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
<title>Hiking Travel</title>
</head>
<body>
<table class="commontb" align="center">
   <tr>
    <td> <%@include file="/front/header.jsp"  %> </td>
  </tr>
  <tr>
    <td align="center" style="text-align:center;width:100%" width="100%"><img width="100%" src="images/banner-trekking.jpg"  /></td>
  </tr>
</table>
<table class="commontb" align="center">
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
<table class="commontb" align="center">
<tbody id="fbcontent">
<%-- <c:forEach begin="0" end="${rows}" varStatus="status">
  <tr>
    <c:forEach items="${rts.get(status.index)}" var="rt" >
    <td valign="top">
    <table width="353" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="300" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td width="296" class="h2-24"><a href="${basePath}hiking/hiking/${rt.alias}">${rt.title}</a></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td><a href="${basePath }hiking/hiking/${rt.alias}"><img src="${basePath }${rt.cover}" width="353" height="166" ></a></td>
      </tr>
      <tr>
        <td class="f12-gao1" style="text-align:left">${rt.shortContent}</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    </c:forEach>
  </tr></c:forEach> --%>
  </tbody>
</table>
  <center><ul id="fbpage"></ul></center>
<script type="text/javascript" src="${basePath}js/ux/front/trek/trekkings.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
