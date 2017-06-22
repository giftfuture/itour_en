<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content=""> 
<title>Climbing travel</title>
</head>
<body>
<table  class="commontb" align="center">
   <tr>
    <td> <%@include file="/front/header.jsp"  %> </td>
  </tr>
  <tr>
    <td><img src="images/img/gonga-04.jpg"/></td>
  </tr>
</table>
<table  class="commontb" align="center">
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="h1-black" style="text-align:left">Hiking on foot</td>
      </tr>
      <tr>
        <td class="h1-2" style="text-align:left">The professional team provides you with logistical support</td>
      </tr>
      <tr>
        <td style="text-align:left"><p>Bring the family, about friends </p>
          <p>Climbed the summit<br />  
           </p>
          <p></p></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
</table>
<table class="commontb" align="center">
 <tbody id="fbcontent">
  </tbody>
</table>
<center><ul id='fbpage'></ul></center>
<script type="text/javascript" src="${basePath}js/ux/front/climb/main.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
