$package('itour.hiking');
itour.hiking = function(){
	var _this = {
			fbpagination:function(pageno){
			            var element = $('#fbpage');
			            var route = $("input[name='idrt']").val();
			        	$.ajax({
							dataType:"json",
							url:basePath+"feedback/pagination",
							data:{'route':route,'pageNo':pageno},
							type:"post",
							cache: false,
							async:false,
							success:function(responseText){
								if(responseText.success){
									//console.log(responseText);
									var data = responseText.result.records;
									var html="";
									$(data).each(function(i,e){
										//console.log(data[i]);
										html+='<table width="715" border="0" cellpadding="2" cellspacing="2" class="STYLE126">'+
								              '<tr>'+
								                '<td width="150"><div align="center"></div>'+
								                  (e.sex||e.sex==1 ? '<img src="images/man.gif" width="32" height="32" /></td>':'<img src="images/woman.gif" width="32" height="32" /></td>')+
								                '<td width="669" style="text-align:left"><strong>'+(e.customerName?e.customerName:"")+'</strong> <span class="STYLE140">'+(e.preferedDate?e.preferedDate:"")+' </span></td>'+
								              '</tr>'+
								              '<tr>'+
								                '<td width="150">'+(e.createTime?e.createTime:"")+'</td>'+
								                '<td style="text-align:left"><span class="STYLE148">'+(e.content?e.content:"")+'</span></td>'+
								              '</tr>'+
								              '<tr>'+
								                '<td>&nbsp;</td>'+
								                '<td style="text-align:left">Re：'+(e.result?e.result:"")+'</td>'+
								              '</tr>'+
								             /* '<tr>'+
								                '<td>&nbsp;</td>'+
								                '<td>&nbsp;</td>'+
								              '</tr>'+*/
								            '</table>';
									});
									$("#fbcontent").append(html);		
									   var options = {
											   bootstrapMajorVersion: 3, //bootstrap版本
											   size: 'normal',
											   itemTexts: function (type, page, current) {
												   switch (type) {
													   case "first":
													   return "首页";
													   case "prev":
													   return "<i class='fa fa-caret-left'></i> 上一页";
													   case "next":
													   return "下一页 <i class='fa fa-caret-right'></i>";
													   case "last":
													   return "末页";
													   case "page":
													   return page;
												   }
											   },
											/*   tooltipTitles: function (type, page, current) {
												   switch (type) {
													   case "first":
													   return "首页";
													   case "prev":
													   return "上一页";
													   case "next":
													   return "下一页";
													   case "last":
													   return "末页";
													   case "page":
													   return "第" + page + "页";
												   }
											   },*/
											   useBootstrapTooltip:true,
											 /*  pageUrl: function(type, page, current){
												   $("#fbcontent").empty();  
												   return fbpagination(page.pageNo);
												   //return basePath+"feedback/pagination?route="+route+"&pageNo="+page; //跳转到选定页面
											   },*/
											   onPageClicked:function(event, originalEvent, type, page){
												   $("#fbcontent").empty();  
												   return _this.fbpagination(page);
											   },
											   numberOfPages: 6, //显示“第几页”的选项数目
											   currentPage: responseText.result.pager.pageId, //当前页数
											   totalPages:responseText.result.pager.pageCount, //总页数
											//   shouldShowPage:true,//是否显示该按钮
											   }
								            element.bootstrapPaginator(options);
								           /* ok(!element.hasClass('pagination-lg'),"Root element shouldn't have pagination-lg class");
								            ok(!element.hasClass('pagination-sm'),"Root element shouldn't have pagination-sm class");
								            var list = element.children();
								            for(var i=0;i < list.length;i++)
								            {
								                var item = $(list[i]);
								                ok(item.is("li"),"Element "+i+" should be li");
								            }
								            ok(element.hasClass('pagination-sm'),"Root element should have pagination-sm class");*/
								}
							},
							beforeSend:function(data) { 
								$("#fbcontent").empty(); 
							  }, 
							error:function(err){
								console.log(err);
							}
						});
			},
			printff:function(){
				//window.print();
				//document.execCommand("print") ;
			    html2canvas(document.innerHTML, {
			        onrendered: function(canvas) {
			            //通过html2canvas将html渲染成canvas，然后获取图片数据
			            var imgData = canvas.toDataURL('image/jpeg');
			            //初始化pdf，设置相应格式
			            var doc = new jsPDF("p", "mm", "a4");
			            //这里设置的是a4纸张尺寸
			            doc.addImage(imgData, 'JPEG', 0, 0,210,297);
			            //输出保存命名为content的pdf
			            doc.save(document.title+new Date().getTime()+'.pdf');
			        }
			    });
			},
			copyUrl:function(){
				var clipBoardContent=window.location.href;
				document.getElementById("flashcopier").innerHTML = clipBoardContent;
				var client =new ZeroClipboard(document.getElementById("copyurl"));
				// 当Flash SWF文件加载完成并准备就绪时触发ready事件
				//client.on("ready", function(){ alert("加载完成!"); });//beforecopy,copy
				// 当触发copy事件时，设置用于复制的文本数据
				//复制成功： 
				client.on( "aftercopy", function(){
				    itour.alert('提示', "复制成功！",'info');
				});
			},
			addFavorite:function () {
				var url = window.location;
				var title = document.title;
				//var ua = navigator.userAgent.toLowerCase();window.external.ImportExportFavorites(true,)
				var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd': 'CTRL';
				try{
					if (document.all) { //IE类浏览器
						try {
							window.external.addFavorite(url	,title);
							//window.external.ImportExportFavorites(true);
						}
						catch (e){
							try{
								window.external.toString(); //360浏览器不支持window.external，无法收藏
								window.alert("国内开发的360浏览器等不支持主动加入收藏。\n您可以尝试通过浏览器菜单栏 或快捷键 ctrl+D 试试。");
							}
							catch (e){
								window.external.addToFavoritesBar(url,title);  //IE8
							}
						}
					}else if (window.sidebar) { //firfox等浏览器
						window.sidebar.addPanel(url	,title, "");
					}else if(window.opera){
						alert('opera您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');
					}else{
						alert('您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');
					}
				}
				catch (e){
					window.alert("因为IE浏览器存在bug，添加收藏失败！\n解决办法：在注册表中查找\n HKEY_CLASSES_ROOT\\TypeLib\\{EAB22AC0-30C1-11CF-A7EB-0000C05BAE0B}\\1.1\\0\\win32 \n将 C:\\WINDOWS\\system32\\shdocvw.dll 改为 C:\\WINDOWS\\system32\\ieframe.dll ");
				}
			},ajaxSubmit:function (form,option){
				form.ajaxSubmit(option);
				$(this).resetForm(); // 提交后重置表单
				_this.fbpagination(1);
				return false;
			},submitform:function (){
			    document.forms["fastask"].method="post";
	    	    document.forms["fastask"].action=basePath+"feedback/add";
				if($(document.forms["fastask"]).form('validate')){
					var option =
						{type:'post',
					 	timeout:3000,
					 //	iframe: true,
					 	async:false,  //异步请求
					 	success:function(data){
					 		var jsondata= $.parseJSON(data);//$(data).text()
				 			//console.log(data);
							itour.closeProgress();
						 	if(jsondata.success||jsondata.success=="true"){
					       		 itour.alert('提示','保存成功.','info');
						       	 document.forms["fastask"].reset();
					        }else{
					        	itour.alert('提示', jsondata.msg || "请求出现异常,请联系管理员",'error'); 
					        }
					 	},
					 	error:function(response, textStatus, errorThrown){
				 			itour.alert('提示',"请求出现异常,请联系管理员.",'error');
					 	}
					 }
			   		 itour.progress('Please waiting','Saving...');
					_this.ajaxSubmit($(document.forms["fastask"]),option);
					 return false;
				}
			},
			replaceInput:function(html){
				var div = document.createElement('div');   
    		    div.innerHTML=html;
				var olist = html.getElementsByTagName('input');// $(html).find("input");// 
			    for(var i=0;i<olist.length;i++){
			        var obj = document.createElement('span');
			        obj.innerText = olist[i].value;
			       // document.body.appendChild(obj);
			        olist[i].parentNode.replaceChild(obj,olist[i]);
			    }
			    return html;
			},
			checkedAll:function (name){//全选
				  var names=document.getElementsByName(name);
				  var len=names.length;
				  if(len>0){
				   for(var i=0;i<len;i++)
				   names[i].checked=true;
				  }
			},
			uncheckedAll:function (name){//全不选
					var names=document.getElementsByName(name);
					var len=names.length;
					if(len>0){
					    for(var i=0;i<len;i++)
					    names[i].checked=false;
					  }
			},
		init:function(){
			$("input[name='route_checkall']").click(function(){
				if($(this).attr("checked")){
					_this.checkedAll("breakfast");
					_this.checkedAll("lunch");
					_this.checkedAll("dinner");
				}else{
					_this.uncheckedAll("breakfast");
					_this.uncheckedAll("lunch");
					_this.uncheckedAll("dinner");
				}
			});
			$("a.imgBorder img").on('click',function(){
				$(this).parents("tr").prev().find("td img").attr("src",$(this).attr("src"));
				//$("td[name='magnifying'] img").attr("src",$(this).attr("src"));
			});
			$("a.imgBorder img").on('mouseover',function(){
				//$("td[name='magnifying'] img").attr("src",$(this).attr("src"));
				$(this).parents("tr").prev().find("td img").attr("src",$(this).attr("src"));
			});
			//扩展easyui表单的验证  
			$.extend($.fn.validatebox.defaults.rules, { 
			    phoneNum: { //验证手机号   
			        validator: function(value, param){ 
			         return /^1[3-8]+\d{9}$/.test(value);
			        },    
			        message: '请输入正确的手机号码。'   
			    }
			})
	/*   $('#tab-container').easytabs({ 
		   	 auto:false,
	    	 // uiTabs: true,
	    	  animate: false,
	    	  animationSpeed: 1000,
	    	  //defaultTab: "a#review",
	    	  panelActiveClass: "active-content-div",
	    	  tabActiveClass: "selected-tab",
	    	//  tabs: "> div > a",
	    	  updateHash: false,
	    	  event:'click',
	    	  cycle: false
	      }).bind('easytabs:after', function(evt, tab, panel, data) {
	    	   if(tab.attr("href")=="#feed-back"){
	    		  
	    	   };
	    	   //$('#tab-console').find('.logged-event-group').last().append("<span class='logged-event'>easytabs:after fired</span>");
	      });*/
	    // Google Analytics tracking code 
	      var _gaq=[['_setAccount','UA-2508361-9'],['_trackPageview']];
	      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
	      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
	      s.parentNode.insertBefore(g,s)}(document,'script'));
	      _this.fbpagination(1);
	      $("input[name='SubmitSend']").click(function(){
	    	  _this.submitform();
	      });
	      $(document).keydown(function(e){
	    		 e = e || window.event;
	    		if(e.keyCode == 13) {
	    			_this.submitform();
	    		}
    	});
		}
	}
	return  _this;
}();

$(function(){
	   itour.hiking.init();
	   itour.hiking.copyUrl();
	   var homeurl = window.location.href;
});
