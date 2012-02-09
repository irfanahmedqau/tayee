<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<p class="message">The previous product saved successfully.</p>
		</c:if>
		<c:if test="${saved eq 0}">
			<p class="message error">The previous product saved failed.</p>
		</c:if>
	</c:if>
	<form action="${contextPath}/saveProductInfo" method="post">
		<fieldset>
			<legend> Edit Storages Info of Product </legend>
			<div class="attrName">
				<label>Product Name:</label><br>
				<label>SKU ID:</label><br>
				<label>Available Storages:</label><br>
			</div>
			<div class="attrVal">
				<input type="text" name="productName" value=""><br>
				<input type="text" name="skuId" value=""><br>
				<input type="checkbox" name="storages" value="200000">Shanghai&nbsp;&nbsp;
				<input type="checkbox" name="storages" value="100000">Beijing&nbsp;&nbsp;
				<input type="checkbox" name="storages" value="510000">Guangzhou&nbsp;&nbsp;
				<input type="checkbox" name="storages" value="430000">Wuhan&nbsp;&nbsp;<br>
				<input type="submit" value="save">
				<input type="reset" value="reset">
			</div>
			<div class="clear"></div>
		</fieldset>
	</form>
</body>
</html>