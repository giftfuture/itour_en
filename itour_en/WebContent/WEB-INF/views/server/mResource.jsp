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
    /* Counter counthandler=new Counter();//创建对象  
    int count=1;  														
    application.setAttribute("count",count);  */
   // String homePage = "http://localhost:8080/itour";  //"http://zjj.itours.com.cn/";
  /*   if(application.getAttribute("count")==null|| count == 0){  
	    count=counthandler.readCount();//读取文件获取数据赋给count  
	    application.setAttribute("count",count);  
  	}  
 	  //count=(Integer)application.getAttribute("count");  
	  if(session.isNew()){ 
		  application.setAttribute("count", ++count);  
		  counthandler.writeCount(count+"");//更新文件记录  
	  } */
	  //System.out.println("count="+count);
%>
<!-- 公共资源CSS,JS  -->
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.5.1/themes/mobile.css">
<link rel="stylesheet" type="text/css" href="${basePath}cssm/base.css">
<link rel="stylesheet" type="text/css" href="${basePath}css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/plug-in/summernote/summernote.css">
<link rel="stylesheet" type="text/css" href="${basePath}cssm/easytab.css">
<!-- ** Javascript ** -->
<%-- <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> --%>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.min.js"></script>  
<!-- <script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script> -->
<script type="text/javascript" src="${basePath}js/commons/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh_TW.min.js"></script>
<script type="text/javascript" src="${basePath}js/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="${basePath}js/commons/package.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.easyui.mobile.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/easyloader.js"></script>
<script type="text/javascript" src="${basePath}js/commons/urls.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/base.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/__.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/commons/YDataGrid.js?v=<%=getTimestamp%>"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-wysiwyg.js"></script>
<%-- <script type="text/javascript" src="${basePath}js/plug-in/AngularJS/angular.min.js"></script> --%>
<%-- <script type="text/javascript" src="${basePath}js/plug-in/ckeditor/ckeditor.js"></script> --%>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote-zh-CN.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/summernote/summernote-zh-TW.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.serialize-object.min.js"></script>
<script type="text/javascript">
var tougao="mrr";
var lmname="JavaScript";
var ourl="";
/* (function(){
	var reWriteUrl=function(url){
	if(url){
		var Splits=url.split("/"),
		siteName=window.location.pathname;
		if(typeof siteName!=="undefined"){
			return "http://zjj.itours.com.cn/"+siteName
			}
		}
	};
	if(/Android|webOS|iPhone|iPad|Windows Phone|iPod|BlackBerry|SymbianOS|Nokia|Mobile/i.test(navigator.userAgent)){
		var url=window.location.href;
		var pathname=window.location.pathname;
		if(url.indexOf("?pc")<0){
			try{
				window.location.href=reWriteUrl(url)
				}catch(e){
					
				}
				}
		}
	})();*/
var basePath = '${basePath}'; 
</script>
<base href=" <%=basePath%>">
<meta charset="UTF-8">
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
<link rel="SHORTCUT ICON" href="<%=basePath%>images/head2016.gif"> 
<%-- <p>我们的友谊海枯石不烂！ 您是第 <%=application.getAttribute("count") %> 位访客</p>   --%>
