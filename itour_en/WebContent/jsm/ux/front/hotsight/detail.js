$package('itouren.hotsightdetail');
itouren.hotsightdetail = function(){
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
										html+='<table width="63%" border="0" cellpadding="2" cellspacing="2" class="STYLE126">'+
								              '<tr>'+
								                '<td  width="11%"><div align="center"></div>'+
								                  (e.sex||e.sex==1 ? '<img src="images/man.gif" style="width:32;height:32;" width="32" height="32" /></td>':'<img src="images/woman.gif" style="width:32;height:32;" width="32" height="32" /></td>')+
								                '<td width="59%" style="text-align:left"><strong>'+(e.customerName?e.customerName:"")+'</strong> <span class="STYLE140">'+(e.preferedDate?e.preferedDate:"")+' </span></td>'+
								              '</tr>'+
								              '<tr>'+
								              '<td>&nbsp;</td>' +
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
													   return "Home";
													   case "prev":
													   return "<i class='fa fa-caret-left'></i>Prev";
													   case "next":
													   return "Next <i class='fa fa-caret-right'></i>";
													   case "last":
													   return "Last";
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
				    itouren.alert('alert', "Copy Successfully!",'info');
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
								itouren.alert('alert',"Domestic development of the 360 browser does not support the initiative to join the collection. \ NYou can try using the browser menu bar or the shortcut ctrl + D.",'info');
							}
							catch (e){
								window.external.addToFavoritesBar(url,title);  //IE8
							}
						}
					}else if (window.sidebar) { //firfox等浏览器
						window.sidebar.addPanel(url	,title, "");
					}else if(window.opera){
						itouren.alert('alert','opera You can try via shortcuts' + ctrl + ' + D Add to Favorites ~','info');
					}else{
						itouren.alert('alert',' You can try via shortcuts' + ctrl + ' + D Add to Favorites ~','info');
					}
				}
				catch (e){
					itouren.alert('alert',"Because IE browser bug, add the collection failed! \ N Workaround: Find in the registry\n HKEY_CLASSES_ROOT\\TypeLib\\{EAB22AC0-30C1-11CF-A7EB-0000C05BAE0B}\\1.1\\0\\win32 \n C:\\WINDOWS\\system32\\shdocvw.dll changed to C:\\WINDOWS\\system32\\ieframe.dll ",'info');
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
							itouren.closeProgress();
						 	if(jsondata.success||jsondata.success=="true"){
					       		 itouren.alert('alert',jsondata.message||'Asked Successfully!','info');
						       	 document.forms["fastask"].reset();
					        }else{
					        	itouren.alert('alert', jsondata.msg || "Request an exception, please contact the administrator.",'error'); 
					        }
					 	},
					 	error:function(response, textStatus, errorThrown){
				 			itouren.alert('alert',"Request an exception, please contact the administrator.",'error');
					 	}
					 }
			   		 itouren.progress('Please waiting','Saving...');
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
			//var url = "${basePath}";  
		    //var desc_ = "itours";        
		    tencentWeiBo:function (){  
		         var _url = "${basePath}";     
		         var _showcount = 0;  
		         var _summary = "";  
		         var _title = desc_;  
		         var _site = "${basePath}";    
		         //var _width = "600px";  
		         //var _height = "800px";  
		         var _pic = "${basePath}images/head2016.gif";  
		         var _shareUrl = 'http://share.v.t.qq.com/index.php?c=share&a=index';  
		         _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //分享的标题  
		         _shareUrl += '&url=' + encodeURIComponent(_url||location.href);    //分享的链接  
		         _shareUrl += '&appkey=5bd32d6f1dff4725ba40338b233ff155';    //在腾迅微博平台创建应用获取微博AppKey  
		         //_shareUrl += '&site=' + encodeURIComponent(_site||'');   //分享来源  
		         _shareUrl += '&pic=' + encodeURIComponent(_pic||'');    //分享的图片，如果是多张图片，则定义var _pic='图片url1|图片url2|图片url3....'  
		         window.open(_shareUrl,'width='+_width+',height='+_height+',left='+(screen.width-_width)/2+',top='+(screen.height-_height)/2+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');  
		    },      
		    shareTSina:function () {    
		    	/*title是标题，rLink链接，summary内容，site分享来源，pic分享图片路径,分享到新浪微博*/    
		    	var top = window.screen.height / 2 - 250;    
		    	var left = window.screen.width / 2 - 300;    
		    	var height = window.screen.height;  
		    	var width =  window.screen.width;   
		        var title = desc_;  
		        var   rLink = "${basePath}";  
		        var backUrl = "${basePath}";  
		        var site = desc_;  
		        var pic = "${basePath}images/head2016.gif";  
		        window.open("http://service.weibo.com/share/share.php?pic=" +encodeURIComponent(pic) +"&title=" +     
		        encodeURIComponent(title.replace(/ /g, " ").replace(/<br \/>/g, " "))+ "&url=" + encodeURIComponent(rLink),    
		        "分享至新浪微博",    
		        "height=500,width=600,top=" + top + ",left=" + left + ",toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");    
		    },    
		    qqFriend:function () {  
		            var p = {  
		                url : '${basePath}', /*获取URL，可加上来自分享到QQ标识，方便统计*/  
		                desc:'',  
		                //title : '新玩法，再不来你就out了！', /*分享标题(可选)*/  
		                title:desc_,  
		                summary : '', /*分享摘要(可选)*/  
		                pics : '${basePath}images/head2016.gif', /*分享图片(可选)*/  
		                flash : '', /*视频地址(可选)*/  
		                site : '${basePath}', /*分享来源(可选) 如：QQ分享*/  
		                style : '201',  
		                width : 32,  
		                height : 32  
		            };  
		            var s = [];  
		            for ( var i in p) {  
		                s.push(i + '=' + encodeURIComponent(p[i] || ''));  
		            }  
		            var url = "http://connect.qq.com/widget/shareqq/index.html?"+s.join('&');  
		            return url;  
		            //window.location.href = url;  
		            //document.write(['<a class="qcShareQQDiv" href="http://connect.qq.com/widget/shareqq/index.html?',s.join('&'), '" >分享给QQ好友</a>' ].join(''));  
		        },  
		     qqZone:function(){  
		         var _url = "${basePath}";     
		         var _showcount = 0;  
		         var _desc = desc_;  
		         var _summary = "";  
		         var _title =  "<a href='${basePath}'>主角旅行itours</a>"; // "主角旅行itours";//
		         var _site = "";  
		         //var _width = "600px";  
		        // var _height = "800px";  
		         var _summary = "";  
		         var _pic = "${basePath}images/head2016.gif";  
		         var _shareUrl = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?';  
		         _shareUrl += 'url=' + encodeURIComponent(_url||document.location);   //参数url设置分享的内容链接|默认当前页location  
		         _shareUrl += '&showcount=' + _showcount||0;      //参数showcount是否显示分享总数,显示：'1'，不显示：'0'，默认不显示  
		         _shareUrl += '&desc=' + encodeURIComponent(_desc||'分享的描述');    //参数desc设置分享的描述，可选参数  
		         //_shareUrl += '&summary=' + encodeURIComponent(_summary||'分享摘要');    //参数summary设置分享摘要，可选参数  
		         _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //参数title设置分享标题，可选参数  
		         //_shareUrl += '&site=' + encodeURIComponent(_site||'');   //参数site设置分享来源，可选参数  
		         _shareUrl += '&pics=' + encodeURIComponent(_pic||'');   //参数pics设置分享图片的路径，多张图片以＂|＂隔开，可选参数  
		        window.open(_shareUrl,'width='+_width+',height='+_height+',top='+(screen.height-_height)/2+',left='+(screen.width-_width)/2+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');   
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
			});
			$("a.imgBorder img").on('mouseover',function(){
				$(this).parents("tr").prev().find("td img").attr("src",$(this).attr("src"));
			});
			//扩展easyui表单的验证  
			$.extend($.fn.validatebox.defaults.rules, { 
			    phoneNum: { //验证手机号   
			        validator: function(value, param){ 
			         return /^1[3-8]+\d{9}$/.test(value);
			        },    
			        message: 'Please enter the correct phone number.'   
			    }
			})
/*	   $('#tab-container').easytabs({ 
	    	 // uiTabs: true,
	    	  animate: true,
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
	      $("a[name='SubmitSend']").click(function(){
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
	   itouren.hotsightdetail.init();
	   itouren.hotsightdetail.copyUrl();
	   var url = qqFriend();  
       $("#qq_id").attr("href",url); 
});
