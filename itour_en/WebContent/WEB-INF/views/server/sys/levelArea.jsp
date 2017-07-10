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
			<label class="ui-label">一级区域:</label><input class="easyui-combobox" id="level1Area" name="level1Area" data-options="width:120,valueField:'aliasCode',textField:'level1Area',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}levelarea/queryLevel1',
        onChange:function(n,o){var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?aliasCode='+n ;$('#level2Area').combobox('reload',urlurl);}">&nbsp;&nbsp;
			<label class="ui-label">二级区域:</label> <input id="level2Area" name="level2Area" class="easyui-combobox" data-options="width:120,valueField:'aliasCode',textField:'level2Area',mode:'remote',panelHeight:'auto',editable:false, method:'get'">&nbsp;&nbsp;     
			<label class="ui-label">景点:</label>
		  <input class="easyui-combobox" id="travelItem" name="travelItem" data-options="width:120,valueField:'alias',textField:'item',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}travelItem/allItems'"/>&nbsp;&nbsp;
	    </p>&nbsp;&nbsp;
	    <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search" style="margin-top:10">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="路线区域" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="rtid">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">路线区域</div> -->
		     	  <!--  <table><tr></tr></table> -->
		     	   	<div class="fitem">
						<div id="larttitle" style="display:none"><label>路线名称:</label>
						<input class="easyui-textbox" name="title" data-options="width:130,height:20,editable:false,border:0,padding:100"/></div>&nbsp;&nbsp;
						<div id="larouteTemplates"  style="display:none"><label>路线名称:</label><input class="easyui-combobox"  name="routeTemplate" data-options="width:130,height:20,padding:100,valueField:'routeCode',textField:'title',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}routeTemplate/queryAll'"/></div>
					</div>
					<div class="fitem">
						<label>一级区域:</label>
						<input class="easyui-combobox" id="formlevel1Area" name="level1Area" data-options="width:130,height:20,valueField:'level1Area',textField:'level1Area',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}levelarea/queryLevel1',
       					onChange:function(n,o){var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+n ;$('#formlevel2Area').combobox('reload',urlurl);}">
        				<br/><span style="padding-left:50px" >新增一级区域</span><a name="addLevel1Area" >&nbsp;&nbsp;&nbsp;<img src="${basePath }images/add.gif" width="16" height="16" ></a> 
        				<div id="level1Areadiv" style="display:none;margin-top:5px">
        					<span name="newlevel1span" style="padding-left:50px" ><input name="newlevel1Area" type="text" class="easyui-textbox">
        					<a name="addlevel1" class="easyui-linkbutton" iconcls="icon-save">新增</a>
        					<a name="cancel1" class="easyui-linkbutton" iconcls="icon-cancel">取消</a></span>
        					<span style="margin-top:5px;padding-top:5px;padding-left:50px">一级区域：<label name="keeplevel1" style="text-align:center"></label>&nbsp;&nbsp;<a name="delkeeplevel1">删除</a></span>
       					</div>
					</div>
					<div class="fitem">
						<label>二级区域:</label>
						<input id="formlevel2Area" name="level2Area" class="easyui-combobox" data-options="width:130,height:20,valueField:'level2Area',textField:'level2Area',mode:'remote',panelHeight:'auto',editable:false, method:'get'">
						<br/><span style="padding-left:50px" >新增二级区域</span><a name="addLevel2Area" >&nbsp;&nbsp;&nbsp;<img src="${basePath }images/add.gif" width="16" height="16" ></a>
						<div id="level2Areadiv" style="display:none;margin-top:5px"> 
							<span name="newlevel2span" style="padding-left:50px" ><input name="newlevel2Area" type="text" class="easyui-textbox">
        					<a name="addlevel2" class="easyui-linkbutton" iconcls="icon-save">新增</a>
        					<a name="cancel2" class="easyui-linkbutton" iconcls="icon-cancel">取消</a></span>
							<span style="margin-top:5px;padding-top:5px;padding-left:50px">二级区域：<label name="keeplevel2" style="text-align:center"></label>&nbsp;&nbsp;<a name="delkeeplevel2">删除</a></span>
       					</div>
					</div>
					<div class="fitem">
						<label>景点名称:</label>
						<input class="easyui-combobox" id="item" name="item" data-options="width:130,height:20,valueField:'alias',textField:'item',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}travelItem/allItems'"/>&nbsp;&nbsp;
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/levelArea.js"></script>
  </body>
</html>
