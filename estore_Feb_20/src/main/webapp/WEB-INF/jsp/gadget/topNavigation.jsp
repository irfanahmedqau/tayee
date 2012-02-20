<%--
  This page renders links to categories and subcategories,
  featured products for every catagory, and also
  highlight selected top level categories.
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>

<%--String[] rootCategoryList={"cat01","cat02"}; --%>
<%String[] rootCategoryList={"cata_md","cata_co","cata_md","cata_co","cata_md","cata_co","cata_md","cata_co"};%>







<div id="topNavigation">
	<ul>
		
		<c:forEach var="rootCategory" items="<%=rootCategoryList%>"
					varStatus="status">
					
	<jsp:include page="${jspRootPath}/gadget/topNavigationTab.jsp" >
 	<jsp:param name="rootCategoryId" value="${rootCategory}"/>
	</jsp:include>
	</c:forEach>


	
	</ul>
</div>







