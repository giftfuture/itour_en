<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%-- <script type="text/javascript" src="${basePath }js/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath }js/jquery-ui-1.12.1/jquery-ui.min.css"> --%>
<%-- <script type="text/javascript" src="${basePath }js/plug-in/jquery.multi-select.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}css/multiselect/css/multi-select.css"> --%>
</head>
<body ><!-- class="easyui-layout" -->
<form:form method="post" id="back_form" action="${basePath }travelOrder/list">
<a style="padding-left:20px;margin-left:20px;" onsubmit="" onclick="document:back_form.submit();" class="easyui-linkbutton" iconcls="icon-back" >返回</a>
</form:form>
<form:form method="post" name="quoteEditForm">
<input type="hidden" name="id" value="${qf.id }">
<input type="hidden" name="rtid" value="${bean.id}">
<input type="hidden" name="torderid" value="${torder.id}" >
<input type="hidden" name="adultticketTotalPrice"  />
<input type="hidden" name="adultticketsBlock" />
<input type="hidden" name="quotetraveldocadultsBlock"  />
<input type="hidden" name="quotetourguideadultsBlock"  />
<input type="hidden" name="quoterentcaradultsBlock"  />
<input type="hidden" name="quotebigtrafficadultsBlock"  />
<input type="hidden" name="quoteinsuranceadultsBlock"  />
<input type="hidden" name="quotecomphcostadultsBlock"  />
<input type="hidden" name="quoterecreationadultsBlock"  />
<input type="hidden" name="quoteitemguidecadultsBlock"  />
<input type="hidden" name="quotebathorseadultsBlock"  />
<input type="hidden" name="quoteridehorseadultsBlock"  />
<input type="hidden" name="quoteclimbregisteradultsBlock"  />
<input type="hidden" name="quoteclimbnexusadultsBlock"  />
<input type="hidden" name="quoteelsecostadultsBlock"  />
<input type="hidden" name="quotetraveldocadultsSumCost"  />
<input type="hidden" name="quotetourguideadultsSumCost"  />
<input type="hidden" name="quoterentcaradultsSumCost"  />
<input type="hidden" name="quotebigtrafficadultsSumCost"  />
<input type="hidden" name="quoteinsuranceadultsSumCost"  />
<input type="hidden" name="quotecomphcostadultsSumCost"  />
<input type="hidden" name="quoterecreationadultsSumCost"  />
<input type="hidden" name="quoteitemguidecadultsSumCost"  />
<input type="hidden" name="quotebathorseadultsSumCost"  />
<input type="hidden" name="quoteridehorseadultsSumCost"  />
<input type="hidden" name="quoteclimbregisteradultsSumCost"  />
<input type="hidden" name="quoteclimbnexusadultsSumCost"  />
<input type="hidden" name="quoteelsecostadultsSumCost"  />
<div id="quoteForm">
<table width="80%" cellspacing="0" cellpadding="0" border="0" align="center">
  <tbody><tr>
    <td><img src="images/frame1-1.gif" width="100%" height="7"></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif"><table width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
      <tbody><tr>
        <td width="685">
        <table width="1053" cellspacing="0" cellpadding="0" border="0">
          <tbody><tr>
            <td width="32"><img src="images/man.gif" width="32" height="32"></td>
            <td width="1021"><span class="style148"><span class="style24">来自：</span>${od.areaname }${torder.receiver} &nbsp;&nbsp;&nbsp;&nbsp;<span class="STYLE24">团号：</span>${od.groupCode }  <span class="STYLE149">&nbsp;&nbsp;&nbsp;&nbsp;出团日期：</span>${od.groupDate }<span class="STYLE149">&nbsp;&nbsp;&nbsp;&nbsp;人数：</span>${od.adults }大${od.children }小 </span></td>
          </tr>
        </tbody></table></td>
      </tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="100%" height="7"></td>
  </tr>
</tbody></table>
<table width="80%" cellspacing="0" cellpadding="10" border="0" align="center">
  <tbody><tr>
    <td class="h1-black">${bean.title}<span class="STYLE27"><input name="rttitle" type="hidden" value="${bean.title }" />
    <input name="rtelevation" type="hidden" value="${bean.elevation }" /></span></td>
  </tr>
</tbody></table>
<br>
<span class="style10">备注：提前要连接好客人的信息，团号，出团日期，人数几大几小。</span><br>
<table width="80%" cellspacing="0" cellpadding="0" border="0" align="center">
  <tbody><tr>
    <td><img src="images/frame1-1.gif" width="100%" height="7"></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif">
    <table width="100%" cellspacing="0" cellpadding="10" border="0" align="center">
        <tbody><tr>
          <td class="STYLE126" width="761" valign="top"><span class="STYLE3">简要行程</span><span class="STYLE2">：</span></td>
        </tr>
      </tbody></table>
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
      <br></td>
  </tr>
  <tr>
    <td><img src="images/frame1-3.gif" width="100%" height="7"></td>
  </tr>
</tbody></table>
<br>
<table width="80%" cellspacing="2" cellpadding="8" border="1" align="center">
  <tbody><tr>
    <td width="78"><strong>项目</strong></td>
    <td width="639"><div align="center"><strong>成本及计算</strong></div></td>
    <td width="39"><div align="center">小孩</div></td>
    <td width="360"><div class="STYLE10" align="center"><strong>说明</strong></div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>人数： </strong></div></td>
    <td><label> 大人：<span class="style126" >${od.adults }位
    <!-- <input name="adultPrice" size="6" style="width:100px" type="number" min=0 class="easyui-numberbox,easyui-validatebox" data-options="precision:2,groupSeparator:',',width:151,height:22,missingMessage:'请填写每位成人的费用;'" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"> -->
        <!-- 元/人 -->&nbsp;&nbsp; 小孩 ${od.adults }位
   <!--  <input name="childPrice" size="6" style="width:100px" type="number" min=0 class="easyui-numberbox,easyui-validatebox" data-options="precision:2,groupSeparator:',',width:151,height:22,missingMessage:'请填写每位孩子的费用;' " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"> -->
    </span> <!-- 元/人   -->   
    （
    <input name="isAsAdult" value="isAsAdult" type="radio">
      同大人一样
      <input name="isAsAdult" value="isAsChild" checked="checked" type="radio">
      按小孩核算
      ）</label></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10">。同大人一样则把核算项目中的成人人数变为 成人+小孩 ， 平摊费用 <br>
      。按小孩计算则计算勾选项目，未勾选的项目需在报价上面显示不含这些项目。<br>
      。小数点后面的去零取整</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0" style="text-align:left"><p align="right"><strong>门票：</strong></p></td>
    <td style="text-align:left;padding-left:15px"><div id="adultticketsBlock">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.adultticketsBlock }
    </c:when>
    <c:otherwise>
    ${adultticketsBlock}
    </c:otherwise>
    </c:choose></div>
       </td>
    <td><div align="center">
    </div></td>
    <td><span class="STYLE10">需要进行单独管理（可以按时间点选门票里面的项目，及按日期出来的价格）<br>
      。报价单上面可以显示或不显示门票明细及价格<br>
      后台可以查看到。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件</strong></div></td>
    <td style="text-align:left">添加证件：<a name="addCard" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addcarddiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quotetraveldocadultsBlock }
    </c:when>
    <c:otherwise>
    <span class=STYLE126><input name=card size=20 type=text>&nbsp;&nbsp;
     <input name=cardprice size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
           元/人&nbsp;&nbsp;备注：<input name=cardremark size=20 type=text><a name=minusCard><img src=images/minus.png onclick='javascript:itour.quoteEdit.sightMinus(this)' width=20 height=20 ></a></span>
    </c:otherwise>
    </c:choose> 
   </div></td>
    <td><div align="center">
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td style="text-align:left">添加导游：<a name="addGuide" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addGuideDiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quotetourguideadultsBlock }
    </c:when>
    <c:otherwise>
    <span class=style126> 
            <br><input name=alltheway value='all the way' size=10 type=text> 
          <select name=choselanguage id=choselanguage> 
            <option>Choose Language</option> 
            <option value='Chinese'>Chinese</option> 
            <option value='English'>English</option> 
          </select>&nbsp;&nbsp; 
        <input name=priceperday size=6  style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        元/天 &nbsp;&nbsp;X 
          <input name=days  size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
            天 &nbsp;&nbsp;备注：<input name=guideremark size=10 type=text>
            <a name=guideminus onclick='javascript:itour.quoteEdit.guideMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> 
     </c:otherwise>
    </c:choose>
   </div></td>
    <td><div align="center">
    </div></td>
    <td><span class="STYLE10">。多少钱一天在后台根据淡旺季和语种管理<br>
      。天数默认为行程天数<br>
      ——算出总价，平摊到团员</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>酒店：<br>
    </strong></div></td>
    <td>
    请在概要行程里面填写价格，请<span class="STYLE129">务必注意节假日及会议期间</span>哟。</td>
    <td><div align="center">
     <!--  <input name="hotelAsadult" checked="checked" type="checkbox"> -->
    </div></td>
    <td><span class="STYLE10">。后台可选择酒店名称，但无需管理价格。<br>
      。可能会有单房差</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><strong>用车：
    <br>
    </strong></td>
    <td style="text-align:left">添加用车：<a name="addusecar" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addcardiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoterentcaradultsBlock }
    </c:when>
    <c:otherwise>
    <span class=STYLE126><input name=alltheway value='all the way' size=10 type=text>&nbsp;&nbsp; 
<input name=carprice size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
            元/ <select name=carstyle id=carstyle> 
            <option selected=selected>style</option> 
            <option value='day'>day</option> 
            <option value='Km'>Km</option> 
            <option value='trip'>trip</option> 
              </select>
              X<input name=carcount size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
                数量&nbsp;&nbsp;　备注： 
              <input name=carremark size=20 type=text><a name=carminus onclick='javascript:itour.quoteEdit.carMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
     </c:otherwise>
    </c:choose>
    </div></td>
    <td><div align="center">
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。<br>
    方式若选择天的话，自动在后面的数量里面补上1（这个容易被忘掉，那算出来就变成 0了）</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br>
    </strong></div></td>
    <td style="text-align:left">添加大交通：<a name="addbigtraffic" ><img src="images/add.gif" width="16" height="16" ></a> 
      <label><input name="train-ticket" value="bigTrafficSum" checked="checked"type="radio">计入总价 </label>
      <label><input name="train-ticket" value="train-ticket"  type="radio">另外核算</label>
      （火车票、机票、大巴票等） 
        <div id="addbigtrafficdiv">
        <c:choose>
        <c:when test="${returnvo != null }">
             ${returnvo.quotebigtrafficadultsBlock }
        </c:when>
        <c:otherwise>
        <span class=STYLE126><input name='traffic' type='text' > 
        <input name=trafficperprice size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        元/ 人 &nbsp;&nbsp;备注： <input name=trafficremark size=20 type=text>
        <a name='trafficminus' onclick='javascript:itour.quoteEdit.trafficMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
   </c:otherwise>
    </c:choose>
    </div></td>
    <td><div align="center">
      <input name="bigtrafficeAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="STYLE10">可以不同的几段计入<br>
      另外核算则写在总价后面。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0">
    <div align="right"><strong>用餐：<br>
    </strong></div></td>
    <td style="text-align:left">添加用餐：<a name="adddinner" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="dinnerblock">
    <label><input name="dinnerprice" type="checkbox" checked="checked"></label>
      餐标：<span class="style126">
        <input name="singledinner" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" type="number" size="6" min="0" value="30" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        </span>元/人餐<br>
    <div id="specialdinnerblock">
    <table border="0" cellspacing="0" cellpadding="2">
    <tbody><tr><td><a name='addspecialdinner'><img src='images/add.gif' width=16 height=16 ></a></td><td rowspan=3>安排特色餐： <select name='province'><option>四川</option> <option>云南</option> <option>西藏</option><option>新疆</option> </select></td></tr></tbody>
        <tbody><tr><td><input name=district size=10 type=text></td>
        <td><span class=style126>餐名：<input name=dinnername size=10 type=text>&nbsp; 
        <input name=dinnerprice size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">元/人 </span></td> 
        <td><a name='addsingledinner'><img src=images/add.gif width=16 height=16 ></a></td></tr></tbody>
        <tbody><tr><td><input name=district size=10 type=text></td><td>餐名：<input name=dinnername size=10 type=text>&nbsp; 
        <input name=dinnerprice size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"> 
        元/人</td><td><a name='addsingledinner'><img src=images/add.gif width=16 height=16 ></a></td> </tr></tbody>
        </table>
      </div></div></td> 
    <div align="center">
      <!-- <input name="checkbox34" value="checkbox" checked="checked" type="checkbox"> -->
    </div>
    </td>
    <td><span class="STYLE10">。后台按勾选来算餐数，特色餐数量需要减出来。<br>
  。特色餐可提前设定，勾选，核算价格的时候需要扣出来已经算入的午餐或晚餐</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0">
    <div align="right"><strong>保险：</strong></div></td>
    <td style="text-align:left">添加保险：<a name="addinsurance" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="insurancediv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteinsuranceadultsBlock }
    </c:when>
    <c:otherwise>
    <span class=style126><br><select style='width:151' name=insuranceselect id=insuranceselect> 
         <option value="Neighborhood travel accident insurance">Neighborhood travel accident insurance</option> 
         <option value="Inbound tourism accident insurance">Inbound tourism accident insurance</option> 
        </select> 
        <input name=insuranceprice size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
                 元/人&nbsp;&nbsp;备注： 
          <input name=insuranceremark size=20 type=text> 
          <a name=insuranceminus onclick='javascript:itour.quoteEdit.insuranceMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
    </c:otherwise>
    </c:choose>
     </div></td>
    <td><div align="center">
      <input name="insuranceAsadult" checked="checked" type="checkbox">         
    </div></td>
    <td><span class="STYLE10">内宾10元，外宾30元 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0">
    <div align="right"><strong>综费</strong>：</div></td>
    <td style="text-align:left">添加综费：<a name="addallfees" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="allfeesdiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quotecomphcostadultsBlock }
    </c:when>
    <c:otherwise>
        <span class=style126> 
         <input name=feeName value='Travel agency service fee' size=20 type=text> 
         <input name=feeperperson size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        元/人&nbsp;&nbsp;备注： <input name=feeremark size=20 type=text> 
      <a name=allfeeminus onclick='javascript:itour.quoteEdit.allfeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
      </c:otherwise>
    </c:choose>
      </div></td>
    <td><div align="center">
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td style="text-align:left">添加娱乐：<a name="addjoys" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addjoysdiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoterecreationadultsBlock }
    </c:when>
    <c:otherwise>
        <span class=STYLE126><input name=joyitem size=20 type=text> 
        <input name=perjoyprice size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        元/人　&nbsp;&nbsp;备注：<input name=joyremark size=20 type=text>
        <a name=joyminus onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
      </c:otherwise>
    </c:choose>
       </div></td>
    <td><div align="center">
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">徒步登山项目</div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>向导</strong></div></td>
    <td style="text-align:left">添加徒步向导：<a name="addhikingguide" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="hikingguidediv">
        <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteitemguidecadultsBlock }
    </c:when>
    <c:otherwise>
        <span class=style126> 
            <input name=hikingitem size=20 type=text> 
            <input name=guidename  size='6' style='width:50' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> 向导数 X 
            <input name=guideperday size=6 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"> 元/天 X   
            <input name=guidedays size=4 style='width:50px' type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"> 天　&nbsp;&nbsp;备注： 
            <input name=hikingguideremark size=20 type=text> 
            <a name=joyminus onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> 
        </c:otherwise>
    </c:choose>
    </div></td>       
    <td><div align="center">  
      <input name="itemguideAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="style10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费</strong></div></td>
    <td style="text-align:left">添加驮马费：<a name="addbathorseCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="bathorseCostdiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quotebathorseadultsBlock }
    </c:when>
    <c:otherwise>
        <span class=STYLE126><br><input name=bathorseCost size=20 type=text> 
            <input name=bathorsenum size=4 style=width:50px type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
            马匹数 X<input name=bathorseperday size=6 style=width:50px type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
            元/天  X  <input name=bathorseprice size=4 style=width:50px type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
            天　&nbsp;&nbsp;备注：<input name=bathorseremark size=20 type=text> <a name=bathorseminus onclick='javascript:itour.quoteEdit.bathhorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
         </c:otherwise>
    </c:choose>
        </div></td>
    <td><div align="center">
      <input name="bathcostAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费</strong></div></td>
    <td style="text-align:left">添加骑马费：<a name="addridehorseCost" id="addridehorseCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="ridehorseCostdiv">
    <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteridehorseadultsBlock }
    </c:when>
    <c:otherwise>
    <span class=style126> 
        <input name='ridehorse' size=20 type='text'> 
        <input name='ridehorseperday'  size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> 
                元/天  X<input name='ridehorsedays'  size='4' style='width:50px' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">天　&nbsp;&nbsp;备注： 
        <input name='ridehorseremark' size=20 type='text'> 
        <a name='rideorseminus' onclick='javascript:itour.quoteEdit.ridehorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> 　
         </c:otherwise>
    </c:choose>
        </div>
     </td>
    <td><div align="center">
      <input name="ridecostAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="STYLE10">？若只是部分客人的怎么办？单独写在备注里面</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费</strong></div></td>
    <td style="text-align:left">添加登山注册费：<a name="addclimbregisterCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="climbregisterdiv"> 
     <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteclimbregisteradultsBlock }
    </c:when>
    <c:otherwise>
        <span class=style126> 
        <input name=climbRegister size=20 type=text>&nbsp;&nbsp;<input name=climbRegisterperday size=6 style='width:50' type='number' min='0' onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\"> 
        元/天  X<input name=climbRegisterdays size=4 style="width:50" type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
        天　&nbsp;&nbsp;备注：<input name=climbRegisterremark size=20 type=text> 
        <a name=climbRegisterminus onclick='javascript:itour.quoteEdit.climbRegisterMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
         </c:otherwise>
    </c:choose>
        </div></td>
    <td><div align="center">
      <input name="climbrcostAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登协联络官</strong></div></td>
    <td style="text-align:left">添加登协联络官：<a name="addclimbnexusCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="climbnexusdiv">
     <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteclimbnexusadultsBlock }
    </c:when>
    <c:otherwise>
        <span class=style126> 
        <input name=climbnexus size=20 type=text>&nbsp;&nbsp;<input style='width:50px;' name=climbnexusnum value=1 size=4 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">人数 X
        <input name=climbnexusperday style='width:50px;' size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">元/天  X 
        <input name=climbnexusdays style='width:50px;' size=4 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">天　&nbsp;&nbsp;备注：
        <input name=climbnexusremark size=20 type=text>
        <a name=climbnexusminus onclick='javascript:itour.quoteEdit.climbnexusMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>
       </c:otherwise>
    </c:choose>
      </div></td>
    <td><div align="center">
      <input name="climbncostAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它 </strong></div></td>
    <td style="text-align:left">其他费用：<a name="addelseitem" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="elseitemdiv">
     <c:choose>
    <c:when test="${returnvo != null }">
         ${returnvo.quoteelsecostadultsBlock }
    </c:when>
    <c:otherwise>
    <span class=STYLE126> 
        <input name=elseitem size=20 type=text> 
        <input name=elseitemprice size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
         元/ <select name=elseitemstyle id=elseitemstyle>
         <option selected=selected>style</option>
         <option value='person'>person</option>
         <option value='group'>group</option>
        </select>&nbsp;&nbsp;备注：<input name=elseitemremark size=20 type=text>
         <a name=elseitemminus onclick='javascript:itour.quoteEdit.elsefeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png'></a></span>
         </c:otherwise>
    </c:choose>
     </div>
      </td>
    <td><div align="center">
      <input name="elsecostAsadult" checked="checked" type="checkbox">
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td><div align="right"></div></td>
    <td style="text-align:left">赠送项目：<textarea rows="3" cols="80" name="presented" value="">${qf.presented }</textarea></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr><td><%-- <a href="${basePath }travelOrder/toQuote2/${torder.id}/${bean.id}"> --%><input type="button" name="rtbtn" value="芝麻开门"/><!-- </a> --><div id="alertMessage"></div></td></tr>
<%--   <tr>
    <td><div align="right">核算价格：</div></td>
    <td><label></label>
      <table cellspacing="0" cellpadding="3" border="0">
        <tbody><tr>
          <td><input type="button" name="rtbtn" value="芝麻开门"></td>
        </tr>
        <tr>
          <td><a href="${basePath}hiking/toQuote2">链接</a></td>
        </tr>
      </tbody></table></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10">两种核算价格的方式，出来两个不同的页面</span></td>
  </tr> --%>
  <tr>
    <td><div align="right"></div></td>
    <td>**线路在外面售卖的价格可能通过这套系统来评估<br>
      **可选儿童不占床，不含门票，不含车费。 </td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
 <!--  <tr>
    <td colspan="4"><p><a href="#" class="STYLE136">算价管理（门票在景点内管理）</a></p>    </td>
  </tr> -->
</tbody></table>
</div>
</form:form>
<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe> 
<script type="text/javascript" src="${basePath}js/ux/sys/quote_step1.js"></script>
</body>
</html>

