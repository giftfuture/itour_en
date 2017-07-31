<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>SelfDrive trip in detail</title>
<%-- <link rel="stylesheet" href="${basePath}css/easyzoom/example.css" /> --%>
<link rel="stylesheet" href="${basePath}cssm/easyzoom/pygments.css" />
<link rel="stylesheet" href="${basePath}cssm/easyzoom/easyzoom.css" />  
<link rel="stylesheet" href="${basePath}cssm/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}cssm/bootstrap/qunit-1.11.0.css" />  
<link rel="stylesheet" type="text/css" href="${basePath}cssm/ScrollPic.css">
<script type="text/javascript" src="${basePath}jsm/commons/ScrollPic.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/easing.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/easyzoom.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/easytab/jquery.easytabs.min.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/easytab/jquery.hashchange.min.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/bootstrap/qunit-1.11.0.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/zeroclip/ZeroClipboard.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/zeroclip/ZeroClipboard.swf"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/pdf/html2canvas.min.js"></script>
<script type="text/javascript" src="${basePath}jsm/plug-in/pdf/jspdf.min.js"></script>

<script type="text/javascript">

</script>
</head>
<body>

<center>
<table class="commontb" align="center" width="100%" style="width:100%;text-align:center;float:middle" >
  <tr><td><%@include file="/frontm/header.jsp"  %> </td></tr>  
  <tr>
    <td width="60%" style="float:middle" class="h1-black">${rt.title}</td><td><input type="hidden" name="idrt" value="${rt.routeCode}"></td>
  </tr>
    <tr><td><!-- <h3>直接使用百度分享</h3>   -->
<div class="bdsharebuttonbox">
<a href="#" class="bds_more" data-cmd="more"></a> 
 <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
 <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
 <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a> 
 <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a></div>  
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},
        "share":{},"image":{"viewList":["weixin","tsina","qzone","tqq"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["weixin","tsina","qzone","tqq"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script> </td></tr>
  <tr>
   <td>
     <table style="float:middle;text-align:center;" align="center" valign="top" >
       <tr>
        <td width="100%" name="magnifying"><img src="${basePath}${rt.cover}" style="border:none;width:100%;float:middle" border="0px" width="100%"/></td>
      </tr>
      <tr>
        <td height="69">
<div align="center">
<!--滚动图片 start-->
<DIV class=rollphotos>
<DIV class=blk_29>
<DIV class=LeftBotton id=LeftArr style="margin-right:15px" ><img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
<DIV style="margin-left:15px" class=Cont id=ISL_Cont_1><!-- 图片列表 begin -->
<c:forEach items="${rt.photoList}" var="photo">
<div class=box><A class=imgBorder target=_blank><IMG alt="landscape" src="${basePath }${photo}" border=0></A> 
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
        scrollPic_02.frameWidth     = '100%';//显示框宽度
        scrollPic_02.pageWidth      = '25%'; //翻页宽度
        scrollPic_02.speed          = 20; //移动速度(单位毫秒，越小越快)
        scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
        scrollPic_02.autoPlay       = true; //自动播放
        scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)
        scrollPic_02.initialize(); //初始化
        //--><!]]>
</SCRIPT>
</DIV>
<!--滚动图片 end-->
</div>
      </td></tr></table></td>
</tr>
<!-- </table>
<table class="commontb" align="center" width="100%"  style="width:100%;text-align:center;float:middle" > -->
<tr>
 <td style="text-align:center;float:middle;"> 
     <table style="text-align:center;float:middle; " align="center">
      <tbody><tr>
        <td style="float:middle;" align="center"><img src="images/frame2-1.gif" height="7"></td>
      </tr>
    <tr>
        <td background="images/frame2-2.gif"><table cellspacing="0" cellpadding="0" border="0" align="center">
          <tbody><tr>
            <td><div align="center"><span class="STYLE2">Is this Line for me？</span></div></td>    
          </tr>
          <tr>
            <td><table class="STYLE126" width="100%" cellspacing="2" cellpadding="4" border="0">
              <tbody><tr>          <td class="STYLE126"><div align="right"><strong>Type</strong></div></td>
          <td class="STYLE126" style="text-align:left"><strong>${rt.travelStyle} </strong><a href="javascript:void(0)" title="${rt.travelStyle}"> </a></td>
        </tr>
        <tr>
          <td width=" " class="STYLE126"><div align="right"><strong>Line number</strong></div></td>
          <td width=" " class="STYLE126" style="text-align:left">${rt.routeCode}</td>
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
             <img src="${basePath}images/shoe-1.gif"  style="width:16;height:16;" width="16" height="16" />
          </c:forEach>
          <c:forEach items="${rt.undiffRate}" var="rd">
             <img src="${basePath}images/shoe-2.gif" style="width:16;height:16;" width="16" height="16" />
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
        <td colspan=2><span class="STYLE148" style="text-align:left;float:left;">
        Note: The needs of each group are different, according to your holiday to re-adjust the design process.</span></td>
        </tr>
      </table>
    <table class="f12-gao1">
      <tr>
        <td><img src="${basePath}images/facebook.png" style="width:24;height:24;" />
        <a target="_blank" href="https://www.facebook.com/dialog/feed">FB</a></td>
        <td><img src="${basePath}images/share.png"  style="width:24;height:24;"/>
        <a target="_blank" id="copyurl" href="javascript:void(0)" data-clipboard-target="flashcopier">CopyUrl</a><div style="display:none" id="flashcopier"></div></td>
        <td><img src="${basePath}images/favorite01.png"  style="width:24;height:24;"/>
        <a target="_blank"  href="javascript:itour.hiking.addFavorite()" rel="sidebar">Bookmark </a></td>
        <td><img src="${basePath}images/print.png"  style="width:24;height:24;"/>
        <a target="_blank"  href="javascript:itour.hiking.printff()">Print</a></td></tr>
            <%--  <tr><td><a href="${basePath}climb/toQuote2/${rt.alias}" class="easyui-linkbutton" >预定本路线</a></td></tr>     --%>
    </table></td>
  </tr></tbody></table>
    </td>
  </tr>
 <tr>
    <td style="float:left"><img src="images/frame2-3.gif"  height="7"></td>
  </tr>
  </tbody>
</table>
</td></tr>
  <tr><td style="text-align:center;float:middle;width:100%;" align="center"> 
<div class="frametb" id="tab-container" class='tab-container' width="100%"  style="width:100%;text-align:center;float:middle" >

 <ul style="text-align:left;float:left" class='etabs'>
   <li width="15%" bgcolor="#F0F0F0" class='tab' style="margin:-5"><a href="${basePath}selfdrive-selfdrive-${alias}#review" target="_self">Overview</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab' style="margin:-5"><a href="${basePath}selfdrive-selfdrive-${alias}#detail-route" target="_self">Route Details</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab' style="margin:-5"><a href="${basePath}selfdrive-selfdrive-${alias}#need-know" target="_self">Before Instructions</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab' style="margin:-5"><a href="${basePath}selfdrive-selfdrive-${alias}#feed-back" target="_self">Feedback</a></li>
  <!--  <li width="110" bgcolor="#F0F0F0" class='tab'><a href="#consulting">咨询预定</a></li> -->
 </ul>
 <div class='panel-container'>
 <div id="review" name="review">
  <table  class="frametb" align="center">
  <tr>
    <td  width="100%" style="align:left;float:left"><img src="${basePath}images/frame1-1.gif" width="100%" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif"width="100%"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="40%" valign="top" class="STYLE126" style="text-align:left"><span class="STYLE3">design concept</span><span class="STYLE2">:</span><br />
          ${rt.designConcept }
          <span class="STYLE148"><strong>iTour travel team customization service:</strong><br />
          ${rt.customizedService }</span>
        </td>
        <td width="60%" valign="top" class="STYLE126"><div align="center"><span class="STYLE3">Travel map</span><br />
            <div class="easyzoom easyzoom--overlay">
                <a href="${basePath}images/map-002.jpg">
                    <img src="${basePath}images/map-002.jpg" alt="" width="100%"  />
                </a>
            </div>
          </div>
        </td>
      </tr>
    </table>
    </td>
    </tr>
     <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr> 
    </table>
  </div>
  <div id="detail-route" name="detail-route">
  <table class="frametb" align="center">
  <tr>
    <td colspan=2><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span> 
    <span class="h2-24" style="float:left"><span class="STYLE148">Brief schedule</span></span></td>
  </tr>
    <tr>
    <td width="100%" style="text-align:left;align:left;float:left"><img src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan="2" background="images/frame1-2.gif">${qf.showTrip }</td></tr>   
  <tr>
  <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>   
  <tr>
    <td colspan=2><span class="h2-24" style="float:left"><img src="${basePath}images/detail.png" width="32" height="32" /></span>
    <span class="h2-24" style="float:left"><span class="STYLE148">Detailed schedule</span></span></td>
  </tr>
  <tr><td colspan="2" background="images/frame1-2.gif">${qf.agodaDetail }</td></tr>
  <tr> <td colspan="2" style="text-align:left"><span class="STYLE7">Note: The above itinerary is for reference only and can be re-adjusted according to your holiday design.</span></td> </tr>
</table>
  </div>
  <div id="need-know" name="need-know">
  <table  class="frametb" align="center">
  <tr>
    <td width="32" style="text-align:left;float:left;"><img src="images/document2.png" width="32" height="32" /></td>
    <td style="text-align:left;float:left;"><span class="h2-24" style="float:left"><span class="STYLE148">Before Instructions</span></span></td>
  </tr>
  <tr>
    <td colspan=2 style="text-align:left;float:left">${rt.beforeInstruction }</td>
  </tr>
    <tr>
    <td style="float:left"><img src="${basePath}images/heart02.png" width="32" height="32"  style="float:left;width:32;height:32;" /></td>
    <td style="float:left"><span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2" style="font-size:1em;">Service and quotation</span></span></span></span></td>
  </tr>
    <tr>
    <td colspan=2 style="text-align:left;float:left;">${rt.serviceAndQuote }</td>
  </tr>
     <tr>
    <td colspan=2 style="float:left"><img src="${basePath}images/heart02.png" style="float:left;width:32;height:32" width="32" height="32" />
    <span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2" style="font-size:1em">Related Routes:</span></span></span></span></td>
  </tr>
  <tr>
    <td  colspan=2 width="100%" style="float:left"><img style="float:left; vertical-align:text-top;" valign="top" src="${basePath}images/frame1-1.gif" height="7" /></td>
  </tr>
  <tr><td colspan=2 style="float:left" background="images/frame1-2.gif" style="valign:top;"> 
     <c:forEach items="${rt.relates}" var="relat"><br>
     <a href="${basePath}selfdrive-selfdrive-${relat.alias}" >${relat.title }</a>
       <%-- <a href="${basePath}climb/toQuote2/${relat.alias}" class="easyui-linkbutton" >${relat.title }</a> --%>
     </c:forEach>
     </td></tr>
   <tr>
    <td colspan=2 style="float:left"><img style="float:left" src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>
<tr>
     <td colspan=2><span class="STYLE3" style="text-align:left;float:left">Tell us your needs, free planning for your program GO! </span> &nbsp;&nbsp;
     <span class="STYLE3"   style="text-align:left;float:left"><a  style="text-align:left;float:left" href="${basePath}selfdrive-selfbooking-${rt.alias}">
     <img style="float:middle" src="${basePath }images/tailor-made.gif" width="134" height="32" ></a></span></td>
   </tr>
 </tbody></table>
  </div>
  <div id="feed-back">
  <table class="frametb" align="center">
  <tr>
    <td width="32"><img src="${basePath}images/ask03.png" width="32" height="32" /></td>
    <td width="100%" style="text-align:left;float:left" ><span class="h2-24"><span class="STYLE148"><span class="STYLE14">
    <span class="STYLE2" style="text-align:left;float:left;font-size:1em;" >Would you like to know what? Come and talk to us:</span><a href="#"></a></span></span></span></td>
  </tr>
</table>
<table  class="frametb" align="center">
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-1.gif" width="100%" height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif">
    <form name="fastask"  class="ui-form">
    <table class="frametb" align="center">
        <tr>
          <td width="31%" valign="top"><table width="357" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
              <tr>
                <td height="30" colspan="2" bgcolor="#CCCCCC" class="STYLE140"><div align="center" class="STYLE3">Quick inquiry</div>
                    <div align="center"></div></td>
              </tr>
              <tr>
                <td width="51" bgcolor="#F0F0F0" class="STYLE140"><div align="right" class="STYLE126"><strong>*Name</strong>:</div></td>
                <td width="249" bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><input type="text" name="name"  class="easyui-textbox" data-options="height:22,prompt:'Please type your name',validType:'string'"/><!--  -->
                    <select name="sex" id="sex" class="easyui-combobox" data-options="width:60,height:22,editable:false,panelHeight:80">
                      <option value="1">Mr</option>
                      <option value="0">Ms</option>
                    </select>
                    
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
                <td bgcolor="#F0F0F0" class="STYLE140"><strong>Verification code:</strong></td>
                <td bgcolor="#F0F0F0" class="STYLE126" style="padding-left:20px;text-align:left"><div class="tip">
                <input type="text" id="verifyCode" class=" easyui-textbox" title="Verification code" name="verifyCode"  data-options="height:22,prompt:'Please type in the correct verification code!'"/><br/>
                <img alt="Click to replace" src="${basePath}ImageServlet" id="validateCodeImg" style="width:65;height:23" onclick="document.getElementById('validateCodeImg').src='${basePath}ImageServlet?'+Math.random()">
               <br/><a href="javascript:void(0)" onclick="document.getElementById('validateCodeImg').src='${basePath}ImageServlet?'+Math.random()">Can not see, change one</a>
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
     
        </tr>
      </table></form></td>
  </tr>
 <tr><td>
   <table  class="frametb" align="center">
        <div id="fbcontent"></div>
   </table>
  </td></tr>
  <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-3.gif" width="100%" height="7" /></td>
  </tr>
   <tr>
    <td style="text-align:center"><ul id='fbpage'></ul></td>
  </tr>
</table>
  </div>
<!--   <div id="consulting" style="display:none;">
  </div> -->
  </div>
  </div>
  </td></tr>
      <tr><td><%@include file="/frontm/footer.jsp" %></td></tr>
</table>

<script type="text/javascript" src="${basePath}jsm/ux/front/selfdrive/detail.js"></script>
 
</center>
</body>
</html>



