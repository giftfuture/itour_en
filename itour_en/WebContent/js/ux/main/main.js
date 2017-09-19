$package('itouren.main');
itouren.main = function(){
	return {
		treeSelect:function(){
			var _this = $(this);
			var title=_this.text();
			var url=_this.attr('href');
			itouren.main.addTab(title,url);
			return false;
		},
		treeInit:function(){
			var  $items =  $('#tree-box').find(".menu-item");
			$items.bind('click',this.treeSelect);
		},
		addTab:function(_title,_url){
			var boxId = '#tab-box';
			if($(boxId).tabs('exists',_title) ){
				var tab = $(boxId).tabs('getTab',_title);
				var index = $(boxId).tabs('getTabIndex',tab);
				$(boxId).tabs('select',index);
				if(tab && tab.find('iframe').length > 0){  
					 var _refresh_ifram = tab.find('iframe')[0];  
				     _refresh_ifram.contentWindow.location.href=_url;  
			    } 
			}else{		
				var _content ="<iframe scrolling='auto'" +
						/*" onload=javascript:this.height=document.frames(this.name).document.body.scrollHeight+30" +*/
						" frameborder='0' src='"+_url+"' style='width:100%; height:100%'></iframe>";
				$(boxId).tabs('add',{
					    title:_title,
					    content:_content,
					    closable:true});
				
			}
		},
		menuHover:function(){
			//菜单鼠标进入效果
			$('.menu-item').hover(
				function () {
					$(this).stop().animate({ paddingLeft: "25px" }, 200,function(){
						$(this).addClass("orange");
					});
				}, 
				function () {
					$(this).stop().animate({ paddingLeft: "15px" },function(){
						$(this).removeClass("orange");
					});
				}
			);
		},
		modifyPwd:function(){
			var pwdForm = $("#pwdForm");
			if(pwdForm.form('validate')){
				var parentId =$('#search_parentId').val();
				$("#edit_parentId").val(parentId)
				itouren.saveForm(pwdForm,function(data){
					$('#modify-pwd-win').dialog('close');
				    pwdForm.resetForm();
				});
			 }
		},
		getCookie : function (name){
		     var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		     if(arr=document.cookie.match(reg))
		     return unescape(arr[2]);
		     else
		     return null;
	     },
	     setCookie : function (name,value){
		     var exp = new Date();
		     exp.setTime(exp.getTime() + 60*60*1000);
		     document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	     },
	     unDealedOrders:function(){
	    		$.ajax({
	    			url:basePath+'travelOrder/unDealedOrders',
	    			method:'post',
	    			async:false,
	    			data:{},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						$("table[name='unDealedOrders']").html('');
						if(resp.success||resp.success=="true"){
							$("table[name='unDealedOrders']").append("<tr><td style='text-align:left;' colspan=6><b>待处理订单</b></td></tr>");
							$("table[name='unDealedOrders']").append("<tr><td style='text-align:center;'>序号</td><td style='text-align:center;'>姓名</td><td style='text-align:center;'>旅行日期</td>" +
									"<td style='text-align:center;'>线路</td><td style='text-align:center;'>下单时间</td><td style='text-align:center;'>详情</td></tr>");
							$(resp.data).each(function(idx,ex){
								if(ex.id && ex.routeId && ex.orderName){
									$("table[name='unDealedOrders']").append("<tr><td style='text-align:center;'>"+(idx+1)+"</td><td style='text-align:center;'>"+ex.receiver+"</td><td style='text-align:center;'>"+ex.expectedDepart+"</td>" +
									"<td style='text-align:left;'><a target='_blank' href="+basePath+"travelOrder/toQuote1/"+ex.id+"/"+ex.routeId+">"+ex.orderName+"</a></td><td style='text-align:center;'>"+ex.createTime+"</td><td style='text-align:center;'><a  onclick='javascript:itouren.main.unDealedOrdersWin(\""+ex.id+"\")' href='javascript:void(0)'>详情</a></td></tr>");
									/*$("#unDealedOrders").append("<p>("+(idx+1)+").<a target='_blank' href="+basePath+"travelOrder/toQuote1/"+ex.id+"/"+ex.routeId+">"+ex.orderName+"</a></p>");*/
								}
							});
						}else{
							$("table[name='unDealedOrders']").append("<tr><td style='text-align:left;'>无待处理订单!</td></tr>");
						}
					
	    			}
				});
	     },
	     unDealedDiarys:function(){
	    		$.ajax({
	    			url:basePath+'unDealedDiarys',
	    			method:'post',
	    			async:false,
	    			data:{},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						$("table[name='unDealedDiarys']").html('');
						if(resp.success||resp.success=="true"){
							$("table[name='unDealedDiarys']").append("<tr><td style='text-align:left;' colspan=6><b>待处理游记</b></td></tr>");
							$("table[name='unDealedDiarys']").append("<tr><td style='text-align:center;'>序号</td><td style='text-align:center;'>姓名</td><td style='text-align:center;'>旅行日期</td>" +
									"<td style='text-align:center;'>晒出时间</td><td style='text-align:center;'>所属线路</td><td style='text-align:center;'>处理</td></tr>");
							$(resp.data).each(function(idx,ex){
								//if(ex.id && ex.routeId && ex.orderName){
									$("table[name='unDealedDiarys']").append("<tr><td style='text-align:center;'>"+(idx+1)+"</td><td style='text-align:center;'>"+(ex.signature?ex.signature:customerName)+"</td><td style='text-align:center;'>"+ex.tourTime+"</td>" +
									"<td style='text-align:center;'>"+ex.createTime+"</td><td style='text-align:center;'>"+ex.routeTitle+"</td><td style='text-align:center;'><a onclick='javascript:itouren.main.unDealedDiarysWin(\""+ex.id+"\")' href='javascript:void(0)'>处理</a></td></tr>");
								//}
							});
						}else{
							$("table[name='unDealedDiarys']").append("<tr><td style='text-align:left;'>无待处理游记!</td></tr>");
						}
					
	    			}
				});
	     },
	     unCheckedMsgs:function(){
	    		$.ajax({
	    			url:basePath+'feedback/unCheckedMsgs',
	    			method:'post',
	    			async:false,
	    			data:{},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						$("table[name='unCheckedMsgs']").html('');
						if(resp.success||resp.success=="true"){
							$("table[name='unCheckedMsgs']").append("<tr><td style='text-align:left;' colspan=6><b>待审核留言</b></td></tr>");
							$("table[name='unCheckedMsgs']").append("<tr><td style='text-align:center;'>序号</td><td style='text-align:center;'>姓名</td><td style='text-align:center;'>反馈时间</td>" +
									"<td style='text-align:center;'>所属线路</td><td style='text-align:center;'>内容</td><td style='text-align:center;'>处理</td></tr>");
							$(resp.data).each(function(idx,ex){
								//if(ex.id && ex.routeId && ex.orderName){
									$("table[name='unCheckedMsgs']").append("<tr><td style='text-align:center;'>"+(idx+1)+"</td><td style='text-align:center;'>"+ex.customerName+"</td><td style='text-align:center;'>"+ex.createTime+"</td>" +
									"<td style='text-align:center;'>"+ex.routeName+"</td><td style='text-align:left;'>"+ex.content+"</td><td style='text-align:center;'><a  onclick='javascript:itouren.main.unCheckedMsgsWin(\""+ex.id+"\")' href='javascript:void(0)'>处理</a></td></tr>");
								//}
							});
						}else{
							$("table[name='unCheckedMsgs']").append("<tr><td style='text-align:left;'>无待审核留言!</td></tr>");
						}
					
	    			}
				});
	     },
	     unDealedOrdersWin:function(orderId){
	    	 $.ajax({
	    			url:basePath+'travelOrder/orderAndDetail',
	    			method:'post',
	    			async:false,
	    			data:{'id':orderId},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						if(resp.success||resp.success=="true"){
							for(var item in resp.data){
								$("#unDealedOrdersWin").find("span[name='"+item+"']").text(resp.data[item]);
							}
							$("#unDealedOrdersWin").find("span[name='gender']").text(resp.data['gender']?'女':'男');
						}
	    			}
				});
	    	 $("#unDealedOrdersWin").window('open');
	     },
	     unDealedDiarysWin:function(shId){
	    	 $.ajax({
	    			url:basePath+'showhappy-shDetail',
	    			method:'post',
	    			async:false,
	    			data:{'shId':shId},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						//console.log(resp);
						if(resp.success||resp.success=="true"){
							$("#unDealedDiarysWin").find("input[name='id']").val(resp.data["id"]);
							$("#unDealedDiarysWin").find("span[name='title']").text(resp.data["title"]);
							$("#unDealedDiarysWin").find("img[name='cover']").attr("src",resp.data["cover"]);
							$("#unDealedDiarysWin").find("span[name='route']").text(resp.data["routeTitle"]);
							$("#unDealedDiarysWin").find("span[name='tourTime']").text(resp.data["tourTime"]);
							$("#unDealedDiarysWin").find("span[name='email']").text(resp.data["email"]);
							$("#unDealedDiarysWin").find("span[name='signature']").text(resp.data["signature"]);
							$("#unDealedDiarysWin").find("span[name='area']").text(resp.data["areaname"]);
							$("#unDealedDiarysWin").find("#content").html(resp.data["content"]);
						}
	    			}
				});
	    	 $("#unDealedDiarysWin").window('open');
	     },unCheckedMsgsWin:function(fbId){
	    	 $.ajax({
	    			url:basePath+'feedback/getId',
	    			method:'post',
	    			async:false,
	    			data:{'id':fbId},
	    			success:function(responseText){
						var resp = $.parseJSON(responseText);
						if(resp.success||resp.success=="true"){
							$("#unCheckedMsgsWin").find("input[name='id']").val(resp.data["id"]);
							$("#unCheckedMsgsWin").find("span[name='name']").text(resp.data["customerName"]);
							$("#unCheckedMsgsWin").find("span[name='sex']").text(resp.data["sex"]=="1"?"女":"男 ");
							$("#unCheckedMsgsWin").find("span[name='email']").text(resp.data["email"]);
							$("#unCheckedMsgsWin").find("span[name='mobile']").text(resp.data["mobile"]);
							$("#unCheckedMsgsWin").find("div[name='content']").text(resp.data["content"]);
						}
	    			}
				});
	    	 $("#unCheckedMsgsWin").window('open');
	     },
		init:function(){
			this.treeInit();
			this.menuHover();
			this.unDealedOrders();
			this.unCheckedMsgs();
			this.unDealedDiarys();
			$("#btn-checkmsg-close").click(function(){$("#unCheckedMsgsWin").dialog('close')});
			$("#btn-diary-close").click(function(){$("#unDealedDiarysWin").dialog('close')});
			$("#btn-Orders-close").click(function(){$("#unDealedOrdersWin").dialog('close')});
			$("#unDealedDiarysWin").find("#btn-diary-submit").click(function(){
				//$("#unDealedDiarysWin").find("form")[0].submit();
				var form = $("#unDealedDiarysWin").find("form")[0];
				//console.log(form.status.value);
				//console.log(form.result.value);
				$.post(basePath+'showhappy/save',{'id':$("#unDealedDiarysWin").find("input[name='id']").val(),'status':form.status.value,'result':form.result.value},
						function(result){
							var resp = $.parseJSON(result);
							if(resp.success||resp.success=="true"){
								itour.alert('提示',"处理成功！"||result.msg,'info',function(){
									 $("#unDealedDiarysWin").dialog('close');
									 itouren.main.unDealedDiarys();
								});
							}
						})
			});
			$("#unCheckedMsgsWin").find("#btn-checkmsg-submit").click(function(){
				var form = $("#unCheckedMsgsWin").find("form")[0];
				//console.log(form.status.value);
				//console.log(form.result.value);
				$.post(basePath+'feedback/save',{'id':$("#unCheckedMsgsWin").find("input[name='id']").val(),'status':form.status.value,'result':form.result.value},
				function(result){
					var resp = $.parseJSON(result);
					if(resp.success||resp.success=="true"){
						itour.alert('提示',"处理成功！"||result.msg,'info',function(){
							 $("#unCheckedMsgsWin").dialog('close');
							 itouren.main.unCheckedMsgs();
						});
					}
				})
			});
			$(document).keyup(function(ev){
				var oEvent=ev||event;//获取事件对象(IE和其他浏览器不一样，这里要处理一下浏览器的兼容性event是IE；ev是chrome等)
				 switch(oEvent.keyCode) {
				 case 27:
					 $("#unCheckedMsgsWin").dialog('close');
					 $("#unDealedDiarysWin").dialog('close');
					 $("#unDealedOrdersWin").dialog('close');
				 case 96:
					 $("#unCheckedMsgsWin").dialog('close');
					 $("#unDealedDiarysWin").dialog('close');
					 $("#unDealedOrdersWin").dialog('close');
				 }
				});
			//修改密码绑定事件
			$('.modify-pwd-btn').click(function(){
				$('#modify-pwd-win').dialog('open');
			});
			$('#btn-pwd-close').click(function(){
				$('#modify-pwd-win').dialog('close');
			});
			$('#btn-pwd-submit').click(this.modifyPwd);
			
		}
	};
}();

$(function(){
	 /* if (window != top)
          top.location.href = location.href;*/
	itouren.main.init();
});		