<%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/WEB-INF/views/server/mResource.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${basePath}css/bootstrap/bootstrapv3.css" />
<link rel="stylesheet" href="${basePath}css/bootstrap/qunit-1.11.0.css" />
<link rel="stylesheet" href="${basePath}cssm/index.css" />
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/bootstrapv3.js"></script>
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/bootstrap-paginator.js"></script>
<script type="text/javascript"src="${basePath}js/plug-in/bootstrap/qunit-1.11.0.js"></script>
<!-- <meta http-equiv="Refresh" content="0; URL=/"> -->
<title>Welcome to iTour Travel</title>
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
<div data-role="content"  data-fullscreen="true" style="z-index:-1; position:relative;">   
    <table  class="commontb" width="100%" style="width:100%" align="center">
        <tr>
            <td><%@include file="/frontm/header.jsp"%></td>
        </tr>
        <tr>
            <td><a target="_blank"><img id="banner-index" width="100%" src="${basePath }images/Route001.jpg" /></a></td>
        </tr>

        <tr>
            <td  valign="top" bgcolor="#fafafa">
            <div style=" position:relative;margin-top:-50;z-index:9999;width:90%">
                <table width="100%" border="0" align="left" cellpadding="0"
                    cellspacing="0">
                    <tr>
                        <td class="STYLE9" style="text-align: left">iTour travel <br/>- custom travel service providers</td>
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
                                》》<a href="${basePath }whyus-aboutus">know more</a>
                            </p>
                            <p></p></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </table>
                </div>
            </td>
        </tr>
        <tr>
            <td valign="top">&nbsp;</td>
        </tr>

        <tr>
            <td width="100%" valign="top">
                <table border="0" align="center" cellpadding="5" cellspacing="0"
                    name="searchRtstb">
                    <tbody id="fbcontent">
                        <tr>
                        <c:if test="${not empty mapvo }">
                            <c:forEach items="${mapvo}" var="entry" varStatus="status">
                                <c:if test="${status.index != 0 && status.index%2==0 }">
                            </tr>
                            <tr>
                            </c:if>
                            <td valign="top"><table width="100%" border="0"
                                    align="left" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="100%" class="h2-24red" colspan=3 style="text-align:left;">
                                            <a width="100%" href="${basePath}${fn:split(entry['key'], '#')[3]}" class="STYLE3 tsSTYLE3" style="font-size:1em;font-weight:normal;"><img
                                                src="images/icon-0${status.index+1 }.jpg" style="width:57;height:43;" width="57" height="43">${fn:split(entry['key'],'#')[0]}</a></td>
                                    </tr>
                                    <tr>
                                        <td width="100%" class="f14-gao1" colspan=3
                                            style="text-align: left">${fn:split(entry['key'], '#')[1]}</td>
                                    </tr>
                                    <tr>
                                        <td width="100%" colspan=3 style="text-align: left"><a
                                            href="${basePath}${fn:split(entry['key'], '#')[3]}" class="STYLE3"><img
                                                src="${basePath }${fn:split(entry['key'],'#')[2]}"
                                                style="border: none;" border="0px" width="100%" /></a></td>
                                    </tr>
                                    <c:forEach items="${entry['value']}" var="et">
                                        <tr>
                                            <td style="text-align: left"><a
                                                href="${basePath }${et.travelStyleAlias }-${et.alias}">>><span
                                                    class="STYLE7">${et.title }</span></a></td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td style="text-align: left"><a
                                            href="${basePath }${entry['value'][0].travelStyleAlias }">More>></a></td>
                                    </tr>
                                </table></td>
                            </c:forEach>
                            </c:if>
                        </tr>
                    </tbody>
                </table>
            </td></tr>
            <tr><td width="100%" valign="top" bgcolor="#f0f0f0" align="left">
                <table width="100%" border="0" align="center" cellpadding="0"
                    cellspacing="0" class="f12-gao1">
                    <tr>
                        <td>
                            <table width="60%" border="0" align="center" cellpadding="5"
                                cellspacing="0" name="showhappytb">
                                <thead>
                                    <tr>
                                        <td width="32" style="text-align: right"><img
                                            src="images/heart02.png" width="32" height="32" /></td>
                                        <td width="80%" class="h2-24" style="text-align: left">Memories of happiness</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td colspan=2>
                                            <%-- <a href="${basePath }showhappy/detail/${showhappy.shCode}">${showhappy.title }</a>  --%>
                                            <a href="${basePath }showhappy-detail-${showhappy.shCode}"><img
                                                src="${basePath }${showhappy.cover }" width="100%" /></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan=2 style="text-align: left"><p
                                                class="f12-gao1">
                                                <span class="STYLE6">${showhappy.shortContent } <a
                                                    href="${basePath }showhappy">More》》</a></span>
                                            </p></td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </table> </td></tr>
                <tr><td><table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" name="hotspots">
                    <thead>
                        <tr>
                            <td width="32"><img src="images/earth.png" width="32" height="32"  style="width:32;height:32;"/>Hot spots</td>
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
                            <td> <a href="${basePath }destination-detail-${hotvo.alias}"><img src="${basePath}${hotvo.cover}" width="100%"
                                 title="${hotvo.item }" /></a></td>
                            </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <td><p class="f12-gao1">
                                    <span class="STYLE6"> <a
                                        href="${basePath }destination">More》》</a></span>
                                </p></td>
                        </tr>
                    </tbody>
                </table></td>
        </tr>
  <tr><td><center><ul id='fbpage'></ul></center></td></tr>
   <tr><td><%@include file="/frontm/footer.jsp"%></td></tr>
    </table>
    </div>
</center>
<script type="text/javascript" src="${basePath }jsm/commons/index.js"></script>
</body>
</html>
