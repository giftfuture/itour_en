$package('itour.climbstep2');
itour.climbstep2 = function(){
	var _this = {
			checkedAll:function (name){//全选
				  var names=document.getElementsByName(name);
				  var len=names.length;
				  if(len>0){
				   for(var i=0;i<len;i++)
				   names[i].checked=true;
				  }
			},
			uncheckedAll:function (name){//全不选
					var names=document.getElementsByName(name);
					var len=names.length;
					if(len>0){
					    for(var i=0;i<len;i++)
					    names[i].checked=false;
					  }
			},
			onlyNonNegative:function (obj) {
				 var inputChar = event.keyCode;
				 //alert(event.keyCode);
				 //1.判断是否有多于一个小数点
				 if(inputChar==190 ) {//输入的是否为.
				  var index1 = obj.value.indexOf(".") + 1;//取第一次出现.的后一个位置
				  var index2 = obj.value.indexOf(".",index1);
				  while(index2!=-1) {
				   //alert("有多个.");
				   
				   obj.value = obj.value.substring(0,index2);
				   index2 = obj.value.indexOf(".",index1);
				  }
				 }
				 //2.如果输入的不是.或者不是数字，替换 g:全局替换
				 obj.value = obj.value.replace(/[^(\d|.)]/g,"");
		},
		init:function(){
			//$("input[name='adults']").on('keyup',_this.onlyNonNegative);
			//$("input[name='children']").on('keyup',_this.onlyNonNegative);
			$("input[name='adults']").numberbox({  
				 onChange:function(){ 	
					_this.onlyNonNegative;
					if(!isNaN($(this).val())){
						var adultsprice = $("input[name='adultsprice']").val();
						var result = parseFloat(adultsprice)*parseInt($(this).val());
						$.parser.parse($("input[name='quoteadults']").parent());
						$("#quoteadults").numberbox('setValue',result);
						$("#quoteticketadults").numberbox('setValue',parseFloat($("#quoteticketadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotetraveldocadults").numberbox('setValue',parseFloat($("#quotetraveldocadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotetourguideadults").numberbox('setValue',parseFloat($("#quotetourguideadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteshowHoteladults").numberbox('setValue',parseFloat($("#quoteshowHoteladults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoterentcaradults").numberbox('setValue',parseFloat($("#quoterentcaradults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotebigtrafficadults").numberbox('setValue',parseFloat($("#quotebigtrafficadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotedinneradults").numberbox('setValue',parseFloat($("#quotedinneradults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteinsuranceadults").numberbox('setValue',parseFloat($("#quoteinsuranceadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotecomphcostadults").numberbox('setValue',parseFloat($("#quotecomphcostadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoterecreationadults").numberbox('setValue',parseFloat($("#quoterecreationadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteitemguidecadults").numberbox('setValue',parseFloat($("#quoteitemguidecadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotebathorseadults").numberbox('setValue',parseFloat($("#quotebathorseadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteridehorseadults").numberbox('setValue',parseFloat($("#quoteridehorseadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteclimbregisteradults").numberbox('setValue',parseFloat($("#quoteclimbregisteradults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteclimbnexusadults").numberbox('setValue',parseFloat($("#quoteclimbnexusadults").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteelsecostadults").numberbox('setValue',parseFloat($("#quoteelsecostadults").parents("td").prev().prev().text())*parseInt($(this).val()));
/*						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));*/
						
					}
				 }
			});
			$("input[name='children']").numberbox({  
				 onChange:function(){
					_this.onlyNonNegative;
					if(!isNaN($(this).val())){
						var childrenprice = $("input[name='childrenprice']").val();
						var result =  parseFloat(childrenprice)*parseInt($(this).val());
						$("#quotechildren").numberbox('setValue',result);
						$("#quoteticketchildren").numberbox('setValue',parseFloat($("#quoteticketchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotetraveldocchildren").numberbox('setValue',parseFloat($("#quotetraveldocchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotetourguidechildren").numberbox('setValue',parseFloat($("#quotetourguidechildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteshowHotelchildren").numberbox('setValue',parseFloat($("#quoteshowHotelchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoterentcarchildren").numberbox('setValue',parseFloat($("#quoterentcarchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotebigtrafficchildren").numberbox('setValue',parseFloat($("#quotebigtrafficchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotedinnerchildren").numberbox('setValue',parseFloat($("#quotedinnerchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteinsurancechildren").numberbox('setValue',parseFloat($("#quoteinsurancechildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotecomphcostchildren").numberbox('setValue',parseFloat($("#quotecomphcostchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoterecreationchildren").numberbox('setValue',parseFloat($("#quoterecreationchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteitemguidechildren").numberbox('setValue',parseFloat($("#quoteitemguidechildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quotebathorsecchildren").numberbox('setValue',parseFloat($("#quotebathorsecchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteridehorsechildren").numberbox('setValue',parseFloat($("#quoteridehorsechildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteclimbregisterchildren").numberbox('setValue',parseFloat($("#quoteclimbregisterchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteclimbnexuschildren").numberbox('setValue',parseFloat($("#quoteclimbnexuschildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						$("#quoteelseecostchildren").numberbox('setValue',parseFloat($("#quoteelseecostchildren").parents("td").prev().prev().text())*parseInt($(this).val()));
						/*$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));
						$("#").numberbox('setValue',parseFloat($(this).prev().prev().text())*parseInt($(this).val()));*/
					}
				 }
			});
			//$("input[name='quoteticketadults']").numberbox('setValue',);
			$("input[name='route_checkall']").click(function(){
				if($(this).attr("checked")){
					_this.checkedAll("breakfast");
					_this.checkedAll("lunch");
					_this.checkedAll("dinner");
			 }else{
					_this.uncheckedAll("breakfast");
					_this.uncheckedAll("lunch");
					_this.uncheckedAll("dinner");
			 }
			});
			$("input[name='calculateSum']").click(function(){
				//document.forms["calculatespendForm"].submit();
				var formData = new Object();
				var actionurl=basePath+"climb/calculateSum";
				var id=$("input[type='hidden'][name='id']").val();
				var adults=$("input[name='adults']").val();	
				var children=$("input[name='children']").val();	
				var param = {'id':id,'adults':parseInt(adults),'children':parseInt(children)};
				formData.id=$("input[type='hidden'][name='id']").val();
				formData.adults=$("input[name='adults']").val();	
				formData.children=$("input[name='children']").val();	
				//console.log(formData);
				__.post(actionurl,formData, function(result) {
					//console.log("data.success="+data.success);
					//console.log(result.adultsumcost+"   "+result.childrensumcost);
					$("input[name='calculateSum']").parents("td").next().next().next().html(result.adultsumcost);
					$("input[name='calculateSum']").parents("td").next().next().next().next().html(result.childrensumcost);
					//$("td[name='adultsumcost']").html(result.adultsumcost);
					//$("td[name='childrensumcost']").html(result.childrensumcost);
				});
			});
		}
	}
	return  _this;
}();

/*window.onload=function(){
	itour.climbstep2.init();
}*/
$(function(){
	itour.climbstep2.init();
});