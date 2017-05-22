/*
 * zxxFile.js 基于HTML5 文件上传的核心脚本 
 *  
*/
var ZXXFILE = {
	fileInput: null,				//html file控件
	dragDrop: null,					//拖拽敏感区域
	upButton: null,					//提交按钮
	url: "",						//ajax地址
	fileFilter: [],					//过滤后的文件数组
    filter: function(files) {
			var arrFiles = [];
			for (var i = 0, file; file = files[i]; i++) {
				//console.log("eeeed"+file.name);
				if (file.type.indexOf("image") == 0) {
					if (file.size >= 5120000) {
						alert('您这张"'+ file.name +'"图片大小过大，应小于5M');	
					} else {
						//console.log(file.name);
						arrFiles.push(file);	
					}			
				} else {
					alert('文件"' + file.name + '"不是图片。');	
				}
			}
			return arrFiles;
	},
	/*filter: function(files) {		//选择文件组的过滤方法
		return files;	
	},*/
//	onchange: function() {alert("43rrer");},		//文件选择后
	onSelect: function() {},		//文件选择后
	onDelete: function() {},		//文件删除后
	onDragOver: function() {},		//文件拖拽到敏感区域时
	onDragLeave: function() {},	//文件离开到敏感区域时
	onProgress: function() {},		//文件上传进度
	onSuccess: function() {},		//文件上传成功时
	onFailure: function() {},		//文件上传失败时,
	onComplete: function() {},		//文件全部上传完毕时
	
	/* 开发参数和内置方法分界线 */
	
	//文件拖放
	funDragHover: function(e) {
		e.stopPropagation();
		e.preventDefault();
		this[e.type === "dragover"? "onDragOver": "onDragLeave"].call(e.target);
		return this;
	},
	//获取选择文件，file控件或拖放
	funGetFiles: function(e) {
		// 取消鼠标经过样式
		this.funDragHover(e);
		// 获取文件列表对象
		var files = e.target.files || e.dataTransfer.files;
		//继续添加文件
		this.fileFilter = this.fileFilter.concat(this.filter(files));
		this.funDealFiles();
		return this;
	},
	
	//选中文件的处理与回调
	funDealFiles: function() {
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			//增加唯一索引值
			file.index = i;
		}
		//执行选择回调
		this.onSelect(this.fileFilter);
		return this;
	},
	
	//删除对应的文件
	funDeleteFile: function(fileDelete) {
		var arrFile = [];
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			if (file != fileDelete) {
				arrFile.push(file);
			} else {
				this.onDelete(fileDelete);	
			}
		}
		this.fileFilter = arrFile;
		return this;
	},
	
	//文件上传
	funUploadFile: function() {
		var self = this;	
		if (location.host.indexOf("sitepointstatic") >= 0) {
			//非站点服务器上运行
			return;	
		}
		for (var i = 0, file; file = this.fileFilter[i]; i++) {
			(function(file) {
				var xhr = new XMLHttpRequest();
				if (xhr.upload) {
					// 上传中
					xhr.upload.addEventListener("progress", function(e) {
						self.onProgress(file, e.loaded, e.total);
					}, false);
		
					// 文件上传成功或是失败
					xhr.onreadystatechange = function(e) {
						if (xhr.readyState == 4) {
							if (xhr.status == 200) {
								self.onSuccess(file, xhr.responseText);
								self.funDeleteFile(file);
								if (!self.fileFilter.length) {
									//全部完毕
									self.onComplete();	
								}
							} else {
								self.onFailure(file, xhr.responseText);		
							}
						}
					};
					//var form = new FormData();
					//form.append("fileselect", file); // 文件对象
				//	var oData = new FormData({'fileselect':document.forms["multiDataForm"].fileselect}); 
					// 开始上传
			/*		xhr.open("post", self.url, true);
					//xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;boundary="+new Date().getTime());
					  // Set appropriate headers
					xhr.overrideMimeType('text/plain; charset=utf-8');
					xhr.setRequestHeader("Content-Type", "multipart/form-data;charset=UTF-8;boundary="+new Date().getTime());
				//	xhr.setRequestHeader("Content-Type", "multipart/x-www-form-urlencoded;charset=UTF-8;boundary="+new Date().getTime());
					//xhr.setRequestHeader("X-File-Name", file.fileName);
					//xhr.setRequestHeader("X-File-Size", file.fileSize);
					xhr.setRequestHeader("X-File-Type", file.type);
					xhr.setRequestHeader("X_FILENAME", file.name);
					xhr.setRequestHeader("fileselect", file);
					// FormData 对象
		            var form = new FormData($("#multiDataForm")[0]);
		            form.append("name","daaaaa");//http://localhost:8080/itour/travelItem/uploadPhoto
					//xhr.setRequestHeader("id", new Date().getTime());
					//console.log(file);
					//xhr.send(file);
					xhr.send(form);*/
				}	
			})(file);	
		}	
			
	},
	init: function() {
		var self = this;
		if (this.dragDrop) {
			this.dragDrop.addEventListener("dragover", function(e) { self.funDragHover(e); }, false);
			this.dragDrop.addEventListener("dragleave", function(e) { self.funDragHover(e); }, false);
			this.dragDrop.addEventListener("drop", function(e) { self.funGetFiles(e); }, false);
		}
		
		//文件选择控件选择
		if (this.fileInput) {//readFile
			this.fileInput.addEventListener("change", function(e) { self.funGetFiles(e); }, false);	
			//this.fileInput.addEventListener("propertychange", function(e) {self.funGetFiles(e); }, false);	
		}
		
		//上传按钮提交
		if (this.upButton) {
			this.upButton.addEventListener("click", function(e) { self.funUploadFile(e); }, false);	
		} 
		/*
		 $.ajax({
			type:"PUT",//这里的参数可以是PUT、POST、GET和DELETE
			url:"/appName/name",//请求地址，name就是你的参数
			data:JSON.stringify($("#myform").serializaObject()),
			dataType:"json",
			contentYype:"application/json",//这个一定要设置
			success:function(data){
			//这里是成功获取信息后的处理方法
			}
			}); 
		 * */
	//	alert();
	}
	 
};
