<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
 <script type="text/javascript" src="<%=basePath%>js/ux/sys/showOrders.js"></script>
 <script type="text/javascript">
function ww4(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
</script>
  </head>
  <body>
  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="10%"><span class="h2-24"><img src="images/detail.png" width="32" height="32" /></span></td>
    <td width="90%"><span class="h2-24"><span class="style148">已出订单</span></span></td>
  </tr>
</table>
<form:form method="post" id="back_form" action="${basePath }customers/list">
<a style="padding-left:20px;margin-left:20px;" onsubmit="" onclick="document:back_form.submit();" class="easyui-linkbutton" iconcls="icon-back" >返回</a>
</form:form>
<table style="text-align:left" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
      <td valign="top">		
        <table  border="0" align="center" cellpadding="10" cellspacing="0" name="">
        <tbody>
	         <tr><td><span class="STYLE23">下单人：${customers.customerName}</span>&nbsp;&nbsp;来自：${customers.areaname}&nbsp;&nbsp; 邮箱：${customers.email }&nbsp;&nbsp;电话：${customers.telephone }</td></tr>
	     <c:choose>
	     <c:when test="${success&&vos !=null &&fn:length(vos)>0 }">
		     <c:forEach items="${vos }" var="item" varStatus="idx">
		     <tr><td style="text-align:left;float:left">${idx.index+1 }.<a target="_blank" href="${basePath }${item.orderUrl}">${item.orderName }</a></td></tr>
		     </c:forEach>
	     </c:when>
	     <c:otherwise>
	     	<c:out value="${msg }"></c:out>
	     </c:otherwise>
	     </c:choose>
	      </tbody>  
	    </table>
    </td>
  </tr>
</table>
  </body>
</html>
