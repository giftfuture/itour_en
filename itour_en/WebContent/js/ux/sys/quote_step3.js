$package('itouren.serverquotestep2');
itouren.serverquotestep3 = function(){
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
	itouren.serverquotestep3.init();
	/*  if (window != top)
          top.location.href = location.href;*/
});