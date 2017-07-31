<%@ page language="java" import="java.lang.*,java.util.Date" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %> 
<!DOCTYPE html>
<html lang="en-US">
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<link rel="stylesheet" type="text/css" href="${basePath}css/easing.css">
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.easing.compatibility.js"></script> 
<title>Destination</title>
</head>
<body>
 <%@include file="/front/header.jsp" %>
<center>
<table class="frametb" align="center" style="text-align:center;">
  <tr>
     <td width="197" valign="top">
      <table width="197" border="0" cellspacing="0" cellpadding="5"float:right;>
          <tr>
            <td height="30" valign="top" style="width:200px;height:auto" bgcolor="#990000"><!-- padding-left:150 -->
            <div style="align:center;font-size:18px;background-color:#8B0000;text-decoration:none;color:white;">Destinations</div>
            <div class="treebox" >
                <ul class="menu">
                <c:forEach items="${scopes}" var="scope" varStatus="status">
                    <li style="width:100%" class="level1">
                        <a style="width:100%" href="javascript:void(0)"><%-- <em class="ico ico${status.index + 1}"></em> --%>
                        <!-- <img src="images/arrow4-1.gif" width="10" height="10"> -->
                        <c:out value="${scope.value}"></c:out><i class="down"></i></a>
                        <ul class="level2" style="float:middle;width:100%">
                            <c:forEach items="${items}" var="item">
                                <c:if test="${scope.key==item.scope }">
                                    <li style="float:middle;width:100%"><a style="float:left" href="${basePath }destination-detail-${item.alias}"><c:out value="${item.item}"></c:out></a></li>       
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
                </ul>
            </div>
            </td>
          </tr>
        </table>
        </td>
        <td  border="0" align="center" cellpadding="0" cellspacing="0"  style="padding-left:0;margin-left:0;width:80%;" >
            <c:forEach var="sortitem" items="${sortedItems}" varStatus="">
            <table border="0" align="center" cellpadding="10" cellspacing="0" style="padding-left:10;margin-left:10;width:100%;">
              <tbody><tr bgcolor="#f0f0f0" width="100%">
                <td colspan=3 width="100%"><span class="STYLE5" style="text-align:left;float:left;"><c:out value="${fn:split(sortitem.key, '_')[1]}"></c:out></span>
                <span style="text-align:right;float:right;"><div align="right">
                <c:choose>
                <c:when test="${tiSizes[sortitem.key]==1}"> <c:out value="${tiSizes[sortitem.key]}"></c:out>destination</c:when>
                <c:otherwise><c:out value="${tiSizes[sortitem.key]}"></c:out>destinations</c:otherwise>
                </c:choose>
                <c:if test="${fn:length(sortitem.value)>= maxd}">
                 | <a href="${basePath}destination-moredests-${fn:split(sortitem.key, '_')[0]}">Show more</a>
                 </c:if>
                </div></span></td>
              </tr>
               <tr width="100%">
                  <c:forEach items="${sortitem.value}" var="ti" varStatus="ix">
                    <td style="text-align:left;align:left;width:33%;float:left;" width="33%">
                         <c:if test="${not empty ti.alias  && not empty ti.item  && not empty ti.cover}">
                              <a href="${basePath }destination-detail-${ti.alias}">${ti.item}<br/>
                                <img width="100%" style="float:left;margin:3px;padding:3px;"  alt="" src="${basePath }${ti.cover}"/>
                              </a>
                           </c:if>
                     </td>
                 </c:forEach>
              </tr>
            </tbody></table>
          </c:forEach>
        </td>
        </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/destination/destinations.js"></script>
 <%@include file="/front/footer.jsp"  %>  
 </center>
</body>
</html>
