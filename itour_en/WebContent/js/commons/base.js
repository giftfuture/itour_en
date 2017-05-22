$package('itour');
var itour={
	/*Json 工具类*/
	isJson:function(str){
		var obj = null; 
		try{
			obj = itour.paserJson(str);
		}catch(e){
			return false;
		}
		var result = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length; 
		return result;
	},
	paserJson:function(str){
		return eval("("+str+")");
	},		
	/*弹出框*/
	alert:function(title, msg, icon, callback){
		$.messager.alert(title,msg,icon,callback);
	},
	/*弹出框*/
	confirm:function(title, msg,callback){
		$.messager.confirm(title,msg,callback);
	},
	progress:function(title,msg){
		 var win = $.messager.progress({  
            title: title ||'Please waiting',  
            msg: msg ||'Loading data...'  
         }); 
	},
	closeProgress:function(){
		$.messager.progress('close');
	},
	/*重新登录页面*/
	toLogin:function(){
		window.top.location= urls['msUrl']+"main/login";
	},
	checkLogin:function(data){//检查是否登录超时
		//console.log(data);
		//console.log(data+"      "+data.logoutFlag);
		if(!data /*|| data.logoutFlag || data.logoutFlag == null*/){
			itour.closeProgress();
			itour.alert('提示',"登录超时,点击确定重新登录.",'error',itour.toLogin);
			return false;
		}
		return true;
	},
	ajaxSubmit:function(form,option){
		//console.log(form.serializeJSON());
		form.ajaxSubmit(option);
		//__.post(form.attr("action"),form.serializeObject(),function(){
		//});
/*	$.ajax(	{type:'post',
	 		url:form.attr("action"),
		 	timeout:3000,
		 	//iframe: true,
		 	cache:false,
		 	processData: false,
		 	contentType: false,
		 	data:form.serializeJSON(),//form.serializeJSON(),//JSON.stringify()
		 //	headers : {"ClientCallMode" : "ajax"}, //添加请求头部
		 //	dataType: "json",
	       // contentType: "multipart/form-data;boundary=56423498738365",
		 	async:false,  //异步请求					
		 	success:function(data){								
		 		//var reg = /<pre.+?>(.+)<\/pre>/g;  
		 		//var result = data.match(reg);  
		 		if(data.indexOf('pre')>0){
		 			data = $(data).text();
		 		}
		 		//console.log(data);
		 		var jsondata= data;//.parseJSON(data);//$(data).text()
		 		if($.isFunction(callback)){
		 			//console.log(callback);
		 			callback(jsondata);
		 		}
		 	},
		 	error:function(response, textStatus, errorThrown){
		 		try{
		 			itour.closeProgress();
		 			var data = '';
		 			if(response.responseText.indexOf('pre')>0){//&&response.responseText.indexOf('</pre>')>0
		 				//console.log($(response.responseText).text());
		 				data = $(response.responseText).text();//$(response.responseText).text()
		 			}else{
		 				data = response.responseText;
		 			}
		 			//console.log(data);
			 		//检查登录
			 		if(!itour.checkLogin(data)){
			 			return false;
			 		}else{
				 		itour.alert('提示', data.msg || "submitForm请求出现异常,请联系管理员",'error');
				 	}
		 		}catch(e){
		 			itour.alert('提示',"catch请求出现异常,请联系管理员.",'error');
		 		}
		 	}
		 });*/
		$(this).resetForm(); // 提交后重置表单
		return false;
	},
	ajaxJson: function(url,option,callback){
	//	console.log(url+"   "+option);
		$.ajax({url,
				type:'post',
			 	dataType:'json',
			 	data:option,
			 	sync:false,
			 	cache:false,
			 	success:function(data){
			 		//console.log(data);
			 		var checklogin = itour.checkLogin(data);//$(data).text()
			 		//console.log(checklogin);
			 		//检查登录
			 		if(!checklogin){
			 			return false;
			 		}	
			 		if($.isFunction(callback)){
			 			//console.log(callback);
			 			callback(data);//$(data).text()
			 		}
			 	},
			 	error:function(response, textStatus, errorThrown){
			 		try{
			 			itour.closeProgress();
			 			var data = $.parseJSON(response.responseText);//$(response.responseText).text()
			 			//console.log(data);
				 		//检查登录
				 		if(!itour.checkLogin(data)){
				 			return false;
				 		}else{
					 		itour.alert('提示', data.msg || "ajaxJson请求出现异常,请联系管理员",'error');
					 	}
			 		}catch(e){
			 			itour.alert('提示',"ajaxJson catch请求出现异常,请联系管理员.",'error');
			 		}
			 	}
		});
	},
	submitFormWithoutLogin:function(form,callback,dataType){
		var option ={type:'post',
			 	//dataType: dataType||'json'||'script',
			 	timeout:3000,
			 //	iframe: true,
			 	cache:false,
			 	url:form.attr("action"),
			 //	dataType: "json",
			 	processData: false,
		        //contentType: "application/json; charset=UTF-8",
			 	contentType:false,
		        //contentType: "multipart/form-data; charset=UTF-8",
			 	async:false,  //异步请求	,
			 	success:function(data){		
			 		console.log(data);
			 		//var reg = /<pre.+?>(.+)<\/pre>/g;  
			 		//var result = data.match(reg);  
			 		if(data.indexOf('pre')>0){
			 			data = $(data).text();
			 		}
			 		//console.log(data);
			 		//var jsondata= data;//.parseJSON(data);//$(data).text()
			 		if($.isFunction(callback)){
			 			//console.log(callback);
			 			callback(data);
			 		}
			 	},
			 	error:function(response, textStatus, errorThrown){
			 		try{
			 			console.log(response.responseText);
			 			itour.closeProgress();
			 			var data = '';
			 			if(response.responseText.indexOf('pre')>0){//&&response.responseText.indexOf('</pre>')>0
			 				//console.log($(response.responseText).text());
			 				data = $(response.responseText).text();//$(response.responseText).text()
			 			}else{
			 				data = response.responseText;
			 			}
			 			//console.log(data);
				 		itour.alert('提示', data.msg || "submitFormWithoutLogin请求出现异常,请联系管理员",'error');
			 		}catch(e){
			 			itour.alert('提示',"submitFormWithoutLogin catch请求出现异常,请联系管理员.",'error');
			 		}
			 	}
			 }
			 itour.ajaxSubmit(form,option);
			 return false;
	},
	saveFormWithoutLogin:function(form,callback){
		if(form.form('validate')){
			itour.progress('Please waiting','Saving...');
			//ajax提交form
			itour.submitFormWithoutLogin(form,function(data){
				itour.closeProgress();
				console.log(data);
				var jsondata =$.parseJSON(data);//$(data).text()
				//console.log(data);
			 	if(jsondata.success||jsondata.success=="true"){
			 	//	console.log(data+"     "+callback);
			 		if($.isFunction(callback)){
			 			//console.log(data);
				       	callback(jsondata);
				    }else{
			       		itour.alert('提示','保存成功.','info');
			        } 
		        }else{
		       	   itour.alert('提示',jsondata.msg||"saveFormWithoutLogin请求出现异常,请联系管理员.",'error');  
		        }
			});
		 }
	},
	submitForm:function(form,callback,dataType){
		//form.attr("travelItems","");//$("#travelItems").combobox('getValues').join(',')
		//console.log(form.serializeObject());//form.serializeObject()
		var option =
				{type:'post',
			 	//url:form.attr("action"),
			 	//dataType: dataType||'json',
			 	//dataType:'script',
			 	timeout:3000,
			 	iframe: true,
			 	cache:false,
			 //	headers : {"ClientCallMode" : "ajax"}, //添加请求头部
			 //	dataType: "json",
			 	processData: false,
		        //contentType: "application/json; charset=UTF-8",
			 	contentType:false,
		        //contentType: "multipart/form-data; charset=UTF-8",
			 	async:false,  //异步请求	,
			 	beforeSubmit:function(){
			 		//form.attr("travelItems",$("#travelItems").combobox('getValues').join(','));
			 	},
			 	success:function(data){								
			 		//var reg = /<pre.+?>(.+)<\/pre>/g;  
			 		//var result = data.match(reg);  
			 		if(data.indexOf('pre')>0){
			 			data = $(data).text();
			 		}
			 		//console.log(data);
			 		//var jsondata= data;//.parseJSON(data);//$(data).text()
			 		if($.isFunction(callback)){
			 			//console.log(callback);
			 			callback(data);
			 		}
			 	},
			 	error:function(response, textStatus, errorThrown){
			 		try{
			 			itour.closeProgress();
			 			var data = '';
			 			if(response.responseText.indexOf('pre')>0){//&&response.responseText.indexOf('</pre>')>0
			 				//console.log($(response.responseText).text());
			 				data = $(response.responseText).text();//$(response.responseText).text()
			 			}else{
			 				data = response.responseText;
			 			}
			 			//console.log(data);
				 		//检查登录
				 		if(!itour.checkLogin(data)){
				 			return false;
				 		}else{
					 		itour.alert('提示', data.msg || "submitForm请求出现异常,请联系管理员",'error');
					 	}
			 		}catch(e){
			 			itour.alert('提示',"catch请求出现异常,请联系管理员.",'error');
			 		}
			 	}
			 }
				//console.log(form);
			 itour.ajaxSubmit(form,option);
			 return false;
	},
	saveForm:function(form,callback){
		//console.log(form);
		if(form.form('validate')){
			itour.progress('Please waiting','Saving...');
			//ajax提交form
			itour.submitForm(form,function(data){
				itour.closeProgress();
			//	console.log(data);
				var jsondata =$.parseJSON(data);//$(data).text()
				//console.log(data);
			 	if(jsondata.success||jsondata.success=="true"){
			 	//	console.log(data+"     "+callback);
			 		if($.isFunction(callback)){
			 			//console.log(data);
				       	callback(jsondata);
				    }else{
			       		itour.alert('提示','保存成功.','info');
			        } 
		        }else{
		       	   itour.alert('提示',jsondata.msg||"saveForm请求出现异常,请联系管理员.",'error');  
		        }
			});
		 }
	},
	/**
	 * 
	 * @param {} url
	 * @param {} option {id:''} 
	 */
	getById:function(url,option,callback){
		itour.progress();
		itour.ajaxJson(url,option,function(data){
	//		console.log(data);
			itour.closeProgress();
			//var jsondata = $.parseJSON(data);//$(data).text()
			if(data.success||data.success=="true"){
			//	console.log($.isFunction(callback)+callback);
				if($.isFunction(callback)){
					//console.log("data:"+data);
					callback(data);
			    }
			}else{
				itour.alert('提示',data.msg||"getById请求出现异常,请联系管理员.",'error');  
			}
		});
	},
	/**
	 * 
	 * @param {} url
	 * @param {} option {id:''} 
	 */
	loadPhotos:function(url,option,callback){
		itour.progress();
		itour.ajaxJson(url,option,function(data){
			//console.log(data);
			itour.closeProgress();
			//var jsondata = $.parseJSON(data);//$(data).text()
			if(data.success||data.success=="true"){
				if($.isFunction(callback)){
					//console.log("data:"+data);
			       	callback(data);
			    }
			}else{
				itour.alert('提示',data.msg||"请求照片出现异常,请联系管理员.",'error');  
			}
		});
	},
	deleteForm:function(url,option,callback){
		itour.progress();
		itour.ajaxJson(url,option,function(data){
				itour.closeProgress();
				//var jsondata = $.parseJSON(data);//$(data).text()
			//	console.log(data);
				/*if(data.indexOf('pre')>0){
		 			data = $(data).text();
		 		}*/
				if(data.success||data.success=="true"){
					if($.isFunction(callback)){
						//console.log(callback);
				       	callback(data);
				    }
				}else{
					itour.alert('提示',data.msg||"deleteForm请求出现异常,请联系管理员.",'error');  
				}
		});
	},
	logicdeleteForm:function(url,option,callback){
		itour.progress();
		itour.ajaxJson(url,option,function(data){
		//	console.log(data);
			/*if(data.indexOf('pre')>0){
				data = $(data).text();
			}*/
				itour.closeProgress();
				//var jsondata = $.parseJSON(data);//$(data).text()
				if(data.success||data.success=="true"){
					if($.isFunction(callback)){
						//console.log(callback);
				       	callback(data);
				    }
				}else{
					itour.alert('提示',data.msg||"logicdeleteForm请求出现异常,请联系管理员.",'error');  
				}
		});
	}
}
/* 自定义密码验证*/
$.extend($.fn.validatebox.defaults.rules, {  
    equals: {  
        validator: function(value,param){  
            return value == $(param[0]).val();  
        },  
        message: '两次输入密码不匹配.'  
    },    
    phoneNum: { //验证手机号   
        validator: function(value, param){ 
         return /^1[3-8]+\d{9}$/.test(value);
        },    
        message: '请输入正确的手机号码。'   
    },
    telNum:{ //既验证手机号，又验证座机号
      validator: function(value, param){ 
          return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^(()|(\d{3}\-))?(1[358]\d{9})$)/.test(value);
         },    
         message: '请输入正确的电话号码。' 
    },
 // 验证中文
    CHS : {
     validator : function(value) {
     return /^[\u0391-\uFFE5]+$/.test(value);},
     message : "只能输入汉字"
    },
    // 字符验证
    stringCheck : {
     validator : function(value) {
     return /^[\u0391-\uFFE5\w]+$/.test(value);},
     message : "只能包括中文字、英文字母、数字和下划线"
    },
    // 验证中文,英文,数字
    stringCheckSub : {
     validator : function(value) {
     return /^[a-zA-Z0-9\u4E00-\u9FA5]+$/.test(value);},
     message : "只能包括中文字、英文字母、数字"
    },
    // 验证英文字母、数字
    englishCheckSub : {
     validator : function(value) {
     return /^[a-zA-Z0-9]+$/.test(value);},
     message : "只能包括英文字母、数字"
    },
    // 验证数字
    numberCheckSub : {
     validator : function(value) {
     return /^[0-9]+$/.test(value);},
     message : "只能输入数字"
    },
 // 电话号码验证
    telephone : {
     validator : function(value) {
      // 电话号码格式010-12345678
      var reg = /^\d{3,4}?\d{7,8}$/;
      return reg.test(value);
     },
     message : "请正确填写您的电话号码."
    },
    // 联系电话(手机/电话皆可)验证
    mobileTelephone : {
     validator : function(value) {
      var cmccMobile = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
      var tel = /^\d{3,4}?\d{7,8}$/;
      return tel.test(value)|| (value.length == 11 && cmccMobile.test(value));
     },
     message : "请正确填写您的联系电话."
    },
    // 验证国内邮编验证
    zipCode : {
     validator : function(value) {
      var reg = /^[1-9]\d{5}$/;
      return reg.test(value);
     },
     message : "邮编必须长短0开端的6位数字."
    },
    // 身份证号码验证
    idCardNo : {
     validator : function(value) {
      return isIdCardNo(value);
     },
     message : "请正确输入您的身份证号码."
    },
    // 验证两个不同时为空
    // 可以自定义提示信息
    allNotNull : {
     validator : function(toValue, fromValue) {
      if (fromValue == null || fromValue.length == 0
        || fromValue[0] == null
        || fromValue[0] == "") {
       if (toValue == null || toValue.length == 0
         || toValue[0] == null
         || toValue[0] == "") {
        $.fn.validatebox.defaults.rules.compareDigit.message = "中，英.文名不可同时为空 ";
        return false;
       } else {
        return true;
       }
      } else
      {
       return true;
      }
     },
     message : ""
    },
    // 数字验证大小，结束值应该大于开始值
    // 可以自定义提示信息
    compareDigit : {
     validator : function(toValue, fromValue) {
      if (fromValue == null || fromValue.length == 0
        || fromValue[0] == null
        || fromValue[0] == "") {
       return true;
      }
      if (parseFloat(toValue) > parseFloat(fromValue[0])) {
       return true;
      } else {
       if (fromValue.length >= 2) {
        $.fn.validatebox.defaults.rules.compareDigit.message = fromValue[1];
       } else {
        $.fn.validatebox.defaults.rules.compareDigit.message = '结束值应该大于开始值';
       }
       return false
      }
     },
     message : ""
    },
    // 日期、时间验证大小，结束日期应该大于开始日期
    // 可以自定义提示信息
    compareDate : {
     validator : function(toDate, param) {
      if (param == null || param.length == 0
        || param[0] == null || param[0] == "") {
       return true;
      }
      if (toDate > param[0]) {
       return true;
      } else {
       if (param.length >= 2) {
        $.fn.validatebox.defaults.rules.compareDate.message = param[1];
       }
       else {
        $.fn.validatebox.defaults.rules.compareDate.message = '结束日期应该大于开始日期';
       }
       return false
      }
     },
     message : ''
    }, 
    idcard : {// 验证身份证
        validator : function(value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
           },
           message : '身份证号码格式不正确'
          },
      minLength : {
           validator : function(value, param) {
            return value.length >= param[0];
           },
           message : '请输入至少（2）个字符.'
          },
      length : {
           validator : function(value, param) {
            var len = $.trim(value).length;
            return len >= param[0] && len <= param[1];
           },
           message : "输入内容长度必须介于{0}和{1}之间."
          },
      phone : {// 验证电话号码
           validator : function(value) {
            return /^((\d2,3  )|(\d{3}\-))?(0\d2,3  |0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
              .test(value);
           },
           message : '格式不正确,请使用下面格式:020-88888888'
          },
          mobile : {// 验证手机号码
           validator : function(value) {
            return /^(13|15|18)\d{9}$/i.test(value);
           },
           message : '手机号码格式不正确'
          },
          phoneNum : {// 验证手机号码+固定电话
           validator : function(value) {
            return /^(((((010)|(02\d)))[2-8]\d{7})|(0[3-9]\d{2}[2-8]\d{6,7})|(0?(?:147|1[358]\d)\d{8}))$/i
              .test(value);
           },
           message : '手机号码格式不正确'
          },
          intOrFloat : {// 验证整数或小数
           validator : function(value) {
            return /^\d+(\.\d+)?$/i.test(value);
           },
           message : '请输入数字，并确保格式正确'
          },
          currency : {// 验证货币
           validator : function(value) {
            return /^\d+(\.\d+)?$/i.test(value);
           },
           message : '货币格式不正确'
          },
          qq : {// 验证QQ,从10000开始
           validator : function(value) {
            return /^[1-9]\d{4,9}$/i.test(value);
           },
           message : 'QQ号码格式不正确'
          },
          integer : {// 验证整数
           validator : function(value) {
            return /^[+]?[1-9]+\d*$/i.test(value);
           },
           message : '请输入整数'
          },
          age : {// 验证年龄
           validator : function(value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i
              .test(value);
           },
           message : '年龄必须是0到120之间的整数'
          },
          chinese : {// 验证中文
           validator : function(value) {
            return /^[\Α-\￥]+$/i.test(value);
           },
           message : '请输入中文'
          },
          english : {// 验证英语
           validator : function(value) {
            return /^[A-Za-z]+$/i.test(value);
           },
           message : '请输入英文'
          },
          unnormal : {// 验证是否包含空格和非法字符
           validator : function(value) {
            return /.+/i.test(value);
           },
           message : '输入值不能为空和包含其他非法字符'
          },
          username : {// 验证用户名
           validator : function(value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
           },
           message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
          },
          faxno : {// 验证传真
           validator : function(value) {
            // return /^[+]{0,1}(\d){1,3}[]?([-]?((\d)|[
            // ]){1,12})+$/i.test(value);
            return /^((\d2,3  )|(\d{3}\-))?(0\d2,3  |0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
              .test(value);
           },
           message : '传真号码不正确'
          },
          zip : {// 验证邮政编码
           validator : function(value) {
            return /^[1-9]\d{5}$/i.test(value);
           },
           message : '邮政编码格式不正确'
          },
          ip : {// 验证IP地址
           validator : function(value) {
            return /d+.d+.d+.d+/i.test(value);
           },
           message : 'IP地址格式不正确'
          },
          name : {// 验证姓名，可以是中文或英文
           validator : function(value) {
            return /^[\Α-\￥]+$/i.test(value)
              | /^\w+[\w\s]+\w+$/i.test(value);
           },
           message : '请输入姓名'
          },
          date : {// 验证姓名，可以是中文或英文
           validator : function(value) {
            // 格式yyyy-MM-dd或yyyy-M-d
            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i
              .test(value);
           },
           message : '清输入合适的日期格式'
          },
          msn : {
           validator : function(value) {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
              .test(value);
           },
           message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
          },
          same : {
           validator : function(value, param) {
            if ($("#" + param[0]).val() != "" && value != "") {
             return$("#" + param[0]).val() == value;
            } else {
             return true;
            }
           },
           message : '两次输入的密码不一致！'
          }
});
/*表单转成json数据*/
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
//--身份证号码验证-支持新的带x身份证
function isIdCardNo(num)
{
 var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4,
   2, 1);
 var error;
 var varArray = new Array();
 var intValue;
 var lngProduct = 0;
 var intCheckDigit;
 var intStrLen = num.length;
 var idNumber = num;
 // initialize
 if ((intStrLen != 15) && (intStrLen != 18)) {
  // error = "输入身份证号码长度不对！";
  // alert(error);
  // frmAddUser.txtIDCard.focus();
  return false;
 }
 // check and set value
 for (i = 0; i < intStrLen; i++) {
  varArray[i] = idNumber.charAt(i);
  if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
   // error = "错误的身份证号码！.";
   // alert(error);
   // frmAddUser.txtIDCard.focus();
   return false;
  } else if (i < 17) {
   varArray[i] = varArray[i] * factorArr[i];
  }
 }
 if (intStrLen == 18) {
  // check date
  var date8 = idNumber.substring(6, 14);
  if (isDate8(date8) == false) {
   // error = "身份证中日期信息不正确！.";
   // alert(error);
   return false;
  }
  // calculate the sum of the products
  for (i = 0; i < 17; i++) {
   lngProduct = lngProduct + varArray[i];
  }
  // calculate the check digit
  intCheckDigit = 12 - lngProduct % 11;
  switch (intCheckDigit) {
  case 10:
   intCheckDigit = 'X';
   break;
  case 11:
   intCheckDigit = 0;
   break;
  case 12:
   intCheckDigit = 1;
   break;
  }
  // check last digit
  if (varArray[17].toUpperCase() != intCheckDigit) {
   // error = "身份证效验位错误!...正确为： " + intCheckDigit + ".";
   // alert(error);
   return false;
  }
 }
 else { // length is 15
  // check date
  var date6 = idNumber.substring(6, 12);
  if (isDate6(date6) == false) {
   // alert("身份证日期信息有误！.");
   return false;
  }
 }
 // alert ("Correct.");
 return true;
}
/* easyui datagrid 添加和删除按钮方法*/
$.extend($.fn.datagrid.methods, {  
    addToolbarItem: function(jq, items){  
        return jq.each(function(){  
            var toolbar = $(this).parent().prev("div.datagrid-toolbar");
            for(var i = 0;i<items.length;i++){
                var item = items[i];
                if(item === "-"){
                    toolbar.append('<div class="datagrid-btn-separator"></div>');
                }else{
                    var btn=$("<a href=\"javascript:void(0)\"></a>");
                    btn[0].onclick=eval(item.handler||function(){});
                    btn.css("float","left").appendTo(toolbar).linkbutton($.extend({},item,{plain:true}));
                }
            }
            toolbar = null;
        });  
    },
    removeToolbarItem: function(jq, param){  
        return jq.each(function(){  
            var btns = $(this).parent().prev("div.datagrid-toolbar").children("a");
            var cbtn = null;
            if(typeof param == "number"){
                cbtn = btns.eq(param);
            }else if(typeof param == "string"){
                var text = null;
                btns.each(function(){
                    text = $(this).data().linkbutton.options.text;
                    if(text == param){
                        cbtn = $(this);
                        text = null;
                        return;
                    }
                });
            } 
            if(cbtn){
                var prev = cbtn.prev()[0];
                var next = cbtn.next()[0];
                if(prev && next && prev.nodeName == "div" && prev.nodeName == next.nodeName){
                    $(prev).remove();
                }else if(next && next.nodeName == "div"){
                    $(next).remove();
                }else if(prev && prev.nodeName == "div"){
                    $(prev).remove();
                }
                cbtn.remove();    
                cbtn= null;
            }                        
        });  
    }                 
});