$package('itour.adFootLink');
itour.adFootLink = function(){
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
				{"btnName":"添加","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74B","actionUrls":"adLink/save","btnType":"add"},
				{"btnName":"修改","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74B","actionUrls":"adLink/getId|adLink/save","btnType":"edit"},
				{"btnName":"删除","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74B","actionUrls":"adLink/logicdelete","btnType":"logicremove"},
				{"btnName":"物理删除","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74B","actionUrls":"adLink/delete","btnType":"remove"}
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
	   			url:'adLink/dataFootList.json',
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
					/*	{field:'advertise',title:'链接图片',align:'center',sortable:true,width:'300',
							formatter:function(value,row,index){
								return row.advertise;
							}
						},*/
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
						{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'},
						{id:'btndelete',text:'物理删除',btnType:'remove'}
			     	]
			}
		},
		init:function(){
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
	 /* if (window != top)
          top.location.href = location.href;*/
	itour.adFootLink.init();
});