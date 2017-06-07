$package('itour.showOrders');
itour.showOrders = function(){
	var _this = {
		  showSuccess:function (str) {
				$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
					opacity : 1,
					right : '0'
				}, 500);
			},
			//显示错误提示
			showError:function (str) {
				$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
					opacity : 1,
					right : '0'
				}, 500);

			},
		init:function(){
			//$('#TableID').find('tbody').find('tr:eq(4)').find('td:lt(2)')
			/*$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(1)').hide();
			$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(2)').show();
			$("table[name='rtscheduleTable']").find('tbody:eq(1)').show();
			$("table[name='rtscheduleTable']").find('tbody:eq(2)').hide();*/
			//$("table[name='rtscheduleTable']").find('tbody:eq(1)').find("a:eq(0)").attr("href",_this.togglequotoForm);
			//$("table[name='rtscheduleTable']").find('tbody:eq(1)').find("a:eq(0)").bind('click',_this.togglequotoForm);
			//$("#eddit").click(_this.togglequotoForm);
			$(document).keydown(function(e){
	    		 e = e || window.event;
	    		if(e.keyCode == 13) {
	    		 
	    		}
	    	});
		}
	}
	return _this;
}();

$(function(){
	itour.showOrders.init();
	/*  if (window != top)
          top.location.href = location.href;*/
});