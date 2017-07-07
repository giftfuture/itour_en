<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page"> 
<title>Destination details</title>
<link rel="stylesheet" type="text/css" href="${basePath}css/easing.css">
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/jquery.easing.compatibility.js"></script> 
<link rel="stylesheet" type="text/css" href="${basePath}css/ScrollPic.css">
<script type="text/javascript" src="${basePath}js/commons/ScrollPic.js"></script>
</head>
<body>
<center>

<table class="commontb" valign="middle" style="height:100%">
<tr><td colspan=3> <%@include file="/front/header.jsp"  %></td></tr>
  <tr style="align:center">
    <td valign="top" rowspan=2 style="text-align:center" align="center">
            <div  style="float:middle;display:inline-block;valign:top;text-align:center;align:center;font-size:18px;background-color:#8B0000;text-decoration:none;color:white;width:202px;height:30px;"  >Vacation destination</div>
            <div class="treebox">
                <ul class="menu">
                <c:forEach items="${scopes}" var="scope" varStatus="status">
                    <li class="level1" style="width:100%">
                        <a style="width:100%" href="javascript:void(0)"><%-- <em class="ico ico${status.index + 1}"></em> --%><c:out value="${scope.value}"></c:out><i class="down"></i></a>
                        <ul class="level2" style="width:100%">
                            <c:forEach items="${items}" var="item">
                                <c:if test="${scope.key==item.scope }">
                                    <li style="width:100%"><a style="float:left" href="${basePath }destination/detail/${item.alias}"><c:out value="${item.item}"></c:out></a></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
                </ul>
            </div></td>
            <td  valign="top" style="width:600;height:338;text-align:left"><!--滚动图片 start-->
        <div style="border:none;text-align:center;width:600;height:338;" align="center">
            <img src="${basePath}${itemvo.cover}" style="border:none;" border="0px" height="338" width="600"/></div>
            <DIV class=rollphotos>
            <DIV class=blk_29>
            <DIV class=LeftBotton id=LeftArr>
            <img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
            <DIV class=Cont id=ISL_Cont_1><!-- 图片列表 begin -->
            <c:forEach items="${photos}" var="photo">
                <DIV class=box>
                <a class=imgBorder target=_blank><IMG height=55 alt="landscape" src="${basePath }${photo}" width=100 border=0></a> 
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
                    scrollPic_02.autoPlay       = true; //自动播放
                    scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)
                    scrollPic_02.initialize(); //初始化
                    //--><!]]>
            </script>
            </DIV>
<!--滚动图片 end--><span style="text-align:left;">${itemvo.content }</span> </td>
            <td style="text-align:center;valign:top;vertical-align:top;align:center;display:inline-block;"><img src="images/ticket.png" width="30" height="30">
            <span class="STYLE3">${itemvo.item}Ticket information(CNY)：</span><br/>
           <span style="padding-left:30px;text-align:center;valign:top;vertical-align:top;display:inline-block;" align="center" >${itemvo.ticketsBlock}</span><br/><br/><br/><br/>
           <span class="h2-24"><img src="images/route2.png" width="48" height="48"></span>
        <span class="STYLE3">Related tourist routes</span>
        <table width="435" border="0" cellpadding="5" cellspacing="0" class="f14-gao1">
              <tbody>
              <c:forEach items="${rts}" var="item">
              <tr>
                <td style="text-align:right"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}"><img src="${basePath }${item.cover}" width="91" height="50"></a></td>
               <td style="text-align:left"><a href="${basePath }${item.travelStyleAlias }/${item.travelStyleAlias }/${item.alias}">[${item.travelStyleType}]${item.title}</a></td>
              </tr>
            </c:forEach>
            <c:if test="${showMore}">
              <tr>
                <td><a href="${basePath }destination/related/${itemvo.alias}">More》》</a></td>
                <td>&nbsp;</td>
              </tr>
            </c:if>
          </tbody></table></td>
          </tr>
          <tr>
            <td valign="top"  style="weight:100%;height:100%;text-align:left;valign:top;">
        </td> 
         </tr>
</table>
<script type="text/javascript" src="${basePath}js/ux/front/destination/destdetail.js"></script>
<%@include file="/front/footer.jsp"  %>
</center>
</body>
</html>
