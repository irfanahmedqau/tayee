<%--
  This page is the home page
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--include the global page start page --%>
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
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
	
	<%--include the top navigation bar --%>
	<jsp:include page="${jspRootPath}/gadget/topNavigation.jsp"/>
	
	<%--include the homepage body --%>
	<jsp:include page="${jspRootPath }/homepage/mainContentLeft.jsp" />
    <jsp:include page="${jspRootPath }/homepage/mainContentCenter.jsp" />
    <jsp:include page="${jspRootPath }/homepage/mainContentRight.jsp" />

	
	<%--include the page footer --%>
	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
</body>
</html>