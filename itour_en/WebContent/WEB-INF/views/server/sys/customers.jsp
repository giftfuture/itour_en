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
			<label class="ui-label">客户ID:</label><input name="customerId" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">创建时间:</label><input name="createTime" class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false"  style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">状态:</label>
			<select name="status" class="easyui-combobox" style="width:100px;">
				<option value="">--请选择--</option>
				<option value="1">活跃</option>
				<option value="2">不活跃</option>
				<option value="3">废弃</option>
			</select>&nbsp;&nbsp;
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
     <div id="edit-win" class="easyui-dialog" title="客户信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	 <!--   <div class="ftitle">客户信息</div> -->
					<!-- <div class="fitem">
						<label></label>
						<input name="customerId" type="text" maxlength="" class="easyui-numberbox" data-options="required:true" missingMessage="请填写customerId">
					</div> 
					<div class="fitem">
						<label></label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
					<div class="fitem">
						<label></label>
						<input name="status" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写status">
					</div>
					<div class="fitem">
						<label></label>
						<input name="updateTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写updateTime">
					</div>-->
					<div class="fitem">
						<label>姓&nbsp;&nbsp;名:</label>
						<input name="customerName" type="text" maxlength="200" class="easyui-textbox" required="true" data-options="" missingMessage="客户姓名为必填项">
						<span style="color:red">*</span>
					</div>
					<div class="fitem">
						<label>昵&nbsp;&nbsp;称:</label>
						<input name="nickName" type="text" maxlength="50" class="easyui-textbox" data-options="" missingMessage="请填写nickName">
					</div>
					<div class="fitem">
						<label>手机/移动电话:</label>
						<input name="mobile" type="text" maxlength="50" class="easyui-numberbox" required="true" data-options="" missingMessage="移动电话为必填项">
						<span style="color:red">*</span>
					</div>
					<div class="fitem">
						<label>固话/小灵通:</label>
						<input name="telephone" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写telephone">
					</div>
					<div class="fitem">
						<label>邮&nbsp;&nbsp;箱:</label>
						<input name="email" type="text" maxlength="255" class="easyui-textbox" required="true" data-options="" missingMessage="邮箱为必填项" validType="email" invalidMessage="请填写正确格式的邮件" >
						<span style="color:red">*</span>
					</div>
					<div class="fitem">
						<label>来自(国家/地区):</label>
					  <input name="scope" class="easyui-combobox"  data-options="width:131,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'"> 
					</div>
					<div class="fitem">
						<label>城&nbsp;&nbsp;市:</label>
						<input name="city" type="text" maxlength="50" class="easyui-textbox" data-options="" missingMessage="请填写city">
					</div>
					<div class="fitem">
						<label>区&nbsp;&nbsp;县:</label>
						<input name="district" type="text" maxlength="250" class="easyui-textbox" data-options="" missingMessage="请填写district">
					</div>
					<div class="fitem">
						<label>地&nbsp;&nbsp;址:</label>
						<input name="address" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写address">
					</div>
					<div class="fitem">
						<label>个人简介/要求:</label>
						<textarea  name="introduction"  rows="5" cols="30" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150" missingMessage="请填写introduction"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/customers.js"></script>
  </body>
</html>
