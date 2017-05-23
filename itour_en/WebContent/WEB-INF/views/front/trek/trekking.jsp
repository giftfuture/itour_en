<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>Hiking travel routes</title>
<meta name="keywords" content="Southwest China Adventures:Trekking & Hiking , Peak Climbing , Off raod¡¡overland, Motercycle tours ">
<meta name="description" content="Southwest China Adventures Trekking,Southwest China Peak Climbing,Southwest China Off raod,Southwest China Motercycle tours">
<script type="text/javascript" src="Scripts/flashobject.js"></script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="css/qzx.css" rel="stylesheet" type="text/css" />
<link href="css/bodylink.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <%@include file="/front/header.jsp"  %>
  <img src="images/climb.jpg" />
<table  class="commontb" align="center">
  <!--DWLayoutTable-->
  <tr>
    <td width="10" background="image/shadowleft.gif"><img src="image/shadowleft.gif" width="10" height="8" /></td>
    <td valign="top" class="title"><table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
         <td width="845" height="40"><p class="righttxt"><strong><font size="+3">Southwest-China-Adventures.com</font> </strong></p></td>
        <td width="115"><img src="img-test/China.jpg" width="40" height="24" /><img src="img-test/ok.gif" width="31" height="24" /><img src="img-test/Belgium.jpg" width="32" height="24" /></td>
      </tr>
    </table></td>
    <td width="10" background="image/shadowright.gif"><img src="image/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
<table  class="commontb" align="center">
  <!--DWLayoutTable-->
  <tr>
    <td width="10"><img src="${basePath}images/shadowleft.gif" width="10" height="8" /></td>
    <td class="rightlinks"><table width="960" border="0" align="center" cellpadding="0" cellspacing="0" class="lefttxt">
        <tr> 
          <td colspan="2"> Southwest-China-Adventures &gt; Trekking &gt;</td>
        </tr>
      </table>
    
      <table width="960" border="0" align="center" cellpadding="0" cellspacing="5">
        <tr> 
          <td> <h1> ${rt.title} </h1></td>
          <td><h1>Line characteristics：${rt.special }</h1></td>
        </tr>
      </table>
      <c:forEach items="${items}" var="item" >
      <table width="960" border="0" align="center" cellpadding="0" cellspacing="10" bgcolor="#CCCCCC" class="lefttxt">
        <tr>
          <td width="600" valign="top"><img src="${basePath}images/img/yading-03.jpg" width="600" height="338" /></td>
          <td width="330" valign="middle"><p class="STYLE126"><span class="STYLE129"></span><br />
            <strong><!-- *民族风情：母系氏族摩梭族，藏族风情<br />
          *沿线人迹罕致<br />
          *亚丁的三座雪山被誉为中国最美的雪山<br />
          *也可根据时间调整抵达或离开的城市<br />
          *可加入丽江、虎跳峡、梅里雪山等地的观光或徒步，依你的情况来调整日程。 --> ${item.feature }</strong></p>
            <p class="STYLE126"><span class="STYLE129">Days：</span> ${item.rcdDays}天 (8 days on foot, this trip can be adjusted to 13-25 days&nbsp;)
            　　<span class="STYLE129"><br />
Difficulty：</span>${item.difficultyRate} 　　　　<br />
<span class="STYLE129">Highest elevation：</span> ${item.mileage }meter<span class="STYLE129"><br />
Seasons：</span>${item.season}<br />
<span class="STYLE129">The number of people：</span>${item.recommandCrowd}</p>
        <!--   <p class="rightlinks"><a href="http://www.itours.com.cn/booking/booking-swca.php"><strong>开始私人定制</strong></a>&gt;&gt;</p> -->
          </td>
        </tr>
      </table>
      <table width="960" border="0" align="center" cellpadding="0" cellspacing="10" class="lefttxt">
        <tr> 
          <td width="620" valign="top"><p><br />
           ${item.item}</p>
            <p>${item.content } </p>
            <p><span class="right">Route ：</span><br />
            ${item.itinerary }</p>
            <p><br /><img src="${basePath}images/img/yading-05.jpg" width="600" height="338" /></p>
            <p><img src="${basePath}images/img/yading-02.jpg" width="600" height="338" /></p>
            <p><img src="${basePath}images/img/yading-04.jpg" width="600" height="338" /></p>
            <p><img src="${basePath}images/img/yading-01.jpg" width="600" height="338" /><br />
            </p></td>
          <td valign="top">Travel map：<br /><!-- images/img/EYmap_ChinaTours_EBC.jpg -->
            <img src="${basePath}${item.map}" width="328" height="239" /> 
            <br />
            <br />
            -------------------------------------------------------------------------------<br />
            <br />
            <p><strong><span class="STYLE130">Equipped with:</span><br />
				${item.equip}
             </strong></p>
            <p><span class="STYLE130"><strong>Not included:</strong></span><br />
             	${item.exclude }
              <br />
              </p>
              <p>
              -------------------------------------------------------------------------------<br />
              <br />
              <span class="STYLE130"><strong>Recommended equipment：</strong></span><br />
              ${item.recommandEquip }
            </p>
             </table>
             </c:forEach>
            -------------------------------------------------------------------------------<br />
            <br />
            <div>
            <form>
            <table>
            <tr><td colspan=2><strong>Please fill in the form and you will receive our reply within 48 hours!</strong></td></tr>
            <tr><td style="text-align:right">Name:</td><td><input name="name" class="easyui-textbox" data-options="required:true" style="width:150px;"/></td></tr>
            <tr><td style="text-align:right">Number of teams:</td><td><input name="teamPersons" size="10"  class="easyui-numberbox" style="width:150px;"/></td></tr>
             <tr><td style="text-align:right"> Reservation date:</td><td><input name="preferedDate" class="easyui-datetimebox ui-text" data-options="editable:false,'focus': function(){}"   style="width:150px;" size="15" /></td></tr>           
            <tr><td style="text-align:right">Mobile :</td><td><input name="mobile"  class="easyui-numberbox " data-options="prompt:'Please enter the correct phone number.',validType:'phoneNum'"  style="width:150px;"/></td></tr>
            <tr><td style="text-align:right">Email: </td><td><input class="easyui-textbox" name="email" data-options="validType:'email'" style="width:150px;"/></td></tr>
            <tr><td>Do you have a special request or doubt?</td><td></td></tr>
          	<tr><td colspan=2><textarea name="content" cols="45" rows="5"></textarea></td><td></td></tr>
             <tr><td><input type="button" value="Submit" /></td><td><input type="reset" value="Reset" /></td></tr>
            </table>  
			</form>
              </div>
              <br />
              <br />
            -------------------------------------------------------------------------------<br />
            <br />
            Related lines：<br />
           
            <c:forEach items="${rt.relates }" var="relate" >
         	   【${relate.travelStyleAlias}】${relate.title }<br />
            </c:forEach>
           <p> ..........</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p><br />
            </p></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
     </td>
    <td width="10" background="${basePath}images/shadowright.gif">
    <img src="${basePath}/images/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
<table  class="commontb" align="center">
  <!--DWLayoutTable-->
  <tr>
    <td width="10" background="${basePath}images/shadowleft.gif">
    <img src="${basePath}images/shadowleft.gif" width="10" height="8" /></td>
    <td class="rightlinks"><!--DWLayoutEmptyCell-->&nbsp;</td>
    <td width="10" background="${basePath}images/shadowright.gif">
    <img src="${basePath}images/shadowright.gif" width="10" height="8" /></td>
  </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/trek/trekking.js"></script>
<%@include file="/front/footer.jsp" %>
</body>
</html>
