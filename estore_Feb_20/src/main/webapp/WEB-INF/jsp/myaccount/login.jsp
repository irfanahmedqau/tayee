<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--include the global page start page --%>
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
<link rel="stylesheet" href="${cssRootPath}/myaccount/login_page.css" type="text/css" charset="utf-8" />
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

<center>
  <div id="mainContent">
    <div id="loginPage">
      <div class="loginHeader">
        <div class="leftTop"></div>
        <div class="CenterTop">Login to Canton, Let's go further.</div>
        <div class="rightTop"></div>
      </div>
      <div class="loginContent">
        <div class="loginLeft">
	      <div class="resultMessage">
        	<c:out value="${resultMessage}"/>
          </div>
		  <div>&nbsp;</div>
          <form:form commandName="loginForm" action="${contextPath}/login" method="post">
	      <table>
	        <tr>
	          <td><label>Login Name</label></td>
	          <td>
	          	<form:input path="loginName" class="inputBg" onblur="return checkLoginName();"/>
	          	<label id="checkLoginNameResult" class="checkResult"><form:errors path="loginName" /></label>
	          </td>
	          <td>&nbsp;</td>
	        </tr>
	        <tr>
	          <td><label>Password</label></td>
	          <td>
	          	<form:password path="password" class="inputBg" onblur="return checkPassword();"/>
	          	<label id="checkPasswordResult" class="checkResult"><form:errors path="password" /></label>
	          </td>
	          <td><a href="#">forget password ?</a></td>
	        </tr>
	        <tr>
	          <td>&nbsp;</td>
	          <td><input type="checkbox" id="autoLogin"/><label for="autoLogin" style="color:#226fbe">&nbsp;login automatically next time.</label></td>
	          <td>&nbsp;</td>
	        </tr>
	        <tr>
	          <td></td>
	          <td><input type="submit" value="login" class="loginBtn" onclick="return checkOnSubmit();" /></td>
	          <td></td>
	        </tr>
	      </table>
      </form:form>
    </div>
        <div class="loginRight">
      <table>
        <tr>
          <td><b>Do not have an account on Canton?</b></td>
        </tr>
        <tr>
          <td>Register a new account, get more valuable information.</td>
        </tr>
        <tr>
          <td><a href="${contextPath}/register" class="registerBtn">Register New Account</a></td>
        </tr>
      </table>
    </div>
      </div>
      <div class="loginBottom">
        <div class="leftBottom"></div>
        <div class="rightBottom"></div>
      </div>
    </div>
  </div>
</center>

<%--include the page footer --%>
<div id="footer">
	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
</div>

<script type='text/javascript'>
	
	function resetAll() {
		$('#checkLoginNameResult').html("");
		$('#checkPasswordResult').html("");
	}

	function checkLoginName() {
		var loginName = $('#loginName').val();
		if (loginName == "" ) {
			$('#checkLoginNameResult').html("please type in login name.");
			$('#loginName').focus();
			return false;
		} else {
			$('#checkLoginNameResult').html("");
		}
	}
	
	function checkPassword() {
		var password = $('#password').val();
		if (password == "") {
			$('#checkPasswordResult').html("please type in password.");
			$('#password').focus();
			return false;
		} else {
			$('#checkPasswordResult').html("");
		}
	}
	function checkOnSubmit() {
		var loginName = $('#loginName').val();
		var password = $('#password').val();
		if (loginName == "" ) {
			$('#checkLoginNameResult').html("please type in login name.");
			$('#loginName').focus();
			return false;
		}
		if (password == "") {
			$('#checkPasswordResult').html("please type in password.");
			$('#password').focus();
			return false;
		}
	}
</script>
</body>
</html>