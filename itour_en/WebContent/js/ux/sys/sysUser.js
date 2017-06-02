$package('itour.sysUser');//class="easyui-layout"
itour.sysUser = function(){
	var _box = null;
	var _this = {
		updatePwdAction:'sysUser/updatePwd',
		editPwdForm:function(){
			return $("#pwdForm");
		},
		editPwdWin:function(){
			return $("#edit-pwd-win");
		},
		savePwd:function(){
			itour.progress();//缓冲条
			if(_this.editPwdForm().form('validate')){
				_this.editPwdForm().attr('action',_this.updatePwdAction);
				itour.saveForm(_this.editPwdForm(),function(data){
					itour.closeProgress();//关闭缓冲条
					_this.editPwdWin().dialog('close');
				});
			 }
		},
		initForm:function(){
			//修改密码
			_this.editPwdWin().find("#btn-pwd-submit").click(function(){
				_this.savePwd();
			});
			_this.editPwdWin().find("#btn-pwd-close").click(function(){	
				$.messager.confirm('提示','您确定关闭当前窗口吗?',function(r){  
				    if (r){  
				     	_this.editPwdWin().dialog('close');
				    }  
				});
			});
		},
		config:{
		    action:{
		    	save:'sysUser/save', //新增&修改 保存Action  
				getId:'sysUser/getId',//编辑获取的Action
				remove:'sysUser/delete',//删除数据的Action}
				logicremove:'sysUser/logicdelete',//逻辑删除Action
				updatePwd:'sysUser/updatePwd'//修改密码的action
		    },
  			dataGrid:{
  				title:'系统用户列表',
	   			url:'sysUser/dataList.json',
	   			columns:[[
						{field:'id',checkbox:true},
						{field:'email',title:'邮箱',width:120,sortable:true},
						{field:'nickName',title:'昵称',width:80,sortable:true},
						{field:'state',title:'状态',width:80,align:'center',sortable:true,styler:function(value,row,index){
							if(value == 1){
							  return 'color:red;';  
							}
						},
						formatter:function(value,row,index){
							if(value == 0){
								return "可用";
							}
							if(value == 1){
								return "禁用";
							}
						}},
						{field:'createTime',title:'创建时间',width:120,sortable:true},
						{field:'loginCount',title:'登录次数',align:'right',width:80,sortable:true},
						{field:'loginTime',title:'最近登录时间',width:120,sortable:true}
				]],
				toolbar:[
					{id:'btnadd',text:'添加',btnType:'add'},
					{id:'btnedit',text:'修改',btnType:'edit'},
					{id:'btnedit',text:'修改密码',btnType:'editPwd',iconCls:'icon-edit',handler:function(){
							var selected = _box.utils.getCheckedRows();
							if ( _box.utils.checkSelectOne(selected)){
								_this.editPwdForm().resetForm();
								_this.editPwdForm().find("input[name='id']").val(selected[0].id);
								_this.editPwdForm().find("input[name='email']").val(selected[0].email);
								_this.editPwdWin().window('open'); 
							}
						}},
					{id:'btndelete',text:'物理删除',btnType:'remove'},
					{id:'btnlogicdelete',text:'删除',iconCls:'icon-remove',btnType:'logicremove'}
				]
			}
		},
		init:function(){
			_this.initForm();
			_box = new YDataGrid(_this.config); 
			_box.init();
			/* 自定义密码验证*/
			$.extend($.fn.validatebox.defaults.rules, {  
			    equals: {  
			        validator: function(value,param){  
			            return value == $(param[0]).val();  
			        },  
			        message: '两次输入密码不匹配.'  
			    }
			});
		}
	}
	return _this;
}();

$(function(){
	itour.sysUser.init();
	  if (window != top)
          top.location.href = location.href;
});		