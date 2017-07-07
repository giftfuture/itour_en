<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<title>Lighttripindetail</title>
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
<DIV class=LeftBotton id=LeftArr  style="margin-right:15px"><img src="${basePath}images/arrow01-1.gif" width="20" height="40" /></DIV>
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
 <td style="text-align:center;float:middle; "> 
     <table style="text-align:center;float:middle; " align="center">
      <tbody><tr>
        <td><img src="images/frame2-1.gif"   height="7"></td>
      </tr>
    <tr>
        <td background="images/frame2-2.gif"><table cellspacing="0" cellpadding="0" border="0" align="center">
          <tbody><tr>
            <td><div align="center"><span class="STYLE2">Is this Line for me？</span></div></td>    
          </tr>
          <tr>
            <td><table class="STYLE126" width="100%" cellspacing="2" cellpadding="4" border="0">
              <tbody><tr>
          <td class="STYLE126"><div align="right"><strong>Type</strong></div></td>
          <td class="STYLE126" style="text-align:left"><strong>${rt.travelStyle} </strong><a href="javascript:void(0)" title="${rt.travelStyle}">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td width=" " class="STYLE126"><div align="right"><strong>Line number</strong></div></td>
          <td width=" " class="STYLE126" style="text-align:left">${rt.routeCode}</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Travel days</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.rcdDays}days<strong> </strong><a href="javascript:void(0)" title="${rt.rcdDays}">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Highest elevation</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.mileage}meter</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Departure</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.departure }<a href="javascript:void(0)" title="${rt.departure}">Explain&gt;&gt;</a></td>
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
        <tr>
          <td class="STYLE126"><div align="right"><strong>Walking difficulty</strong></div></td>
          <td class="STYLE126" style="text-align:left">
          <c:forEach items="${rt.diffRate}" var="dr">
             <img src="${basePath}images/shoe-1.gif" width="16" height="16" />
          </c:forEach>
          <c:forEach items="${rt.undiffRate}" var="rd">
             <img src="${basePath}images/shoe-2.gif" width="16" height="16" />
          </c:forEach>
           <a href="javascript:void(0)" title="Dark shoes logo on the difficulty level">Explain&gt;&gt;</a></td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Walking distance </strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.trekDistance }km</td>
        </tr>
        <tr>
          <td class="STYLE126"><div align="right"><strong>Mountain Style</strong></div></td>
          <td class="STYLE126" style="text-align:left">${rt.mountStyle } <a href="javascript:void(0)" title="${rt.mountStyle}">Explain&gt;&gt; </a></td>
        </tr>
         <tr>
        <td colspan=2  ><span class="STYLE148">
         Note: The needs of each group are different, according to your holiday to<br /> re-adjust the design process.</span></td>
        </tr>
      </table>
    <table class="f12-gao1">
      <tr>
        <td><img src="${basePath}images/facebook.png" width=" " height=" " />
        <a target="_blank" href="https://www.facebook.com/dialog/feed">share to FB</a></td>
        <td><img src="${basePath}images/share.png" width=" " height=" " />
        <a target="_blank" id="copyurl" href="javascript:void(0)" data-clipboard-target="flashcopier">Copy Url</a><div style="display:none" id="flashcopier"></div></td>
        <td><img src="${basePath}images/favorite01.png" width=" " height=" " />
        <a target="_blank"  href="javascript:itour.hiking.addFavorite()" rel="sidebar">Bookmark this page</a></td>
        <td><img src="${basePath}images/print.png" width=" " height=" " />
        <a target="_blank"  href="javascript:itour.hiking.printff()">Print the page</a></td></tr>
         <tr><td>Related routes:
              <c:forEach items="${rt.relates}" var="relat"><br>
              <a href="${basePath}light/light/${relat.alias}" >${relat.title }</a>
                <%-- <a href="${basePath}light/toQuote2/${relat.alias}" class="easyui-linkbutton" >${relat.title }</a> --%>
              </c:forEach>
              </td></tr>
            <%--  <tr><td><a href="${basePath}light/toQuote2/${rt.alias}" class="easyui-linkbutton" >预定本路线</a></td></tr>     --%>
    </table></td>
  </tr></tbody></table>
    </td>
  </tr>
 <tr>
    <td><img src="images/frame2-3.gif"   height="7"></td>
  </tr>
  </tbody>
</table>
</td></tr>
 

 <tr><td style="text-align:center;float:middle;width:100%;" align="center">
<div class="frametb" id="tab-container" class='tab-container' width="100%"  style="width:100%;text-align:center;float:middle">
 <ul style="text-align:left;float:left" class='etabs'>
   <li width="15%" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light/light/${alias}#review" target="_self">Overall overview</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light/light/${alias}#detail-route" target="_self">Detailed itinerary</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light/light/${alias}#need-know" target="_self">Before the line to know</a></li>
   <li width="15%" bgcolor="#F0F0F0" class='tab'><a href="${basePath}light/light/${alias}#feed-back" target="_self">Client feedback</a></li>
  <!--  <li width="110" bgcolor="#F0F0F0" class='tab'><a href="#consulting">咨询预定</a></li> -->
 </ul>
 <div class='panel-container'>
 <div id="review" name="review">
  <table  class="frametb" align="center">
  <tr>
    <td width="100%" style="align:left;float:left"><img src="${basePath}images/frame1-1.gif"  height="7" /></td>
  </tr>
  <tr>
    <td background="${basePath}images/frame1-2.gif" width="100%"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="40%" valign="top" class="STYLE126" style="text-align:left"><span class="STYLE3">design concept</span><span class="STYLE2">:</span><br />
          ${rt.designConcept }
          <span class="STYLE148"><strong>iTour travel team customization service:</strong><br />
          ${rt.customizedService }</span>
        </td>
        <td width="60%" valign="top" class="STYLE126"><div align="center"><span class="STYLE3">Travel map</span><br />
            <div class="easyzoom easyzoom--overlay">
                <a href="${basePath}images/map-002.jpg">
                    <img src="${basePath}images/map-002.jpg" alt=""  width="100%" />
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
    <td width="100%" style="align:left;float:left"><img src="${basePath}images/frame1-1.gif" height="7" /></td>
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
      <%-- <tr><td colspan=2>
<table  class="frametb" align="center">
  <tr>
    <td style="float:left"><img style="float:left" src="images/frame1-1.gif" width="1140" height="7" /></td>
  </tr>
  <tr>
    <td background="images/frame1-2.gif">
    <table  class="frametb" align="center">
        <tr>
          <td valign="top"><br />
          <table width="1140" border="0" align="center" cellpadding="4" cellspacing="2">
                             <tr>
                <td width="95" bgcolor="#f0f0f0"><p align="right"><strong>Tickets:</strong></p></td>
                <td width="529" style="text-align:left">${fn:split(qf.showTicket,'|')[1]}
                </td>
                <td width="444" style="text-align:left">${fn:split(qf.showTicket,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Tourist guide:</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showTourguide,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showTourguide,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Hotel: 
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showHotel,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showHotel,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Car: 
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showRentcar,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showRentcar,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Dining:
                </strong></div></td>
                <td style="text-align:left">${fn:split(qf.showDinner,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showDinner,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Insurance:</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showInsurance,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showInsurance,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>Comprehensive fee:</strong><strong>:</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showComphcost,'|')[1]}</td>
                <td style="text-align:left">${fn:split(qf.showComphcost,'|')[0]}￥/person</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="right"><strong>entertainment:</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showRecreation,'|')[1]} </td>
                <td style="text-align:left">${fn:split(qf.showRecreation,'|')[0]}￥/person</td>
              </tr>

              <tr>
                <td bgcolor="#f0f0f0"><div align="center"><strong>other fee:</strong></div></td>
                <td style="text-align:left">${fn:split(qf.showElsecost,'|')[1]} </td>
                <td style="text-align:left">${fn:split(qf.showElsecost,'|')[0]}</td>
              </tr>
              <tr>
                <td bgcolor="#f0f0f0"><div align="center"><strong>Quotes</strong></div></td>
                <td style="text-align:left">Adults:${qf.adultsQuote}￥/person*4 persons<br />
                Children  :${qf.childquote }￥/person*2 persons(Children do not include tickets) </td>
                <td>&nbsp;</td>
              </tr>
            </table>          
            <br /></td></tr>
      </table>
      </td>
      </tr>
      </table>
      </td></tr> --%>
</table>
  </div>
  <div id="need-know" name="need-know">
  <table  class="frametb" align="center">
  <tr>
    <td width="32" style="text-align:left;float:left;"><img src="images/document2.png" width="32" height="32" /></td>
    <td width="100%"  style="text-align:left;float:left;"><span class="h2-24" style="float:left"><span class="STYLE148">Before the line to know</span></span></td>
  </tr>
  <tr>
    <td colspan=2 style="text-align:left;align:left;">${rt.beforeInstruction }</td>
  </tr>
    <tr>
    <td colspan=2 style="float:left"><img style="float:left" src="${basePath}images/heart02.png" width="32" height="32" />
    <span class="h2-24" style="float:left"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2">Service and quotation</span></span></span></span></td>
  </tr>
    <tr>
    <td colspan=2 style="text-align:left;align:left;">${rt.serviceAndQuote }</td>
  </tr>
<tr>
     <td colspan=2 ><span class="STYLE3" style="text-align:left;float:left">Tell us your needs, free planning for your program GO! </span> &nbsp;&nbsp;
     <span class="STYLE3"  style="text-align:left;float:left"><a style="text-align:left;float:left;" href="${basePath}light/selfbooking/${rt.alias}">
     <img  style="float:middle" src="${basePath }images/tailor-made.gif" width="134" height="32" ></a></span></td>
   </tr>
</table>
  </div>
  <div id="feed-back" name="feed-back">
  <table  class="frametb" align="center">
  <tr>
    <td width="32"><img src="${basePath}images/ask03.png" width="32" height="32" /></td>
    <td width="100%" style="text-align:left;float:left" ><span class="h2-24"><span class="STYLE148"><span class="STYLE14"><span class="STYLE2" style="text-align:left;float:left" >Would you like to know what? Come and talk to us:</span><a href="#"></a></span></span></span></td>
  </tr>
</table>
<table  class="frametb" align="center">
  <tr>
    <td style="float:left"><img style="float:left" src="${basePath}images/frame1-1.gif" width="1140" height="7" /></td>
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
                    <select name="sex" id="sex" class="easyui-combobox" data-options="height:22,editable:false,panelHeight:80">
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

<script type="text/javascript" src="${basePath}jsm/ux/front/light/detail.js"></script>
 
</center>
</body>
</html>



