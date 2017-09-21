<%@ page language="java" import="java.lang.*,java.util.*,com.itour.servlet.Counter" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/";  
	application.setAttribute("basePath", basePath);
    pageContext.setAttribute("basePath", basePath);
    long getTimestamp=new Date().getTime();
%>
<!-- CSS  -->
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/base.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/plug-in/summernote/summernote.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/easytab.css">
<!-- ** Javascript ** -->
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.min.js"></script>  
<script type="text/javascript" src="${basePath}js/commons/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh_TW.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/package.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/easyloader.js"></script>
<script type="text/javascript" src="${basePath}js/commons/urls.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/base.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/__.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/YDataGrid.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-wysiwyg.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote-zh-CN.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote-zh-TW.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.serialize-object.min.js"></script>
<script type="text/javascript">
var basePath = '${basePath}'; 
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},
"share":{},"image":{"viewList":["weixin","tsina","qzone","tqq"],"viewText":"分享到：","viewSize":"16"},
"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["weixin","tsina","qzone","tqq"]}};
with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>
<base href=" <%=basePath%>">
<meta charset="UTF-8">
<meta name="applicable-device" content="pc,mobile">  
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" /> 
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" />
<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta http-equiv="pragma" content="no-cache">  
<META NAME="Generator" CONTENT="EditPlus">
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0">      
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="mobile-agent" content="format=html5; url=<%=basePath%>" />
<meta http-equiv="mobile-agent" content="format=xhtml; url=<%=basePath%>" />
<s:htmlEscape defaultHtmlEscape="true"></s:htmlEscape>
<link rel="SHORTCUT ICON" href="<%=basePath%>images/head2016.gif"> 
