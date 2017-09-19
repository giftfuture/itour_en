 <%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.min.js"></script> --%>
<!-- <div style="left: 0; bottom: 0; right: 0;position:fixed !important;"> -->
<script type="text/javascript" src="${basePath}js/commons/package.js"></script>
<script type="text/javascript">
 var rcdDays='${rcdDays}';
 var level1Area ='${level1Area}';
 var level2Area = '${level2Area}';
</script>
<div style="width:100%">
<form name="searchForm" method="post">
<table class="frametb" align="center" style="margin-top:30px">
  <tr>
    <td width="12%" bgcolor="#CCCCCC"><div align="left" class="STYLE2"><strong>Quick Search</strong></div></td>
    <td width="80%" bgcolor="#CCCCCC" class="f14-gao1" >  
      <strong>Travel mode:</strong> <input name="travel_style" id="travel_style" class="easyui-combobox" value="${travelStyle}" data-options="width:120,minWidth:80,height:22,valueField:'alias',textField:'type',mode:'remote',panelHeight:'150',editable:false,method:'get',url:'${basePath}travelStyle/loadStyles',prompt:'-All-'">
      <label>
      Tourist area: 
         <input class="easyui-combobox" id="level1Area" name="level1Area" value="${level1Area}" data-options="width:120,minWidth:80,height:22,panelHeight:'auto',editable:false,prompt:'-All-'">
        <!--  width:130,height:20,valueField:'aliasCode',textField:'level2Area',mode:'remote',panelHeight:'auto',editable:false, method:'get'  -->
         <input id="level2Area" name="level2Area" class="easyui-combobox" data-options="width:120,minWidth:80,height:22,panelHeight:'auto',editable:false,prompt:'-All-'"/> 
        Holiday days:<a href="javascript:void(0)">
    <select class="easyui-combobox" data-options="width:120,minWidth:80,height:22,editable:false,prompt:'-All-'" name="vacation" id="vacation">
      <option value="">-All-</option>
      <option value="1_5">1-5days</option>
      <option value="6_9">6-9days</option>
      <option value="10_15">10-15days</option>
      <option value="16">16days+</option>
    </select>
      </a></label></td>
      <td width="8%" bgcolor="#CCCCCC"><a name="search" href="javascript:itouren.footer.searchRtResult()"><img name="search" src="${basePath}images/search.png" width="48" height="48" /></a> </td>
    <!-- <td width="15%" bgcolor="#CCCCCC" class="f14-gao1"><a class="easyui-linkbutton" iconcls="icon-search" id="searchbtn">搜索</a></td> -->
  </tr>
</table>
</form>
<table width="100%" border="0" align="center" cellpadding="5" cellspacing="0" bgcolor="#fafafa" name="keyfooter" style="margin-top:30;background-color:#fafafa;" bgcolor="#fafafa">
   </table>
<!-- <table width="100%" border="0" align="center" cellpadding="15" cellspacing="0">  
  <tr>
    <td height="106" valign="top" bgcolor="#fafafa">
    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="0">
      <tr>
        <td width="210"><strong>一些關鍵字</strong></td>
        <td width="210"><strong>页脚待定</strong></td>
        <td width="210"><strong>页脚待定</strong></td>
        <td width="210"><strong>页脚待定</strong></td>
        <td width="210"><strong>页脚待定</strong></td>
      </tr>
      <tr>
        <td valign="top"><p>四川旅游<br />
        四川旅游<br />
        四川旅游<br />
        四川旅游<br />
        四川旅游<br />
        四川旅游</p>          </td>
        <td valign="top">四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游</td>
        <td valign="top">四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游</td>
        <td valign="top">四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游</td>
        <td valign="top">四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游<br />
四川旅游</td>
      </tr>
    </table></td>
  </tr>
</table> -->
<%-- <center>
<div id="links" style="align:center">
   <div class="contents"><a href="http://www.ctrip.cn/" target="_blank"><img src="${basePath }/images/ad/20121209192739900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.qunar.com/" target="_blank"><img src="${basePath }/images/ad/20121209192856900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.12306.cn" target="_blank"><img src="${basePath }/images/ad/20121209193221900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.kuxun.cn/" target="_blank"><img src="${basePath }/images/ad/20121209192108900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.mangocity.com/" target="_blank"><img src="${basePath }/images/ad/20121209192948900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.csair.com/cn/" target="_blank"><img src="${basePath }/images/ad/20121209192627900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.ceair.com/" target="_blank"><img src="${basePath }/images/ad/20121209193103900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.ch.com" target="_blank"><img src="${basePath }/images/ad/20121209193323900.jpg" style="width:105px;height:36px;border:0px;"></a>
       <a href="http://www.mafengwo.cn/" target="_blank"><img src="${basePath }/images/ad/20120419110149.png" style="width:105px;height:36px;border:0px;"></a>
       
   </div>
</div>
</center> --%>
<table class="lefttxt frametb" align="center" style="margin-top:30px">
  <tbody><tr>
    <td   valign="middle" height="135"  bgcolor="#666666"><table width="100%" height="60" cellspacing="0" cellpadding="0" border="0" align="center">
      <tbody>
        <tr>
          <td width="100%" height="30" bgcolor="#EFEFEF"><div class="STYLE6" align="center">iTour Travel www.iTours.com.cn</div></td>
        </tr>
        <tr>
          <td height="30" bgcolor="#EFEFEF"><div class="STYLE6" align="center">Add: Chengdu City, a ring road on the 15th Overseas Chinese Building on the 9th floor<br>
            Tel: +86-28-85580038 / 85562905<br>
            E-mail: info@itours.com.cn </div></td>
        </tr>
      </tbody>
    </table></td>
  </tr>
</tbody></table>
<p></p><p></p>
<p></p><p></p><table class="frametb" align="center">
<tbody>
  <tr>
    <td><div align="center">
<!-- <script src="https://s11.cnzz.com/z_stat.php?id=1261858669&amp;web_id=1261858669" language="JavaScript"></script>
<script src="https://c.cnzz.com/core.php?web_id=1261858669&amp;t=z" charset="utf-8" type="text/javascript"></script> -->
<a href="http://www.cnzz.com/stat/website.php?web_id=1261858669" target="_blank" title="Webmaster Statistics">Webmaster Statistics</a>  
    </div></td>
  </tr></tbody>
</table>
</div>
<script type="text/javascript" src="${basePath}js/ux/front/footer.js"></script>  

