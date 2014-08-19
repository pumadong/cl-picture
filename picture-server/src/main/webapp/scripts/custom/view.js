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
			View.hide();
			document.form[0].submit();
		},	
		show: function() {
			$("#checkResult").show();
		},
		hide: function() {	
			$("#checkResult").hide();
		}
	}
}();
