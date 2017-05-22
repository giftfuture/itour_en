<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/resource.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />
<link rel="stylesheet" href="${basePath}css/index.css" />
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<!-- <meta http-equiv="Refresh" content="0; URL=/"> -->
<title>欢迎访问主角旅行</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	jQuery.browser = {};
	(function() {
		jQuery.browser.msie = false;
		jQuery.browser.version = 0;
		if (navigator.userAgent.match(/MSIE ([0-9]+)./)) {
			jQuery.browser.msie = true;
			jQuery.browser.version = RegExp.$1;
		}
	})();
</script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><%@include file="/front/header.jsp"%></td>
		</tr>
		<tr>
			<td><a target="_blank"><img id="banner-index"
					src="${basePath }images/Route001.jpg" /></a></td>
		</tr>
	</table>
	<table class="commontb" align="center">
		<tr>
			<td height="106" valign="top" bgcolor="#fafafa">
				<table width="100%" border="0" align="left" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="STYLE9" style="text-align: left">主角旅行——定製旅行服務商</td>
					</tr>
					<tr>
						<td class="STYLE10" style="text-align: left">您才是旅行的主角</td>
					</tr>
					<tr>
						<td style="text-align: left"><p>人生是由大大小小不同的旅程串連而成的，
								我們覺得每次的旅程，旅人的角色都應該凌駕於所有之上，每次的旅程都應該獨特而美好，沒有勉強，沒有委曲求全 ...
								您，是主人，一切以您的想法及需求為依歸。</p>
							<p>
								我們衷心希望，每一個旅途都能為您創造幸福而美好的回憶 。將來，不管您憶起哪一個片段，都能打從心底泛起笑顏。<br /> <br />
								主角旅行是隶属于中旅旗下的专业定制旅行服务团队。 我們有強大的信心來履行對您的承諾，因為我們
							</p>
							<p>
								》》<a href="${basePath }whyus/aboutus">了解更多</a>
							</p>
							<p></p></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top">&nbsp;</td>
		</tr>
	</table>
	<br />
	<table class="commontb" align="center">
		<tr>
			<td width="766" valign="top">
				<table border="0" align="center" cellpadding="15" cellspacing="0"
					name="searchRtstb">
					<tbody id="fbcontent">
						<tr>
							<c:if test="${not empty mapvo }">
								<c:forEach items="${mapvo}" var="entry" varStatus="status">
									<c:if test="${status.index != 0 && status.index%2==0 }">
						</tr>
						<tr>
							</c:if>
							<td valign="top"><table width="253" border="0"
									align="left" cellpadding="0" cellspacing="0">
									<tr>
										<td width="296" class="h2-24red" colspan=3
											style="text-align: left; padding-left: 50px"><a
											width="100px" href="${basePath}hiking/main"><img
												src="images/icon-0${status.index+1 }.jpg" width="57"
												height="43">${fn:split(entry['key'],'#')[0]}</a></td>
									</tr>
									<tr>
										<td width="296" class="f14-gao1" colspan=3
											style="text-align: left">${fn:split(entry['key'], '#')[1]}</td>
									</tr>
									<tr>
										<td width="296" colspan=3 style="text-align: left"><a
											href="${basePath}hiking/main" class="STYLE3"><img
												src="${basePath }${fn:split(entry['key'],'#')[2]}"
												style="border: none;" border="0px" height="166" width="353" /></a></td>
									</tr>
									<c:forEach items="${entry['value']}" var="et">
										<tr>
											<td style="text-align: left"><a
												href="${basePath }${et.travelStyleAlias }/${et.travelStyleAlias }/${et.alias}">>><span
													class="STYLE7">${et.title }</span></a></td>
										</tr>
									</c:forEach>
									<tr>
										<td style="text-align: left"><a
											href="${basePath }${entry['value'][0].travelStyleAlias }/main">More>></a></td>
									</tr>
								</table></td>
							</c:forEach>
							</c:if>
						</tr>
					</tbody>
				</table>
			</td>
			<td width="474" valign="top" bgcolor="#f0f0f0" align="left">
				<table width="353" border="0" align="center" cellpadding="0"
					cellspacing="0" class="f12-gao1">
					<tr>
						<td>
							<table width="300" border="0" align="center" cellpadding="5"
								cellspacing="0" name="showhappytb">
								<thead>
									<tr>
										<td width="32" style="text-align: right"><img
											src="images/heart02.png" width="32" height="32" /></td>
										<td width="268" class="h2-24" style="text-align: left">回憶幸福</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan=2>
											<%-- <a href="${basePath }showhappy/detail/${showhappy.shCode}">${showhappy.title }</a>  --%>
											<a href="${basePath }showhappy/detail/${showhappy.shCode}"><img
												src="${basePath }${showhappy.cover }" width="353" height="166" /></a>
										</td>
									</tr>
									<tr>
										<td colspan=2 style="text-align: left"><p
												class="f12-gao1">
												<span class="STYLE6">${showhappy.shortContent } <a
													href="${basePath }showhappy/main">More》》</a></span>
											</p></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</table> <br />
				<table width="353" border="0" align="center" cellpadding="5"
					cellspacing="0" name="hotspots">
					<thead>
						<tr>
							<td width="32"><img src="images/earth.png" width="32"
								height="32" /> 热门景点</td>
						</tr>
					</thead>
					<tbody>
						<tr>
						<tr>
							<c:if test="${not empty hotrtVos }">
								<c:forEach items="${hotrtVos }" var="hotvo" varStatus="s">
									<c:if test="${s.index%2==0 }">
						</tr>
						<tr>
							</c:if>
							<td> <a href="${basePath }destination/detail/${hotvo.alias}"><img src="${basePath}${hotvo.cover}" width="175"
								height="168" title="${hotvo.item }" /></a></td>
							</c:forEach>
							</c:if>
						</tr>
						<tr>
							<td><p class="f12-gao1">
									<span class="STYLE6"> <a
										href="${basePath }destination/main">More》》</a></span>
								</p></td>
						</tr>
					</tbody>
				</table> <!--   <table width="353" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>九寨沟 四姑娘山 海螺沟。。。。 </td>
        </tr>
      </table></td> -->
		</tr>
	</table>
	<center>
		<ul id='fbpage'></ul>
	</center>
	<%@include file="/front/footer.jsp"%>
	<script type="text/javascript" src="js/commons/index.js"></script>
</body>
</html>
