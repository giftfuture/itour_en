<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>Climbing Mountain</title>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
 <meta http-equiv="keywords" content="Climbing the peak, mountain climbing, mountain ridge of danger, mountaineering adventure, mountaineering equipment, the Himalayas, mount Everest, mount Everest">  
 <meta http-equiv="description" content="Climbing the peak, mountain climbing, mountain ridge of danger, mountaineering adventure, mountaineering equipment, the Himalayas, mount Everest, mount Everest"> 
</head>
<body>
<table  class="commontb" align="center" style="width:100%">
   <tr>
    <td> <%@include file="/frontm/header.jsp"  %> </td>
  </tr>
  <tr>
    <td><img  width="100%" src="images/img/gonga-04.jpg"/></td>
  </tr>
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

<!--  <tbody id="fbcontent">
  </tbody> -->

    <tr>
    <td><ul id="fbpage"></ul> </td>
  </tr>
    </table>
  <table class="frametb" align="center">
   <tr>
    <td> <%@include file="/frontm/footer.jsp" %> </td>
  </tr>
</table>
<script type="text/javascript" src="${basePath}jsm/ux/front/climb/main.js"></script>
</body>
</html>
