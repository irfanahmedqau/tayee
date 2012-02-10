<%--
  This page build one root category in the left navigation bar
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>
<%@page import="com.bleum.canton.homepage.gln.mock.MockedCategoryVO"%>
<%@page import="java.util.*"%>

<%-- get the values from the included page --%>



<c:set var="rootCategoryId" value="${param.rootCategoryId }" />
<%
    String rootCategoryId = (String) (pageContext.getAttribute("rootCategoryId"));
   
    //get the registration table object
    Map<String, MockedCategoryVO> beanRegistrationTable = (Map<String, MockedCategoryVO>) application
            .getAttribute("beanRegistrationTable");

    //get all the related information by given the bean name
    MockedCategoryVO rootCategoryVO = beanRegistrationTable.get(rootCategoryId);
    //out.println(rootCategoryVO.getCategoryId());

    String rootCategoryName = rootCategoryVO.getCategoryName();

    //get subCategories
    ArrayList<String> subCategoryIds = (ArrayList<String>) rootCategoryVO.getSubCategories();
    
%>


<li>
	<h3>
		<a href="${jspRootPath}/gadget/category.jsp">
			<param name="categoryNavIds" value="1" />
			<param name="itemId" value="1" /> <%=rootCategoryName%>
		</a>
	</h3>
	<div class="bar"></div>
	<div class="menu">
		<div class="SubItem">
			<div>

				<c:forEach var="level1CategoryId" items="<%=subCategoryIds %>"
					varStatus="status">
					<%
					    String level1CategoryId = (String) pageContext.getAttribute("level1CategoryId");

					        //lookup the bean registration table to get the related information
					        MockedCategoryVO level1CategoryVO = beanRegistrationTable.get(level1CategoryId);

					        String level1CategoryName = level1CategoryVO.getCategoryName();
					        ArrayList<String> level2CategoryIds = (ArrayList<String>) level1CategoryVO.getSubCategories();
					%>
					<div class="Fore">
						<a href="javascript:void(0)"><%=level1CategoryName%></a>
					</div>
					<div class="list">
						<dl>
							<c:forEach var="level2CategoryId" items="<%=level2CategoryIds %>"
								varStatus="status">
								<%
								    String level2CategoryId = (String) pageContext.getAttribute("level2CategoryId");
								            //out.println(level1CategoryId);
								            //lookup the bean registration table to get the related information
								            MockedCategoryVO level2CategoryVO = beanRegistrationTable.get(level2CategoryId);

								            String level2CategoryName = level2CategoryVO.getCategoryName();
								%>

								<dt>
									<nobr>
										<a href="javascript:void(0)"><%=level2CategoryName %></a>
									</nobr>
								</dt>

							</c:forEach>
						</dl>
					</div>

				</c:forEach>
			</div>





		</div>
		<jsp:include page="${jspRootPath }/gadget/leftNavigationPromotion.jsp" />
</li>

