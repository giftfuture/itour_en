<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 100px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<!-- <label class="ui-label">客户ID:</label><input name="id" class="easyui-box ui-text" style="width:100px;"> -->
			<label class="ui-label">标题:</label><input name="title" class="easyui-textbox" data-options="width:120">&nbsp;&nbsp;
			<label class="ui-label">状态:</label>&nbsp;&nbsp;
				<select name="status" class="easyui-combobox" data-options="editable:false,width:120">
				   <option value="">--请选择--</option>
				   <option value="1">待审核</option>
				   <option value="2">审核通过</option>
				   <option value="3">审核未通过</option>
				</select>&nbsp;&nbsp;
			<!-- <input name="status" class="easyui-box ui-text" style="width:100px;"/> -->
			<label class="ui-label">晒出日期:</label><input name="createTime" class="easyui-datebox" data-options="width:120,editable:false,region:'north',split:true,border:false">&nbsp;&nbsp;
			<label class="ui-label">旅行日期:</label><input name="tourTime" class="easyui-datebox" data-options="width:120,editable:false,region:'north',split:true,border:false">&nbsp;&nbsp;
	    </p>
	    <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search" style="margin-top:10">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="回忆幸福" data-options="autoOpen:false,closed:true,iconCls:'icon-save',modal:true,closeOnEscape:false, 
     open:function(event,ui){$('.panel-tool-close').hide();}" style="width:1150px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <table>
                      <tr><td style="text-align:left"><div class="fitem">
                        <label>标题:</label>
                        <input name="title" type="text" maxlength="255"  class="easyui-textbox" data-options="" missingMessage="请填写title">
                        <span style="color:red">*</span>
                    </div></td>
                    <td style="text-align:left"><div class="fitem">
                        <label>旅行日期</label>
                        <input name="tourTime" type="text" maxlength="" class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" missingMessage="请填写旅行日期">
                    </div></td>
                    <td style="text-align:left"><div class="fitem">
                        <label>晒出人</label>
                        <input name="title" type="text" maxlength="255"  class="easyui-textbox" data-options="" missingMessage="请填写晒出人">
                        <!-- <span style="color:red">*</span> -->
                    </div></td>
                    </tr>
                    <tr><td colspan=3 style="text-align:left"><div class="fitem">
                        <label>内容:</label>
                        <textarea id="content" name="content"></textarea> 
                        <!-- <!-- <textarea rows="5" cols="30" name="content"  maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150" missingMessage="请填写content"></textarea>
                        <span style="color:red">*</span> -->  
                    </div></td></tr>
                    <tr><td style="text-align:left"><div class="fitem">
                        <label>路线</label>
                        <input name="routeTitle" type="text" maxlength="255"  class="easyui-textbox" data-options="editable:false" missingMessage="请填写路线图">
                        <span style="color:red">*</span>
                    </div>
                    </td>
                    <td style="text-align:left"><div class="fitem">
                        <label>来自地区</label>
                          <input name="area" class="easyui-combobox"  data-options="width:131,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'"> 
                       <!--  <span style="color:red">*</span> -->
                    </div></td>
                    <td style="text-align:left"><div class="fitem">
                        <label>审核状态</label>
                        <select name="status" class="easyui-combobox" data-options="editable:false">
                           <option value="1">待审核</option>
                           <option value="2">审核通过</option>
                           <option value="3">审核未通过</option>
                        </select>
                    </div></td></tr>
                    <tr><td colspan=3 style="text-align:left"><div class="fitem" style="text-align:left;">
                        <label>审核意见</label>
                        <textarea rows="5" cols="90" name="result" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:1050,height:150" missingMessage="请填写result"></textarea>
                    <!--    <input name="result" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写result"> -->
                    </div></td><td></td></tr>
                      </table> 
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/showhappy.js"></script>
  </body>
</html>
