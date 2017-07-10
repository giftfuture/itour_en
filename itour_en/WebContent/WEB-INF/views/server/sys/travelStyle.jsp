<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/zxxFile.css">
  <script type="text/javascript" src="${basePath}/js/commons/zxxFile.js"></script> 
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 100px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">旅行方式:</label><input name="type" class="easyui-textbox" data-options="width:120">&nbsp;&nbsp;
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
   	 <div id="upload-photo" title="图片上传" class="easyui-dialog" data-options="autoOpen: false,closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form  class="ui-form" id="multiDataForm" name="multiDataForm" method="post" enctype="multipart/form-data" autocomplete="off">
			 <input class="hidden" name="id">
			 	<div class="ui-edit">
    		       <div class="fitem upload">
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                                 封面：<input id="fileImage" type="file" name="fileselect" size="30" accept="image/*"  />
                            </div>
                            <div id="preview" class="upload_preview"></div>
                        </div>
                        <div class="upload_submit">
                            <button type="submit" id="fileSubmit" class="upload_submit_btn">确认上传</button>
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="upload_cancel_btn" id="win-close">取消上传</button>
                        </div>
                        <div id="uploadInf" class="upload_inf"></div>
                    </div>
				</div>
				</div>
     	</form>
	 </div> 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="旅行方式" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:320px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">旅行方式</div>  -->
					<div class="fitem">
						<label>旅行方式:</label>
						<input name="type" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写旅行方式">
					</div>
					<div class="fitem">
					<label>英文别名:</label>
					<input name="alias" type="text" maxlength="255" class="easyui-textbox" data-options="" missingMessage="请填写英文别名">
					</div>
					<div class="fitem">
					<label>简要描述:</label>
					<textarea rows="7" cols="30" name="descrip" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150"  missingMessage="请填写旅行方式备注"></textarea>
					</div>
					<div class="fitem">
						<label>备&nbsp;&nbsp;注:</label>
						<textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150"  missingMessage="请填写旅行方式备注"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/travelStyle.js"></script>
  </body>
</html>
