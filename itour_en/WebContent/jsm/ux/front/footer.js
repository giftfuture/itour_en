$package('itouren.footer');
itouren.footer = function(){
	var _this = {
		searchRtResult:function(){
			document.forms["searchForm"].action=basePath+"search";
			document.forms["searchForm"].submit();
		},loadlevel2Area:function (level1Area){
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
		footAds:function(){
			  $.ajax({  
			        url : basePath+'adLink/footAds',  
			        async : false,  
			        method: 'post',
			        success : function(rest){ 
			            var result = eval('('+rest+")");//转换为json对象 
			            //console.log(result);     
			            var html = "<tr bgcolor='#fafafa'>"; 
			            $(result).each(function(i,e){
			            	if(i!=0 && i%5==0){
			            		html+="</tr><tr bgcolor='#fafafa'>";
			            	}
			            	html+=" <td width='210'><a href='"+basePath+e.adlink+"'>"+e.title+"</a></td>";
			            });
			            $("table[name='keyfooter']").append(html+"</tr>");
			        }  
			    }); 
		
		},
		init:function(){
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
		     _this.footAds();
		     _this.loadlevel2Area(level1Area);
		    //console.log('${rcdDays}');$(this).combobox('select', '${rcdDays}')
		    $("#vacation").combobox({ 
		        data:[{'value':'','text':'-All-'},{'value':'1_5','text':'1-5days'},{'value':'6_9','text':'6-9days'},{'value':'10_15','text':'10-15days'},{'value':'16','text':'16days+'}],
		        mode:'local',
		        onLoadSuccess:function(){$(this).combobox('setValue', rcdDays);}
		    }) 
			//$("a[name='search']").click(_this.searchRtResult); 
			//$("a[name='search']").attr("href",_this.searchRtResult); 
			/*_this.fbpagination(1); href="itour.footer.searchRtResult"
			$("#searchbtn").click(function(){
				//console.log("11111");
				_this.fbpagination(1);
			});*/
			//_this.travelStyle;
			//$("#searchForm").submit(_this.search);
			//验证码图片绑定点击事件
			//var form = $("#loginForm");
			//form.submit(itour.login.toLogin);
			/*$("select[name='areas']").combobox({ 
			    url:basePath+'travelItem/allScopes', 
			    valueField:'key',    
			    textField:'value'
			});*/
		}
	}
	return _this;
}();


/*window.onload=function(){
	itouren.footer.init();
}*/

$(function(){
	itouren.footer.init();
});		
