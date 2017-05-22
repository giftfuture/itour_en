<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
 <script type="text/javascript" src="<%=basePath%>js/ux/sys/quotation.js"></script>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">报价单号:</label><input name="orderId" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">报价单名:</label><input name="name" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">生成时间:</label><input name="createTime"  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;">&nbsp;&nbsp;
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
     <div id="edit-win" class="easyui-dialog" title="报价单" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">报价单</div> -->
					<div class="fitem">
						<label>报价单名:</label>
						<input name="name" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写name">
					</div>
					<div class="fitem">
						<label>&nbsp;订单号:</label>
						<input name="orderId" type="text" maxlength="64" class="easyui-textbox" data-options="" missingMessage="请填写orderId">
					</div>
					<div class="fitem">
						<label>&nbsp;报价单:</label>
						<input name="quotation" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写quotation">
					</div>
					<!-- <div class="fitem">
						<label>创建时间:</label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
					<div class="fitem">
						<label>更新时间:</label>
						<input name="updateTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写updateTime">
					</div> -->
					<div class="fitem">
						<label>总价加利润/明细报价:</label>
						<input name="type" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写type">
					</div>
					<div class="fitem">
						<label>&nbsp;总金额:</label>
						<input name="totalPrice" type="text" maxlength="" class="easyui-textbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写totalPrice">
					</div>
					<div class="fitem">
						<label>计算明细:</label>
						<input name="formula" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写formula">
					</div>
					<div class="fitem">
						<label>备&nbsp;&nbsp;注:</label>
						<textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150" missingMessage="请填写remark"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>

  </body>
</html>
