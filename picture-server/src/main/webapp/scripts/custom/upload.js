var Upload = function () {
	return {
		//检查目录文件是否上传完整
		check: function() {		
			var regNo = /^\d{8,10}$/;		
			if($("#year").val()=="")
			{
				Upload.show();
				$("#checkResult").text("请选择年份！");		
				return false;
			}		
			if($("#month").val()=="")
			{
				Upload.show();
				$("#checkResult").text("请选择月份！");		
				return false;
			}	
			if($("#no").val() == "")
			{
				Upload.show();
				$("#checkResult").text("请填写商品编号！");		
				return false;
			}		
			if(!regNo.test($("#no").val()))
			{
				Upload.show();
				$("#checkResult").text("商品编号必须为8-10位的数字！");		
				return false;
			}
			var uf = $("#uploadFile").val();
			uf = uf.substring(uf.lastIndexOf("\\")+1);
			var regPic = /^\d{8,10}_[0,1]{1}\d{1}_[b,o]{1}.\w+$/;	//图片格式必须为：12345678_01_o.png样式
			if(!regPic.test(uf))
			{
				Upload.show();
				$("#checkResult").text("图片格式不正确！");
				return false;
			}
			if($("#no").val() != uf.substring(0,uf.indexOf("_")))
			{
				Upload.show();
				$("#checkResult").text("商品编号和图片名称不一致！");
				return false;
			}
			return true;
		},
		upload:	function() {
			if(!Upload.check())
			{
				return;
			}
			Upload.hide();
			$("#loading").show();
			$.ajaxFileUpload
			(
				{
					url:$("#url_request").val(),
					secureuri:false,
					fileElementId:'uploadFile',
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
							Upload.show();
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
		show: function() {
			$("#checkResult").show();
		},
		hide: function() {	
			$("#checkResult").hide();
		}
	}
}();
