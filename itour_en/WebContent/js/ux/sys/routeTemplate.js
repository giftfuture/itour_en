$package('itouren.routeTemplate');
itouren.routeTemplate = function(){
	var _box = null;
	var photoszxxfile = null;
	var _this = {
			uploadCoverAction:'routeTemplate/uploadCover',
			uploadCoverForm:function(){
				return $("#uploadCoverForm");
			},
			uploadCoverWin:function(){//upload-photo
				return $("#uploadCover-photo");
			},
			saveuploadCover:function(){
					itouren.progress();//缓冲条
					_this.uploadCoverForm().attr('action',_this.uploadCoverAction);
					_this.uploadCoverForm().ajaxForm();
					itouren.saveForm(_this.uploadCoverForm(),function(data){
						///console.log(data);
						//if(data.success){	
							itouren.alert('提示', data.msg||'Cover picture saved successfully!', 'info',function(){								
								itouren.closeProgress();//关闭缓冲条
								_box.handler.refresh();
								$("#coverpreview",this.uploadCoverWin).html('');
								_this.uploadCoverForm().resetForm();
								_this.uploadCoverWin().dialog('close');
							})
						//}
					});
			},
			inituploadCoverForm:function(){
				_this.uploadCoverWin().find("#coverSubmit").click(function(){
					_this.saveuploadCover();
				});
				_this.uploadCoverWin().find("#coverwin-close").click(function(){	
					$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
					    if (r){  
						$("#coverpreview",this.uploadCoverWin).html('');
					     	_this.uploadCoverWin().dialog('close');
					    }  
					});
				});
			},
			
			uploadMapAction:'routeTemplate/uploadMap',
			uploadMapForm:function(){
				return $("#uploadMapForm");
			},
			uploadMapWin:function(){
				return $("#upload-map");
			},
			saveMap:function(){
					itouren.progress();//缓冲条
					_this.uploadMapForm().attr('action',_this.uploadMapAction);
					_this.uploadMapForm().ajaxForm();
					itouren.saveForm(_this.uploadMapForm(),function(data){
						///console.log(data);
						//if(data.success){	
						itouren.alert('提示', data.msg||'地图保存成功！', 'info',function(){								
								itouren.closeProgress();//关闭缓冲条
								_box.handler.refresh();
								$("#mappreview",this.uploadMapWin).html('');
								_this.uploadMapForm().resetForm();
								_this.uploadMapWin().dialog('close');
							})
						//}
					});
			},
			initUploadMapForm:function(){
				_this.uploadMapWin().find("#mapSubmit").click(function(){
					_this.saveMap();
				});
				_this.uploadMapWin().find("#mapwin-close").click(function(){	
					$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
					    if (r){  
						$("#mappreview",this.uploadMapWin).html('');
					     	_this.uploadMapWin().dialog('close');
					    }  
					});
				});
			},
			uploadPhotoAction:'routeTemplate/uploadPhotos',
			uploadPhotoForm:function(){
				return $("#uploadPhotoForm");
			},
			uploadPhotoWin:function(){
				return $("#upload-photo");
			},
			savePhoto:function(){
					itouren.progress();//缓冲条
					_this.uploadPhotoForm().attr('action',_this.uploadPhotoAction);
					_this.uploadPhotoForm().ajaxForm();
					itouren.saveForm(_this.uploadPhotoForm(),function(data){
						///console.log(data);
						//if(data.success){	
							$.messager.alert('提示', data.msg, 'info',function(){								
								itouren.closeProgress();//关闭缓冲条
								_box.handler.refresh();
								$("#preview",this.uploadPhotoWin).html('');
								_this.uploadPhotoForm().resetForm();
								_this.uploadPhotoWin().dialog('close');
							})
						//}
					});
			},
			initUploadForm:function(){
				_this.uploadPhotoWin().find("#fileSubmit").click(function(){
					_this.savePhoto();
				});
				_this.uploadPhotoWin().find("#win-close").click(function(){	
					$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
					    if (r){  
						$("#preview",this.uploadPhotoWin).html('');
					     	_this.uploadPhotoWin().dialog('close');
					    }  
					});
				});
			},
			
			toList:function(parentId){
				_box.form.search.resetForm();
				if(parentId){
					$('#search_parentId').val(parentId);
					$('#btnback').linkbutton('enable');
					_box.grid.datagrid('hideColumn','childMenus');
				}else{
					$('#btnback').linkbutton('disable');
					_box.grid.datagrid('showColumn','childMenus');
				}
				_box.handler.refresh();
		},
		//设置默认按钮数据
		addDefBtns:function(){
			var defaultBtns= [
				{"btnName":"添加","menuid":"74BDAEA713D841549B840E502C4F150B","actionUrls":"routeTemplate/save","btnType":"add"},
				{"btnName":"修改","menuid":"74BDAEA713D841549B840E502C4F150B","actionUrls":"routeTemplate/getId|routeTemplate/save","btnType":"edit"},
				{"btnName":"删除","menuid":"74BDAEA713D841549B840E502C4F150B","actionUrls":"routeTemplate/logicdelete","btnType":"logicremove"},
				{"btnName":"物理删除","menuid":"74BDAEA713D841549B840E502C4F150B","actionUrls":"routeTemplate/delete","btnType":"remove"}
			];
			var tbline = $(".tb-line:visible");
			var btnType = $("input[name='btnType']",tbline);
			$.each(defaultBtns,function(i,btn){
				var isExists = false;
				//判断按钮类型是否存在
				if(btnType.length > 0){
					for(var i =0; i < btnType.length; i++){
						if(btnType.eq(i).val() == btn.btnType){
							isExists = true;
							break;
						}
					}
				}
				if(!isExists){
					_this.addLine(btn);
				}
			});
		},
		addLine: function(data){
			var table = $("#btn-tb");
			var	html = "<tr class='tb-line'>";
			html+=	   "	<td align='center'><span  class='newFlag red'>*</span></td>";
			html+=	   "	<td><input name=\"btnName\" class=\"easyui-textbox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
			html+=	   "	<td><input name=\"btnType\" class=\"easyui-textbox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
			html+=	   "	<td><input name=\"actionUrls\" class=\"easyui-textbox text-desc\" style=\"width:100%\"  ></td>";
			html+=	   "	<td align='center'><a class=\"easyui-linkbutton remove-btn\"  iconCls=\"icon-remove\" plain=\"true\"></a>";
			html+=	   "	<input class=\"hidden\" name=\"btnId\">";
			html+=	   "	<input class=\"hidden\" name=\"deleteFlag\">";
			html+=	   "	</td>";
			html+=	   "</tr>";
			var line = $(html);
			//版定删除按钮事件
			$(".remove-btn",line).click(function(){
				itouren.confirm('提示','你确定删除当前记录吗?',function(r){
					if(r){
						_this.delLine(line);
					}
				})
			});
			if(data){
				if(data.id){
					$(".newFlag",line).html(''); //清空新增标记
				}
				$("input[name='btnId']",line).val(data.id);
				$("input[name='btnName']",line).val(data.btnName);
				$("input[name='btnType']",line).val(data.btnType);
				$("input[name='actionUrls']",line).val(data.actionUrls);
			}
			$.parser.parse(line);//解析esayui标签
			table.append(line);
		},
		//删除全部
		delAllLine:function(b){
			if(b){
				$(".tb-line").remove();
			}else{
				$(".tb-line").each(function(i,line){
					_this.delLine($(line));
				});
			}
		},
		//删除单行
		delLine:function(line){
			if(line){
		 		var btnId = $("input[name='btnId']",line).val();
				if(btnId){
					$("input[name='deleteFlag']",line).val(1); //设置删除状态
					line.fadeOut();
				}else{
					line.fadeOut("fast",function(){
						 $(this).remove();
					});
				}
			}
		},
	config:{
		event:{
			/*add:function(){
				$('#typeIds_combobox').combobox('reload');
				_box.handler.add();
			},
			edit:function(){
				$('#typeIds_combobox').combobox('reload');
				_box.handler.edit();
			}*/
			add : function(){
					_this.delAllLine(true);//清空已有的数据
					_box.handler.add();//调用add方法
				var parentId =$('#search_parentId').val();
				if(parentId){
					$("#edit_parentId").val(parentId);
				}
			},
			edit:function(){
				_this.delAllLine(true);
				_box.handler.edit(function(result){
					$.each(result.data.btns,function(i,btn){
						_this.addLine(btn);
					});
				});
			}
			
		},
		action:{
				save:'routeTemplate/save', //新增&修改 保存Action  
				getId:'routeTemplate/getId',//编辑获取的Action
				uploadPhoto:'routeTemplate/uploadPhoto',
				logicremove:'routeTemplate/logicdelete',//逻辑删除Action
				remove:'routeTemplate/delete'//删除数据的Action
			},
  			dataGrid:{
  				title:'路线模板',
	   			url:'routeTemplate/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
			/*		{field:'customerId',title:'客户ID',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.customerId;
						}
					},*/
					{field:'quotoFormquotoForm',title:'路线编辑',align:'center',sortable:true,
						formatter:function(value,row,index){
							return '<a href="'+basePath+'routeTemplate/quoteEdit?id='+row.id+'">路线编辑</a>';
						}
					},
					{field:'routeCode',title:'线路编号',align:'center',sortable:true,//线路编号
						formatter:function(value,row,index){
							return row.routeCode;
						}
					},
					{field:'title',title:'线路名称',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.title+"").length>30){
								return (row.title+"").substring(0,30)+"....";
							}else{									
								return row.title;
							}
						}
					},
					{field:'levelarea',title:'路线区域',align:'center',sortable:true,
						formatter:function(value,row,index){
							return '<a href="'+basePath+'levelarea/list/'+row.id+'">路线区域</a>';
						}
					},
					{field:'cover',title:'封面',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.cover;
						}
					},
					{field:'viewphotos',title:'美图',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.viewphotos+"").length>60){
								return (row.viewphotos+"").substring(0,60)+"....";
							}else{									
								return row.viewphotos;
							}
						}
					},
					{field:'starLevel',title:'星级',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(parseInt(row.starLevel)==5){
								return "五星";
							}else if(parseInt(row.starLevel)==4){
								return "四星";
							}else if(parseInt(row.starLevel)==3){
								return "三星";
							}else if(parseInt(row.starLevel)==2){
								return "二星";
							}else if(parseInt(row.starLevel)==1){									
								return "一星";
							}
						}
					},
				/*	{field:'quotoForm',title:'详细日程',align:'center',sortable:true,
						formatter:function(value,row,index){
							return '<a href="'+basePath+'routeTemplate/rtschedule?id='+row.id+'">详细日程</a>';
						}
					},*/
				/*	{field:'level1Area',title:'一级区域',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.level1Area;
						}
					},
					{field:'level2Area',title:'二级区域',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.level2Area;
						}
					},*/
					{field:'rcdDays',title:'(建议)游览时间(天)',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.rcdDays;
						}
					},
					{field:'elevation',title:'最高海拔(米)',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.elevation;
						}
					},
					{field:'mileage',title:'里程(公里)',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.mileage;
						}
					},
					{field:'departure',title:'出发地',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.departure+"").length>30){
								return (row.departure+"").substring(0,30)+"....";
							}else{									
								return row.departure;
							}
						}
					},
					{field:'arrive',title:'完成地',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.arrive+"").length>30){
								return (row.arrive+"").substring(0,30)+"....";
							}else{									
								return row.arrive;
							}
						}
					},
					{field:'transportation',title:'交通工具',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.transportation+"").length>30){
								return (row.transportation+"").substring(0,30)+"....";
							}else{									
								return row.transportation;
							}
						}
					},
					{field:'trekDistance',title:'徒步里程(公里)',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.trekDistance;
						}
					},
					{field:'mountStyle',title:'山峰类型',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.mountStyle+"").length>30){
								return (row.mountStyle+"").substring(0,30)+"....";
							}else{									
								return row.mountStyle;
							}
						}
					},
					{field:'shortContent',title:'简略内容',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.shortContent+"").length>30){
								return (row.shortContent+"").substring(0,30)+"....";
							}else{									
								return row.shortContent;
							}
						}
					},
					{field:'special',title:'特色介绍',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.special+"").length>30){
								return (row.special+"").substring(0,30)+"....";
							}else{									
								return row.special;
							}
						}
					},
					{field:'relatedRouteTitles',title:'相关线路',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.relatedRouteTitles;
						}
					},
				/*	{field:'similars',title:'相似线路',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.similars;
						}
					},*/
					{field:'routeMap',title:'路线地图',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.routeMap;
						}
					},
					{field:'travelStyle',title:'线路类别',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.travelStyle;
						}
					},
					{field:'travelItems',title:'包含景点',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.travelItems;
						}
					},
					{field:'difficultyRate',title:'旅行难度',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(value == 0){
								return "热身难度";
							}
							if(value == 1){
								return "一般难度";
							}
							if(value == 2){
								return "略有挑战";								
							}
							if(value == 3){
								return "难度适中";
							}
							if(value == 4){
								return "是个难关";							
							}
							if(value == 5){
								return "难度爆表";
							}else{									
								if((row.difficultyRate+"").length>30){
									return (row.difficultyRate+"").substring(0,30)+"....";
								}else{									
									return row.difficultyRate;
								}
							}
						}
					},
					{field:'createTime',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					{field:'createBy',title:'创建人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createBy;
							}
						},
					{field:'updateTime',title:'更新时间',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.updateTime;
						}
					},		
					{field:'updateBy',title:'更新人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateBy;
							}
						},
					{field:'remark',title:'备注',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.remark+"").length>30){
									return (row.remark+"").substring(0,30)+"....";
								}else{									
									return row.remark;
								}
							}
						}
					]],
					toolbar:[
								{id:'btnadd',text:'添加',btnType:'add'},
								{id:'btnedit',text:'修改',btnType:'edit'},
								{id:'btndelete',text:'物理删除',btnType:'remove'},
								{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'},
								{id:'btnedit',text:'上传封面',btnType:'upload',iconCls:'icon-large-picture',handler:function(){
									var selected = _box.utils.getCheckedRows();
									if (_box.utils.checkSelectOne(selected)){
										_this.uploadCoverForm().resetForm();
										_this.uploadCoverForm().find("input[name='id']").val(selected[0].id);
										_this.uploadCoverWin().window('open'); 		
									}
								}},
								{id:'btnedit',text:'上传地图',btnType:'upload',iconCls:'icon-large-picture',handler:function(){
									var selected = _box.utils.getCheckedRows();
									if (_box.utils.checkSelectOne(selected)){
										_this.uploadMapForm().resetForm();
										_this.uploadMapForm().find("input[name='id']").val(selected[0].id);
										_this.uploadMapWin().window('open'); 		
									}
								}},
								{id:'btnedit',text:'上传图片',btnType:'upload',iconCls:'icon-large-picture',handler:function(){
									var selected = _box.utils.getCheckedRows();
									if (_box.utils.checkSelectOne(selected)){
										_this.uploadPhotoForm().resetForm();
										_this.uploadPhotoForm().find("input[name='id']").val(selected[0].id);
										_this.uploadPhotoWin().window('open'); 		
									}
								}}
							]
			}
		},
		coverparams:{
			fileInput: $("#coverImage",this.uploadCoverWin).get(0),
		//	dragDrop: $("#fileDragArea").get(0),
			upButton: $("#coverSubmit",this.uploadCoverWin).get(0),
			url: 'routeTemplate/uploadCover',// _this.config.action.uploadPhoto,//
			onSelect: function(files) {
				//console.log(files[0]);
				var html = '',i = 0;
				$("#coverpreview",this.uploadCoverWin).html('<div class="upload_loading"></div>');
				var funAppendImage = function() {
					file = files[i];
					if(file) {
						var reader = new FileReader();
						reader.onload = function(e) {
							//if(i==0){
								html = html + '<div id="coveruploadList_'+ i +'" class="upload_append_list"><p><strong></strong>'+ 
								'<img id="coveruploadImage_' + i + '" title="' +file.name + '"  src="' + e.target.result + '" class="upload_image" /></p>'+ 
								'<span id="coveruploadProgress_' + i + '" class="upload_progress"></span>' +
								'</div>';
								i++;
								funAppendImage();
							//}
						}
						reader.readAsDataURL(file);
					} else {
						//console.log(html);
						$("#coverpreview",this.uploadCoverWin).html(html);
						if (html) {
							//提交按钮显示
							$("#coverSubmit",this.uploadCoverWin).show();	
						} else {
							//提交按钮隐藏
							$("#coverSubmit",this.uploadCoverWin).hide();	
						}
					}
				
				};
				funAppendImage();		
			},
			onDelete: function(file) {
				$("#coveruploadList_" + file.index,this.uploadCoverWin).fadeOut();
			},
			onDragOver: function() {
				$(this).addClass("upload_drag_hover");
			},
			onDragLeave: function() {
				$(this).removeClass("upload_drag_hover");
			},
			onProgress: function(file, loaded, total) {
				var eleProgress = $("#coveruploadProgress_" + file.index,this.uploadCoverWin), percent = (loaded / total * 100).toFixed(2) + '%';
				eleProgress.show().html(percent);
			},
			onSuccess: function(file, response) {
				$("#coveruploadInf",this.uploadCoverWin).append("<p>封面图片"+file.name+"上传成功，"  + response + "</p>");
				$("#coverpreview",this.uploadCoverWin).html('');
				Grid.datagrid('reload',param);
				_this.config.datagrid('reload',param);
			   Form.uploadCoverForm.resetForm();
			},
			onFailure: function(file) {
				$("#coveruploadInf",this.uploadCoverWin).append("<p>封面图片" + file.name + "上传失败！</p>");	
				$("#uploadImage_" + file.index,this.uploadCoverWin).css("opacity", 0.2);
				$("#coverpreview",this.uploadCoverWin).html('');
			},
			onComplete: function() {
				//提交按钮隐藏
				$("#coverSubmit",this.uploadCoverWin).hide();
				//file控件value置空
				$("#coverImage",this.uploadCoverWin).val("");
				$("#coveruploadInf",this.uploadCoverWin).append("<p>当前图片上传完毕。</p>");
				$("#coverpreview",this.uploadCoverWin).html('');
			}
		},
		mapparams:{
			fileInput: $("#mapfile",this.uploadMapWin).get(0),
		//	dragDrop: $("#fileDragArea").get(0),
			upButton: $("#mapSubmit",this.uploadMapWin).get(0),
			url: 'routeTemplate/uploadMap',
			onSelect: function(files) {
				//console.log(files[0]);
				var html = '',i = 0;
				$("#mappreview",this.uploadMapWin).html('<div class="upload_loading"></div>');
				var funAppendImage = function() {
					file = files[i];
					if (file) {
						var reader = new FileReader();
						reader.onload = function(e) {
							if(i==0){
								html = html + '<div id="mapuploadList_'+ i +'" class="upload_append_list"><p><strong></strong>'+ 
								'<img id="mapuploadImage_' + i + '" title="' +file.name + '"  src="' + e.target.result + '" class="upload_image" /></p>'+ 
								'<span id="mapuploadProgress_' + i + '" class="upload_progress"></span>' +
								'</div>';
								i++;
								funAppendImage();
							}
						}
						reader.readAsDataURL(file);
					} else {
						$("#mappreview",this.uploadMapWin).html(html);
						if (html) {
							//提交按钮显示
							$("#mapSubmit",this.uploadMapWin).show();	
						} else {
							//提交按钮隐藏
							$("#mapSubmit",this.uploadMapWin).hide();	
						}
					}
				};
				funAppendImage();		
			},
			onDelete: function(file) {
				$("#mapuploadList_" + file.index,this.uploadMapWin).fadeOut();
			},
			onDragOver: function() {
				$(this).addClass("upload_drag_hover");
			},
			onDragLeave: function() {
				$(this).removeClass("upload_drag_hover");
			},
			onProgress: function(file, loaded, total) {
				var eleProgress = $("#mapuploadProgress_" + file.index,this.uploadMapWin), percent = (loaded / total * 100).toFixed(2) + '%';
				eleProgress.show().html(percent);
			},
			onSuccess: function(file, response) {
				$("#mapuploadInf",this.uploadMapWin).append("<p>路线地图"+file.name+"上传成功，"  + response + "</p>");
				$("#mappreview",this.uploadMapWin).html('');
				Grid.datagrid('reload',param);
				_this.config.datagrid('reload',param);
			   Form.uploadMapForm.resetForm();
			},
			onFailure: function(file) {
				$("#mapuploadInf",this.uploadMapWin).append("<p>路线地图" + file.name + "上传失败！</p>");	
				$("#mapuploadImage_" + file.index,this.uploadMapWin).css("opacity", 0.2);
				$("#mappreview",this.uploadMapWin).html('');
			},
			onComplete: function() {
				//提交按钮隐藏
				$("#mapSubmit",this.uploadMapWin).hide();
				//console.log("<p>当前地图图片上传完毕。</p>");
				//file控件value置空
				$("#mapfile",this.uploadMapWin).val("");
				$("#mapuploadInf",this.uploadMapWin).append("<p>当前地图上传完毕。</p>");
				$("#mappreview",this.uploadMapWin).html('');
			}
		},
		photosparams:{
			fileInput: $("#fileImage",this.uploadPhotoWin).get(0),
		//	dragDrop: $("#fileDragArea").get(0),
			upButton: $("#fileSubmit",this.uploadPhotoWin).get(0),
			url: 'routeTemplate/uploadPhotos',// _this.config.action.save,
			onSelect: function(files) {
				var html = '', i = 0;
				$("#preview",this.uploadPhotoWin).html('<div class="upload_loading"></div>');
				var funAppendImage = function() {
					file = files[i];
					if (file) {
						var reader = new FileReader();
						reader.onload = function(e) {
							html = html + '<div id="uploadList_'+ i +'" class="upload_append_list"><p><strong></strong>'+ 
								'<a href="javascript:" class="upload_delete" title="删除" data-index="'+ i +'">删除</a><br />' +
								'<img id="uploadImage_' + i + '" title="' +file.name + '"  src="' + e.target.result + '" class="upload_image" /></p>'+ 
								'<span id="uploadProgress_' + i + '" class="upload_progress"></span>' +
							'</div>';
							i++;
							funAppendImage();
						}
					//	console.log(file);
						reader.readAsDataURL(file);
					} else {
						//console.log(html);
						$("#preview",this.uploadPhotoWin).html(html);
						if (html) {
							//删除方法
							$(".upload_delete",this.uploadPhotoWin).click(function() {
								photoszxxfile.funDeleteFile(files[parseInt($(this).attr("data-index"))]);
								this.onDelete(files[parseInt($(this).attr("data-index"))]);
								return false;	
							});
							//提交按钮显示
							$("#fileSubmit",this.uploadPhotoWin).show();	
						} else {
							//提交按钮隐藏
							$("#fileSubmit",this.uploadPhotoWin).hide();	
						}
					}
				};
				funAppendImage();		
			},//viewPhotoForm
			onDelete: function(file) {
				$("#uploadList_" + file.index,this.uploadPhotoWin).fadeOut();
				$("#uploadList_"+file.index,this.uploadPhotoWin).remove();
				var remhtml = $("#preview",this.uploadPhotoWin).html();
				if(!remhtml){
					$("#fileSubmit",this.uploadPhotoWin).hide();
				}
			},
			onDragOver: function() {
				$(this).addClass("upload_drag_hover");
			},
			onDragLeave: function() {
				$(this).removeClass("upload_drag_hover");
			},
			onProgress: function(file, loaded, total) {
				var eleProgress = $("#uploadProgress_" + file.index,this.uploadPhotoWin), percent = (loaded / total * 100).toFixed(2) + '%';
				eleProgress.show().html(percent);
			},
			onSuccess: function(file, response) {
				$("#uploadInf",this.uploadPhotoWin).append("<p>图片"+file.name+"上传成功，"  + response + "</p>");
				$("#preview",this.uploadPhotoWin).html('');
				Grid.datagrid('reload',param);
				_this.config.datagrid('reload',param);
			   Form.uploadPhotoForm.resetForm();
			},
			onFailure: function(file) {
				$("#uploadInf",this.uploadPhotoWin).append("<p>图片" + file.name + "上传失败！</p>");	
				$("#uploadImage_" + file.index,this.uploadPhotoWin).css("opacity", 0.2);
				$("#preview",this.uploadPhotoWin).html('');
			},
			onComplete: function() {
				//提交按钮隐藏
				$("#fileSubmit",this.uploadPhotoWin).hide();
				//file控件value置空
				$("#fileImage",this.uploadPhotoWin).val("");
				$("#preview",this.uploadPhotoWin).html('');
				$("#uploadInf",this.uploadPhotoWin).append("<p>当前图片全部上传完毕，可继续添加上传。</p>");
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			var zxxfile = $.extend(ZXXFILE,this.coverparams);
			zxxfile.init();
			var zxxmapfile = $.extend(uploadFile,this.mapparams);
			zxxmapfile.init(); 
			photoszxxfile =  $.extend(uploadPhotos,this.photosparams);
			photoszxxfile.init();
			this.inituploadCoverForm();
			this.initUploadMapForm(); 
			this.initUploadForm();
			$('#addLine_btn').click(_this.addLine);
			$('#addDefLine_btn').click(_this.addDefBtns);
			$('#delAllLine_btn').click(function(){
				itouren.confirm('提示','你确定删除当前记录吗?',function(r){
					_this.delAllLine(false);
				});
			});
			$("#travelItems").combobox({
				url:'travelItem/allItems',
				valueField:'alias',
				textField:'item',
				multiple:true,
				method:'get',
			    editable : false  ,
				formatter:function(row){
				   var s = "<span><input type='checkbox' class='selectId' style='vertical-align: middle' id='selectId_"+row.alias+"' value="+row.alias+">"+row.item+"<span>"
				   return s;  
				},
				onSelect:function(record){
					$("#selectId_"+record.alias).attr("checked", true);
				},
				onUnselect:function(record){
					$("#selectId_"+record.alias).attr("checked", false);
				}
			});
			$("#related").combobox({
				url:'routeTemplate/queryAll',
			    editable : false,
				valueField:'routeCode',
				textField:'title',
				multiple:true,
				method:'get',
				formatter:function(row){
				   var s = "<span><input type='checkbox' class='selectId' style='vertical-align: middle' id='selectId_"+row.routeCode+"' value="+row.routeCode+">"+row.title+"<span>"
				   return s;  
				},
				onSelect:function(record){
					$("#selectId_"+record.routeCode).attr("checked", true);
				},
				onUnselect:function(record){
					$("#selectId_"+record.routeCode).attr("checked", false);
				}
			});
		    $('#designConcept').summernote({  
		        height: 400,                  
		        minHeight: 300,   
		        maxHeight: 500,        
		        popover:{},
		       // focus: true,   
		        lang:'en-US',   
		        dialogsFade : false,// Add fade effect on dialogs
		        dialogsInBody : false,// Dialogs can be placed in body, not in summernote.
		        shortcuts:false,
		        disableDragAndDrop:true,
		        placeholder:'write here...',
		      /*  callbacks: { 
			        onImageUpload: function(files, editor, $editable) {  
			        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
			        }
		        },*/codemirror: {
		            theme: 'monokai'
		        },toolbar: [  
		                    ['style', ['bold', 'italic', 'underline', 'clear']],  
		                    ['fontsize', ['fontsize']],  
		                    ['color', ['color']],  
		                    ['font', ['bold', 'underline', 'clear']],
		                    ['fontname', ['fontname']],
		                    ['para', ['ul', 'ol', 'paragraph']],  
		                    ['height', ['height']],  
		                    ['table', ['table']],
		                    ['insert', ['link','picture', 'video','table','hr']] ,
		                    ['view', ['fullscreen', 'codeview', 'help']]
		                ],
		        fontNames: ['Microsoft YaHei ','Serif', 'Sans', 'Arial', 'Arial Black', 'Courier','Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande','Sacramento'],
		        colors: [
		                 ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
		                 ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
		                 ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
		                 ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
		                 ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
		                 ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
		                 ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
		                 ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
		               ]
		  }); 
		    $('#customizedService').summernote({  
		        height: 400,                  
		        minHeight: 300,             
		        maxHeight: 500,        
		       // focus: true,   
		        lang:'en-US',   
		        popover:{},
		        dialogsFade : false,// Add fade effect on dialogs
		        dialogsInBody : false,// Dialogs can be placed in body, not in summernote.
		        shortcuts:false,
		        disableDragAndDrop:true,
		        placeholder:'write here...',
		      /*  callbacks: { 
			        onImageUpload: function(files, editor, $editable) {  
			        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
			        }
		        },*/codemirror: {
		            theme: 'monokai'
		        },toolbar: [  
		                    ['style', ['bold', 'italic', 'underline', 'clear']],  
		                    ['fontsize', ['fontsize']],  
		                    ['color', ['color']],  
		                    ['font', ['bold', 'underline', 'clear']],
		                    ['fontname', ['fontname']],
		                    ['para', ['ul', 'ol', 'paragraph']],  
		                    ['height', ['height']],  
		                    ['table', ['table']],
		                    ['insert', ['link','picture', 'video','table','hr']] ,
		                    ['view', ['fullscreen', 'codeview', 'help']]
		                ],
		        fontNames: ['Microsoft YaHei ','Serif', 'Sans', 'Arial', 'Arial Black', 'Courier','Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande','Sacramento'],
		        colors: [
		                 ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
		                 ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
		                 ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
		                 ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
		                 ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
		                 ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
		                 ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
		                 ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
		               ]
		  }); 
		    $('#beforeInstruction').summernote({  
		        height: 400,                  
		        minHeight: 300,             
		        maxHeight: 500, 
		        popover:{},
		       // focus: true,   
		        lang:'en-US',   
		        dialogsFade : false,// Add fade effect on dialogs
		        dialogsInBody : false,// Dialogs can be placed in body, not in summernote.
		        shortcuts:false,
		        disableDragAndDrop:true,
		        placeholder:'write here...',
		      /*  callbacks: { 
			        onImageUpload: function(files, editor, $editable) {  
			        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
			        }
		        },*/codemirror: {
		            theme: 'monokai'
		        },toolbar: [  
		                    ['style', ['bold', 'italic', 'underline', 'clear']],  
		                    ['fontsize', ['fontsize']],  
		                    ['color', ['color']],  
		                    ['font', ['bold', 'underline', 'clear']],
		                    ['fontname', ['fontname']],
		                    ['para', ['ul', 'ol', 'paragraph']],  
		                    ['height', ['height']],  
		                    ['table', ['table']],
		                    ['insert', ['link','picture', 'video','table','hr']] ,
		                    ['view', ['fullscreen', 'codeview', 'help']]
		                ],
		        fontNames: ['Microsoft YaHei ','Serif', 'Sans', 'Arial', 'Arial Black', 'Courier','Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande','Sacramento'],
		        colors: [
		                 ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
		                 ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
		                 ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
		                 ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
		                 ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
		                 ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
		                 ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
		                 ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
		               ]
		  }); 
		    $('#beforeInstruction').summernote({  
		        height: 400,                  
		        minHeight: 300,             
		        maxHeight: 500,        
		       // focus: true,   
		        lang:'en-US',   
		        popover:{},
		        dialogsFade : false,// Add fade effect on dialogs
		        dialogsInBody : false,// Dialogs can be placed in body, not in summernote.
		        shortcuts:false,
		        disableDragAndDrop:true,
		        placeholder:'write here...',
		      /*  callbacks: { 
			        onImageUpload: function(files, editor, $editable) {  
			        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
			        }
		        },*/codemirror: {
		            theme: 'monokai'
		        },toolbar: [  
		                    ['style', ['bold', 'italic', 'underline', 'clear']],  
		                    ['fontsize', ['fontsize']],  
		                    ['color', ['color']],  
		                    ['font', ['bold', 'underline', 'clear']],
		                    ['fontname', ['fontname']],
		                    ['para', ['ul', 'ol', 'paragraph']],  
		                    ['height', ['height']],  
		                    ['table', ['table']],
		                    ['insert', ['link','picture', 'video','table','hr']] ,
		                    ['view', ['fullscreen', 'codeview', 'help']]
		                ],
		        fontNames: ['Microsoft YaHei ','Serif', 'Sans', 'Arial', 'Arial Black', 'Courier','Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande','Sacramento'],
		        colors: [
		                 ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
		                 ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
		                 ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
		                 ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
		                 ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
		                 ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
		                 ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
		                 ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
		               ]
		  }); 
		}
	}
	return _this;
}();
$(function(){
	itouren.routeTemplate.init();
	/*  if (window != top)
          top.location.href = location.href;*/
});