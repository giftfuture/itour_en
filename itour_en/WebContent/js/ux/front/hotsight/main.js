$package('itour.hotsightmain');
itour.hotsightmain = function(){
	var _this = {
			fbpagination:function (pageno){
			    var element = $('#fbpage');
			  	$.post(basePath+"hotsight/hotsightpagination",{'pageNo':pageno},
				function(responseText){
								responseText = $.parseJSON(responseText);
								var searchRts = responseText.result.records;
							//	console.log(searchRts);
								var html="<tr>";
								$(searchRts).each(function(i,e){
									html+=('<td valign="top">'+
									    '<table width="353" border="0" align="left" cellpadding="0" cellspacing="0">'+
									      '<tr>'+
									        '<td><table width="300" border="0" align="left" cellpadding="0" cellspacing="0">'+
									            '<tr>'+
									              '<td width="296" class="h2-24"><a href="'+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+'/'+(e.travelStyleAlias?e.travelStyleAlias:"")+'/'+(e.alias?e.alias:"")+'">'+(e.title?e.title:"")+'</a></td>'+
									            '</tr>'+
									        '</table></td>'+
									      '</tr>'+
									      '<tr>'+
									        '<td><a href="'+basePath+(e.travelStyleAlias?e.travelStyleAlias:"")+'/'+(e.travelStyleAlias?e.travelStyleAlias:"")+'/'+(e.alias?e.alias:"")+'"><img src="'+basePath+(e.cover?e.cover:"")+'" width="353" height="166" ></a></td>'+
									      '</tr>'+
									      '<tr>'+
									        '<td class="f12-gao1" style="text-align:left">'+(e.shortContent?e.shortContent:"")+'</td>'+
									      '</tr>'+
									      '<tr>'+
									        '<td>&nbsp;</td>'+
									      '</tr>'+
									    '</table></td>'+(i !=0 &&i%2==0?"</tr><tr>":""));
									//console.log(e.title+"   "+e.alias+"  "+e.cover);
								});
								$("#fbcontent").empty(); 
								//console.log(html);
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
			_this.fbpagination(1);
		 	//$("select[name='selectScopes']").combobox({ 
		/*$("#travelstyle").combobox({ 
		 		onChange: function (n,o) {
		 			alert("我是老大!");

		 			}
			});*/ 
		}
	}
	return  _this;
}();

$(function(){
	itour.hotsightmain.init();
});