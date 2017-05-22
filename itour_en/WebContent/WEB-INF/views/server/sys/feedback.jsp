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
			<label class="ui-label">客户ID:</label><input name="id" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">标题:</label><input name="title" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">状态:</label>
				<select name="status" class="easyui-combobox" style="width:100px;">
				   <option value="">--请选择--</option>
				   <option value="1">待审核</option>
				   <option value="2">审核通过</option>
				   <option value="3">审核未通过</option>
				</select>&nbsp;&nbsp;
			<!-- <input name="status" class="easyui-box ui-text" style="width:100px;"/> -->
			<label class="ui-label">反馈时间:</label><input name="createTime"  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;">
	    </p>&nbsp;&nbsp;
	    <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="客户反馈" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">客户反馈</div> -->
					<!-- <div class="fitem">
						<label></label>
						<input name="feedbackId" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写feedbackId">
					</div> -->
				<!-- 	<div class="fitem">
						<label>客户ID</label>
						<input name="customerId" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写customerId">
					</div> -->
					<div class="fitem">
						<label>标题:</label>
						<input name="title" type="text" maxlength="255" required="true" class="easyui-textbox" data-options="" missingMessage="请填写title">
						<span style="color:red">*</span>
					</div>
					<p></p>
					<div class="fitem">
						<label>内容:</label>
						<textarea rows="5" cols="30" name="content" required="true" maxlength="500" class="easyui-textbox"  data-options="multiline:true,width:300,height:150"  missingMessage="请填写content"></textarea>
						<span style="color:red">*</span>
					</div>
			<!-- 		<div class="fitem">
						<label>反馈时间</label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div> -->
					<div class="fitem">
						<label>反馈状态</label>
						<select name="status" class="easyui-combobox">
						   <option value="1">待审核</option>
						   <option value="2">审核通过</option>
						   <option value="3">审核未通过</option>
						</select>
						<!-- <input name="status" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写status"> -->
					</div> 
				<!-- 	<div class="fitem">
						<label>更新时间</label>
						<input name="updateTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写updateTime">
					</div> -->
					<div class="fitem">
						<label>审核意见</label>
						<textarea rows="5" cols="30" name="result" maxlength="500" class="easyui-textbox"  data-options="multiline:true,width:300,height:150"  missingMessage="请填写result"></textarea>
					</div> 
					<div class="fitem">
						<label>是否公开展示</label>
						<select name="publicShow">
						   <option value="0">否</option>
						   <option value="1">是</option>
						</select>
					</div> 
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/feedback.js"></script>
  </body>
</html>
