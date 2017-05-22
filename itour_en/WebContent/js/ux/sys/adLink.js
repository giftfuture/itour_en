$package('itour.adLink');
itour.adLink = function(){
	var _box = null;
	var _this = {
			uploadPhotoAction:'adLink/uploadPhoto',
			uploadPhotoForm:function(){
				return $("#multiDataForm");
			},
			uploadPhotoWin:function(){//upload-photo
				return $("#upload-photo");
			},
			savePhoto:function(){
					itour.progress();//缓冲条
					_this.uploadPhotoForm().attr('action',_this.uploadPhotoAction);
					_this.uploadPhotoForm().ajaxForm();
					itour.saveForm(_this.uploadPhotoForm(),function(data){
						///console.log(data);
						//if(data.success){	
							$.messager.alert('提示', data.msg, 'info',function(){								
								itour.closeProgress();//关闭缓冲条
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
					     	_this.uploadPhotoWin().dialog('close');
					    }  
					});
				});
			},
			loadPhotoList:function(id){
				itour.loadPhotos('editPhoto',{'id':id},function(data){
					itour.closeProgress();
					var images = "";
					if(data.success){
						//console.log(data.uris);
						for(var i in data.uris){
						  images+='<img alt="图片浏览" src="'+basePath+data.uris[i]+'" style="width:50px;height:50px;">';	
						}
					}
					$("#previewPhotos").html(images);
					_this.editPhotoWin().dialog('open'); 
					//_this.editPhotoWin().window('open'); 
					//回调函数
					/*if(jQuery.isFunction(callback)){
						callback(result);
					}*/                        																									
				});
			},
		//设置默认按钮数据
		addDefBtns:function(){
			var defaultBtns= [
				{"btnName":"添加","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74A","actionUrls":"adLink/save","btnType":"add"},
				{"btnName":"修改","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74A","actionUrls":"adLink/getId|adLink/save","btnType":"edit"},
				{"btnName":"删除","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74A","actionUrls":"adLink/logicdelete","btnType":"logicremove"},
				{"btnName":"物理删除","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74A","actionUrls":"adLink/delete","btnType":"remove"}
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
			//html+=	   "	<td align='center'><span  class='newFlag red'>*</span></td>";
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
				itour.confirm('提示','你确定删除当前记录吗?',function(r){
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
			add:function(){
				_box.handler.add();
			},
			edit:function(){
				_box.handler.edit();
			},
			uploadImg:function(){
				_box.handler.uploadImg();
			}
		},
		action:{
				save:'adLink/save', //新增&修改 保存Action  
				getId:'adLink/getId',//编辑获取的Action
				remove:'adLink/delete',//删除数据的Action
				uploadPhoto:'adLink/uploadPhoto'
			},
  			dataGrid:{
  				title:'首页链接',
	   			url:'adLink/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'title',title:'链接名称',align:'left',sortable:true,width:'300',
						formatter:function(value,row,index){
							if((row.title+"").length>30){
								return '<a title="'+row.title+'">'+(row.title+"").substring(0,30)+'....</a>';
							}else{									
								return '<a title="'+row.title+'">'+row.title+'</a>';
							}
						}
					},
					{field:'adlink',title:'链接地址',align:'left',sortable:true,width:'400',
							formatter:function(value,row,index){
								if((row.adlink+"").length>80){
									return '<a title="'+row.adlink+'">'+(row.adlink+"").substring(0,80)+'....</a>';
								}else{									
									return '<a title="'+row.adlink+'">'+row.adlink+'</a>';
								}
							}
						},
						{field:'advertise',title:'链接图片',align:'center',sortable:true,width:'300',
							formatter:function(value,row,index){
								return row.advertise;
							}
						},
					{field:'remark',title:'备注',align:'left',sortable:true,width:'300',
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
						{id:'btnedit',text:'上传图片',btnType:'upload',iconCls:'icon-large-picture',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if (_box.utils.checkSelectOne(selected)){
								_this.uploadPhotoForm().resetForm();
								_this.uploadPhotoForm().find("input[name='id']").val(selected[0].id);
								_this.uploadPhotoWin().window('open'); 		
							}
						}},
						{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'},
						{id:'btndelete',text:'物理删除',btnType:'remove'}
			     	]
			}
		},
		params:{
			fileInput: $("#fileImage").get(0),
			//	dragDrop: $("#fileDragArea").get(0),
				upButton: $("#fileSubmit").get(0),
				url: 'adLink/uploadPhoto',// _this.config.action.uploadPhoto,//$("#uploadForm").attr("action"),
				filter: function(files) {
					var arrFiles = [];
					for (var i = 0, file; file = files[i]; i++) {
						if (file.type.indexOf("image") == 0) {
							if (file.size >= 5120000) {
								itour.alert('提示','您这张"'+ file.name +'"图片大小过大，应小于5M','info');	
							} else {
								arrFiles.push(file);	
							}			
						} else {
							itour.alert('提示','文件"' + file.name + '"不是图片。','info');	
						}
					}
					return arrFiles;
				},
				onSelect: function(files) {
					//console.log(files[0]);
					var html = '',i = 0;
					$("#preview").html('<div class="upload_loading"></div>');
					var funAppendImage = function() {
						file = files[i];
						if(file) {
							var reader = new FileReader();
							reader.onload = function(e) {
								if(i==0){
									html = html + '<div id="uploadList_'+ i +'" class="upload_append_list"><p><strong>' + file.name + '</strong>'+ 
									'<img id="uploadImage_' + i + '" src="' + e.target.result + '" class="upload_image" /></p>'+ 
									'<span id="uploadProgress_' + i + '" class="upload_progress"></span>' +
									'</div>';
									i++;
									funAppendImage();
								}
							}
							reader.readAsDataURL(file);
						} else {
							//console.log(html);
							$("#preview").html(html);
							if (html) {
								//提交按钮显示
								$("#fileSubmit").show();	
							} else {
								//提交按钮隐藏
								$("#fileSubmit").hide();	
							}
						}
					};
					funAppendImage();		
				},
				onDelete: function(file) {
					$("#uploadList_" + file.index).fadeOut();
				},
				onDragOver: function() {
					$(this).addClass("upload_drag_hover");
				},
				onDragLeave: function() {
					$(this).removeClass("upload_drag_hover");
				},
				onProgress: function(file, loaded, total) {
					var eleProgress = $("#uploadProgress_" + file.index), percent = (loaded / total * 100).toFixed(2) + '%';
					eleProgress.show().html(percent);
				},
				onSuccess: function(file, response) {
					$("#uploadInf").append("<p>封面图片"+file.name+"上传成功，"  + response + "</p>");
					Grid.datagrid('reload',param);
					_this.config.datagrid('reload',param);
				   Form.multiDataForm.resetForm();
				},
				onFailure: function(file) {
					$("#uploadInf").append("<p>封面图片" + file.name + "上传失败！</p>");	
					$("#uploadImage_" + file.index).css("opacity", 0.2);
				},
				onComplete: function() {
					//提交按钮隐藏
					$("#fileSubmit").hide();
					//file控件value置空
					$("#fileImage").val("");
					$("#uploadInf").append("<p>当前图片上传完毕。</p>");
				}
			},init:function(){
				this.initUploadForm();
				_box = new YDataGrid(_this.config); 
				_box.init();
				ZXXFILE = $.extend(ZXXFILE,this.params);
				ZXXFILE.init();
				$('#addLine_btn').click(_this.addLine);
				$('#addDefLine_btn').click(_this.addDefBtns);
				$('#delAllLine_btn').click(function(){
					itour.confirm('提示','你确定删除当前记录吗?',function(r){
						_this.delAllLine(false);
					});
				});
				
			}};
	return _this;
}();

$(function(){
	itour.adLink.init();
});