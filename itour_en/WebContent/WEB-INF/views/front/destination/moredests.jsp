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
<title>更多目的地</title>
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
      四川，简称“川”或“蜀”，省会成都，位于中国大陆西南腹地，东部为川东平行岭谷和川中丘陵，中部为四川盆地和成都平原，西部为川西高原，与陕西、贵州、云南、西藏、青海、甘肃、重庆诸省市交界，是国宝大熊猫的故乡。
      四川是“中国西部综合交通枢纽”、“中国西部经济发展高地”，经济总量连续多年位居西部第一[1]  。 
      四川是中国重要的经济、工业、农业、军事、旅游、文化大省。省会成都在1993年被国务院确定为中国西南地区的科技、商贸、金融中心和交通、通信枢纽[2]  。成都双流国际机场是中国第四大航空港[3]  。 
      中国人民解放军五大战区之一的西部战区机关驻四川省成都市[4]  。
      四川全省共辖1个副省级市、17个地级市、3个自治州，其中包括51个市辖区、16个县级市、112个县、4个自治县。截至2015年底，四川省户籍人口9132.6万人，常住人口8204万人[5]  。 
      四川现拥有已探明储量的矿产资源132种，占全国资源种数的70%，为全国的资源、能源大省。四川油气田已探明天然气储量超过3.8万亿立方米，位居全国第一，是川气东送的起点[6]  。因物产丰富，资源富集而被誉为“天府之国”。 
      四川是世界自然与文化遗产最多的省份，现有世界自然与文化遗产5处，列入联合国《人与生物圈计划》的自然保护区4处，世界地质公园2处。以及国家5A级景区10处，国家4A级景区130处。中国优秀旅游城市21座，中国历史文化名城8座，全国重点文物保护单位230处，中国最佳旅游城市一座。</td>
  </tr>
  <tr><td><input type="hidden" name="scope" value="${scope }"/></td></tr>
    <tr>
   <%--  <td><span class="STYLE5">${dests}</span></td> --%>
    <td colspan=3 style="text-align:left" name="dests">个目的地 </td>
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

