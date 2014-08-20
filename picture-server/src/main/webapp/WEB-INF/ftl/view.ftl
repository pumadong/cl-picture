<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.1.1
Version: 2.0.2
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>创力 | 图片中心 - 主页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN GENERAL STYLES -->
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
<!-- END GENERAL STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/select2/select2-metronic.css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/plugins/jquery-multi-select/css/multi-select.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/style.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link rel="stylesheet" type="text/css" href="${IncPath}/assets/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">

<#include "header.ftl" >

<div class="clearfix">
</div>

<!-- BEGIN CONTAINER -->
<div class="page-container">
	
	<#include "sidebar.ftl" >

	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					图片浏览
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${BasePath}">
								主页
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a>
								图片浏览
							</a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<div class="form-body">
		           		<form action="viewresult.do" id="form_cl" class="form-horizontal" method="POST">
		           			<input type="hidden" name="visitedModule" value="${visitedModule}">
		           			<input type="hidden" name="visitedResource" value="${visitedResource}">
		           			<div class="form-group">
								<label class="control-label col-md-2">年份：
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-3">
					           		<select id="year" name="year" class="form-control select2me">
					           			<option value="">请选择</option>
										<option value="2013">2013</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
										<option value="2020">2020</option>
										<option value="2021">2021</option>
										<option value="2022">2022</option>
										<option value="2023">2023</option>
					           		</select>
					           	</div>
				           	</div>
		           			<div class="form-group">
								<label class="control-label col-md-2">月份：
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-3">
					           		<select id="month" name="month" class="form-control select2me">
					           			<option value="">请选择</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
					           		</select>
					           	</div>
				           	</div>
		           			<div class="form-group">
								<label class="control-label col-md-2">商品编号：
								<span class="required">
									 *
								</span>
								</label>
								<div class="col-md-3">
					           		<input type="text" id="no" name="no" data-required="1" class="form-control"/>
					           	</div>
				           	</div>
							<div class="form-actions fluid">
								<div class="col-md-offset-0 col-md-12">
									<button type="button" class="btn blue" onclick="javascript:View.search();">查询</button>
									<button type="button" class="btn blue" onclick="javascript:View.delete();">删除</button>
									<button type="button" class="btn blue" onclick="javascript:View.refreshCDN();">刷新CDN</button>
									<button type="reset" class="btn blue" onclick="javascript:View.hide();">取消</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="checkResult" class="btn red" style="display:none"></span>
									<span id="loading" style="display:none"><img src="${IncPath}/assets/img/loading-spinner-blue.gif"></span>
								</div>
							</div>
						<input type="hidden" name="url_request" id="url_request" value="http://localhost:10003/picture-server/delete.op">
						<input type="hidden" name="url_response" id="url_response" value="http://localhost:10003/picture-server/result.jsp">
		           		</form>
	           		</div>
				</div>
			</div>
			<!-- BEGIN 查询结果-->
			<#if result?? >
			<div class="row">
				<div class="col-md-12">
					<div class="portlet grey box">
						<div class="portlet-title">
							<div class="caption">
								查询结果
							</div>
						</div>						
						<div class="portlet-body">
							<#if result >
								<#if mapFile?exists>
								<#list mapFile?keys as key> 
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">第${key}张角度图</h3>
									</div>
									<div class="panel-body">
										<#list mapFile[key] as item>
											<a href="${PicPath}/${year}${month}/${no}/${item}" target="_blank">${item}</a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</#list>
									</div>
								</div>
								</#list>
								</#if>
								<#if lstFileB??>
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">宝贝描述图</h3>
									</div>
									<div class="panel-body">
										<#list lstFileB as item>
											<a href="${PicPath}/${year}${month}/${no}/${item}" target="_blank">${item}</a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</#list>
									</div>
								</div>
								</#if>
							<#else>
								<div class="panel panel-info">
									<div class="panel-body">
										 指定的目录不存在！
									</div>
								</div>
							</#if> 
						</div>
					</div>
				</div>
			</div>
			</#if>
			<!-- END 查询结果-->	
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

<#include "footer.ftl" >

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${IncPath}/assets/plugins/respond.min.js"></script>
<script src="${IncPath}/assets/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${IncPath}/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN GENERAL PLUGINS -->
<script src="${IncPath}/assets/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
<script src="${IncPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="${IncPath}/assets/plugins/jquery-validation/dist/additional-methods.min.js"></script>
<!-- END GENERAL PLUGINS -->
<script src="${IncPath}/assets/scripts/core/app.js"></script>
<script src="${BasePath}/scripts/plugin/ajaxfileupload.js"></script>
<script src="${BasePath}/scripts/custom/cl.js"></script>
<script src="${BasePath}/scripts/custom/view.js"></script>
<script>
    jQuery(document).ready(function() {       
       // initiate layout and plugins
       App.init();
       Cl.initModal();
       <#if year??>
       $("#year").val("${year}");
       </#if>
       <#if month??>
       $("#month").val("${month}");
       </#if>
       <#if no??>
       $("#no").val("${no}");
       </#if>    
    });
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
