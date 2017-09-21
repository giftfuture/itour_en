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
	<div data-options="region:'west',split:true,title:'功能导航'" style="width:150;">
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
	    	 // console.log("curuser="+itouren.main.getCookie('<%=SessionUtils.SESSION_USER%>'));
	    	  if(!itouren.main.getCookie('<%=SessionUtils.SESSION_USER%>') && window.location.href != basePath+"main/login"){
	    		  window.parent.location.href = basePath+"main/login"; 
	          }else{
	        	  $(obj).attr("href",uul);
	          }
	      }
     </script>
	</div>
	<div data-options="region:'south',split:true,border:false" style="height:30px;overflow:hidden;">
		<div class="panel-header" style="border:none;text-align:center;" >CopyRight &copy; 2016 itour 版权所有. &nbsp;&nbsp;官方网址: www.itours.com.cn</div>
	</div>
	<!-- 中间内容页面 -->
	<div data-options="region:'center'">
		<div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
			<div title="Welcome" style="padding:20px;overflow:auto;"> 
				<div style="margin-top:20px;">
				<pre style="font-size:1.5em;font-family: '微软雅黑';">欢迎进入主角旅行英文版网站后台管理界面</pre>
				<table style="margin-top:20px;width:100%;height:auto;border:1px solid grey;overflow-y:scroll;" border="1" name="unDealedOrders" id="unDealedOrders">
				</table>
                 <table style="margin-top:20px;width:100%;height:auto;border:1px solid grey;overflow-y:scroll;" border="1" name="unDealedDiarys" id="unDealedDiarys">
                </table>
                <table style="margin-top:20px;width:100%;height:auto;border:1px solid grey;overflow-y:scroll;" border="1" name="unCheckedMsgs" id="unCheckedMsgs">
                </table>
				 <div id="unDealedOrdersWin" buttons="#unDealedOrdersbtn" class="easyui-dialog" title="订单信息" data-options="collapsible:false,minimizable:false,maximizable:false,shadow:true,closed:true,iconCls:'icon-filter',modal:true,width:850,height:650">
                           <table width="100%" border="0" align="center" cellpadding="5" cellspacing="5" class="heedline1 odinfotb">
                                <tr> 
                                 <td width="50%"  style="text-align:left;padding-left:15px" ><strong>订单号：<span name="orderNo"></span> </strong></td>
                                  <td width="50%" style="text-align:left" ><strong>订单名称：<span name="orderName"></span> </strong></td>
                                </tr>
                                <tr>
                                  <td width="50%" style="text-align:left;padding-left:15px" >旅行线路： <span name="routename"></span></td>
                                  <td width="50%" style="text-align:left" >旅行预算：<span name="budget"></span>元/<span name="singleorcluster"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >联系人姓名：<span name="receiver" ></span></td>
                                  <td width="50%" style="text-align:left" >性别：<span name="gender"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >预计出行日期：<span name="expectedDepart"></span></td>
                                  <td width="50%" style="text-align:left" >预计返程日期：<span name="expectedBack"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >出行方式：<span name="travelfashion"></span></td>
                                  <td width="50%" style="text-align:left" >出团日期：<span name="groupDate"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >酒 店：<span name="hotel"></span></td>
                                  <td width="50%" style="text-align:left;">人数：&nbsp;&nbsp;大人<span name="adults"></span>位&nbsp;&nbsp;小孩（12岁以下）<span name="children"></span>位</td>
                                </tr>
                                <tr> 
                                  <td colspan=2 style="text-align:left;padding-left:15px" >行程要求： <span name="travelrequest"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >导 游：<span name="guide"></span></td>
                                  <td width="50%" style="text-align:left" >是否安排饮食 ：<span name="foodArrange"></span> </td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >国家及地区：<span name="areaname"></span></td>
                                  <td width="50%" style="text-align:left" >E-mail：<span name="receiveremail"></span></td>
                                </tr>
                                <tr> 
                                  <td width="50%" style="text-align:left;padding-left:15px" >联系电话：<span name="receiverMobile"></span></td>
                                  <td width="50%" style="text-align:left" >门票：<span name="tickets"></span></td>
                                </tr>
                                <tr> 
                                  <td colspan=2 style="text-align:left;padding-left:15px">住宿要求：
                                 特色酒店： <span name="stayrequest"></span>&nbsp;&nbsp;地理位置： <span name="position"></span></td></tr>
                             <tr><td colspan=2 style="text-align:left;padding-left:15px" >房型要求：双床房<span name="db_room"></span>间，大床房<span name="bb_room"></span>间，套房<span name="suite"></span>间</td></tr>
                             <tr><td colspan=2 style="text-align:left;padding-left:15px" >住宿备注：<span name="hotel_no_smoking"></span>&nbsp;&nbsp;<span name="hotel_quiet"></span>&nbsp;&nbsp;<span name="hotel_info"></span></td></tr>
                             <tr><td style="text-align:left;padding-left:15px" colspan=2>交通：&nbsp;&nbsp;飞机：<span name="plane"></span>&nbsp;&nbsp;舱位：<span name="shipping_space"></span>&nbsp;&nbsp;汽车：<span name="car"></span>&nbsp;&nbsp;<span name="car_no_smoking"></span>&nbsp;&nbsp;<span name="car_new"></span>&nbsp;&nbsp;火车：<span name="train"></span>&nbsp;&nbsp;游轮：<span name="cruise"></span></td></tr>
                            <tr><td style="text-align:left;padding-left:15px" colspan=2>用餐要求：&nbsp;&nbsp;特色：<span name="foodrequest"></span> &nbsp;&nbsp;&nbsp;&nbsp;口味：<span name="taste"></span>&nbsp;&nbsp;&nbsp;&nbsp;忌口：<span name="hatefood"></span></td></tr>
                            <tr><td colspan=2 style="text-align:left;padding-left:15px">娱乐：<span name="recreation"></span></td></tr><tr> 
                              <td colspan=2 style="text-align:left;padding-left:15px">更多个性需求：<span name="specialrequest"></span></td></tr>
                            </table>
                   <!--   <div id="#unDealedOrdersbtn" class="dialog-button" >  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok" id="btn-Orders-submit">确定</a>  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" id="btn-Orders-close">关闭</a>  
                     </div> -->
                </div>
               <div id="unDealedDiarysWin" buttons="#unDealedDiarysbtn" class="easyui-dialog" title="游记处理" data-options="collapsible:false,minimizable:false,maximizable:false,shadow:true,closed:true,iconCls:'icon-edit',modal:true,width:1000,height:750">
                   <form method="post">
                    <input type="hidden" name="id">
                   <table width="100%" border="0" align="center" cellpadding="10" cellspacing="0">
                         <tr><td  style="text-align:left" class="STYLE18">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<span name="title" ></span></td>
                         <td rowspan=4 style="vertical-align:top; padding-top:10px;" class="STYLE18">
                                封面图片： <img name="cover" src="" style="border:none;" border="0px" height="200" width="200" /></td></tr>
                         <tr>
                            <td style="text-align:left"><span class="STYLE23 STYLE18">旅行線路：</span>
                                <span name="route"></span>
                            </td>
                            <td></td>
                       </tr>
                       <tr><td style="text-align:left"><span class="STYLE23 STYLE18">旅行日期：</span><span class="STYLE22"><span class="STYLE148">
                             <span name="tourTime"></span></span> 
                           </span></td><td></td></tr>
                        <tr><td style="text-align:left"><span class="STYLE23 STYLE18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</span> 
                        <span class="STYLE148" name="email"></span></td><td></td></tr>  
                        <tr> <td style="text-align:left" class="STYLE23 STYLE18" colspan=2>回&nbsp;&nbsp;憶&nbsp;&nbsp;人：
                            <span class="STYLE18"><span name="signature"></span>&nbsp;来&nbsp;自&nbsp;
                            <span name="area"></span>
                            </span></td> </tr>
                        <tr>
                            <td style="text-align:left" colspan=2><span class="STYLE23 STYLE18">内容：</span><div id="content"></div></td>
                       </tr>
                         <tr>
                            <td style="text-align:left" ><div class="fitem">
                        <label>审核状态</label>
                        <select name="status" class="easyui-combobox" data-options="editable:false">
                           <option value="1">待审核</option>
                           <option value="2">审核通过</option>
                           <option value="3">审核未通过</option>
                        </select>
                    </div></td></tr>
                    <tr><td colspan=3 style="text-align:left"><div class="fitem" style="text-align:left;">
                        <label>审核意见</label>
                        <textarea rows="5" cols="90" name="result" maxlength="500" class="easyui-textbox" data-options="multiline:true,width:1050,height:150" missingMessage="请填写result"></textarea>
                    </div></td><td></td></tr>
                    </table>
                     <div id="unDealedDiarysbtn" class="dialog-button" >  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok" id="btn-diary-submit">确定</a>  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" id="btn-diary-close">关闭</a>  
                     </div>
                     </form>   
                </div>
               <div id="unCheckedMsgsWin" buttons="#unCheckedMsgsbtn" class="easyui-dialog" title="留言审核" data-options="collapsible:false,minimizable:false,maximizable:false,shadow:true,closed:true,iconCls:'icon-edit',modal:true,width:650,height:450">
                    <form method="post">
                     <input type="hidden" name="id">
                     <table  border="0" cellpadding="0" cellspacing="1">
                          <tr>
                            <td class="STYLE140">*姓名：</td>
                            <td class="STYLE126" style="padding-left:20px;text-align:left;height:22"><span name="name"></span>
                            </td>
                          </tr>
                           <tr>
                            <td class="STYLE140">性别：</td>
                            <td class="STYLE126" style="padding-left:20px;text-align:left;height:22"><span name="sex"></span>
                            </td>
                          </tr>
                          <tr>
                            <td  class="STYLE140">*电邮:</td>
                            <td class="STYLE126" style="padding-left:20px;text-align:left"><span name="email"></span></td>
                          </tr>
                          <tr>
                            <td class="STYLE140">电话:</td>
                            <td class="STYLE126" style="padding-left:20px;text-align:left"><span name="mobile"></span></td>
                          </tr>
                          <tr>
                            <td class="STYLE140">内容:</td>
                            <td class="STYLE140" style="padding-left:20px;text-align:left">
                               <div name="content"></div>
                            </td>
                          </tr>
                          <tr><td class="STYLE140" style="padding-left:20px;text-align:left"><div class="fitem">
                                <label>反馈状态</label>
                                <select name="status" class="easyui-combobox" data-options="editable:false">
                                   <option value="1">待审核</option>
                                   <option value="2">审核通过</option>
                                   <option value="3">审核未通过</option>
                                </select>
                            </div></td></tr>
                        <tr>
                           <td class="STYLE140" style="padding-left:20px;text-align:left" colspan=2><div class="fitem">
                                <label>审核意见</label>
                                <textarea rows="5" cols="30" name="result" maxlength="500" class="easyui-textbox"  data-options="multiline:true,width:300,height:150"  missingMessage="请填写result"></textarea>
                            </div> </td>
                          </tr>
                      </table>
                     <div id="unCheckedMsgsbtn" class="dialog-button" >  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-ok" id="btn-checkmsg-submit">确定</a>  
                        <a href="javascript:void(0)" class="easyui-linkbutton" icon="icon-cancel" id="btn-checkmsg-close">关闭</a>  
                     </div>
                     </form>
                </div>
            </div>
        </div>  
    </div>
	<!--  modify password start -->
	<div id="modify-pwd-win"  class="easyui-dialog" buttons="#editPwdbtn" title="修改用户密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:350px;height:200px;display:none;">
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
	              <input id="rpwd" name="rpwd" type="password" class="easyui-textbox"  data-options="required:true" required="required" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	 </form>
     	 <div id="editPwdbtn" class="dialog-button" >  
            <a href="javascript:void(0)" class="easyui-linkbutton"  icon="icon-ok" id="btn-pwd-submit">确定</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton"  icon="icon-cancel" id="btn-pwd-close">关闭</a>  
         </div>
	</div>
	<!-- modify password end  -->
  </body>
</html>
