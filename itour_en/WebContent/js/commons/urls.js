/*全局Url， 获取配置 urls['msUrl']*/ 
/**
var urls= {
	'msUrl':'http://127.0.0.1:8080/ms',
	'easyuiUrl':'http://127.0.0.1:8080/ms/js/jquery-easyui-1.3.2'
}*/
var urls= {
	'msUrl':'/itour/',
	'easyuiUrl':'/js/jquery-easyui-1.3.2'
}
$('input.easyui-datetimebox').datetimebox({
    showSeconds: false
});
$("input.easyui-datetimebox").on('focus',function(){	
	console.log(1111111111111111);
	$(this).datetimebox('getValue');
});
//alert(urls['msUrl']);