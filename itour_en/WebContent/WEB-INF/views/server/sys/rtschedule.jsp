<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
 <script type="text/javascript" src="<%=basePath%>js/ux/sys/rtschedule.js"></script>
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
  <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="10%"><span class="h2-24"><img src="images/detail.png" width="32" height="32" /></span></td>
    <td width="90%"><span class="h2-24"><span class="style148">详细日程</span></span></td>
  </tr>
</table>
<form:form method="post" id="back_form" action="${basePath }routeTemplate/list">
<!-- <input type="submit" class="easyui-linkbutton" iconcls="icon-back" value="返回"> -->
<a style="padding-left:20px;margin-left:20px;" onsubmit="" onclick="document:back_form.submit();" class="easyui-linkbutton" iconcls="icon-back" >返回</a>
</form:form>
<table width="100%" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
      <td valign="top">		
      <form:form name="rtscheduleForm" method="post" enctype="multipart/form-data" autocomplete="off">
        <table width="100%" border="0" align="center" cellpadding="10" cellspacing="0" name="rtscheduleTable">
        <tbody>
	         <tr><td><span class="STYLE23">旅行線路：${bean.title }</span><input type="hidden" id="id" name="id" value="${bean.id }" /></td></tr>
	      </tbody>  
	      <tbody id="editquotoFormtbody"><tr>
	            <td colspan=2><div id="editquotoForm">${bean.quotoForm }</div></td>
	       </tr></tbody> 
	        <tbody id="quotoFormtbody"><tr>
	            <td colspan=2><div id="quotoForm">${bean.quotoForm }</div></td>
	       </tr>
	       </tbody>
	       <tbody id="edittbody">
	        <tr>
	            <td></td><td><a name="edit" id="eddit" class="easyui-linkbutton"  iconcls="icon-edit">编辑</a></td><!-- href="javascript:itour.rtschedule.togglequotoForm()" -->
	       </tr>
	       </tbody>
          <tbody id="submittbody" style="display:none">
	      <tr><td colspan=2>验证码： <input type="text" id="verifyCode" name="verifyCode" class=" easyui-validatebox" title="验证码" data-options="required:true" nullmsg="请输入验证码!"/>
	           <img alt="点击更换" src="${basePath}RandomCodeServlet" id="validateCode" onclick="itour.rtschedule.changeValidateCode()">
	           &nbsp;&nbsp;<a href="javascript:itour.rtschedule.changeValidateCode()" >看不清，换一张</a></td></tr>
	      <tr><td><a class="easyui-linkbutton" iconcls="icon-save" name="savequotoForm">保存</a></td><!-- href="itour.rtschedule.savequotoForm"  -->
	      <td><a href="javascript:void(0);" class="easyui-linkbutton" name="cancelquotoForm" onclick="" iconcls="icon-cancel">取消</a></td></tr>
	     </tbody>
	    </table>
	    <div id="alertMessage"></div>
    </form:form> 
    </td>
  </tr>
</table>
  </body>
</html>
