$package('itour.quoteEdit');
itour.quoteEdit = function(){
	var _box = null;
	var _this = {
		saveQuoteForm:function(){
			document.forms["quoteEditForm"].target="rfFrame";
			var formData = new Object();
			var actionurl=basePath+"routeTemplate/updateQuoteForm";
			formData["routeTemplate"]  = $('input[name="rtId"]').val();
			//formData.quoteEditForm = $("form[name='quoteEditForm']").html();
			formData["adults"] = $("input[name='adults']").val();
			formData["children"]=$("input[name='children']").val();
			formData["isAsAdult"] = $("input[name='isAsAdult'][value='isAsAdult']").attr("checked")||$("input[name='isAsAdult'][value='isAsAdult']").attr("checked")=="checked"?true:false;
			formData["ticketBlock"]= $("#addsightdiv").html();
			formData["ticketAsadult"]=$("input[name='ticketAsadult']").is(':checked');
			formData["travelDocs"]=$("#addcarddiv").html();
			formData["traveldocAsadult"]=$("input[name='traveldocAsadult']").is(':checked');	
			formData["tourGuide"]=$("#addGuideDiv").html();
			formData["tourguideAsadult"]=$("input[name='tourguideAsadult']").is(':checked');	
			//formData.hotel=
			//formData.hotelAsadult=$("input[name='hotelAsadult']").is(':checked');	
			formData["rentCar"]=$("#addcardiv").html();
			formData["rentcarAsadult"]=$("input[name='rentcarAsadult']").is(':checked');	
			formData["bigTrafficSum"]=$("input[name='train-ticket'][value='bigTrafficSum']").attr("checked")||$("input[name='train-ticket'][value='bigTrafficSum']").attr("checked")=="checked"?true:false;
			formData["bigTraffic"]=$("#addbigtrafficdiv").html();
			formData["bigtrafficeAsadult"]=$("input[name='bigtrafficeAsadult']").is(':checked');
			formData["dinner"]=$("#dinnerblock").html();
			formData["insurance"]=$("#insurancediv").html();
			formData["insuranceAsadult"]=$("input[name='insuranceAsadult']").is(':checked');	
			formData["comprehensiveCosts"]=$("#allfeesdiv").html();
			formData["comphcostAsadult"]=$("input[name='comphcostAsadult']").is(':checked');	
			formData["recreation"]=$("#addjoysdiv").html();
			formData["recreationAsadult"]=$("input[name='recreationAsadult']").is(':checked');	
			formData["itemGuide"]=$("#hikingguidediv").html();
			formData["itemguideAsadult"]=$("input[name='itemguideAsadult']").is(':checked');	
			formData["bathorseCost"]=$("#bathorseCostdiv").html();
			formData["bathcostAsadult"]=$("input[name='bathcostAsadult']").is(':checked');	
			formData["ridehorseCost"]=$("#ridehorseCostdiv").html();
			formData["ridecostAsadult"]=$("input[name='ridecostAsadult']").is(':checked');	
			formData["climbRegisterCost"]=$("#climbregisterdiv").html();
			formData["climbrcostAsadult"]=$("input[name='climbrcostAsadult']").is(':checked');	
	  		formData["climbNexusCost"]=$("#climbnexusdiv").html();
			formData["climbncostAsadult"]=$("input[name='climbncostAsadult']").is(':checked');	
			formData["elseCost"]=$("#elseitemdiv").html();
			formData["elsecostAsadult"]=$("input[name='elsecostAsadult']").is(':checked');	
			formData["presented"]=$("input[name='presented']").val();
			var sights = $("#addsightdiv").find("input[name='sight']");
			var sightprices =  $("#addsightdiv").find("input[name='sightprice']");
			var showTicket ="";
			var ticketpricesum=0;
			if(sights.length>0 && sightprices.length>0){
				for(var i=0;i<sights.length;i++){
					ticketpricesum+=parseFloat(sightprices[i].value);
					showTicket+=(parseInt(i)+1)+"."+sights[i].value+"门票"+sightprices[i].value+"元/人<br/>";
				}
			}
			formData["showTicket"]=ticketpricesum+"|"+showTicket;
			var cards = $("#addcarddiv").find("input[name='card']");
			var cardprices =  $("#addcarddiv").find("input[name='cardprice']");
			var showTraveldoc = "";
			var totalcardprices=0;
			if(cards.length>0 && cardprices.length>0){
				for(var i=0;i<cards.length;i++){
					totalcardprices+=parseFloat(cardprices[i].value);
					showTraveldoc+=(parseInt(i)+1)+"."+cards[i].value+"价格"+cardprices[i].value+"元/人<br/>";
				}	
			}
	        formData["showTraveldoc"]=totalcardprices+"|"+showTraveldoc;
	        var showTourguide ="";
	        var alltheway = $("#addGuideDiv").find("input[name='alltheway']");
	        var choselanguage = $("#addGuideDiv").find("select[name='choselanguage']");
	        var priceperday = $("#addGuideDiv").find("input[name='priceperday']");
	        var totalpriceperday=0;
	      //  console.log(choselanguage.length+"   "+$(choselanguage[0]).find("option:selected").val()+"  "+$(choselanguage[0]).html());
			if(alltheway.length>0 && choselanguage.length>0 && priceperday.length>0){
				for(var i=0;i<alltheway.length;i++){
		        	var selectedlanguage = $(choselanguage[i]).find("option:selected").val();
		        	//console.log(selectedlanguage);
		        	//console.log(choselanguage[i].options[choselanguage[i].selectedIndex].value+"   "+choselanguage[i].selectedIndex);
		        	totalpriceperday+=parseFloat(priceperday[i].value);
		        	showTourguide+=(parseInt(i)+1)+"."+alltheway[i].value+" "+(selectedlanguage?selectedlanguage:"")+" "+priceperday[i].value+"元/天<br/>";
		        }
			}
		    formData["showTourguide"]=totalpriceperday+"|"+showTourguide;
		/*  var showHotel = "";
            var stayposition = $("table[name='routetable']").find("input[name='stayposition']");
            var hotel = $("table[name='routetable']").find("select[name='hotel']");
            var selfhotel = $("table[name='routetable']").find("input[name='selfhotel']");
            var hotelprice = $("table[name='routetable']").find("input[name='hotelprice']");
            var totalhotelprice=0;
            if(stayposition.length>0 &&hotel.length>0 &&selfhotel.length>0 &&hotelprice.length>0){
            	for(var i=0;i<stayposition.length;i++){
	            	//showHotel+=(i+1)+"."+(selfhotel[i].value?selfhotel[i].value:hotel[i].options[hotel[i].selectedIndex].value)+"  "+hotelprice[i].value+"/间/夜<br/>"
	            	var selectedhotel = $(hotel[i]).find("option:selected").text();
	            	totalhotelprice+=parseFloat(hotelprice[i].value);
        		    showHotel+=(parseInt(i)+1)+"."+(selfhotel[i].value?selfhotel[i].value:(selectedhotel?selectedhotel:""))+"  "+hotelprice[i].value+"/间/夜<br/>"
            	}
            }
            formData["showHotel"]=totalhotelprice+"|"+showHotel;*/
            var showRentcar = "";
            var carway = $("#addcardiv").find("input[name='alltheway']");
            var carprice = $("#addcardiv").find("input[name='carprice']");
            var carstyle = $("#addcardiv").find("select[name='carstyle']");
            var carpricesum = 0;
			if(carway.length>0 && carprice.length>0 && carstyle.length>0){
				for(var i=0;i<carway.length;i++){
	            	//showRentcar+=(i+1)+"."+ carway[i].value+"  "+carprice[i].value+"  "+carstyle[i].options[carstyle[i].selectedIndex].value+"元/天<br/>";
	            	var selectedcarstyle = $(carstyle[i]).find("option:selected").val();
	            	var resultstr = carway[i].value+"  "+carprice[i].value+"  "+(selectedcarstyle?selectedcarstyle:"");
	            	carpricesum+=parseFloat(carprice[i].value);
	            	showRentcar+=(parseInt(i)+1)+"."+ resultstr+"元/天<br/>";
	            }
			}
            formData["showRentcar"]=carpricesum+"|"+showRentcar;
            var showBigtraffic="";
            var traffic=$("#addbigtrafficdiv").find("input[name='traffic']");
            var trafficperprice =$("#addbigtrafficdiv").find("input[name='trafficperprice']");
            var totaltrafficperprice=0;
			if(traffic.length>0 && trafficperprice.length>0){
				for(var i=0;i<traffic.length;i++){
					totaltrafficperprice+=parseFloat(trafficperprice[i].value);
	            	showBigtraffic+=(parseInt(i)+1)+"."+traffic[i].value+" "+trafficperprice[i].value+"元/人<br/>";
	            }
			}
            formData["showBigtraffic"]=totaltrafficperprice+"|"+showBigtraffic;
            var showDinner = "";
        /*    var breakfast = $("input[type='checkbox'][name='breakfast']:checked");
            var lunch = $("input[type='checkbox'][name='lunch']:checked");
            var dinner = $("input[type='checkbox'][name='dinner']:checked");
            var singledinnerprice = $("#dinnerblock").find("input[name='singledinner']").val();
            var totaldinnerprice=(lunch.length+dinner.length)*singledinnerprice;
            showDinner+="早餐酒店用，共"+breakfast.length+"餐,正餐共"+(lunch.length+dinner.length)+"餐，每餐价格"+singledinnerprice+"元/人<br/>";*/
            var dinnername = $("#dinnerblock").find("input[name='dinnername']");
            var dinnerprice = $("#dinnerblock").find("input[name='dinnerprice']");
            var districts = $("#dinnerblock").find("input[name='district']");
            var totaldinnerprice = 0;
    		if(dinnername.length>0 && dinnerprice.length>0){
    			showDinner+="特色餐"+dinnername.length+"餐（";
    			for(var i=0;i<dinnername.length;i++){
    				totaldinnerprice+=parseFloat(dinnerprice[parseInt(i)+1].value);
	            	showDinner+=districts[i].value+ "  "+ dinnername[i].value+"  "+dinnerprice[parseInt(i)+1].value+"元/人、";
	            	if(i%2==0)showDinner+="<br/>";
	            }
	            showDinner+="）";
    		}
            formData["showDinner"]=totaldinnerprice+"|"+showDinner;
            var showInsurance = "";
            var insuranceselect = $("#insurancediv").find("select[name='insuranceselect']");
            var insuranceprice =  $("#insurancediv").find("input[name='insuranceprice']");
            var totalinsuranceprice=0;
            if(insuranceselect.length>0 && insuranceprice.length>0){
	        	for(var i=0;i<insuranceselect.length;i++){
	            	//showInsurance+=insuranceselect[i].options[insuranceselect[i].selectedIndex].value+" "+insuranceprice[i].value+"元/人<br/>";
	            	var insuranceselectvalue = $(insuranceselect[i]).find("option:selected").text();
	            	totalinsuranceprice+=parseFloat(insuranceprice[i].value);
	            	showInsurance+=insuranceselectvalue?insuranceselectvalue:""+" "+insuranceprice[i].value+"元/人<br/>";
	            }
			}
            formData["showInsurance"]=totalinsuranceprice+"|"+showInsurance;
            var showComphcost = "";
            var feeName = $("#allfeesdiv").find("input[name='feeName']");
            var feeperperson = $("#allfeesdiv").find("input[name='feeperperson']");
            var totalfeeperperson=0;
            if(feeName.length>0 && feeperperson.length>0){
            	for(var i=0;i<feeName.length;i++){
            		//console.log(feeName[i].innerHTML+"  "+feeperperson[i].innerHTML);
            		totalfeeperperson+=parseFloat(feeperperson[i].value);
            		showComphcost+=feeName[i]?feeName[i].value:""+" "+feeperperson[i]?feeperperson[i].value:""+"元/人<br/>";
            	}
            }
            formData["showComphcost"]=totalfeeperperson+"|"+showComphcost;
            var showRecreation = "";
            var joyitem=$("#addjoysdiv").find("input[name='joyitem']");
            var perjoyprice=$("#addjoysdiv").find("input[name='perjoyprice']");
            var totalperjoyprice=0;
            if(joyitem.length > 0 && perjoyprice.length > 0){
            	for(var i=0;i<joyitem.length;i++){
            		totalperjoyprice+=parseFloat(perjoyprice[i].value);
	            	showRecreation+=joyitem[i].value+"  "+perjoyprice[i].value+"元/人<br/>";
	            }
            }
            formData["showRecreation"]=totalperjoyprice+"|"+showRecreation;
            var showItemguide = "";
            var hikingitem = $("#hikingguidediv").find("input[name='hikingitem']");
            var guidename = $("#hikingguidediv").find("input[name='guidename']");
            var guideperday = $("#hikingguidediv").find("input[name='guideperday']");
            var totalguideperday=0;
            if(hikingitem.length>0 && guidename.length>0 && guideperday.length>0){
            	for(var i=0;i<hikingitem.length;i++){
            		totalguideperday+=parseFloat(guideperday[i].value);
            		showItemguide+="项目："+hikingitem[i].value+"向导名："+guidename[i].value+"  "+guideperday[i].value+"元/天";
            	}
        	}
            formData["showItemguide"]=totalguideperday+"|"+showItemguide;
            var showBathorse = "";
            var bathorseCost=$("#bathorseCostdiv").find("input[name='bathorseCost']");
            var bathorsenum=$("#bathorseCostdiv").find("input[name='bathorsenum']");
            var bathorseperday = $("#bathorseCostdiv").find("input[name='bathorseperday']");
            var bathorseprice=$("#bathorseCostdiv").find("input[name='bathorseprice']");
            var totalbathorseperday=0;
            if(bathorseCost.length>0 && bathorsenum.length>0 && bathorseperday.length>0 && bathorseprice.length>0){
            	for(var i=0;i<bathorseCost.length;i++){
            		totalbathorseperday+=parseFloat(bathorseperday[i].value);
            		showBathorse+="项目："+bathorseCost[i].value+"马匹数："+bathorsenum[i].value+"  "+bathorseperday[i].value+"元/天  单匹价格："+bathorseprice[i].value+"<br/>";
            	}
            }
            formData["showBathorse"]=totalbathorseperday+"|"+showBathorse;
            var showRidehorse = ""; 
            var ridehorse = $("#ridehorseCostdiv").find("input[name='ridehorse']");
            var ridehorseperday = $("#ridehorseCostdiv").find("input[name='ridehorseperday']");
            var totalridehorseperday=0;
            if(ridehorse.length>0 && ridehorseperday.length>0){
            	for(var i=0;i<ridehorse.length;i++){
            		totalridehorseperday+=parseFloat(ridehorseperday[i].value);
	            	showRidehorse+="项目："+ridehorse[i].value+"  "+ridehorseperday[i].value+"元/天<br/>";
	            }
            }
            formData["showRidehorse"]=totalridehorseperday+"|"+showRidehorse;
            var showClimbregister = "";
            var climbRegister = $("#climbregisterdiv").find("input[name='climbRegister']");
            var climbRegisterperday = $("#climbregisterdiv").find("input[name='climbRegisterperday']");
            var totalclimbRegisterperday=0;
            if(climbRegister.length>0 && climbRegisterperday.length>0){
            	for(var i=0;i<climbRegister.length;i++){
            		totalclimbRegisterperday+=parseFloat(climbRegisterperday[i].value);
	            	showClimbregister+="项目："+climbRegister[i].value+"   "+climbRegisterperday[i].value+"元/天<br/>";
	            }
            }
            formData["showClimbregister"]=totalclimbRegisterperday+"|"+showClimbregister;
            var showClimbnexus = "";
            var climbnexus = $("#climbnexusdiv").find("input[name='climbnexus']");
            var climbnexusperday = $("#climbnexusdiv").find("input[name='climbnexusperday']");
            var climbnexusdays = $("#climbnexusdiv").find("input[name='climbnexusdays']");
            var totalclimbnexusperday=0;
            if(climbnexus.length> 0 && climbnexusperday.length>0&& climbnexusdays.length>0){
            	for(var i=0;i<climbnexus.length;i++){
            		totalclimbnexusperday+=parseFloat(climbnexusperday[i].value);
            		showClimbnexus+="项目："+climbnexus[i].value+" 天数:"+climbnexusdays[i].value+" "+climbnexusperday[i].value+"元/天<br/>";
            	}
            }
            formData["showClimbnexus"]=totalclimbnexusperday+"|"+showClimbnexus;
            var showElsecost = "";
            var elseitem = $("#elseitemdiv").find("input[name='elseitem']");
            var elseitemprice = $("#elseitemdiv").find("input[name='elseitemprice']");
            var elseitemstyle = $("#elseitemdiv").find("select[name='elseitemstyle']");
            var totalshowElsecost=0;
            if(elseitem.length> 0 && elseitemprice.length>0 && elseitemstyle.length>0){
            	for(var i=0;i<elseitem.length;i++){
	            	//showElsecost+="项目："+elseitem[i].value+"  "+showElsecost[i].value+"元/天"+elseitemstyle[i].options[elseitemstyle[i].selectedIndex].value+"<br/>";
	            	var selectedelseitemstyle = $(elseitemstyle[i]).find("option:selected").val();
	            	totalshowElsecost+=parseFloat(elseitemprice[i].value);
	            	showElsecost+="项目："+elseitem[i]?elseitem[i].value:""+"  "+elseitemprice[i]?elseitemprice[i].value:""+"元/天"+selectedelseitemstyle?selectedelseitemstyle:""+"<br/>";
            	}
        	}
          formData["showElsecost"]=totalshowElsecost+"|"+showElsecost;
	  	 var showTrip="<table name='showTrip'  width='1140' cellspacing='1' cellpadding='5' border='0' align='center'><thead><tr>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0' height='31'><div class='style18' align='center'><div align='center'><strong><strong>天数</strong></strong></div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0'><div class='STYLE18' align='center'><div align='center'><strong><strong>行程</strong></strong></div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0'><div class='STYLE18' align='center'><div align='center'>里程</div></div></td>"+
          "<td class='STYLE129' valign='middle' bgcolor='#F0F0F0'><div class='STYLE18' align='center'><div align='center'>景点</div></div></td>"+
          "</tr></thead>";
        var beriefTrip="";
			var agodaTbodys =$("table[name='routetable'] tbody[name='agodaTbody']");
			$(agodaTbodys).each(function(i,e){
				//  if(i!=agodaTbodys.length-1){
					  var tourdaysval = $("#tourdays",$(e)).val();
					  //console.log("tourdaysval="+tourdaysval);
					  //$("#tourdays",beriefagodaTbody).val(tourdaysval);
					  //$("span[name='tourdays']",showagodaTbody).text(tourdaysval);
					  var tourDescval = $("#tourDesc",$(e)).val();
					  //console.log("tourDescval="+tourDescval);
					  //$("#tourDesc",beriefagodaTbody).val(tourDescval);
					  //$("span[name='tourDesc']",showagodaTbody).text(tourDescval);
					  var mileageval = $("#mileage",$(e)).val();
					  //console.log("mileageval="+mileageval);
					  //$("#mileage",beriefagodaTbody).val(mileageval);
					  //$("span[name='mileage']",showagodaTbody).text(mileageval);
					  var areaval = $("#area",$(e)).val();// $("#area",$(e)).combobox('getValue');
					 // console.log("areaval="+areaval);
					  var areatext = $("#area",$(e)).combobox('getText');//$("#area",$(e)).combobox('getText');
					  //console.log("areatext="+areatext);
					 // $("#area",beriefagodaTbody).val(areaval);//combobox('setValue',areaval);
					 // $("span[name='area']",showagodaTbody).text(areatext);
					  var travelItemval = $("#travelItem",$(e)).val();
					  var travelItemtext = $("#travelItem",$(e)).combobox('getText');
					 // console.log("travelItemval="+travelItemval+"travelItemtext"+travelItemtext);
					 // $("#travelItem",beriefagodaTbody).val(travelItemval);//combobox('setValue',travelItemval);
					 // $("span[name='travelItem']",showagodaTbody).text(travelItemtext);
					  var agodaDetailval = $("#agodaDetail",$(e)).val();//combobox('getValue');
					 // console.log("agodaDetailval="+agodaDetailval);
					  //$("#agodaDetail",beriefagodaTbody).val(agodaDetailval);//combobox('setValue',agodaDetailval);
					  //$("span[name='agodaDetail']",showagodaTbody).text(agodaDetailval);
					  beriefTrip+="<tbody name='agodaTbody'><tr><td class=style126 width=34 valign=middle><div align=center><select class='easyui-combobox' id='tourdays' name='tourdays' data-options=\"width:50,editable:false,onLoadSuccess:function(){$(this).combobox('setValue', "+tourdaysval+")}\">" +
				  		"<option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option>" +
				  		"<option value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option>" +
				  		"<option value='9'>9</option><option value='10'>10</option><option value='11'>11</option>" +
				  		"<option value='12'>12</option><option value='13'>13</option><option value='14'>14</option>" +
				  		"<option value='15'>15</option></select></div></td>"+
						"<td class=STYLE126 width=308 valign=middle><input type='text' class='easyui-textbox' value='"+tourDescval+"' data-options=\"width:308,onLoadSuccess:function(){$(this).combobox('setValue', '"+tourDescval+"')}\" id='tourDesc' name='tourDesc'></td>"+
						"<td class=STYLE126 width=50 valign=middle><input name='mileage' id='mileage' class='easyui-textbox' value='"+mileageval+"' data-options=\"onLoadSuccess:function(){$(this).combobox('setValue', '"+mileageval+"')}\" type='number' min=0 "+
						"onkeyup='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)'" +
						"onafterpaste='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" +
						"onblur='(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)'></td>"+
						"<td class=STYLE126 width=124 valign=middle><input name='area' id='area' class='easyui-combobox' style='cursor:pointer'  data-options=\"width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'areas/allAreas',"+
						"onChange:function(n,o){ var urlurl = 'travelItem/queryByScope?scope='+n ;$(this).parents('tbody').find('#travelItem').combobox('reload',urlurl);},onLoadSuccess:function(){$(this).combobox('setValue', '"+areaval+"')}\">"+
						"<input id='travelItem' style='cursor:pointer' name='travelItem' class='easyui-combobox'"+																																						//type=checkbox
						" data-options=\"valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,required:true,width:151,height:22," +
						"formatter:function(row){return '<option  class=selectId style=vertical-align:middle name=selectId_1491992423815'+row.alias+' value='+row.alias+'>'+row.item+'</option>';}," +
						"onSelect:function(record){$('option[name=selectId_1491992423815'+record.alias+']',$(this)).attr('selected', 'true');}," +
						"onUnselect:function(record){$('option[name=selectId_1491992423815'+record.alias+']',$(this)).attr('selected',false);}" +
						",onLoadSuccess:function(){var travelItemval ='"+travelItemval+"';$(this).combobox('setValues',travelItemval.split(',')); }" +
						"\"/></td>"+
						"<td><a name='routeminus' onclick='javascript:itour.quoteEdit.routeMinus(this)'><img alt='' title='删除本行' style='height:16px;height:16px;' src='images/minus.png' ></a></td></tr>"+
						"<tr><td class=STYLE126 width=100 valign=middle><strong>详细行程：</strong></td><td style='text-align:left' colspan='4' class=STYLE126 valign=middle>"+
						"<input type='text' class='easyui-textbox' id='agodaDetail' name='agodaDetail' value='"+agodaDetailval+"' data-options=\"width:890,height:34,onLoadSuccess:function(){$(this).combobox('setValue', '"+agodaDetailval+"')}\"/></td></tr></tbody>";
					  		  
					  var showagodaTbody="<tbody name='agodaTbody'><tr><td class=style126 width=34 valign=middle  style='float:left;text-align:left'><div align=center><span name='tourdays'>"+tourdaysval+"</span></div></td>"+
						"<td class=STYLE126 width=308 style='float:left;text-align:left' valign=middle><span name='tourDesc'>"+tourDescval+"</span></td>"+
						"<td class=STYLE126 width=50 valign=middle  style='float:left;text-align:left'><span name='mileage'>"+mileageval+"</span></td><td style='float:left;text-align:left'><span name='area'>"+areatext+"</span>"+
						"<span name='travelItem'>"+travelItemtext+"</span></td></tr></tbody>";
				/*	  var newtr="<tr><td class='STYLE126' width='34' valign='middle'><div align='center'>"+$("select[name='tourdays'] option:selected",$(e)).val()+"</div></td>"+
			          "<td class='STYLE126' width='308' valign='middle'><span name='tourDesc'>"+$("input[name='tourDesc']",$(e)).val()+"</span></td>"+
			          "<td class='STYLE126' width='50' valign='middle'><span name='mileage'>"+$("input[name='mileage']",$(e)).val()+"</span></td>"+
			          "<td class='STYLE126' width='124' valign='middle'><span name='travelItem'>"+$($("div.panel.combo-p")[i]).find(".combobox-item.combobox-item-selected").text()+"</span></td>";
			          showTrip+=newtr;for(var i=0;i<arr.length;i++)
			          $("select[name='tourdays']",$(beriefTr)).val($("select[name='tourdays']",$(e)).find("option:selected").val());	
			          try{
			        	   $.parser.parse($(beriefTr).parent());
			        	  var tourTime = $("input[name='tourTimeinput']",$(e)).val();//$("input[name='tourTimeinput']",$(e)).datebox('getValue');
			        	  $("#travelItem",$(beriefTr)).combobox('setValue',travelItem);
				          $("#tourTime",$(beriefTr)).datebox('setValue',tourTime);
			          }catch(e){
						console.log("name: " + e.name + 
								 ",description: " +e.description+
							      ",message: " + e.message + 
							      ",lineNumber: " + e.lineNumber + 
							      ",fileName: " + e.fileName + 
							      ",stack: " + e.stack);
					}
			          $("input[name='tourDesc']",$(beriefTr)).val($("input[name='tourDesc']",$(e)).val());
			          $("input[name='mileage']",$(beriefTr)).val($("input[name='mileage']",$(e)).val());
			          beriefTrip+=beriefTr;  */ 
				  //}
					 showTrip+= showagodaTbody;
			});
			formData["showTrip"]=showTrip+"</table>";
			formData["beriefTrip"]=beriefTrip;
			
			var agodaDetail = "<table border='0' align='center' cellpadding='0' cellspacing='0' width='1140'><tbody><tr><td><img src='images/frame1-1.gif' width='100%' height='7'></td></tr><tr><td background='images/frame1-2.gif'></td></tr><tr><td><span class='STYLE9'>"+$("input[name='rttitle']").val()+"</span>";
			$("table[name='routetable'] tbody[name='agodaTbody']").each(function(i,e){
				agodaDetail+="<table width='100%' border='0' align='center' cellpadding='10' cellspacing='0'><tbody><tr>"+
	            "<td width='78' class='STYLE148'><strong>Day "+(i+1)+" </strong></td>"+
	            "<td width='972'><span class='STYLE148'><strong> "+$("input[name='rtelevation']").val()+"km 住：四姑娘山鎮 </strong></span></td>"+
	          "</tr><tr><td valign='top'>&nbsp;</td>"+
	            "<td valign='top' style='text-align:left'><span class='STYLE126'>"+$("#agodaDetail",$(e)).val()+"<br>";
				var landscapes = $("#travelItem",$(e)).val();//$("#lctiValue",e).val();
				//console.log($("#travelItem",$(e)).val());
				$.ajax({url:basePath+'travelItem/queryByAlias',method:'post',async:false,data:{"alias":landscapes},success:function(traitems){
					var jsontraitems = $.parseJSON(traitems);
					$(jsontraitems).each(function(idx,ex){
						//var exphotos = eval('('+ex.photos+')');
					//	var ex =  eval('('+bean+')');
						//console.log(jsontraitems[idx].item);
						agodaDetail+="<span>【"+jsontraitems[idx].item+"】"+jsontraitems[idx].content+"</span>"+
						"<table width='300' border='0' cellspacing='1' cellpadding='5'><tbody>"+
						"<tr>";
						if(jsontraitems[idx].photos.length>0){
							var jsonphotos = jsontraitems[idx].photos.split(",");
							$(jsonphotos).each(function(index,ele){
								//console.log(jsontraitems[i].photos);
								//console.log(ele);
								if(ele.length>0){
									agodaDetail+="<td><div align='left'><img alt="+jsontraitems[idx].item+" title="+jsontraitems[idx].item+" src='"+ele+"' width='271' height='152'></div></td>";
								}
								if(index>0&&index%4==0){
									agodaDetail+="</tr><tr>";
								}
							})
						}
						agodaDetail+="</tr>";//+
						//"<tr><td class='STYLE126'><div align='center'>"+jsontraitems[idx].item+"</div></td></tr>";
					});
				}});
                  agodaDetail+="</tbody></table></td></tr></tbody></table>";
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
/*		addLensRow:function ()
		{   
		    var newTr = lens_spec_tb.insertRow(-1);   
		    
		    var newTd0 = newTr.insertCell();//添加两列
		    var newTd1 = newTr.insertCell();
		    var newTd2 = newTr.insertCell();
		    var newTd3 = newTr.insertCell();
		    var newTd4 = newTr.insertCell();
		    var newTd5 = newTr.insertCell();
		    var newTd6 = newTr.insertCell();
		    var newTd7 = newTr.insertCell();
		    //设置列内容和属性
		     
		    var id = lens_spec_tb.rows.length-1;
		    newTd6.innerHTML = '<input id="qiujing'+id+'" type="text" />';
		    newTd5.innerHTML = '<input id="zhujing'+id+'" type="text" />';
		    newTd4.innerHTML = '<input id="shangguang'+id+'" type="text" />';
		    newTd3.innerHTML = '<input id="xiaguang'+id+'" type="text" />';
		    newTd2.innerHTML = '<input id="zhouwei'+id+'" type="text" />';
		    newTd1.innerHTML = '<input id="jiwan'+id+'" type="text" />';
		    newTd0.innerHTML = '<input id="add'+id+'" type="text" />';
		    newTd7.innerHTML = '<input id="shuliang'+id+'" type="text" value="1" onBlur="onlyNum(this);"/>';
		     
		},*/
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
			"元/人<a name=minusSight><img src=images/minus.png onclick='javascript:itour.quoteEdit.sightMinus(this)' width=20 height=20 ></a></span>";
			$("#addsightdiv").append(insertBlock);
		},
		sightMinus:function(e){
			 $(e).parent().parent().remove();
		},
		routePlus:function(){
			//var lastTr = $("table[name='routetable'] tbody>tr:last"); 
			var insertTr ="<tbody name='agodaTbody'><tr><td class=style126 width=34 valign=middle><div align=center><select class='easyui-combobox' name='tourdays' id='tourdays' data-options='width:50,editable:false'>" +
			"<option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option " +
			"value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option><option " +
			"value='9'>9</option><option value='10'>10</option><option value='11'>11</option><option " +
			"value='12'>12</option><option value='13'>13</option><option value='14'>14</option><option " +
			"value='15'>15</option></select></div></td>" +
			"<td class=STYLE126 width=308 valign=middle><input type='text' data-options='width:308' class='easyui-textbox' name='tourDesc' id='tourDesc'></td>" +
			"<td class=STYLE126 width=50 valign=middle><input name='mileage' id='mileage' class='easyui-textbox' type='number' min=0 " +
			"onkeyup=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) " +
			"onafterpaste=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) " +
			"onblur=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)></td>" +
			"<td class=STYLE126 width=124 valign=middle><input name='area' id='area' class='easyui-combobox' style='cursor:pointer'  data-options=\"width:130,height:20,valueField:'id',textField:'areaname',mode:'remote',panelHeight:'300',editable:false,method:'get',url:'areas/allAreas'," +
			"onChange:function(n,o){ var urlurl = 'travelItem/queryByScope?scope='+n ;$(this).parents('tbody').find('#travelItem').combobox('reload',urlurl);}\">" +
			"<input id='travelItem' style='cursor:pointer' name='travelItem' class='easyui-combobox'  " +																																		//type=checkbox 
			" data-options=\"valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,required:true,width:151,height:22," +
			"formatter:function(row){return '<option class=selectId style=vertical-align:middle name=selectId_'+row.alias+' value='+row.alias+'>'+row.item+'</option>';}," +
			"onSelect:function(record){$('option[name=selectId_'+record.alias+']',$(this)).attr('selected', 'true');}," +
			"onUnselect:function(record){$('option[name=selectId_'+record.alias+']',$(this)).attr('selected', 'false');}" +
			",onChange:function(n,o){$('#lctiValue').val($('#lctiValue').val()+n)}\"/><input type='hidden' name='lctiValue' id='lctiValue'/></td>" +
			"<td><a name='routeminus' onclick='javascript:itour.quoteEdit.routeMinus(this)'><img alt='' style='height:16px;height:16px;' title='删除本行' src='images/minus.png' ></a></td></tr>" +
			"<tr><td class=STYLE126 width=100 valign=middle><strong>详细行程：</strong></td><td style='text-align:left' colspan='4' class=STYLE126 valign=middle>" +
			"<input type='text' class='easyui-textbox' name='agodaDetail' id='agodaDetail' data-options='width:890,height:34'/></td></tr></tbody>" ;
			// class='easyui-datebox' data-options=\"validType:'dateValided',editable:false,required:true,split:true,border:false,region:'north'\" 
			$("table[name='routetable']").append(insertTr);
			var agodaTableLen = $("table[name='routetable'] tbody[name='agodaTbody']").length;
			$.parser.parse($("table[name='routetable'] tbody[name='agodaTbody']:eq("+(agodaTableLen-1)+")"));
		},
		routeMinus:function(e){
			//$("table[name=='routetable'] tbody")
			//var index = $(e).parent().parent().attr("rowIndex");
			 ///$(e).parents("tbody").remove();
			$(e).parent().parent().parent().remove();
		},
		cardPlus:function(){
			var insertBlock="<span class=STYLE126><br> "+
	        "<input name=card size=20 type=text>&nbsp;&nbsp;"+
	        "<input name=cardprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
	        "元/人&nbsp;&nbsp;备注：<input name=cardremark size=20 type=text><a name=minusCard><img src=images/minus.png onclick='javascript:itour.quoteEdit.sightMinus(this)' width=20 height=20 ></a></span>";
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
          	"<a name=guideminus onclick='javascript:itour.quoteEdit.guideMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>"	;
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
              "<a name=carminus onclick='javascript:itour.quoteEdit.carMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#addcardiv").append(insertBlock);
		},
		carMinus:function(e){
			$(e).parent().remove();
		},trafficPlus:function(){
			var insertBlock="<span class=STYLE126><br> "+
			"<input name='traffic' type='text' >"+
			"<input name=trafficperprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
        	"元/ 人 &nbsp;&nbsp;备注： <input name=trafficremark size=20 type=text>" +
        	"<a name=trafficminus onclick='javascript:itour.quoteEdit.trafficMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
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
            "<a name=insuranceminus onclick='javascript:itour.quoteEdit.insuranceMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
			$("#insurancediv").append(insertBlock);
		},insuranceMinus:function(e){
			$(e).parent().remove();
		},allfeePlus:function(){
			var insertBlock="<span class=style126><br>"+
      "<input name=feeName value='旅行社综合服务费' size=20 type=text>"+
          "<input name=feeperperson size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
       	"元/人&nbsp;&nbsp;备注："+
        "<input name=feeremark size=20 type=text>"+
      "<a name=allfeeminus onclick='javascript:itour.quoteEdit.allfeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
		$("#allfeesdiv").append(insertBlock);
		},allfeeMinus:function(e){
			$(e).parent().remove();
		},joyPlus:function(){
			var insertBlock="<span class=STYLE126><br>"+
			"<input name=joyitem size=20 type=text>"+
            "<input name=perjoyprice size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
      		"元/人　&nbsp;&nbsp;备注："+
      		"<input name=joyremark size=20 type=text>"+
      		"<a name=joyminus onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span>";
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
          	"<a name=joyminus onclick='javascript:itour.quoteEdit.joyMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> ";
		$("#hikingguidediv").append(insertBlock);
		},hikingGuideMinus:function(e){
			$(e).parent().remove();
		},bathhorsePlus:function(){
			var insertBlock="<span class=STYLE126><br><input name=bathorseCost size=20 type=text>"+
			"<input name=bathorsenum size=4 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) \" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"马匹数 X<input name=bathorseperday size=6 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
			"元/天  X  <input name=bathorseprice size=4 style=width:50px type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
         	 "天　&nbsp;&nbsp;备注：<input name=bathorseremark size=20 type=text> <a name=bathorseminus onclick='javascript:itour.quoteEdit.bathhorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> ";
			$("#bathorseCostdiv").append(insertBlock);
		},bathhorseMinus:function(e){
			$(e).parent().remove();
		},ridehorsePlus:function(){
			var insertBlock=" <span class=style126><br>"+
			"<input name='ridehorse' size=20 type='text'>"+
			"<input name='ridehorseperday' size=6 type='text'>"+
       		"元/天  X<input name='ridehorsedays' size=4 type='text'>天　&nbsp;&nbsp;备注："+
       		"<input name='ridehorseremark' size=20 type='text'>"+
            "<a name='rideorseminus' onclick='javascript:itour.quoteEdit.ridehorseMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span> 　";
			$("#addridehorseCost").append(insertBlock);
		},ridehorseMinus:function(e){
			$(e).parent().remove();
		},climbRegisterPlus:function(){
			var insertSpan="<span class=style126><br>"+
				"<input name=climbRegister size=20 type=text>&nbsp;&nbsp;<input name=climbRegisterperday size=6 type=text>"+
				"元/天  X<input name=climbRegisterdays size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">"+
				"天　&nbsp;&nbsp;备注：<input name=climbRegisterremark size=20 type=text>"+
				"<a name=climbRegisterminus onclick='javascript:itour.quoteEdit.climbRegisterMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></a></span";
				$("#climbregisterdiv").append(insertSpan);
		},climbRegisterMinus:function(e){
			$(e).parent().remove();
		},climbnexusPlus:function(){
			var insertSpan="<span class=style126><br>"+
				"<input name=climbnexus size=20 type=text><input style='width:50px;' name=climbnexusnum value=1 size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">人数 X"+
				"<input name=climbnexusperday style='width:50px;' size=6 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">元/天  X  "+
				"<input name=climbnexusdays style='width:50px;' size=4 type=number min=0 onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onafterpaste=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\">天　&nbsp;&nbsp;备注："+
				"<input name=climbnexusremark size=20 type=text>"+
				"<a name=climbnexusminus onclick='javascript:itour.quoteEdit.climbnexusMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></span>";
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
           	" <a name=elseitemminus onclick='javascript:itour.quoteEdit.elsefeeMinus(this)'><img alt='' style='height:20px;height:20px;' src='images/minus.png' ></span>";
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
			            	itour.alert("提示","选择行程安排日期应在当前日期之后","info" );
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
			        	   //itour.alert('提示','选择行程安排日期应在当前日期之后','warn');
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
/*window.onload=function(){
	itour.quoteEdit.init();
	<div id="routetablecopydiv" style="display:none">
<tr><td class=STYLE126 width=34 valign=middle><div align=center><select name='tourdays'><option value='1'>1</option>
				        <option value='2'>2</option>
				        <option value='3'>3</option>
				        <option value='4'>4</option>
				        <option value='5'>5</option>
				        <option value='6'>6</option>
				        <option value='7'>7</option>
				        <option value='8'>8</option>
				        <option value='9'>9</option>
				        <option value='10'>10</option>
				        <option value='11'>11</option>
				        <option value='12'>12</option>
				        <option value='13'>13</option>
				        <option value='14'>14</option>
				        <option value='15'>15</option></select></div></td>
				        <td class=STYLE126 width=55 valign=middle>
				        <input name='tourTime' class='easyui-datebox' data-options="validType:'dateValided',editable:false,required:true,split:true,border:false,region:'north'" style='width:100px;'/></td>
				        <td class=STYLE126 width=35 valign=middle>
				        <select name='tourWeekday'><option value='周日'>周日</option>
				        <option value='周一'>周一</option>
				        <option value='周二'>周二</option>
				        <option value='周三'>周三</option>
				        <option value='周四'>周四</option>
				        <option value='周五'>周五</option>
				        <option value='周六'>周六</option></select></td>
				        <td class=STYLE126 width=308 valign=middle><input type=text name='tourDesc'></td>
				        <td class=STYLE126 width=50 valign=middle><input name='mileage' type='number' min=0 onkeyup=(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this) onblur=this.v()></td>
				        <td class=STYLE126 width=124 valign=middle><select name='travelItem' class='easyui-combobox'  style='width:100px;' data-options="url:'travelItem/allItems',valueField:'alias',textField:'item',multiple:true,method:'get',editable:false,region:'north',split:true,border:false,required:true,width:151,height:22,  
			            formatter:function(row){return '<span><input type=checkbox class=selectId style=vertical-align: middle name=selectId_'+row.alias+' value='+row.alias+'>'+row.item+'</span>';},'onSelect':function(record){$('input[name=selectId_'+record.alias+']').attr('checked', true);},onUnselect:function(record){$('input[name=selectId_'+record.alias+']').attr('checked', false);}"></select></td>
				        <td class=STYLE126 width=67 valign=middle>早餐：<input name='breakfast' checked=checked type=checkbox>
				        中餐：<input name='lunch' checked=checked type=checkbox>
				        晚餐：<input name='dinner' checked=checked type=checkbox></td>
				        <td class=STYLE126 width=57 valign=middle><input type=text name='stayposition'></td>
				        <td class=STYLE126 width=171 valign=middle><select name='hotel' >
				          <option >选择该城市酒店</option>
				          <option value='贵山商务酒店'>贵山商务酒店</option>
				          <option value='嘉绒酒店'>嘉绒酒店</option></select>
				          <input name='selfhotel' size=10 type=text>
				          <br>*也可自己填写</td>
				          <td class=STYLE126 width=88 valign=middle><input name='hotelprice' size=6 type=number min=0 onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this); onblur=this.v()">
				        </td><td><a name='routeminus' onclick='javascript:itour.quoteEdit.routeMinus(this)'><img alt='' style='height:16px;height:16px;' src='images/minus.png' ></a></td>
				      </tr>
</div>
}*/
$(function(){
	itour.quoteEdit.init();
});
