$package('itour.login');
itour.login = function(){
	return {
		toLogin:function(){
			try{
				var form = $("#loginForm");
				if(form.form('validate')){
					itour.progress('Please waiting','Loading...');
					itour.submitForm(form,function(data){
						itour.closeProgress();
						if(data.success){
							itour.alert('提示',data.msg,'info'); 
					 		window.location= basePath+"main/manage";
				        }else{
				        	itour.alert('提示',data.msg,'error');  
				        	itour.login.loadVrifyCode();//刷新验证码
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
			$(".vc-pic").click(itour.login.loadVrifyCode);
			//but_login
			//var form = $("#loginForm");
		//	form.submit(itour.login.toLogin);
		}
	}
}();

$(function(){
	itour.login.init();
});		