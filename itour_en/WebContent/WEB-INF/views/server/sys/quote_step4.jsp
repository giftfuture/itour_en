<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${basePath}css/easyzoom/pygments.css" />
<link rel="stylesheet" href="${basePath}css/easyzoom/easyzoom.css" />  
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<link rel="stylesheet" type="text/css" href="${basePath}css/ScrollPic.css">
<script type="text/javascript" src="${basePath}js/commons/ScrollPic.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easyzoom.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easytab/jquery.easytabs.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easytab/jquery.hashchange.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/zeroclip/ZeroClipboard.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/zeroclip/ZeroClipboard.swf"></script>
<script type="text/javascript" src="${basePath}js/plug-in/pdf/html2canvas.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/pdf/jspdf.min.js"></script>
<title>${bean.title }</title>
</head>
<body>
<form:form method="post" id="back_form" name="back_form" action="${basePath }travelOrder/list">
</form:form>
<center>
<form name="calculatespendForm" action="travelOrder/generateReport" method="post">
<div id="reportdiv">
<table border="0" align="center" width="1140" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="${basePath}images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif">
    <table width="1140" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="685"><table width="1053" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="32"><img src="${basePath}images/man.gif" width="32" height="32" /></td>
            <td width="1021" style="color: #990000;"><span class="STYLE148"><span class="STYLE14">来自：</span>${bean.city }${bean.district } ${bean.customerName} <span class="STYLE14"> 团号：</span>${qf.groupCode }  <span class="STYLE14">出团日期：</span>${qf.groupDate }<span class="STYLE14">人数：</span>${qf.adults }大${qf.children }小 </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img src="${basePath}images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
<table width="1140" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
    <td class="h1-black">${rt.title}<span class="STYLE27"></span></td>
  </tr>
   <tr>
    <td><span class="STYLE126 STYLE3" style="font-size: 16px;font-weight: bold;font-family: Arial, Helvetica, sans-serif;color: #990000;">${torder.orderName } </span><input type="hidden" name="tordername" value="${torder.orderName }"/><input type="hidden" name="idrt" value="${rtid}"/></td>
  </tr>  
</table>
<table  style="width:1350px;text-align:center;align:center;font-family: '微软雅黑';border:0;"  align="center">
 <!--  <tr>
    <td style="float:left" class="h1-black" style="color: #990000;" ></td>
  </tr> -->
  <tr>
    <td>
    <table>
      <tr>		
        <td ><img src="${basePath}${bean.cover}" style="border:none;" border="0px" height="900" width="900"/></td>
      </tr>
      <tr>
        <td height="69">
            <div align="center">
<!--滚动图片 start-->
<DIV class="rollphotos" style="width:908">
<DIV class="blk_29" style="width:908">
<DIV class=LeftBotton id=LeftArr><img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
<DIV class="Cont" id=ISL_Cont_1><!-- 图片列表 begin -->
<c:forEach items="${bean.photoList}" var="photo">
<div class=box><a class="imgBorder" target="_blank">
<img height=84 alt="landscape" src="${basePath }${photo}" width="124" border="0" /></a> 
</div>
</c:forEach>
<!-- 图片列表 end --></DIV>
<div class=RightBotton id=RightArr><img src="${basePath}images/arrow01-2.gif" width="20" height="40" /></div></div>
<script  type="text/javascript">
		<!--//--><![CDATA[//><!--
		var scrollPic_02 = new ScrollPic();
		scrollPic_02.scrollContId   = "ISL_Cont_1"; //内容容器ID
		scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
		scrollPic_02.arrRightId     = "RightArr"; //右箭头ID
		scrollPic_02.frameWidth     = 908;//显示框宽度
		scrollPic_02.pageWidth      = 152; //翻页宽度
		scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
		scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
		scrollPic_02.autoPlay       = false; //自动播放
		scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)
		scrollPic_02.initialize(); //初始化
		//--><!]]>
</script>
</div>
<!--滚动图片 end-->
</div>
     </td></tr></table></td>
    <td style="float:left" valign="top"><div align="center"><span class="STYLE2"  style="font-family: '微软雅黑'; font-size: 24px; color: #990000; ">这条线路适合我吗？</span>
    </div>
      <table >
        <tr>
          <td class="STYLE126" style="width:130px;margin-right:10px;padding-right:10px;"><div align="right"><strong>类型</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;padding-left:10px;text-align:left" style="font-size: 14px;"><strong>${bean.travelStyle} </strong><a href="javascript:void(0)" title="${bean.travelStyle}">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td width="70" class="STYLE126" style="width:130px;margin-right:10px;padding-right:10px;"><div align="right"><strong>线路编号</strong></div></td>
          <td width="350" class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.routeCode}</td>
        </tr>
         <tr>
          <td width="70" class="STYLE126" style="width:130px;margin-right:10px;padding-right:10px;"><div align="right"><strong>线路名称</strong></div></td>
          <td width="350" class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.title}</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>旅行天数</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.rcdDays}天<strong> </strong><a href="javascript:void(0)" title="${bean.rcdDays}">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>最高海拔</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.mileage}米</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>起始地</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.departure }<a href="javascript:void(0)" title="${bean.departure}">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>完成地</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.arrive }</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>路线</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.routeLine }</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>交通方式</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.transportation }</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>徒步难度</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left">
          <c:forEach items="${bean.diffRate}" var="dr">
          	 <img src="${basePath}images/shoe-1.gif" width="16" height="16" />
          </c:forEach>
          <c:forEach items="${bean.undiffRate}" var="rd">
         	 <img src="${basePath}images/shoe-2.gif" width="16" height="16" />
          </c:forEach>
           <a href="javascript:void(0)" title="深色鞋子标识徒步难度等级">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>徒步距离 </strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.trekDistance }km</td>
        </tr>
        <tr>
          <td class="STYLE126" style="margin-right:10px;padding-right:10px;"><div align="right"><strong>山峰类型</strong></div></td>
          <td class="STYLE126" style="margin-left:10px;text-align:left" style="font-size: 14px;">${bean.mountStyle } <a href="javascript:void(0)" title="${bean.mountStyle}">Explain&gt;&gt; </a></td>
        </tr>
      </table>
      <span class="STYLE148" style="color: #990000"> 
    注：每个团的需求都不同，可根据您的假期重新调整设计行程。</span> 
    <table class="f12-gao1">
      <tr>
        <td><img src="${basePath}images/facebook.png" width="24" height="24" />
        <a target="_blank" href="https://www.facebook.com/dialog/feed">分享至FB</a></td>
        <td><img src="${basePath}images/share.png" width="24" height="24" />
        <a target="_blank" id="copyurl" href="javascript:void(0)" data-clipboard-target="flashcopier">复制链接</a><div style="display:none" id="flashcopier"></div></td>
        <td><img src="${basePath}images/favorite01.png" width="24" height="24" />
        <a target="_blank"  href="javascript:itour.serverquotestep4.addFavorite()" rel="sidebar">收藏本页</a></td>
        <td><img src="${basePath}images/print.png" width="24" height="24" />
        <a target="_blank"  href="javascript:itour.serverquotestep4.printff()">打印页面</a></td>
      </tr>
 	 <tr><td>相关路线：
      <c:forEach items="${bean.relates}" var="relat">
      <p><a href="${basePath}${bean.travelStyle }/${bean.travelStyle }/${relat.alias}" >${relat.title }</a></p>
      </c:forEach>
      </td></tr>
    </table></td>
  </tr>
</table>

<div  style="width:1350px;text-align:center;align:center;font-family: '微软雅黑';border:0;"  id="tab-container" class='tab-container' cellpadding="3" cellspacing="1">
 <ul style="text-align:left;float:left" class='etabs'>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}${bean.travelStyle}/${bean.travelStyle }/${bean.alias}#review" target="_self">整体概览</a></li>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}${bean.travelStyle }/${bean.travelStyle }/${bean.alias}#detail-route" target="_self">详细行程</a></li>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}${bean.travelStyle }/${bean.travelStyle }/${bean.alias}#need-know" target="_self">行前需知</a></li>
 </ul>
 <div class='panel-container'>
 <div id="review" name="review">
  <table class="frametb" align="center">
  <tr>
    <td width="1140" style="align:left;float:left"><img src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif" width="1140" ><table width="1140" border="0" align="center" cellpadding="10" cellspacing="0">
      <tr> 
        <td width="761" valign="top" style="text-align:left;color: #990000;font-family:'微软雅黑';font-size: 16px; font-weight: bold;" class="STYLE126" ><span class="STYLE3">设计理念：</span>
       	 <p style="color: #990000;"> ${bean.designConcept }</p>
          <span class="STYLE148" style="color: #990000;font-weight: bold;text-align: left;font-size: 14px;"><strong>主角旅行團隊定製服務：</strong> </span>
          <p style="color: #990000;">${bean.customizedService }</p>
        </td>
        <td width="299" valign="top" class="STYLE126"><div align="center"><span class="STYLE3" style="color: #990000;font-family: '微软雅黑';font-size: 24px;">行程地图</span>
   			<div class="easyzoom easyzoom--overlay"><p>
				<a href="${basePath}images/map-002.jpg">
					<img src="${basePath}images/map-002.jpg" alt="" width="640" height="360" />		
				</a></p>
			</div>
          </div>
        </td>
      </tr>
    </table>
    </td>
    </tr>
      <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-3.gif" width="1140" height="7" /></td>
  </tr> 
    </table>
  </div>
  <div id="detail-route" name="detail-route">
   <table  class="frametb" align="center">
  <tr>
    <td colspan=2><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span> 
    <span class="h2-24" style="float:middle"><span class="STYLE148" style="color: #990000;font-family: '微软雅黑';font-size: 24px;">简要日程</span></span></td>
  </tr>
   <tr>
    <td width="1140" style="align:left;float:left"><img style="align:left;float:left" src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan="2" background="${basePath}images/frame1-2.gif" style="valign:top;">${qf.showTrip }</td></tr>   
  <tr>
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-3.gif" width="1140" height="7" /></td>
  </tr> 
    <td colspan=2><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span>
    <span class="h2-24" style="float:middle"><span class="STYLE148" style="color: #990000;font-family: '微软雅黑';font-size: 24px;">详细日程</span></span></td>
  </tr>
  <tr><td colspan="2" background="${basePath}images/frame1-2.gif">${qf.agodaDetail }</td></tr>
  <tr><td colspan=2>  <div id="need-know" name="need-know">
  <table  class="frametb" align="center">
  <tr>
    <td width="32"><img src="${basePath}images/document2.png" width="32" height="32" /></td>
    <td width="1028" style="float:middle"><span class="h2-24"><span class="STYLE148" style="color: #990000;font-family: '微软雅黑';font-size: 24px;">行前需知</span></span></td>
  </tr>
   <tr>
    <td colspan=2 style="text-align:left;align:left;">${bean.beforeInstruction }</td>
  </tr>
 <!--  <tr>
    <td><img src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr> -->
</table>
</div></td></tr>
<tr><td colspan=2>
<input type="hidden" name="id" value="${qf.id }">
<input type="hidden" name="rtid" value="${bean.id }">
<input type="hidden" name="torderid" value="${torder.id } ">
</td></tr>
<tr><td>
<table width="1140" border="0" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="32"><img src="${basePath}images/heart02.png" width="32" height="32" /></td>
    <td width="1028"><span class="h2-24"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2" style="color: #990000;font-family: '微软雅黑';font-size: 24px;">服务及报价</span></span></span></span></td>
  </tr>
</table>
<table width="1140" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif">
	<table  class="commontb" align="center">
        <tr>
          <td valign="top">
          <table width="1100" border="0" align="center" cellpadding="4" cellspacing="2">
          	<c:if test="${calvo.isShowDetail=='true' }">
              <tr>
                <td width="95" bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
                <td width="529" style="text-align:left">${fn:split(qf.showTicket,'|')[1]}
                </td>
                <td width="444" style="text-align:left">${fn:split(qf.showTicket,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showTourguide,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showTourguide,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showHotel,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showHotel,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>用车：
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showRentcar,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showRentcar,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>用餐： 
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showDinner,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showDinner,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>保险：</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showInsurance,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showInsurance,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>综费：</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showComphcost,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showComphcost,'|')[0]}元/人</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showRecreation,'|')[1]} </td>
                <td style="text-align:left">${fn:split(qf.showRecreation,'|')[0]}元/人</td>
              </tr>
			</c:if>
            <tr>
              <td bgcolor="#f0f0f0"><div align="right"><strong>报价：</strong></div></td>
              <td style="text-align:left;float:left">大人：<span name="adultsperguy">${calvo.plusSumPrice+adultsumcost }</span>元/人*${od.adults }人 
                小孩：<span name="childsperguy">${calvo.plusDevicePrice+childrensumcost }</span>元/人*${od.children }人（小孩不含门票） </td>
              <td>&nbsp;</td>
            </tr>
        
          </table>          
          <p>&nbsp;</p>
          </td>
        </tr>
      </table></td>
  </tr>
  <tr>
    <td style="float:left"><img  style="float:left" src="${basePath}images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
</td></tr></table></div></div></div>
</div>
    <table><tr>
      <td><label></label>
          <table border="0" cellspacing="0" cellpadding="3">
            <tr>
              <td><a style="padding-left:10px;padding-right:10px;margin-left:20px;" href="travelOrder/returntoQuote3/${torder.id}/${bean.id }" class="easyui-linkbutton" iconcls="icon-back" >返回上页修改</a></td>
              <td><a  style="padding-left:10px;padding-right:10px;margin-left:20px;" class="easyui-linkbutton" name="modefyProject" value="改下项目描述" >改下项目描述</a></td>
              <td><input type="hidden" name="formContent"/><a style="padding-left:10px;padding-right:10px;margin-left:20px;" class="easyui-linkbutton" name="generateReport" value="生成正式报价单" >生成正式报价单</a></td>
               <td><a style="padding-left:10px;padding-right:10px;margin-left:20px;display:none" class="easyui-linkbutton" name="viewReport" value="查看报价单" >查看报价单</a></td>	
            </tr>
        </table></td>
      <td>&nbsp;</td>
    </tr></table>
</form>
<script type="text/javascript" src="${basePath}js/ux/sys/quote_step4.js"></script>
</body>
</html>

