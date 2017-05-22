$package('itour.destinationssc');
itour.destinationssc = function(){
	var _this = {
			fbpagination:function (pageno,scope){
			    var element = $('#fbpage');
			    //  var route = $("input[name='idrt']").val();
			  //  console.log(pageno);
			  //  console.log(travel_style+"  "+vacation+"   "+areas);
			  	$.post(basePath+"destination/moredestPage",{'pageNo':pageno,'scope':scope},
				function(responseText){
						var responseText = $.parseJSON(responseText);
						var searchRts = responseText.result.records;
						$("td[name='dests']").text(responseText.result.total+$("td[name='dests']").text());
						var html="<tr>";
						$(searchRts).each(function(i,e){
							html+='<td align="center">'+
								   	'<p><a href="'+basePath+'destination/detail/'+e.alias+'">'+e.item+'</a></p>'+
								   	'<p><a href="'+basePath+'destination/detail/'+e.alias+'"><img src="'+basePath+e.cover+'" width="450" height="309" /></a></p>'+
								   	'<p style="text-align:left">'+e.shortContent+'</p>'+
							    '</td>'+(i !=0 &&i%2==0?"</tr><tr>":"");
						});
						$("#fbcontent").empty();
			   			$("#fbcontent").append(html+"</tr>");
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
									   return _this.fbpagination(page,scope);
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
			var scope = $("input[name='scope']").val();
			_this.fbpagination(1,scope);
		}
	}
	return  _this;
}();

$(function(){
	itour.destinationssc.init();
});