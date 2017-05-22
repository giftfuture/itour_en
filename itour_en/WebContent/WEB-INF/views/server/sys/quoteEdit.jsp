<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>路线价目详情</title>
<%-- <script type="text/javascript" src="${basePath }js/jquery-ui-1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath }js/jquery-ui-1.12.1/jquery-ui.min.css"> --%>
<%-- <script type="text/javascript" src="${basePath }js/plug-in/jquery.multi-select.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}css/multiselect/css/multi-select.css"> --%>
</head>
<body ><!-- class="easyui-layout" -->
<form:form method="post" id="back_form" action="${basePath }routeTemplate/list">
<a style="padding-left:20px;margin-left:20px;" onsubmit="" onclick="document:back_form.submit();" class="easyui-linkbutton" iconcls="icon-back" >返回</a>
</form:form>
<form:form method="post" name="quoteEditForm">
<input type="hidden" name="rtId" value="${bean.id}">
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
            <td width="1021"><span class="style148"><span class="style24">来自：</span>${bean.city }${bean.district }${bean.customerName} <span class="STYLE24">团号：</span>${qf.groupCode }  <span class="STYLE149">出团日期：</span>${qf.groupDate }<span class="STYLE149">人数：</span>${qf.adults }大${qf.children }小 </span></td>
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
    <td class="h1-black">${bean.title }<span class="STYLE27"><input name="rttitle" type="hidden" value="${bean.title }" />
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
      <div id="routetablediv">
      <table name="routetable" width="80%" cellspacing="1" cellpadding="5" border="0" align="center">
        <thead><tr>
          <td class="STYLE129" valign="middle" bgcolor="#F0F0F0" height="31"><div class="style18" align="center">
            <div align="center"><strong><strong>天数</strong></strong></div>
          </div></td>
          <td class="STYLE129" valign="middle" align="center" bgcolor="#F0F0F0"><div class="STYLE18" align="center">
          <strong>行程</strong>
          </div></td>
          <td class="STYLE129" valign="middle" bgcolor="#F0F0F0"><div class="STYLE18" align="center">
            <div align="center">里程</div>
          </div></td>
          <td class="STYLE129" valign="middle" bgcolor="#F0F0F0" align="center"><div class="STYLE18" align="center" style="width:300px;">
           	景点
          </div></td>
          <td><a name="routeplus"><img alt="" title="添加一行" src="${basePath }images/add.gif"></a></td>
        </tr>
        </thead>
<%--    <tr id=beriefTr_0><td class=style126 width=34 valign=middle><div align=center><select class='easyui-combobox' name='tourdays' data-options="width:50"><option 
		value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option 
		value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option><option 
		value='9'>9</option><option value='10'>10</option><option value='11'>11</option><option 
		value='12'>12</option><option value='13'>13</option><option value='14'>14</option><option 
		value='15'>15</option></select></div></td>
		<td class=STYLE126 width=308 valign=middle><input type='text' class='easyui-textbox' name='tourDesc'></td>
		<td class=STYLE126 width=50 valign=middle><input name='mileage'  class='easyui-textbox' type='number' min=0 
		onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" 
		onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" 
		onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"></td>
		<td class=STYLE126 width=124 valign=middle><input name="area" id="area" class="easyui-combobox" style="cursor:pointer"  data-options="width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'auto',editable:false,method:'get',url:'${basePath}areas/allAreas',
		onChange:function(n,o){ var urlurl = '${basePath}travelItem/queryByScope?scope='+n ;$('#travelItem').combobox('reload',urlurl);}">
		<input id='travelItem' style="cursor:pointer" name='travelItem' class='easyui-combobox'  
		 data-options="valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,required:true,width:151,height:22,formatter:function(row){return '<span><input type=checkbox class=selectId style=vertical-align:middle name=selectId_1491992423815'+row.alias+' value='+row.alias+'>'+row.item+'</span>';},onSelect:function(record){$('input[name=selectId_1491992423815'+record.alias+']').attr('checked', true);},onUnselect:function(record){$('input[name=selectId_1491992423815'+record.alias+']').attr('checked', false);}"/></td>
		<td><a name='routeminus' onclick='javascript:itour.quoteEdit.routeMinus(this)'><img alt='' style='height:16px;height:16px;' src='images/minus.png' ></a></td></tr>
		<tr><td class=STYLE126 width=100 valign=middle>详细行程：</td><td style="text-align:left" colspan="4" class=STYLE126 valign=middle>
		<input type="text" class="easyui-textbox" name=''data-options="width:890,height:34"/></td></tr> --%>
		  ${qf.beriefTrip }   
      </table></div>
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
    <td><label> 大人：<span class="style126" >
    <input name="adults" size="6" type="number" min=0 class="easyui-numberbox,easyui-validatebox" data-options="precision:2,groupSeparator:',',width:151,height:22,missingMessage:'请填写每位成人的费用;'" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
    	元/人&nbsp;&nbsp; 小孩 
    <input name="children" size="6" type="number" min=0 class="easyui-numberbox,easyui-validatebox" data-options="precision:2,groupSeparator:',',width:151,height:22,missingMessage:'请填写每位孩子的费用;' " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)">
    </span> 元/人     
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
    <td bgcolor="#f0f0f0"><p align="right"><strong>门票：</strong></p></td>
    <td><!-- <span class="STYLE144">根据制定行程时所选的景点，按对应的日期显示景点名称及相应各价格明细 ——如果觉得管理后台太麻烦的话也可以直接手动输入 <span class="STYLE145">？ </span><br>
      </span> -->
        <br> 
      添加景区：<a name="addSight" ><img src="images/add.gif" width="16" height="16" ></a> <br>
      <div id="addsightdiv">
      	${qf.ticketBlock}</div></td>
    <td><div align="center">
    <c:choose> 
      <c:when test="${qf.ticketAsadult ==true}">
            <input name="ticketAsadult" value="" checked="checked" type="checkbox">
      </c:when><c:otherwise>
      		<input name="ticketAsadult" value="" type="checkbox">
      </c:otherwise>	
      </c:choose>
    </div></td>
    <td><span class="STYLE10">需要进行单独管理（可以按时间点选门票里面的项目，及按日期出来的价格）<br>
      。报价单上面可以显示或不显示门票明细及价格<br>
      后台可以查看到。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>旅行证件</strong></div></td>
    <td>添加证件：<a name="addCard" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addcarddiv">
    ${qf.travelDocs }
   </div></td>
    <td><div align="center">
    <c:choose> 
    	<c:when test="${qf.traveldocAsadult==true }">
      <input name="traveldocAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="traveldocAsadult" type="checkbox">
    	</c:otherwise>
   	</c:choose>
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>导游：</strong></div></td>
    <td>添加导游：<a name="addGuide" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addGuideDiv">
   ${qf.tourGuide }
   </div></td>
    <td><div align="center">
    <c:choose> 
      <c:when test="${qf.tourguideAsadult==true }">
      <input name="tourguideAsadult" type="checkbox" checked="checked">
      </c:when><c:otherwise>
      <input name="tourguideAsadult" type="checkbox">
      </c:otherwise>
     </c:choose>
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
    <td>添加用车：<a name="addusecar" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addcardiv">
    ${qf.rentCar }
    </div></td>
    <td><div align="center">
    <c:choose> 
      <c:when test="${qf.rentcarAsadult==true }">
      <input name="rentcarAsadult" checked="checked" type="checkbox">
      </c:when><c:otherwise>
       <input name="rentcarAsadult" type="checkbox">
      </c:otherwise>	
    </c:choose>
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。<br>
    方式若选择天的话，自动在后面的数量里面补上1（这个容易被忘掉，那算出来就变成 0了）</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>大交通：<br>
    </strong></div></td>
    <td>添加大交通：<a name="addbigtraffic" ><img src="images/add.gif" width="16" height="16" ></a> 
    <c:choose>
    	<c:when test="${qf.bigtrafficeAsadult==true }">
    	    <label>
        <input name="train-ticket" value="bigTrafficSum" checked="checked"type="radio">
      计入总价
      </label>
      <label>
        <input name="train-ticket" value="train-ticket"  type="radio">
        另外核算</label>
      （火车票、机票、大巴票等）<br>
    	</c:when><c:otherwise>
    	    <label>
        <input name="train-ticket" value="bigTrafficSum" type="radio">
      计入总价
      </label>
      <label>
        <input name="train-ticket" value="train-ticket" checked="checked" type="radio">
        另外核算</label>
      （火车票、机票、大巴票等）<br>
    	</c:otherwise>
    </c:choose>
    	<div id="addbigtrafficdiv">
  			${qf.bigTraffic }
            </div>  </td>
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
    <td>添加用餐：<a name="adddinner" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="dinnerblock">
	${qf.dinner }
	</div></td>
    <td><div align="center">
      <!-- <input name="checkbox34" value="checkbox" checked="checked" type="checkbox"> -->
    </div>
    </td>
    <td><span class="STYLE10">。后台按勾选来算餐数，特色餐数量需要减出来。<br>
  。特色餐可提前设定，勾选，核算价格的时候需要扣出来已经算入的午餐或晚餐</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0">
    <div align="right"><strong>保险：</strong></div></td>
    <td>添加保险：<a name="addinsurance" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="insurancediv">
    ${qf.insurance }
        </div></td>
    <td><div align="center">
      <c:choose>
      	<c:when test="${qf.insuranceAsadult==true }">
      <input name="insuranceAsadult" checked="checked" type="checkbox">      	
      	</c:when>
      	<c:otherwise>
      	 <input name="insuranceAsadult" type="checkbox">      	
      	</c:otherwise>
      </c:choose>	
    </div></td>
    <td><span class="STYLE10">内宾10元，外宾30元 </span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0">
    <div align="right"><strong>综费</strong>：</div></td>
    <td>添加综费：<a name="addallfees" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="allfeesdiv">
		${qf.comprehensiveCosts }
      </div></td>
    <td><div align="center">
    <c:choose>
    	<c:when test="${qf.comphcostAsadult==true }">
       <input name="comphcostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="comphcostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>娱乐：</strong></div></td>
    <td>添加娱乐：<a name="addjoys" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="addjoysdiv">
		${qf.recreation }
       </div></td>
    <td><div align="center">
     <c:choose>
    	<c:when test="${qf.comphcostAsadult==true }">
      <input name="recreationAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="recreationAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">徒步登山项目</div></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>向导</strong></div></td>
    <td>添加徒步向导：<a name="addhikingguide" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="hikingguidediv">
		${qf.itemGuide }
   	</div></td>       
    <td><div align="center">  
       <c:choose>
    	<c:when test="${qf.itemguideAsadult==true }">
      <input name="itemguideAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="itemguideAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="style10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>驮马费</strong></div></td>
    <td>添加驮马费：<a name="addbathorseCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="bathorseCostdiv">
		${qf.bathorseCost }
        </div></td>
    <td><div align="center">
     <c:choose>
    	<c:when test="${qf.bathcostAsadult==true }">
      <input name="bathcostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="bathcostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="STYLE10">——算出总价，平摊到团员。</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>骑马费</strong></div></td>
    <td>添加骑马费：<a name="addridehorseCost" id="addridehorseCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="ridehorseCostdiv">
		${qf.ridehorseCost }
       </div>
     </td>
    <td><div align="center">
    <c:choose>
    	<c:when test="${qf.ridecostAsadult==true }">
      <input name="ridecostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="ridecostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="STYLE10">？若只是部分客人的怎么办？单独写在备注里面</span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登山注册费</strong></div></td>
    <td>添加登山注册费：<a name="addclimbregisterCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="climbregisterdiv"> 
   		${qf.climbRegisterCost }
      </div></td>
    <td><div align="center">
    <c:choose>
    	<c:when test="${qf.climbrcostAsadult==true }">
      <input name="climbrcostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="climbrcostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>登协联络官</strong></div></td>
    <td>添加登协联络官：<a name="addclimbnexusCost" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="climbnexusdiv">
		${qf.climbNexusCost }	
      </div></td>
    <td><div align="center">
     <c:choose>
    	<c:when test="${qf.climbncostAsadult==true }">
      <input name="climbncostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="climbncostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td colspan="4"><span class="STYLE10"></span></td>
  </tr>
  <tr>
    <td bgcolor="#f0f0f0"><div align="right"><strong>其它 </strong></div></td>
    <td>其他费用：<a name="addelseitem" ><img src="images/add.gif" width="16" height="16" ></a> 
    <div id="elseitemdiv">
   	${qf.elseCost }
     </div>
      </td>
    <td><div align="center">
     <c:choose>
    	<c:when test="${qf.elsecostAsadult==true }">
      <input name="elsecostAsadult" checked="checked" type="checkbox">
    	</c:when><c:otherwise>
      <input name="elsecostAsadult" type="checkbox">
    	</c:otherwise>
    </c:choose>
    </div></td>
    <td><span class="style10"></span></td>
  </tr>
  <tr>
    <td><div align="right"></div></td>
    <td>赠送项目：<textarea rows="3" cols="80" name="presented" value="">${qf.presented }</textarea></td>
    <td><div align="center"></div></td>
    <td><span class="STYLE10"></span></td>
  </tr>
  <tr><td><input type="button" name="rtbtn" value="芝麻开门"><div id="alertMessage"></div></td></tr>
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
<script type="text/javascript" src="${basePath}js/ux/sys/quoteEdit.js"></script>
</body>
</html>

