var View = function () {
	return {
		//检查目录文件是否上传完整
		check: function() {		
			var regNo = /^\d{8,10}$/;		
			if($("#year").val()=="")
			{
				View.show();
				$("#checkResult").text("请选择年份！");		
				return false;
			}		
			if($("#month").val()=="")
			{
				View.show();
				$("#checkResult").text("请选择月份！");		
				return false;
			}	
			if($("#no").val() == "")
			{
				View.show();
				$("#checkResult").text("请填写商品编号！");		
				return false;
			}		
			if(!regNo.test($("#no").val()))
			{
				View.show();
				$("#checkResult").text("商品编号必须为8-10位的数字！");		
				return false;
			}
			return true;
		},
		search:	function() {
			if(!View.check())
			{
				return;
			}
			View.hide();
			//document.form[0].submit();
			$("#form_cl").submit();
		},
		delete:	function() {
			if(!View.check())
			{
				return;
			}
			View.hide();
			$("#loading").show();
			$.ajaxFileUpload
			(
				{
					url:$("#url_request").val(),
					secureuri:false,
					fileElementId:'deleteFile',
					dataType: 'json',
					data: {//加入的文本参数 
						"dt": $("#year").val() + $("#month").val(),
			            "no": $("#no").val(),
			            "url": $("#url_response").val()
		       		},  
					beforeSend:function()
					{
						$("#loading").show();
					},
					complete:function()
					{
						$("#loading").hide();
					},				
					success: function (data, status)
					{
						if(typeof(data.result) != 'undefined')
						{
							View.show();
							$("#checkResult").text(data.message);	
						}
					},
					error: function (data, status, e)
					{
						alert(e);
					}
				}
			);
		},
		refreshCDN:	function() {
			View.show();
			$("#checkResult").text("调用CDN方的接口，强迫图片刷新！");	
		},
		show: function() {
			$("#checkResult").show();
		},
		hide: function() {	
			$("#checkResult").hide();
		}
	}
}();
