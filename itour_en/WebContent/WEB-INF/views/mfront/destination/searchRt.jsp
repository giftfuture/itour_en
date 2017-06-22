<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <!-- <meta http-equiv="Refresh" content="0; URL=/"> -->
<title>Welcome to iTour travel</title>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
 <link href="${basePath }cssm/index.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
/*  $(document.forms["searchForm"]).form('load','${context}'); */

 jQuery.browser={};
 (function(){
     jQuery.browser.msie=false; 
     jQuery.browser.version=0;
     if(navigator.userAgent.match(/MSIE ([0-9]+)./)){
         jQuery.browser.msie=true;
         jQuery.browser.version=RegExp.$1;
     }})();
 </script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><%@include file="/frontm/header.jsp" %></td>
  </tr>
</table>


<input type="hidden" name="alias" value="${alias }" />
<input type="hidden" name="pageNo" value="${pageNo }"   />
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="67%" valign="top">
    <table border="0" align="center" cellpadding="15" cellspacing="0" name="searchRtstb">
    <tbody id="fbcontent"></tbody>
    </table></td>
  </tr>
    <tr><td><ul id='fbpage'></ul></td></tr>
  <tr><td><%@include file="/frontm/footer.jsp" %></td></tr>
</table>

<script type="text/javascript" src="${basePath}jsm/ux/front/destination/searchRt.js"></script>
</body>
</html>
