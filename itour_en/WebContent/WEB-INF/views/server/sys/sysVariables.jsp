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
			<label class="ui-label">变量名:</label><input name="varName" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">变量值:</label><input name="varValue" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
		    <label class="ui-label">主机名:</label><input name="varHostname" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
            <label class="ui-label">主机IP: </label><input name="varHostip" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
	    </p>
	    <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="系统变量" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">系统变量</div> -->
					<div class="fitem">
						<label>变量名:</label>
						<input name="varName" type="text" maxlength="255" class="easyui-textbox" data-options="required:true" missingMessage="请填写varName">
					</div>
					<div class="fitem">
						<label>变量值:</label>
						<input name="varValue" type="text" maxlength="512" class="easyui-textbox" data-options="" missingMessage="请填写varValue">
					</div>
					<div class="fitem">
						<label>主机名:</label>
						<input name="varHostname" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写varHostname">
					</div>
					<div class="fitem">
						<label>主机IP:</label>
						<input name="varHostip" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写varHostip">
					</div>
					<div class="fitem">
						<label>所属项目:</label>
						<input name="varProject" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写varProject">
					</div>
					<div class="fitem">
						<label>备注说明:</label>
							<textarea rows="5" cols="30" name="remark" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150"  missingMessage="请填写remark"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/sysVariables.js"></script>
  </body>
</html>
