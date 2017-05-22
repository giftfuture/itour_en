<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 120px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">订单号:</label><input name="orderNo" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">订单名称:</label><input name="orderName" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">订单状态:</label>
				<select name="orderStatus" class="easyui-combobox" data-options="editable:false,width:100">
					<option value="">--请选择--</option>
					<option value="1">待付款</option>
					<option value="2">付款完成,待确认</option>
					<option value="3">确认支付完成</option>
				</select>&nbsp;&nbsp;
			</p>
		<p class="ui-fields"><label class="ui-label">联系人:</label><input name="receiver" class="easyui-textbox" data-options="width:100">&nbsp;&nbsp;
			<label class="ui-label">下单时间:</label><input name="createTime"  class="easyui-datebox" data-options="width:100,editable:false,region:'north',split:true,border:false" ></p>
	    &nbsp; &nbsp; <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="订单信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	 <!--   <div class="ftitle">客户订单</div> -->
					<!-- <div class="fitem">
						<label>订单状态:</label>
						<select name="orderStatus">
							<option value="1">待付款</option>
							<option value="2">付款完成,待确认</option>
							<option value="3">确认支付完成</option>
						</select>
					</div> -->
					<div class="fitem">
						<label>订单号:</label>
						<input name="orderNo" type="text" maxlength="100" class="easyui-textbox" data-options="editable:false" missingMessage="请填写receiver">
					</div>
					<div class="fitem">
						<label>订单名称:</label>
						<input name="orderName" type="text" maxlength="100" class="easyui-textbox" data-options="" missingMessage="请填写receiver">
					</div>
					<div class="fitem">
						<label>联系人:</label>
						<input name="receiver" type="text" maxlength="100" class="easyui-textbox" data-options="" missingMessage="请填写receiver">
					</div>
					<div class="fitem">
						<label>联系人性别:</label>
						<select id="gender" name="gender" class="easyui-combobox" data-options="editable:false">
			              <option>性别</option>
			              <option value="1">男</option>
			              <option value="0">女</option>
			            </select>
					</div>
			  	    <div class="fitem">
						<label>订单路线:</label>
						<input name="routename" type="text" maxlength="20" class="easyui-textbox" missingMessage="请填写receiverMobile">
					</div>
					<div class="fitem">
						<label>联系电话:</label>
						<input name="receiverMobile" type="text" maxlength="20" class="easyui-numberbox" data-options="validType:'mobileTelephone',missingMessage:'请填写联系方式(手机或固话)',invalidMessage:'无效的联系方式'" missingMessage="请填写receiverMobile">
					</div>
					<div class="fitem">
						<label>联系邮箱:</label>
						<input name="receiveremail" type="text" maxlength="100" class="easyui-textbox" data-options="" missingMessage="请填写receiver">
					</div>
					<div class="fitem">
						<label>订单状态：</label>
						<select id="orderStatus" name="orderStatus" class="easyui-combobox" data-options="editable:false" style="width:100px;">
							<option value="">--请选择--</option>
							<option value="1">待付款</option>
							<option value="2">付款完成,待确认</option>
							<option value="3">确认支付完成</option>
						</select>
					</div>
				<!-- <div class="fitem">
						<label>联系电话:</label>
						<input name="receiverMobile" type="text" maxlength="20" class="easyui-numberbox" data-options="validType:'mobileTelephone',missingMessage:'请填写联系方式(手机或固话)',invalidMessage:'无效的联系方式'" missingMessage="请填写receiverMobile">
					</div> -->
				<!-- 	<div class="fitem">
						<label>客户ID:</label>
						<input name="customerId" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写customerId">
					</div> -->
					<div class="fitem">
						<label>计划出行日:</label>
						<input id="expectedDepart" name="expectedDepart" type="text" maxlength=""  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false,validType:'dateValided'" missingMessage="请填写expectedDepart">
					</div>
					<div class="fitem">
						<label>计划返程日:</label>
						<input id="expectedBack" name="expectedBack" type="text" maxlength=""  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false,validType:'dateValided'" missingMessage="请填写expectedBack">
					</div>
					<div class="fitem">
						<label>出行人数:</label>
						<input name="totalStaff" type="text" maxlength="" class="easyui-numberbox" data-options="max:100" missingMessage="请填写totalStaff">
					</div>
					<div class="fitem">
						<label>出行预算:</label>
						<input name="budget" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2" missingMessage="请填写出行预算">
					</div>
					<div class="fitem">
						<label>支付方式:</label>
						<select id="payType" name="payType" class="easyui-combobox" data-options="editable:false" >
							<option value="">--请选择--</option>
							<option value="1">线上支付</option>
							<option value="2">现金支付</option>
							<option value="3">邮局汇款</option>
							<option value="4">公司转帐</option>
						</select>
					</div>
	  			<!--    <div class="fitem">
						<label>是否支付完成：</label>
						<select name="orderStatus" class="easyui-box ui-text" style="width:100px;">
							<option value="">--请选择--</option>
							<option value="1">未支付</option>
							<option value="2">支付完成</option>
						</select>
					</div> -->
					<div class="fitem">
						<label>支付平台:</label>
						<select id="payPlatform" name="payPlatform" class="easyui-combobox" data-options="editable:false">
							<option value="">--请选择--</option>
							<option value="1">微信</option>
							<option value="2">支付宝</option>
							<option value="3">网银</option>
						</select>
					</div>
					<div class="fitem">
						<label>付款银行:</label>
						<select id="bank" name="bank" class="easyui-combobox" data-options="editable:false">
							<option value="">--请选择--</option>
							<option value="中国银行">中国银行</option>
							<option value="中国农业银行">中国农业银行</option>
							<option value="中国工商银行">中国工商银行</option>
							<option value="中国建设银行">中国建设银行</option>
							<option value="交通银行">交通银行</option>
							<option value="浦发银行">浦发银行</option>
							<option value="招商银行">招商银行</option> 
							<option value="广发银行">广发银行</option>
							<option value="中信银行">中信银行</option>
							<option value="兴业银行">兴业银行</option>
							<option value="邮储银行">邮储银行</option>
							<option value="民生银行">民生银行</option>
							<option value="平安银行">平安银行</option>
							<option value="光大银行">光大银行</option>
							<option value="华夏银行">华夏银行</option>
							<option value="汇丰银行">汇丰银行</option>
							<option value="其他银行">其他银行</option>
						</select>
					</div>
					<div class="fitem">
						<label>付款方帐户:</label>
						<input name="payAccount" type="text" maxlength="255" class="easyui-numberbox" data-options="" missingMessage="请填写payAccount">
					</div>
				<!-- 	<div class="fitem">
						<label>是否支付完成:</label>
						<input name="isPayed" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写isPayed">
					</div>  -->
					<div class="fitem">
						<label>备&nbsp;&nbsp;注:</label>
						<textarea rows="5" cols="30" name="remark" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150"  missingMessage="请填写remark"></textarea>
						<!-- <label>付款时间:</label> -->
						<input name="payTime" type="hidden" value="currentText" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写payTime">
						<!-- <label>付款终端:</label> -->
						<input name="payTerminal" type="hidden"  maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写payTerminal">
					</div>
  			</div>
     	</form>
  	 </div>
   <script type="text/javascript" src="<%=basePath%>js/ux/sys/travelOrder.js"></script>
  </body>
</html>
