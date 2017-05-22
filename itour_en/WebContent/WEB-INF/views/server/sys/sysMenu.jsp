<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  <script type="text/javascript" src="<%=basePath%>js/ux/sys/sysMenu.js"></script>
</head>
  <body class="easyui-layout">
  	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: false,collapsible:false,iconCls:'icon-search',border:false" >   
 	 <form id="searchForm">
 	 	<input class="hidden" id='search_parentId' name="parentId">
 	 	<p class="ui-fields">
            <label class="ui-label">菜单名:</label> 
            <input name="name" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
             <label class="ui-label">URL:</label> 
            <input name="url" class="easyui-textbox" style="width:100px;" data-options="region:'north',split:true,border:false" >&nbsp;&nbsp;
             <label class="ui-label">创建时间:</label> 
            <input name="createTime" class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;">&nbsp;&nbsp;
        </p>
        <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- DataList  -->
	 <div region="center" border="false">
     	<table id="data-list" ></table>
     </div>
    
     <!-- Edit Win&From -->
     <div id="edit-win" class="easyui-dialog" title="菜单项" data-options="closed:true,iconCls:'icon-save',modal:true"  style="width:600px;height:490px;">  
     	<form id="editForm" class="ui-form" method="post"> 
     	 <!-- 隐藏文本框 -->
     	 <input class="hidden" name="id">
     	 <input class="hidden" name="deleted">
    	 <input class="hidden" name="parentId" id='edit_parentId'>
    	 <div class="easyui-panel" border='false' style="width:500px;height: 455px;">  
	        <div class="easyui-layout" data-options="fit:true">
	            <div data-options="region:'north',split:true,height:155,padding:10" >  
	             <!--   <div class="ftitle">详细</div>     -->
		           <div class="fitem">  
		               <label>名称:</label>  
		               <input class="easyui-textbox" type="text" name="name" data-options="required:true,width:300">
		           </div>  
		           <div class="fitem">  
		               <label>URL:</label>  
		               <input type="text" name="url" class="easyui-textbox"  data-options="width:300"></input>
		           </div>  
		      <!--      <div class="fitem">  
		               <label>Rank:</label>  
		               <input class="easyui-numberbox" type="text" value="0" name="rank" data-options="required:true,min:0,max:999">
		           </div>  -->
		           <div class="fitem">  
		               <label>Actions:</label>  
		               <input class="easyui-textbox" type="text" name="actions"  data-options="width:300"><br/>
		               <span style="padding-left:100px">注册的Action.按"|"分隔</span>
		           </div> 
	            </div>
	            <div data-options="region:'center',split:true,height:300">  
	              	<div id="toolbar">  
				        <a href="javascript:void(0)" id='addLine_btn' class="easyui-linkbutton" iconCls="icon-add" plain="true" >Add</a>  
				        <a href="javascript:void(0)" id='addDefLine_btn'class="easyui-linkbutton" iconCls="icon-add" plain="true" >AddDefault</a>
				        <a href="javascript:void(0)" id='delAllLine_btn'class="easyui-linkbutton" iconCls="icon-remove" plain="true" >Delete All</a>  
				    </div>  
				    <table id="btn-tb" style="width:100%;height:270;padding:10;float:top,valign:top">
				    	<thead>
				    	<tr>
				    		<!-- <th width="5%"></th> -->
				    		<th width="25%">按钮名称:</th>
				    		<th width="25%">按钮类型</th>
				    		<th width="40%">注册Action(用"|"分格)</th>
				    		<th width="10%">删除</th>
				    	</tr>
				    	</thead>
				    	<tbody>
				    	</tbody>
				    </table>
	            </div>
	         </div>
	       </div>
     	</form>
  	 </div>
  
  </body>
</html>
