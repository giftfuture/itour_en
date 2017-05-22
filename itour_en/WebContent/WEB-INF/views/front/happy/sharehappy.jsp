<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %> 
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta name="description" content="四姑娘山海子沟徒步、长坪沟穿越毕棚沟">
<meta name="keywords" content="四姑娘山登山，四姑娘山露營，四姑娘山穿越，四姑娘山徒步">
<script type="text/javascript">
function ww4(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
</script>
</head>
<body>
<%@include file="/front/header.jsp"  %> 
<table border="0" align="center" width="1140" cellpadding="0" cellspacing="0">
  <tr>
    <td class="STYLE17"><div align="center"><span class="STYLE19"></span></div></td>
  </tr>
  <tr>
    <td  style="float:left;text-align:left;margin-left:-500px; padding-left:-500px;"><img style="float:left" src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td  background="images/frame1-2.gif">
    <table width="1140"  border="0" align="center" cellpadding="0" cellspacing="0">
       <tr>
        <td valign="top">		
        <form:form name="sharehappy" method="post" enctype="multipart/form-data" autocomplete="off">
	        <table width="100%" border="0" align="center" cellpadding="10" cellspacing="0">
	         <tr><td  style="text-align:left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="text" class="easyui-textbox" data-options="" name="title" id="title"/></td>
	         <td rowspan=4 style="vertical-align:top; padding-top:10px;">
	            	封面图片：<input type="file" name="surface" id="surface" value="" onchange="change('cover','surface')"  accept="image/jpg,image/jpeg,image/gif,image/png" />
	            	<img id="cover" style="border:none;" border="0px" height="200" width="200" /></td></tr><!-- opacity:0 -->
	         <tr>
	            <td style="text-align:left"><span class="STYLE23">旅行線路：</span>
	            	<input id="route" name="route" class="easyui-combobox"  data-options="width:171,valueField:'routeCode',textField:'title',mode:'remote',panelHeight:'auto',editable:false,method:'POST',url:'${basePath}routeTemplate/loadRoutes'">
	            </td>
	            <td></td>
	       </tr>
	       <tr><td style="text-align:left"><span class="STYLE23">旅行日期：</span><span class="STYLE22"><span class="STYLE148">
	             <input id="tourTime" name="tourTime" class="easyui-datebox" data-options="width:171,editable:false,region:'north',split:true,border:false,required:true,validType:'checkDated'"/></span> 
	           </span></td><td></td></tr>
	        <tr> <td style="text-align:left">&nbsp;&nbsp;回&nbsp;憶&nbsp;人：
            	<span class="STYLE20"><input type="text" class="easyui-textbox" id="signature" name="signature"/>来自
            	<input name="area" id="area" class="easyui-combobox"  data-options="width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'">
            	</span></td><td></td></tr>
	        <tr>
	            <td colspan=2><div id="content"></div></td>
	       </tr>
	       <tr>
	       <td colspan=2 style="text-align:left">验证码： <input type="text" id="verifyCode" name="verifyCode" class=" easyui-textbox" title="验证码" data-options="required:true,nullmsg:'请输入验证码!'"/> 
	           <img alt="点击更换" src="${basePath}RandomCodeServlet" id="validateCode" onclick="changeValidateCode()">
	           &nbsp;&nbsp;<a href="javascript:void(0)" onclick="changeValidateCode()">看不清，换一张</a></td></tr>
	      <tr><td style="text-align:left"><a href="javascript:sharehappy()" class="easyui-linkbutton" name="savehappy" iconcls="icon-save">保存</a></td>
	      <td style="text-align:left"><a href="javascript:void(0);" class="easyui-linkbutton" onclick="${basePath}showhappy/sharehappy" iconcls="icon-cancel">取消</a></td></tr>
	    </table><div id="alertMessage"></div>
    </form:form> 
    </td>
  </tr>
</table>
</td></tr>
 <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr> 
</table>
<script type="text/javascript" src="${basePath}js/ux/front/happy/sharehappy.js"></script>
<%@include file="/front/footer.jsp"  %>  
</body>
</html>

