<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CA Console</title>
<%@include file="/WEB-INF/jsp/includes/extjs.jspf" %>
<style type="text/css">
	#center_wrapper {margin:180px auto; width: 350px;}
</style>
<script language="JavaScript" type="text/javascript">
	var formAction = '${contextPath}/j_spring_security_check';
</script>
<script type="text/javascript" src="${jsRootPath}/login.js"></script>
</head>
<body>
<div id="center_wrapper"></div>
</body>
</html>