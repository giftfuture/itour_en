<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
	 <title>操作日志</title>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 100px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">操作码:</label><input name="operCode" class="easyui-textbox"  data-options="width:120">&nbsp;&nbsp;
			<label class="ui-label">日志码:</label><input name="logCode" class="easyui-textbox"  data-options="width:120">&nbsp;&nbsp;
			<label class="ui-label">操作类型:</label><input name="operationType" class="easyui-textbox"  data-options="width:120">
	    </p>&nbsp;&nbsp;
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search" style="margin-top:10">查询</a>
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
		     	   <div class="ftitle">操作日志</div>
					<div class="fitem">
						<label></label>
						<input name="operCode" type="text" maxlength="32" class="easyui-textbox" data-options="required:true" missingMessage="请填写operCode">
					</div>
					<div class="fitem">
						<label></label>
						<input name="logCode" type="text" maxlength="32" class="easyui-textbox" data-options="" missingMessage="请填写logCode">
					</div>
					<div class="fitem">
						<label></label>
						<input name="operationType" type="text" maxlength="64" class="easyui-textbox" data-options="" missingMessage="请填写operationType">
					</div>
					<div class="fitem">
						<label></label>
						<input name="primaryKeyvalue" type="text" maxlength="64" class="easyui-textbox" data-options="" missingMessage="请填写primaryKeyvalue">
					</div>
					<div class="fitem">
						<label></label>
						<input name="content" type="text" maxlength="512" class="easyui-textbox" data-options="" missingMessage="请填写content">
					</div>
					<div class="fitem">
						<label></label>
						<input name="url" type="text" maxlength="256" class="easyui-textbox" data-options="" missingMessage="请填写url">
					</div>
					<div class="fitem">
						<label></label>
						<input name="creator" type="text" maxlength="32" class="easyui-textbox" data-options="" missingMessage="请填写creator">
					</div>
					<div class="fitem">
						<label></label>
						<input name="createTime" type="text" maxlength="" class="easyui-textbox" data-options="" missingMessage="请填写createTime">
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/logOperation.js"></script>
  </body>
</html>
