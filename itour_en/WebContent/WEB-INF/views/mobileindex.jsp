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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.5">
<link rel="stylesheet" href="${basePath}js/jqueryMobile/jquery.mobile-1.4.5.min.css" />
<script type="text/javascript" src="${basePath}js/jqueryMobile/jquery.mobile-1.4.5.min.js"></script>

 <!-- <meta http-equiv="Refresh" content="0; URL=/"> -->
<title>欢迎访问主角旅行</title>
 <link href="css/index.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
 jQuery.browser={};
 (function(){
	 jQuery.browser.msie=false; 
	 jQuery.browser.version=0;
	 if(navigator.userAgent.match(/MSIE ([0-9]+)./)){
		 jQuery.browser.msie=true;
		 jQuery.browser.version=RegExp.$1;
  }})();
 </script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><%@include file="/front/header.jsp" %></td>
  </tr>
 <tr>
    <td><img id="banner-index"  src="${basePath }images/Route001.jpg" width="1350" height="598" /></td>
  </tr>  
    <tr><td style="text-align:left"><input type="button" value="1" onclick="changePho(this)" />
    <input type="button" value="2" onclick="changePho(this)" />
    <input type="button" value="3" onclick="changePho(this)" />
    <input type="button" value="4" onclick="changePho(this)" />
    <input type="button" value="5" onclick="changePho(this)" />
    <input type="button" value="6" onclick="changePho(this)" /></td></tr>
  <tr><td> </td></tr>
<tr><td>
<!--此 param 标签提示使用 Flash Player 6.0 r65 和更高版本的用户下载最新版本的 Flash Player。如果您不想让用户看到该提示，请将其删除。 -->
<script type="text/javascript">
if($.browser.msie){ 
	document.write('<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1350" height="598" style="margin-top: -10px;margin-left: -8px;" id="FLVPlayer1">'+
			'<param name="movie" value="FLVPlayer_Progressive.swf" />'+
			'<param name="quality" value="high" />'+
			'<param name="wmode" value="opaque" />'+
			'<param name="scale" value="noscale" />'+
			'<param name="salign" value="lt" />'+
			'<param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=public/swf/Clear_Skin_3&amp;streamName=public/video/praise02.mp4&amp;autoPlay=false&amp;autoRewind=false" />'+
			'<param name="swfversion" value="8,0,0,0" />'+
			'<param name="expressinstall" value="expressInstall.swf" />'+
			'</object>');
	}else{
		 document.write('<div align="center" width="1350" height="598"><video width="1350" height="598" controls="controls">'+
		'<source src="video/praise01.mp4" type="video/mp4"></source>'+
		'your browser does not support the video tag'+
		'</video></div>'); 
		//document.write('<iframe height=600 width=330 src="http://player.youku.com/embed/XNTcyMzIwMTE2" frameborder=0 allowfullscreen></iframe>');
		//document.write('<iframe height=600 width=330 src="http://player.youku.com/player.php/Type/Folder/Fid/22127316/Ob/1/sid/XNjk1MDUyNzU2/v.swf" frameborder=0 allowfullscreen></iframe>');
	/* 	document.write('<div align="center" width="100%" height="50%">'+
		'<embed src="http://player.youku.com/player.php/Type/Folder/Fid/22127316/Ob/1/sid/XNjk1MDUyNzU2/v.swf" '+
		'quality="high" width="1000px" height="500px" align="center" allowScriptAccess="always" allowFullScreen="true" mode="transparent" type="application/x-shockwave-flash"></embed></div>'); */
	}
</script>  
<!-- 
<embed src="http://static.youku.com/v1.0.0149/v/swf/qplayer_rtmp.swf?VideoIDS=XNTg2ODcxMTM2ID&winType=adshow&isAutoPlay=true" quality="high" width="290" height="220" align="middle" title="嘉兴中安商贸园宣传片" wmode="transparent" allowScriptAccess="never" allowNetworking="internal" autostart="1" type="application/x-shockwave-flash"></embed> -->
<!-- 视频常见几种比例：384×256、580×435、610×460 -->
<%--   <video width="602px" height="345px" controls="controls">
<source src="${basePath }video/praise.mp4" type="video/mp4"></source>
your browser does not support the video tag
</video> --%>
</td></tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td class="STYLE9" style="text-align:left">主角旅行——定製旅行服務商</td>
      </tr>
      <tr>
        <td class="STYLE10" style="text-align:left">您才是旅行的主角</td>
      </tr>
      <tr >
        <td style="text-align:left"><p>人生是由大大小小不同的旅程串連而成的， 我們覺得每次的旅程，旅人的角色都應該凌駕於所有之上，每次的旅程都應該獨特而美好，沒有勉強，沒有委曲求全 ... 您，是主人，一切以您的想法及需求為依歸。</p>
          <p>我們衷心希望，每一個旅途都能為您創造幸福而美好的回憶 。將來，不管您憶起哪一個片段，都能打從心底泛起笑顏。<br />
            <br />
          主角旅行是隶属于中旅旗下的专业定制旅行服务团队。 我們有強大的信心來履行對您的承諾，因為我們</p>
          <p>》》<a href="${basePath }whyus/aboutus">了解更多</a></p>
          <p></p></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top">&nbsp;</td>
  </tr>
</table>
<br />
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="766" valign="top">
    <table border="0" align="center" cellpadding="15" cellspacing="0" name="searchRtstb">
    <tbody id="fbcontent">
      <tr>
      <c:if test="${not empty mapvo }">
	      <c:forEach items="${mapvo}" var="entry" varStatus="status">
	       <c:if test="${status.index != 0 && status.index%4==0 }"></tr><tr></c:if>
	        <td valign="top"><table width="353" border="0" align="left" cellpadding="0" cellspacing="0" class="f14-gao1">
	            <tr>
	              <td><table width="300" border="0" align="left" cellpadding="0" cellspacing="0">
	                  <tr>
	                    <td width="57"><img src="images/icon-01.jpg" width="57" height="43" /></td>
	                    <td width="296" class="h2-24"><a href="${basePath}hiking/main" class="STYLE3">${entry['key']}</a></td>
	                  </tr>
	              </table></td>
	            </tr>
	            <tr>
	              <td><a href="${basePath }${entry['value'].travelStyleAlias }/${entry['value'].travelStyleAlias }/${entry['value'].alias}"><span class="STYLE7">${entry['value'].title }</span></a></td>
	            </tr>
	            <tr>
	              <td><a href="${basePath }${entry['value'].travelStyleAlias }/${entry['value'].travelStyleAlias }/${entry['value'].alias}"><img src="${entry['value'].cover }" width="353" height="166" /></a></td>
	            </tr>
	            <tr>
	              <td class="STYLE8"><%-- <a href="${basePath }${entry['value'].travelStyleAlias }/${entry['value'].travelStyleAlias }/${entry['value'].alias}">${entry['value'].title }</a><br /> --%>
	              ${entry['value'].shortContent}<br><a href="${basePath }${entry['value'].travelStyleAlias }/main">More》》</a>
	              </td>
	            </tr>
	        </table></td>
	        </c:forEach>
        </c:if>
      </tr>
      </tbody>
    </table></td>
    <td width="374" valign="top" bgcolor="#f0f0f0"><br />
      <table width="353" border="0" align="center" cellpadding="0" cellspacing="0" class="f12-gao1">
      <tr>
        <td>
        <table width="300" border="0" align="left" cellpadding="5" cellspacing="0" name="showhappytb">
        	<thead>
            <tr>
              <td width="32"><img src="images/heart02.png" width="32" height="32" /></td>
              <td width="268" class="h2-24">回憶幸福</td>
            </tr>
            </thead>
            <tbody>
	      <tr>
	       <td><a href="${basePath }showhappy/detail/${showhappy.shCode}">${showhappy.title }</a> 
	        <a href="${basePath }showhappy/detail/${showhappy.shCode}"><img src="${basePath }${showhappy.cover }" width="353" height="166" /></a></td>
	      </tr>
	      <tr>
	        <td><p class="f12-gao1"><span class="STYLE6">${showhappy.shortContent } 
	             <a href="${basePath }showhappy/main">More》》</a></span></p>
	       </td></tr></tbody>
        </table></td>
      </tr>
    </table>
      <br />
      <table  width="353" border="0" align="center" cellpadding="5" cellspacing="0" name="hotspots">
        <thead><tr>
          <td width="32"><img src="images/earth.png" width="32" height="32" /></td>
          <td width="301" class="h2-24">热门景点</td>
        </tr></thead>
        <tbody>
        <tr>
  		  <tr>
  		   <c:if test="${not empty hotrtVos }">
	      <c:forEach items="${hotrtVos }" var="hotvo" varStatus="s">
	      		<c:if test="${s.index%2==0 }"></tr><tr></c:if>	
		        <td><img src="${basePath}${hotvo.cover}" width="175" height="168" title="${hotvo.title }" /></td>
	      </c:forEach>
        </c:if>
        </tr>
        <tr>
       	 <td><p class="f12-gao1"><span class="STYLE6">
	             <a href="${basePath }showhappy/main">More》》</a></span></p>
	       </td></tr>
        </tbody>
      </table>
    <!--   <table width="353" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>九寨沟 四姑娘山 海螺沟。。。。 </td>
        </tr>
      </table></td> -->
  </tr>
</table>
<center><ul id='fbpage'></ul></center>
<%@include file="/front/footer.jsp" %>
<script type="text/javascript" src="js/commons/index.js"></script>
</body>
</html>
