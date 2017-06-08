$package('itouren.trekking');
itouren.trekking = function(){
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
				 		itouren.alert('alert', result.msg ,'info');
				 	},
				 	error:function(response, textStatus, errorThrown){
				 		try{
				 			itouren.closeProgress();
				 			var data = $.parseJSON(response.responseText);
				 			//console.log(data);
				 			itouren.alert('alert', data.msg ,'error');
				 		}catch(e){
				 			itouren.alert('alert',"Request an exception, please contact the administrator.",'error');
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
	itouren.trekking.init();
});