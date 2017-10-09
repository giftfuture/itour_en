$package('itouren.msearch');
itouren.msearch = function(){
	var _this = {
			fbpagination:function (pageno){
			    var element = $('#fbpage');
			    //  var route = $("input[name='idrt']").val();
			  //  console.log(pageno);
			    var travel_style = $("#travel_style").combobox('getValue');			
			    var vacation = $("#vacation").combobox('getValue');
			    var level1Area = $("#level1Area").combobox('getValue'); 
			    var level2Area = $("#level2Area").combobox('getValue'); 
			  //  console.log(travel_style+"  "+vacation+"   "+level1Area+"  "+level2Area);
			  	$.post(basePath+"searchRtResult",{'pageNo':pageno,'travel_style':travel_style,'vacation':vacation,'level1Area':level1Area,'level2Area':level2Area},
						function(responseText){
								var responseText = $.parseJSON(responseText);
								var searchRts = responseText.result.records;
								jQuery("#travel_style").combobox('setValue',responseText.params.travelStyle);
							 	jQuery("#level1Area").combobox('setValue',responseText.params.level1Area);
							 	jQuery("#level2Area").combobox('setValue',responseText.params.level2Area);
							 	jQuery("#vacation").combobox('setValue',responseText.params.rcdDays);
								var html="<tr>";
								$(searchRts).each(function(i,e){
									html+=(i!=0&&i%3==0?"</tr><tr>":"")+
						            "<td><table><tr>"+
						              "<td><a href='"+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+"/"+(e.travelStyleAlias?e.travelStyleAlias:"")+"/"+(e.alias?e.alias:"")+"'><span class='STYLE7'>"+(e.title?e.title:"")+"</span></a></td>"+
						            "</tr>"+
						            "<tr>"+
						              "<td><a href='"+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+"/"+(e.travelStyleAlias?e.travelStyleAlias:"")+"/"+(e.alias?e.alias:"")+"'><img src='"+basePath+""+(e.cover?e.cover:"")+"' width='353' height='166' /></a></td>"+
						            "</tr>"+
						            "<tr>"+
						              "<td class='STYLE8'>"+
						             (e.shortContent?e.shortContent:"")+"<br><a href='"+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+"/main'>More》》</a>"+
						              "</td></tr></table></td>";
								});
								$("#fbcontent").html("");
					   			$("table[name='searchRtstb'] tbody").append(html+"</tr>");
								   var options = {
										   bootstrapMajorVersion: 3, //bootstrap版本
										   size: 'normal',
										   itemTexts: function (type, page, current) {
											   switch (type) {
												   case "first":
												   return "Home";
												   case "prev":
												   return "<i class='fa fa-caret-left'></i>Prev";
												   case "next":
												   return "Next <i class='fa fa-caret-right'></i>";
												   case "last":
												   return "Last";
												   case "page":
												   return page;
											   }
										   },
										   useBootstrapTooltip:true,
										   onPageClicked:function(event, originalEvent, type, page){
											   $("#fbcontent").empty();  
											   return _this.fbpagination(page);
										   },
										   numberOfPages: 6, //显示“第几页”的选项数目
										   currentPage: responseText.result.pager.pageId, //当前页数
										   totalPages:responseText.result.pager.pageCount, //总页数
										//   shouldShowPage:true,//是否显示该按钮
										   }
							            element.bootstrapPaginator(options);
						});
				},
				loadlevel2Area:function (level1Area){
				    var templevel2Areaindex=0;
				    if(level1Area&&level1Area.length>0){
				   //console.log(level1Area);
				    $.ajax({  
				        url : basePath+'levelarea/queryLevel2ByLevel1',  
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
				                onLoadSuccess:function(){$(this).combobox('select',level2Area)}
				            });  
				        }  
				    }); 
				  }
				},
				init:function(){
					_this.fbpagination(1);
				    $.ajax({  
				        url:basePath+'levelarea/queryLevel1',
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
				                    _this.loadlevel2Area(n);
				                } 
				            });   
				        }  
				    })
				     _this.loadlevel2Area(level1Area);
				    //console.log('${rcdDays}');$(this).combobox('select', '${rcdDays}')
				    $("#vacation").combobox({ 
				        data:[{'value':'-All-','text':'-All-'},{'value':'1_5','text':'1-5days'},{'value':'6_9','text':'6-9days'},{'value':'10_15','text':'10-15days'},{'value':'16','text':'16days+'}],
				        mode:'local',
				        onLoadSuccess:function(){$(this).combobox('setValue', rcdDays);}
				    }) 
					//jQuery("#level1Area").combobox('setValue','四川');
			}
	}
	return _this;
}();

window.onload=function(){
	itouren.msearch.init();
	
}