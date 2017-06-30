<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>seld driving Travel</title>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<meta name="keywords" content="Southwest China Adventures:Trekking & Hiking , Peak Climbing , Off raod¡¡overland, Motercycle tours ">
<meta name="description" content="Southwest China Adventures Trekking,Southwest China Peak Climbing,Southwest China Off raod,Southwest China Motercycle tours">
</head>
<body>

 <table class="commontb" align="center">
 <tr><td> <%@include file="/front/header.jsp"  %></td></tr>
 <tr><td align="center" style="text-align:center;width:100%" width="100%"><img width="100%" src="images/index-ad/banner.jpg"  /></td></tr></table>
<table  class="commontb" align="center" bgcolor="#FFFFFF">
  <!--DWLayoutTable-->
  <tr>
    <td width="10" background="images/shadowleft.gif"><img src="images/shadowleft.gif" width="10" height="8" /></td>
    <td valign="top" class="title"><table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
    </table></td>
    <td width="10" background="images/shadowright.gif"><img src="images/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
<table class="commontb" align="center">
 <tbody id="fbcontent">
  </tbody>
</table>
<center><ul id='fbpage'></ul></center>
<script type="text/javascript" src="${basePath}js/ux/front/selfdrive/main.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
