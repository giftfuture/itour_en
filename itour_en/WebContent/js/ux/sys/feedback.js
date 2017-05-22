$package('itour.feedback');
itour.feedback = function(){
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
					{"btnName":"添加","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"feedback/save","btnType":"add"},
					{"btnName":"修改","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"feedback/getId|feedback/save","btnType":"edit"},
					{"btnName":"删除","menuid":"E2A9CF59E2F144A2B863ECA27EC8BDDF","actionUrls":"feedback/logicdelete","btnType":"logicremove"},
					{"btnName":"删除","menuid":'E2A9CF59E2F144A2B863ECA27EC8BDDF',"actionUrls":"feedback/delete","btnType":"remove"}
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
  				save:'feedback/save', //新增&修改 保存Action  
  				getId:'feedback/getId',//编辑获取的Action
  				logicremove:'feedback/logicdelete',//逻辑删除Action
  				remove:'feedback/delete'//删除数据的Action
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
  				title:'反馈咨询',
	   			url:'feedback/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
			/*		{field:'customerId',title:'客户ID',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.customerId;
						}
					},*/
					{field:'customerName',title:'姓名',align:'center',sortable:false,formatter:function(value,row,index){
						return row.customerName;
					}},
					{field:'email',title:'邮箱',align:'center',sortable:false,formatter:function(value,row,index){
						return row.email;
					}},
					{field:'mobile',title:'电话',align:'center',sortable:false,formatter:function(value,row,index){
						return row.mobile;
					}},
					{field:'title',title:'标题',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.title;
						}
					},
				{field:'content',title:'内容',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(row.content && row.content.length>30){
								return row.content.substring(0,30)+"...";
							}else{									
								return row.content;
							}
						}
					},
					{field:'createTime',title:'反馈时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					{field:'status',title:'状态',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
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
						{field:'publicShow',title:'是否公开展示',align:'center',sortable:true,
							formatter:function(value,row,index){
								//console.log(row.result);
								if(row.publicShow){
									return "是";
								}else{									
									return "否";
								}
							}
						}
					]],
					toolbar:[
								{id:'btnadd',text:'添加',btnType:'add'},
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
	itour.feedback.init();
});