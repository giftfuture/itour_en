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
<title>HotSport Travel</title>
</head>
<body>
<%@include file="/front/header.jsp"  %>
<table  class="commontb" align="center">
   <tr>
    <td>  </td>
  </tr>
  <tr>
    <td align="center" style="text-align:center;width:100%" width="100%">
    <img width="100%" src="images/banner.jpg"  height="598px" /></td>
  </tr>
</table>
<table class="frametb" align="center">
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="h1-black" style="text-align:left">HotSport Travel</td>
      </tr>
      <tr>
        <td class="h1-2" style="text-align:left">The professional team provides you with logistical support</td>
      </tr>
      <tr>
        <td style="text-align:left"><p>Bring the family, about friends </p>
          <p>Climbed the summit<br />  
              <br />
            》》<a href="${basePath }hotsight/main">Know more</a></p>
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
<table  class="frametb" align="center">
 <tbody id="fbcontent">
  </tbody>
    <tr>
    <td width="100%"  ><ul id="fbpage"></ul> </td>
  </tr>
    </table>
  <table class="frametb" align="center">
   <tr>
    <td width="100%"  ><%@include file="/front/footer.jsp" %></td>
  </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/hotsight/main.js"></script>
</body>
</html>
