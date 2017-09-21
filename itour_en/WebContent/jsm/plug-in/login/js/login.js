$(document).ready(function() {
	//getCookie();
	onfocus();
	$(".on_off_checkbox").iphoneStyle();
	$('.tip a ').tipsy({
		gravity : 'sw'
	});
	$('#login').show().animate({
		opacity : 1
	}, 2000);
	$('.logo').show().animate({
		opacity : 1,
		top : '32%'
	}, 800, function() {
		$('.logo').show().delay(1200).animate({
			opacity : 1,
			top : '1%'
		}, 300, function() {
			$('.formLogin').animate({
				opacity : 1,
				left : '0'
			}, 300);
			$('.userbox').animate({
				opacity : 0
			}, 200).hide();
		});
	});
	// 点击登录
	$("#but_login").click(function(e){
		submit();
	});
	//回车登录
	$(document).keydown(function(e){
		 e = e || window.event;
		  //阻止默认事件
	  /*   if(e.preventDefault){
	         e.preventDefault();
	     }else{
	         e.returnValue = false;
	     }*/
		if(e.keyCode == 13) {
			submit();
		}
	});
	// 重置
	$('#forgetpass').click(function(e) {
		$(":input").each(function() {
		$('#'+this.name).val("");
		});
		$("#forget-pwd-win").dialog('open');
	});
	$("#btn-forgetpwd-close").click(function(){
		$("#forget-pwd-win").dialog('close');
	})
	$("#btn-forgetpwd-submit").click(function(){
		itour.progress('Please waiting','Processing...');
		$.post(basePath+'main/toresetPwd',{'email':$("#loginEmail").val()},function(data){
			itour.closeProgress();
			var result = $.parseJSON(data);
			if(result.success||result.success=='true'){
				itour.alert("提示",result.msg,"info",function(){
					$("#forget-pwd-win").dialog('close');
					$("#modify-pwd-win").dialog('open');
				})
			}else{
				itour.alert("alert",result.msg||"To reset the password by email, please contact the administrator.","info");
			}
		});
	})
	$("#btn-forgetpwd-close").click(function(){
		$("#modify-pwd-win").dialog('close');
	})
	$("#btn-forgetpwd-submit").click(function(){
		modifyPwd();
	})
$('.userload').click(function(e){
	$('.formLogin').animate({
		opacity : 1,
		left : '0'
	}, 300);
	$('.userbox').animate({
		opacity : 0
	}, 200, function() {
		$('.userbox').hide();
	});
	/* 自定义密码验证*/
	$.extend($.fn.validatebox.defaults.rules, {  
	    equals: {  
	        validator: function(value,param){  
	            return value == $(param[0]).val();  
	        },  
	        message: '两次输入密码不匹配.'  
	    }
	})
});
});
function modifyPwd(){
	itour.progress('请稍侯','信息提交中...');
	var pwdForm = $("#pwdForm");
	var param = {'email':$("#email",pwdForm).val(),'newPwd':$("#newPwd",pwdForm).val(),'pwdCode':$("#pwdCode",pwdForm).val()};
	//console.log(param);
	if(pwdForm.form('validate')){
		$.post(basePath+'main/resetPwd',param,function(data){
			var result = $.parseJSON(data);
			itour.closeProgress();
			if(result.success||result.success=='true'){
				itour.alert("",result.msg,"info",function(){
					$('#modify-pwd-win').dialog('close');
					pwdForm.resetForm();
				})
			}else{
				itour.alert("提示",result.msg||"通过邮箱重置密码失败，请联系管理员。","info");
			}
		})
	/*	itour.saveFormWithoutLogin(pwdForm,function(data){
			itour.alert("提示",result.msg,"info",function(){
				$('#modify-pwd-win').dialog('close');
				pwdForm.resetForm();
			})
		});*/
	 }
};
function forgetPwdForm(){
	var pwdForm = $("#forgetpwdForm");
	if(pwdForm.form('validate')){
		//var parentId =$('#search_parentId').val();
		/*$("#edit_parentId").val(parentId)*/
		itour.saveForm(pwdForm,function(data){
			$('#forget-pwd-win').dialog('close');
		    pwdForm.resetForm();
		});
	 }
}
//表单提交
function submit(){
	var submit = true;
	$("input[nullmsg]").each(function(){
		if ($("#" + this.name).val() == "") {
			showError($("#" + this.name).attr("nullmsg"), 500);
			jrumble();
			setTimeout('hideTop()', 3000);
			submit = false;
			return false;
		}
	});
	if (submit) {
		hideTop();
		loading('请稍候', 1);
		setTimeout("unloading()", 2000);
		setTimeout("login()", 1);
	}
}
//刷新验证码
function changeImg(){
    document.getElementById("validateCodeImg").src=basePath+"LoginServlet?"+Math.random();
}
//登录处理函数
function login() {
	//setCookie();
	var actionurl=basePath+"main/logIn";//$("#formLogin").attr("action");//提交路径
	var checkurl=$("#formLogin").attr("check");//验证路径
	 var formData = new Object();
	var data=$(":input").each(function(){
		 formData[this.name] =$("#"+this.name ).val();
	});
	//console.log(formData+"   "+checkurl);
	$.ajax({
		async : false,
		cache : false,
		type : 'post',
		url : actionurl,//checkurl,// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
			itour.alert('提示','登录处理函数出现错误','info');
		},
		success : function(data) {
			//console.log("data.success="+data.success);
			if (data.success) {
				loginsuccess();
				showSuccess(data.msg);
				//setTimeout("formSubmit()", 0);
			//	formSubmit();
			//	alert("rraar"+actionurl);
			//	$("#" + this.name).val("");
				window.location.href=basePath+"main/manage";
			} else {
				showError(data.msg);
				window.location= basePath+"main/login";
			}
		}
	});
}
function formSubmit(){
	//itour.ajaxSubmit(document.forms["formLogin"]);
//	document.forms["formLogin"].submit();
}
//设置cookie
function setCookie()
{
	if ($('#on_off').val() == '1'){
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name, $("#"+this.name).val(), "/",24);
			$.cookie("COOKIE_NAME","true", "/",24);
		});
	} else {
		$("input[iscookie='true']").each(function() {
			$.cookie(this.name,null);
			$.cookie("COOKIE_NAME",null);
		});
	}
}
//读取cookie
function getCookie()
{
	var COOKIE_NAME=$.cookie("COOKIE_NAME");
	if (COOKIE_NAME !=null){
		$("input[iscookie='true']").each(function() {
			$($("#"+this.name).val( $.cookie(this.name)));
		});
		$("#on_off").attr("checked", true);
		$("#on_off").val("1");
	} else{
		$("#on_off").attr("checked", false);
		$("#on_off").val("0");
	}
}
//点击消息关闭提示
$('#alertMessage').click(function() {
	hideTop();
});
//显示错误提示
function showError(str) {
	$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);

}
//验证通过加载动画
function loginsuccess()
{
	$("#login").animate({
		opacity : 1,
		top : '49%'
	}, 200, function() {
		$('.userbox').show().animate({
			opacity : 1
		}, 500);
		$("#login").animate({
			opacity : 0,
			top : '60%'
		}, 500, function() {
			$(this).fadeOut(200, function() {
				$(".text_success").slideDown();
				$("#successLogin").animate({
					opacity : 1,
					height : "200px"
				}, 1000);
			});
		});
	});
}
function showSuccess(str) {
	$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);
}

function onfocus() {
	if ($(window).width() > 480) {
		$('.tip input').tipsy({
			trigger : 'focus',
			gravity : 'w',
			live : true
		});
	} else {
		$('.tip input').tipsy("hide");
	}
}

function hideTop() {
	$('#alertMessage').animate({
		opacity : 0,
		right : '-20'
	}, 500, function() {
		$(this).hide();
	});
}
//加载信息
function loading(name, overlay) {
	$('body').append('<div id="overlay"></div><div id="preloader">' + name + '...</div>');
	if (overlay == 1) {
		$('#overlay').css('opacity', 0.1).fadeIn(function() {
			$('#preloader').fadeIn();
		});
		return false;
	}
	$('#preloader').fadeIn();
}

function unloading() {
	$('#preloader').fadeOut('fast', function() {
		$('#overlay').fadeOut();
	});
}
// 表单晃动
function jrumble() {
	$('.inner').jrumble({
		x : 4,
		y : 0,
		rotation : 0
	});
	$('.inner').trigger('startRumble');
	setTimeout('$(".inner").trigger("stopRumble")', 500);
};
