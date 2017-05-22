$package('itour.searchRt');
itour.searchRt = function(){
	var _this = {
			fbpagination:function (pageno,alias){
			    var element = $('#fbpage');
			    //  var route = $("input[name='idrt']").val();
			  //  console.log(pageno);
			  //  console.log(travel_style+"  "+vacation+"   "+areas);
			  	$.post(basePath+"destination/related/searchRtResults",{'pageNo':pageno,'alias':alias},
				function(responseText){
						var responseText = $.parseJSON(responseText);
						var searchRts = responseText.result.records;
						var html="<tr>";
						$(searchRts).each(function(i,e){
							html+=(i!=0&&i%3==0?"</tr><tr>":"")+
							'<td><table><tr>'+
			                '<td width="66"><a href="'+basePath+e.travelStyleAlias+'/'+e.travelStyleAlias+'/'+e.alias+'"><img src="'+basePath+(e.cover?e.cover:"")+'" width="91" height="50"></a></td></tr>'+
			                '<tr><td width="384" class="f12-gao1"><a href="'+basePath+e.travelStyleAlias+'/'+e.travelStyleAlias+'/'+e.alias+'">【'+(e.travelStyleType?e.travelStyleType:"")+'】'+(e.title?e.title:"")+'</a></td>'+
			              '</tr></table></td>';
						});
						$("#fbcontent").html("");
			   			$("table[name='searchRtstb'] tbody").append(html+"</tr>");
						   var options = {
								   bootstrapMajorVersion: 3, //bootstrap版本
								   size: 'normal',
								   itemTexts: function (type, page, current) {
									   switch (type) {
										   case "first":
										   return "首页";
										   case "prev":
										   return "<i class='fa fa-caret-left'></i> 上一页";
										   case "next":
										   return "下一页 <i class='fa fa-caret-right'></i>";
										   case "last":
										   return "末页";
										   case "page":
										   return page;
									   }
								   },
								   useBootstrapTooltip:true,
								   onPageClicked:function(event, originalEvent, type, page){
									   $("#fbcontent").empty();  
									   return _this.fbpagination(page,alias);
								   },
								   numberOfPages: 6, //显示“第几页”的选项数目
								   currentPage: responseText.result.pager.pageId, //当前页数
								   totalPages:responseText.result.pager.pageCount, //总页数
								//   shouldShowPage:true,//是否显示该按钮
								   }
					            element.bootstrapPaginator(options);
				});
				},
				init:function(){
					var alias = $("input[name='alias']").val();
					_this.fbpagination(1,alias);
					//jQuery("#level1Area").combobox('setValue','四川');
			}
	}
	return _this;
}();

window.onload=function(){
	itour.searchRt.init();
	
}