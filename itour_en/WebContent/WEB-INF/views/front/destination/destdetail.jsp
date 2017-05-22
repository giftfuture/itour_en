<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<title>目的地详情</title>
<link rel="stylesheet" type="text/css" href="${basePath}css/easing.css">
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.easing.compatibility.js"></script> 
<link rel="stylesheet" type="text/css" href="${basePath}css/ScrollPic.css">
<script type="text/javascript" src="${basePath}js/commons/ScrollPic.js"></script>
</head>
<body>
<center>
<%@include file="/front/header.jsp"  %> 
<table class="commontb" valign="middle" style="height:100%">
  <tr style="align:center">
    <td style='weight:100%;height:100%;' valign="top" rowspan=2>
            <div style="align:center;font-size:18px;background-color:#8B0000;text-decoration:none;color:white" >旅遊目的地</div>
            <div class="treebox">
				<ul class="menu">
				<c:forEach items="${scopes}" var="scope" varStatus="status">
					<li class="level1">
						<a href="javascript:void(0)"><%-- <em class="ico ico${status.index + 1}"></em> --%><c:out value="${scope.value}"></c:out><i class="down"></i></a>
						<ul class="level2">
							<c:forEach items="${items}" var="item">
								<c:if test="${scope.key==item.scope }">
									<li><a href="${basePath }destination/detail/${item.alias}"><c:out value="${item.item}"></c:out></a></li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
				</ul>
			</div></td>
            <td  style='weight:100%;height:100%;'><!--滚动图片 start-->
        	<img src="${basePath}${itemvo.cover}" style="border:none;" border="0px" height="900" width="900"/>
			<DIV class=rollphotos>
			<DIV class=blk_29>
			<DIV class=LeftBotton id=LeftArr>
			<img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
			<DIV class=Cont id=ISL_Cont_1><!-- 图片列表 begin -->
			<c:forEach items="${photos}" var="photo">
				<DIV class=box>
				<a class=imgBorder target=_blank><IMG height=84 alt="landscape" src="${basePath }${photo}" width=124 border=0></a> 
				</DIV>
			</c:forEach>
			<!-- 图片列表 end --></DIV>
			<DIV class=RightBotton id=RightArr><img src="${basePath}images/arrow01-2.gif" width="20" height="40" /></DIV></DIV>
			<script language="javascript" type="text/javascript">
					<!--//--><![CDATA[//><!--
					var scrollPic_02 = new ScrollPic();
					scrollPic_02.scrollContId   = "ISL_Cont_1"; //内容容器ID
					scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
					scrollPic_02.arrRightId     = "RightArr"; //右箭头ID
					scrollPic_02.frameWidth     = 908;//显示框宽度
					scrollPic_02.pageWidth      = 152; //翻页宽度
					scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
					scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
					scrollPic_02.autoPlay       = false; //自动播放
					scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)
					scrollPic_02.initialize(); //初始化
					//--><!]]>
			</script>
			</DIV>
<!--滚动图片 end--></td>
            <td style="valign:top;vertical-align:top;"><img src="images/ticket.png" width="30" height="30">
            <span class="STYLE3">${itemvo.item}门票信息（CNY）：</span><br/>
            ${itemvo.ticketsBlock}<br/><span class="h2-24"><img src="images/route2.png" width="48" height="48"></span>
		<span class="STYLE3">相关旅游线路</span>
		<table width="280" border="0" cellpadding="5" cellspacing="0" class="f14-gao1">
              <tbody>
              <c:forEach items="${rts}" var="item">
              <tr>
                <td style="text-align:right"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}"><img src="${basePath }${item.cover}" width="91" height="50"></a></td>
             <!- width="66" width="384" class="f12-gao1"--> 
               <td style="text-align:left"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}">【${item.travelStyleType}】${item.title}</a></td>
              </tr>
        	</c:forEach>
              <tr>
                <td><a href="${basePath }destination/related/${itemvo.alias}">More》》</a></td>
                <td>&nbsp;</td>
              </tr>
          </tbody></table></td>
          </tr>
          <tr>
            <td valign="top"  style="weight:100%;height:100%;text-align:left;valign:top;">
            ${itemvo.content }
		</td><td><%-- <span class="h2-24"><img src="images/route2.png" width="48" height="48"></span>
		<span class="STYLE3">相关旅游线路</span>
		<table width="280" border="0" cellpadding="5" cellspacing="0" class="f14-gao1">
              <tbody>
              <c:forEach items="${rts}" var="item">
              <tr>
                <td style="text-align:right"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}"><img src="${basePath }${item.cover}" width="91" height="50"></a></td>
             <!- width="66" width="384" class="f12-gao1"--> 
               <td style="text-align:left"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}">【${item.travelStyleType}】${item.title}</a></td>
              </tr>
        	</c:forEach>
              <tr>
                <td><a href="${basePath }destination/related/${itemvo.alias}">More》》</a></td>
                <td>&nbsp;</td>
              </tr>
          </tbody></table> --%>
		</td>
	  	 </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/destination/destdetail.js"></script>
<%@include file="/front/footer.jsp"  %>
</center>
</body>
</html>
