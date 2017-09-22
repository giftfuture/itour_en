$package('itouren.quoteEdit');
itouren.quoteEdit = function(){
	var _box = null;
	var _this = {
		saveQuoteForm:function(){
			var formData = new Object();
			var actionurl=basePath+"routeTemplate/updateQuoteForm";
			formData["routeTemplate"]  = $('input[name="rtId"]').val();
	  	 var showTrip="<table name='showTrip'  width='100%' cellspacing='1' cellpadding='1' border='0' align='center'><thead><tr>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0' style='width:5%'  height='31'><div class='style18' align='center'><div align='center'><strong><strong>Days</strong></strong></div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0' style='width:59%'><div class='STYLE18' align='center'><div align='center'><strong><strong>Itinerary</strong></strong></div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0' style='width:6%'><div class='STYLE18' align='center'><div align='center'>Mileage</div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0' style='width:30%'><div class='STYLE18' align='center'><div align='center'>Landscape</div></div></td>"+
          "</tr></thead>";
        var beriefTrip="";
			var agodaTbodys =$("table[name='routetable'] tbody[name='agodaTbody']");
			$(agodaTbodys).each(function(i,e){
					  var tourdaysval = i++;
					  var tourDescval = $("#tourDesc",$(e)).val();
					  var mileageval = $("#mileage",$(e)).val();
					  var areaval = $("#area",$(e)).val();// $("#area",$(e)).combobox('getValue');
					  var areatext = $("#area",$(e)).combobox('getText');//$("#area",$(e)).combobox('getText');
					  var travelItemval = $("#travelItem",$(e)).val();
					  var travelItemtext = $("#travelItem",$(e)).combobox('getText');
					  var hotelPlace = $("#hotelPlace",$(e)).val();
					  var agodaDetailval = $("#agodaDetail",$(e)).val();//combobox('getValue');
					  beriefTrip+="<tbody name='agodaTbody'><tr>"+//<td>" + tourdaysval +"</td>"+
						"<td class=STYLE126 width=308 valign=middle><input type='text' class='easyui-textbox' value='"+tourDescval+"' data-options=\"width:308,onLoadSuccess:function(){$(this).combobox('setValue', '"+tourDescval+"')}\" id='tourDesc' name='tourDesc'></td>"+
						"<td class=STYLE126 width=50 valign=middle><input name='mileage' id='mileage' class='easyui-textbox' value='"+mileageval+"' data-options=\"onLoadSuccess:function(){$(this).combobox('setValue', '"+mileageval+"')}\" type='number' min=0 "+
						"onkeyup='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)'" +
						"onafterpaste='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" +
						"onblur='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)'></td>"+
						"<td class=STYLE126 width=124 valign=middle><input name='area' id='area' class='easyui-combobox' data-options=\"cursor:'pointer',width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'areas/allAreas',"+
						"onChange:function(n,o){ var urlurl = 'travelItem/queryByScope?scope='+n ;$(this).parents('tbody').find('#travelItem').combobox('reload',urlurl);},onLoadSuccess:function(){$(this).combobox('setValue', '"+areaval+"')}\">"+
						"<input id='travelItem' name='travelItem' class='easyui-combobox'"+																																						//type=checkbox
						" data-options=\"cursor:'pointer',valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,width:151,height:22," +
						"formatter:function(row){return '<option  class=selectId style=vertical-align:middle name=selectId_1491992423815'+row.alias+' value='+row.alias+'>'+row.item+'</option>';}," +
						"onSelect:function(record){$('option[name=selectId_1491992423815'+record.alias+']',$(this)).attr('selected', 'true');}," +
						"onUnselect:function(record){$('option[name=selectId_1491992423815'+record.alias+']',$(this)).attr('selected',false);}" +
						",onLoadSuccess:function(){var travelItemval ='"+travelItemval+"';$(this).combobox('setValues',travelItemval.split(',')); }" +
						"\"/></td>"+
						"<td class=STYLE126 valign=middle><input type='text' data-options='' value='"+hotelPlace+"' class='easyui-textbox' name='hotelPlace' id='hotelPlace'></td>"+
						"<td><a name='routeminus' onclick='javascript:itouren.quoteEdit.routeMinus(this)'><img alt='' title='删除本行' style='height:16px;height:16px;' src='images/minus.png' ></a></td></tr>"+
						"<tr><td class=STYLE126  style='text-align:left' colspan='5'><strong>详细行程：</strong>"+
						"<input type='text' class='easyui-textbox' id='agodaDetail' name='agodaDetail' value='"+agodaDetailval+"' data-options=\"width:1000,height:34,onLoadSuccess:function(){$(this).combobox('setValue', '"+agodaDetailval+"')}\"/></td></tr></tbody>";
					  		  
					  var showagodaTbody="<tbody name='agodaTbody'><tr><td class=style126 width=34 valign=middle  style='float:left;text-align:left'><div align=center><span name='tourdays'>"+tourdaysval+"</span></div></td>"+
						"<td class=STYLE126 style='float:left;text-align:left' valign=middle><span name='tourDesc'>"+tourDescval+"</span></td>"+
						"<td class=STYLE126 valign=middle  style='float:left;text-align:left'><span name='mileage'>"+mileageval+"</span></td><td style='float:left;text-align:left'><span name='area'>"+areatext+"</span>"+
						"<span name='travelItem'>"+travelItemtext+"</span></td></tr></tbody>";
					 showTrip+= showagodaTbody;
			});
			formData["showTrip"]=showTrip+"</table>";
			formData["beriefTrip"]=beriefTrip;
			var agodaDetail = "<table border='0' align='center' cellpadding='0' cellspacing='0' width='100%'><tbody>";
			agodaDetail+="<tr><td><img src='images/frame1-1.gif' width='100%' height='7'></td></tr>" ;
			agodaDetail+="<tr><td background='images/frame1-2.gif'></td></tr><tr><td>";
			$("table[name='routetable'] tbody[name='agodaTbody']").each(function(i,e){
				agodaDetail+="<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'><tbody>";
				agodaDetail+="<tr><td width='7%' class='STYLE148'><strong>Day "+(i+1)+" </strong></td>";
				agodaDetail+="<td width='93%'><span class='STYLE148'><strong> "+$("input[name='rtelevation']").val()+"km 住："+ $("#hotelPlace",$(e)).val()+"  </strong></span></td></tr>" ;
				agodaDetail+="<tr><td width='7%' valign='top'>&nbsp;</td>"+
	            "<td valign='top' style='text-align:left;width:90%'><span class='STYLE126'width='90%' style='width:90%'><div style='width:95%'>"+$("#agodaDetail",$(e)).val()+"</div><br>";
				var landscapes = $("#travelItem",$(e)).val();//$("#lctiValue",e).val();
				//console.log($("#travelItem",$(e)).val());
				$.ajax({url:basePath+'travelItem/queryByAlias',method:'post',async:false,data:{"alias":landscapes},success:function(traitems){
					var jsontraitems = $.parseJSON(traitems);
					$(jsontraitems).each(function(idx,ex){
						//var exphotos = eval('('+ex.photos+')');
					//	var ex =  eval('('+bean+')');
						//console.log(jsontraitems[idx].item);
						agodaDetail+="<span style='text-align:center;float:middle;'>【"+jsontraitems[idx].item+"】"+jsontraitems[idx].shortContent+"</span>";
						agodaDetail+="<table width='100%' border='0' cellspacing='1' cellpadding='1'><tbody>";
						agodaDetail+="<tr>";
						if(jsontraitems[idx].photos && jsontraitems[idx].photos.length>0){
							var jsonphotos = jsontraitems[idx].photos.split(",");
							$(jsonphotos).each(function(index,ele){
								//console.log(jsontraitems[i].photos);
								//console.log(ele);
								if(ele && ele.length>0){
									agodaDetail+="<td style='width:50%' width='50%'><div align='left'><img alt='"+jsontraitems[idx].item+"' title='"+jsontraitems[idx].item+"' src='"+ele+"' width='95%'></div></td>";
								}else{
									agodaDetail+="<td style='width:50%' width='50%'><div align='left'></div></td>";
								}
								if(index>1){
									break;
								}
								/*if(index>0&&index%4==0){
									agodaDetail+="</tr><tr>";
								}*/
							})
						}
						agodaDetail+="</tr></tbody></table>"; 
					});
				}});
                  agodaDetail+="</td></tr></tbody></table>";
			});
			agodaDetail +="</td></tr><tr><td><img src='images/frame1-3.gif' width='100%' height='7'></td></tr></tbody></table>";
			formData["agodaDetail"]=agodaDetail;
			//console.log(formData["showTrip"]);
			__.post(actionurl, formData, function(result) {
				//console.log("data.success="+data.success);
				itour.alert("提示",result.msg,"info");
				/*if (result.success) {
					_this.showSuccess(result.msg);
				} else {
					_this.showError(result.msg);
				}*/
			});
		
		},	
		dinnerPlus:function(){
			var insertDinner="<tbody><tr><td><a name='addspecialdinner'><img src='images/add.gif' width=16 height=16 ></a></td><td rowspan=3>安排特色餐： <select name='province'><option>四川</option> <option>云南</option> <option>西藏</option><option>新疆</option> </select></td></tr></tbody>"+
			"<tbody><tr><td><input name=district size=10 type=text></td>"+
	    	"<td><span class=style126>餐名：<input name=dinnername size=10 type=text>&nbsp;"+
	        "<input name=dinnerprice size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/人 </span></td>"+
	        "<td><a name='addsingledinner'><img src=images/add.gif width=16 height=16 ></a></td></tr></tbody>"+
	    	"<tbody><tr><td><input name=district size=10 type=text></td><td>餐名：<input name=dinnername size=10 type=text>&nbsp;"+
	        "<input name=dinnerprice size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
	 		 "元/人</td><td><a name='addsingledinner'><img src=images/add.gif width=16 height=16 ></a></td> </tr></tbody>";
			$("#specialdinnerblock table").append(insertDinner);
		},
		dinnerMinus:function(){
			
		},
		specialDinnerPlus:function(obj){
			var specialDinner="<tbody><tr><td><input name=district size=10 type=text></td>"+
			"<td><span class=style126>餐名：<input name=dinnername size=10 type=text>&nbsp;"+
			"<input name=dinnerprice size=6  style='width:50px'  type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/人 </span></td>"+
			"<td><a name='addsingledinner' ><img src=images/add.gif width=16 height=16 ></a></td></tr></tbody>";
			$(obj).parent().parent().parent().after(specialDinner);		
		},specialDinnerMinus:function(){
											
		},singleDinnerPlus:function(obj){
			var singledinner = " <td>餐名：<input name=dinnername size=10 type=text>&nbsp;"+
			"<input name='dinnerprice' size=6  style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/人</td>";
			$(obj).parent().before(singledinner);
		},singleDinnerMinus:function(){
			
		},
		sightPlus:function(){
			var insertBlock = "<span class=STYLE126><br> 景点名称"+
			"<input name=sight size=20 type=text>"+
			"<input name=sightprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"元/人<a name=minusSight><img src=images/minus.png onclick='javascript:itouren.quoteEdit.sightMinus(this)' width=20 height=20 ></a></span>";
			$("#addsightdiv").append(insertBlock);
		},
		sightMinus:function(e){
			 $(e).parent().parent().remove();
		},
		routePlus:function(){
			var insertTr ="<tbody name='agodaTbody'><tr>" +
			"<td class=STYLE126 width=308 valign=middle><input type='text' data-options='width:308' class='easyui-textbox' name='tourDesc' id='tourDesc'></td>" +
			"<td class=STYLE126 width=50 valign=middle><input name='mileage' id='mileage' class='easyui-textbox' type='number' min=0 " +
			"onkeyup=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) " +
			"onafterpaste=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) " +
			"onblur=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)></td>" +
			"<td class=STYLE126 width=124 valign=middle><input name='area' id='area' class='easyui-combobox' data-options=\"cursor:'pointer',width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'areas/allAreas'," +
			"onChange:function(n,o){ var urlurl = 'travelItem/queryByScope?scope='+n ;$(this).parents('tbody').find('#travelItem').combobox('reload',urlurl);}\">" +
			"&nbsp;&nbsp;<input id='travelItem' name='travelItem' class='easyui-combobox'  " +																																		//type=checkbox 
			" data-options=\"cursor:'pointer',valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,width:151,height:22," +
			"formatter:function(row){return '<option class=selectId style=cursor:pointer,vertical-align:middle name=selectId_'+row.alias+' value='+row.alias+'>'+row.item+'</option>';}," +
			"onSelect:function(record){$('option[name=selectId_'+record.alias+']',$(this)).attr('selected', 'true');}," +
			"onUnselect:function(record){$('option[name=selectId_'+record.alias+']',$(this)).attr('selected', 'false');}" +
			",onChange:function(n,o){$('#lctiValue').val($('#lctiValue').val()+n)}\"/><input type='hidden' name='lctiValue' id='lctiValue'/></td>" +
			"<td class=STYLE126 valign=middle><input type='text' data-options='' class='easyui-textbox' name='hotelPlace' id='hotelPlace'></td>"+
			"<td><a name='routeminus' onclick='javascript:itouren.quoteEdit.routeMinus(this)'><img alt='' style='height:16px;height:16px;' title='删除本行' src='images/minus.png' ></a></td></tr>" +
			"<tr><td class=STYLE126 colspan='5' style='text-align:left;'><strong>详细行程：</strong>" +
			"<input type='text' class='easyui-textbox' name='agodaDetail' id='agodaDetail' data-options='width:1000,height:34'/></td></tr></tbody>" ;
			$("table[name='routetable']").append(insertTr);
			var agodaTableLen = $("table[name='routetable'] tbody[name='agodaTbody']").length;
			$.parser.parse($("table[name='routetable'] tbody[name='agodaTbody']:eq("+(agodaTableLen-1)+")"));
		},
		routeMinus:function(e){
			$(e).parent().parent().parent().remove();
		},
		cardPlus:function(){
			var insertBlock="<span class=STYLE126><br> "+
	        "<input name=card size=20 type=text>&nbsp;&nbsp;"+
	        "<input name=cardprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
	        "元/人&nbsp;&nbsp;备注：<input name=cardremark size=20 type=text><a name=minusCard><img src=images/minus.png onclick='javascript:itouren.quoteEdit.sightMinus(this)' width=20 height=20 ></a></span>";
			$("#addcarddiv").append(insertBlock);
		},cardMinus:function(e){
			 $(e).parent().parent().remove();
		},
		guidePlus:function(){
			var insertBlock="<span class=style126>"+
			"<br><input name=alltheway value=全程 size=10 type=text>"+
          "<select name=choselanguage id=choselanguage>"+
            "<option>选择语种</option>"+
            "<option value=中文>中文</option>"+
            "<option value=英文>英文</option>"+
          "</select>&nbsp;&nbsp;"+
        "<input name=priceperday size=6  style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
        "元/天 &nbsp;&nbsp;X "+
          "<input name=days  size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
          	"天 &nbsp;&nbsp;备注：<input name=guideremark size=10 type=text>" +
          	"<a name=guideminus onclick='javascript:itouren.quoteEdit.guideMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>"	;
			$("#addGuideDiv").append(insertBlock);
		},guideMinus:function(e){
			$(e).parent().remove();
		},
		carPlus:function(){
			var insertBlock="  <span class=STYLE126> <br>   "+
			"<input name=alltheway value=全程 size=10 type=text>&nbsp;&nbsp;"+
			"<input name=carprice size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
        	"元/ <select name=carstyle id=carstyle>"+
            "<option selected=selected>方式</option>"+
            "<option value=天>天</option>"+
            "<option value=公里>公里 </option>"+
            "<option value=趟>趟</option>"+
	          "</select>"+
	          "X<input name=carcount size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
             	"数量&nbsp;&nbsp;　备注： "+
              "<input name=carremark size=20 type=text>"+
              "<a name=carminus onclick='javascript:itouren.quoteEdit.carMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#addcardiv").append(insertBlock);
		},
		carMinus:function(e){
			$(e).parent().remove();
		},trafficPlus:function(){
			var insertBlock="<span class=STYLE126><br> "+
			"<input name='traffic' type='text' >"+
			"<input name=trafficperprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
        	"元/ 人 &nbsp;&nbsp;备注： <input name=trafficremark size=20 type=text>" +
        	"<a name=trafficminus onclick='javascript:itouren.quoteEdit.trafficMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#addbigtrafficdiv").append(insertBlock);
		},trafficMinus:function(e){
			$(e).parent().remove();
		},insurancePlus:function(){
		  var insertBlock="<span class=style126><br><select name=insuranceselect id=insuranceselect>"+
          "<option value=人>内宾旅游意外保险</option>"+
          "<option value=团>入境旅游意外保险</option>"+
          "</select>"+
          "<input name=insuranceprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
          	"元/人&nbsp;&nbsp;备注："+
            "<input name=insuranceremark size=20 type=text>"+
            "<a name=insuranceminus onclick='javascript:itouren.quoteEdit.insuranceMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#insurancediv").append(insertBlock);
		},insuranceMinus:function(e){
			$(e).parent().remove();
		},allfeePlus:function(){
			var insertBlock="<span class=style126><br>"+
      "<input name=feeName value='旅行社综合服务费' size=20 type=text>"+
          "<input name=feeperperson size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
       	"元/人&nbsp;&nbsp;备注："+
        "<input name=feeremark size=20 type=text>"+
      "<a name=allfeeminus onclick='javascript:itouren.quoteEdit.allfeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
		$("#allfeesdiv").append(insertBlock);
		},allfeeMinus:function(e){
			$(e).parent().remove();
		},joyPlus:function(){
			var insertBlock="<span class=STYLE126><br>"+
			"<input name=joyitem size=20 type=text>"+
            "<input name=perjoyprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
      		"元/人　&nbsp;&nbsp;备注："+
      		"<input name=joyremark size=20 type=text>"+
      		"<a name=joyminus onclick='javascript:itouren.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#addjoysdiv").append(insertBlock);
		},
		joyMinus:function(e){
			$(e).parent().remove();
		},hikingGuidePlus:function(){
			var insertBlock="<span class=style126> <br>"+
			"<input name=hikingitem size=20 type=text>"+
			"<input name=guidename size=4 type=text>"+
			"向导数 X"+
			"<input name=guideperday size=6 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"元/天 X  "+
			"<input name=guidedays size=4 style='width:50px' type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
        	"天　&nbsp;&nbsp;备注："+
        	"<input name=hikingguideremark size=20 type=text>"+
          	"<a name=joyminus onclick='javascript:itouren.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> ";
		$("#hikingguidediv").append(insertBlock);
		},hikingGuideMinus:function(e){
			$(e).parent().remove();
		},bathhorsePlus:function(){
			var insertBlock="<span class=STYLE126><br><input name=bathorseCost size=20 type=text>"+
			"<input name=bathorsenum size=4 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) \" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"马匹数 X<input name=bathorseperday size=6 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"元/天  X  <input name=bathorseprice size=4 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
         	 "天　&nbsp;&nbsp;备注：<input name=bathorseremark size=20 type=text> <a name=bathorseminus onclick='javascript:itouren.quoteEdit.bathhorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> ";
			$("#bathorseCostdiv").append(insertBlock);
		},bathhorseMinus:function(e){
			$(e).parent().remove();
		},ridehorsePlus:function(){
			var insertBlock=" <span class=style126><br>"+
			"<input name='ridehorse' size=20 type='text'>"+
			"<input name='ridehorseperday' size=6 type='text'>"+
       		"元/天  X<input name='ridehorsedays' size=4 type='text'>天　&nbsp;&nbsp;备注："+
       		"<input name='ridehorseremark' size=20 type='text'>"+
            "<a name='rideorseminus' onclick='javascript:itouren.quoteEdit.ridehorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> 　";
			$("#addridehorseCost").append(insertBlock);
		},ridehorseMinus:function(e){
			$(e).parent().remove();
		},climbRegisterPlus:function(){
			var insertSpan="<span class=style126><br>"+
				"<input name=climbRegister size=20 type=text>&nbsp;&nbsp;<input name=climbRegisterperday size=6 type=text>"+
				"元/天  X<input name=climbRegisterdays size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"天　&nbsp;&nbsp;备注：<input name=climbRegisterremark size=20 type=text>"+
				"<a name=climbRegisterminus onclick='javascript:itouren.quoteEdit.climbRegisterMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span";
				$("#climbregisterdiv").append(insertSpan);
		},climbRegisterMinus:function(e){
			$(e).parent().remove();
		},climbnexusPlus:function(){
			var insertSpan="<span class=style126><br>"+
				"<input name=climbnexus size=20 type=text><input style='width:50px;' name=climbnexusnum value=1 size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">人数 X"+
				"<input name=climbnexusperday style='width:50px;' size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/天  X  "+
				"<input name=climbnexusdays style='width:50px;' size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">天　&nbsp;&nbsp;备注："+
				"<input name=climbnexusremark size=20 type=text>"+
				"<a name=climbnexusminus onclick='javascript:itouren.quoteEdit.climbnexusMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></span>";
				$("#climbnexusdiv").append(insertSpan);
		},climbnexusMinus:function(e){
			$(e).parent().remove();
		},elsefeePlus:function(){
			var insertSpan="<span class=STYLE126><br>"+
			"<input name=elseitem size=20 type=text>"+
			"<input name=elseitemprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
       	 	" 元/	<select name=elseitemstyle id=elseitemstyle>"+
       	 	" <option selected=selected>方式</option>"+
       	 	" <option value=人>人</option>"+
       	 	" <option value=团>团</option>"+
       	 	"</select>&nbsp;&nbsp;备注：<input name=elseitemremark size=20 type=text>"+
           	" <a name=elseitemminus onclick='javascript:itouren.quoteEdit.elsefeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></span>";
			$("#elseitemdiv").append(insertSpan);
		},elsefeeMinus:function(e){
			$(e).parent().remove();
		},
		showSuccess:function (str) {
			$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
				opacity : 1,
				right : '0'
			}, 500);
		},
		showError:function (str) {//显示错误提示
			$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
				opacity : 1,
				right : '0'
			}, 500);

		},
		initTravelItem:function(e){
			$("select[name='travelItem']",e).combobox({
			url:'travelItem/allItems',
			valueField:'alias',
			textField:'item',
			multiple:true,
			method:'get',
		    editable : false  ,
			formatter:function(row){
			   var s = "<span><input type='checkbox' class='selectId' style='vertical-align: middle' id='selectId_"+row.alias+"' value="+row.alias+">"+row.item+"<span>"
			   return s;  
			},
			onSelect:function(record){
				$("#selectId_"+record.alias).attr("checked", true);
			},
			onUnselect:function(record){
				$("#selectId_"+record.alias).attr("checked", false);
			}
		})},
		checkedAll:function (name){//全选
		  var names=document.getElementsByName(name);
		  var len=names.length;
		  if(len>0){
		   for(var i=0;i<len;i++)
		   names[i].checked=true;
		  }
		},
		uncheckedAll:function (name){//全不选
			var names=document.getElementsByName(name);
			var len=names.length;
			if(len>0){
			    for(var i=0;i<len;i++)
			    names[i].checked=false;
			  }
		},
		formatterDate : function(date) {//得到当前日期
			var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
			var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1);
			return date.getFullYear() + '-' + month + '-' + day;
		},
		onChangeDate: function(obj,date){  
            $(obj).prev().val(date);  
        },
		init:function(){
	/*	   $("input[name='tourTime']").datebox({  
			   onSelect:function(date){  
			            var nowDate = new Date();  
			            if(date<=nowDate){  
			            	itouren.alert("提示","选择行程安排日期应在当前日期之后","info" );
			                $("input[name='tourTime']").datebox('setValue','');  
			                return false;
			            }else{
			            	return true;
			            }  
			        }  
		    }); */
			$("input[name='rtbtn']").click(_this.saveQuoteForm);
			$("input[name='route_checkall']").click(function(){
				if($(this).attr("checked")){
					_this.checkedAll("breakfast");
					_this.checkedAll("lunch");
					_this.checkedAll("dinner");
				}else{
					_this.uncheckedAll("breakfast");
					_this.uncheckedAll("lunch");
					_this.uncheckedAll("dinner");
				}
			});
			$("a[name='routeplus']").click(_this.routePlus);
			$("a[name='addSight']").click(function(){_this.sightPlus()});
			$("a[name='addCard']").click(function(){_this.cardPlus()});
			$("a[name='addGuide']").click(function(){_this.guidePlus()});  
			$("a[name='addusecar']").click(function(){_this.carPlus()});
			$("a[name='addbigtraffic']").click(function(){_this.trafficPlus()});
			$("a[name='addinsurance']").click(function(){_this.insurancePlus()});
			$("a[name='addallfees']").click(function(){_this.allfeePlus()});
			$("a[name='addjoys']").click(function(){_this.joyPlus()});
			$("a[name='addhikingguide']").click(function(){_this.hikingGuidePlus()});   
			$("a[name='addbathorseCost']").click(function(){_this.bathhorsePlus()});
			$("#addridehorseCost").click(function(){_this.ridehorsePlus()});
			$("a[name='addclimbregisterCost']").click(function(){_this.climbRegisterPlus()});
			$("a[name='addclimbnexusCost']").click(function(){_this.climbnexusPlus()});
			$("a[name='addelseitem']").click(function(){_this.elsefeePlus()}); 
			$("a[name='adddinner']").click(function(){_this.dinnerPlus()});
			$("a[name='addspecialdinner']").live('click',function(){_this.specialDinnerPlus(this)});
			$("a[name='addsingledinner']").live('click',function(){_this.singleDinnerPlus(this)}); 
		    /*$("#tourTime").datebox({  //tourTimeinput
		          
		    });*/ 
			/*$.datepicker.setDefaults({
				  showOn: "both",
				  buttonImageOnly: true,
				  buttonImage: "calendar.gif",
				  buttonText: "Calendar"
				});*/
			//$("input[name='tourTime']").datepicker({ altFormat: 'yyyy-MM-dd' });
		//	 $("input[name='tourTime']").datepicker("option", "dateFormat", 'yyyy-MM-dd');
			$.extend($.fn.validatebox.defaults.rules,{  
			    dateValided : {  
			        validator : function(value) { //参数value为当前文本框的值
			        	var d =  _this.formatterDate(new Date());
			        //	itour.alert('提示',value +"    "+ d+"   "+(value > d),'info');
			           if(d>=value){
			        	   //itouren.alert('提示','选择行程安排日期应在当前日期之后','warn');
			        	   //$("input[name='tourTime']").datebox('setValue','');  
			           }else{
			        	   return value > d;  
			           }
			        },  
			        message : '选择行程安排日期应在当前日期之后'  //
			    }  
			}); 
		} 
	}
	return _this;
}();
$(function(){
	itouren.quoteEdit.init();
//	  if (window != top)
//          top.location.href = location.href;
});
