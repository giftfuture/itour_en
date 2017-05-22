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
			<label class="ui-label">状态:</label>
			<select name="status" class="easyui-combobox" style="width:100px;">
				<option value="">--请选择--</option>
				<option value="1">待处理</option>
				<option value="2">处理中</option>
				<option value="3">处理完成</option>
			</select>&nbsp;&nbsp;
			<label class="ui-label">创建时间:</label><input name="createTime"  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;">
	    </p>
	    &nbsp; &nbsp;<a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="订单详情" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">订单详情</div> -->
   					<div class="fitem">
						<!-- <label>详情号</label> -->
						<input name="orderId" type="hidden" maxlength="64" class="easyui-textbox" data-options="" missingMessage="请填写orderId">
					</div>
					<div class="fitem">
						<label>导游:</label>
						<span class="radioSpan">
				            <input type="radio" name="guide" value="中文" />中文 
				            <input type="radio" name="guide" value="英文" />英文 
				            <input type="radio" name="guide" value="广东话" />广东话 <br/>
				            <input type="radio" name="guide" value="其他语种" />其它语种
				            <span id="elseguide" style="display:none" >
				            <input type="text" class="easyui-textbox"name="guide_other" id="guide_other" value=""> </span>
				            <input type="radio" name="guide" value="无需导游" />无需导游</span>
					</div>
					<div class="fitem">
						<label>来自:</label>
						<input id="comefrom" name="comefrom" class="easyui-combobox"  data-options="width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'">
					</div>
					<div class="fitem">
						<label>状&nbsp;&nbsp;态:</label>
						<select id="status" name="status" class="easyui-combobox" data-options="editable:false">
							<option value="1">待处理</option>
							<option value="2">处理中</option>
							<option value="3">处理完成</option>
						</select>
					</div>
        			<div class="fitem">
						<label>出行方式:</label>
						<select id="travelfashion" name="travelfashion" class="easyui-combobox" data-options="editable:false">
						  	<option value="">请选择</option>
						  	<option value="单独安排">单独安排</option>
							<option value="加入散客团">加入散客团</option>
						 </select>
					</div>
					<div class="fitem">
						<label>团/人:</label>
						<select id="singleorcluster" name="singleorcluster" class="easyui-combobox" data-options="editable:false">
						  	<option value="人">人</option>
							<option value="团">团</option>
						  </select>
					</div>
					<div class="fitem">
						<label>成人人数:</label>
						<input name="adults" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写totalStaff">
					</div>
				   <div class="fitem">
						<label>小孩人数:</label>
						<input name="children" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写totalStaff">
					</div>
					<div class="fitem">
						<label>团号:</label>
						<input name="groupCode" type="text" maxlength="" class="easyui-textbox" data-options="" missingMessage="请填写totalStaff">
					</div>
					<div class="fitem">
						<label>出行日期:</label>
						<input id="groupDate" name="groupDate" type="text" class='easyui-datebox' data-options="validType:'dateValided',editable:false,required:true,split:true,border:false,region:'north'" style="width:100px;" />
					</div>
					<!-- <div class="fitem">
						<label>创建时间:</label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
					<div class="fitem">
						<label>更新时间:</label>
						<input name="updateTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写updateTime">
					</div> -->
				<!-- 	<div class="fitem">
						<label>单&nbsp;&nbsp;价:</label>
						<input name="perPrice" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写perPrice">
					</div>
					<div class="fitem">
						<label>数&nbsp;&nbsp;量:</label>
						<input name="count" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写count">
					</div>
					<div class="fitem">
						<label>内容详情:</label>
							<textarea rows="7" cols="30" name="content" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写remark"></textarea>
					</div> -->
					<div class="fitem">
						<label>备&nbsp;&nbsp;注:</label>
						<textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-textbox"  data-options="multiline:true,width:300,height:150"  missingMessage="请填写remark"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/orderDetail.js"></script>
  </body>
</html>
