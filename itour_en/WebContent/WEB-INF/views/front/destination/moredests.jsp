<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<title>More Destinations</title>
</head>
<body>
<table  class="commontb" align="center">
 <tr>
    <td>
	 <%@include file="/front/header.jsp"  %>
    </td>
  </tr>
</table>
<!-- <table width="100%" border="0" align="center" cellpadding="15" cellspacing="0">
  <tr>
    <td>目的地》四川》四姑娘山》四姑娘山长坪沟</td>  
  </tr>
</table> -->
<table  class="commontb" align="center">
  <tr> 
    <td style="text-align:center;float:middle" valign="top" colspan=3>
	  Sichuan, referred to as "Sichuan" or "Shu", the capital of Chengdu, located in the hinterland of the southwest of mainland China, the eastern part of the eastern Sichuan Ling and Chuanzhong hills, the central Sichuan Basin and the Chengdu Plain, western Sichuan Plateau, and Shaanxi, Guizhou, Yunnan , Tibet, Qinghai, Gansu, Chongqing provinces and cities at the junction, is the hometown of National Treasure giant panda.
      Sichuan is "China's western integrated transport hub", "China's western economic development heights", the total economy for many years ranked first in the west [1].
      Sichuan is an important economic, industrial, agricultural, military, tourism and cultural province of China. Provincial capital in 1993 by the State Council identified as China's southwestern region of science and technology, commerce, financial center and transportation, communications hub [2]. Chengdu Shuangliu International Airport is China's fourth largest airport [3].
      The People's Liberation Army one of the five major theater of the western theater in Chengdu, Sichuan Province [4].
      Sichuan province has jurisdiction over a sub-provincial city, 17 prefecture-level cities, three autonomous prefectures, including 51 municipal districts, 16 county-level cities, 112 counties, 4 autonomous counties. As of the end of 2015, Sichuan Province, population of 91.326 million people, the resident population of 82.44 million people [5].
      Sichuan now has proven reserves of 132 kinds of mineral resources, accounting for 70% of the national resources, for the country's resources, energy province. Sichuan oil and gas fields have proven natural gas reserves of more than 3.8 trillion cubic meters, ranking first in the country, is the starting point of Sichuan-East gas transmission [6]. Due to rich products, rich resources and known as the "land of abundance."
      Sichuan is the largest natural and cultural heritage of the province, the existing natural and cultural heritage of the world 5, included in the United Nations "Man and the Biosphere Plan" of the nature reserve 4, the World Geopark 2. As well as the national 5A level scenic spots 10, the national 4A level scenic area 130. China's outstanding tourist city 21, China's historical and cultural city 8, the national key cultural relics protection units 230, China's best tourist city.</td>
  </tr>
  <tr><td><input type="hidden" name="scope" value="${scope }"/></td></tr>
    <tr>
   <%--  <td><span class="STYLE5">${dests}</span></td> --%>
    <td colspan=3 style="text-align:left" name="dests">destinations </td>
  </tr>
  <tbody id="fbcontent">
 <%--   <tr>
  <c:forEach items="${list}" var="dest" varStatus="stat">
   <td align="center">
	   	<p><a href="${basePath }destination/detail/${dest.alias}">${dest.item }</a></p>
	   	<p><a href="${basePath }destination/detail/${dest.alias}"><img src="${basePath}${dest.cover}" width="450" height="309" /></a></p>
	   	<p style="text-align:left">${dest.shortContent }</p>
    </td>
     <c:if test="${stat.index != 0 && stat.index%2==0 }"></tr><tr></c:if>
  </c:forEach>
  </tr> --%>
  </tbody>
</table>
<center><ul id='fbpage'></ul></center>
<script type="text/javascript" src="${basePath}js/ux/front/destination/moredests.js"></script>
<%@include file="/front/footer.jsp"  %>
</body>
</html>

