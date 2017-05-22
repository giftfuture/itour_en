$package('itour.logSetting');
itour.logSetting = function(){
	var _box = null;
	var _this = {
		config:{
			event:{
				add:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.add();
				},
				edit:function(){
					$('#typeIds_combobox').combobox('reload');
					_box.handler.edit();
				}
			},
  			dataGrid:{
  				title:'日志设置',
	   			url:'logSetting/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'logCode',title:'日志码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.logCode;
							}
						},
					{field:'tableName',title:'表名',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.tableName;
							}
						},
					{field:'function',title:'功能',align:'center',sortable:true,
							formatter:function(value,row,index){
								return value;// row.function;
							}
						},
					{field:'urlTeimplate',title:'URL模板',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.urlTeimplate;
							}
						},
					{field:'creater',title:'操作人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.creater;
							}
						},
					{field:'deletescriptTemplate',title:'删除脚本',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.deletescriptTemplate;
							}
						},
					{field:'updatescriptTemplate',title:'更新脚本',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.updatescriptTemplate;
							}
						},
					{field:'createTime',title:'操作时间',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					]]
			}
		},
		init:function(){
			_box = new YDataGrid(_this.config); 
			_box.init();
		}
	}
	return _this;
}();

$(function(){
	itour.logSetting.init();
});