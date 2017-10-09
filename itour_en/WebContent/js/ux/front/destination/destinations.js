$package('itouren.destinations');
itouren.destinations = function(){
	var _this = {
		init:function(){
			var docwidth = document.documentElement.clientWidth;
			var paddingwidth = (docwidth-1140)/2;
			//$("ul.menu").css("padding-left",paddingwidth);
			_this.menuClick();
		},
		accordion:function(){
			$(this).addClass('current')   //给当前元素添加"current"样式
			.find('i').addClass('down')   //小箭头向下样式
			.parent().next().slideDown('slow','easeOutQuad')  //下一个元素显示
			.parent().siblings().children('a').removeClass('current')//父元素的兄弟元素的子元素去除"current"样式
			.find('i').removeClass('down').parent().next().slideUp('slow','easeOutQuad');//隐藏
			 return false; //阻止默认时间
		},
		menuClick:function(){
			$(".treebox .menu .level1>a").click(_this.accordion);
		}
	}
	return  _this;
}();

$(function(){
	itouren.destinations.init();
	//itouren.destinations.menuClick();
});