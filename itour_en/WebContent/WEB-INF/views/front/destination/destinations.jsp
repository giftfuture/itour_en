<%@ page language="java" import="java.lang.*,java.util.Date" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %> 
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<link rel="stylesheet" type="text/css" href="${basePath}css/easing.css">
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.easing.compatibility.js"></script> 
<title>目的地</title>
</head>
<body>
<table class="commontb" align="center">
<tr>
    <td>
		 <%@include file="/front/header.jsp"  %>
    </td>
  </tr>
</table>
<!-- <table width="100%"  border="0" align="center" cellpadding="15" cellspacing="0">
  <tr>
    <td>目的地》四川》四姑娘山》四姑娘山长坪沟</td>
  </tr>
</table> -->
<br />
<table class="commontb" align="center">
  <tr>
    <td width="197" valign="top">
      <table width="197" border="0" cellspacing="0" cellpadding="5">
          <tr>
            <td height="30" bgcolor="#990000"><div style="align:center;font-size:18px;background-color:#8B0000;text-decoration:none;color:white" width="197px" >旅遊目的地</div></td>
          </tr>
          <tr>
  			<td><div class="treebox">
				<ul class="menu">
				<c:forEach items="${scopes}" var="scope" varStatus="status">
					<li class="level1">
						<a href="javascript:void(0)"><%-- <em class="ico ico${status.index + 1}"></em> --%>
						<!-- <img src="images/arrow4-1.gif" width="10" height="10"> -->
						<c:out value="${scope.value}"></c:out><i class="down"></i></a>
						<ul class="level2" style="float:middle">
							<c:forEach items="${items}" var="item">
								<c:if test="${scope.key==item.scope }">
									<li style="float:middle"><a href="${basePath }destination/detail/${item.alias}"><c:out value="${item.item}"></c:out></a></li>		
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
        <td rowspan=2>
       		<c:forEach var="sortitem" items="${sortedItems}" varStatus="">
	        <table border="0" align="center" cellpadding="10" cellspacing="0" style="width:1140px" width="1140px">
		      <tbody><tr bgcolor="#f0f0f0" style="width:1140px" width="1140px">
		        <td colspan=2 width="60%" style="text-align:left;float:left;width:648;"><span class="STYLE5"><c:out value="${fn:split(sortitem.key, '_')[1]}"></c:out></span></td>
		        <td width="40%" style="text-align:right;float:right;width:432;"><div align="right"><c:out value="${tiSizes[sortitem.key]}"></c:out>个目的地
		        <c:if test="${fn:length(sortitem.value)>= maxd}">
		         | <a href="${basePath}destination/moredests/${fn:split(sortitem.key, '_')[0]}">显示更多</a>
		         </c:if>
		        </div></td>
		      </tr>
		      <tr>
			     <c:forEach items="${sortitem.value}" var="ti">
			      	<td style="text-align:left;align:left">
			      		<a href="${basePath }destination/detail/${ti.alias}">${ti.item}<br/><img width="200px" height="200px" alt="" src="${basePath }${ti.cover}"/></a>
			      	</td>
		         </c:forEach>
		      </tr>
		    </tbody></table>
	      <!--   <table border="0" align="left" cellpadding="5" cellspacing="0">
		    </table> -->
		  </c:forEach>
        </td>
        </tr>

</table>
<script type="text/javascript" src="${basePath}js/ux/front/destination/destinations.js"></script>
 <%@include file="/front/footer.jsp"  %>  
</body>
</html>
