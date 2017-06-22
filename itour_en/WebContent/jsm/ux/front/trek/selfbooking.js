$package('itouren.trekselfbooking');
itouren.trekselfbooking = function(){
	var _this = {
		formatterDate : function(date) {//得到当前日期
			var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
			var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1);
			return date.getFullYear() + '-' + month + '-' + day;
		},
		onChangeDate: function(obj){  
           // $(obj).prev().val(date);  
        },
        changeValidateCode:function () {  
            var timenow = new Date().getTime();//这是为了防止每次刷新的时候验证码相同
            $("#validateCode").attr("src",basePath+"RandomCodeServlet?d="+timenow);  
        }, 
        check_form:function(){
        	itouren.progress('Please waiting','Booking...');
        	var formData = {};
        	formData.routename=$("input[name='routename'").val();
    		formData.expectedDepart = $("#expectedDepart").datebox('getValue');
        	formData.expectedBack = $("#expectedBack").datebox('getValue');
        	formData.travelfashion = $("#travelfashion").combobox('getValue')=="Please Choose"?"": $("#travelfashion").combobox('getValue');
        	formData.budget = $("input[name='budget']").val();
        	formData.singleorcluster = $("#singleorcluster").combobox('getValue');
        	formData.groupCode =$("#groupCode").textbox('getValue');
			formData.groupDate = $("#groupDate").datebox('getValue');
        	formData.travelrequest="";
        	 if($("input:checked[name='travelrequest[]']").length>0){
        		 $("input:checked[name='travelrequest[]']").each(function(){        			 
        			 formData.travelrequest+=($(this).val()?$(this).val()+",":"");
        		 })
        	 }
    	//	formData.travelrequest = $("input:checked[name='travelrequest[]']").val()? $("input:checked[name='travelrequest[]']").val().join(','):"";
        	formData.hotel = $("#hotel").combobox('getValue')=="Please Choose"?"":$("#hotel").combobox('getValue');
        	formData.guide = $("input:checked[name='guide'][type='radio']").val()=="Other languages"?$("input[name='guide_other']").val():$("input:checked[name='guide'][type='radio']").val();
        	formData.foodArrange = $("input:checked[name='foodArrange']").val();
        	formData.receiver = $("input[name='receiver']").val();
        	formData.gender = $("#gender").combobox('getValue')=="Gender"?"":parseInt($("#gender").combobox('getValue'));
        	formData.adults = $("input[name='adults']").val();
        	formData.children = $("input[name='children']").val();
        	formData.comefrom = $("#comefrom").combobox('getValue')=="Please Choose"?"":$("#comefrom").combobox('getValue');
        	formData.receiveremail = $("input[name='receiveremail'").val();
        	formData.receiverMobile = $("input[name='receiverMobile']").val();
        	formData.stayrequest="";
        	//formData.stayrequest = $("input:checked[name='stayrequest[]']").val()?$("input[name='stayrequest[]'][checked='checked']").val().join(','):"";
        	if($("input:checked[name='stayrequest[]']").length>0){
        		$("input:checked[name='stayrequest[]']").each(function(){
        			formData.stayrequest+=($(this).val()?$(this).val()+",":"");
        		})
        	}
        	//formData.position = $("input:checked[name='position[]']").val()?$("input[name='position[]'][checked='checked']").val().join(','):"";
        	formData.position="";
        	if($("input:checked[name='position[]']").length>0){
        		$("input:checked[name='position[]']").each(function(){
        			formData.position+=($(this).val()?$(this).val()+",":"");
        		})
        	}
        	formData.db_room = $("input[name='db_room']").val();
        	formData.bb_room = $("input[name='bb_room']").val();
        	formData.suite = $("input[name='suite']").val();
        	formData.hotel_no_smoking = $("input:checked[name='hotel_no_smoking']").val();
        	formData.hotel_quiet = $("input:checked[name='hotel_quiet']").val();
        	formData.hotel_info = $("input:checked[name='hotel_info']").val();
        	formData.plane = $("input:checked[name='plane[]']").val();
        	//formData.plane="";
        	/*if($("input:checked[name='plane[]']").length>0){
        		$("input:checked[name='plane[]']").each(function(){
        			formData.plane+=($(this).val()?$(this).val()+",":"");
        		})
        	}*/
        	formData.shipping_space = $("input:checked[name='shipping_space']").val();
        	formData.car = $("input:checked[name='car']").val();
        	formData.car_no_smoking =  $("input:checked[name='car_no_smoking']").val();
        	formData.car_new =  $("input:checked[name='car_new']").val();
        	formData.train = $("input:checked[name='train']").val();
        	formData.cruise = $("input:checked[name='cruise']").val();
        	formData.tickets = $("input:checked[name='tickets']").val();
        	//var foodrequestarray = $("input:checked[name='foodrequest[]']").val();
        	formData.foodrequest="";
        	if($("input:checked[name='foodrequest[]']").length>0){
        		$("input:checked[name='foodrequest[]']").each(function(){
        			formData.foodrequest+=($(this).val()?$(this).val()+",":"");
        		})
        	}
        	//console.log(formData.travelrequest);
        	//formData.foodrequest = foodrequestarray?foodrequestarray.join(','):"";
        	//formData.foodrequest+=','+$("input[name='foodrequest1']").val();
        	//formData.taste = $("input:checked[name='taste[]']").val()?$("input[name='taste[]']").val().join(','):"";
        	formData.taste="";
        	if($("input:checked[name='taste[]']").length>0){
        		$("input:checked[name='taste[]']").each(function(){
        			formData.taste+=($(this).val()?$(this).val()+",":"");
        		})
        	}
        	formData.hatefood = $("input[name='hatefood']").val();
        	formData.recreation = $("input:checked[name='recreation']").val();
        	formData.specialrequest = $("input[name='specialrequest']").val();
        	formData.verifyCode = $("input[name='verifyCode']").val();
        /*	document.forms["booking"].action=basePath+"orderDetail/booking";
    		itouren.saveFormWithoutLogin($(document.forms["booking"]),function(data){
				itouren.closeProgress();
				itouren.alert('提示',data.msg||'保存成功！','info');
			});*/
        	//$(document.forms["booking"]).serializeObject()
        	//console.log(formData);
        	__.post(basePath+"travelOrder/booking",formData,function(data){
				itouren.closeProgress();
				//console.log(data);
				itouren.alert('提示',data.msg||'Scheduled success, please check the mailbox reservation success later!','info');
			});
        },
		init:function(){
		/*	if($("#travelfashion").combobox('getValue')=="加入散客团"){
				$("#groupdiv").show();
			}else{
				$("#groupdiv").hide();
			}*/
			$("#travelfashion").combobox({
				onChange: function (n,o) {
					if($(this).combobox('getValue')=="Join FIT"){
						$("#groupdiv").show();
					}else{
						$("#groupCode").textbox('setValue','');
						$("#groupDate").datebox('setValue','');
						$("#groupdiv").hide();
					}
			}});
			if($("input:checked[name='guide'][type='radio']").val()=="Other languages"){
				$("#elseguide").show();
			}else{
				$("#elseguide").hide();
			}
			$("input[name='guide'][type='radio']").click(function(){
				//console.log($("input:checked[name='guide'][type='radio']").val());
				if($("input:checked[name='guide'][type='radio']").val()=="Other languages"){
					$("#elseguide").show();
				}else{
					$("#elseguide").hide();
				}
			});
			$("a[name='check_formbtn']").click(_this.check_form);
			 $(document).keydown(function(e){
	    		 e = e || window.event;
	    		if(e.keyCode == 13) {
	    			_this.check_form;
	    		}
	    	});
			$.extend($.fn.validatebox.defaults.rules,{ 
				dateValided:{
			        validator : function(value) { //参数value为当前文本框的值
			        	var d =  _this.formatterDate(new Date());
			        //	itouren.alert('提示',value +"    "+ d+"   "+(value > d),'info');
			           if(d>=value){
			        	   //itouren.alert('提示','选择行程安排日期应在当前日期之后','warn');
			        	   //$("input[name='tourTime']").datebox('setValue','');  
			           }else{
			        	   return value > d;  
			           }
			        },  
			        message : 'The routing date should be selected after the current date.'  //
				},
			    md : {  
			        validator : function(value,param) { //参数value为当前文本框的值
			        	var startTime = $(param[0]).datebox('getValue'); 
			        	return value>startTime; 
			        },  
			        message : 'The choice of itinerary should be after the departure date.'  //
			    }  
			}); 
		}
	}
	return  _this;
}();

$(function(){
	itouren.trekselfbooking.init();
});