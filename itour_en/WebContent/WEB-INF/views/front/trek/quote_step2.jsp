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
<%@include file="/front/header.jsp"  %>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="100%" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif">
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
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
<table width="100%" border="0" align="center" cellpadding="10" cellspacing="0">
  <tr>
    <td class="h1-black">${rt.title}<span class="STYLE27"></span></td>
  </tr>
</table>
<br />
<br />
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif"><table width="1100" border="0" align="center" cellpadding="10" cellspacing="0">
        <tr>
          <td width="761" valign="top" class="STYLE126"><span class="STYLE3">简要行程</span><span class="STYLE2">：</span></td>
        </tr>
      </table>
       ${qf.showTrip }
</td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>
</table>
<br />
<form name="calculatespendForm" action="">
<input type="hidden" name="id" value="${qf.id }">
<table width="100%" border="1" align="center" cellpadding="8" cellspacing="2">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2" align="center"  style="width:200px">成本</td>
    <td colspan="2" style="width:200px">分项加价<br />
      <span class="STYLE148">加总价 分项加价 </span></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td width="78"><strong>项目</strong></td>
    <td width="639"><strong>成本及计算</strong></td>
    <td width="39">人数(大人)</td>
    <td width="56">人数(小孩)</td>
    <td width="39">报价(大人)</td>
    <td width="56">报价(小孩)</td>
    <td width="664"><div align="center" class="STYLE10"><strong>说明</strong></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>人数： </strong></div></td>
    <td><label><input name="adultsprice" type="hidden" value="${qf.adults }"/><input name="childrenprice" type="hidden" value="${qf.children }"/>
      大人：${qf.adults }元/人 小孩：${qf.children }元/人（按小孩价格核算）</label></td>
    <td style="width:150px"><input size="6" type="text" name="adults"  class="easyui-numberbox" data-options="min:0,max:100,validType:'number',precision:0,groupSeparator:',',height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>位</td>
    <td style="width:150px"><input size="6" type="text" name="children" class="easyui-numberbox" data-options="min:0,max:100,validType:'number',precision:0,groupSeparator:',',height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>位</td>
    <td><input size="6" type="text" id="quoteadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quotechildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">。按前面 一页填写的数据 <br />
      。分项报价的内容</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td>${fn:split(qf.showTicket,'|')[1]}</td>
    <td>${fn:split(qf.showTicket,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" type="text" id="quoteticketadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoteticketchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩 未勾选，则成本 为0 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件</strong></div></td>
    <td>${fn:split(qf.showTraveldoc,'|')[1]}</td>
    <td>${fn:split(qf.showTraveldoc,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" type="text" id="quotetraveldocadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quotetraveldocchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td>${fn:split(qf.showTourguide,'|')[1]}</td>
    <td>${fn:split(qf.showTourguide,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" type="text" id="quotetourguideadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)""/></td>
    <td><input size="6" type="text" id="quotetourguidechildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩未勾选，则把些项目平摊到大人</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br /></strong></div></td>
    <td>${fn:split(qf.showHotel,'|')[1]}</td>
    <td>${fn:split(qf.showHotel,'|')[0]}</td>
    <td>220</td>
    <td><input size="6" type="text" id="quoteshowHoteladults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoteshowHotelchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">1间房按2人算<br />小孩勾选了，所以有小孩 的成本 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用车：<br /></strong></div></td>
    <td>${fn:split(qf.showRentcar,'|')[1]}</td>
    <td>${fn:split(qf.showRentcar,'|')[0]}</td>
    <td>1000</td>
    <td><input size="6" type="text" id="quoterentcaradults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoterentcarchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">小孩勾选了，所以车价除以大人和小孩 的和<br /></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br /></strong></div></td>
    <td>${fn:split(qf.showBigtraffic,'|')[1]}</td>
    <td>${fn:split(qf.showBigtraffic,'|')[0]}</td>
    <td>&nbsp;</td>
    <td><input size="6" type="text" id="quotebigtrafficadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quotebigtrafficchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10">没填写则没有</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用餐：<br /> <br /></strong></div></td>
    <td>${fn:split(qf.showDinner,'|')[1]}</td>
    <td>${fn:split(qf.showDinner,'|')[0]}</td>
    <td>500</td>
    <td><input size="6" type="text" id="quotedinneradults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quotedinnerchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
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
    <td><input size="6" type="text" id="quoteinsuranceadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoteinsurancechildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>综费</strong>：</div></td>
    <td>${fn:split(qf.showComphcost,'|')[1]}</td>
    <td>${fn:split(qf.showComphcost,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" type="text" id="quotecomphcostadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quotecomphcostchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td>${fn:split(qf.showRecreation,'|')[1]}</td>
    <td>${fn:split(qf.showRecreation,'|')[0]}</td>
    <td>10</td>
    <td><input size="6" type="text" id="quoterecreationadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoterecreationchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它 </strong></div></td>
    <td>${fn:split(qf.showElsecost,'|')[1]}</td>
    <td>${fn:split(qf.showElsecost,'|')[0]}</td>
    <td>0</td>
    <td><input size="6" type="text" id="quoteelsecostadults"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><input size="6" type="text" id="quoteelseecostchildren"  class="easyui-numberbox" data-options="min:0,validType:'number',editable:false,precision:2,groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" size="6" min="0" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="7"><div align="center"></div></td>
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
    <td><div align="right">核算价格：</div></td>
    <td colspan=3><input type="button" onclick="javascript:go(-1)" name="Submit2" value="返回上页修改" />
	<input type="button" name="calculateSum" value="算算呗 " />
	<input type="button" name="reviewcalculate" value="预览一下" />
	<input type="button" name="generateQuote" value="生成正式报价单"></td>
  <%--       <tr>
          <td>链接1</td>
          <td><a href="${basePath}hiking/toQuote3">链接2</a></td>
        </tr> --%>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td><div align="right"></div></td>
    <td>**线路在外面售卖的价格可能通过这套系统来评估<br />
      **可选儿童不占床，不含门票，不含车费。 </td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="7"><p><a href="#" class="STYLE136">算价管理（门票在景点内管理）</a></p>    </td>
  </tr>
</table>
</form>
<script type="text/javascript" src="${basePath}js/ux/front/trek/quote_step2.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
