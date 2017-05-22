$package('itour.logSettingDetail');
itour.logSettingDetail = function(){
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
  				title:'日志设置详情',
	   			url:'logSettingDetail/dataList.json',
	   			columns:[[
					{field:'id',checkbox:true},
					{field:'detailCode',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.detailCode;
							}
						},
					{field:'logCode',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.logCode;
							}
						},
					{field:'columnName',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.columnName;
							}
						},
					{field:'columnText',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.columnText;
							}
						},
					{field:'columnDatatype',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.columnDatatype;
							}
						},
					{field:'createTime',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.createTime;
							}
						},
					{field:'creater',title:'',align:'center',sortable:true,
							formatter:function(value,row,index){
								return row.creater;
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
	itour.logSettingDetail.init();
});