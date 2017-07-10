<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="keywords" content="china travel">  
<meta http-equiv="description" content="${rt.title }"> 
<title>${rt.title}</title>
</head>
<body>
<div id="append_parent"></div>
<table align="center" width="100%" style="width:100%;text-align:center;float:middle"  bgcolor="#FFFFFF">
  <tr><td colspan="3"><%@include file="/frontm/header.jsp"  %></td></tr>  
  <tr> 
    <td width="5" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="5" height="8" /></td>
    <td width="177">
<div align="center"><img src="images/logo.jpg" width="160" height="96" /></div></td>
    <td width="5" background="images/default/shadowright.gif"><img src="images/default/shadowright.gif" width="5" height="8" /></td>
  </tr>
  <tr> 
    <td width="5" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="5" height="8" /></td>
    <td> <div align="center"><span class="headline"> itour Travel personality customization service</span></div></td>
    <td width="5" background="images/default/shadowright.gif"><img src="images/default/shadowright.gif" width="5" height="8" /></td>
  </tr>
<tr><td colspan="3">
 <form name="booking" method="post">
<table  align="center" style="text-align:center;float:middle"  bgcolor="#FFFFFF">
<!--   <tr>
    <td><input type="hidden" id="site_id" name="site_id" value="3" /></td>
    <td><input type="hidden" id="line_url" name="line_url" value="http://www.travel-sichuan.com/sichuan/daocheng/t-dc-01.htm" /></td></tr> -->
  <tr>
    <td width="5" background="images/default/shadowleft.gif"><img src="images/default/shadowleft.gif" width="5" height="8" /></td>
    <td> 
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="heedline1">
  
        <tr> 
          <td width="35%" align="right" style="text-align:right;width:35%"><strong>Travel routes: </strong></td>
          <td width="65%" style="text-align:left;width:65%"><input type="hidden" name="routeId" value="${rt.id }"/><strong>${rt.title }</strong> 
          <%-- <input name="routename" type="text" data-options="editable:false" class="easyui-textbox" size="80" value="${rt.title } " /> --%>
          </td>
        </tr>
        <tr> 
          <td width="35%" align="right" style="text-align:right;width:35%;"><strong>Travel date:</strong></td>
          <td  width="65%" style="text-align:left;width:65%"><input name="expectedDepart" id="expectedDepart" type="text" class='easyui-datebox' data-options="showSeconds:false, height:22,validType:'dateValided',editable:false,split:true,border:false,region:'north',onSelect:itouren.mclimbselfbooking.onChangeDate(this)" /></td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Return date:</strong></td>
          <td style="text-align:left"><input id="expectedBack" name="expectedBack" type="text" class='easyui-datebox' data-options="showSeconds:false,height:22,validType:'md[\'#expectedDepart\']',editable:false,split:true,border:false,region:'north',onSelect:itouren.mclimbselfbooking.onChangeDate(this)" />
            </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Travel Mode:</strong></td>
          <td style="text-align:left;width:65%"><select id="travelfashion" name="travelfashion" class="easyui-combobox" data-options="width:150,height:22,editable:false,panelHeight:100">
            <option value="">Please choose</option>
            <option value="Separate arrangements">Separate arrangements</option>
            <option value="Join FIT">Join FIT</option>
          </select><br/> 
          <span id="groupdiv" style="display:none">
         <!-- Group number:<input id="groupCode" type="text" class="easyui-textbox" size="80" />-->
          The date of the group:<input id="groupDate" name="groupDate" type="text" class='easyui-datebox' data-options="prompt:'--The date of the group--',height:22,validType:'dateValided',editable:false,required:true,split:true,border:false,region:'north',onSelect:itouren.mclimbselfbooking.onChangeDate(this)" />
          </span> </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Travel budget:</strong></td>
          <td style="text-align:left"><input name="budget" type="text" min=0 class="easyui-numberbox" data-options="width:150,precision:2,groupSeparator:',',height:22" />&nbsp;￥/
          &nbsp;<select id="singleorcluster" name="singleorcluster" class="easyui-combobox" data-options="height:22,editable:false,panelHeight:100">
            <option value="Per person">Per person</option>
            <option value="Per group">Per group</option>
          </select>
          <br/> (Please specify the budget for each person or the total<br/> budget for the whole group)</td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Travel requirements:<br />
             (Check) </strong></td>
          <td style="text-align:left;width:65%"><span class="radioSpan">
          <input name="travelrequest[]" type="checkbox" value="Photography mainly" />
            Photography mainly
            <input name="travelrequest[]" type="checkbox" value="Experience folk culture" />
            Experience folk culture<br/>
            <input name="travelrequest[]" type="checkbox" value="Beautiful natural scenery" />
            Beautiful natural scenery
            <input name="travelrequest[]" type="checkbox" value="Adventure challenge" />
            Adventure challenge <br /> <input name="travelrequest[]" type="checkbox" value="Family travel" />
            Family travel
            <input name="travelrequest[]" type="checkbox" value="Honeymoon travel" />
            Honeymoon travel 
            <input name="travelrequest[]" type="checkbox" value="Meeting rewards" />
            Meeting rewards<br /> <input name="travelrequest[]" type="checkbox" value="compact" /> compact
            <input name="travelrequest[]" type="checkbox" value="Comfortable and relaxed" />
            Comfortable and relaxed<br /> <input name="travelrequest[]" type="checkbox" value="By car" />By car 
            <input name="travelrequest[]" type="checkbox" value="Motorcycle" /> Motorcycle 
            <input name="travelrequest[]" type="checkbox" value="on foot" />on foot<br /> 
            <input name="travelrequest[]" type="checkbox" value="No shopping" />No shopping</span> </td>
        </tr>
        <tr>
          <td><strong>Hotel:</strong></td>
          <td style="text-align:left;width:65%"><select id="hotel" name="hotel" class="easyui-combobox" data-options="height:22,editable:false,panelHeight:200">
            <option value="">Please Choose</option>
            <option value="Luxury (best hotel)">Luxury (best hotel)</option>
            <option value="Distinguished (five-star)">Distinguished (five-star)</option>
            <option value="Comfortable (four star)">Comfortable (four star)</option>
            <option value="Economy (three stars)">Economy (three stars)</option>
            </select></td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"> <strong>Tourist guide:</strong></td>
          <td style="text-align:left;width:65%"><span class="radioSpan">
          <input type="radio" name="guide" value="Chinese" />Chinese
            <input type="radio" name="guide" value="English" />English 
            <input type="radio" name="guide" value="Cantonese" />Cantonese <br/>
            <input type="radio" name="guide" value="Other languages" />Other languages
            <span id="elseguide" style="display:none" >
            <input type="text" class="easyui-textbox"name="guide_other" id="guide_other" value=""> </span>
            <input type="radio" name="guide" value="No tour guide" />No tour guide</span> </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Whether to arrange a diet :</strong></td>
          <td style="text-align:left;width:65%"><input type="checkbox" name="foodArrange" value="Please arrange" />
          <!--   <input type="radio" name="foodrequest" value="自行安排"  />  请安排  自行安排 -->
           </td>
        </tr>
<!--         <tr> 
          <td><div align="right"></div></td>
          <td>&nbsp;</td>
        </tr> -->
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Contact name:</strong></td>
          <td style="text-align:left;width:65%"><input name="receiver" type="text" class="easyui-textbox" data-options="width:100,height:22"/> 
          <select id="gender" name="gender" class="easyui-combobox" data-options="height:22,editable:false,panelHeight:100">
              <option>Gender</option>
              <option value="1">Male</option>
              <option value="0">Female</option>
            </select> </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"> <strong>The number of people:</strong></td>
          <td style="text-align:left"><input name="adults" size="6" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:100,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
            Adult
            <br/><input name="children" size="6" min=0 class="easyui-numberbox" data-options="precision:0,groupSeparator:',',width:100,height:22 " onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" />
          Child (under 12 years old) </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Countries and regions:</strong></td>
          <td style="text-align:left;width:65%"><input id="comefrom" name="comefrom" class="easyui-combobox"  data-options="width:150,height:22,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}areas/allAreas'">
           </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>E-mail:</strong></td>
          <td style="text-align:left;width:65%"><input name="receiveremail" type='text' class="easyui-textbox" data-options="validType:'email',groupSeparator:',',width:150,height:22" /> </td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>Contact number:</strong></td>
          <td style="text-align:left;width:65%"><input name="receiverMobile" class="easyui-textbox" type="text" data-options="validType:'mobileTelephone',groupSeparator:',',width:150,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/></td>
        </tr>
   <!--      <tr> 
          <td valign="top"> <div align="right"><strong>详细要求:</strong></div></td>
          <td style="text-align:left">希望能知道您对这次旅游的想法和期望，这样我们更更好的为您设计:<br /> <textarea name="description" cols="70" rows="8" id="description"></textarea> 
          </td>
        </tr> -->
      <!-- <tr> 
          <td colspan=2>To understand your individual needs, please fill out the form below to get a more detailed personalized service. (Just tick your question or fill it out) </td>
        </tr>-->
        <tr> 
          <td  width="35%"align="right" style="text-align:right"><strong>Accommodation requirements:</strong></td>
          <td style="text-align:left;width:65%" ><label>Featured Hotels: 
          <span class="radioSpan">
            <input name="stayrequest[]" type="checkbox"  value="Cultural theme hotel" />
            Cultural theme hotel
            <input name="stayrequest[]" type="checkbox"  value="National characteristics hotel" />
            National characteristics hotel <br/>
            <input name="stayrequest[]" type="checkbox"   value="Residential experience" />
           Residential experience<br />
            Location: <br />
            <input name="position[]" type="checkbox"  value="City center" />
            City center
            <input name="position[]" type="checkbox" value="Good environment" />
          Good environment<br />
            <input name="position[]" type="checkbox" value="Be Quiet" />
           Be Quiet
            <input name="position[]" type="checkbox" value="Easy traffic" />
            Easy traffic <br />
            Room requirements:<br /> Twin room
            <input name="db_room"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
            King bed room 
            <input name="bb_room"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" />
             suite <br /><input name="suite"  size="6" type="number" min=0 class="easyui-numberbox" data-options="groupSeparator:',',width:51,height:22" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onafterpaste="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"/>
             Remark:
            <input name="hotel_no_smoking" type="checkbox" value="Smoke free" />
            Smoke free
            <input name="hotel_quiet" type="checkbox" value="Be Quiet" />
           Be Quiet<br />
            <input name="hotel_info" type="checkbox"  value="We hope that we can get hotel information" /> 
             Hope to get the information after the hotel, if you like the<br /> hotel can be filled in the individual needs</span>
           </label></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td valign="top"><strong>Traffic:
              </strong></td>
          <td  style="text-align:left;width:65%"><span class="radioSpan">Airplanes: 
            <input name="plane[]" type="radio" value="China domestic" />
            China domestic
            <input name="plane[]" type="radio" value="International" />
            International<br />
        Accommodation: 
            <input type="radio" name="shipping_space" value="First class" />
          First class
            <input type="radio" name="shipping_space" value="Business class" />
            Business class 
            <input type="radio" name="shipping_space" value="Economy class" />
            Economy class<br />
          Car: 
            <input type="radio" name="car" value="SUV" />
            SUV
            <input type="radio" name="car" value="Car" />
            Car
            <input type="radio" name="car" value="Business Car" />
            Business Car <br />
            <input type="radio" name="car" value="Tour Bus" />
            Tour Bus
            <input name="car_no_smoking" type="checkbox" value="Smoke Free" />
            Smoke Free
            <input name="car_new" type="checkbox" value="New Car" />
            New Car<br />
            Train: 
            <input type="radio" name="train" value="Hard sleeper" />
            Hard sleeper
            <input type="radio" name="train" value="Soft sleeper" />
            Soft sleeper<br />
            Cruise ship: 
            <input type="radio" name="cruise" value="Five Stars" />
            Five Stars
            <input type="radio" name="cruise" value="Four Stars" />
            Four Stars
            <input type="radio" name="cruise" value="Economy" />
            Economy</span></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td  width="35%"align="right" style="text-align:right"> <strong>Ticket: </strong></td>
          <td style="text-align:left;width:65%"><span class="radioSpan">
          <input type="radio" name="tickets" value="Only big ticket" />
            Only big ticket
            <input type="radio" name="tickets" value="All tickets and ropeway" />
            All tickets and ropeway <br/>
            <input type="radio" name="tickets" value="Get your own" />
          Get your own</span></td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td  width="35%"align="right" style="text-align:right"><p align="right"><strong>Meal requirements: </strong></p></td>
          <td valign="top" style="text-align:left">Features: <span class="radioSpan">
            <input name="foodrequest[]" type="checkbox" value="Flavor meal" />
            Flavor meal
            <input name="foodrequest[]" type="checkbox" value="snack" />
            snack
            <input name="foodrequest[]" type="checkbox" value="Hot pot" />
            Hot pot <br />other: 
            <input name="foodrequest[]" type="text"  class="easyui-textbox" data-options="height:22"/> 
            <br />
            Taste: 
            <input name="taste[]" type="checkbox" value="Light" />
            Light 
            <input name="taste[]" type="checkbox" value="Spicy" />
            Spicy 
            <input name="taste[]" type="checkbox" value="More vegetables" />
            More vegetables <br/>
            <input name="taste[]" type="checkbox" value="Succulents" />
            Succulents 
            <input name="taste[]" type="checkbox" value="Vegetarian" />
            Vegetarian<br />
            diet: 
            <input name="hatefood" type="text" class="easyui-textbox" data-options="height:22" /><br/>  There are other requirements or you like the restaurant <br/>can fill in the individual needs to fill in
            </span>
           </td>
        </tr>
        <tr><td></td><td></td></tr>
        <tr> 
          <td  width="35%"align="right" style="text-align:right"><strong>Entertainment:</strong></td>
          <td valign="top" style="text-align:left"><span class="radioSpan"><input type="checkbox" name="recreation" value="Expect experience of local ethnic customs" /></span>
             Expect experience of local ethnic customs</td>
        </tr>
        <tr> 
          <td width="35%"align="right" style="text-align:right"><strong>More personality needs:</strong></td>
          <td valign="top" style="text-align:left">Hope to know your thoughts and expectations of this tour, so that we are better for you:<br/>
          <textarea name="specialrequest" cols="50" rows="8" class="easyui-textbox" data-options="multiline:true"></textarea></td>
        </tr>
  <!--  <tr> 
          <td valign="top"><div align="right"></div></td>
          <td valign="top" style="text-align:left"><input type="submit" name="Submit2" value="预定" /></td>
        </tr> -->
    <tr> 
        <td width="35%"align="right" style="text-align:right"><strong>Verify Code:</strong></td>
        <td  style="text-align:left"> <input type="text" id="verifyCode" name="verifyCode"  class="easyui-textbox" title="verify Code" data-options="prompt:'please enter verification code!'" />
          <img alt="Click to replace" src="${basePath}RandomCodeServlet" id="validateCode" onclick="itour.climbselfbooking.changeValidateCode()">
          <br/>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="itour.climbselfbooking.changeValidateCode()">Can not see, change one</a></td>
       <!--  <td><input name="code" id="code" type="text" size="8" />&nbsp;<img src='index.php?action=authcode&",Math.random(),"' alt="CAPTCHA" name="vcode" width="130" height="25" border="1" align="absmiddle" id='vcode' style="cursor: pointer;" title="看不清？点击更换另一个验证码。" onclick= this.src="index.php?action=authcode&"+Math.random() />&nbsp;看不清，请点击图片更换验证码。</td> -->
      </tr>
      <tr> <td></td>
        <td style="text-align:left;padding-bottom:30px;"><a class="easyui-linkbutton" iconcls="icon-ok"  name="check_formbtn">Quickly book</a></td>
      </tr>
      </table></td>
    <td width="5" background="images/default/shadowright.gif">
    <img src="images/default/shadowright.gif" width="5" height="8" /></td>
  </tr>
</table>
  </form></td></tr>
  <tr><td colspan="3"><%@include file="/frontm/footer.jsp" %></td></tr>
  </table>

<script type="text/javascript" src="${basePath}jsm/ux/front/climb/selfbooking.js"></script>

</body>
</html>
