<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<title>${rt.title }</title>
</head>
<body>
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
</table>
<form name="calculatespendForm" action="travelOrder/toQuote4" method="post">
<%-- <input type="hidden" name="rtid" value="${rtid }"/> --%>
<input type="hidden" name="id" value="${qf.id }">
<input type="hidden" name="rtid" value="${bean.id }">
<input type="hidden" name="torderid" value="${torder.id } ">
<table width="90%" border="1" align="center" cellpadding="8" cellspacing="2">
    <tr>
    <td style="width:15%" bgcolor="#f0f0f0">&nbsp;</td>
    <td style="width:30%">&nbsp;</td>
    <td colspan="2" align="center"  style="width:10%">成本</td>
    <td colspan="2" style="width:15%">分项加价<br />
      <span class="STYLE148">加总价 分项加价 </span></td>
    <td style="width:30%"><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td width="78" bgcolor="#f0f0f0"><div align="right"><strong>项目：</strong></div></td>
    <td width="639"><strong>成本及计算</strong></td>
    <td width="39">大人</td>
    <td width="56">小孩</td>
    <td width="39"></td>
    <td width="56"></td>
    <td width="664"><div align="center" class="STYLE10"><strong>说明</strong></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>人数： </strong></div></td>
    <td><label><input name="adultsprice" type="hidden" value="${qf.adults }"/><input name="childrenprice" type="hidden" value="${qf.children }"/>
      大人：${od.adults}人 小孩：${od.children}人（按小孩价格核算）</label></td>
    <td style="width:150px"></td>
    <td style="width:150px"></td>
    <td>${calvo.quoteadults}<input name="quoteadults" type="hidden" value="${calvo.quoteadults}"/></td>
    <td>${calvo.quotechildren}<input name="quotechildren" type="hidden" value="${calvo.quotechildren}"/></td>
    <td><span class="STYLE10">。按前面 一页填写的数据 <br />
      。分项报价的内容</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td>${fn:split(qf.showTicket,'|')[1]}</td>
    <td>${fn:split(qf.showTicket,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quoteticketadults}<input name="quoteticketadults" type="hidden" value="${calvo.quoteticketadults}"/></td>
    <td>${calvo.quoteticketchildren}<input name="quoteticketchildren" type="hidden" value="${calvo.quoteticketchildren}"/></td>
    <td><span class="STYLE10">小孩 未勾选，则成本 为0 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件：</strong></div></td>
    <td>${fn:split(qf.showTraveldoc,'|')[1]}</td>
    <td>${fn:split(qf.showTraveldoc,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quotetraveldocadults}<input name="quotetraveldocadults" type="hidden" value="${calvo.quotetraveldocadults}"/></td>
    <td>${calvo.quotetraveldocchildren}<input name="quotetraveldocchildren" type="hidden" value="${calvo.quotetraveldocchildren}"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td>${fn:split(qf.showTourguide,'|')[1]}</td>
    <td>${fn:split(qf.showTourguide,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quotetourguideadults}<input name="quotetourguideadults" type="hidden" value="${calvo.quotetourguideadults}"/></td>
    <td>${calvo.quotetourguidechildren}<input name="quotetourguidechildren" type="hidden" value="${calvo.quotetourguidechildren}"/></td>
    <td><span class="STYLE10">小孩未勾选，则把些项目平摊到大人</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br /></strong></div></td>
    <td>${fn:split(qf.showHotel,'|')[1]}</td>
    <td>${fn:split(qf.showHotel,'|')[0]}</td>
    <td>220</td>
    <td>${calvo.quoteshowHoteladults}<input name="quoteshowHoteladults" type="hidden" value="${calvo.quoteshowHoteladults}"/></td>
    <td>${calvo.quoteshowHotelchildren}<input name="quoteshowHotelchildren" type="hidden" value="${calvo.quoteshowHotelchildren}"/></td>
    <td><span class="STYLE10">1间房按2人算<br />小孩勾选了，所以有小孩 的成本 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用车：<br /></strong></div></td>
    <td>${fn:split(qf.showRentcar,'|')[1]}</td>
    <td>${fn:split(qf.showRentcar,'|')[0]}</td>
    <td>1000</td>
    <td>${calvo.quoterentcaradults}<input name="quoterentcaradults" type="hidden" value="${calvo.quoterentcaradults}"/></td>
    <td>${calvo.quoterentcarchildren}<input name="quoterentcarchildren" type="hidden" value="${calvo.quoterentcarchildren}"/></td>
    <td><span class="STYLE10">小孩勾选了，所以车价除以大人和小孩 的和<br /></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br /></strong></div></td>
    <td>${fn:split(qf.showBigtraffic,'|')[1]}</td>
    <td>${fn:split(qf.showBigtraffic,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quotebigtrafficadults}<input name="quotebigtrafficadults" type="hidden" value="${calvo.quotebigtrafficadults}"/></td>
    <td>${calvo.quotebigtrafficchildren}<input name="quotebigtrafficchildren" type="hidden" value="${calvo.quotebigtrafficchildren}"/></td> 
    <td><span class="STYLE10">没填写则没有</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用餐：<br /> <br /></strong></div></td>
    <td>${fn:split(qf.showDinner,'|')[1]}</td>
    <td>${fn:split(qf.showDinner,'|')[0]}</td>
    <td>500</td>
    <td>${calvo.quotedinneradults}<input name="quotedinneradults" type="hidden" value="${calvo.quotedinneradults}"/></td>
    <td>${calvo.quotedinnerchildren}<input name="quotedinnerchildren" type="hidden" value="${calvo.quotedinnerchildren}"/></td> 
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
    <td>${calvo.quoteinsuranceadults}<input name="quoteinsuranceadults" type="hidden" value="${calvo.quoteinsuranceadults}"/></td>
    <td>${calvo.quoteinsurancechildren}<input name="quoteinsurancechildren" type="hidden" value="${calvo.quoteinsurancechildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>综费：</strong></div></td>
    <td>${fn:split(qf.showComphcost,'|')[0]}</td>
    <td>${fn:split(qf.showComphcost,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quotecomphcostadults}<input name="quotecomphcostadults" type="hidden" value="${calvo.quotecomphcostadults}"/></td>
    <td>${calvo.quotecomphcostchildren}<input name="quotecomphcostchildren" type="hidden" value="${calvo.quotecomphcostchildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td>${fn:split(qf.showRecreation,'|')[1]}</td>
    <td>${fn:split(qf.showRecreation,'|')[0]}</td>
    <td>10</td>
    <td>${calvo.quoterecreationadults}<input name="quoterecreationadults" type="hidden" value="${calvo.quoterecreationadults}"/></td>
    <td>${calvo.quoterecreationchildren}<input name="quoterecreationchildren" type="hidden" value="${calvo.quoterecreationchildren}"/></td> 
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
    <td>${calvo.quoteitemguidecadults}<input name="quoteitemguidecadults" type="hidden" value="${calvo.quoteitemguidecadults}"/></td>
    <td>${calvo.quoteitemguidechildren}<input name="quoteitemguidechildren" type="hidden" value="${calvo.quoteitemguidechildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费：</strong></div></td>
    <td>${fn:split(qf.showBathorse,'|')[1]}</td>
    <td>${fn:split(qf.showBathorse,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quotebathorseadults}<input name="quotebathorseadults" type="hidden" value="${calvo.quotebathorseadults}"/></td>
    <td>${calvo.quotebathorsecchildren}<input name="quotebathorsecchildren" type="hidden" value="${calvo.quotebathorsecchildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费：</strong></div></td>
    <td>${fn:split(qf.showRidehorse,'|')[1]}</td>
    <td>${fn:split(qf.showRidehorse,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quoteridehorseadults}<input name="quoteridehorseadults" type="hidden" value="${calvo.quoteridehorseadults}"/></td>
    <td>${calvo.quoteridehorsechildren}<input name="quoteridehorsechildren" type="hidden" value="${calvo.quoteridehorsechildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费：</strong></div></td>
    <td>${fn:split(qf.showClimbregister,'|')[1]}</td>
    <td>${fn:split(qf.showClimbregister,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quoteclimbregisteradults}<input name="quoteclimbregisteradults" type="hidden" value="${calvo.quoteclimbregisteradults}"/></td>
    <td>${calvo.quoteclimbregisterchildren}<input name="quoteclimbregisterchildren" type="hidden" value="${calvo.quoteclimbregisterchildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
    <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山联络官： </strong></div></td>
    <td>${fn:split(qf.showClimbnexus,'|')[1]}</td>
    <td>${fn:split(qf.showClimbnexus,'|')[0]}</td>
    <td>0</td>
     <td>${calvo.quoteclimbnexusadults}<input name="quoteclimbnexusadults" type="hidden" value="${calvo.quoteclimbnexusadults}"/></td>
    <td>${calvo.quoteclimbnexuschildren}<input name="quoteclimbnexuschildren" type="hidden" value="${calvo.quoteclimbnexuschildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它： </strong></div></td>
    <td>${fn:split(qf.showElsecost,'|')[1]}</td>
    <td>${fn:split(qf.showElsecost,'|')[0]}</td>
    <td>0</td>
    <td>${calvo.quoteelsecostadults}<input name="quoteelsecostadults" type="hidden" value="${calvo.quoteelsecostadults}"/></td>
    <td>${calvo.quoteelseecostchildren}<input name="quoteelseecostchildren" type="hidden" value="${calvo.quoteelseecostchildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
<tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>合计：</strong></div></td>
    <td>&nbsp;</td>
    <td>${adultsumcost }<input name="adultsumcost" type="hidden" value="${calvo.adultsumcost}"/></td>
    <td>${childrensumcost }<input name="childrensumcost" type="hidden" value="${calvo.childrensumcost}"/></td>
    <td>${calvo.plusSumPrice}<input name="plusSumPrice" type="hidden" value="${calvo.plusSumPrice}"/></td>
    <td>${calvo.plusDevicePrice}<input name="plusDevicePrice" type="hidden" value="${calvo.plusDevicePrice}"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
 <!--  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><span class="STYLE10"></span></td>
  </tr> -->
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>报价：</strong></div></td>
    <td colspan=6  style="text-align:left;float:left">大人：<span name="adultsperguy">${calvo.plusSumPrice+adultsumcost }</span>元/人*${od.adults }人<br />
      小孩：<span name="childsperguy">${calvo.plusDevicePrice+childrensumcost }</span>元/人*${od.children }人（小孩不含门票） 注：小孩未勾引选门票栏。 </td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"></td>
    <td>
      <table border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td>
			<a style="padding-left:10px;padding-right:10px;" href="travelOrder/returntoQuote2/${torder.id}/${bean.id }" class="easyui-linkbutton" iconcls="icon-back" >返回上页修改</a>
		   </td>
          <td><input  style="padding-left:10px;padding-right:10px;margin-left:20px;" type="submit" class="easyui-linkbutton" name="Submit22" value="预览一下" /></td>
          <td><span class="STYLE149">
            <input name="isShowDetail"  value="true" type="checkbox" />
          </span><span class="STYLE148">报价单中显示明细帐目</span></td>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <!-- <td><span class="STYLE10">两种核算价格的方式，出来两个不同的页面</span></td> -->
  </tr>
  <tr>
    <td   bgcolor="#f0f0f0"></td>
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
 
<script type="text/javascript" src="${basePath}js/ux/sys/quote_step3.js"></script>
</body>
</html>
