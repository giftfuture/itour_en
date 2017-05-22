$package('itour.orderDetail');
itour.orderDetail = function(){
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
				{"btnName":"添加","menuid":'0BFBE5C0E2BF4A579A65B45FCD52B74D',"actionUrls":"orderDetail/save","btnType":"add"},
				{"btnName":"修改","menuid":'0BFBE5C0E2BF4A579A65B45FCD52B74D',"actionUrls":"orderDetail/getId|orderDetail/save","btnType":"edit"},
				{"btnName":"删除","menuid":"0BFBE5C0E2BF4A579A65B45FCD52B74D","actionUrls":"orderDetail/logicdelete","btnType":"logicremove"},
				{"btnName":"物理删除","menuid":'0BFBE5C0E2BF4A579A65B45FCD52B74D',"actionUrls":"orderDetail/delete","btnType":"remove"}
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
		handlerAdd:function(){
			
		},
		action:{
				save:'orderDetail/save', //新增&修改 保存Action  
				getId:'orderDetail/getId',//编辑获取的Action
				logicremove:'orderDetail/logicdelete',//逻辑删除Action
				remove:'orderDetail/delete'//删除数据的Action
			},
  			dataGrid:{
  				title:'订单详情',
	   			url:'orderDetail/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'travelOrder',title:'订单号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.travelOrder;
						}
					},
					{field:'orderId',title:'详情号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.id;
						}
					},
					{field:'guide',title:'导游',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.guide;
						}
					},
					{field:'comefrom',title:'来自',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.comefrom;
						}
					},{field:'status',title:'状态',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(value == 1){
								return "待处理";
							}
							if(value == 2){
								return "处理中";
							}
							if(value == 3){
								return "处理完成";
							}
					}},
					{field:'createTime',title:'创建时间',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.createTime;
						}
					},
					{field:'updateTime',title:'更新时间',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.updateTime;
						}
					},
				/*	{field:'content',title:'内容明细',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.content;
						}
					},
					{field:'perPrice',title:'单价',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.perPrice;
							}
					},
					{field:'count',title:'数量',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.count;
							}
					},*/
					{field:'travelfashion',title:'旅行方式',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.travelfashion;
						}
					},
					{field:'singleorcluster',title:'团/人',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.singleorcluster;
						}
					},
					{field:'adults',title:'成人人数',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.adults;
						}
					},
					{field:'children',title:'小孩人数',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.children;
						}
					},
					{field:'groupCode',title:'团号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.groupCode;
						}
					},
					{field:'groupDate',title:'出团日期',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.groupDate;
						}
					},
					{field:'travelfashion',title:'出行方式',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.travelfashion;
						}
					},
					{field:'travelrequest',title:'行程要求',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.travelrequest+"").length>30){
								return (row.travelrequest+"").substring(0,30)+"....";
							}else{									
								return row.travelrequest;
							}
						}
					},
					{field:'tickets',title:'门票',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.tickets;
						}
					},
					{field:'foodArrange',title:'是否安排饭食',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.foodArrange;
						}
					},
					{field:'foodrequest',title:'用餐要求',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.foodrequest+"").length>30){
								return (row.foodrequest+"").substring(0,30)+"....";
							}else{									
								return row.foodrequest;
							}
						}
					},
					{field:'hotel',title:'酒店',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.hotel+"").length>30){
								return (row.hotel+"").substring(0,30)+"....";
							}else{									
								return row.hotel;
							}
						}
					},
					{field:'stayrequest',title:'住宿要求',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.stayrequest+"").length>30){
								return (row.stayrequest+"").substring(0,30)+"....";
							}else{									
								return row.stayrequest;
							}
						}
					},
					{field:'position',title:'房间位置 ',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.position;
						}
					},
					{field:'bb_room',title:'双床房 ',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.bb_room;
						}
					},
					{field:'db_room',title:'大床房',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.db_room;
						}
					},
					{field:'suite',title:'套房',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.suite;
						}
					},
					{field:'hotel_no_smoking',title:'是否无烟房间',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.hotel_no_smoking;
						}
					},
					{field:'hotel_quiet',title:'是否安静房间',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.hotel_quiet;
						}
					},
					{field:'hotel_info',title:'是否提供宾馆详情',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.hotel_info;
						}
					},
					{field:'plane',title:'航班类别',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.plane;
						}
					},
					{field:'shipping_space',title:'航旅舱位',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.shipping_space;
						}
					},
					{field:'car',title:'车辆',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.car;
						}
					},
					{field:'car_no_smoking',title:'无烟车',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.car_no_smoking;
						}
					},
					{field:'car_new',title:'新车',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.car_new;
						}
					},
					{field:'cruise',title:'游轮',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.cruise;
						}
					},
					{field:'train',title:'火车票',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.train;
						}
					},
					{field:'hatefood',title:'忌口',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.hatefood+"").length>30){
								return (row.hatefood+"").substring(0,30)+"....";
							}else{									
								return row.hatefood;
							}
						}
					},
				/*	{field:'traffic',title:'交通',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.traffic;
						}
					},*/
					{field:'recreation',title:'娱乐',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.recreation+"").length>30){
								return (row.recreation+"").substring(0,30)+"....";
							}else{									
								return row.recreation;
							}
						}
					},
					{field:'specialrequest',title:'个性要求',align:'center',sortable:true,
						formatter:function(value,row,index){
							if((row.specialrequest+"").length>30){
								return (row.specialrequest+"").substring(0,30)+"....";
							}else{									
								return row.specialrequest;
							}
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
									/*{id:'btnadd',text:'添加',btnType:'add',disabled:true,handler:function(){
										//$("span[name='orderId']").text("aaaa");
									}},*/
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
		formatterDate : function(date) {//得到当前日期
			var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
			var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1);
			return date.getFullYear() + '-' + month + '-' + day;
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
			$("#travelfashion").combobox({
				onChange: function (n,o) {
					if($(this).combobox('getValue')=="加入散客团"){
						$("#groupdiv").show();
					}else{
						$("#groupCode").textbox('setValue','');
						$("#groupDate").datebox('setValue','');
						$("#groupdiv").hide();
					}
			}});
			if($("input:checked[name='guide'][type='radio']").val()=="其他语种"){
				$("#elseguide").show();
			}else{
				$("#elseguide").hide();
			}
			$("input[name='guide'][type='radio']").click(function(){
				//console.log($("input:checked[name='guide'][type='radio']").val());
				if($("input:checked[name='guide'][type='radio']").val()=="其他语种"){
					$("#elseguide").show();
				}else{
					$("#elseguide").hide();
				}
			});
			$.extend($.fn.validatebox.defaults.rules,{ 
				dateValided:{
			        validator : function(value) { //参数value为当前文本框的值
			        	var d =  _this.formatterDate(new Date());
			        //	itour.alert('提示',value +"    "+ d+"   "+(value > d),'info');
			           if(d>=value){
			        	   //itour.alert('提示','选择行程安排日期应在当前日期之后','warn');
			        	   //$("input[name='tourTime']").datebox('setValue','');  
			           }else{
			        	   return value > d;  
			           }
			        },  
			        message : '选择行程安排日期应在当前日期之后'  //
				},
			    md : {  
			        validator : function(value,param) { //参数value为当前文本框的值
			        	var startTime = $(param[0]).datebox('getValue'); 
			        	return value>startTime; 
			        },  
			        message : '选择行程安排返程日应在出发日期之后'  //
			    }  
			}); 
		}
	}
	return _this;
}();

$(function(){
	itour.orderDetail.init();
});