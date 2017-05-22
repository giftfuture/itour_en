<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">日志码:</label><input name="logCode" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">表名:</label><input name="tableName" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">功能:</label><input name="function" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
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
		     	   <div class="ftitle">日志设置</div>
					<div class="fitem">
						<label></label>
						<input name="logCode" type="text" maxlength="32" class="easyui-validatebox" data-options="required:true" missingMessage="请填写logCode">
					</div>
					<div class="fitem">
						<label></label>
						<input name="tableName" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写tableName">
					</div>
					<div class="fitem">
						<label></label>
						<input name="function" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写function">
					</div>
					<div class="fitem">
						<label></label>
						<input name="urlTeimplate" type="text" maxlength="256" class="easyui-validatebox" data-options="" missingMessage="请填写urlTeimplate">
					</div>
					<div class="fitem">
						<label></label>
						<input name="creater" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写creater">
					</div>
					<div class="fitem">
						<label></label>
						<input name="deletescriptTemplate" type="text" maxlength="512" class="easyui-validatebox" data-options="" missingMessage="请填写deletescriptTemplate">
					</div>
					<div class="fitem">
						<label></label>
						<input name="updatescriptTemplate" type="text" maxlength="512" class="easyui-validatebox" data-options="" missingMessage="请填写updatescriptTemplate">
					</div>
					<div class="fitem">
						<label></label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/logSetting.js"></script>
  </body>
</html>
