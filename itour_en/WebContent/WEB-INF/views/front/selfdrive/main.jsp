<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>自驾</title>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<meta name="keywords" content="Southwest China Adventures:Trekking & Hiking , Peak Climbing , Off raod¡¡overland, Motercycle tours ">
<meta name="description" content="Southwest China Adventures Trekking,Southwest China Peak Climbing,Southwest China Off raod,Southwest China Motercycle tours">
<!-- <script type="text/javascript" src="Scripts/flashobject.js"></script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="css/qzx.css" rel="stylesheet" type="text/css" />
<link href="css/bodylink.css" rel="stylesheet" type="text/css" /> -->
</head>
<body>
 <%@include file="/front/header.jsp"  %>
 <table class="commontb" align="center"><tr><td><img src="images/index-ad/banner.jpg"  /></td></tr></table>
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
<%-- <c:forEach begin="0" end="${rows}" varStatus="status">
  <tr>
    <c:forEach items="${rts.get(status.index)}" var="rt" >
    <td valign="top">
    <table width="353" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="300" border="0" align="left" cellpadding="0" cellspacing="0">
            <tr>
              <td width="296" class="h2-24"><a href="${basePath}selfdrive/selfdrive/${rt.alias}">${rt.title}</a></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td><a href="${basePath }selfdrive/selfdrive/${rt.alias}"><img src="${basePath }${rt.cover}" width="353" height="166" ></a></td>
      </tr>
      <tr>
        <td class="f12-gao1">${rt.shortContent}</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    </c:forEach>
  </tr></c:forEach> --%>
  </tbody>
</table>
<center><ul id='fbpage'></ul></center>
<script type="text/javascript" src="${basePath}js/ux/front/selfdrive/main.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
