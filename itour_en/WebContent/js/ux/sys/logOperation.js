$package('itour.logOperation');
itour.logOperation = function(){
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
  				title:'操作日志',
	   			url:'logOperation/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'operCode',title:'操作码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.operCode;
							}
						},
					{field:'logCode',title:'日志码',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.logCode;
							}
						},
					{field:'operationType',title:'操作类型',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.operationType;
							}
						},
					{field:'primaryKeyvalue',title:'主键值',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.primaryKeyvalue;
							}
						},
					{field:'content',title:'操作明细',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.content;
							}
						},
						{field:'newContent',title:'更新明细',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.content;
							}
						},
					{field:'url',title:'操作URL',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.url;
							}
						},
					{field:'creater',title:'操作人',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.creater;
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
	itour.logOperation.init();
});