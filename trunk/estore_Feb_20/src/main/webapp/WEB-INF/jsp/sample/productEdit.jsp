<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${cssRootPath}/sample.css">
<title>Product Edit</title>
</head>
<body>
	<c:if test="${saved ne null}">
		<c:if test="${saved eq 1}">
			<p class="message">
				<fmt:message key="product.saved.success" />
			</p>
		</c:if>
		<c:if test="${saved eq 0}">
			<p class="message error">
				<fmt:message key="product.saved.failure" />
			</p>
		</c:if>
	</c:if>
	<form:form action="${contextPath}/saveProductInfo" method="post" modelAttribute="productForm">
		<fieldset>
			<legend> <fmt:message key="product.edit.form.name"/> </legend>
			<div class="attrName">
				<label><fmt:message key="product.attr.name" />:</label><br>
				<label><fmt:message key="product.attr.skuid" />:</label><br>
				<label><fmt:message key="product.attr.storages" />:</label><br>
			</div>
			<div class="attrVal">
				<form:input path="productName" /><form:errors path="productName" cssClass="error"/><br>
				<form:input path="skuId" /><form:errors path="skuId" cssClass="error"/><br>
				<form:checkbox path="storages" value="200000"/>Shanghai&nbsp;&nbsp;
				<form:checkbox path="storages" value="100000"/>Beijing&nbsp;&nbsp;
				<form:checkbox path="storages" value="510000"/>Guangzhou&nbsp;&nbsp;
				<form:checkbox path="storages" value="430000"/>Wuhan&nbsp;&nbsp;
				<form:errors path="storages" cssClass="error"/><br>
				<input type="submit" value="save">
				<input type="reset" value="reset">
			</div>
			<div class="clear"></div>
		</fieldset>
	</form:form>
</body>
</html>