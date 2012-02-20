<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Admin</title>
    </head>
    <body>
        Search Admin
        <div>
            <div>
                <a href="${contextPath}/admin/search/clear"> Clear Index</a>
            </div>
            <div>
                <a href="${contextPath}/admin/search/create"> Create Index</a>
            </div>
        </div>
    </body>
</html>