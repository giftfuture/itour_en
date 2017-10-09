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
 <meta http-equiv="keywords" content="On foot, exercise, outdoors, hiking, poor travel, trekking in China, hiking starting from here">  
 <meta http-equiv="description" content="Outdoor sports, deep travel, photography, travel with the group, wild camping, hiking knowledge, skills, lines, Raiders, travel, we respect the freedom of travel, with the feet of the world"> 
<title>Hiking Travel</title>
</head>
<body>
 <%@include file="/front/header.jsp"  %>
<table class="commontb" align="center">
   <tr>
    <td> </td>
  </tr>
  <tr>
    <td align="center" style="text-align:center;width:100%" width="100%" class="banner">
    <img width="100%" src="images/banner-trekking.jpg" /></td>
  </tr>
</table>
<table class="frametb" align="center">
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td class="h1-black" style="text-align:left">Hiking on foot</td>
      </tr>
      <tr>
        <td class="h1-2" style="text-align:left">The professional team provides you with logistical support</td>
      </tr>
      <tr>
        <td style="text-align:left"><p>Bring the family, about friends </p>
          <p>Climbed the summit
         <%--    》》<a href="${basePath}hiking/main">了解更多</a> --%></p>
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
<table class="frametb" align="center">
<tbody id="fbcontent" width="100%" style="width:100%">
  </tbody>
   <tr>
    <td width="100%"  style="width:100%" colspan=3><ul id="fbpage"></ul> </td>
  </tr>
  </table>
  <table class="frametb" align="center">
   <tr width="100%" >
    <td style="width:100%" width="100%"><%@include file="/front/footer.jsp" %></td>
  </tr>
</table>
 
<script type="text/javascript" src="${basePath}js/ux/front/trek/trekkings.js"></script>

</body>
</html>
