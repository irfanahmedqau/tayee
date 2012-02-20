<%--
  The part is used for holding the swimlanes
  
  The side of each swimlane is configurable
  <c:set var="swimlaneLength" value="some digital"/>
  
  How many categories to render is also configurable
  String[] renderedCategories={"cat0227","cat0227","cat0227","cat0227",
  "cat0227","cat0227","cat0227"};		
  
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>

	<%	
		//configurable here to define which category we need to render in the swimlane
		//so that we can render the first 4 products in this category
		String[] renderedCategories={"cata_m_mobile","cata_m_mobile","cata_m_mobile","cata_m_mobile","cata_m_mobile","cata_m_mobile","cata_m_mobile"};		
	%>

	<div id="mainContentCate" class="section" style="margin-top: -5px;">
	
	<%--global configure the length of each swimlane --%>
	<c:set var="swimlaneLength" value="3"/>
	
	
	<%--iterate to display each swimlane ,each of them stands for the products in this category --%>
	<c:forEach var="renderCategory" items="<%=renderedCategories%>"
					varStatus="status">
					
	<jsp:include page="${jspRootPath }/homepage/mainContentSwimlane.jsp">
		<jsp:param name="swimlaneLength" value="${swimlaneLength }" />
		<jsp:param name="catId" value="${renderCategory }" />
	</jsp:include>
	
	</c:forEach>


	</div>
	<!-- end of mainContentCate -->
