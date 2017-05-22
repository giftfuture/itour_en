$package('itour.customers');
itour.customers = function(){
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
					{"btnName":"添加","menuid":"10","actionUrls":"customers/save","btnType":"add"},
					{"btnName":"修改","menuid":"10","actionUrls":"customers/getId|customers/save","btnType":"edit"},
					{"btnName":"物理删除","menuid":"10","actionUrls":"customers/delete","btnType":"remove"},
					{"btnName":"删除","menuid":"10","actionUrls":"customers/logicdelete","btnType":"logicremove"}
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
				//html+=	   "	<td><span class='newFlag red'>*</span>";
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
  				save:'customers/save', //新增&修改 保存Action  
  				getId:'customers/getId',//编辑获取的Action
  				logicremove:'customers/logicdelete',//逻辑删除Action
  				remove:'customers/delete'//删除数据的Action
  			},
  			dataGrid:{
  				title:'客户信息',
	   			url:'customers/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					/*{field:'customerId',title:'客户ID',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.customerId;
							}
						},*/
						{field:'customerName',title:'客户姓名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.customerName;
							}
						},
						{field:'email',title:'邮箱',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.email;
							}
						},
					/*{field:'nickName',title:'昵称',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.nickName;
							}
						},*/
				/*		{field:'telephone',title:'电话',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.telephone;
							}
						},
					{field:'mobile',title:'手机',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.mobile;
							}
						},
					{field:'createTime',title:'创建时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					{field:'status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "活跃";
								}
								if(value == 2){
									return "不活跃";
								}
								if(value == 3){
									return "废弃";
								}
							}
						},
					{field:'address',title:'地址',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.address;
							}
						},
						{field:'updateTime',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateTime;
							}
						},
					{field:'scope',title:'来自(区域)',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "中国大陆";
								}
								if(value == 2){
									return "香港";
								}
								if(value == 3){
									return "澳门";
								}
								if(value == 4){
									return "台湾";
								}
								if(value == 5){
									return "海外";
								}else{
									return value;
								}
							}
						},*/
					{field:'city',title:'城市',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.city;
							}
					},
					{field:'birthday',title:'生日',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.birthday;
							}
					},
					/*{field:'detailed',title:'查看详细',align:'center',width:150,formatter:function(value,row,index){
						return '<a>查看详细</a>';		
					}},*/
					{field:'detailed',title:'订单',align:'center',width:150,formatter:function(value,row,index){
						return '<a href="'+basePath+'customers/showOrders?id='+row.id+'">订单</a>';		
					}}
				/*	{field:'district',title:'区县',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.district;
							}
						},
					{field:'introduction',title:'简介',align:'center',sortable:true,
							formatter:function(value,row,index){
								if((row.introduction+"").length>30){
									return (row.introduction+"").substring(0,30)+"....";
								}else{									
									return row.introduction;
								}
							}
					}*/]/*,[
							{field:'district',title:'区县',align:'center',sortable:true,
								formatter:function(value,row,index){
									return row.district;
								}
							},
							{field:'introduction',title:'简介',align:'center',sortable:true,
								formatter:function(value,row,index){
									if((row.introduction+"").length>30){
										return (row.introduction+"").substring(0,30)+"....";
									}else{									
										return row.introduction;
									}
								}
							}
					      ]*/],
					toolbar:[{id:'btnadd',text:'添加',btnType:'add'},
								{id:'btnedit',text:'修改',btnType:'edit'},
								{id:'btndelete',text:'物理删除',btnType:'remove'},
								{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'},
								{
									id:'btnback',
									text:'back',
									disabled: true,
									iconCls:'icon-back',
									handler:function(){
										_this.toList();
									}
								}
							]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			$('#addLine_btn').click(_this.addLine);
			$('#addDefLine_btn').click(_this.addDefBtns);
			$('#delAllLine_btn').click(function(){
				itour.confirm('提示','你确定删除当前记录吗?',function(r){
					_this.delAllLine(false);
				});
			});
			
		}
	}
	return _this;
}();

$(function(){
	itour.customers.init();
});