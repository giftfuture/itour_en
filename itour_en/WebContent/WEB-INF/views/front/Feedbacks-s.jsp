<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%    
String path = request.getContextPath();    
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。    
pageContext.setAttribute("basePath",basePath);    
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href=" <%=basePath%>">
 <meta http-equiv="pragma" content="no-cache">  
 <meta http-equiv="cache-control" content="no-cache">  
 <meta http-equiv="expires" content="0">      
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Southwest-China-Adventures.com</title>
<meta name="keywords" content="Southwest China Adventures:Trekking & Hiking , Peak Climbing , Off raod¡¡overland, Motercycle tours ">
<meta name="description" content="Southwest China Adventures Trekking,Southwest China Peak Climbing,Southwest China Off raod,Southwest China Motercycle tours">
<script type="text/javascript" src="Scripts/flashobject.js"></script>
<script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
<link href="css/qzx.css" rel="stylesheet" type="text/css" />
<link href="css/bodylink.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
.STYLE126 {font-size: 14px}
.STYLE131 {color: #333333}
.STYLE140 {color: #666666}
.STYLE144 {color: #FFFFFF}
.STYLE144 {	font-size: 16px;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
.STYLE145 {font-size: 16px; font-weight: bold; font-family: Arial, Helvetica, sans-serif;}
.STYLE156 {color: #FF0000}
-->
</style>
</head>
<BODY><body>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="189" height="48"><img src="image/header_00.jpg" width="160" height="96" /></td>
    <td width="771"><div align="right">Destinations | How to Pay |  News |<br />
      Phone 02899877848778 Mail£ºifno@itours.com.cn</div></td>
  </tr>
</table>
<table width="900" height="60" border="0" align="center" cellpadding="0" cellspacing="0" class="title">
  <tr>
    <td width="623" height="30" background="image/menu-back1.gif"><div align="center" class="right">
      <table border="0" align="center" cellpadding="10" cellspacing="0">
        <tr>
          <td class="STYLE144">Home</td>
          <td bgcolor="#CCCCCC" class="headline"><a href="Hiking-trekking-china.html">Hiking &amp;Trekking</a></td>
          <td class="headline"><span class="STYLE144">Self-drive</span></td>
          <td class="headline"><span class="STYLE144">China Tours </span></td>
          <td class="headline"><span class="STYLE144">Tailor-made</span></td>
          <td><span class="STYLE145"><span class="STYLE144">Feedbacks</span></span></td>
          <td class="STYLE145"><span class="STYLE144">Why Us </span></td>
        </tr>
      </table>
    </div></td>
  </tr>
  <tr>
    <td height="40" bgcolor="#CCCCCC"><div align="center" class="right02"><a href="#">Tekking in Sichuan </a>| <a href="#">Trekking in Yunnan</a> | <a href="#">Trekking in Tibet </a></div></td>
  </tr>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="lefttxt">
  <tr>
    <td colspan="2"> EasyChinaTravel &gt; Feedbacks </td>
  </tr>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="5">
  <tr>
    <td><h1 align="center" class="STYLE131">Feedbacks</h1></td>
  </tr>
  <tr>
    <td><span class="title"><strong>我要反馈</strong></span>
      <table width="717" border="0" cellpadding="4" cellspacing="0">
        <tr>
          <td width="64" valign="top"><div align="left"><strong>Title:
              <br />
          </strong></div>            </td>
          <td width="637" valign="top"><input type="text" name="textfield72" />          </td>
        </tr>
        <tr>
          <td valign="top"><strong>Name: </strong></td>
          <td valign="top"><input type="text" name="textfield222" /></td>
        </tr>
        <tr>
          <td valign="top"><strong>Country:</strong></td>
          <td valign="top"><input type="text" name="textfield2222" /></td>
        </tr>
        <tr>
          <td valign="top"><strong>Itinerary:</strong></td>
          <td valign="top"><input type="text" name="textfield522" /></td>
        </tr>
        <tr>
          <td valign="top"><strong>Phone:</strong></td>
          <td valign="top"><input type="text" name="textfield623" /></td>
        </tr>
        <tr>
          <td valign="top"><strong>Email:</strong></td>
          <td valign="top"><input type="text" name="textfield6232" /></td>
        </tr>
        <tr>
          <td valign="top"><strong>Request: <br />
            <br />
          </strong></td>
          <td valign="top"><textarea name="textarea" cols="80" rows="18"></textarea></td>
        </tr>
        <tr>
          <td valign="top"><strong>Photos</strong></td>
          <td valign="top"><input type="submit" name="Submit2" value="£¿¡£¡£" /></td>
        </tr>
        <tr>
          <td valign="top">&nbsp;</td>
          <td valign="top"><span class="STYLE140"><span class="STYLE126">
            <input name="textfield23222" type="text" size="8" />
Confirm Code:3052</span></span></td>
        </tr>
        <tr>
          <td valign="top">&nbsp;</td>
          <td valign="top"><input type="submit" name="Submit" value="Send" /></td>
        </tr>
      </table>
      <br />
      <br />
<label></label>
<p class="STYLE156">注：提交后需要经过后台审核才能出现在前台 。</p>
<br />
      <br />
      <p>&nbsp;</p>    </td>
  </tr>
</table>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="lefttxt">
  <tr>
    <td height="105" valign="top" bgcolor="#666666"><strong>;lkajsdflladsf;</strong>
      <table width="883" height="60" border="0" align="center" cellpadding="0" cellspacing="0">
        <tbody>
          <tr>
            <td width="883" height="30" bgcolor="#EFEFEF"><div align="center">www.EasyChinaTravel.com</div></td>
          </tr>
          <tr>
            <td height="30" bgcolor="#EFEFEF"><div align="center">Add: Huaqiao Building, #15 South Three Sections of Yihuan Road, Chengdu, Sichuan, China<br />
              Tel: +86-28-85580038 / 85562905?<br />
              E-mail: olivierwagemans@hotmail.com</div></td>
          </tr>
        </tbody>
      </table>
    </td>
  </tr>
  <tr>
    <td width="611" valign="top" bgcolor="#666666"><strong><br />
    </strong></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
</table>
</body>
</html>
