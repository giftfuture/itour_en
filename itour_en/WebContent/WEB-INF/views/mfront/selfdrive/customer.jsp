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
.STYLE134 {font-size: 24px}
-->
</style>
</head>
<BODY>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="189" height="48"><img src="image/header_00.jpg" width="160" height="96" /></td>
    <td width="771"><div align="right"> How to Pay | Feedbacks &amp; Reviews | News |<br />
      Phone 02899877848778 Mail£ºifno@itours.com.cn</div></td>
  </tr>
</table>
<table width="960" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="title">
  <tr>
    <td width="623" height="30" bgcolor="#999999"><div align="center" class="right">
      <table border="0" align="center" cellpadding="10" cellspacing="0">
        <tr>
          <td bgcolor="#EFEFEF" class="headline">Home</td>
          <td class="headline"><a href="Hiking-trekking-china.html">Hiking &amp;Trekking</a></td>
          <td class="headline"><a href="offroad.html">Self-Drive</a></td>
          <td class="headline"><a href="Classic.html">Sightseeing</a></td>
          <td class="headline"><a href="Customized-Tours.html">Tailor-made</a></td>
          <td class="headline">Destinations</td>
          <td class="headline"><a href="aboutus.html">Why Us</a></td>
        </tr>
      </table>
    </div></td>
  </tr>
</table>
<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><span class="f12"><br />
        <strong> 基本资料</strong><br />
____________________________________________________________________________________________ <br />
<br /> 
</span><span class="f12"><br />
<br />
................................................................................<br />
<input type="submit" name="Submit" value="修改" />
<input type="reset" name="Submit3" value="重置" />
<br />
<br />
</span></td>
  </tr>
</table>
<br />
<br />
<table width="960" height="60" border="0" align="center" cellpadding="0" cellspacing="0" class="title">
  <tr>
    <td width="623" height="30" bgcolor="#EFEFEF"><div align="center">Southwest-China-Adventures.com</div></td>
  </tr>
  <tr>
    <td height="30" bgcolor="#EFEFEF" class="TP05"><div align="center"> Add: Huaqiao Building, #15 South Three Sections of Yihuan Road, Chengdu, Sichuan, China<br />
      Tel: +86-28-85580038 / 85562905 <br />
      E-mail: olivierwagemans@hotmail.com </div></td>
  </tr>
</table>
</body>
</html>
