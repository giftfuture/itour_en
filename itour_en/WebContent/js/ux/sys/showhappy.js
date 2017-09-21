$package('itouren.showhappy');
itouren.showhappy = function(){
	var _box = null;
	var _this = {
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
					{"btnName":"添加","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"showhappy/save","btnType":"add"},
					{"btnName":"修改","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"showhappy/getId|showhappy/save","btnType":"edit"},
					{"btnName":"删除","menuid":"E2A9CF59E2F144A2B863ECA27EC8BDDF","actionUrls":"showhappy/logicdelete","btnType":"logicremove"},
					{"btnName":"删除","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"showhappy/delete","btnType":"remove"}
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
  				save:'showhappy/save', //新增&修改 保存Action  
  				getId:'showhappy/getId',//编辑获取的Action
  				logicremove:'showhappy/logicdelete',//逻辑删除Action
  				remove:'showhappy/delete'//删除数据的Action
  			},
			/*event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},*/
  			dataGrid:{
  				title:'回忆幸福',
	   			url:'showhappy/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					/*{field:'customerId',title:'客户ID',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.customerId;
						}
					},*/
					{field:'title',title:'标题',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(row.title && row.title.length>30){
								return row.title.substring(0,30)+"...";
							}else{									
								return row.title;
							}
						}
					},
				{field:'shortContent',title:'内容',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(row.shortContent && row.shortContent.length>30){
								return row.shortContent.substring(0,30)+"...";
							} 									
							return row.shortContent;
						}
					},
					{field:'tourTime',title:'旅行日期',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.tourTime;
							}
					},{field:'createTime',title:'反馈日期',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.createTime;
						}
					},
					{field:'routeTitle',title:'路线',align:'center',sortable:false,formatter:function(value,row,index){
						if(row.routeTitle && row.routeTitle.length>30){
							return row.routeTitle.substring(0,30)+"...";
						}else{									
							return row.routeTitle;
						}
					}},
					{field:'customerName',title:'晒出人',align:'center',sortable:false,formatter:function(value,row,index){
							return row.customerName;
					}},
					{field:'areaname',title:'来自地区',align:'center',sortable:false,formatter:function(value,row,index){
						if(row.areaname && row.areaname.length>30){
							return row.areaname.substring(0,30)+"...";
						}else{									
							return row.areaname;
						}
					}},
					{field:'status',title:'审核状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1||value == 0){
									return "待审核";
								}
								if(value == 2){
									return "审核通过";
								}
								if(value == 3){
									return "审核未通过";
								}
							}
						},
				/*	{field:'updateTime',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateTime;
							}
						},*/
					{field:'result',title:'审核意见',align:'center',sortable:true,
							formatter:function(value,row,index){
								//console.log(row.result);
								if(row.result && row.result.length>30){
									return row.result.substring(0,30)+"....";
								}else{									
									return row.result;
								}
							}
						},
					]],
					toolbar:[
								/*{id:'btnadd',text:'添加',btnType:'add'},*/
								{id:'btnedit',text:'修改',btnType:'edit'},
								{id:'btndelete',text:'物理删除',btnType:'remove'},
								{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'}
							]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#addLine_btn').click(_this.addLine);
			$('#addDefLine_btn').click(_this.addDefBtns);
			$('#delAllLine_btn').click(function(){
				itouren.confirm('提示','你确定删除当前记录吗?',function(r){
					_this.delAllLine(false);
				});
			});
		    $('#content').summernote({  
		    	popover:{},
		        height: 400,                  
		        minHeight: 300,             
		        maxHeight: 500,        
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
			
		}
	}
	return _this;
}();

$(function(){
	itouren.showhappy.init();
	 /* if (window != top)
          top.location.href = location.href;*/
});