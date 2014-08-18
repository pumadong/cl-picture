//检查目录文件是否上传完整
function check(){
	
	var regNo = /^\d{8}$/;
	
	if($("#year").val()=="")
	{
		show();
		$("#checkResult").text("请选择年份！");		
		return false;
	}
	
	if($("#month").val()=="")
	{
		show();
		$("#checkResult").text("请选择月份！");		
		return false;
	}

	if($("#no").val() == "")
	{
		show();
		$("#checkResult").text("请填写商品编号！");		
		return false;
	}
	
	if(!regNo.test($("#no").val()))
	{
		show();
		$("#checkResult").text("商品编号格式不正确！");		
		return false;
	}
	
	hide();
	document.form[0].submit();
}

function show() {
	$("#checkResult").show();
}
function hide() {	
	$("#checkResult").hide();
}
