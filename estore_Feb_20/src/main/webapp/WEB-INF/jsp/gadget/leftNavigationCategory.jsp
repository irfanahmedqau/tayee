<%--
  This page build one root category in the left navigation bar
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>
<%@page import="com.bleum.canton.mock.MockedCategoryVO"%>
<%@page import="com.bleum.canton.mock.MockedBeanRegistrationTable"%>
<%@page import="com.bleum.canton.itempage.service.*"%>
<%@page import="com.bleum.canton.itempage.entity.*"%>
<%@page import="java.util.*"%>

<%-- get the values from the included page --%>



<c:set var="rootCategoryId" value="${param.rootCategoryId }" />
<%
    String rootCategoryId = (String) (pageContext.getAttribute("rootCategoryId"));

    IItempageService itempageService = (IItempageService) request.getAttribute("itempageService");

    //get all the related information by given the bean name
    Category rootCategory = (Category) itempageService.getCategoryByID(rootCategoryId);
    //out.println(rootCategoryVO.getCategoryId());

    String rootCategoryName = rootCategory.getCategoryName();

    //get subCategories
    ArrayList<String> subCategoryIds = (ArrayList<String>) itempageService.getChildCategoryIDs(rootCategoryId);
%>


<li>



	<h3>
		<a href="${jspRootPath}/gadget/category.jsp">
			<param name="categoryNavIds" value="1" />
			<param name="itemId" value="1" /> <%=rootCategoryName%>
		</a>
	</h3>

	<div class="menu">



		<div class="SubItem">


			<c:forEach var="level1CategoryId" items="<%=subCategoryIds %>"
				varStatus="status">
				<%
				    String level1CategoryId = (String) pageContext.getAttribute("level1CategoryId");

				        //lookup the bean registration table to get the related information
				        //MockedCategoryVO level1CategoryVO = (MockedCategoryVO)beanRegistrationTable.get(level1CategoryId);
				        Category level1Category = itempageService.getCategoryByID(level1CategoryId);
				        String level1CategoryName = level1Category.getCategoryName();
				        ArrayList<String> level2CategoryIds = (ArrayList<String>) itempageService
				                .getChildCategoryIDs(level1CategoryId);
				%>
				<div>
					<%--start of enclosed div of fore and list --%>


					<div class="Fore">
						<%--begin of fore div --%>
						<a href="javascript:void(0)"><%=level1CategoryName%></a>
					</div>
					<%--end of Fore div --%>

					<div class="list">
						<%--begin of list div --%>
						<dl>
							<c:forEach var="level2CategoryId" items="<%=level2CategoryIds %>"
								varStatus="status">
								<%
								    String level2CategoryId = (String) pageContext.getAttribute("level2CategoryId");
								            //out.println(level1CategoryId);
								            //lookup the bean registration table to get the related information
								            Category level2Category = itempageService.getCategoryByID(level2CategoryId);

								            String level2CategoryName = level2Category.getCategoryName();
								%>

								<dt>
									<nobr>
										<a href="javascript:void(0)"><%=level2CategoryName%></a>
									</nobr>
								</dt>


							</c:forEach>
						</dl>
					</div>
					<%--end of list div --%>
					<br>



				</div>
				<%--end of enclosed div --%>

			</c:forEach>






		</div>
		<%-- end of SubItem div --%>

		<jsp:include page="${jspRootPath }/gadget/leftNavigationPromotion.jsp" />
</li>

