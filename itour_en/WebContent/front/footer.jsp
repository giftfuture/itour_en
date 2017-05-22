 <%@ page language="java" import="java.lang.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <script type="text/javascript" src="${basePath}js/jquery-easyui-1.5.1/jquery.min.js"></script> --%>
<!-- <div style="left: 0; bottom: 0; right: 0;position:fixed !important;"> -->
<script type="text/javascript" src="${basePath}js/commons/package.js"></script>
<script type="text/javascript" src="${basePath}js/ux/front/footer.js"></script>  
<div>
<script type="text/javascript">
 /*$("#level1Area").combobox({
  url: '@(Url.Action("BaseDataCombobox", "System"))?type=@(CMM.RedStrings.Model.Const.BaseDataCategory.EnterpriseProperty)',
    valueField: "ID",
    textField: "Text",
    panelHeight: "auto",
    editable: false,
    onSelect: function (record) {
    	,onChange:function(n,o){ var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+n ;$('#level2Area').combobox('reload',urlurl);}
        ,onselect:function(){ var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+$(this).combobox('getValue');$('#level2Area').combobox('reload',urlurl);}
    },
onChange:function(n,o){ var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+n ;$('#level2Area').combobox('reload',urlurl);} */
$(document).ready(function(){
	var level1Area ='${level1Area}';
	$.ajax({  
		url:'${basePath}levelarea/queryLevel1',
	    async : false,  
	    method: 'get',
	    success:function(rest){
	    	var result = eval('('+rest+")");//转换为json对象 
	    	$("#level1Area").combobox({ 
	    		valueField:'level1Area',
	    		textField:'level1Area',
	    		mode:'local',
	    		data:result,
	    		onLoadSuccess:function(){$(this).combobox('select', level1Area)},
	    		onChange:function(n,o){
	    	    	loadlevel2Area(n);
	   	    	} 
	    	});   
	    }  
	})
	loadlevel2Area(level1Area);
	//console.log('${rcdDays}');$(this).combobox('select', '${rcdDays}')
	$("#vacation").combobox({ 
		onLoadSuccess:function(){$(this).combobox('setValue', '${rcdDays}');}
	})  
})
function loadlevel2Area(level1Area){
	var templevel2Areaindex=0;
	if(level1Area&&level1Area.length>0){
   //console.log(level1Area);
	$.ajax({  
	    url : '${basePath}levelarea/queryLevel2ByLevel1',  
	    async : false,  
	    method: 'get',
	    data:{'level1Area':level1Area},
	    success : function(rest){ 
	    	var result = eval('('+rest+")");//转换为json对象 
	    	//console.log(result);    	
	        $("#level2Area").combobox({  
	        	valueField:'aliasCode',
	        	textField:'level2Area',
	            mode : 'local',  
	            data: result,
	            onLoadSuccess:function(){$(this).combobox('select','${level2Area}')}
	        });  
	    }  
	}); 
  }
}
</script>
<form name="searchForm" method="post">
<table class="commontb" align="center" >
  <tr>
    <td width="15%" bgcolor="#CCCCCC"><div align="left" class="STYLE2">快速搜索</div></td>
    <td width="60%" bgcolor="#CCCCCC" class="f14-gao1" >  
       旅行方式：<input name="travel_style" id="travel_style" class="easyui-combobox" value="${travelStyle}" data-options="width:130,height:20,valueField:'alias',textField:'type',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'${basePath}travelStyle/loadStyles'">
      <label>
       旅游区域：<!--onBeforeLoad
     	   -->
        	<!-- width:130,height:20,valueField:'level1Area',textField:'level1Area',mode:'remote',method:'get',panelHeight:'auto',editable:false, url:'${basePath}levelarea/queryLevel1' -->
         <input class="easyui-combobox" id="level1Area" name="level1Area" value="${level1Area}" data-options="width:130,height:20,panelHeight:'auto',editable:false"
        <%-- ,onLoadSuccess:function(){$(this).combobox('select', '${level1Area}');} --%>
    <%--     ,onChange:function(n,o){ var urlurl = '${basePath}levelarea/queryLevel2ByLevel1?level1Area='+n ;$('#level2Area').combobox('reload',urlurl);} --%>
        >
     	<!--  width:130,height:20,valueField:'aliasCode',textField:'level2Area',mode:'remote',panelHeight:'auto',editable:false, method:'get'  -->
     	 <input id="level2Area" name="level2Area" class="easyui-combobox" data-options="width:130,height:20,panelHeight:'auto',editable:false"/> 
	     	 <%--  ,onLoadSuccess:function(){
	    		var level1Area = $('#level1Area').combobox('getValue');
	     	   console.log(level1Area);	
	     	   if(level1Area.length>0){
		     	  $(this).combobox('reload','${basePath}levelarea/queryLevel2ByLevel1?level1Area='+level1Area);
	     	  } 
	     	  $(this).combobox('select','${level2Area}'); --%>
     <%-- 	  },onBeforeLoad:function(){
	     	var level1Area = '${level1Area}';
	     	  alert(level1Area);
	     	  //console.log(level1Area);
	     	   if(level1Area.length>0){
		     	  $(this).combobox('reload','${basePath}levelarea/queryLevel2ByLevel1?level1Area='+level1Area);
	     	  } 
	     	  
     	  }--%>
        假期天数：<a href="javascript:void(0)">
	<select class="easyui-combobox" data-options="width:130,height:20,editable:false" name="vacation" id="vacation">
	  <option value="">-所有-</option>
	  <option value="1_5">1-5天</option>
	  <option value="6_9">6-9天</option>
	  <option value="10_15">10-15天</option>
	  <option value="16">16天+</option>
	</select>
      </a></label></td>
      <td width="10%" bgcolor="#CCCCCC"><a name="search" href="javascript:itour.footer.searchRtResult()"><img name="search" src="${basePath}images/search.png" width="48" height="48" /></a> </td>
    <!-- <td width="15%" bgcolor="#CCCCCC" class="f14-gao1"><a class="easyui-linkbutton" iconcls="icon-search" id="searchbtn">搜索</a></td> -->
  </tr>
</table>
</form>
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
<table class="commontb" align="center">
  <tr>
    <td width="1350" height="105" valign="top" bgcolor="#666666">
    <table width="1350" height="60" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td width="1350" height="30" bgcolor="#EFEFEF"><div align="center" class="STYLE6">主角旅行 www.iTours.com.cn</div></td>
        </tr>
        <tr>
          <td height="30" bgcolor="#EFEFEF"><div align="center" class="STYLE6">Add: 成都一環路南三段15號華僑大廈9層<br />
            Tel: +86-28-85580038 / 85562905<br />
            E-mail: info@itours.com.cn </div></td>
        </tr>
      </tbody>
    </table>
    </td>
  </tr>
  <tr>
    <td><div align="center">
<!-- <script src="https://s11.cnzz.com/z_stat.php?id=1261858669&amp;web_id=1261858669" language="JavaScript"></script>
<script src="https://c.cnzz.com/core.php?web_id=1261858669&amp;t=z" charset="utf-8" type="text/javascript"></script> -->
<a href="http://www.cnzz.com/stat/website.php?web_id=1261858669" target="_blank" title="站长统计">站长统计</a>	
	</div></td>
  </tr>
</table>
</div>
<script type="text/javascript">
/* var areas = $("#areas").combobox('getValue'); 
console.log(travel_style+"  "+vacation+"   "+areas); */
</script>
