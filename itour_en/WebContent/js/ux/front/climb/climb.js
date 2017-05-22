$package('itour.climb');
itour.climb = function(){
	var _this = {
			feedback:function(){
				$.ajax({type:'post',
				 	url:basePath+"feedback/add",
				 	timeout:3000,
				 	data:$(document.forms[0]).serialize(),
				 	cache: false,
				 	//headers : {"ClientCallMode" : "ajax"}, //添加请求头部
				 	async:false,  //异步请求
			 	   // contentType: "application/json; charset=utf-8", 
				 	success:function(data){
				 		var result= $.parseJSON(data);
				 		//$.messager.alert('提示',result.msg,'info');
				 		itour.alert('提示', result.msg ,'info');
				 	},
				 	error:function(response, textStatus, errorThrown){
				 		try{
				 			itour.closeProgress();
				 			var data = $.parseJSON(response.responseText);
				 			//console.log(data);
				 			itour.alert('提示', data.msg ,'error');
				 		}catch(e){
				 			itour.alert('提示',"请求出现异常,请联系管理员.",'error');
				 		}
				 	}
				 })
				 //$(document.forms[0]).ajaxSubmit(option);
			 	 $(document.forms[0]).resetForm(); // 提交后重置表单
				 return false;
				
			},
		init:function(){
			$("input[type='button']").click(_this.feedback);
		}
	}
	return  _this;
}();

$(function(){
	itour.climb.init();
});