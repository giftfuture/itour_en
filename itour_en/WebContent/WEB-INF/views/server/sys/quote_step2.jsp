<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
<meta http-equiv="description" content="${rt.title }"> 
<title>${rt.title}</title>
</head>
<body>
<form:form method="post" id="back_form" action="${basePath }travelOrder/list">
<a style="padding-left:20px;margin-left:20px;" onsubmit="" onclick="document:back_form.submit();" class="easyui-linkbutton" iconcls="icon-back" >返回</a>
</form:form>
<table border="0" align="center" width="1140" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif">
    <table width="1140" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="685"><table width="1053" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="32"><img src="images/man.gif" width="32" height="32" /></td>
            <td width="1021"><span class="STYLE148"><span class="STYLE24">来自：</span>${bean.city }${bean.district } ${bean.customerName}  <span class="STYLE24">团号：</span>${qf.groupCode }  <span class="STYLE14">出团日期：</span>${qf.groupDate }<span class="STYLE14">人数：</span>${qf.adults }大${qf.children }小 </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
<table width="1140" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
    <td class="h1-black">${rt.title}<span class="STYLE27"></span></td>
  </tr>
   <tr>
    <td><span class="STYLE126 STYLE3">${torder.orderName } </span></td>
  </tr>  
   <tr>
     <td width="761" valign="top" class="STYLE126"><span class="STYLE3">简要行程</span></td>
   </tr>
</table>
 
<table width="1140" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif">${qf.showTrip }</td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
<br />
<form name="calculatespendForm" action="travelOrder/toQuote3" method="post">
<input type="hidden" name="id" value="${qf.id }">
<input type="hidden" name="rtid" value="${bean.id }">
<input type="hidden" name="torderid" value="${torder.id } ">
<table width="90%" border="1" align="center" cellpadding="8" cellspacing="2">
  <tr>
    <td style="width:10%" bgcolor="#f0f0f0">&nbsp;</td>
    <td style="width:35%">&nbsp;</td>
    <td colspan="2" align="center"  style="width:10%">成本</td>
    <td colspan="2" style="width:15%">分项加价<br />
      <span class="STYLE148">加总价 分项加价 </span></td>
    <td style="width:30%"><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td style="width:200px" bgcolor="#f0f0f0"><div align="right"><strong>项目：</strong></div></td>
    <td width="639"><strong>成本及计算</strong></td>
    <td width="39">成本(大人)</td>
    <td width="56">成本(小孩)</td>
    <td width="39">加总价</td>
    <td width="56">分项加价</td>
    <td width="664"><div align="center" class="STYLE10"><strong>说明</strong></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>人数： </strong></div></td>
    <td><label><input name="adultsprice" type="hidden" value="${qf.adults }"/><input name="childrenprice" type="hidden" value="${qf.children }"/>
      大人：${od.adults }位 小孩：${od.children }位（按小孩价格核算）</label></td>
     <td></td><td></td>
    <!-- td style="width:150px"><input size="6" name="adults"  class="easyui-numberbox" data-options="min:0,max:100,validType:'number',precision:0,groupSeparator:',',height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>位</td>
    <td style="width:150px"><input size="6" name="children" class="easyui-numberbox" data-options="min:0,max:100,validType:'number',precision:0,groupSeparator:',',height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>位</td> -->
    <td><input size="6" id="quoteadults" name="quoteadults" value="${calvo.quoteadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotechildren" name="quotechildren" value="${calvo.quotechildren }"   class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">。按前面 一页填写的数据 <br />
      。分项报价的内容</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td>${fn:split(qf.showTicket,'|')[1]}</td>
    <td>${fn:split(qf.showTicket,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteticketadults" name="quoteticketadults" value="${calvo.quoteticketadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteticketchildren" name="quoteticketchildren" value="${calvo.quoteticketchildren }"   class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩 未勾选，则成本 为0 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件：</strong></div></td>
    <td>${fn:split(qf.showTraveldoc,'|')[1]}</td>
    <td>${fn:split(qf.showTraveldoc,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quotetraveldocadults"  name="quotetraveldocadults" value="${calvo.quotetraveldocadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotetraveldocchildren" name="quotetraveldocchildren" value="${calvo.quotetraveldocchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td>${fn:split(qf.showTourguide,'|')[1]}</td>
    <td>${fn:split(qf.showTourguide,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quotetourguideadults" name="quotetourguideadults" value="${calvo.quotetourguideadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)""/></td>
    <td><input size="6" id="quotetourguidechildren" name="quotetourguidechildren" value="${calvo.quotetourguidechildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩未勾选，则把些项目平摊到大人</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br /></strong></div></td>
    <td>${fn:split(qf.showHotel,'|')[1]}</td>
    <td>${fn:split(qf.showHotel,'|')[0]}</td>
    <td>220</td>
    <td><input size="6" id="quoteshowHoteladults" name="quoteshowHoteladults" value="${calvo.quoteshowHoteladults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteshowHotelchildren" name="quoteshowHotelchildren" value="${calvo.quoteshowHotelchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">1间房按2人算<br />小孩勾选了，所以有小孩 的成本 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用车：<br /></strong></div></td>
    <td>${fn:split(qf.showRentcar,'|')[1]}</td>
    <td>${fn:split(qf.showRentcar,'|')[0]}</td>
    <td>1000</td>
    <td><input size="6" id="quoterentcaradults" name="quoterentcaradults" value="${calvo.quoterentcaradults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoterentcarchildren" name="quoterentcarchildren" value="${calvo.quoterentcarchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩勾选了，所以车价除以大人和小孩 的和<br /></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br /></strong></div></td>
    <td>${fn:split(qf.showBigtraffic,'|')[1]}</td>
    <td>${fn:split(qf.showBigtraffic,'|')[0]}</td>
    <td>&nbsp;</td>
    <td><input size="6" id="quotebigtrafficadults" name="quotebigtrafficadults" value="${calvo.quotebigtrafficadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotebigtrafficchildren" name="quotebigtrafficchildren" value="${calvo.quotebigtrafficchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">没填写则没有</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用餐：<br /> <br /></strong></div></td>
    <td>${fn:split(qf.showDinner,'|')[1]}</td>
    <td>${fn:split(qf.showDinner,'|')[0]}</td>
    <td>500</td>
    <td><input size="6" id="quotedinneradults" name="quotedinneradults" value="${calvo.quotedinneradults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotedinnerchildren"  name="quotedinnerchildren" value="${calvo.quotedinnerchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">按填写和勾选的来<br />
      早餐默认酒店用<br />
      午餐和晚上按上面是11餐，其中2餐特色餐<br />
      填写了40元餐标，则为<br />
      （11餐-2餐特色）*40元+60+80=500<br />
      小孩 勾选了</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>保险：</strong></div></td>
    <td>${fn:split(qf.showInsurance,'|')[1]}</td>
    <td>${fn:split(qf.showInsurance,'|')[0]}</td>
    <td>10</td>
    <td><input size="6" id="quoteinsuranceadults" name="quoteinsuranceadults" value="${calvo.quoteinsuranceadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteinsurancechildren" name="quoteinsurancechildren" value="${calvo.quoteinsurancechildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>综费：</strong></div></td>
    <td>${fn:split(qf.showComphcost,'|')[1]}</td>
    <td>${fn:split(qf.showComphcost,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quotecomphcostadults" name="quotecomphcostadults" value="${calvo.quotecomphcostadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotecomphcostchildren" name="quotecomphcostchildren" value="${calvo.quotecomphcostchildren }"   class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td>${fn:split(qf.showRecreation,'|')[1]}</td>
    <td>${fn:split(qf.showRecreation,'|')[0]}</td>
    <td>10</td>
    <td><input size="6" id="quoterecreationadults" name="quoterecreationadults" value="${calvo.quoterecreationadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoterecreationchildren" name="quoterecreationchildren" value="${calvo.quoterecreationchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="7"><div align="center"></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>向导：</strong></div></td>
    <td>${fn:split(qf.showItemguide,'|')[1]}</td>
    <td>${fn:split(qf.showItemguide,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteitemguidecadults" name="quoteitemguidecadults" value="${calvo.quoteitemguidecadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteitemguidechildren" name="quoteitemguidechildren" value="${calvo.quoteitemguidechildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费：</strong></div></td>
    <td>${fn:split(qf.showBathorse,'|')[1]}</td>
    <td>${fn:split(qf.showBathorse,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quotebathorseadults" name="quotebathorseadults" value="${calvo.quotebathorseadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quotebathorsecchildren" name="quotebathorsecchildren" value="${calvo.quotebathorsecchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费：</strong></div></td>
    <td>${fn:split(qf.showRidehorse,'|')[1]}</td>
    <td>${fn:split(qf.showRidehorse,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteridehorseadults" name="quoteridehorseadults"  value="${calvo.quoteridehorseadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteridehorsechildren" name="quoteridehorsechildren" value="${calvo.quoteridehorsechildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费：</strong></div></td>
    <td>${fn:split(qf.showClimbregister,'|')[1]}</td>
    <td>${fn:split(qf.showClimbregister,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteclimbregisteradults" name="quoteclimbregisteradults" value="${calvo.quoteclimbregisteradults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteclimbregisterchildren" name="quoteclimbregisterchildren" value="${calvo.quoteclimbregisterchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
    <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山联络官：</strong></div></td>
    <td>${fn:split(qf.showClimbnexus,'|')[1]}</td>
    <td>${fn:split(qf.showClimbnexus,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteclimbnexusadults"  name="quoteclimbnexusadults" value="${calvo.quoteclimbnexusadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteclimbnexuschildren" name="quoteclimbnexuschildren" value="${calvo.quoteclimbnexuschildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它 ：</strong></div></td>
    <td>${fn:split(qf.showElsecost,'|')[1]}</td>
    <td>${fn:split(qf.showElsecost,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" id="quoteelsecostadults" name="quoteelsecostadults"  value="${calvo.quoteelsecostadults }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" id="quoteelseecostchildren" name="quoteelseecostchildren" value="${calvo.quoteelseecostchildren }"  class="easyui-numberbox" data-options="min:0,validType:'number',precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
<!--   <tr>
    <td><div align="right"></div></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><span class="STYLE10"></span></td>
  </tr> -->
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>核算价格：</strong></div></td>
    <td colspan=3>
	<input style="float:left" type="submit" name="calculateSum"  style="padding-left:10px;padding-right:10px;margin-left:20px;" class="easyui-linkbutton" value="算算呗" data-options="width:100px">
	<!-- <a name="reviewcalculate"  class="easyui-linkbutton">预览一下</a> -->
	<!-- <a name="generateQuote"  class="easyui-linkbutton">生成正式报价单</a></td> -->
  <%--       <tr>
          <td>链接1</td>
          <td><a href="${basePath}travelOrder/toQuote3">链接2</a></td>
        </tr> --%>
    <td> </td>
    <td> </td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"></div></td>
    <td>**线路在外面售卖的价格可能通过这套系统来评估<br />
      **可选儿童不占床，不含门票，不含车费。 </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><span class="STYLE10"></span></td>
  </tr>
<!--   <tr>
    <td colspan="7"><p><a href="#" class="STYLE136">算价管理（门票在景点内管理）</a></p>    </td>
  </tr> -->
</table>
</form>
<script type="text/javascript" src="${basePath}js/ux/sys/quote_step2.js"></script>
</body>
</html>
