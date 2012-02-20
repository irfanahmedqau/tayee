<%--
  This page renders links to categories and subcategories,
  featured products for every catagory, and also
  highlight selected top level category.
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>






<%--String[] rootCategoryList={"cat01","cat02"}; --%>
<%String[] rootCategoryList={"cata_md","cata_co","cata_md","cata_co","cata_md","cata_co","cata_md","cata_co"};%>


<c:forEach var="rootCategory" items="<%=rootCategoryList%>"
					varStatus="status">
					
<jsp:include page="${jspRootPath}/gadget/leftNavigationCategory.jsp" >
 <jsp:param name="rootCategoryId" value="${rootCategory}"/>
</jsp:include>


</c:forEach>







