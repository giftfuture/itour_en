$package('itour.travelOrder');
itour.travelOrder = function(){
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
					{"btnName":"添加","menuid":"11","actionUrls":"travelOrder/save","btnType":"add"},
					{"btnName":"修改","menuid":"11","actionUrls":"travelOrder/getId|travelOrder/save","btnType":"edit"},
					{"btnName":"删除","menuid":"11","actionUrls":"travelOrder/logicdelete","btnType":"logicremove"},
					{"btnName":"物理删除","menuid":"11","actionUrls":"travelOrder/delete","btnType":"remove"}
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
				html+=	   "	<td><input name=\"btnName\" class=\"easyui-combobox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
				html+=	   "	<td><input name=\"btnType\" class=\"easyui-combobox text-name\" style=\"width:100%\" data-options=\"required:true\"></td>";
				html+=	   "	<td><input name=\"actionUrls\" class=\"easyui-combobox text-desc\" style=\"width:100%\"  ></td>";
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
  				save:'travelOrder/save', //新增&修改 保存Action  
  				getId:'travelOrder/getId',//编辑获取的Action
  				logicremove:'travelOrder/logicdelete',//逻辑删除Action
  				remove:'travelOrder/delete'//删除数据的Action
  			},
		/*config:{
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
  			dataGrid:{
  				title:'客户订单',
	   			url:'travelOrder/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
				/*	{field:'customerId',title:'客户ID',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.customerId;
						}
					},*/
					{field:'orderNo',title:'订单号',align:'center',sortable:true,
						formatter:function(value,row,index){
							return '<span title="'+row.orderNo+'">'+row.orderNo+'</span>';
						}
					},
					{field:'orderName',title:'订单名称',align:'left',sortable:true,
						formatter:function(value,row,index){
							return '<span title="'+row.orderName+'">'+row.orderName+'</span>';
						}
					},
					{field:'routeId',title:'订单处理',align:'center',sortable:true,
						formatter:function(value,row,index){
							return '<a href="'+basePath+'travelOrder/toQuote2/'+row.id+'/'+row.routeId+'">订单处理</a>';
						}
					},
					{field:'orderStatus',title:'订单状态',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(value == 1){
								return "待付款";
							}
							if(value == 2){
								return "付款完成,待确认";
							}
							if(value == 3){
								return "确认支付完成";
							}
						}
					},
					{field:'receiver',title:'联系人',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.receiver;
						}
					},
					{field:'gender',title:'联系人性别',align:'center',sortable:true,
						formatter:function(value,row,index){
							if(row.gender==1)
								return '男';
							else
								return '女';
						}
					},{field:'receiverMobile',title:'联系电话',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.receiverMobile;
						}
					},
					{field:'receiveremail',title:'联系邮箱',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.receiveremail;
						}
					},
					{field:'routename',title:'订单路线',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.routename;
						}
					},
					{field:'createTime',title:'下单时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					{field:'updateTime',title:'更新时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updateTime;
							}
						},
					{field:'expectedDepart',title:'计划出行日',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.expectedDepart;
							}
						},
					{field:'expectedBack',title:'计划返程日',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.expectedBack;
							}
						},
					{field:'totalStaff',title:'出行人数',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.totalStaff;
							}
					},
					{field:'budget',title:'出行预算',align:'center',sortable:true,
						formatter:function(value,row,index){
							return row.budget;
						}
					},
					{field:'isPayed',title:'是否支付完成.',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "未支付";
								}
								if(value == 2){
									return "支付完成";
								}
							}
						},
					{field:'payType',title:'支付方式',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "线上支付";
								}
								if(value == 2){
									return "现金支付";
								}
								if(value == 3){
									return "邮政汇款";
								}
								if(value == 4){
									return "公司转帐";
								}
							}
						},
					{field:'payPlatform',title:'付款平台',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "微信";
								}
								if(value == 2){
									return "支付宝";
								}
								if(value == 3){
									return "网银";
								}
							}
						},
					{field:'bank',title:'付款方银行',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.bank;
							}
						},
					{field:'payAccount',title:'付款方银行帐户',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.payAccount;
							}
						},
					{field:'payTime',title:'付款时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.payTime;
							}
						},
					{field:'payTerminal',title:'付款终端',align:'center',sortable:true,
							formatter:function(value,row,index){
								if(value == 1){
									return "PC";
								}
								if(value == 2){
									return "IOS";
								}
								if(value == 3){
									return "Android";
								}else{
									return '<span title="'+row.payTerminal+'">'+row.payTerminal+'</span>';;
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
					}]],
					toolbar:[
								{id:'btnadd',text:'添加',btnType:'add',disabled:true},
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
			var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
			+ (date.getMonth() + 1);
			return date.getFullYear() + '-' + month + '-' + day;
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
			_this.browser();
			$('#addLine_btn').click(_this.addLine);
			$('#addDefLine_btn').click(_this.addDefBtns);
			$('#delAllLine_btn').click(function(){
				itour.confirm('提示','你确定删除当前记录吗?',function(r){
					_this.delAllLine(false);
				});
			});
			$("#expectedDepart").datebox({ 
				  validator: function(date){ 
				       return new Date()<date;//<= 
				   },
				 onSelect : function(beginDate){ 
				  $('#expectedBack').datebox().datebox('calendar').calendar({ 
				    validator: function(date){ 
				       return beginDate<date;//<= 
				   } 
				  }); 
				 } 
			});
			$.extend($.fn.validatebox.defaults.rules,{  
			    dateValided : {  
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
			    } ,
			    dateLimited : {  
			        validator : function(value,param) { //参数value为当前文本框的值
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
			    } 
			}); 
		},
		//判断访问终端
		browser:function(){
	         var explorer =navigator.userAgent,browse,
	         app = navigator.appVersion,
	         language=(navigator.browserLanguage || navigator.language).toLowerCase();
			 if (explorer.indexOf("MSIE") >= 0){
			 	//ie 
			 	browse = "ie";
			 }else if (explorer.indexOf("Firefox") >= 0) {
			 	// firefox 火狐
			 	browse = "Firefox";
			 }else if(explorer.indexOf("Chrome") >= 0){
			 	//Chrome 谷歌
			 	browse = "Chrome";
			 }else if(explorer.indexOf("Opera") >= 0){
			 	//Opera 欧朋
			 	browse = "Opera";
			 }else if(explorer.indexOf("Safari") >= 0){
			 	//Safari 苹果浏览器
			 	browse = "Safari";
			 }else if(explorer.indexOf("Netscape")>= 0) { 
			 	//Netscape
			 	browse = "Netscape"; 
			 }
			 var result = browse+"_"+app+"_"+language;
			// alert(browse+"_"+app+"_"+language);
			// return browse+"_"+app+"_"+language;
			//$("#payTerminal").val(result);
			$("input[name='payTerminal']").val(result);
		}
	}
	return _this;
}();

$(function(){
	itour.travelOrder.init();
});