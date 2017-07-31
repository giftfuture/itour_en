 <%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script type="text/javascript" src="${basePath}jsm/commons/package.js"></script>
<script type="text/javascript">
 var rcdDays='${rcdDays}';
 var level1Area ='${level1Area}';
 var level2Area = '${level2Area}';
</script>

<div width="100%" style="width:100%"  data-role="content"  data-fullscreen="true">
<form name="searchForm" method="post">
<table class="commontb" align="center"  width="100%" height="100%" style="width:100%;height:200px;"  data-role="content"  data-fullscreen="true">
  <tr>
    <td width="15%" bgcolor="#CCCCCC"><div align="left" class="STYLE2"><strong>fast Search</strong></div></td>
    <td width="75%" bgcolor="#CCCCCC" class="f14-gao1" >  
      <p style="height:15px"><span style="text-align:left"><strong>Travel Mode:</strong>&nbsp;<input name="travel_style" id="travel_style" class="easyui-combobox" value="${travelStyle}" data-options="width:120,minWidth:50,height:22,valueField:'alias',textField:'type',mode:'remote',panelHeight:'150',editable:false,method:'get',url:'${basePath}travelStyle/loadStyles',prompt:'-All-'"/></span></p>
      <p style="height:15px"><span style="text-align:left">
       <strong>&nbsp;  Area Level1:</strong>
         <input class="easyui-combobox" id="level1Area" name="level1Area" value="${level1Area}" data-options="width:120,minWidth:50,height:22,panelHeight:'auto',editable:false,prompt:'-All-'"/></span></p>
         <p style="height:15px"><span style="text-align:left"><strong>&nbsp;  Area Level2:</strong><input id="level2Area" name="level2Area" class="easyui-combobox" data-options="width:120,minWidth:50,height:22,panelHeight:'auto',editable:false,prompt:'-All-'"/></span> 
         </p>
        <p style="height:15px"><span style="text-align:left"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Holiday:</strong><a href="javascript:void(0)">
    <input class="easyui-combobox" data-options="width:120,minWidth:50,height:22,editable:false,prompt:'-All-'" name="vacation" id="vacation"/>
      </a></span></p></td>
      <td width="10%" bgcolor="#CCCCCC"><a name="search" href="javascript:itouren.footer.searchRtResult()"><img name="search" src="${basePath}images/search.png" width="48" height="48" /></a> </td>
  </tr>
</table>
</form>
<table width="100%" border="0" align="center" style="margin-top:30;background-color:#fafafa;" cellpadding="5" cellspacing="0" bgcolor="#fafafa" name="keyfooter">
 </table>
<table class="commontb" align="center"  width="100%" style="margin-top:30px;width:100%" data-role="content"  data-fullscreen="true">
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
<p></p><p></p> 
<table align="center" class="commontb" width="100%" style="width:100%" data-role="content"  data-fullscreen="true" bgcolor='#fafafa'>
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
<script type="text/javascript" src="${basePath}jsm/ux/front/footer.js"></script>  

