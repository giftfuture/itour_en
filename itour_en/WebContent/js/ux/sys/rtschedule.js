$package('itour.rtschedule');
itour.rtschedule = function(){
	var _this = {
			changeValidateCode:function () {  
			    var timenow = new Date().getTime();//这是为了防止每次刷新的时候验证码相同
			    $("#validateCode").attr("src",basePath+"RandomCodeServlet?d="+timenow);  
			  },
		  savequotoForm:function () {
				var actionurl=basePath+"routeTemplate/savertschedule";//$("#formLogin").attr("action");//提交路径
				 var formData = new Object();
				//var formData= $("form[name='rtscheduleForm']").serialize();
				/*$("form input").each(function(){
					 formData[this.name] =$("input[name='"+this.name+"']" ).val();
				});*/
				formData["id"] = $("#id").val();
				formData["quotoForm"] = $('#editquotoForm').summernote('code');
				formData["verifyCode"]=$("#verifyCode").val();
				__.post(actionurl, formData, function(result) {
					//console.log("data.success="+data.success);
					if (result.success) {
						itour.alert("提示",result.msg||"详细日程更新成功！",'info');
					/*	$("table[name='rtscheduleTable']").find('tbody:eq(2)').hide();
						$("table[name='rtscheduleTable']").find('tbody:eq(1)').show();
						$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(1)').hide();
						$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(2)').show();*/
						$("#editquotoForm").html("");
						$("#editquotoFormtbody").hide();
						$("#quotoForm").html(result.data);
						$("#quotoFormtbody").show();
						$("#edittbody").show();
						$("#submittbody").hide();
						//_this.showSuccess(result.msg);
					} else {
						itour.alert("提示",result.msg||"详细日程更新出错！",'info');
					/*	$("table[name='rtscheduleTable']").find('tbody:eq(2)').show();
						$("table[name='rtscheduleTable']").find('tbody:eq(1)').hide();
						$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(2)').hide();
						$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(1)').show();*/
						$("#editquotoFormtbody").show();
						$("#quotoFormtbody").hide();
						$("#edittbody").hide();
						$("#submittbody").show();
						//_this.showError(result.msg);
					}
					_this.changeValidateCode;
					$("#verifyCode").val('');
				});
				
			},
		  showSuccess:function (str) {
				$('#alertMessage').removeClass('error').html(str).stop(true, true).show().animate({
					opacity : 1,
					right : '0'
				}, 500);
			},
			//显示错误提示
			showError:function (str) {
				$('#alertMessage').addClass('error').html(str).stop(true, true).show().animate({
					opacity : 1,
					right : '0'
				}, 500);

			},
			//图片上传  
			sendFile:function (file, editor, $editable){ 
				$(".note-toolbar.btn-toolbar").append('正在上传图片');  
				 console.log("file="+file);  
				 console.log("editor="+editor);  
				 console.log("welEditable="+$editable);  
			    var filename = false;  
			    try{  
			    filename = file['name'];  
			    } catch(e){  
			        filename = false;  
			    }  
			    if(!filename){  
			        $(".note-alarm").remove();  
			    }  
			    //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误  
			    var data = new FormData();  
			    data.append("file", file);  
			    data.append("key",filename); //唯一性参数  
			    data.append("token",$("#summernote").attr('token'));  
			  //以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误
			    var ext = filename.substr(filename.lastIndexOf("."));
			    ext = ext.toUpperCase();
			    var timestamp = new Date().getTime();
			    var name = timestamp+"_"+$("#summernote").attr('aid')+ext;
			/*    $.ajax({  
				    data: data,  
				    type: "POST",  
				    url: basePath+"verifyCode/addd",  
				    cache: false,  
				    contentType: false,  
				    processData: false,  
				    success: function(url) {  
				        if(url=='200'){  
				            alert("上传失败！");  
				            return;  
				        }else{  
				            alert("上传成功！");   
				        }  
				        //alert(url);  
				    editor.insertImage($editable, url);  
				   // $("#summernote").summernote('insertImage', url, 'image name'); // the insertImage API  
				    //setTimeout(function(){$(".note-alarm").remove();},3000);  
				    },  
				    error:function(){  
				        alert("上传失败！");  
				        return;  
			        //setTimeout(function(){$(".note-alarm").remove();},3000);  
			        }  
			  }); */
			 },  
		/*	 summernoteArea:function(){
				 $('#editquotoForm').summernote({  
				        height: 400,                  
				        minHeight: 300,             
				        maxHeight: 500,        
				        focus: true,   
				        lang:'zh-CN',   
				        codemirror: {
				            theme: 'monokai'
				        },toolbar: [  
				                    ['style', ['bold', 'italic', 'underline', 'clear']],  
				                    ['fontsize', ['fontsize']],  
				                    ['color', ['color']],  
				                    ['para', ['ul', 'ol', 'paragraph']],  
				                    ['height', ['height']],  
				                    ['insert', ['picture', 'video']]  
				                ], 
				  }); 
			 },*/
			 togglequotoForm:function(){
			/*		$("table[name='rtscheduleTable']").find('tbody:eq(2)').show();
					$("table[name='rtscheduleTable']").find('tbody:eq(1)').hide();
					$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(2)').hide();
					$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(1)').show();*/
					$("#editquotoFormtbody").show();
					$("#quotoForm").html("");
					$("#quotoFormtbody").hide();
					$("#edittbody").hide();
					$("#submittbody").show();
					/*${bean.quotoForm }*/
					 $('#editquotoForm').summernote({  
					        height: 400,                  
					        minHeight: 300,             
					        maxHeight: 500,        
					        focus: true,   
					        lang:'zh-CN',   
					      /*  callbacks: { 
						        onImageUpload: function(files, editor, $editable) {  
						        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
						        }
					        },*/codemirror: {
					            theme: 'monokai'
					        },toolbar: [  
					                    ['style', ['bold', 'italic', 'underline', 'clear']],  
					                    ['fontsize', ['fontsize']],  
					                    ['color', ['color']],  
					                    ['para', ['ul', 'ol', 'paragraph']],  
					                    ['height', ['height']],  
					                    ['insert', ['picture', 'video']]  
					                ], 
					  });
			},
		init:function(){
			//$('#TableID').find('tbody').find('tr:eq(4)').find('td:lt(2)')
			/*$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(1)').hide();
			$("table[name='rtscheduleTable']").find('tbody:eq(0)').find('tr:eq(2)').show();
			$("table[name='rtscheduleTable']").find('tbody:eq(1)').show();
			$("table[name='rtscheduleTable']").find('tbody:eq(2)').hide();*/
			$("#editquotoFormtbody").hide();
			$("#quotoFormtbody").show();
			$("#edittbody").show();
			$("#submittbody").hide();
			$("#editquotoForm").html("");
			//$("table[name='rtscheduleTable']").find('tbody:eq(1)').find("a:eq(0)").attr("href",_this.togglequotoForm);
			//$("table[name='rtscheduleTable']").find('tbody:eq(1)').find("a:eq(0)").bind('click',_this.togglequotoForm);
			//$("#eddit").click(_this.togglequotoForm);
			$("a[name='savequotoForm']").click(_this.savequotoForm);
			$(document).keydown(function(e){
	    		 e = e || window.event;
	    		if(e.keyCode == 13) {
	    			_this.savequotoForm;
	    		}
	    	});
			$("a[name='cancelquotoForm']").click(function(){
				$("#editquotoFormtbody").hide();
				//$("#quotoForm").html("");
				$("#quotoFormtbody").show();
				$("#edittbody").show();
				$("#submittbody").hide();
			});
			$("#eddit").click(function(){
				$.post(basePath+"routeTemplate/getId",{"id":$("#id").val()},function(responseText){
					$("#editquotoFormtbody").show();
					$("#quotoFormtbody").hide();
					$("#edittbody").hide();
					$("#quotoForm").html("");
					$("#submittbody").show();
					var result = $.parseJSON(responseText);
					var resultdata = $.parseJSON(result.data);
					$("#editquotoForm").html(resultdata.quotoForm);
					$("#editquotoForm").summernote({  
					        height: 400,                  
					        minHeight: 300,             
					        maxHeight: 500,        
					        focus: true,   
					        lang:'zh-CN',   
					      /*  callbacks: { 
						        onImageUpload: function(files, editor, $editable) {  
						        	sendFile(files[0],editor,$editable);  //// 重写图片上传  
						        }
					        },*/codemirror: {
					            theme: 'monokai'
					        },toolbar: [  
					                    ['style', ['bold', 'italic', 'underline', 'clear']],  
					                    ['fontsize', ['fontsize']],  
					                    ['color', ['color']],  
					                    ['para', ['ul', 'ol', 'paragraph']],  
					                    ['height', ['height']],  
					                    ['insert', ['picture', 'video']]  
					                ], 
					  });
				});
			})
		}
	}
	return _this;
}();

$(function(){
	itour.rtschedule.init();
});