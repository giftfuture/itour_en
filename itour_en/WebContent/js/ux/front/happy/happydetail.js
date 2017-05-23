 $package('itour.happydetail');
itour.happydetail = function(){
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
				    itour.alert('alert', "Copy Successfully!",'info');
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
								itour.alert('alert',"Domestic development of the 360 browser does not support the initiative to join the collection. \ NYou can try using the browser menu bar or the shortcut ctrl + D.",'info');
							}
							catch (e){
								window.external.addToFavoritesBar(url,title);  //IE8
							}
						}
					}else if (window.sidebar) { //firfox等浏览器
						window.sidebar.addPanel(url	,title, "");
					}else if(window.opera){
						itour.alert('alert','opera You can try via shortcuts' + ctrl + ' + D Add to Favorites ~','info');
					}else{
						itour.alert('alert',' You can try via shortcuts' + ctrl + ' + D Add to Favorites ~','info');
					}
				}
				catch (e){
					itour.alert('alert',"Because IE browser bug, add the collection failed! \ N Workaround: Find in the registry\n HKEY_CLASSES_ROOT\\TypeLib\\{EAB22AC0-30C1-11CF-A7EB-0000C05BAE0B}\\1.1\\0\\win32 \n C:\\WINDOWS\\system32\\shdocvw.dll changed to C:\\WINDOWS\\system32\\ieframe.dll ",'info');
				}
			},
			init:function(){
					/// _this.fbpagination(1);
			}
	}
	return  _this;
	}();
	$(function(){
	   itour.happydetail.init();
	});