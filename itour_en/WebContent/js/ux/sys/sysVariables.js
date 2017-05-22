$package('itour.sysVariables');
itour.sysVariables = function(){
/*	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},*/
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
					{"btnName":"添加","menuid":"7A776ACD16D546A2866B1D79509383F8","actionUrls":"sysVariables/save","btnType":"add"},
					{"btnName":"修改","menuid":"7A776ACD16D546A2866B1D79509383F8","actionUrls":"sysVariables/getId|sysVariables/save","btnType":"edit"},
					{"btnName":"删除","menuid":"7A776ACD16D546A2866B1D79509383F8","actionUrls":"sysVariables/logicdelete","btnType":"logicremove"},
					{"btnName":"物理删除","menuid":"7A776ACD16D546A2866B1D79509383F8","actionUrls":"sysVariables/delete","btnType":"remove"}
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
  				save:'sysVariables/save', //新增&修改 保存Action  
  				getId:'sysVariables/getId',//编辑获取的Action
  				logicremove:'sysVariables/logicdelete',//逻辑删除Action
  				remove:'sysVariables/delete'//删除数据的Action
  			},
  			dataGrid:{
  				title:'系统变量',
	   			url:'sysVariables/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'varName',title:'变量名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.varName;
							}
						},
					{field:'varValue',title:'变量值',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.varValue;
							}
						},
					{field:'varHostname',title:'主机名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.varHostname;
							}
						},
					{field:'varHostip',title:'主机IP',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.varHostip;
							}
						},
						{field:'varProject',title:'所属项目',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.varProject;
							}
						},
					{field:'remark',title:'备注说明',align:'center',sortable:true,
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
	itour.sysVariables.init();
});