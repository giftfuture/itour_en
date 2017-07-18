<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %> 
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
<div data-role="content"  data-fullscreen="true">    
<table  align="center" style="width:100%">
  <tr>
    <td> <%@include file="/frontm/header.jsp"  %></td>
  </tr>
  <tr>
    <td class="STYLE17" style="font-size:1.25em"><div align="center">Memories of happiness will be happy freeze</div></td>
  </tr>
  <tr>
    <td><img src="images/frame1-1.gif" width="100%"/></td>
  </tr>
  <tr>
    <td style="text-align:left;background-image:url('images/frame1-2.gif');background-position:0px 0px;">
        <span>※ travel is the course of the flow<br /></span> 
 <span>※ touched the eternity of the moment<br/></span>
 <span>※ memories of life is a happy landscape</span>
      <span style="float:right;"><a href="${basePath}showhappy/sharehappy">《<strong>Share memories</strong>》</a></span></td>
  </tr>
  <tr><!--  style="vertical-align:top;valign:top;height:7px;text-overflow:ellipsis;overflow:hidden;white-space: nowrap;"  -->
    <td><img src="${basePath }images/frame1-3.gif" width="100%" /></td>
  </tr>
</table>
<table border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="${basePath }images/frame1-1.gif" width="100%" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath }images/frame1-2.gif">

        <div id="fbcontent"></div>
        <ul id='fbpage'></ul>
      </td>
  </tr>
    <tr>
    <td> <%@include file="/frontm/footer.jsp" %> </td>
  </tr>
  <tr>
    <td><img src="${basePath }images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>
</table>
</div>

<script type="text/javascript" src="${basePath}jsm/ux/front/happy/happiness.js"></script>
</body>
</html>

