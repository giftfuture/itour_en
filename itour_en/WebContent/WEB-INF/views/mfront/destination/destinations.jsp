<%@ page language="java" import="java.lang.*,java.util.Date" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %> 
<!DOCTYPE html>
<html lang="en-US">
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<link rel="stylesheet" type="text/css" href="${basePath}cssm/easing.css">
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.easing.compatibility.js"></script> 
<title>Destination</title>
</head>
<body>
<center>
<table class="frametb" align="center" style="text-align:center;width:100%">
  <tr width="100%"><td><%@include file="/frontm/header.jsp"  %></td></tr>  
  <tr width="100%">
    <td valign="top">
      <table><tr><td width="20%" style="width:20%;vertical-align:top;" >
       <table valign="top" width="100%" border="0" cellspacing="0"  style="float:left;" >
          <tr>
            <td height="30" valign="top" style="width:20%;height:auto;" bgcolor="#990000"><!-- <span style="font-size:0.75em">Destinations</span> -->
            <div valign="top" style="align:center;font-size:1.125em;width:20%;background-color:#8B0000;text-decoration:none;color:white;">
            <div valign="top" class="treebox" style="float:left">
                <ul class="menu">
                <label style="float:middle;text-align:center;align:center;font-size:0.7rem;background-color:#8B0000;text-decoration:none;color:white;vertical-align:top;">Destinations</label>
                <c:forEach items="${scopes}" var="scope" varStatus="status">
                    <li style="width:100%" class="level1">
                        <a style="width:100%"  href="javascript:void(0)"><%-- <em class="ico ico${status.index + 1}"></em> --%>
                        <!-- <img src="images/arrow4-1.gif" width="10" height="10"> -->
                        <i class="down"></i><c:out value="${scope.value}"></c:out></a>
                        <ul class="level2" style="width:100%;float:left;margin:0px;padding:0px;margin:0px;padding:0px;">
                            <c:forEach items="${items}" var="item">
                                <c:if test="${scope.key==item.scope }">
                                    <li style="float:left;width:100%;margin:0px;padding:0px;"><a  style="float:left;width:100%;margin:0px;padding:0px;" href="${basePath }destination/detail/${item.alias}"><c:out value="${item.item}"></c:out></a></li>     
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
                </ul>
            </div></div>
            </td>    
        </tr>
        </table>
      </td><td align="center" width="80%" style=" width:80%;">

            <c:forEach var="sortitem" items="${sortedItems}" varStatus="">
            <table border="0" align="center" cellpadding="0" cellspacing="0" style="width:100%;">
              <tbody><tr bgcolor="#f0f0f0" width="100%">
                <td colspan=3 width="100%">
        <span class="STYLE5" style="text-align:left;float:left;font-size:1.25em;"><c:out value="${fn:split(sortitem.key, '_')[1]}"></c:out></span>
                <span style="text-align:right;float:right;"><div align="right">
                <c:choose>
                <c:when test="${tiSizes[sortitem.key]==1}"> <c:out value="${tiSizes[sortitem.key]}"></c:out>destination</c:when>
                <c:otherwise><c:out value="${tiSizes[sortitem.key]}"></c:out>destinations</c:otherwise>
                </c:choose>
                <c:if test="${tiSizes[sortitem.key]>= maxd}">
                 | <a href="${basePath}destination/moredests/${fn:split(sortitem.key, '_')[0]}">Show more</a>
                 </c:if>
                </div></span></td>
              </tr>
               <tr width="100%">
                  <c:forEach items="${sortitem.value}" var="ti" varStatus="ix">
                    <td style="text-align:left;align:left;width:33%;float:left;" width="33%">
                         <c:if test="${not empty ti.alias  && not empty ti.item  && not empty ti.cover}">
                              <a href="${basePath }destination/detail/${ti.alias}">${ti.item}<br/>
                                <img width="100%" style="float:left;margin:3px;padding:3px;"  alt="" src="${basePath }${ti.cover}"/>
                              </a>
                           </c:if>
                     </td>
                 </c:forEach>
              </tr>
            </tbody></table>
          </c:forEach>
        </td></tr></table>  
        </tr>
<tr><td><%@include file="/frontm/footer.jsp"  %>  </td></tr>
</table>
<script type="text/javascript" src="${basePath}jsm/ux/front/destination/destinations.js"></script>
 </center>
</body>
</html>
