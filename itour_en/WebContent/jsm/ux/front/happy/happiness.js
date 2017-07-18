$package('itouren.mhappiness');
itouren.mhappiness = function(){
		var _this = {
		fbpagination:function(pageno){
	        var element = $('#fbpage');
	      //  var route = $("input[name='idrt']").val();
	    	$.post( basePath+"showhappy/pagination",
				{'pageNo':pageno},
				function(responseText){
					//if(responseText.success){
						responseText = $.parseJSON(responseText);
						console
						//console.log(responseText.result);
						var data = responseText.result.records;
						//console.log(data);
						var html="";
						$(data).each(function(i,e){
							//console.log(data[i]);
							html+="<table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'>"+
					        "<tr>"+
					          "<td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>"+
					              "<tr>"+
					                "<td style='width:26.8%'><table  border='0' align='center' cellpadding='0' cellspacing='0'>"+
					                  "<tr>"+
					                    "<td ><table border='0' cellspacing='0' cellpadding='0'>"+
					                        "<tr>"+
					                          "<td  style='width:100%;'><a href='"+basePath+"showhappy/detail/"+(e.shCode?e.shCode:"")+"'><img src='"+basePath+(e.cover?e.cover:"") +"' width='100%' /></a></td>"+
					                          "<td width='11' rowspan='2' valign='bottom'><img src='"+basePath+"images/tu-k-02.gif' width='11' height='122' /></td>"+
					                        "</tr>"+
					                        "<tr>"+
					                          "<td><div align='right'><img src='images/tu-k-01.gif' width='100%' height='9' /></div></td>"+
					                        "</tr>"+
					                    "</table></td>"+
					                  "</tr>"+
					                "</table></td>"+
					                "<td width='73.2%' valign='bottom'><table width='100%' border='0' cellpadding='0' cellspacing='0' class='STYLE126'>"+
					                 " <tr>"+
					                   // "<td valign='top'>&nbsp;</td>"+
					                    "<td style='text-align:left'><span class='STYLE19'>"+(e.title?e.title:"")+" </span><span class='STYLE22'>"+(e.tourTime?e.tourTime:"")+"</span></td>"+
					                  "</tr>"+
					                  "<tr>"+
					                   // "<td width='20' valign='top'><div align='center'><img src='"+basePath+"images/quote-1.gif' /></div></td>"+
					                    "<td width='100%' style='text-align:left'><span class='STYLE18'>"+(e.shortContent?e.shortContent:"")+"<a href='"+basePath+"showhappy/detail/"+(e.shCode?e.shCode:"")+"'>Into her memories</a>》》<img src='images/quote-2.gif' style='width:18;height:14;' width='18' height='14' /></span></td>"+
					                  "</tr>"+
					                  "<tr>"+
					                   // "<td valign='top'>&nbsp;</td>"+
					                    "<td style='text-align:right'><div class='STYLE20'>"+(e.signature?e.signature:"")+" From "+(e.areaname?e.areaname:"")+"</div></td>"+
					                  "</tr>"+
					                "</table></td>"+
					              "</tr>"+
					            "</table>"+
					              "<div>"+
								"</div>"+
					          "</td>"+
					        "</tr>"+
					      "</table>";
						});
						$("#fbcontent").append(html);		
						   var options = {
								   bootstrapMajorVersion: 3, //bootstrap版本
								   size: 'normal',
								   itemTexts: function (type, page, current) {
									   switch (type) {
										   case "first":
										   return "Home";
										   case "prev":
										   return "<i class='fa fa-caret-left'></i> Prev";
										   case "next":
										   return "Next <i class='fa fa-caret-right'></i>";
										   case "last":
										   return "Last";
										   case "page":
										   return page;
									   }
								   },
								/*   tooltipTitles: function (type, page, current) {
									   switch (type) {
										   case "first":
										   return "首页";
										   case "prev":
										   return "上一页";
										   case "next":
										   return "下一页";
										   case "last":
										   return "末页";
										   case "page":
										   return "第" + page + "页";
									   }
								   },*/
								   useBootstrapTooltip:true,
								 /*  pageUrl: function(type, page, current){
									   $("#fbcontent").empty();  
									   return fbpagination(page.pageNo);
									   //return basePath+"feedback/pagination?route="+route+"&pageNo="+page; //跳转到选定页面
								   },*/
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
					           /* ok(!element.hasClass('pagination-lg'),"Root element shouldn't have pagination-lg class");
					            ok(!element.hasClass('pagination-sm'),"Root element shouldn't have pagination-sm class");
					            var list = element.children();
					            for(var i=0;i < list.length;i++)
					            {
					                var item = $(list[i]);
					                ok(item.is("li"),"Element "+i+" should be li");
					            }
					            ok(element.hasClass('pagination-sm'),"Root element should have pagination-sm class");*/
					//}
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
		}
	}
	return  _this;
}();
$(function(){
	   itouren.mhappiness.init();
});
