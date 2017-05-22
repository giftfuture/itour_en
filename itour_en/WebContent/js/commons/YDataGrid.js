var YDataGrid = function(config){
		config = config || {};
		var dataGrid = config.dataGrid || {}
		//Actions
		var actionUrl =  config.action || {}
		var Action = {
			'save': actionUrl.save ||'save',
			'getId': actionUrl.getId||'getId',
			'remove': actionUrl.remove||'delete',
			'logicremove': actionUrl.logicremove||'logicdelete',
			'updatePwd':actionUrl.updatePwd||'updatePwd'
		}
		//Grid DataList
		var Grid = $('#data-list');
		//Form
		var Form = {search:$("#searchForm"),editPhotoForm:$("#editPhotoForm"),uploadMapForm:$("#uploadMapForm"),
					uploadPhotoForm:$("#uploadPhotoForm"),
					edit:$("#editForm"),multiDataForm:$("#multiDataForm"),uploadCoverForm:$("#uploadCoverForm")};
		//var picForm = {edit:$("#multiDataForm")};
		//Win 窗口
		var Win =  {edit:$("#edit-win"),uploadPhotoWin:$("#upload-photo"),uploadMapWin:$("#upload-map"),
			uploadCoverWin:$("#uploadCover-photo"),editPhotoWin:$("#edit-photo")};
		//var PhotoWin = {edit:$("#uploadphoto")};
		//处理函数
		var Handler = {
			//serach 查询事件
			search: function(callback){
				Events.refresh();
				//回调函数
				if(jQuery.isFunction(callback)){
					callback();
				}
				return false;	
			},
			//add按钮事件
			add: function(callback){
				//Win.edit.css("display","inline");
				if(Win.edit.find("#larouteTemplates")){
					Win.edit.find("#larouteTemplates").show();
					Win.edit.find("#larttitle").hide();
					Win.edit.find("#devideTicketdiv").show();
					Win.edit.find("#fullyearTicketdiv").hide();
					Win.edit.find("input[name='ticketprices']").each(function(){
						this.value="";
					});
					Win.edit.find("input[name='tickets']").each(function(){
						this.value="";
					});
				}
				Win.edit.show();
				Win.edit.dialog('open');
				Form.edit.resetForm();
				//回调函数
				if(jQuery.isFunction(callback)){
					//console.log(callback);
					callback();
				}
			},
			ckCreate:function (name) {
			    if (CKEDITOR.instances[name]) {
			        var instance = CKEDITOR.instances[name];
			        if (instance.element.$) {
			            instance.destroy(true);
			        }
			        //$('#' + name).attr('contenteditable', true);
			       // CKEDITOR.inline(name);
			    }
		    },
			//edit 按钮事件
			edit:function(callback){
				//Win.edit.removeAttr("display");
				//Win.edit.css("display","inline");
				if(Win.edit.find("#larttitle")){
					Win.edit.find("#larouteTemplates").hide();
					Win.edit.find("#larttitle").show();
					Win.edit.find("#devideTicketdiv").show();
					Win.edit.find("#fullyearTicketdiv").hide();
				}
				Win.edit.show();
			//	Win.edit.dialog('open'); 
				var record = Utils.getCheckedRows();
				if (Utils.checkSelectOne(record)){
					itour.progress();
					var data ={};
					var idKey = dataGrid.idField || 'id'; //主键名称
 					data[idKey] = (record[0][idKey]);
					itour.getById(Action.getId,data,function(result){
						itour.closeProgress();
						Form.edit.form('load',result.data);
					//	try{
						//	CKEDITOR.replace('txtContent', { toolbar: 'Basic' });
							if(result.data.beforeInstruction&&result.data.beforeInstruction.length>0){
								Handler.ckCreate('beforeInstruction');
								//console.log(result.data.beforeInstruction);
								var beforeInstruction = CKEDITOR.replace("beforeInstruction");
								//console.log(CKEDITOR.replace("beforeInstruction"));
								beforeInstruction.setData(result.data.beforeInstruction);
							}
							if(result.data.customizedService&&result.data.customizedService.length>0){
								Handler.ckCreate('customizedService');
								var customizedService = CKEDITOR.replace('customizedService');
								//console.log(CKEDITOR.replace("beforeInstruction"));
								customizedService.setData(result.data.customizedService);
							}
							if(result.data.designConcept&&result.data.designConcept.length>0){
								Handler.ckCreate('designConcept');
								var designConcept = CKEDITOR.replace('designConcept');
								//console.log(CKEDITOR.replace("beforeInstruction"));
								designConcept.setData(result.data.designConcept);
							}
						/*	if(result.data.orderId){
								$("span[name='orderId']").html("<label>订单号:</label>"+result.data.orderId);
							}*/
					/*	}catch(e){
							console.log("name: " + e.name + 
									 ",description: " +e.description+
								      ",message: " + e.message + 
								      ",lineNumber: " + e.lineNumber + 
								      ",fileName: " + e.fileName + 
								      ",stack: " + e.stack);
						}*/
					//console.log(result.data);
						//回调函数
						/*console.log(callback);
						if(jQuery.isFunction(callback)){
							callback(result);
						}*/
					});
				}
				Win.edit.dialog('open'); 
			},
			//刷新Grid 数据
			refresh: function(callback){
				var param = Form.search.serializeObject();
				//Grid.datagrid("resize");
				//console.log(param);
				Grid.datagrid('reload',param);
				//回调函数
				if(jQuery.isFunction(callback)){
					callback();
				}
			},
			//删除记录
			remove: function(callback){
				var records = Utils.getCheckedRows();
				if (Utils.checkSelect(records)){
					$.messager.confirm('提示','确认删除记录?',function(r){  
					    if (r){
					    	itour.progress();
					    	var arr = [],idKey = dataGrid.idField || 'id'; //主键名称
					    	$.each(records,function(i,record){
					    		arr.push('id='+record[idKey]);
					    	});
					    	var data = arr.join("&");
					   		itour.deleteForm(Action.remove,data,function(result){
								itour.closeProgress();
								Events.refresh();
								//回调函数
								itour.alert('提示',result.msg||'删除成功.','info');
							/*	if(jQuery.isFunction(callback)){
									console.log(result);
									callback(result);
								}*/
							});
					    }  
					});
				}
			},//保存调用方法
			//逻辑删除记录
			logicremove: function(callback){
				var records = Utils.getCheckedRows();
				if (Utils.checkSelect(records)){
					$.messager.confirm('提示','确认删除记录?',function(r){  
					    if (r){
					    	itour.progress();
					    	var arr = [],idKey = dataGrid.idField || 'id'; //主键名称
					    	$.each(records,function(i,record){
					    		arr.push('id='+record[idKey]);
					    	});
					    	var data = arr.join("&");
					   		itour.logicdeleteForm(Action.logicremove,data,function(result){
								itour.closeProgress();
								Events.refresh();
								//回调函数
								itour.alert('提示',result.msg||'删除成功.','info');
								/*if(jQuery.isFunction(callback)){
									console.log(result);
									callback(result);
								}*/
							});
					    }  
					});
				}
			},//保存调用方法
			save: function(callback){
				if(Form.edit.form('validate')){
					itour.progress();
					Form.edit.attr('action',Action.save);
					var parentId =$('#search_parentId').val();
					$("#edit_parentId").val(parentId);
				    //var beforeInstruction = CKEDITOR.replace("beforeInstruction", { "toolbar": "Basic" }); //显示编辑器
				/*    beforeInstruction.document.getBody().getHtml();
			            CKFinder.setupCKEditor(editor, "ckfinder/"); //设置图片管理组件
			            //处理CKEDITOR的值
			            function CKupdate() {
			                for (instance in CKEDITOR.instances)
			                    CKEDITOR.instances[instance].updateElement();
			            }
		            CKupdate(); //在提交表单前需要做以上处理
*/ 				try{
					if(CKEDITOR.instances.length>0){
						Form.edit.attr("beforeInstruction",CKEDITOR.instances.beforeInstruction.getData());
						Form.edit.attr("customizedService",CKEDITOR.instances.customizedService.getData());
						Form.edit.attr("designConcept",CKEDITOR.instances.designConcept.getData());	
					}
				}catch(e){
					console.log("name: " + e.name + 
							 ",description: " +e.description+
						      ",message: " + e.message + 
						      ",lineNumber: " + e.lineNumber + 
						      ",fileName: " + e.fileName + 
						      ",stack: " + e.stack);
				}
				var tickets= $("input[name='tickets']");
				var ticketprices = $("input[name='ticketprices']");
					if(tickets.length>0 && ticketprices.length>0){
						var fullyearTicket = !$("input:radio[name='isfullyearTicket']:checked").val()||$("input:radio[name='isfullyearTicket']:checked").val()=="1";
						var ticketsBlock = "";
						if(fullyearTicket){
							ticketsBlock += "淡季："
							$(ticketprices).each(function(i,e){
								if(i>=4){
									if(i==8){ ticketsBlock += "旺季："};
									if(tickets[i].value && ticketprices[i].value){
										ticketsBlock+=tickets[i].value+":"+ticketprices[i].value+"、";
									}
								}
							});
						}else{
							$(ticketprices).each(function(i,e){
								if(i<4){
									if(tickets[i].value && ticketprices[i].value){
										ticketsBlock+=tickets[i].value+":"+ticketprices[i].value+"、";
									}
								}
							})
						}
						//console.log(ticketsBlock+"    "+fullyearTicket+"  "+$("input:radio[name='isfullyearTicket']:checked").val());
						Form.edit[0].ticketsBlock.value=ticketsBlock;
						Form.edit[0].fullyearTicket.value=fullyearTicket;
						//Form.edit.attr("ticketsBlock",ticketsBlock);
						//Form.edit.attr("fullyearTicket",fullyearTicket);
					} 
					//console.log(Form.edit.serializeJSON());
					itour.saveForm(Form.edit,function(data){
						itour.closeProgress();
						Win.edit.dialog('close');
					    Events.refresh();
					    Form.edit.resetForm();
					     //回调函数
						if(jQuery.isFunction(callback)){
							//console.log(callback(data));
							callback(data);
						}else{
							itour.alert('提示',data.msg||'保存成功！','info');
						}
					});
				 }
			},
			saveas: function(callback){
				if(Form.edit.form('validate')){
					itour.progress();
					Form.edit.attr('action',Action.save);
					var parentId =$('#search_parentId').val();
					$("#edit_parentId").val(parentId);
				    //var beforeInstruction = CKEDITOR.replace("beforeInstruction", { "toolbar": "Basic" }); //显示编辑器
				/*    beforeInstruction.document.getBody().getHtml();
			            CKFinder.setupCKEditor(editor, "ckfinder/"); //设置图片管理组件
			            //处理CKEDITOR的值
			            function CKupdate() {
			                for (instance in CKEDITOR.instances)
			                    CKEDITOR.instances[instance].updateElement();
			            }
		            CKupdate(); //在提交表单前需要做以上处理
*/ 				try{
					if(CKEDITOR.instances.length>0){
						Form.edit.attr("beforeInstruction",CKEDITOR.instances.beforeInstruction.getData());
						Form.edit.attr("customizedService",CKEDITOR.instances.customizedService.getData());
						Form.edit.attr("designConcept",CKEDITOR.instances.designConcept.getData());	
					}
				}catch(e){
					console.log("name: " + e.name + 
							 ",description: " +e.description+
						      ",message: " + e.message + 
						      ",lineNumber: " + e.lineNumber + 
						      ",fileName: " + e.fileName + 
						      ",stack: " + e.stack);
				}
					Form.edit[0].id.value='';
					console.log(Form.edit.serializeJSON());
					itour.saveForm(Form.edit,function(data){
						itour.closeProgress();
						Win.edit.dialog('close');
					    Events.refresh();
					    Form.edit.resetForm();
					     //回调函数
						if(jQuery.isFunction(callback)){
							//console.log(callback(data));
							callback(data);
						}else{
							itour.alert('提示',data.msg||'另存成功！','info');
						}
					});
				 }
			},
			//关闭按钮事件
			close:function (callback){
				$.messager.confirm('确认','你确认关闭窗口?',function(r){  
				    if (r){  
				     	Win.edit.dialog('close');
				     	//回调函数
						if(jQuery.isFunction(callback)){
			  				callback(data);
						}
		  		    }
				});
			}
		}
		
		//Grid 工具类
		var Utils = {
			getCheckedRows : function(){
				return Grid.datagrid('getChecked');			
			},
			checkSelect : function(rows){//检查grid是否有勾选的行, 有返回 true,没有返回true
				var records =  rows;
				if(records && records.length > 0){
					return true;
				}
				itour.alert('警告','请选中一条记录.','warning');  
				return false;
			},
			checkSelectOne : function(rows){//检查grid是否只勾选了一行,是返回 true,否返回false
				var records = rows;
				if(!Utils.checkSelect(records)){
					return false;
				}
				if(records.length == 1){
					return true;
				}
				itour.alert('警告','只能选择一行记录.','warning');  
				return false;
			}
		}
		//自定义事件
		var evt= config.event || {};
		
		//默认事件
		var Events ={
			//serach 查询事件
			search: evt.search || Handler.search,
			//add按钮事件
			add: evt.add || Handler.add,
			//edit 按钮事件
			edit: evt.edit || Handler.edit,
			//刷新Grid 数据
			refresh: evt.refresh || Handler.refresh,
			//删除记录
			remove: evt.remove || Handler.remove,
			//逻辑删除记录
			logicremove:evt.logicremove||Handler.logicremove,
			//保存调用方法
			save: evt.save || Handler.save,
			//另存为新
			saveas:evt.saveas||Handler.saveas,
			//关闭按钮事件
			close : evt.close ||  Handler.close//,
			//上传图片的事件
			//uploadImg:evt.uploadImg||Handler.uploadImg
		}
		
		//按钮控制 btnType 用来控制按钮是否显示,后台根据授权控制是否显示
		var bar_add ={	
						id:'btnadd',
						text:'添加',
						iconCls:'icon-add',
						btnType:'add',
						handler: Events.add
					 };
		var bar_edit = {
						id:'btnedit',
						text:'修改',
						iconCls:'icon-edit',
						btnType:'edit',
						handler: Events.edit
						};
		var bar_remove = { id:'btnremove',
						text:'物理删除',
						iconCls:'icon-remove',
						btnType:'remove',
						handler:Events.remove
					   };
		var bar_logicremove = { id:'btnlogicremove',
						text:'删除',
						iconCls:'icon-remove',
						btnType:'logicremove',
						handler:Events.logicremove
					   };
	/*	var bar_upload={id:'btnupload',
						text:'上传图片',
					//	iconCls:'icon_upload',
						btnType:'upload',
						handler:Events.uploadImg
					  };*/
		var toolbarConfig = [bar_add,bar_edit,bar_remove,bar_logicremove];
		var getToolbar = function (){
			var tbars = [];
			//console.log(dataGrid.toolbar);
			if (dataGrid.toolbar != undefined && dataGrid.toolbar.length > 0) {
				for (var i = 0; i < dataGrid.toolbar.length; i++) {
					var bar = dataGrid.toolbar[i];
					if(!bar){
						continue;
					}
					if(bar.btnType=='add'){
						tbars.push({id:bar.id || bar_add.id,text:bar.text || bar_add.text ,iconCls: bar.iconCls || bar_add.iconCls, btnType: bar.btnType || bar_add.btnType,handler:bar.handler || bar_add.handler});
						continue;
					}
					if(bar.btnType=='edit'){
						tbars.push({id:bar.id || bar_edit.id,text:bar.text || bar_edit.text ,iconCls: bar.iconCls || bar_edit.iconCls,btnType: bar.btnType || bar_edit.btnType,handler:bar.handler || bar_edit.handler});
						continue;
					}
					if(bar.btnType=='remove'){
						tbars.push({id:bar.id || bar_remove.id,text:bar.text || bar_remove.text ,iconCls: bar.iconCls || bar_remove.iconCls,btnType: bar.btnType || bar_remove.btnType,handler:bar.handler || bar_remove.handler});
						continue;
					}
					if(bar.btnType=='logicremove'){
						tbars.push({id:bar.id || bar_logicremove.id,text:bar.text || bar_logicremove.text ,iconCls: bar.iconCls || bar_logicremove.iconCls,btnType: bar.btnType || bar_logicremove.btnType,handler:bar.handler || bar_logicremove.handler});
						continue;
					}
		 		   /*if(bar.btnType=='upload'){
						tbars.push({id:bar.id || bar_upload.id,text:bar.text || bar_upload.text ,iconCls: bar.iconCls || bar_upload.iconCls,btnType: bar.btnType || bar_upload.btnType,handler:bar.handler || bar_upload.handler});
						continue;
					}*/
					tbars.push({id:bar.id,text:bar.text,iconCls:bar.iconCls,btnType: bar.btnType,handler:bar.handler,disabled:bar.disabled});
				}
			}else{
				tbars = toolbarConfig;
			}
			return tbars;
		}
	
		//初始化表格
		var initGrid = function(){
			//console.log(dataGrid.method);
			var dataconfig = {
				title: dataGrid.title || 'Data List',
				iconCls: dataGrid.iconCls || 'icon-save',
				fit:true,
				//height: dataGrid.height || 365,
				border:false,
				nowrap: true,
				autoRowHeight: false,
				striped: false,
				collapsible:false,
				remoteSort: false,
				pagination:true,
				rownumbers:true,
				singleSelect:false,
				checkOnSelect:false,
				selectOnCheck:false,
				url: dataGrid.url,
				method: dataGrid.method || 'post',
				loadMsg: dataGrid.loadMsg || 'Loading in ...',
				idField: dataGrid.idField,
				columns: dataGrid.columns,
				toolbar: getToolbar(),
				onLoadSuccess: dataGrid.onLoadSuccess || function(){
					Grid.datagrid('unselectAll');
					Grid.datagrid('uncheckAll');
				},
				onSelect:function(rowIndex, rowData){
					var rows = Grid.datagrid('getRows');//选择一行
					$.each(rows,function(i){
						if(i != rowIndex){
							Grid.datagrid('uncheckRow',i);
							Grid.datagrid('unselectRow',i);
						}
					})
					Grid.datagrid('checkRow',rowIndex);
				}
			};
			Grid.datagrid(dataconfig);
		}
		//初始化Grid按钮 按钮控制
		var initTbar = function(){
			var tbars = getToolbar();
			//console.log(tbars);	
			var _url = urls['msUrl'] + 'main/getActionBtn';
			var params = {'url':window.location.href};
			//查询页面授权的btnType  
			//console.log(_url);	
			//console.log(data);	
			itour.ajaxJson(_url,params,function(data){
				//console.log(data);
				if(data.success||data.success=='true'){
					if(data.allType){
						//console.log(tbars);
						Grid.datagrid({'toolbar':tbars});
					}else{
						var newBars = [];
						jQuery.inArray("John", data.types);				
						for(var i=0;i< tbars.length; i++){
							var bar = tbars[i];
							//btnType 为空显示
							if(!bar.btnType){
								newBars.push(bar);		
							}else{
								//判断btnType是否存在,存在则显示
								//console.log($.inArray(bar.btnType, data.types));
								if($.inArray(bar.btnType, data.types) >= 0 ){
									newBars.push(bar);
								}	
							}
						}
						//console.log(newBars);
						if(newBars.length > 0){
							Grid.datagrid({'toolbar':newBars});
						}
					}
				}else{
					itour.alert('提示',data.msg||'YDataGrid ajaxJson请求出现异常,请联系管理员','info');
				}
			});
		}
		
		//初始化form
		var initForm = function(){
			if(Form.search && Form.search[0]){
				Form.search.find("#btn-search").click(Events.search); //保存事件
			}
		}
		
		var initWin = function(){
			if(Win.edit && Win.edit[0]){
				//判断页面是否设置buttons，如果没有设置默认按钮
				var btns = Win.edit.attr("buttons");
				if(!btns){
					if($("#beforeInstruction").length>0 &&$("#customizedService").length>0 &&$("#designConcept").length>0){
						//设置 保存,关闭按钮
						Win.edit.dialog({
							buttons:[
								{
									text:'另存为新线路',
									handler:Events.saveas
								},    
								{
									text:'保存',
									handler:Events.save
								},{
									text:'关闭',
									handler:Events.close
								}
							]
						});
					}else{
						Win.edit.dialog({
							buttons:[
								{
									text:'保存',
									handler:Events.save
								},{
									text:'关闭',
									handler:Events.close
								}
							]
						});
					}
				}
				Win.edit.find("#btn-submit").click(Events.save); //保存事件
				Win.edit.find("#btn-close").click(Events.close);//关闭窗口
			}
		}
		//this 返回属性
		this.win = Win;
		this.form = Form;
		this.grid = Grid;
		this.utils = Utils;
		this.handler = Handler;
		
		
		//初始化方法
		this.init = function(){
			initGrid();
			initTbar();
			initForm();
			initWin();
		}
		//调用初始化
		return this;
};