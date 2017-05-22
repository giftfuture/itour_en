<%@ page language="java"  pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
 <head>
 <link rel="stylesheet" type="text/css" href="${basePath}/css/zxxFile.css">
 <script type="text/javascript" src="${basePath}/js/commons/zxxFile.js"></script> 
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" style="height: 120px;" title="过滤条件" data-options="striped: true,region:'north',collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">链接名称:</label>
			<input name="title" class="easyui-textbox" data-options="width:300"/>
			&nbsp;&nbsp;<label class="ui-label">链接地址:</label>
			<input name="adlink" class="easyui-textbox" data-options="width:300"/>
			&nbsp;&nbsp;<label class="ui-label">图片名称:</label>
			<input name="advertise" class="easyui-textbox" data-options="width:300"/>
			&nbsp;&nbsp;<a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a></p>
      </form>
      </div>
       <!--  Search panel end -->
     <div region="center" border="false" >
     <!-- Data List -->
     <table id="data-list"></table>
	 </div>
	 <!-- Edit Win&Form -->
	 <div id="upload-photo" title="图片上传" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form  class="ui-form" id="multiDataForm" name="multiDataForm" method="post" enctype="multipart/form-data" autocomplete="off">
   				 <input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload"><!-- <label>美&nbsp;&nbsp;图:</label> -->
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                <input id="fileImage" type="file" name="fileselect" accept="image/*"  />
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
     <div id="edit-win" title="首页链接" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">首页链接</div> -->
					<div class="fitem">
						<label>链接名称:</label><input name="title" type="text" maxlength="255" required="true" class="easyui-textbox" data-options="width:300,missingMessage:'请填写项目名称'" >
						<span style="color:red">*</span>
					</div>
					<div class="fitem">
						<label>链接地址:</label><input name="adlink" type="text" maxlength="255" class="easyui-textbox" data-options="width:300" missingMessage="请填写scope">
					</div>
				<!-- 	<div class="fitem">
						<label>链接图片:</label><input name="advertise" type="text" maxlength="255" required="true" class="easyui-textbox" data-options="" missingMessage="请填写简略描述"><span style="color:red">*</span>
					</div>	 -->
					<!-- <div class="fitem">
						<label>是否有效:</label><input name="elevation" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写elevation">
					</div> -->
					<div class="fitem">
						<label>备&nbsp;&nbsp;注:</label><textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:300,height:150" missingMessage="请填写remark"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
<script type="text/javascript" src="${basePath}/js/ux/sys/adLink.js"></script>		  
  </body>
</html>
