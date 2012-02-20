<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="${jspRootPath}/includes/global/incScript.jsp" />
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
<script type="text/javascript" src="${jsRootPath}/myaccount/myaccount_homeaddr.js"></script>
<title>Home Addresses</title>
</head>
<body>
<div id="topbar">
	<jsp:include page="${jspRootPath }/includes/common/incPageTopBar.jsp"/> 
</div>

<%--include the home page header --%>
<div id="wrap">
	<jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp"/>
</div>
<div id="mainContent">
	<center>
	<fieldset>
	
	<th >	<fmt:message key="Myaccount.homeaddr.title" /></th>
	
	<c:if test="${allHomeAddresses ne null }">
		<table border="1">
			
			<tr>
				<td colspan="2"><fmt:message key="Myaccount.homeaddr.detail" /></td>
				<td colspan="2"><fmt:message key="Myaccount.homeaddr.operation" /></td>
			</tr>
			<c:forEach var="address" items="${allHomeAddresses}" varStatus="status">
				<tr>
					<td colspan="2"><fmt:message key="Myaccount.homeaddr.contact" />:${address.contact}<br/>
						<fmt:message key="Myaccount.homeaddr.mobilephone" />:${address.mobilePhone}<br />
						<fmt:message key="Myaccount.homeaddr.detail" />:${address.detailAddress}<br />
					</td>
					<td colspan="2"><a href="${contextPath}/deleteHomeAddress?id=${address.id}">delete</a>
						<a href="javascript:modify('${address.id}')" id ="modify" onclick="">modify</a>
					</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
	</fieldset>
	<input align="left" id="new_homeaddress" type="button" value="add new homeaddress" onclick="new_homeaddress()">

	

		
		<div id="form_hidden" style="display:none">
		<form:form id="homeaddr_form" action="${contextPath}/addHomeAddress" method="post" modelAttribute="HomeAddrForm" >

		<fieldset>
		<table>
			<tr>
				<td><label><fmt:message key="Myaccount.homeaddr.region" />:</label></td>
				<td>
					<form:select   id="country" path="countryId" onchange="selectedCountry()" onclick="getAllCountries()">
						<option>please select</option>
						
					</form:select>
					<form:select style="diaplay:none" id="province" path="provinceId" onchange="selectedProvice()">
						<option>please select</option>
					</form:select>
					<form:select style="diaplay:none" id="city" path="cityId"  onchange="selectedCity()">
						<option>please select</option>
					</form:select>
					<form:select style="diaplay:none" id="district" path="districtId" onchange="selectedDistrict()">
						<option>please select</option>
					</form:select>
					<form:errors path="countryId" cssClass="error" />
				</td>
			</tr>
			
			<tr>
				<td>
					<label><fmt:message key="Myaccount.homeaddr.detail" />:</label></td>
				<td>	<form:input id="detailAddress" path="detailAddress" />
					<form:errors path="detailAddress" cssClass="error" />
				</td>
				</tr>
				<tr>
				<tr>
				<td>
					<label><fmt:message key="Myaccount.homeaddr.zipcode" />:</label></td>
				<td>	<form:input path="zipCode" />
					<form:errors id="zipCode" path="zipCode" cssClass="error" />
				</td>
				</tr>
				<tr>
				<td>
					<label><fmt:message key="Myaccount.homeaddr.contact" />:</label></td>
				<td>	<form:input path="contact" />
					<form:errors id="contact" path="contact" cssClass="error" />
				
				</td>
				</tr>
				<tr>
				<td>
					<label><fmt:message key="Myaccount.homeaddr.linephone" />:</label></td>
				<td>	<form:input path="linePhone" />
				<form:errors id="contact" path="contact" cssClass="error" />
				
				</td>
				</tr>
				<tr>
				<td>
					<label><fmt:message key="Myaccount.homeaddr.mobilephone" />:</label></td>
				<td>	<form:input path="mobilePhone" />
				<form:errors id="mobilePhone" path="mobilePhone" cssClass="error" />
					
				</td>
				</tr>
				<tr>
				<td>
					<form:hidden id="homeaddr_id" path="id"/>
				<input type="submit" value="save"> <a type="button" onclick="cancle()">cancle</a>
				</td>
			</tr>
			
		</table>
			

		</fieldset>
	</form:form>
		</div>
	<%--include the page footer --%>
	</center>
	</div>
<div id="footer">
	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
</div>
</body>
</html>