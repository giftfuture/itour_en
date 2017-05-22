<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head>
 <script type="text/javascript" src="<%=basePath%>js/ux/sys/sysUser.js"></script>
</head>
	<body class="easyui-layout">
	<!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
 	 	<p class="ui-fields">
 	 	    <label class="ui-label">邮箱:</label><input name="email" class="easyui-textbox" style="width:100px;">&nbsp;&nbsp;
            <label class="ui-label">状态: </label><select name="state" class="easyui-combobox" data-options="editable:false,region:'north',split:true,border:false"><option value="">--请选择--</option><option value=0>可用</option><option value=1>禁用</option></select>&nbsp;&nbsp;
             <label class="ui-label">创建时间: </label><input name="createTime" class="easyui-datebox" data-options="editable:false,region:'north',split:true,border:false">&nbsp;&nbsp;
        </p>
        <a href="javascript:void(0)" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->
     <!-- DataList  -->
     <div region="center" border="false" >
     <table id="data-list"></table>
     </div>

     <!-- Edit Form -->
     <div id="edit-win" class="easyui-dialog" title="系统用户" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" type="text" name="id">
     		 <input class="hidden" name="deleted">
     		 <div class="ui-edit">
	     	   <!-- <div class="ftitle">系统用户信息</div> -->    
	           <div class="fitem">  
	               <label>邮箱:</label>  
	               <input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'">
	           </div>  
	            
	           <div class="fitem">  
	               <label>用户名:</label>  
	               <input class="easyui-textbox" type="text" name="nickName" data-options="required:true,validType:'length[1,10]'">
	           </div>
	            <div class="fitem">  
	               <label>状态:</label>  
	               <select class="easyui-combobox" name="state"  data-options="editable:false,region:'north',split:true,border:false,required:true">
                    	<option value="0" selected="selected">可用</option>
                    	<option value="1">禁用</option>
                   	</select>
	           </div> 
	         </div>
     	</form>
  	 </div> 
  	 
  	 <!-- Edit Password Form -->
     <div id="edit-pwd-win" class="easyui-dialog" buttons="#editPwdbtn" title="修改密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:340px;">
     	<form id="pwdForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
	     	  <!--  <div class="ftitle">用户信息</div>     -->
	           <div class="fitem">  
	               <label>邮箱:</label>  
	               <input class="easyui-textbox" type="text" readonly="readonly" name="email" data-options="required:true,validType:'email'">
	           </div>  
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" class="easyui-textbox" data-options="required:true"/>
	           </div>
	            <div class="fitem">  
	               <label>新密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" class="easyui-textbox" data-options="required:true" />
	           </div> 
	           <div class="fitem">  
	               <label>确认密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" class="easyui-textbox"   required="required" data-options="validType:'equals[\'#newPwd\']'" />
	           </div> 
	         </div>
     	</form>
     	 <div id="editPwdbtn" class="dialog-button">  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
        </div>
  	 </div> 
	
  </body>
</html>
