<%@ page language="java" import="java.lang.*,java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
    application.setAttribute("basePath", basePath);
    pageContext.setAttribute("basePath", basePath);
    int count=1;  														
    application.setAttribute("count",count); 
    String homePage = "http://localhost:8080/itour";  //"http://zjj.itours.com.cn/";
    long getTimestamp=new Date().getTime();
%>
<script type="text/javascript">
var tougao="mrr";
var lmname="JavaScript";
var ourl="";
var basePath = '${basePath}'; 
</script>
<base href=" <%=basePath%>">
<!-- 公共资源CSS,JS  -->
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/base.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap/bootstrap.min.css">
<!-- ** Javascript ** -->
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.min.js"></script> 
<!-- <script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script> -->
<script type="text/javascript" src="${basePath}js/commons/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh_TW.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/package.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${basePath}js/commons/urls.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/base.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/__.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/YDataGrid.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-wysiwyg.js"></script>
<meta charset="UTF-8">
<meta name="applicable-device" content="pc">
<meta name="viewport" content="width=device-width,initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" />
<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0">      
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="mobile-agent" content="format=html5; url=<%=homePage%>" />
<meta http-equiv="mobile-agent" content="format=xhtml; url=<%=homePage%>" />
<link rel="SHORTCUT ICON" href="<%=basePath%>images/head2016.gif"> 
<link rel="stylesheet" href="${basePath}css/index.css" />  
 <!-- <meta http-equiv="Refresh" content="0; URL=/"> -->
<title>欢迎访问主角旅行</title>
 <link href="css/index.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
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
    <td><%@include file="/front/header.jsp" %></td>
  </tr>
 <%-- <tr>
    <td><img id="banner-index"  src="${basePath }images/Route001.jpg"/></td>
  </tr> --%>  
<tr><td style="padding-top:70px;margin-top:70px">
<!--此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
<script type="text/javascript">
if($.browser.msie){ 
	document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1350" height="598" style="margin-top: -10px;margin-left: -8px;" id="FLVPlayer1">'+
			'<param name="movie" value="FLVPlayer_Progressive.swf" />'+
			'<param name="quality" value="high" />'+
			'<param name="wmode" value="opaque" />'+
			'<param name="scale" value="noscale" />'+
			'<param name="salign" value="lt" />'+
			'<param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=public/swf/Clear_Skin_3&amp;streamName=${videopath}.mp4&amp;autoPlay=true&amp;autoRewind=true" />'+
			'<param name="swfversion" value="8,0,0,0" />'+
			'<param name="expressinstall" value="expressInstall.swf" />'+
			'</object>');
	}else{
		 document.write('<div align="center" width="1350" height="598">'+
		'<video width="1350" height="598" webkit-playsinline="true" autoplay="autoplay" controls="controls">'+
		'<source src="${videopath}.mp4" type="video/mp4"></source>'+
		'your browser does not support the video tag'+
		'</video></div>'); 
		//document.write('<iframe height=600 width=330 src="http://player.youku.com/embed/XNTcyMzIwMTE2" frameborder=0 allowfullscreen></iframe>');
		//document.write('<iframe height=600 width=330 src="http://player.youku.com/player.php/Type/Folder/Fid/22127316/Ob/1/sid/XNjk1MDUyNzU2/v.swf" frameborder=0 allowfullscreen></iframe>');
	/* 	document.write('<div align="center" width="100%" height="50%">'+
		'<embed src="http://player.youku.com/player.php/Type/Folder/Fid/22127316/Ob/1/sid/XNjk1MDUyNzU2/v.swf" '+
		'quality="high" width="1000px" height="500px" align="center" allowScriptAccess="always" allowFullScreen="true" mode="transparent" type="application/x-shockwave-flash"></embed></div>'); */
	}
</script>  
<!-- 
<embed src="http://static.youku.com/v1.0.0149/v/swf/qplayer_rtmp.swf?VideoIDS=XNTg2ODcxMTM2ID&winType=adshow&isAutoPlay=true" quality="high" width="290" height="220" align="middle" title="嘉兴中安商贸园宣传片" wmode="transparent" allowScriptAccess="never" allowNetworking="internal" autostart="1" type="application/x-shockwave-flash"></embed> -->
<!-- 视频常见几种比例：384×256、580×435、610×460 -->
<%--   <video width="602px" height="345px" controls="controls">
<source src="${basePath }video/praise.mp4" type="video/mp4"></source>
your browser does not support the video tag
</video> --%>
</td></tr>
</table>
<%@include file="/front/footer.jsp" %>
</body>
</html>
