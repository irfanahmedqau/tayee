<%--
  This page renders links to categories and subcategories,
  featured products for every catagory, and also
  highlight selected top level category.
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>


<!-- //////////////////////  -->

<jsp:include page="${jspRootPath}/gadget/mockedCategoriesInit.jsp" />


<jsp:include page="${jspRootPath}/gadget/leftNavigationCategory.jsp" >
 <jsp:param name="rootCategoryId" value="cat01"/>
</jsp:include>



