<%@ page language="java"  pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML>
<html>
 <head>
 <link rel="stylesheet" type="text/css" href="${basePath}/css/zxxFile.css">
 <script type="text/javascript" src="${basePath}/js/commons/zxxFile.js"></script> 
 <script type="text/javascript" src="${basePath}/js/commons/uploadFile.js"></script> 
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" style="height: 120px;" title="过滤条件" data-options="striped: true,region:'north',collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">景点代码:</label>
			<input name="itemCode" class="easyui-textbox" style="width:110px;"/>&nbsp;&nbsp;
			<label class="ui-label">景点名称:</label>
			<input name="item" class="easyui-textbox" style="width:108px;"/>&nbsp;&nbsp;
			<!-- <label class="ui-label">是否热门:</label>
			<select name="hot" class="easyui-combobox" style="width:108px;">
				<option value="0">否</option>
			 	<option value="1">是</option>
			 </select> -->
			 <label class="ui-label">热门度:</label><select name="starLevel" class="easyui-combobox" data-options="width:131,editable:false">
			<option value="">--请选择--</option>
			<option value="5">五星</option>
			<option value="4">四星</option>
			<option value="3">三星</option>
			<option value="2">两星</option>
			<option value="1">一星</option>
			</select>&nbsp;&nbsp;
			<label class="ui-label">海&nbsp;&nbsp;拔:</label>
			<select name="elevation" class="easyui-combobox" data-options="width:131,editable:false">
				<option value="">--请选择--</option>
				<option value="1">100米以下</option>
				<option value="2">500米以下</option>
				<option value="3">1000米以下</option>
				<option value="4">2000米以下</option>
				<option value="5">4000米以下</option>
				<option value="6">6000米以下</option>
				<option value="7">8000米以下</option>
				<option value="8">8000米以上</option>
			</select>&nbsp;&nbsp;
			<!-- var v = $(this).combobox('panel')[0].childElementCount; -->
			 
			<label class="ui-label">所属省市:</label><!-- onShowPanel:function(){$(this).combobox('panel').height(1000);} -->
		  <input name="scope" class="easyui-combobox"  data-options="width:131,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'">  &nbsp;&nbsp;
		<!-- 	<select name="scope" class="easyui-box ui-text" style="width:100px;">
				<option value="">--请选择--</option>
				<option value="四川">四川</option>
				<option value="云南">云南</option>
				<option value="西藏">西藏</option>
				<option value="新疆">新疆</option>
			</select> -->
			</p><p class="ui-fields"><label id="rcmdCrowd" class="ui-label">推荐人群:&nbsp;</label>&nbsp;&nbsp;
			<label class="ui-label" id="SelectrankLabel">推荐指数:&nbsp;</label>&nbsp;&nbsp;
			<label class="ui-label">里&nbsp;&nbsp;程:</label>&nbsp;&nbsp;
			<select name="mileage" class="easyui-combobox"  data-options="width:131,editable:false">
				<option value="">--请选择--</option>
				<option value="1">5公里以内</option>
				<option value="2">20公里以内</option>
				<option value="3">50公里以内</option>
				<option value="4">200公里以内</option>
				<option value="5">500公里以内</option>
				<option value="6">1000公里以内</option>
				<option value="7">2000公里以内</option>
			</select>
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
     	<form class="ui-form" id="uploadPhotoForm" name="uploadPhotoForm" method="post" enctype="multipart/form-data" autocomplete="off">
   				 <input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload">
					<div class="upload_box">
                        <div class="upload_main">
                            <div class="upload_choose">
                                <input id="fileImage" type="file" name="fileselect"  multiple="multiple" accept="image/*"  />
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
 	 <div id="uploadCover-photo" title="封面上传" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form class="ui-form" id="uploadCoverForm" name="uploadCoverForm" method="post" enctype="multipart/form-data" autocomplete="off">
   				 <input class="hidden" name="id">
 			   <div class="ui-edit">
    		       <div class="fitem upload">
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

 	 <div id="edit-photo" title="图片编辑" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:420px;">	 
     	<form action="" class="ui-form" id="editPhotoForm" name="editPhotoForm" method="post" ><!-- enctype="multipart/form-data" -->
   				 <input class="hidden" name="id">
   				 <div class="ui-edit">
    		       <div class="fitem upload"><!-- <label>美&nbsp;&nbsp;图:</label> -->
					<div class="upload_box">
                        <div class="upload_main">
                            <div id="previewPhotos" class="upload_preview">
								<!-- <img alt="图片浏览" src=""> -->
                            </div>
                        </div>
                        <div class="upload_submit">
                            <button type="submit" id="editPhotoSubmit" class="upload_submit_btn">确定</button>
                           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button class="upload_cancel_btn" id="editwin-close">取消</button>
                        </div>
                        <div id="uploadInf" class="upload_inf"></div>
                    </div>
				</div>
				</div>
     	</form>
	 </div>  
     <div id="edit-win" title="旅行景点" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:620px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">旅行景点</div> -->
					<div class="fitem">
						<label>景点名称:</label><input name="item" type="text" maxlength="255" class="easyui-textbox" data-options="required:true" missingMessage="请填写项目名称">
						<span style="color:red">*</span>
					</div>
					<div class="fitem">
						<label>所属省市:</label>
						  <input name="scope" class="easyui-combobox"  data-options="width:131,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas',onShowPanel:function(){$(this).combobox('panel').height(300);}">  
					</div>
					<div class="fitem">
						<label>简略描述:</label><input name="shortContent" type="text" maxlength="255" class="easyui-textbox" data-options="prompt:'请填写简略描述'" ><span style="color:red">*</span>
					</div>	
					<div class="fitem">
					<label class="ui-label">热门度:</label>
						<select name="starLevel" class="easyui-combobox"  data-options="width:131,editable:false">
							<option value="">--请选择--</option>
							<option value="5">五星</option>
							<option value="4">四星</option>
							<option value="3">三星</option>
							<option value="2">两星</option>
							<option value="1">一星</option>
						</select>	
					</div>
					<div class="fitem">
						<label>海&nbsp;&nbsp;拔:</label><input name="elevation" type="text" maxlength="" class="easyui-numberbox" data-options="precision:2,groupSeparator:',',editable:false" missingMessage="请填写elevation">
					</div>
				  	<div class="fitem">
						<label id="rankLabel">推荐指数:</label>
					</div>  
					<div class="fitem"><input type="hidden" name="ticketsBlock" /><input type="hidden" name="fullyearTicket" />
					<label id="rankLabel">门票信息: </label><span><input type="radio" name="isfullyearTicket" value="0">全年票价不变 
						<input type="radio" name="isfullyearTicket" value="1" >区分淡旺季</span>
						<div id="fullyearTicketdiv"><table><tr><td colspan=2>全年门票信息</td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr></table></div>
						<div id="devideTicketdiv"><table><tr><td colspan=2>淡季门票信息</td><td></tr>
						<tr><td style="text-align:left" colspan=2><select name="freebeginMonth" id="freebeginMonth" class='easyui-combobox' data-options="editable:false,width:60,prompt:'月份'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>
						<select name="freebeginDate" id="freebeginDate" class='easyui-combobox' data-options="editable:false,width:60,prompt:'日期'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option>
						<option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
						<option value="31">31</option></select>到
						<select name="freeendMonth" id="freeendMonth" class='easyui-combobox' data-options="editable:false,width:60,prompt:'月份'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>
						<select name="freeendDate" id="freeendDate" class='easyui-combobox' data-options="editable:false,width:60,prompt:'日期'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option>
						<option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
						<option value="31">31</option></select></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox"  title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr></table>
						<table><tr><td colspan=2>旺季门票信息</td></tr>
					    <tr><td style="text-align:left" colspan=2>
					    <select name="busybeginMonth" id="busybeginMonth" class='easyui-combobox' data-options="editable:false,width:60,prompt:'月份'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>
						<select name="busybeginDate" id="busybeginDate" class='easyui-combobox' data-options="editable:false,width:60,prompt:'日期'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option>
						<option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
						<option value="31">31</option></select>到
						<select name="busyendMonth" id="busyendMonth" class='easyui-combobox' data-options="editable:false,width:60,prompt:'月份'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option></select>
						<select name="busyendDate" id="busyendDate" class='easyui-combobox' data-options="editable:false,width:60,prompt:'日期'"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option>
						<option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
						<option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option>
						<option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option>
						<option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
						<option value="31">31</option></select></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr>
						<tr><td><input type="text" class="easyui-textbox" title="门票" data-options="prompt:'门票'" name="tickets"/></td><td><input type="text" class="easyui-numberbox" title="门票价格" data-options="prompt:'门票价格'" name="ticketprices"/></td></tr></table></div>
						<div></div>
					</div>
<!-- 					<div class="fitem">
						<label>里&nbsp;&nbsp;程:</label><input name="mileage" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写mileage">
					</div> -->
					<div class="fitem">
						<label>具体介绍:</label><textarea rows="7" cols="30" name="content" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:205,height:130" missingMessage="请填写具体介绍"></textarea>
					</div> 
<!-- 					<div class="fitem">
						<label>推荐原因:</label><input name="recommandReason" type="text" maxlength="512" class="easyui-validatebox" data-options="" missingMessage="请填写recommandReason">
					</div>
					<div class="fitem">
						<label>建议天数:</label><input name="rcdDays" type="text" maxlength="" class="easyui-numberbox" data-options="" missingMessage="请填写rcdDays">
					</div>
					<div class="fitem">
						<label id="difficultyRateLabel">挑战度:</label>
					</div>
					<div class="fitem">
						<label id="happyLabel">好玩值:</label>
					</div>
					<div class="fitem">
						<label id="rucrowd">建议人群:</label>
					</div> -->
					<div class="fitem">
						<label>备注(提醒建议):</label><textarea rows="7" cols="30" name="remark" maxlength="500" class="easyui-textbox"  data-options="multiline:true,width:205,height:130" missingMessage="请填写remark"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
<script type="text/javascript" src="${basePath}/js/ux/sys/travelItem.js"></script>		  
  </body>
</html>
