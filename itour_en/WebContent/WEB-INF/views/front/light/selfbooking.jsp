<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="keywords" content="china travel">  
<meta http-equiv="description" content="${rt.title }"> 
<title>${rt.title}</title>
</head>
<body>
<%@include file="/front/header.jsp"  %>
<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<div id="append_parent"></div>
<table width="996" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr> 
    <td width="10" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="10" height="8" /></td>
    <td width="177">
<div align="center"><img src="images/logo.jpg" width="160" height="96" /></div></td>
    <td width="10" background="images/default/shadowright.gif"><img src="images/default/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
<table width="996" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr> 
    <td width="10" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="10" height="8" /></td>
    <td> </div> <div align="center"><span class="headline"> 主角旅行个性定制服务</span></div></td>
    <td width="10" background="images/default/shadowright.gif"><img src="images/default/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
 <form name="booking" method="post">
<table width="996" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<!--   <tr>
    <td><input type="hidden" id="site_id" name="site_id" value="3" /></td>
    <td><input type="hidden" id="line_url" name="line_url" value="http://www.travel-sichuan.com/sichuan/daocheng/t-dc-01.htm" /></td></tr> -->
  <tr>
    <td width="10" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="10" height="8" /></td>
    <td> <div align="center"> </div>
      <br />
      <table width="100%" border="0" align="center" cellpadding="2" cellspacing="0" class="heedline1">
        <tr> 
          <td width="19%"> <p align="right"><strong>旅行线路：<br />
              </strong></p></td>
          <td width="81%" style="text-align:left"><input type="hidden" name="routeId" value="${rt.id }"/><input name="routename" type="text" class="easyui-textbox" data-options="editable:false" size="80" value="${rt.title } " /></td>
        </tr>
        <tr> 
          <td><div align="right"><strong>预计出行日期：</strong></div></td>
          <td style="text-align:left"><input name="expectedDepart" id="expectedDepart" type="text" class='easyui-datetimebox' data-options="showSeconds:false, validType:'dateValided',editable:false,split:true,border:false,region:'north',onSelect:itour.lightselfbooking.onChangeDate(this)" style="width:150px;" /></td>
        </tr>
        <tr> 
          <td><div align="right"><strong>预计返程日期：</strong></div></td>
          <td style="text-align:left"><input id="expectedBack" name="expectedBack" type="text" class='easyui-datetimebox' data-options="showSeconds:false, validType:'md[\'#expectedDepart\']',editable:false,split:true,border:false,region:'north',onSelect:itour.lightselfbooking.onChangeDate(this)" style="width:150px;" />
            </td>
        </tr>
		<tr> 
          <td><div align="right"><strong>旅行方式：</strong></div></td>
          <td style="text-align:left"><select id="travelfashion" name="travelfashion" class="easyui-combobox" data-options="editable:false,panelHeight:100">
		  	<option value="">请选择</option>
		  	<option value="单独安排">单独安排</option>
			<option value="加入散客团">加入散客团</option>
		  </select>&nbsp;&nbsp;&nbsp;&nbsp;
		  <span id="groupdiv" style="display:none">
		  团号:<input id="groupCode" type="text" class="easyui-textbox" size="80" />
		  出团日期：<input id="groupDate" name="groupDate" type="text" class='easyui-datebox' data-options="validType:'dateValided',editable:false,required:true,split:true,border:false,region:'north',onSelect:itour.lightselfbooking.onChangeDate(this)" style="width:100px;" />
		  </span> </td>
        </tr>
        <tr> 
          <td><div align="right"><strong>旅游预算：</strong></div></td>
          <td style="text-align:left"><input name="budget" type="text" min=0 class="easyui-numberbox" data-options="precision:2,groupSeparator:',',width:151,height:22" />&nbsp;元 /
          &nbsp;<select id="singleorcluster" name="singleorcluster" class="easyui-combobox" data-options="editable:false,panelHeight:100">
		  	<option value="人">人</option>
			<option value="团">团</option>
		  </select>
            （请注明是每人的预算还是整团的总预算）</td>
        </tr>
        <tr> 
          <td valign="top"> <div align="right"><strong>行程要求：<br />
              （复选） </strong></div></td>
          <td style="text-align:left"><span class="radioSpan">
          <input name="travelrequest[]" type="checkbox" value="摄影为主" />
            摄影为主 
            <input name="travelrequest[]" type="checkbox" value="体验民俗文化" />
            体验民俗文化 
            <input name="travelrequest[]" type="checkbox" value="美丽自然风光" />
            美丽自然风光 
            <input name="travelrequest[]" type="checkbox" value="探险挑战" />
            探险挑战 <br /> <input name="travelrequest[]" type="checkbox" value="家庭出游" />
            家庭出游 
            <input name="travelrequest[]" type="checkbox" value="蜜月旅行" />
            蜜月旅行 
            <input name="travelrequest[]" type="checkbox" value="会议奖励" />
            会议奖励<br /> <input name="travelrequest[]" type="checkbox" value="紧凑" />紧凑 
            <input name="travelrequest[]" type="checkbox" value="舒适轻松" />
            舒适轻松 <br /> <input name="travelrequest[]" type="checkbox" value="自驾" />自驾 
            <input name="travelrequest[]" type="checkbox" value="摩托" /> 摩托 
            <input name="travelrequest[]" type="checkbox" value="徒步" /> 徒步<br /> 
            <input name="travelrequest[]" type="checkbox" value="不购物" />不购物</span> </td>
        </tr>
        <tr>
          <td><div align="right"><strong>酒 店：</strong></div></td>
          <td style="text-align:left"><select id="hotel" name="hotel" class="easyui-combobox" data-options="editable:false,panelHeight:200">
		  	<option value="">请选择</option>
            <option value="奢华型（最好的酒店）">奢华型（最好的酒店）</option>
            <option value="尊贵型（五星级）">尊贵型（五星级）</option>
            <option value="舒适型（四星级）">舒适型（四星级）</option>
            <option value="经济型（三星级）">经济型（三星级）</option>
            </select></td>
        </tr>
        <tr> 
          <td><div align="right"><strong>导 游：</strong></div></td>
          <td style="text-align:left"><span class="radioSpan">
          <input type="radio" name="guide" value="中文" />中文 
            <input type="radio" name="guide" value="英文" />英文 
            <input type="radio" name="guide" value="广东话" />广东话 
            <input type="radio" name="guide" value="其他语种" />其它语种
            <span id="elseguide" style="display:none" >
            <input type="text" class="easyui-textbox"name="guide_other" id="guide_other" value=""> </span>
            <input type="radio" name="guide" value="无需导游" />无需导游</span> </td>
        </tr>
        <tr> 
          <td><div align="right"><strong>是否安排饮食 ：</strong></div></td>
          <td style="text-align:left"><input type="checkbox" name="foodArrange" value="请安排" />
          <!--   <input type="radio" name="foodrequest" value="自行安排"  />  请安排  自行安排 -->
           </td>
        </tr>
<!--         <tr> 
          <td><div align="right"></div></td>
          <td>&nbsp;</td>
        </tr> -->
        <tr> 
          <td><div align="right"><strong>联系人姓名：</strong></div></td>
          <td style="text-align:left"><input name="receiver" type="text" class="easyui-textbox"/> 
          <select id="gender" name="gender" class="easyui-combobox" data-options="editable:false,panelHeight:100">
              <option>性别</option>
              <option value="1">男</option>
              <option value="0">女</option>
            </select> </td>
        </tr>
        <tr> 
          <td><div align="right"><strong>人数：</strong></div></td>
          <td style="text-align:left"><input name="adults" size="6" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
            大人 
            <input name="children" size="6" min=0 class="easyui-numberbox" data-options="precision:0,groupSeparator:',',width:151,height:22 " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" />
            小孩（12岁以下） </td>
        </tr>
        <tr> 
          <td><div align="right"><strong>国家及地区：</strong></div></td>
          <td style="text-align:left"><input id="comefrom" name="comefrom" class="easyui-combobox"  data-options="width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'">
            （如：中国香港）</td>
        </tr>
        <tr> 
          <td><div align="right"><strong>E-mail：</strong></div></td>
          <td style="text-align:left"><input name="receiveremail" type='text' class="easyui-textbox" data-options="validType:'email',groupSeparator:',',width:151,height:22" /> </td>
        </tr>
        <tr> 
          <td><div align="right"><strong>联系电话：</strong></div></td>
          <td style="text-align:left"><input name="receiverMobile" class="easyui-textbox" type="text" data-options="validType:'mobileTelephone',groupSeparator:',',width:151,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
        </tr>
   <!--      <tr> 
          <td valign="top"> <div align="right"><strong>详细要求：</strong></div></td>
          <td style="text-align:left">希望能知道您对这次旅游的想法和期望，这样我们更更好的为您设计：<br /> <textarea name="description" cols="70" rows="8" id="description"></textarea> 
          </td>
        </tr> -->
        <tr> 
          <td colspan=2>为能了解您的个性需求，请填写下面表格，以获得更细致的个性服务。（只需在您关注的问题中打勾或填写即可） </td>
        </tr>
        <tr> 
          <td width="19%" valign="top"><div align="right"><strong>住宿要求：</strong></div></td>
          <td width="81%" valign="top" style="text-align:left"><label>特色酒店： 
          <span class="radioSpan">
            <input name="stayrequest[]" type="checkbox"  value="文化主题酒店" />
            文化主题酒店 
            <input name="stayrequest[]" type="checkbox"  value="民族特色酒店" />
            民族特色酒店 
            <input name="stayrequest[]" type="checkbox"   value="民居体验" />
            民居体验<br />
            地理位置： 
            <input name="position[]" type="checkbox"  value="市中心" />
            市中心 
            <input name="position[]" type="checkbox" value="环境好" />
            环境好 
            <input name="position[]" type="checkbox" value="安静" />
            安静 
            <input name="position[]" type="checkbox" value="交通方便" />
            交通方便 <br />
            房型要求：双床房 
            <input name="db_room"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
            间 大床房 
            <input name="bb_room"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" />
            间 套房<input name="suite"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
            间 <br />备注：
            <input name="hotel_no_smoking" type="checkbox" value="无烟" />
            无烟 
            <input name="hotel_quiet" type="checkbox" value="安静" />
            安静 
            <input name="hotel_info" type="checkbox"  value="希望能得到确定后酒店的资料" /> 
             希望能得到确定后酒店的资料,若有您喜欢的酒店可在个性需求里面填写</span>
           </label></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td valign="top"><div align="right"><strong>交通：<br />
              </strong></div></td>
          <td valign="top" style="text-align:left"><span class="radioSpan">飞机： 
            <input name="plane[]" type="radio" value="中国国内" />
            中国国内 
            <input name="plane[]" type="radio" value="国际" />
            国际<br />
            舱位： 
            <input type="radio" name="shipping_space" value="头等舱" />
            头等舱 
            <input type="radio" name="shipping_space" value="商务舱" />
            商务舱 
            <input type="radio" name="shipping_space" value="经济舱" />
            经济舱<br />
            汽车： 
            <input type="radio" name="car" value="越野车" />
            越野车 
            <input type="radio" name="car" value="轿车" />
            轿车 
            <input type="radio" name="car" value="商务车" />
            商务车 
            <input type="radio" name="car" value="旅游巴士" />
            旅游巴士 
            <input name="car_no_smoking" type="checkbox" value="无烟" />
            无烟 
            <input name="car_new" type="checkbox" value="新车" />
            新车<br />
            火车： 
            <input type="radio" name="train" value="硬卧" />
            硬卧 
            <input type="radio" name="train" value="软卧" />
            软卧<br />
            游轮： 
            <input type="radio" name="cruise" value="五星" />
            五星 
            <input type="radio" name="cruise" value="四星" />
            四星 
            <input type="radio" name="cruise" value="经济型" />
            经济型</span></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td valign="top"><div align="right"><strong>门票： </strong></div></td>
          <td valign="top" style="text-align:left"><span class="radioSpan">
          <input type="radio" name="tickets" value="仅大门票" />
            仅大门票 
            <input type="radio" name="tickets" value="所有门票及索道等" />
            所有门票及索道等 
            <input type="radio" name="tickets" value="自己搞定" />
            自己搞定</span></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td valign="top"><p align="right"><strong>用餐要求：<br />
              </strong></p></td>
          <td valign="top" style="text-align:left">特色： <span class="radioSpan">
            <input name="foodrequest[]" type="checkbox" value="风味餐" />
            风味餐 
            <input name="foodrequest[]" type="checkbox" value="小吃" />
            小吃 
            <input name="foodrequest[]" type="checkbox" value="火锅" />
            火锅 其它： 
            <input name="foodrequest[]" type="text"  class="easyui-textbox" /> 
            <br />
            口味： 
            <input name="taste[]" type="checkbox" value="清淡" />
            清淡 
            <input name="taste[]" type="checkbox" value="麻辣" />
            麻辣 
            <input name="taste[]" type="checkbox" value="多蔬菜" />
            多蔬菜 
            <input name="taste[]" type="checkbox" value="多肉" />
            多肉 
            <input name="taste[]" type="checkbox" value="素食" />
            素食<br />
            忌口： 
            <input name="hatefood" type="text" class="easyui-textbox"/>  有其它要求或您喜欢的餐厅可填写在个性需求里填写
            </span>
           </td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td valign="top"><div align="right"><strong>娱乐：</strong></div></td>
          <td valign="top" style="text-align:left"><span class="radioSpan"><input type="checkbox" name="recreation" value="期望体验当地民族风情表演" /></span>
                   期望体验当地民族风情表演</td>
        </tr>
        <tr> 
          <td valign="top"><div align="right"><strong>更多个性需求：</strong></div></td>
          <td valign="top" style="text-align:left">希望能知道您对这次旅游的想法和期望，这样我们更更好的为您设计：
          <textarea name="specialrequest" cols="70" rows="8" class="easyui-textbox" data-options="multiline:true" style="height:100px"></textarea></td>
        </tr>
  <!--  <tr> 
          <td valign="top"><div align="right"></div></td>
          <td valign="top" style="text-align:left"><input type="submit" name="Submit2" value="预定" /></td>
        </tr> -->
    <tr> 
        <td> <div align="right"><strong>验证码：</strong></div></td>
        <td  style="text-align:left"> <input type="text" id="verifyCode" name="verifyCode"  class="easyui-textbox" title="验证码" data-options="required:true" nullmsg="请输入验证码!"/>
          <img alt="点击更换" src="${basePath}RandomCodeServlet" id="validateCode" onclick="itour.lightselfbooking.changeValidateCode()">
          &nbsp;&nbsp;<a href="javascript:void(0)" onclick="itour.lightselfbooking.changeValidateCode()">看不清，换一张</a></td>
       <!--  <td><input name="code" id="code" type="text" size="8" />&nbsp;<img src='index.php?action=authcode&",Math.random(),"' alt="CAPTCHA" name="vcode" width="130" height="25" border="1" align="absmiddle" id='vcode' style="cursor: pointer;" title="看不清？点击更换另一个验证码。" onclick= this.src="index.php?action=authcode&"+Math.random() />&nbsp;看不清，请点击图片更换验证码。</td> -->
      </tr>
      <tr> <td></td>
          <td style="text-align:left"><a class="easyui-linkbutton"  iconcls="icon-ok" name="check_formbtn">快速预定</a></td>
      </tr>
      </table></td>
    <td width="10" background="images/default/shadowright.gif">
    <img src="images/default/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
  </form>
<script type="text/javascript" src="${basePath}js/ux/front/light/selfbooking.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
