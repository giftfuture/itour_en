$package('itour.travelItem');
itour.travelItem = function(){
	var _box = null;
	var _this = {
			uploadCoverAction:'travelItem/uploadCover',
			uploadCoverForm:function(){
				return $("#uploadCoverForm");
			},
			uploadCoverWin:function(){//upload-photo
				return $("#uploadCover-photo");
			},
			saveuploadCover:function(){
				itour.progress();//缓冲条
				_this.uploadCoverForm().attr('action',_this.uploadCoverAction);
				_this.uploadCoverForm().ajaxForm();
				itour.saveForm(_this.uploadCoverForm(),function(data){
					///console.log(data);
					//if(data.success){	
						itour.alert('提示', data.msg, 'info',function(){								
							itour.closeProgress();//关闭缓冲条
							_box.handler.refresh();
							_this.uploadCoverForm().resetForm();
							_this.uploadCoverWin().dialog('close');
						})
					//}
				});
			},
			initUploadCoverForm:function(){
				/*var uploadCoverFile = $.extend(uploadFile,this.uploadCoverParams);
				uploadCoverFile.init(); */
				_this.uploadCoverWin().find("#fileSubmit").click(function(){
					_this.saveuploadCover();
				});
				_this.uploadCoverWin().find("#win-close").click(function(){	
					$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
					    if (r){  
					     	_this.uploadCoverWin().dialog('close');
					    }  
					});
				});
			},
			
			uploadPhotoAction:'travelItem/uploadPhoto',
			uploadPhotoForm:function(){
				return $("#uploadPhotoForm");
			},
			uploadPhotoWin:function(){
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
				/*var zxxfile = $.extend(ZXXFILE,this.uploadparams);
				zxxfile.init();*/
				//console.log(zxxfile.url);
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
			
			editPhotoAction:'travelItem/saveeditedPhoto',
			editPhotoForm:function(){
				return $("#editPhotoForm");
			},
			editPhotoWin:function(){//upload-photo
				return $("#edit-photo");
			},
			submitPhoto:function(){
				itour.progress();//缓冲条
				_this.editPhotoForm().attr('action',_this.editPhotoAction);
				itour.saveForm(_this.editPhotoForm(),function(data){
					itour.closeProgress();//关闭缓冲条
					_this.editPhotoWin().dialog('close');
				});
			},
			loadPhotoList:function(id){
				itour.loadPhotos('travelItem/editPhoto',{'id':id},function(data){
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
			initEditForm:function(){
				_this.editPhotoWin().find("#editPhotoSubmit").click(function(){
					_this.submitPhoto();
				});
				_this.editPhotoWin().find("#editwin-close").click(function(){	
					$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
					    if (r){  
					     	_this.editPhotoWin().dialog('close');
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
				{"btnName":"添加","menuid":"13","actionUrls":"travelItem/save","btnType":"add"},
				{"btnName":"修改","menuid":"13","actionUrls":"travelItem/getId|travelItem/save","btnType":"edit"},
				{"btnName":"删除","menuid":"13","actionUrls":"travelItem/logicdelete","btnType":"logicremove"},
				{"btnName":"物理删除","menuid":"13","actionUrls":"travelItem/delete","btnType":"remove"}
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
		delAllLine:function(b){//删除全部
			if(b){
				$(".tb-line").remove();
			}else{
				$(".tb-line").each(function(i,line){
					_this.delLine($(line));
				});
			}
		},
		delLine:function(line){//删除单行
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
				save:'travelItem/save', //新增&修改 保存Action  
				getId:'travelItem/getId',//编辑获取的Action
				remove:'travelItem/delete',//删除数据的Action
				uploadPhoto:'travelItem/uploadPhoto',
				uploadCover:'travelItem/uploadCover'
			},
  			dataGrid:{
  				title:'旅行项目',
	   			url:'travelItem/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'itemCode',title:'景点代码',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.itemCode+"").length>30){
								return (row.itemCode+"").substring(0,30)+"....";
							}else{									
								return row.itemCode;
							}
						}
					},
					{field:'item',title:'景点名称',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.item+"").length>30){
									return (row.item+"").substring(0,30)+"....";
								}else{									
									return row.item;
								}
							}
					},
					/*	{field:'hot',title:'是否热门',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(row.hot){
									return "是";
								}else{									
									return "否";
								}
							}
						},*/
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
					{field:'elevation',title:'海拔(千米)',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.elevation+"").length>30){
									return (row.elevation+"").substring(0,30)+"....";
								}else{									
									return row.elevation;
								}
							}
					},
					{field:'content',title:'详细描述',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.content+"").length>30){
									return (row.content+"").substring(0,30)+"....";
								}else{									
									return row.content;
								}
							}
					},
					{field:'cover',title:'封面',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.cover+"").length>30){
									return (row.cover+"").substring(0,30)+"....";
								}else{									
									return row.cover;
								}
							}
					},
					{field:'photos',title:'美图',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.photos+"").length>30){
									return (row.photos+"").substring(0,30)+"....";
								}else{									
									return row.photos;
								}
							}
					},
					{field:'mileage',title:'里程(公里)',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.mileage+"").length>30){
									return (row.mileage+"").substring(0,30)+"....";
								}else{									
									return row.mileage;
								}
							}
					},
					{field:'areaname',title:'所属区域',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.areaname;
							}
					},
					{field:'ticketsBlock',title:'门票信息',align:'center',sortable:true,
						formatter:function(value,row,index){
							//var ticketsBlock = $(row.ticketsBlock).text();
							if((row.ticketsBlock+"").length>30){
								return (row.ticketsBlock+"").substring(0,30)+"....";
							}else{									
								return row.ticketsBlock;
							}
						}
					},
					{field:'fullyearTicket',title:'全年门票不变',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(row.fullyearTicket){
								return "是"	;
							}else{
								return "否";
							}
						}
					},
					{field:'freeseason',title:'淡季',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.freeseason;
						}
					},
					{field:'busyseason',title:'旺季',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.busyseason;
						}
					},
					{field:'shortContent',title:'简短介绍',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.shortContent+"").length>30){
									return (row.shortContent+"").substring(0,30)+"....";
								}else{									
									return row.shortContent;
								}
							}
					},
					{field:'rank',title:'推荐指数',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "一般推荐";
								}
								if(value == 2){
									return "比较推荐";								
								}
								if(value == 3){
									return "实力推荐";
								}
								if(value == 4){
									return "强烈推荐";							
								}
								if(value == 5){
									return "极力推荐";
								}else{									
									if((row.rank+"").length>30){
										return (row.rank+"").substring(0,30)+"....";
									}else{									
										return row.rank;
									}
								}
							}
					},
					{field:'recommandReason',title:'推荐原因',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.recommandReason+"").length>30){
									return (row.recommandReason+"").substring(0,30)+"....";
								}else{									
									return row.recommandReason;
								}
							}
					},
					/*{field:'discount',title:'折扣',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.discount;
							}
					},*/
					{field:'rcdDays',title:'建议天数',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.rcdDays+"").length>30){
									return (row.rcdDays+"").substring(0,30)+"....";
								}else{									
									return row.rcdDays;
								}
							}
					},
					{field:'difficultyRate',title:'挑战度(1为最低,5为最高,依次递增)',align:'center',sortable:true,
							formatter:function(value,row,index){
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
					{field:'happyValue',title:'快乐值(1为最低,5为最高,依次递增)',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "心情舒畅";
								}
								if(value == 2){
									return "趣味盎然";								
								}
								if(value == 3){
									return "乐翻天";
								}
								if(value == 4){
									return "乐不思蜀";							
								}
								if(value == 5){
									return "极乐无穷";
								}else{									
									if((row.happyValue+"").length>30){
										return (row.happyValue+"").substring(0,30)+"....";
									}else{									
										return row.happyValue;
									}
								}
							}
						},
					{field:'recommandCrowd',title:'建议人群',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.recommandCrowd+"").length>30){
									return (row.recommandCrowd+"").substring(0,30)+"....";
								}else{									
									return row.recommandCrowd;
								}
							}
						},				
					{field:'remark',title:'备注(提醒建议)',align:'center',sortable:true,
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
								/*var uploadCoverFile = $.extend(uploadFile,this.uploadCoverParams);*/
								//_this.init.uploadCoverFile;
								_this.uploadCoverForm().resetForm();		
								_this.uploadCoverForm().find("input[name='id']").val(selected[0].id);
								/*var uploadCoverFile = $.extend(uploadFile,this.uploadCoverParams);
								uploadCoverFile.init();*/
								_this.uploadCoverWin().window('open'); 		
							}
						}},
						{id:'btnedit',text:'上传图片',btnType:'upload',iconCls:'icon-large-picture',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if (_box.utils.checkSelectOne(selected)){
							/*	var zxxfile = $.extend(ZXXFILE,this.params);*/
								//_this.init.zxxfile.init();
								_this.uploadPhotoForm().resetForm();
								_this.uploadPhotoForm().find("input[name='id']").val(selected[0].id);
								
								/*var zxxfile = $.extend(ZXXFILE,this.uploadparams);
								zxxfile.init();*/
								_this.uploadPhotoWin().window('open'); 		
							}
						}},
						{id:'btnedit',text:'编辑图片',btnType:'browser',iconCls:'icon-large-picture',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if (_box.utils.checkSelectOne(selected)){
							/*	var zxxfile = $.extend(ZXXFILE,this.params);*/
								//_this.init.zxxfile;
								_this.editPhotoForm().resetForm();
								_this.editPhotoForm().find("input[name='id']").val(selected[0].id);
								_this.loadPhotoList(selected[0].id);
								_this.editPhotoWin().window('open');
								
							}
						}},
						{id:'btnback',text:'back',disabled: true,iconCls:'icon-back',
							handler:function(){
								_this.toList();
							}
						}
			     	]
			}
		},
		init:function(){
			this.difficultyRate();
			this.happyValue();
			this.writeSelect();
			this.writeRank();
			_box = new YDataGrid(_this.config); 
			_box.init();
			/*var uploadCoverFile = $.extend(uploadFile,this.uploadCoverParams);
			uploadCoverFile.init(); */
			var zxxfile = $.extend(ZXXFILE,this.uploadparams);
			zxxfile.init();
			this.initUploadCoverForm();
			this.initUploadForm();
			this.initEditForm();
			$('#addLine_btn').click(_this.addLine);
			$('#addDefLine_btn').click(_this.addDefBtns);
			$('#delAllLine_btn').click(function(){
				itour.confirm('提示','你确定删除当前记录吗?',function(r){
					_this.delAllLine(false);
				});
			});
			$("input:radio[name='isfullyearTicket']").get(1).checked=true;  
		/*	$("input:radio[name='fullyearTicket']").each(function(i,e) {   
				//console.log(this.value+(this.value == '区分淡旺季'));
                if (this.value == '区分淡旺季'){   
                  this.checked=true; 
                }       
             });  */ 
			$("input:radio[name='isfullyearTicket']").change(function(){//[type='radio']
				//console.log(111111111111);
			//$("#fullradiodiv :radio").change(function(){
				var $selectedvalue = $("input:radio[name='isfullyearTicket']:checked").val();
				if ($selectedvalue == '0') {
					$("#devideTicketdiv").find("input[name='ticketprices']").each(function(){
						this.value="";
					});
					$("#devideTicketdiv").find("input[name='tickets']").each(function(){
						this.value="";
					});
					$("#devideTicketdiv").hide();
					$("#fullyearTicketdiv").show();
				}
				if ($selectedvalue == '1') {
					$("#fullyearTicketdiv").find("input[name='ticketprices']").each(function(){
						this.value="";
					});
					$("#fullyearTicketdiv").find("input[name='tickets']").each(function(){
						this.value="";
					});
					$("#fullyearTicketdiv").hide();
					$("#devideTicketdiv").show();
				}
			});
			$("input[name='tickets']").on('click',function(){
				if(this.value=='门票'){this.value='';this.className='black';};
			})
			$("input[name='tickets']").on('blur',function(){
				if(this.value=='') {this.value='门票';this.className='gray';};
			})
			$("input[name='ticketprices']").on('click',function(){
				if(this.value=='门票价格'){this.value='';this.className='black';};
			})
			$("input[name='ticketprices']").on('blur',function(){
				if(this.value=='') {this.value='门票价格';this.className='gray';};
			});
		},
		writeSelect:function(){
			var result='<select name="recommandCrowd" type="text" maxlength="255" class="easyui-combobox"  data-options="width:131,editable:false" missingMessage="请填写recommandCrowd">'+
			'<option value="">--请选择--</option>'+  
			'<option value="亲子游">亲子游</option> '+ 
			'<option value="情侣双人游">情侣双人游</option>'+ 
			'<option value="家庭游">家庭游</option>'+ 
			'<option value="老人游">老人游</option>'+ 
			'<option value="个人游">个人游</option>'+ 
			'<option value="伙伴游(毕业旅行)">伙伴游(毕业旅行)</option>'+ 
			'<option value="其他人群">其他人群</option>'+ 
			'</select>';
			$("#rucrowd").parent().append(result);
			$("#rcmdCrowd").after(result);
			//document.getElementById("rucrowd").innerHTML= result;
		},
		writeRank:function(){
			var rankSelect ='<select name="rank" class="easyui-combobox"  data-options="width:131,editable:false">'+
			'<option value="">--请选择--</option>'+
			'<option value="5">极力推荐</option>'+
			'<option value="4">强烈推荐</option>'+
			'<option value="3">实力推荐</option>'+
			'<option value="2">比较推荐</option>'+
			'<option value="1">一般推荐</option>'+
			'</select>'; 
			$("#rankLabel").parent().append(rankSelect);
			$("#SelectrankLabel").after(rankSelect);
		},
		difficultyRate:function(){
			var difficultyRateSelect = '<select name="difficultyRate" type="text" maxlength="" class="easyui-combobox"  data-options="width:131,editable:false" missingMessage="请填写difficultyRate">'+
				'<option value="">--请选择--</option>'+
				'<option value="1">一般难度</option>'+
				'<option value="2">略有挑战</option>'+
				'<option value="3">难度适中</option>'+
				'<option value="4">是个难关</option>'+
				'<option value="5">难度爆棚</option>'+
				'</select>';
			$("#difficultyRateLabel").parent().append(difficultyRateSelect);
		},
		happyValue:function(){
			var happySelect='<select name="happyValue" type="text" maxlength="" class="easyui-combobox"  data-options="width:131,editable:false" missingMessage="请填写happyValue"><option value="">--请选择--</option><option value="1">心情舒畅</option><option value="2">趣味盎然</option><option value="3">乐翻天</option><option value="4">乐不思蜀</option><option value="5">极乐无穷</option></select>';
			$("#happyLabel").parent().append(happySelect);
		},
		uploadparams:{
			fileInput: $("#fileImage",this.uploadPhotoWin).get(0),
			//dragDrop: $("#fileDragArea").get(0),
			upButton: $("#fileSubmit",this.uploadPhotoWin).get(0),
			url: 'travelItem/uploadPhoto',// _this.config.action.save,
			onSelect: function(files) {
				var html = '', i = 0;
				$("#preview",this.uploadPhotoWin).html('<div class="upload_loading"></div>');
				var funAppendImage = function() {
					file = files[i];
					//alert("ffffd"+file.name);
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
						reader.readAsDataURL(file);
					} else {
						//console.log(html);
						$("#preview",this.uploadPhotoWin).html(html);
						if (html) {
							//删除方法
							$(".upload_delete",this.uploadPhotoWin).click(function() {
								zxxfile.funDeleteFile(files[parseInt($(this).attr("data-index"))]);
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
			},
			onDelete: function(file) {
				$("#uploadList_" + file.index,this.uploadPhotoWin).fadeOut();
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
				Grid.datagrid('reload',param);
				_this.config.datagrid('reload',param);
			   Form.uploadPhotoForm.resetForm();
			},
			onFailure: function(file) {
				$("#uploadInf",this.uploadPhotoWin).append("<p>图片" + file.name + "上传失败！</p>");	
				$("#uploadImage_" + file.index,this.uploadPhotoWin).css("opacity", 0.2);
			},
			onComplete: function() {
				//提交按钮隐藏
				$("#fileSubmit",this.uploadPhotoWin).hide();
				//file控件value置空
				$("#fileImage",this.uploadPhotoWin).val("");
				$("#uploadInf",this.uploadPhotoWin).append("<p>当前图片全部上传完毕，可继续添加上传。</p>");
			}
		}/*,
		uploadCoverParams:{
			fileInput: $("#fileImage",this.uploadCoverWin).get(0),
		//	dragDrop: $("#fileDragArea").get(0),
			upButton: $("#fileSubmit",this.uploadCoverWin).get(0),
			url: 'travelItem/uploadCover',// _this.config.action.save,//$("#uploadForm").attr("action"),
			onSelect: function(files) {
				var html = '', i = 0;
				$("#preview",this.uploadCoverWin).html('<div class="upload_loading"></div>');
				var funAppendImage = function() {
					file = files[i];
					//alert("ffffff"+file.name);
					if (file) {
						var reader = new FileReader();
						reader.onload = function(e) {
							html += '<div id="uploadList_'+ i +'" class="upload_append_list"><p><strong></strong>'+ 
								'<img id="uploadImage_' + i + '" title="' +file.name + '" src="' + e.target.result + '" class="upload_image" /></p>'+ 
								'<span id="uploadProgress_' + i + '" class="upload_progress"></span>' +
							'</div>';
							i++;
							funAppendImage();
						}
						reader.readAsDataURL(file);
					} else {
						//console.log(html);
						$("#preview",this.uploadCoverWin).html(html);
						if (html) {
							//提交按钮显示
							$("#fileSubmit",this.uploadCoverWin).show();	
						} else {
							//提交按钮隐藏
							$("#fileSubmit",this.uploadCoverWin).hide();	
						}
					}
				};
				funAppendImage();		
			},
			onDelete: function(file) {
				$("#uploadList_" + file.index,this.uploadCoverWin).fadeOut();
			},
			onDragOver: function() {
				$(this).addClass("upload_drag_hover");
			},
			onDragLeave: function() {
				$(this).removeClass("upload_drag_hover");
			},
			onProgress: function(file, loaded, total) {
				var eleProgress = $("#uploadProgress_" + file.index,this.uploadCoverWin), percent = (loaded / total * 100).toFixed(2) + '%';
				eleProgress.show().html(percent);
			},
			onSuccess: function(file, response) {
				$("#uploadInf",this.uploadCoverWin).append("<p>图片"+file.name+"上传成功，"  + response + "</p>");
				Grid.datagrid('reload',param);
				_this.config.datagrid('reload',param);
			   Form.uploadCoverForm.resetForm();
			},
			onFailure: function(file) {
				$("#uploadInf",this.uploadCoverWin).append("<p>图片" + file.name + "上传失败！</p>");	
				$("#uploadImage_" + file.index,this.uploadCoverWin).css("opacity", 0.2);
			},
			onComplete: function() {
				//提交按钮隐藏
				$("#fileSubmit",this.uploadCoverWin).hide();
				//file控件value置空
				$("#fileImage",this.uploadCoverWin).val("");
				$("#uploadInf",this.uploadCoverWin).append("<p>当前图片全部上传完毕，可继续添加上传。</p>");
			}
		}*/
	};
	return _this;
}();
/*window.onload(){
	itour.travelItem.init();
}*/
$(function(){
	itour.travelItem.init();
});