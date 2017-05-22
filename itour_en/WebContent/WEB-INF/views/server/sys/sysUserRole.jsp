<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  </head>
 <body class="easyui-layout">
	<!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件"
 	  data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	   <label class="ui-label">账号:</label> 
 	 	   <input name="email" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
            <label class="ui-label">状态: </label><select name="state" class="easyui-combobox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;"><option value="">--请选择--</option><option value=0>可用</option><option value=1>禁用</option></select>&nbsp;&nbsp;
            <label class="ui-label">授予角色: </label><input name="roleStr" class="easyui-combobox"  style="width:100px;" data-options="valueField:'number',textField:'roleName',mode:'remote',panelHeight:'auto',editable:false,method:'post',url:'${basePath}sysRole/loadRoleList'">&nbsp;&nbsp;
        </p>
        <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     
     <!-- DataList  -->
     <div region="center" border="false" >
     <table id="data-list"></table>
     </div>

     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="授权" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:340px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="id">
     		  <div class="ui-edit">
		     	   <div class="ftitle">授权设置</div>    
		           <div class="fitem">  
		               <label>账号:</label>  
		               <input class="easyui-textbox" type="text" readonly="readonly" name="email" data-options="required:true,validType:'email'"/>
		           </div>  
		            <div class="fitem">  
		               <label>角色选择:</label>  
		               <select class="easyui-combobox" data-options="editable:false,region:'north',split:true,border:false,required:true,width:135" id="roleIds" name="roleIds"></select>
		           </div> 
	         </div>
     	</form>
  	 </div> 
<script type="text/javascript" src="<%=basePath%>js/ux/sys/sysUserRole.js"></script>
  </body>
</html>
