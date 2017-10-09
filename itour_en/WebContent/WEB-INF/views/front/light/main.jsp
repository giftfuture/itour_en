<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>Light Travel</title>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<meta http-equiv="keywords" content="Light travel">  
<meta http-equiv="description" content="Do not have to wait luggage, no money a light, want to go away, want to stay to stay, more try fresh opportunities, it is an environmentally friendly concept, more open, more free, more economical"> 
</head>
<body>
 <%@include file="/front/header.jsp"  %>
 <center>
 <div style="z-index:-1; position:relative;">
<table class="commontb" align="center">
  <tr>
    <td align="center" style="text-align:center;width:100%" width="100%" class="banner">
    <img width="100%" src="images/img/girl-03.jpeg"/></td>
  </tr>
</table>
</div>
<div style="position:relative;margin-top:-60;z-index:9999;width:1140">
<table class="frametb" align="center">
  <tr style="width:100%;text-align:center" align="center" width="100%" >
            <td width="100%" style="width:100%"></td>
        </tr>
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="h1-black" style="text-align:left">Light Travel</td>
      </tr>
      <tr>
        <td class="h1-2" style="text-align:left">The professional team provides you with logistical support</td>
      </tr>
      <tr>
        <td style="text-align:left"><p>Bring the family, about friends </p>
          <p>Know More about Light Travel<br />  
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
</div>
<table class="frametb" align="center">
 <tbody id="fbcontent">
  </tbody>
    <tr>
    <td width="100%" colspan=3><ul id="fbpage"></ul> </td>
  </tr>
    </table>
  <table class="frametb" align="center">
   <tr>
    <td width="100%"  ><%@include file="/front/footer.jsp" %></td>
  </tr>
</table>
</center>
<script type="text/javascript" src="${basePath}js/ux/front/light/main.js"></script>
</body>
</html>
