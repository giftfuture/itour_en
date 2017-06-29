<%@ page language="java" import="java.util.*,com.itour.base.util.SessionUtils" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
 <%  
 request.setCharacterEncoding("UTF-8");  
 String session_user = "";  
 Cookie[] cookies = request.getCookies();  
 if(null != cookies && cookies.length > 0) {  
     for(Cookie c : cookies) {  
         if(SessionUtils.SESSION_USER.equals(c.getName())) {  
         	session_user = c.getValue();  
         	break;
         } 
     }  
 }  
// System.out.println("################"+session_user);
%>  
<!DOCTYPE HTML>
<html>
  <head>
     <title>itour后台管理界面</title>
     <link rel="stylesheet" type="text/css" href="css/main.css">
     <script type="text/javascript" src="js/ux/main/main.js"></script>
     <script type="text/javascript">
       itouren.main.setCookie('<%=SessionUtils.SESSION_USER%>','<%=session_user%>');
     </script>  
  </head>
  <body class="easyui-layout">
 	<div class="ui-header" data-options="region:'north',split:true,border:false" style="height:40px;overflow: hidden;">
 	<h1></h1>
 	<div  class="ui-login">
 		<div class="ui-login-info">
	 		欢迎 <span class="orange">${user.nickName}</span> 第[<span class="orange">${user.loginCount}</span>]次登录 
	 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 		<a class="modify-pwd-btn"  href="javascript:void(0);">修改密码</a> |
 			<a class="logout-btn" href="main/logout">安全退出</a>
 		</div>
 	</div>
 	</div>
	<!-- 树形菜单 -->
	<div data-options="region:'west',split:true,title:'功能导航'" style="width:200px;">
		<div id="tree-box" class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach var="item" items="${menuList}">
				<div title="${item.text}">
					<c:forEach var="node" items="${item.children}">
					<a class="menu-item" onclick="javascript:dirurl(this,'${basePath}${node.url}')"  href="javascript:void(0)">${node.text}</a><!--  onclick="javascript:dirurl(this,'${basePath}${node.url}')" -->
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	 <script type="text/javascript">
	      var curuser =itouren.main.getCookie('<%=SessionUtils.SESSION_USER%>');
	      if(!curuser && document.referrer != basePath+"main/login" && window.location.href != basePath+"main/login"){
	    	  window.parent.location.href = basePath+"main/login";        
	      }
	      function dirurl(obj,uul){
	    	  console.log("curuser="+itouren.main.getCookie('<%=SessionUtils.SESSION_USER%>'));
	    	  if(!itouren.main.getCookie('<%=SessionUtils.SESSION_USER%>') && window.location.href != basePath+"main/login"){
	    		  window.parent.location.href = basePath+"main/login"; 
	          }else{
	        	  $(obj).attr("href",uul);
	          }
	      }
	      
     </script>
	</div>
	<div data-options="region:'south',split:true,border:false" style="height: 30px;overflow:hidden;">
		<div class="panel-header" style="border: none;text-align: center;" >CopyRight &copy; 2016 itour 版权所有. &nbsp;&nbsp;官方网址: www.itours.com.cn</div>
	</div>
	<!-- 中间内容页面 -->
	<div data-options="region:'center'" >
		<div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
			<div title="Welcome" style="padding:20px;overflow:hidden;"> 
				<div style="margin-top:20px;">
				</div>
				<pre>欢迎进入主角旅行英文版网站后台管理界面</pre>
				<div style="margin-top:20px;">
				</div>
			</div>
	 
		</div>	
	</div>
	<!--  modify password start -->
	<div id="modify-pwd-win"  class="easyui-dialog" buttons="#editPwdbtn" title="修改用户密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:350px;height:200px;">
		<form id="pwdForm" action="${basePath}main/modifyPwd" class="ui-form" method="post">
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="email">
     		 <div class="ui-edit">
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" class="easyui-textbox"  data-options="required:true"/>
	           </div>
	            <div class="fitem">  
	               <label>新密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" class="easyui-textbox" data-options="required:true" />
	           </div> 
	           <div class="fitem">  
	               <label>重复密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" class="easyui-textbox"   data-options="required:true" required="required" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	 </form>
     	 <div id="editPwdbtn" class="dialog-button" >  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
         </div>
	</div>
	<!-- modify password end  -->
  </body>
</html>
