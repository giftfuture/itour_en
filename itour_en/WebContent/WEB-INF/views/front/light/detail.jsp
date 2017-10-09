<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>Lighttrip-${rt.title }</title>
<meta http-equiv="keywords" content="Light travel">  
<meta http-equiv="description" content="${rt.shortContent }">
<link rel="stylesheet" href="css/magiczoom.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />  
<link rel="stylesheet" type="text/css" href="${basePath}css/ScrollPic.css">
<script type="text/javascript" src="${basePath}js/commons/ScrollPic.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easytab/jquery.easytabs.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/easytab/jquery.hashchange.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/zeroclip/ZeroClipboard.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/zeroclip/ZeroClipboard.swf"></script>
<script type="text/javascript" src="${basePath}js/plug-in/pdf/html2canvas.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/pdf/jspdf.min.js"></script>
<script type="text/javascript" src="${basePath}js/plug-in/magiczoom.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<%@include file="/front/header.jsp"  %>
 <div class="bdsharebuttonbox">
<a href="#" class="bds_more" data-cmd="more"></a> 
 <a href="#" class="bds_weixin" data-cmd="weixin" title="Share to Wechat"></a>
 <a href="#" class="bds_tsina" data-cmd="tsina" title="Share to Weibo"></a>
 <a href="#" class="bds_qzone" data-cmd="qzone" title="Share to Qzone"></a> 
 <a href="#" class="bds_tqq" data-cmd="tqq" title="Share to Tencent weibo"></a>
 <a href="#"  class="bds_fbook" data-cmd="fbook" title="Share to Facebook"></a>
<a href="#"  class="bds_twi" data-cmd="twi" title="Share to twitter"></a></div>  
<center>
<table  id="main-content" class="frametb" align="center"><!--  width="1350px" -->
  <tr>
    <td><input type="hidden" name="idrt" value="${rt.routeCode}"></td>
  </tr>
  <tr>
    <td width="56.7%" style="paddingg-top:30"><table style="float:right;text-align:right;align:right;margin-right:50px;" border="0" cellpadding="0" cellspacing="0">
      <tr><td style="float:middle" class="h1-black">${rt.title}</td></tr>
      <tr>
        <td name="magnifying">
        <div class="bigImage"><img src="${basePath}${rt.cover}" style="border:none;" border="0px" /></div></td>
      </tr>
      <tr>
        <td height="69"><table border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
<div align="center">
<!--滚动图片 start-->
<DIV class=rollphotos>
<DIV class=blk_29>
<DIV class=LeftBotton id=LeftArr><img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
<DIV style="margin-left:15px" class=Cont id=ISL_Cont_1><!-- 图片列表 begin -->
<c:forEach items="${rt.photoList}" var="photo">
<div class=box><A class=imgBorder target=_blank><IMG height=55 alt="landscape" src="${basePath }${photo}" width=100 border=0></A> 
</div>
</c:forEach>
<!-- 图片列表 end --></DIV>
<DIV class=RightBotton id=RightArr><img src="${basePath}images/arrow01-2.gif" width="20" height="40" /></DIV></DIV>
<SCRIPT language=javascript type=text/javascript>
        <!--//--><![CDATA[//><!--
        var scrollPic_02 = new ScrollPic();
        scrollPic_02.scrollContId   = "ISL_Cont_1"; //内容容器ID
        scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
        scrollPic_02.arrRightId     = "RightArr"; //右箭头ID
        scrollPic_02.frameWidth     = 608;//显示框宽度
        scrollPic_02.pageWidth      = 152; //翻页宽度
        scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
        scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
        scrollPic_02.autoPlay       = false; //自动播放
        scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)
        scrollPic_02.initialize(); //初始化
        //--><!]]>
</SCRIPT>
</DIV>
<!--滚动图片 end-->
</div>
      </tr></table></td>
      </tr></table></td>
        <td width="44.3%" style="width:44.3%" valign="top" > 
      <table border="0" cellpadding="0" cellspacing="0" class="STYLE126">
      <tbody><tr>
        <td style="padding-top:30;"><img src="images/frame2-1.gif" width="480" height="7"></td>
      </tr>
<tr>
        <td background="images/frame2-2.gif"><table cellspacing="0" cellpadding="5" border="0" align="center">
          <tbody><tr>
            <td><div align="center"><span class="STYLE2">Is this Line for me？</span></div></td>    
          </tr>
          <tr>
            <td><table class="STYLE126" width="442" cellspacing="2" cellpadding="4" border="0">
              <tbody><tr>
          <td class="STYLE126"><div align="right"><strong>Type</strong></div></td>
          <td class="STYLE126" style="text-align:left"><strong>${rt.travelStyle} </strong><a href="javascript:void(0)" title="${rt.travelStyle}"> </a></td>
        </tr>
        <tr>
          <td width="70" class="STYLE126"><div align="right"><strong>Line number</strong></div></td>
          <td width="350" class="STYLE126" style="text-align:left">${rt.routeCode}</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Travel days</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.rcdDays}days<strong> </strong><a href="javascript:void(0)" title="${rt.rcdDays}"> </a></td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Highest elevation</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.mileage}meter</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Departure</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.departure }<a href="javascript:void(0)" title="${rt.departure}"> </a></td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Arrive</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.arrive }</td>
        </tr>
         <tr>
          <td class="STYLE126"><div align="right"><strong>Route</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.routeLine }</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Transportation Style</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.transportation }</td>
        </tr>
        <c:if test="${not empty rt.difficultyRate}">
        <tr>
          <td class="STYLE126"><div align="right"><strong>Walking difficulty</strong></div></td>
          <td class="STYLE126" style="text-align:left">
          <c:forEach items="${rt.diffRate}" var="dr">
             <img src="${basePath}images/shoe-1.gif" width="16" height="16" />
          </c:forEach>
          <c:forEach items="${rt.undiffRate}" var="rd">
             <img src="${basePath}images/shoe-2.gif" width="16" height="16" />
          </c:forEach>
           <a href="javascript:void(0)" title="Dark shoes logo on the difficulty level"> </a></td>
        </tr>
        </c:if>
        <c:if test="${not empty rt.trekDistance}">
        <tr>
          <td class="STYLE126"><div align="right"><strong>Walking distance </strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.trekDistance }km</td>
        </tr>
        </c:if>
         <c:if test="${not empty rt.mountStyle}">
        <tr>
          <td class="STYLE126"><div align="right"><strong>Mountain Style</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.mountStyle } <a href="javascript:void(0)" title="${rt.mountStyle}"> </a></td>
        </tr>
        </c:if>
         <tr>
        <td colspan=2 style="text-align:left"><span class="STYLE148">
         Note: The needs of each group are different, according to your holiday to  re-adjust the design process.</span></td>
        </tr>
      </table>
    <table class="f12-gao1">
      <tr>
        <%-- <td><img src="${basePath}images/facebook.png" width="24" height="24" />
        <a target="_blank" href="https://www.facebook.com/dialog/feed">FB</a></td>
        <td><img src="${basePath}images/share.png" width="24" height="24" />
        <a target="_blank" id="copyurl" href="javascript:void(0)" data-clipboard-target="flashcopier">CopyUrl</a><div style="display:none" id="flashcopier"></div></td> --%>
        <td style="text-align:left;"><img src="${basePath}images/favorite01.png" width="24" height="24" />
        <a target="_blank"  href="javascript:itouren.hiking.addFavorite()" rel="sidebar">Bookmark</a></td>
        <%-- <td><img src="${basePath}images/print.png" width="24" height="24" />
        <a target="_blank"  href="javascript:itour.hiking.printff()">Print</a></td> --%>
        </tr>
            <%--  <tr><td><a href="${basePath}climb/toQuote2/${rt.alias}" class="easyui-linkbutton" >预定本路线</a></td></tr>     --%>
    </table></td>
  </tr></tbody></table>
    </td>
  </tr>
 <tr>
    <td style="float:left"><img src="images/frame2-3.gif" width="480" height="7"></td>
  </tr>
  </tbody>
</table>
</td></tr>
</table>
<br />
<br />
<br />
<table class="frametb" align="center"><tr><td>
<div class="frametb" id="tab-container" class='tab-container' border="0" cellpadding="3" cellspacing="1">
 <ul style="text-align:left;float:left" class='etabs'>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light-${alias}#review">Overview</a></li>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light-${alias}#detail-route">Route Details</a></li>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light-${alias}#need-know">Before Instructions</a></li>
   <li width="110" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light-${alias}#show-happy">Happiness</a></li>
  <!--  <li width="110" bgcolor="#F0F0F0" class='tab'><a href="#consulting">咨询预定</a></li> -->
 </ul>
 <div class='panel-container'>
 <div id="review">
  <table  class="frametb" align="center">
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif"><table width="1140" border="0" align="center" cellpadding="10" cellspacing="0">
      <tr>
        <td width="761" valign="top" class="STYLE126" style="text-align:left"><span class="STYLE3">design concept</span><span class="STYLE2">:</span><br />
          ${rt.designConcept }
          <span class="STYLE148"><strong>iTour travel team customization service:</strong><br />
          ${rt.customizedService }</span>
        </td>
        <c:if test="${not empty rt.routeMap}">
            <td width="299" valign="top" class="STYLE126"><div align="center"><span class="STYLE3">Travel map</span><br />
                <div>
                    <a href="${basePath}${rt.routeMap}" class="MagicZoom" rel="zoom-position:top">
                        <img src="${basePath}${rt.routeMap}" alt="" width="260" height="127" />
                    </a>
                </div>
              </div>
            </td>
        </c:if>
      </tr>
    </table>
    </td>
    </tr>
     <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr> 
    </table>
  </div>
  <div id="detail-route">
  <table class="frametb" align="center">
  <tr>
    <td colspan=2 style="padding-top:30;"><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span> 
    <span class="h2-24" style="float:left"><span class="STYLE148">Brief schedule</span></span></td>
  </tr>
    <tr>
    <td width="1140" style="align:left;float:left"><img src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan="2" background="images/frame1-2.gif" style="valign:top;">${qf.showTrip }</td></tr>   
  <tr>
  <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>   
  <tr>
    <td colspan=2 style="padding-top:30;"><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span>
    <span class="h2-24" style="float:left"><span class="STYLE148">Detailed schedule</span></span></td>
  </tr>
  <tr><td colspan="2" background="images/frame1-2.gif">${qf.agodaDetail }</td></tr>
  <tr> <td colspan="2" style="text-align:left"><span class="STYLE7">Note: The above itinerary is for reference only and can be re-adjusted according to your holiday design.</span></td> </tr>
</table>
  </div>
  <div id="need-know">
  <table  class="frametb" align="center">
  <tr>
    <td colspan=2 style="text-align:left;float:left;padding-top:30;"><img src="images/document2.png" width="32" height="32" />
    <span class="h2-24"><span class="STYLE148">Before Instructions</span></span></td>
  </tr>
  <tr>
    <td colspan=2 style="text-align:left">${rt.beforeInstruction }</td>
  </tr>
    <tr>
    <td colspan=2 style="float:left;padding-top:30;"><img style="float:left" src="${basePath}images/heart02.png" width="32" height="32" />
    <span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2">Service and quotation</span></span></span></span></td>
  </tr>
    <tr>
    <td colspan=2>${rt.serviceAndQuote }</td>
  </tr>
   <tr>
    <td colspan=2 style="float:left;padding-top:30;"><img style="float:left" src="${basePath}images/heart02.png" width="32" height="32" />
    <span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2">Related Routes</span></span></span></span></td>
  </tr>
  <tr>
    <td  colspan=2 width="1140" style="float:left"><img style="float:left; vertical-align:text-top;" valign="top" src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan=2 style="float:left" background="images/frame1-2.gif" style="valign:top;"> 
     <c:forEach items="${rt.relates}" var="relat"><br>
     <a href="${basePath}light-${relat.alias}" >${relat.title }</a>
       <%-- <a href="${basePath}climb/toQuote2/${relat.alias}" class="easyui-linkbutton" >${relat.title }</a> --%>
     </c:forEach>
     </td></tr>
   <tr>
    <td colspan=2 style="float:left"><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
</table>
  <table  class="frametb" align="center">
   <tbody><tr>
     <td colspan=2 style="text-align:left;float:left;padding-top:30;" ><span class="STYLE3" style="text-align:left;float:left">Tell us your needs, free planning for your program GO! </span> &nbsp;&nbsp;
     <span class="STYLE3"  style="text-align:left;float:left"><a href="${basePath}light-selfbooking-${rt.alias}">
     <img src="${basePath }images/tailor-made.gif" width="134" height="32" ></a></span></td>
   </tr>
 </tbody></table>
  </div>
  <div id="feed-back">
  <table  class="frametb" align="center">
  <tr>
    <td  colspan=2 style="text-align:left;float:left;"><img src="${basePath}images/ask03.png" width="32" height="32" />
    <span class="h2-24"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2" style="text-align:left;float:left" >Would you like to know what? Come and talk to us:</span><a href="#"></a></span></span></span></td>
  </tr>
</table>
<table  class="frametb" align="center">
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif">
    <form name="fastask"  class="ui-form">
    <table width="1140" border="0" align="center" cellpadding="10" cellspacing="0">
        <tr>
          <td width="357" valign="top"><table width="357" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
              <tr>
                <td height="30" colspan="2" bgcolor="#CCCCCC" class="STYLE140"><div align="center" class="STYLE3">Quick inquiry</div>
                    <div align="center"></div></td>
              </tr>
              <tr>
                <td width="51" bgcolor="#F0F0F0" class="STYLE140"><div align="right" class="STYLE126"><strong>*Name</strong>:</div></td>
                <td width="249" bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><input type="text" name="name"  class="easyui-textbox" data-options="height:22,prompt:'Please type your name',validType:'string'"/><!--  -->
                    <select name="sex" id="sex" class="easyui-combobox" data-options="height:22,width:80,editable:false,panelHeight:80">
                      <option value="1">Mr</option>
                      <option value="0">Ms</option>
                    </select>
                    <label></label>
                </td>
              </tr>
              <tr>
                <td bgcolor="#F0F0F0" class="STYLE140"><div align="right" class="STYLE126"><strong>*Email</strong>:</div></td>
                <td bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><input type="text" class="easyui-textbox" name="email" data-options="height:22,prompt:'Please type a legal email',validType:'email'"/>
                    <!-- <a href="javascript:void(0)" title="合法的电子邮箱">Explains</a>&gt;&gt;  --></td>
              </tr>
              <tr>
                <td bgcolor="#F0F0F0" class="STYLE140"><div align="right"><strong>Mobile Phone</strong>:</div></td>
                <td bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><input type="text" name="mobile"  class="easyui-numberbox" data-options="height:22,prompt:'Please type your contact number'"/>
                    <!-- <a href="javascript:void(0)" title="合法且正在使用的11位大陆手机号码">Explains</a>&gt;&gt; --> </td>
              </tr>
          <!--     <tr>
                <td bgcolor="#F0F0F0" class="STYLE140"><div align="right"><strong>标题</strong>:</div></td>
                <td bgcolor="#F0F0F0" class="STYLE140"><label>
                  <input type="text" name="title" />
                </label></td>
              </tr> -->
              <tr>
                <td bgcolor="#F0F0F0" class="STYLE140"><div align="right"><strong>Content</strong>:</div></td>
                <td bgcolor="#F0F0F0" class="STYLE140" style="padding-left:20px;text-align:left">
                   <textarea name="content" cols="30" rows="5" class="easyui-textbox" data-options="multiline:true,width:205,height:89,prompt:'What would you say ...'"></textarea>
                </td>
              </tr>
              <tr>
                <td bgcolor="#F0F0F0" class="STYLE140">Verification code</td>
                <td bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><div class="tip">
                <input type="text" id="verifyCode" class=" easyui-textbox" title="Verification code" name="verifyCode"  data-options="height:22,prompt:'Please type in the correct verification code!'"/><br/>
                <img alt="Click to replace" src="${basePath}ImageServlet" id="validateCodeImg" onclick="document.getElementById('validateCodeImg').src='${basePath}ImageServlet?'+Math.random()">
                &nbsp;&nbsp;<a href="javascript:void(0)" onclick="document.getElementById('validateCodeImg').src='${basePath}ImageServlet?'+Math.random()">Can not see, change one</a>
      </div></td>
              </tr>
              <tr>
                <td colspan=2 bgcolor="#F0F0F0" class="STYLE140"><a class="easyui-linkbutton" iconcls="icon-ok" name="SubmitSend" >Ask</a></td>
              </tr>
              <tr>
                <td bgcolor="#F0F0F0" class="STYLE140" colspan=2><input type="hidden" name="route" value="${rt.routeCode}"/>
               *We will keep your information confidential.</td>
              </tr>
          </table></td>
          <td width="733" valign="top"><div>
                <div id="fbcontent"></div>
            </div>
            </td>
        </tr>
      </table></form></td>
  </tr>
  <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
   <tr>
    <td style="text-align:center"><ul id='fbpage'></ul></td>
  </tr>
</table>
  </div>
<div id="show-happy" name="show-happy">
    <table style="margin-bottom:30"><tr>
    <td colspan=2 style="float:left"><img style="float:left" src="${basePath}images/heart02.png" width="32" height="32" />
    <span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2">Memories of happiness will be happy freeze</span></span></span></span></td>
  </tr>
  <tr>
    <td colspan=2 width="1140"><img style="float:left;vertical-align:text-top;" valign="top" src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan=2 background="images/frame1-2.gif"> 
                <table width='100%' border='0' align='center' cellpadding='10' cellspacing='0'> 
                            <tr> 
                              <td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='20'> 
                                   <tr> 
                                    <td style='width:26.8%'><table  border='0' align='center' cellpadding='0' cellspacing='0'> 
                                      <tr>
                                        <td><table border='0' cellspacing='0' cellpadding='0'>
                                            <tr>
                                              <td style='width:100%;'><a href='${basePath}showhappy-detail-${shvo.shCode}'><img src='${basePath}${shvo.cover}' width='100%' /></a></td>
                                              <td width='11' rowspan='2' valign='bottom'><img src='${basePath}images/tu-k-02.gif' width='11' height='122' /></td>
                                            </tr>
                                            <tr>
                                              <td><div align='right'><img src='${basePath}images/tu-k-01.gif' width='191' height='9' /></div></td>
                                            </tr>
                                        </table></td>
                                      </tr>
                                    </table></td>
                                    <td width='73.2%' valign='bottom'><table width='100%' border='0' cellpadding='2' cellspacing='2' class='STYLE126'>
                                      <tr>
                                        
                                        <td style='text-align:left'><span class='STYLE19'>${shvo.title} </span><span class='STYLE22'>${shvo.tourTime}</span></td>
                                      </tr>
                                      <tr>
                                        <td width='100%' style='text-align:left'><span class='STYLE18'>${shvo.shortContent}<a href='${basePath}showhappy-detail-${shvo.shCode}'>Walk into her memory</a>》》<img src='images/quote-2.gif' width='18' height='14' /></span></td>
                                      </tr>
                                      <tr>
                                        <td style='text-align:right'><div class='STYLE20'>${shvo.signature} From ${shvo.areaname}</div></td>
                                      </tr>
                                    </table></td>
                                  </tr>
                                </table>
                                  <div>
                                </div>
                              </td>
                            </tr>
						    <tr>
						      <td valign="top"><span class="STYLE126"><a href="${basePath}showhappy">More Memories》》</a></span></td>
						    </tr>
                          </table>
   </td></tr>
   <tr>
    <td colspan=2><img style="float:left" src="images/frame1-3.gif" width="1140" height="7" /></td>
  </tr>
  </table>
  </div>
  </div>
  </div></td></tr></table>
  <table class="frametb" align="center">
   <tr><td><%@include file="/front/footer.jsp" %></td></tr></table>
<script type="text/javascript" src="${basePath}js/ux/front/light/detail.js"></script>
</center>
</body>
</html>



