$package('itouren.serverquotestep4');
itouren.serverquotestep4 = function(){
	var _this = {
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
			},
		generateReportFun:function(intervalId){
			      var progressBar = $("#divProgressbar");  
			      progressBar.show();
				//想要修改进度条的颜色去css文件中去修改
			      progressBar.progressbar({
					width : 200,		//设置进度条宽度 默认400
					height : 15,		//设置进度条高度 默认22
					value : 0,			//设置进度条值 默认0
					text : '{value}%',	//设置进度条百分比模板 默认 {value}%
					//在value改变的时候触发
					onChange : function (newValue, oldValue) {
						console.log('新:' + newValue + ',旧:' + oldValue);
					},
				});
			      intervalId = setInterval(function(){
					var value = progressBar.progressbar('getValue');
					if (value < 100){
					    value += Math.floor(Math.random() * 5);
					    progressBar.progressbar('setValue', value);
					}
					//getValue  setValue 分别是返回当前进度值  和 设置一个进度值
					//progressBar.progressbar('setValue', progressBar.progressbar('getValue') + 5);
				},1000);
			  itouren.main.unDealedOrders();	    
		 },
		 msgProgress:function(intervalId){
			  		var progressBar = $("#divProgressbar");  
					var value = progressBar.progressbar('getValue');
					if (value < 100){
					    value += Math.floor(Math.random() * 6);
					    progressBar.progressbar('setValue', value);
					    //console.log("value="+value);    
					}else{
						 progressBar.progressbar('setValue', 100);
						 window.clearInterval(intervalId);  
					}
		 },
		init:function(){
			$("a.imgBorder img").on('click',function(){
				$(this).parents("tr").prev().find("td img").attr("src",$(this).attr("src"));
				//$("td[name='magnifying'] img").attr("src",$(this).attr("src"));
			});
			$("a.imgBorder img").on('mouseover',function(){
				//$("td[name='magnifying'] img").attr("src",$(this).attr("src"));
				$(this).parents("tr").prev().find("td img").attr("src",$(this).attr("src"));
			});
			//generateReport
			$("a[name='generateReport']").click(function(){
					   var totalTime = 35;	
				   var intervalId = null;
				   var progressBar = $("#divProgressbar");  
				      progressBar.show();
					//想要修改进度条的颜色去css文件中去修改
				      progressBar.progressbar({
						width : 300,		//设置进度条宽度 默认400
						height : 22,		//设置进度条高度 默认22
						value : 0,			//设置进度条值 默认0
						text : '{value}%',	//设置进度条百分比模板 默认 {value}%
						onChange : function (newValue, oldValue) {//在value改变的时候触发
							//console.log('新:' + newValue + ',旧:' + oldValue);	 
						}
					 });
				     
				//itour.progress('请稍侯','信息提交中...', interval:0);
				//var nowtime = new Date().getTime();
				//progressBar.progressbar({value: 0});
			   // nowtime,progressBar,intervalId,document.getElementById("reportdiv").innerHTML,$("input[name='tordername']").val(),$("input[name='idrt']").val()
				$.ajax({url:'travelOrder/generateReport',method:'post',data:{'formContent':document.getElementById("reportdiv").innerHTML,'tordername':$("input[name='tordername']").val(),'idrt':$("input[name='idrt']").val(),'basePath':basePath},
					dataType:'json',
					timeout:40000,//超时时间：40秒 
					beforeSend: function(){
						//console.log("beforeSend####intervalId="+intervalId);
						intervalId = setInterval("itouren.serverquotestep4.msgProgress("+intervalId+")",1000);
					},
					complete:function(){
					},
					success:function(responseText){
					progressBar.progressbar('setValue', 100);
					window.clearInterval(intervalId);  
					console.log(responseText);
					var result = $.parseJSON(responseText);
					//console.log(result);
					//itour.closeProgress();
					//clearInterval(intervalId);  
	               /* if(progressBar != null){  
	                    progressBar.progressbar("setValue",100);      
	                }*/
		                //console.log(result);
						if(result && result.success && result.msg){
					 
						itour.alert("提示",result.msg,"info",function(){
							$("a[name='viewReport']").attr("href",basePath+result.data);
							$("a[name='viewReport']").show();
							itour.confirm("操作提示", "回到订单管理页面？", function (data) {  
								if (data) {  
									document.forms["back_form"].submit();
								}  
							});
						});
					}else{
						itour.alert("提示","生成报价单出错，请重新操作或联系管理员。","info",function(){});
					}
			  },//请求出错的处理  
	                error:function(){  
	                	progressBar.progressbar('setValue', 0);
	                    window.clearInterval(intervalId);  
	                    itour.alert("提示","请求出错，请重新生成","info");  
	                 }  
				});
			});
		}
	}
	return  _this;
}();

$(function(){
	   itouren.serverquotestep4.init();
	   itouren.serverquotestep4.copyUrl();
	   var homeurl = window.location.href;
	   /*if (window != top)
           top.location.href = location.href;*/
});