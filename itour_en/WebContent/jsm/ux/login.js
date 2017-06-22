$package('itouren.login');
itouren.login = function(){
	return {
		toLogin:function(){
			try{
				var form = $("#loginForm");
				if(form.form('validate')){
					itouren.progress('Please waiting','Loading...');
					itouren.submitForm(form,function(data){
						itouren.closeProgress();
						if(data.success){
							itouren.alert('提示',data.msg,'info'); 
					 		window.location= basePath+"main/manage";
				        }else{
				        	itouren.alert('提示',data.msg,'error');  
				        	itouren.login.loadVrifyCode();//刷新验证码
				        }
					});
				}
			}catch(e){
				
			}
			return false;
		},
		loadVrifyCode:function(){//刷新验证码
			var _url = "ImageServlet?time="+new Date().getTime();
			$(".vc-pic").attr('src',_url);
		},
		init:function(){
			if(window.top != window.self){
				window.top.location =  window.self.location;
			}
			//验证码图片绑定点击事件
			$(".vc-pic").click(itouren.login.loadVrifyCode);
			//but_login
			//var form = $("#loginForm");
		//	form.submit(itouren.login.toLogin);
		}
	}
}();

$(function(){
	itouren.login.init();
});		