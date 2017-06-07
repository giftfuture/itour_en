<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
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
<input type="hidden" name="adultticketTotalPrice" value="${vo.adultticketTotalPrice}" />
<input type="hidden" name="adultticketsBlock" value="${vo.adultticketsBlock}"  />
<input type="hidden" name="quotetraveldocadultsBlock"  value="${vo.quotetraveldocadultsBlock}" />
<input type="hidden" name="quotetourguideadultsBlock"  value="${vo.quotetourguideadultsBlock}" />
<input type="hidden" name="quoterentcaradultsBlock"   value="${vo.quoterentcaradultsBlock}"/>
<input type="hidden" name="quotebigtrafficadultsBlock"  value="${vo.quotebigtrafficadultsBlock}" />
<input type="hidden" name="quoteinsuranceadultsBlock"  value="${vo.quoteinsuranceadultsBlock}" />
<input type="hidden" name="quotecomphcostadultsBlock"  value="${vo.quotecomphcostadultsBlock}" />
<input type="hidden" name="quoterecreationadultsBlock"  value="${vo.quoterecreationadultsBlock}" />
<input type="hidden" name="quoteitemguidecadultsBlock"  value="${vo.quoteitemguidecadultsBlock}" />
<input type="hidden" name="quotebathorseadultsBlock"  value="${vo.quotebathorseadultsBlock}" />
<input type="hidden" name="quoteridehorseadultsBlock"  value="${vo.quoteridehorseadultsBlock}" />
<input type="hidden" name="quoteclimbregisteradultsBlock"  value="${vo.quoteclimbregisteradultsBlock}" />
<input type="hidden" name="quoteclimbnexusadultsBlock"  value="${vo.quoteclimbnexusadultsBlock}" />
<input type="hidden" name="quoteelsecostadultsBlock"  value="${vo.quoteelsecostadultsBlock}" />
<input type="hidden" name="quotetraveldocadultsSumCost"  value="${vo.quotetraveldocadultsSumCost}" />
<input type="hidden" name="quotetourguideadultsSumCost"  value="${vo.quotetourguideadultsSumCost}" />
<input type="hidden" name="quoterentcaradultsSumCost"  value="${vo.quoterentcaradultsSumCost}" />
<input type="hidden" name="quotebigtrafficadultsSumCost"  value="${vo.quotebigtrafficadultsSumCost}" />
<input type="hidden" name="quoteinsuranceadultsSumCost"  value="${vo.quoteinsuranceadultsSumCost}" />
<input type="hidden" name="quotecomphcostadultsSumCost"  value="${vo.quotecomphcostadultsSumCost}" />
<input type="hidden" name="quoterecreationadultsSumCost"  value="${vo.quoterecreationadultsSumCost}" />
<input type="hidden" name="quoteitemguidecadultsSumCost"  value="${vo.quoteitemguidecadultsSumCost}" />
<input type="hidden" name="quotebathorseadultsSumCost"  value="${vo.quotebathorseadultsSumCost}" />
<input type="hidden" name="quoteridehorseadultsSumCost"  value="${vo.quoteridehorseadultsSumCost}" />
<input type="hidden" name="quoteclimbregisteradultsSumCost"  value="${vo.quoteclimbregisteradultsSumCost}" />
<input type="hidden" name="quoteclimbnexusadultsSumCost"  value="${vo.quoteclimbnexusadultsSumCost}" />
<input type="hidden" name="quoteelsecostadultsSumCost"  value="${vo.quoteelsecostadultsSumCost}" />
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
    <td>${vo.quoteadults}<input name="quoteadults" type="hidden" value="${vo.quoteadults}"/></td>
    <td>${vo.quotechildren}<input name="quotechildren" type="hidden" value="${vo.quotechildren}"/></td>
    <td><span class="STYLE10">。按前面 一页填写的数据 <br />
      。分项报价的内容</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td style="text-align:left">${vo.adultticketsBlock}</td>
    <td>${vo.adultticketTotalPrice}</td>
    <td>0</td>
    <td>${vo.quoteticketadults}<input name="quoteticketadults" type="hidden" value="${vo.quoteticketadults}"/></td>
    <td>${vo.quoteticketchildren}<input name="quoteticketchildren" type="hidden" value="${vo.quoteticketchildren}"/></td>
    <td><span class="STYLE10">小孩 未勾选，则成本 为0 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件：</strong></div></td>
    <td style="text-align:left">${vo.quotetraveldocadultsBlock}</td>
    <td>${vo.quotetraveldocadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quotetraveldocadults}<input name="quotetraveldocadults" type="hidden" value="${vo.quotetraveldocadults}"/></td>
    <td>${vo.quotetraveldocchildren}<input name="quotetraveldocchildren" type="hidden" value="${vo.quotetraveldocchildren}"/></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td style="text-align:left">${vo.quotetourguideadultsBlock}</td>
    <td>${vo.quotetourguideadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quotetourguideadults}<input name="quotetourguideadults" type="hidden" value="${vo.quotetourguideadults}"/></td>
    <td>${vo.quotetourguidechildren}<input name="quotetourguidechildren" type="hidden" value="${vo.quotetourguidechildren}"/></td>
    <td><span class="STYLE10">小孩未勾选，则把些项目平摊到大人</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br /></strong></div></td>
    <td style="text-align:left">${fn:split(qf.showHotel,'|')[1]}</td>
    <td>${fn:split(qf.showHotel,'|')[0]}</td>
    <td>220</td>
    <td>${vo.quoteshowHoteladults}<input name="quoteshowHoteladults" type="hidden" value="${vo.quoteshowHoteladults}"/></td>
    <td>${vo.quoteshowHotelchildren}<input name="quoteshowHotelchildren" type="hidden" value="${vo.quoteshowHotelchildren}"/></td>
    <td><span class="STYLE10">1间房按2人算<br />小孩勾选了，所以有小孩 的成本 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用车：<br /></strong></div></td>
    <td style="text-align:left">${vo.quoterentcaradultsBlock}</td>
    <td>${vo.quoterentcaradultsSumCost}</td>
    <td>1000</td>
    <td>${vo.quoterentcaradults}<input name="quoterentcaradults" type="hidden" value="${vo.quoterentcaradults}"/></td>
    <td>${vo.quoterentcarchildren}<input name="quoterentcarchildren" type="hidden" value="${vo.quoterentcarchildren}"/></td>
    <td><span class="STYLE10">小孩勾选了，所以车价除以大人和小孩 的和<br /></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br /></strong></div></td>
      <td style="text-align:left">${vo.quotebigtrafficadultsBlock}</td>
    <td>${vo.quotebigtrafficadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quotebigtrafficadults}<input name="quotebigtrafficadults" type="hidden" value="${vo.quotebigtrafficadults}"/></td>
    <td>${vo.quotebigtrafficchildren}<input name="quotebigtrafficchildren" type="hidden" value="${vo.quotebigtrafficchildren}"/></td> 
    <td><span class="STYLE10">没填写则没有</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>用餐：<br /> <br /></strong></div></td>
    <td style="text-align:left">${fn:split(qf.showDinner,'|')[1]}</td>
    <td>${fn:split(qf.showDinner,'|')[0]}</td>
    <td>500</td>
    <td>${vo.quotedinneradults}<input name="quotedinneradults" type="hidden" value="${vo.quotedinneradults}"/></td>
    <td>${vo.quotedinnerchildren}<input name="quotedinnerchildren" type="hidden" value="${vo.quotedinnerchildren}"/></td> 
    <td><span class="STYLE10">按填写和勾选的来<br />
      早餐默认酒店用<br />
      午餐和晚上按上面是11餐，其中2餐特色餐<br />
      填写了40元餐标，则为<br />
      （11餐-2餐特色）*40元+60+80=500<br />
      小孩 勾选了</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>保险：</strong></div></td>
    <td style="text-align:left">${vo.quoteinsuranceadultsBlock}</td>
    <td>${vo.quoteinsuranceadultsSumCost}</td>
    <td>10</td>
    <td>${vo.quoteinsuranceadults}<input name="quoteinsuranceadults" type="hidden" value="${vo.quoteinsuranceadults}"/></td>
    <td>${vo.quoteinsurancechildren}<input name="quoteinsurancechildren" type="hidden" value="${vo.quoteinsurancechildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>综费：</strong></div></td>
    <td style="text-align:left">${vo.quotecomphcostadultsBlock}</td>
    <td>${vo.quotecomphcostadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quotecomphcostadults}<input name="quotecomphcostadults" type="hidden" value="${vo.quotecomphcostadults}"/></td>
    <td>${vo.quotecomphcostchildren}<input name="quotecomphcostchildren" type="hidden" value="${vo.quotecomphcostchildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
     <td style="text-align:left">${vo.quoterecreationadultsBlock}</td>
    <td>${vo.quoterecreationadultsSumCost}</td>
    <td>10</td>
    <td>${vo.quoterecreationadults}<input name="quoterecreationadults" type="hidden" value="${vo.quoterecreationadults}"/></td>
    <td>${vo.quoterecreationchildren}<input name="quoterecreationchildren" type="hidden" value="${vo.quoterecreationchildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="7"><div align="center"></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>向导：</strong></div></td>
    <td style="text-align:left">${vo.quoteitemguidecadultsBlock}</td>
    <td>${vo.quoteitemguidecadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quoteitemguidecadults}<input name="quoteitemguidecadults" type="hidden" value="${vo.quoteitemguidecadults}"/></td>
    <td>${vo.quoteitemguidechildren}<input name="quoteitemguidechildren" type="hidden" value="${vo.quoteitemguidechildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费：</strong></div></td>
     <td style="text-align:left">${vo.quotebathorseadultsBlock}</td>
    <td>${vo.quotebathorseadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quotebathorseadults}<input name="quotebathorseadults" type="hidden" value="${vo.quotebathorseadults}"/></td>
    <td>${vo.quotebathorsecchildren}<input name="quotebathorsecchildren" type="hidden" value="${vo.quotebathorsecchildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费：</strong></div></td>
    <td style="text-align:left">${vo.quoteridehorseadultsBlock}</td>
    <td>${vo.quoteridehorseadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quoteridehorseadults}<input name="quoteridehorseadults" type="hidden" value="${vo.quoteridehorseadults}"/></td>
    <td>${vo.quoteridehorsechildren}<input name="quoteridehorsechildren" type="hidden" value="${vo.quoteridehorsechildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费：</strong></div></td>
    <td style="text-align:left">${vo.quoteclimbregisteradultsBlock}</td>
    <td>${vo.quoteclimbregisteradultsSumCost}</td>
    <td>0</td>
    <td>${vo.quoteclimbregisteradults}<input name="quoteclimbregisteradults" type="hidden" value="${vo.quoteclimbregisteradults}"/></td>
    <td>${vo.quoteclimbregisterchildren}<input name="quoteclimbregisterchildren" type="hidden" value="${vo.quoteclimbregisterchildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
    <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山联络官： </strong></div></td>
     <td style="text-align:left">${vo.quoteclimbnexusadultsBlock}</td>
    <td>${vo.quoteclimbnexusadultsSumCost}</td>
    <td>0</td>
     <td>${vo.quoteclimbnexusadults}<input name="quoteclimbnexusadults" type="hidden" value="${vo.quoteclimbnexusadults}"/></td>
    <td>${vo.quoteclimbnexuschildren}<input name="quoteclimbnexuschildren" type="hidden" value="${vo.quoteclimbnexuschildren}"/></td> 
     <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它： </strong></div></td>
    <td style="text-align:left">${vo.quoteelsecostadultsBlock}</td>
    <td>${vo.quoteelsecostadultsSumCost}</td>
    <td>0</td>
    <td>${vo.quoteelsecostadults}<input name="quoteelsecostadults" type="hidden" value="${vo.quoteelsecostadults}"/></td>
    <td>${vo.quoteelseecostchildren}<input name="quoteelseecostchildren" type="hidden" value="${vo.quoteelseecostchildren}"/></td> 
    <td><span class="STYLE10"></span></td>
  </tr>
<tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>合计：</strong></div></td>
    <td>&nbsp;</td>
    <td>${adultsumcost }<input name="adultsumcost" type="hidden" value="${vo.adultsumcost}"/></td>
    <td>${childrensumcost }<input name="childrensumcost" type="hidden" value="${vo.childrensumcost}"/></td>
    <td>${vo.plusSumPrice}<input name="plusSumPrice" type="hidden" value="${vo.plusSumPrice}"/></td>
    <td>${vo.plusDevicePrice}<input name="plusDevicePrice" type="hidden" value="${vo.plusDevicePrice}"/></td>
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
    <td colspan=6  style="text-align:left;float:left">大人：<span name="adultsperguy">${vo.plusSumPrice+adultsumcost }</span>元/人*${od.adults }人<br />
      小孩：<span name="childsperguy">${vo.plusDevicePrice+childrensumcost }</span>元/人*${od.children }人（小孩不含门票） 注：小孩未勾引选门票栏。 </td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"></td>
    <td>
      <table border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td>
            <a style="padding-left:10px;width:200pxpadding-right:10px;" href="travelOrder/returntoQuote2/${torder.id}/${bean.id }" class="easyui-linkbutton" iconcls="icon-back" >返回上页修改</a>
           </td>
          <td><input  style="padding-left:10px;padding-right:10px;margin-left:20px;height:26;width:150;" type="submit" class="easyui-linkbutton" name="Submit22" value="预览一下" /></td>
     </tr>
      </table></td>
          <td colspan=4><span class="STYLE149">
            <input name="isShowDetail"  value="true" type="checkbox" />
          </span><span class="STYLE148">报价单中显示明细帐目</span></td>
          
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
