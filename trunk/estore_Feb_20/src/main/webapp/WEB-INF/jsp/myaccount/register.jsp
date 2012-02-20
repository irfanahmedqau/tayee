<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--include the global page start page --%>
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
<link rel="stylesheet" href="${cssRootPath}/myaccount/register_page.css" type="text/css" charset="utf-8" />
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
    <div id="registerPage">
      <div class="registerHeader">
        <div class="leftTop"></div>
        <div class="CenterTop">Customer Register</div>
        <div class="rightTop"></div>
      </div>
      <div class="registerContent">
        <div class="registerLeft">
          <div class="resultMessage">
        	<c:out value="${resultMessage}"/>
          </div>
          <div>&nbsp;</div>
        <form:form commandName="registerForm" action="${contextPath}/register" method="post">
	      <table>
	        
	        <tr>
				<td><label>LoginName</label></td>
				<td>
					<form:input path="loginName" class="inputBg" onblur="return checkLoginName();"/>
			 		<label id="checkLoginNameResult" class="checkResult"><form:errors path="loginName" /></label>
			 	</td>
			</tr>
			
			<tr>
				<td><label>Password</label></td>
				<td>
					<form:password path="password" class="inputBg" onblur="return checkPassword();"/>
				 	<label id="checkPasswordResult" class="checkResult"><form:errors path="password" /></label>
			 	</td>
			</tr>
			
			<tr>
				<td><label>Confirm Password</label></td>
				<td>
					<form:password path="password2" class="inputBg" onblur="return confirmPassword();"/>
				 	<label id="confirmPasswordResult" class="checkResult"><form:errors path="password2" /></label>
				 </td>
			</tr>
			
			<tr>
				<td><label>Email</label></td>
				<td>
					<form:input path="email" class="inputBg" onblur="return checkEmail();"/>
				 	<label id="checkEmailResult" class="checkResult"><form:errors path="email" /></label>
			 	</td>
			</tr>
			
			<tr>
				<td><center>
					<input type="submit" value="register" class="registerBtn" onclick="return checkOnSubmit();" /></center>
				</td>
				
				<td><center>
					<input type="reset" value="reset" class="registerBtn" onclick="return resetAll();"/></center>
			 	</td>
	        </tr>
	        
	      </table>
      </form:form>
    </div>
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
		$('#confirmPasswordResult').html("");
		$('#checkEmailResult').html("");
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
		//pattern...
		$.ajax({  
			type: "post",  
			url: "ajaxCheckLoginName",
			dataTpye: "json",
			data: {"loginName":loginName},
			success: function(response){
				$('#checkLoginNameResult').html(response);  
			},  
			error: function(e){ 
				$('#checkLoginNameResult').html(response);
			}
		});
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
	
	function confirmPassword() {
		var password = $('#password').val();
		var password2 = $('#password2').val();
		if (password == "") {
			$('#checkPasswordResult').html("please type in password.");
			$('#password').focus();
			return false;
		} else {
			$('#checkPasswordResult').html("");
		}
		if (password2 == "") {
			$('#confirmPasswordResult').html("please type in confirm password.");
			$('#password2').focus();
			return false;
		} else {
			$('#confirmPasswordResult').html("");
		}
		if (password != password2) {
			$('#confirmPasswordResult').html("please type in the same confirm password as password.");
			$('#password').focus();
			return false;
		}
	}
	
	function checkEmail() {
		var email = $('#email').val(); 
		if (email == "" ) {
			$('#checkEmailResult').html("please type in email.");
			$('#email').focus();
			return false;
		} else {
			$('#checkLoginNameResult').html("");
		}
		//pattern...
		$.ajax({  
			type: "post",  
			url: "ajaxCheckEmail",
			dataTpye: "json",
			data: {"email":email},
			success: function(response){ 
				$('#checkEmailResult').html(response);
			},  
			error: function(e){
				$('#checkEmailResult').html(e);
			}
		});
	}

	function checkOnSubmit() {
		var loginName = $('#loginName').val();
		var password = $('#password').val();
		var password2 = $('#password2').val();
		var email = $('#email').val();
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
		if (password2 == "") {
			$('#confirmPasswordResult').html("please type in confirm password.");
			$('#password2').focus();
			return false;
		}
		if (email == "") {
			$('#checkEmailResult').html("please type in email.");
			$('#email').focus();
			return false;
		}
		if (password != password2) {
			$('#confirmPasswordResult').html("please type in the same confirm password as password.");
			$('#password').focus();
			return false;
		}
	}
</script>

</body>
</html>