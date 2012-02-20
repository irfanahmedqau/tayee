<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--include the global page start page --%>
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
<link rel="stylesheet" href="${cssRootPath}/myaccount/mycenter.css" type="text/css" charset="utf-8" />
<link rel="stylesheet" href="${cssRootPath}/myaccount/header_full.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${cssRootPath}/myaccount/package_v1.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${jsRootPath}/myaccount/My97DatePicker/WdatePicker.js"></script>
<title><fmt:message key="canton.homepage.title" /></title>
</head>

<body>

<div id="topbar">
	<jsp:include page="${jspRootPath }/includes/common/incPageTopBar.jsp"/> 
</div>

<%--include the home page header --%>
<div id="wrap">
	<jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp"/>
</div>

<div class="main layout_row3" id="container">
	<div class="crumbs">
			<a href="">首页</a> &gt; <a href="">我的CANTON</a> &gt; 个人资料
		</div>
	<div class="i_content wrap_mycenter">
		<!-- 二级页内容 s -->
		<div class="mod_kong id_mod_password" id="mod_profile">
			<div class="mod_hd">
				<h3>个人资料管理<span class="mod_hd_tips">（带<span class="strong">*</span>号的项目为必填项）</span></h3>
			</div>
			<div class="mod_bd">
				<ul class="list_info">
					<form:form id="mainForm" commandName="customerForm" method="post" action="">
						<li><span class="tit"><span class="strong">*</span>Login Name </span><form:input path="loginName" style="border:0" readonly="true"/></li>
						<li><span class="tit"><span class="strong">*</span>Email </span><form:input path="email" style="border:0" readonly="true"/></li>
						<li><span class="tit">Last Login Date </span><form:input path="lastLoginDate" style="border:0" readonly="true"/></li>
						<li><span class="tit">Status </span><form:input path="status" style="border:0" readonly="true"/></li>
						<li><span class="tit">Description </span><form:input path="description" /></li>
						<li><span class="tit">Nick Name </span><form:input path="nickName" /><font color="red"><form:errors path="nickName" /></font></li>
						<li><span class="tit">First Name </span><form:input path="firstName" /><font color="red"><form:errors path="firstName" /></font></li>
						<li><span class="tit">Last Name </span><form:input path="lastName" /><font color="red"><form:errors path="firstName" /></font></li>
						<li><span class="tit">Birthday </span><form:input path="birthday" onClick="WdatePicker()"/><font color="red"><form:errors path="firstName" /></font></li>
						<li><span class="tit">Gender </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="sex" value="m"> 男</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="radio" name="sex" value="f" /> 女</label><font color="red"><form:errors path="firstName" /></font></li>
						<li><span class="tit">Line Phone </span><form:input path="linePhone" onchange="return checkLinePhone();"/><font color="red"><form:errors path="firstName" /><label id="checkLinePhoneResult"></label></font></li>
						<li><span class="tit">Mobile Phone </span><form:input path="mobilePhone" onchange="return checkMobilePhone();"/><font color="red"><form:errors path="firstName" /><label id="checkMobilePhoneResult"></label></font></li>
						<li>
							<input type="submit" value="save" onclick="return submitSave()"/>
							<input type="submit" value="refresh" onclick="return submitRefresh()"/>
							<input type="reset" value="reset" />
						</li>
					</form:form>
				</ul>	
			</div>
		</div>
	</div>

	<div id="homeLeftBar">
		<jsp:include page="${jspRootPath}/myaccount/incHomeLeftBar.jsp" />
	</div>
</div>

<%--include the page footer --%>
<div id="footer">
	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
</div>

<script type='text/javascript'>
	function checkLinePhone() {
	
	}
	
	function checkMobilePhone() {
	
	}
	
	function submitSave() {
		document.getElementById("mainForm").action="${contextPath}/myaccount/update";
		document.getElementById("mainForm").submit();
	}
	
	function submitRefresh() {
		document.getElementById("mainForm").action="${contextPath}/myaccount/refresh";
		document.getElementById("mainForm").submit();
	}
</script>
</body>
</html>