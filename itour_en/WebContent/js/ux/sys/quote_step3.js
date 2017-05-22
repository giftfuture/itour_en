$package('itour.serverquotestep2');
itour.serverquotestep3 = function(){
	var _this = {
		init:function(){
			$("input[name='plusSumPrice']").numberbox({  
				 onChange:function(){
					_this.onlyNonNegative;
					if(!isNaN($(this).val())){	
						$("span[name='childsperguy']").$("input[name='plusSumPrice']").val();
					}
				 }
			});
		}
	}
	return  _this;
}();

$(function(){
	itour.serverquotestep3.init();
});