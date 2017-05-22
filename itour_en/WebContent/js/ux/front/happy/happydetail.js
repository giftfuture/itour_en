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
			init:function(){
					/// _this.fbpagination(1);
			}
	}
	return  _this;
	}();
	$(function(){
	   itour.happydetail.init();
	});