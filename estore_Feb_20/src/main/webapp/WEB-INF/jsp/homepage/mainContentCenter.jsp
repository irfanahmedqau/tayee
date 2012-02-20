<%--
  The right part of the main content in homepage,and it includes the following parts:
  1) advertisement bar
  2) placeholders of these items
  
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>

<%@page import="com.bleum.canton.mock.*" %>
<%@page import="java.util.*" %>


<div id="mainContentCenter">

	<%--this part is the mainContent advertisements which can float --%>
	<jsp:include page="${jspRootPath }/homepage/mainContentAdvertisement.jsp"/>


	<%--this part is the container which can hold swimlanes --%>

	<jsp:include page="${jspRootPath }/homepage/mainContentSwimlaneContainer.jsp"/>

</div>
<%-- mainContentRight div end --%>
