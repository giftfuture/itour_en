$package('itour.levelarea');
itour.levelarea = function(){
	var _box = null;
	var _this = {
			//设置默认按钮数据
			addDefBtns:function(){
				var defaultBtns= [
					{"btnName":"添加","menuid":"74BDAEA713D841549B840E502C4F150A","actionUrls":"levelarea/save","btnType":"add"},
					{"btnName":"修改","menuid":"74BDAEA713D841549B840E502C4F150A","actionUrls":"levelarea/getId|levelarea/save","btnType":"edit"},
					{"btnName":"物理删除","menuid":"74BDAEA713D841549B840E502C4F150A","actionUrls":"levelarea/delete","btnType":"remove"},
					{"btnName":"删除","menuid":"74BDAEA713D841549B840E502C4F150A","actionUrls":"levelarea/logicdelete","btnType":"logicremove"}
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
  				save:'levelarea/save', //新增&修改 保存Action  
  				getId:'levelarea/getId',//编辑获取的Action
  				logicremove:'levelarea/logicdelete',//逻辑删除Action
  				remove:'levelarea/delete'//删除数据的Action
  			},						
  			dataGrid:{
  				title:'路线区域',
	   			url:'levelarea/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'title',title:'路线名称',align:'center',sortable:true,width:'200',
						formatter:function(value,row,index){
							return row.title;
						}
					},
					{field:'level1Area',title:'一级区域',align:'center',sortable:true,width:'200',
						formatter:function(value,row,index){
							return row.level1Area;
						}
					},
					{field:'level2Area',title:'二级区域',align:'center',sortable:true,width:'200',
						formatter:function(value,row,index){
							return row.level2Area;
						}
					},
				/*	{field:'aliasCode',title:'别名码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.aliasCode;
							}
					},*/
					{field:'item',title:'景点',align:'center',sortable:true,width:'200',
						formatter:function(value,row,index){
							return row.item;
						}
					}
				 ]],
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
			$("#level1Areadiv").hide();
			$("#level2Areadiv").hide();
			$("a[name='addLevel1Area']").click(function(){
				$("#level1Areadiv").show();
				$("span[name='newlevel1span']").show();
				$("label[name='keeplevel1']").parent().hide();
			});
			$("a[name='addLevel2Area']").click(function(){
				$("#level2Areadiv").show();
				$("span[name='newlevel2span']").show();
				$("label[name='keeplevel2']").parent().hide();
			});
			$("#level1Areadiv").find("a[name='addlevel1']").click(function(){
				if($("input[name='newlevel1Area']").val()){
					$("label[name='keeplevel1']").html($("input[name='newlevel1Area']").val());
					$("label[name='keeplevel1']").parent().show();
					$("input[name='newlevel1Area']").val("");
					$("span[name='newlevel1span']").hide();
				//	$("#level1Areadiv").find("a[name='addlevel1']").hide();
				//	$("#level1Areadiv").find("a[name='cancel1']").hide();
				}
			});
			$("#level1Areadiv").find("a[name='cancel1']").click(function(){
				$("input[name='newlevel1Area']").val('');
				$("#level1Areadiv").hide();
			});
			$("#level2Areadiv").find("a[name='addlevel2']").click(function(){
				if($("input[name='newlevel2Area']").val()){
					$("label[name='keeplevel2']").html($("input[name='newlevel2Area']").val());
					$("label[name='keeplevel2']").parent().show();
					$("input[name='newlevel2Area']").val("");
					$("span[name='newlevel2span']").hide();
					//$("#level2Areadiv").find("a[name='addlevel2']").hide();
					//$("#level2Areadiv").find("a[name='cancel2']").hide();
				}
			});
			$("#level2Areadiv").find("a[name='cancel2']").click(function(){
				$("input[name='newlevel2Area']").val('');
				$("#level2Areadiv").hide();
			});
			$("a[name='delkeeplevel1']").click(function(){
				$(this).prev().html('')	;
				$(this).parent().hide();
			});
			$("a[name='delkeeplevel2']").click(function(){
				$(this).prev().html('')	;
				$(this).parent().hide();
			});
		}
	}
	return _this;
}();

$(function(){
	itour.levelarea.init();
});