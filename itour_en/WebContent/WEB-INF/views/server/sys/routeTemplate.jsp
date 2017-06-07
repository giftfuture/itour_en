<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="${basePath}/css/zxxFile.css">
  <script type="text/javascript" src="${basePath}/js/commons/zxxFile.js"></script> 
  <script type="text/javascript" src="${basePath}/js/commons/uploadFile.js"></script> 
  <script type="text/javascript" src="${basePath}/js/commons/uploadPhotos.js"></script> 
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">客户ID:</label><input name="customerId" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">创建人:</label><input name="createBy" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">创建时间:</label><input name="createTime"  class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false" style="width:100px;">&nbsp;&nbsp;
			<label class="ui-label">热门度:</label><select name="starLevel" class="easyui-combobox" data-options="width:131,height:20,editable:false">
			<option value="">--请选择--</option>
			<option value="5">五星</option>
			<option value="4">四星</option>
			<option value="3">三星</option>
			<option value="2">两星</option>
			<option value="1">一星</option>
			</select>
	    </p> &nbsp;&nbsp;
	    <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
     <!-- Edit Win&Form -->
      	 <div id="upload-photo" title="图片上传" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form  class="ui-form" id="uploadPhotoForm" name="uploadPhotoForm" method="post" enctype="multipart/form-data" autocomplete="off">
   				 <input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload">
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                <input id="fileImage" type="file" name="fileselect" multiple="multiple" accept="image/*"  />
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
   	 <div id="uploadCover-photo" title="封面上传" class="easyui-dialog" data-options="autoOpen: false,closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form  class="ui-form" id="uploadCoverForm" name="uploadCoverForm" method="post" enctype="multipart/form-data" autocomplete="off">
   				 <input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload">
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                                 封面：<input id="fileImage" type="file" name="fileselect" accept="image/*"  />
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
   	 <div id="upload-map" title="地图上传" class="easyui-dialog" data-options="autoOpen: false,closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form class="ui-form" id="uploadMapForm" name="uploadMapForm" method="post" enctype="multipart/form-data" autocomplete="off">
			<input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload">
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                                 地图：<input id="mapfile" type="file" name="mapfile" accept="image/*"  />
                            </div>
                            <div id="mappreview" class="upload_preview"></div>
                        </div>
                        <div class="upload_submit">
                            <button type="submit" id="mapSubmit" class="upload_submit_btn">确认上传</button>
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="upload_cancel_btn" id="win-close">取消上传</button>
                        </div>
                        <div id="mapuploadInf" class="upload_inf"></div>
                    </div>
				</div>
				</div>
     	</form>
	 </div> 

     <div id="edit-win" class="easyui-dialog" title="路线模板" data-options="autoOpen: false,closed:true,iconCls:'icon-save',modal:true,draggable:true,width:'80%',height:'80%'"  >  <!-- style="padding:200px;top:200px;left:200px;" -->
     	<form id="editForm" class="ui-form" method="post"  ><!-- autocomplete="off" target="coverImgifm" --> <!-- accept="application/json" --> <!-- enctype="multipart/form-data" -->
     		 <input class="hidden" name="id">
     		 <!-- <input class="hidden" name="levelArea"> -->
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">路线模板</div> -->
		     	   <table><thead></thead>
		     	   <tbody>
		     	   <tr><td style="text-align:left">	<div class="fitem">
						<label>线路名称:</label><input name="title" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20,required:true" missingMessage="请填写scope"><span style="color:red">*</span>
					</div></td>
					<td style="text-align:left"><div class="fitem">
					<label class="ui-label">热门度:</label>
					<select name="starLevel" class="easyui-combobox"  data-options="width:131,height:20,editable:false">
						<option value="">--请选择--</option>
						<option value="5">五星</option>
						<option value="4">四星</option>
						<option value="3">三星</option>
						<option value="2">两星</option>
						<option value="1">一星</option>
					</select>
					</div></td>
		     	  	 <td style="text-align:left"><div class="fitem">
						<label>线路类别:</label><input name="travelStyleAlias" class="easyui-combobox"  data-options="width:131,height:20,valueField:'alias',textField:'type',mode:'remote',panelHeight:'auto',editable:false,method:'get',url:'${basePath}travelStyle/loadStyles'">
					</div></td><td style="text-align:left"><div class="fitem">
						<label>途经景点:</label>
						   <select id="travelItems" name="travelItemAliass" class="easyui-combobox" data-options="editable:false,region:'north',split:true,border:false,multiple:true,required:true,width:131,height:20"></select>
					</div></td></tr>  
		      	   <tr><td style="text-align:left"><div class="fitem">
						<label>简略描述:</label><input name="shortContent" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20" missingMessage="请填写简略描述">
					</div></td><td style="text-align:left"><div class="fitem">
						<label>线路特色:</label><input name="special" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20" missingMessage="请填写简略描述">
					</div></td>  
					<td style="text-align:left"><div class="fitem">
                        <label>建议天数:</label><input name="rcdDays" type="text" maxlength="" class="easyui-numberbox" data-options="width:131,height:20" missingMessage="请填写rcdDays">
                    </div></td>
		     	   <!--    <td style="text-align:left"><div class="fitem">
						<label>相似线路:</label>
						<select id="related" name="related" class="easyui-combobox" data-options="editable:false,region:'north',split:true,border:false,multiple:true,required:true,width:131,height:20" ></select>
					</div></td> -->
					<td style="text-align:left"><div class="fitem">
						<label id="difficultyRateLabel">挑战度:</label>
						<select name="difficultyRate" class="easyui-combobox ui-text" data-options="editable:false,region:'north',split:true,border:false,width:131,height:20">
							<option value="">--请选择--</option>
							<option value="0">入门难度</option>
							<option value="1">一般难度</option>
							<option value="2">略有挑战</option>
							<option value="3">难度适中</option>
							<option value="4">是个难关</option>
							<option value="5">难度爆表</option>
						</select>		
					</div></td></tr>  
		     	  <tr><td style="text-align:left"><div class="fitem">
						<label>山峰类型:</label><input name="mountStyle" type="text" maxlength="" class="easyui-textbox" data-options="width:131,height:20" missingMessage="请填写elevation">
					</div></td><td style="text-align:left"><div class="fitem">
						<label style="margin-left:0px">海&nbsp;&nbsp;&nbsp;&nbsp;拔:</label><input name="elevation" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:',',width:131,height:20" missingMessage="请填写elevation">米
					</div></td>
		     	    <td style="text-align:left"><div class="fitem">
						<label style="margin-left:0px">里&nbsp;&nbsp;&nbsp;&nbsp;程:</label><input name="mileage" type="text" maxlength="255" class="easyui-numberbox" data-options="precision:2,groupSeparator:',',width:131,height:20" missingMessage="请填写mileage">公里
					</div></td><td style="text-align:left"><div class="fitem">
						<label style="margin-left:0px">徒步距离:</label><input name="trekDistance" type="text" maxlength="255" class="easyui-numberbox" data-options="precision:2,groupSeparator:',',width:131,height:20" missingMessage="请填写mileage">公里
					</div></td></tr>
		     	   <tr><td style="text-align:left"><div class="fitem">
						<label>交通工具:</label><input name="transportation" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20"  missingMessage="请填写mileage">
					</div></td><td style="text-align:left"><div class="fitem">
						<label>建议天数:</label><input name="rcdDays" type="text" maxlength="" class="easyui-numberbox" data-options="width:131,height:20" missingMessage="请填写rcdDays">
					</div></td>
		     	   <td style="text-align:left"><div class="fitem">
						<label>出发地:</label><input name="departure" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20" missingMessage="请填写mileage">
					</div></td><td style="text-align:left"><div class="fitem">
						<label>到达地:</label><input name="arrive" type="text" maxlength="255" class="easyui-textbox" data-options="width:131,height:20" missingMessage="请填写mileage">
					</div></td></tr>  
					<%-- <tr><td style="text-align:left"><div class="fitem">
						<label>一级区域:</label><input class="easyui-combobox" id="formlevel1Area" name="level1Area" data-options="width:130,height:20,valueField:'level1Area',textField:'level1Area',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}levelarea/queryLevel1',
       					onChange:function(n,o){var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+n ;$('#formlevel2Area').combobox('reload',urlurl);}">
					</div></td><td style="text-align:left"><div class="fitem">
						<label>二级区域:</label><input id="formlevel2Area" name="level2Area" class="easyui-combobox" data-options="width:130,height:20,valueField:'level2Area',textField:'level2Area',mode:'remote',panelHeight:'auto',editable:false, method:'get'">	</div></td>
					<td style="text-align:left"><div class="fitem"></div></td></tr> --%>
		     	   <tr><td colspan=4><div class="fitem">
						<label>设计理念:</label>
						<textarea id="designConcept" name="designConcept"></textarea> 
					<!-- <textarea rows="4" cols="80" id="designConcept" name="designConcept"  class="ckeditor" maxlength="5000" ></textarea> -->
					<!-- <script type="text/javascript">window.onload = function(){CKEDITOR.replace('designConcept');};</script> -->
					</div></td><td></td></tr>
					<tr><td colspan=4><div class="fitem">
						<label>定制服务:</label>
						<textarea id="customizedService" name="customizedService"></textarea> 
						<!-- <textarea rows="4" cols="80" id="customizedService" name="customizedService" class="ckeditor" maxlength="5000" ></textarea> -->
						<!-- <script type="text/javascript">window.onload = function(){CKEDITOR.replace('customizedService');};</script> -->
					</div></td></tr>
		     	   <tr><td colspan=4><div class="fitem">
						<label>行前须知:</label>
						<textarea id="beforeInstruction" name="beforeInstruction"></textarea> 
						<!-- <textarea rows="4" cols="80" id="beforeInstruction" name="beforeInstruction" class="ckeditor" maxlength="5000"></textarea> -->
						<!-- <script type="text/javascript">window.onload = function(){CKEDITOR.replace('beforeInstruction');};</script>  -->
					</div></td><td></td></tr>  
				    <tr><td colspan=4><div class="fitem">
                        <label>服务与报价:</label>
                        <textarea id="serviceAndQuote" name="serviceAndQuote"></textarea> 
                        <!-- <textarea rows="4" cols="80" id="serviceAndQuote" name="serviceAndQuote" class="ckeditor" maxlength="5000"></textarea> -->
                        <!-- <script type="text/javascript">window.onload = function(){CKEDITOR.replace('serviceAndQuote');};</script>  -->
                    </div></td><td></td></tr>  
			 	 	<tr><td colspan=4><div class="fitem">
						<label style="width:50">备注:</label>	
						<textarea rows="4" cols="80" name="remark" maxlength="5000"  class="easyui-textbox" data-options="multiline:true,width:1300,height:100"  missingMessage="请填写remark"></textarea>
					</div></td></tr>  
					<!-- <div class="fitem">
						<label>更新时间:</label>
						<input name="updateTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写updateTime">
					</div>
					<div class="fitem">
						<label>更新人:</label>
						<input name="updateBy" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写updateBy">
					</div> -->
		     	   </tbody>
		     	   </table>
	   				<!-- <div class="fitem">
						<label>客户ID:</label>
						<input name="customerId" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写customerId">
					</div> -->
					<!-- <div class="fitem">
						<label>创建时间:</label>
						<input name="createTime" type="text" maxlength="" class="easyui-datetimebox" data-options="" missingMessage="请填写createTime">
					</div>
					<div class="fitem">
						<label>创建人:</label>
						<input name="createBy" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写createBy">
					</div> -->
				<!-- 	<div class="fitem">
						<label>具体介绍:</label><textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-validatebox" data-options="" missingMessage="请填写具体介绍"></textarea>
					</div>  -->
				  <!-- 	<div class="fitem">
						<label id="rankLabel">推荐指数:</label>
						</div>  
					<div class="fitem">
						<label>推荐原因:</label><input name="recommandReason" type="text" maxlength="512" class="easyui-validatebox" data-options="" missingMessage="请填写recommandReason">
					</div> -->
				<!-- 	<div class="fitem">
						<label id="happyLabel">好玩值:</label>
					</div>
					<div class="fitem">
						<label id="rucrowd">建议人群:</label>
					</div> -->
  			</div>
     	</form>
     	<!-- <iframe id='coverImgifm' name='coverImgifm' style="display:none"/> -->
  	 </div>
     <script type="text/javascript" src="<%=basePath%>js/ux/sys/routeTemplate.js"></script>
  </body>
</html>

		