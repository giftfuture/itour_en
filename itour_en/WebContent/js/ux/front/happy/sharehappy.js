//加载编辑器  
$(document).ready(function() { 
    $('#content').summernote({  
        height: 400,                  
        minHeight: 300,             
        maxHeight: 500,        
        focus: true,   
        lang:'zh-CN',   
      /*  callbacks: { 
	        onImageUpload: function(files, editor, $editable) {  
	        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
	        }
        },*/codemirror: {
            theme: 'monokai'
        },toolbar: [  
                    ['style', ['bold', 'italic', 'underline', 'clear']],  
                    ['fontsize', ['fontsize']],  
                    ['color', ['color']],  
                    ['para', ['ul', 'ol', 'paragraph']],  
                    ['height', ['height']],  
                    ['insert', ['picture', 'video']]  
                ],
        fontNames: ['Microsoft YaHei ','Serif', 'Sans', 'Arial', 'Arial Black', 'Courier','Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande','Sacramento'],
        colors: [
                 ['#000000', '#424242', '#636363', '#9C9C94', '#CEC6CE', '#EFEFEF', '#F7F7F7', '#FFFFFF'],
                 ['#FF0000', '#FF9C00', '#FFFF00', '#00FF00', '#00FFFF', '#0000FF', '#9C00FF', '#FF00FF'],
                 ['#F7C6CE', '#FFE7CE', '#FFEFC6', '#D6EFD6', '#CEDEE7', '#CEE7F7', '#D6D6E7', '#E7D6DE'],
                 ['#E79C9C', '#FFC69C', '#FFE79C', '#B5D6A5', '#A5C6CE', '#9CC6EF', '#B5A5D6', '#D6A5BD'],
                 ['#E76363', '#F7AD6B', '#FFD663', '#94BD7B', '#73A5AD', '#6BADDE', '#8C7BC6', '#C67BA5'],
                 ['#CE0000', '#E79439', '#EFC631', '#6BA54A', '#4A7B8C', '#3984C6', '#634AA5', '#A54A7B'],
                 ['#9C0000', '#B56308', '#BD9400', '#397B21', '#104A5A', '#085294', '#311873', '#731842'],
                 ['#630000', '#7B3900', '#846300', '#295218', '#083139', '#003163', '#21104A', '#4A1031']
               ]
  }); 
    $.extend($.fn.datebox.defaults.rules,{  
    	checkDated:{  //只有在datebox的input框获取焦点的时候才会显示提示，如果禁用了输入则不会生效
    		validator:function(value){      
    			var now = new Date();  
    			var result =  now>=new Date(value);
    			return result;  
    		},  
    		message:"晒旅行幸福的日期应在当前日期之前"  
    	}     
    }); 
    //$('#tourTime').datebox('setValue', getCurentDateStr());  
  /*  	$('#tourTime').datebox("calendar").calendar({  
	        validator : function(date){  
	            var now = new Date();  
	            var d1 = new Date(now.getFullYear(),now.getMonth(),now.getDate());  
	            return date <= d1;  
	        }  
    	});*/  

/*    $("#tourTime").datebox({  
        onSelect:function(date){  
            var nowDate = new Date();  
            if(date>nowDate){  
            	itour.alert("提示","选择晒旅行幸福的日期应在当前日期或之前","info");
                $("#tourTime").datebox("setValue","");  
                return false;
            }
            return true;
        }  
    }); */
});  
function getCurentDateStr(){   
    var now = new Date();  
    var year = now.getFullYear();       //年  
    var month = now.getMonth() + 1;     //月  
    var day = now.getDate();            //日  
   var clock = year + "-";  
    if(month < 10) clock += "0";         
    clock += month + "-";  
    if(day < 10) clock += "0";   
    clock += day;  
    return clock;   
}  

//刷新验证码
/*function changeImg(){
    document.getElementById("validateCodeImg").src=basePath+"ImageServlet?"+Math.random();
}
*/
function changeValidateCode() {  
    var timenow = new Date().getTime();//这是为了防止每次刷新的时候验证码相同
    $("#validateCode").attr("src",basePath+"RandomCodeServlet?d="+timenow);  
  } 
function change(picId,fileId){
    var pic = document.getElementById(picId);
    var file = document.getElementById(fileId);
    if(window.FileReader){//chrome,firefox7+,opera,IE10+
       oFReader = new FileReader();
       oFReader.readAsDataURL(file.files[0]);
       oFReader.onload = function (oFREvent) {pic.src = oFREvent.target.result;};        
    }else if (document.all) {//IE9-//IE使用滤镜，实际测试IE6设置src为物理路径发布网站通过http协议访问时还是没有办法加载图片
        file.select();
        file.blur();//要添加这句，要不会报拒绝访问错误（IE9或者用ie9+默认ie8-都会报错，实际的IE8-不会报错）
        var reallocalpath = document.selection.createRange().text//IE下获取实际的本地文件路径
        //if (window.ie6) pic.src = reallocalpath; //IE6浏览器设置img的src为本地路径可以直接显示图片
        //else { //非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现，IE10浏览器不支持滤镜，需要用FileReader来实现，所以注意判断FileReader先
            pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
            pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';//设置img的src为base64编码的透明图片，要不会显示红xx
       // }
    }else if (file.files) {//firefox6-
        if (file.files.item(0)) {
            url = file.files.item(0).getAsDataURL();
            pic.src = url;
        }
    }
}
/*function getBase64Image(img) {
	 var canvas = document.createElement("canvas");
     canvas.width = img.width;
     canvas.height = img.height;
     var ctx = canvas.getContext("2d");
     ctx.drawImage(img, 0, 0, img.width, img.height);
     var ext = img.src.substring(img.src.lastIndexOf(".")+1).toLowerCase();
     var dataURL = canvas.toDataURL("image/"+ext);
     return dataURL; // return dataURL.replace("data:image/png;base64,", ""); 
} */
function sharehappy() {
	var actionurl=basePath+"showhappy/add";//$("#formLogin").attr("action");//提交路径
	 var formData = new Object();
	//var formData= $("form[name='sharehappy']").serialize();
	/*$("form input").each(function(){
		 formData[this.name] =$("input[name='"+this.name+"']" ).val();
	});*/
	var route=$("#route").combobox('getValue')?$("#route").combobox('getValue'):$("#route").combobox('getText');
/*	formData["route"] = route;
	formData["content"] = $('#content').summernote('code');
	formData["verifyCode"]=$("#verifyCode").val();
	formData["title"]=$("#title").textbox('getValue');
	formData["tourTime"] = $("#tourTime").datebox('getValue');
	formData["signature"] = $("#signature").textbox('getValue');
	formData["area"] = $("#area").combobox('getValue');
	formData["surface"]=$('#surface').get(0).files[0];*/
	formData.route = route;
	formData.content = $('#content').summernote('code');
	formData.verifyCode=$("#verifyCode").val();
	formData.title=$("#title").textbox('getValue');
	formData.tourTime = $("#tourTime").datebox('getValue');
	formData.signature = $("#signature").textbox('getValue');
	formData.area = $("#area").combobox('getValue');
	//formData.cover=$('#surface').get(0).files[0];
	var image = new Image();
	image.src = $("#cover").attr("src");
/*	image.onload = function(){
	    //var base64 = getBase64Image(image);
	   // console.log(base64);
	    formData.cover= image.src;
	    formData.surface=image.name;
	}*/
//	console.log($("#cover"));
	formData.cover = image.src;
	formData.surface=image.name;
	//console.log(formData);
	//console.log(formData.cover.length);  
	//console.log(formData.tourTime+"   "+new Date());
	if(!formData.tourTime||new Date(formData.tourTime)>new Date()){
		itour.alert("提示","晒旅行幸福的日期应在当前日期之前",'info');
		return;
	}else{
		__.post(actionurl, formData, function(result) {
			//console.log("data.success="+data.success);
			if (result.success) {
				itour.alert("提示",result.msg||"晒出成功！",'info');
				setTimeout(function(){window.location.href=basePath+"showhappy/main";}, 3000);
				//_this.showSuccess(result.msg);
			} else {
				itour.alert("提示",result.msg||"晒出出错！",'info');
				return;
				//_this.showError(result.msg);
			}
	});
	}
	//console.log(formData);
	//console.log($.parseJSON(formData));
	//var showhappy = JSON.stringify($.parseJSON(formData));
	//var json='{"showhappy":'+showhappy+'}';
	//console.log(json);
	//console.log(formData+"   "+checkurl);
	//console.log(formData);
	/*$.ajax({
		async : false,
		cache : false,
		type : 'post',
		url : actionurl,//checkurl,// 请求的action路径
		dataType:'json',
		contentType:'application/json',
		//processData : false,
		data : formData,// $.parseJSON(formData),
		error : function() {// 请求失败处理函数
			alert('晒幸福处理函数出现错误');
		},
		success : function(data) {
			//console.log("data.success="+data.success);
			if (data.success) {
				showSuccess(data.msg);
				//setTimeout("formSubmit()", 0);
			//	formSubmit();
			//	alert("rraar"+actionurl);
			//	$("#" + this.name).val("");
			} else {
				showError(data.msg);
			}
		}
	});*/
}
function showSuccess(str) {
	$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);
}
//显示错误提示
function showError(str) {
	$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);

}
//图片上传  
function sendFile(file, editor, $editable){ 
	$(".note-toolbar.btn-toolbar").append('正在上传图片');  
	 console.log("file="+file);  
	 console.log("editor="+editor);  
	 console.log("welEditable="+$editable);  
    var filename = false;  
    try{  
    filename = file['name'];  
    } catch(e){  
        filename = false;  
    }  
    if(!filename){  
        $(".note-alarm").remove();  
    }  
    //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误  
    var data = new FormData();  
    data.append("file", file);  
    data.append("key",filename); //唯一性参数  
    data.append("token",$("#summernote").attr('token'));  
  //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误
    var ext = filename.substr(filename.lastIndexOf("."));
    ext = ext.toUpperCase();
    var timestamp = new Date().getTime();
    var name = timestamp+"_"+$("#summernote").attr('aid')+ext;
    $.ajax({  
	    data: data,  
	    type: "POST",  
	    url: basePath+"showhappy/addd",  
	    cache: false,  
	    contentType: false,  
	    processData: false,  
	    success: function(url) {  
	        if(url=='200'){  
	            alert("上传失败！");  
	            return;  
	        }else{  
	            alert("上传成功！");   
	        }  
	        //alert(url);  
	    editor.insertImage($editable, url);  
	   // $("#summernote").summernote('insertImage', url, 'image name'); // the insertImage API  
	    //setTimeout(function(){$(".note-alarm").remove();},3000);  
	    },  
	    error:function(){  
	        alert("上传失败！");  
	        return;  
        //setTimeout(function(){$(".note-alarm").remove();},3000);  
        }  
  }); 
 }  

// var text="${text}";   
//  $('#summernote').code(text); // 给编辑器赋值

//var str= $('#summernote').code();  //取值 

