<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
 <base href="<%=basePath%>">
 <meta http-equiv="pragma" content="no-cache">  
 <meta http-equiv="cache-control" content="no-cache">  
 <meta http-equiv="expires" content="0">      
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">:</label><input name="detailCode" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">:</label><input name="logCode" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">:</label><input name="columnName" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">日志设置详情</div>
					<div class="fitem">
						<label></label>
						<input name="detailCode" type="text" maxlength="32" class="easyui-validatebox" data-options="required:true" missingMessage="请填写detailCode">
					</div>
					<div class="fitem">
						<label></label>
						<input name="logCode" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写logCode">
					</div>
					<div class="fitem">
						<label></label>
						<input name="columnName" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写columnName">
					</div>
					<div class="fitem">
						<label></label>
						<input name="columnText" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写columnText">
					</div>
					<div class="fitem">
						<label></label>
						<input name="columnDatatype" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写columnDatatype">
					</div>
					<div class="fitem">
						<label></label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
					<div class="fitem">
						<label></label>
						<input name="creator" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写creator">
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/logSettingDetail.js"></script>
  </body>
</html>
