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
 <meta http-equiv="keywords" content="show happyiness ,memories of happyiness">  
 <meta http-equiv="description" content="show happyiness ,memories of happyiness"> 
<title>Memories of Happiness</title>
</head>
<body>
<%@include file="/front/header.jsp"  %>
<table class="commontb" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td> </td>
  </tr>
  <tr>
    <td class="STYLE17"><div align="center">Memories of happiness will be happy freeze</div></td>
  </tr>
  <tr>
    <td><img src="images/frame1-1.gif" width="1140"/></td>
  </tr>
  <tr>
    <td style="text-align:left;padding-left:170px;margin-left:170px;background-image:url('images/frame1-2.gif');background-position:105px 0px;">
	    <span>※ travel is the course of the flow<br /></span> 
 <span>※ touched the eternity of the moment<br/></span>
 <span>※ memories of life is a happy landscape</span>
      <span style="float:right;padding-right:120px"><a href="${basePath}showhappy-sharehappy">《<strong>Share memories</strong>》</a></span></td>
  </tr>
  <tr><!--  style="vertical-align:top;valign:top;height:7px;text-overflow:ellipsis;overflow:hidden;white-space: nowrap;"  -->
    <td><img src="${basePath }images/frame1-3.gif" width="1140" /></td>
  </tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="${basePath }images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath }images/frame1-2.gif">
  		<div id="fbcontent"></div>
	    <ul id='fbpage'></ul>
      </td>
  </tr>
  <tr>
    <td><img src="${basePath }images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>
  <tr><td><%@include file="/front/footer.jsp"  %>  </td></tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/happy/happiness.js"></script>

</body>
</html>

