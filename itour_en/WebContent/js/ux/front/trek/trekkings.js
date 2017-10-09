$package('itouren.trekkings');
itouren.trekkings = function(){
	var _this = {
			fbpagination:function (pageno){
			    var element = $('#fbpage');
			  	$.post(basePath+"hiking-goHiking",{'pageNo':pageno},
				function(responseText){
								responseText = $.parseJSON(responseText);
								var searchRts = responseText.result.records;
								var html='<tr>';
								$(searchRts).each(function(i,e){
									html+='<td width="33.3%"><table style="width:93.5%" align="center" border="0" cellpadding="0" cellspacing="0">'+
						            '<tr><td width="100%" class="h2-24"><a href="'+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+'-'+(e.alias?e.alias:"")+'">'+(e.title?e.title:"")+'</a></td></tr>'+
								      '<tr><td class="f12-gao1" style="text-align:center"><a href="'+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+'-'+(e.alias?e.alias:"")+'"><img src="'+basePath+(e.cover?e.cover:"")+'" width="100%" height="166" ></a></td></tr>'+
								      '<tr><td class="f12-gao1" style="text-align:left">'+(e.shortContent?e.shortContent:"")+'</td></tr>'+
								      '<tr><td>&nbsp;</td></tr></table></td>'
								      +((i+1)%3==0?"</tr><tr>":""); 
								});
								$("#fbpage").parents("tr").before(html+'</tr>');
								   var options = {
										   bootstrapMajorVersion: 3, //bootstrap版本
										   size: 'normal',
										   itemTexts: function (type,page,current) {
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
						}/*,
						beforeSend:function(data) { 
							$("#fbcontent").empty(); 
						  }, 
						error:function(err){
							console.log(err);
						}*/
					);
				},
		init:function(){
			var docwidth = document.documentElement.clientWidth;
			$("td.banner img").css("width",parseInt(docwidth)*0.726);
			$("td.banner img").css("height",parseInt(docwidth)*0.323);
			_this.fbpagination(1);
		}
	}
	return  _this;
}();

$(function(){
	itouren.trekkings.init();
});