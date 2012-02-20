<%--
 This jsp page build one swimlane ,it can display the first 4 products in this category
 passed by the parameter
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>
<%@page import="com.bleum.canton.mock.*"%>
<%@page import="com.bleum.canton.itempage.dao.*"%>
<%@page import="com.bleum.canton.itempage.dao.impl.*"%>
<%@page import="com.bleum.canton.itempage.entity.*"%>
<%@page import="com.bleum.canton.itempage.service.*"%>
<%@page import="java.util.*"%>


<c:set var="swimlaneLength" value="${param.swimlaneLength }" />
<c:set var="catId" value="${param.catId }" />


<%
	
		String catId = (String) (pageContext.getAttribute("catId"));
		int swimlaneLength =Integer.parseInt( ((String) (pageContext.getAttribute("swimlaneLength")))     );
		      	
		
		//get the reference of itempage
		IItempageService itempageService = (IItempageService) request.getAttribute("itempageService");

		
		//get the categoryObject which need to render
		Category category = itempageService.getCategoryByID(catId);
		
		
		
		//get the categoryName 
		String categoryName=category.getCategoryName();
		

		//get the products which belongs to this category
		ArrayList<Product> products = (ArrayList<Product> )itempageService.findProductByCategoryID(catId);
		
		//how many products in this category
		int numOfProductsToDisplay = (products.size()<=swimlaneLength)?products.size():swimlaneLength;
		
	

	%>
<div id="cateSport" class="cateProd">
	<h3>
		<%=categoryName %>

		</h2>
		<ul>

			<c:forEach var="product" items="<%=products %>" begin="0"
				end="<%=numOfProductsToDisplay-1 %>" step="1">
				<li><div class="proImg">
						<img src="${imagesRootPath }/${product.thumbImageURL}">
					

						<%
						Product product = (Product) (pageContext.getAttribute("product"));
						int productId=product.getId();
											
						boolean hasItems=true;
						Item defaultItem=null;
						
						//the price is found in item level ,so we can get the default item related to this product
						try{
						    defaultItem=itempageService.getDefaultItemByProductID(productId);
						    if (defaultItem ==null)
							    hasItems = false;
						}catch(Exception ex){
						    hasItems=false;
						    
						}
						
										
						
					%>

						<c:choose>

							<c:when test="<%=hasItems%>">

								<%
      					 	//get the price of the defaultItem
      					 	double price =defaultItem.getPrice();
      					 %>
      					 </div> 
      					 <a title="${product.productName }"
					        href="${contextPath }/viewProduct/${product.id}/default">
					     ${product.productName}</a>
					<div>
					

								<font color="red"> <fmt:message
										key="canton.mainContentCenter.specialPrice" /> <fmt:message
										key="canton.mainContentCenter.rmbSymbol" /> <strong><%=price %></strong>
								</font>
					</div></li>

				</c:when>

				<c:otherwise>
				
					 </div> 
					 <a title="${product.productName }" href="#">${product.productName}</a>
					<div>

					<font color="red"> &nbsp;&nbsp;<strong><fmt:message
								key="canton.mainContentCenter.noPrice" /> </strong>
					</font>
					
				</c:otherwise>

				</c:choose>


			</c:forEach>






		</ul>
</div>

