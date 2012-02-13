<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="app.name"/></title>
<%@ include file="/WEB-INF/jsp/includes/extjs.jspf" %>
<script type="text/javascript">
	Ext.onReady(function(){
		//Register User Model
		Ext.define('User', {
			extend: "Ext.data.Model",
			fields: [
				{name: 'id', type: 'string'},
				{name: 'userName', type: 'string'},
				{name: 'age', type: 'int'}
			],
			proxy: {
				type: 'rest',
				url: '${contextPath}/user',
				reader: {
					type: 'json',
					root: 'data'
				}
			}
		});
		//uses the User Model's Proxy
		Ext.create('Ext.data.Store', {
		    model: 'User'
		});

		//Save the user.
		document.getElementById('saveButton').onclick = function(){
			//Get the constructor of User model
			//var User = Ext.ModelMgr.getModel('User');
			var user = Ext.create('User', {
				userName: document.getElementById('userName').value,
				age: document.getElementById('age').value
			});
			user.save({
				success: function(user){
					alert('User saved successfully. ID is [' + user.getId() +'].');
				}
			});
		};
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>User Name:</td>
			<td>
				<input id="userName" type="text" value="">
			</td>
		</tr>
		<tr>
			<td>Age:</td>
			<td>
				<input id="age" type="text" value="">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="saveButton">Save</button>
			</td>
		</tr>
	</table>
</body>
</html>