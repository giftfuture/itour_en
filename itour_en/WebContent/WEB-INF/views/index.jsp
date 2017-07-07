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
<title>Welcome to iTour Travel</title>
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

<center>
    <table class="commontb" align="center" width="72.6%" style="width:72.6%">
        <tr><td><%@include file="/front/header.jsp"%></td></tr>
        <tr>
            <td style="width:100%;text-align:center" align="center" width="100%" colspan=2>
        <a target="_blank"><img id="banner-index" width="100%" src="${basePath }images/Route001.jpg"  height="598px" /></a></td>
        </tr>
    </table>
    <table class="frametb" align="center" width="61.3%" style="width:61.3%">
        <tr>
            <td height="106" valign="top" bgcolor="#fafafa" colspan="2">
                <table width="100%" border="0" align="left" cellpadding="0"
                    cellspacing="0">
                    <tr>
                        <td class="STYLE9" style="text-align: left">iTour travel - custom travel service providers</td>
                    </tr>
                    <tr>
                        <td class="STYLE10" style="text-align: left">You are the protagonist of the trip</td>
                    </tr>
                    <tr>
                        <td style="text-align: left"><p>Life is made up of trips of different sizes,
We feel that every trip, the role of travelers should be above all, each trip should be unique and beautiful, no reluctance, no compromise ...
You are the owner, everything is based on your thoughts and needs。</p>
                            <p>
                                We sincerely hope that every trip can create a happy and beautiful memories for you. In the future, no matter which one you recall, you can play from the bottom of my heart smile. <br /> <br />
The protagonist travel belongs to the professional travel service team affiliated to China Travel Service. We have a strong faith in fulfilling your promise as we are
                            </p>
                            <p>
                                》》<a href="${basePath }whyus/aboutus">understand more</a>
                            </p>
                            <p></p></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
       
  
        <tr style="width:100%;text-align:center" align="center" width="100%" >
            <td  width="67%" style="width:67%;">
                <table border="0" align="center" cellpadding="15" cellspacing="0"
                    name="searchRtstb" width="100%" style="width:100%">
                    <tbody id="fbcontent">
                        <tr>
                        <c:if test="${not empty mapvo }">
                            <c:forEach items="${mapvo}" var="entry" varStatus="status">
                                <c:if test="${status.index != 0 && status.index%2==0 }">
                            </tr>
                            <tr>
                            </c:if>
                            <td valign="top"><table width="100%" border="0"  style="float:left"
                                    align="left" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="100%" class="h2-24red" colspan=3
                                            style="text-align: left; padding-left: 50px"><a
                                            width="100px" href="${basePath}${fn:split(entry['key'], '#')[3]}/main"><img
                                                src="images/icon-0${status.index+1 }.jpg" width="57"
                                                height="43">${fn:split(entry['key'],'#')[0]}</a></td>
                                    </tr>
                                    <tr>
                                        <td width="100%" class="f14-gao1" colspan=3
                                            style="text-align: left">${fn:split(entry['key'], '#')[1]}</td>
                                    </tr>
                                    <tr>
                                        <td width="100%" colspan=3 style="text-align: left"><a
                                            href="${basePath}${fn:split(entry['key'], '#')[3]}/main" class="STYLE3"><img
                                                src="${basePath }${fn:split(entry['key'],'#')[2]}"
                                                style="border: none;" border="0px" height="166" width="84%" /></a></td>
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
                    
                </table>
            </td>
            <td width="33%" style="width:33%;" valign="top" bgcolor="#f0f0f0">
                <table  width="100%" border="0" align="center" cellpadding="0"
                    cellspacing="0" class="f12-gao1">
                    <tr>
                        <td>
                            <table width="100%" border="0" align="center" cellpadding="5"
                                cellspacing="0" name="showhappytb">
                                <thead>
                                    <tr>
                                        <td width="32" style="text-align: right"><img
                                            src="images/heart02.png" width="32" height="32" /></td>
                                        <td width="268" class="h2-24" style="text-align: left">Memories of happiness</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td colspan=2>
                                            <%-- <a href="${basePath }showhappy/detail/${showhappy.shCode}">${showhappy.title }</a>  --%>
                                            <a href="${basePath }showhappy/detail/${showhappy.shCode}"><img
                                                src="${basePath }${showhappy.cover }"  width="80%" /></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan=2 style="text-align: left"><p
                                                class="f12-gao1">
                                                <span class="STYLE6" width="80%">${showhappy.shortContent } <a
                                                    href="${basePath }showhappy/main">More》》</a></span>
                                            </p></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </table> <br />
                <table width="100%" border="0" align="center" cellpadding="5"
                    cellspacing="0" name="hotspots">
                    <thead>
                        <tr>
                            <td width="32"><img src="images/earth.png" width="32"
                                height="32" />Hot spots</td>
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
                            <td> <a href="${basePath }destination/detail/${hotvo.alias}"><img src="${basePath}${hotvo.cover}" width="100%"
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
                </table></td>  
        </tr>
        <tr><td colspan=2><%@include file="/front/footer.jsp"%></td></tr>
    </table>
        
    </center>
 <script type="text/javascript" src="js/commons/index.js"></script>
</body>
</html>
