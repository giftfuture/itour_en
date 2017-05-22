$package('itour.footer');
itour.footer = function(){
	var _this = {
		searchRtResult:function(){
			document.forms["searchForm"].action=basePath+"search";
			document.forms["searchForm"].submit();
		},init:function(){
			if(window.top != window.self){
				window.top.location =  window.self.location;
			}
			//$("a[name='search']").click(_this.searchRtResult); 
			//$("a[name='search']").attr("href",_this.searchRtResult); 
			/*_this.fbpagination(1); href="itour.footer.searchRtResult"
			$("#searchbtn").click(function(){
				//console.log("11111");
				_this.fbpagination(1);
			});*/
			//_this.travelStyle;
			//$("#searchForm").submit(_this.search);
			//验证码图片绑定点击事件
			//var form = $("#loginForm");
			//form.submit(itour.login.toLogin);
			/*$("select[name='areas']").combobox({ 
			    url:basePath+'travelItem/allScopes', 
			    valueField:'key',    
			    textField:'value'
			});*/
		}
	}
	return _this;
}();

window.onload=function(){
	itour.footer.init();
}
/*$(function(){
	itour.footer.init();
});	*/	