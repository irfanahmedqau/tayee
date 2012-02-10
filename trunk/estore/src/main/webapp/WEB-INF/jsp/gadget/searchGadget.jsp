<%--
  The search gadget, which is a form ,when submit,it will go to search result page.
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>


<form action="${jspRootPath}/browse/searchResults.jsp">
  <div class="keyInfoInput">
  	<label for="topSearch">
  		<input type="text" id="topSearch" autocomplete="off" maxlength="50" name="topSearch" class="defaultKey ui-autocomplete-input" value=<fmt:message key="canton.searchwidget.promptWord"/> role="textbox" aria-autocomplete="list" aria-haspopup="true">
  		
  	</label>
  </div>
  <div class="areaSelect"><select>
	 
	  <option value ="xx"><fmt:message key="canton.searchwidget.option.all"/></option>
	  <option><fmt:message key="canton.searchwidget.option.digital"/></option>
	  <option><fmt:message key="canton.searchwidget.option.food_drink"/></option>
	  <option><fmt:message key="canton.searchwidget.option.sport_healthy"/></option>
	  <option><fmt:message key="canton.searchwidget.option.cosmetic"/></option>
	  <option><fmt:message key="canton.searchwidget.option.appliance"/></option>
	  
	  </select>
   </div>
   <div class="searchButton">	 
		<input type="text" style="display:none" />
        <input  type="hidden" value="${jspRootPath}/browse/searchResults.jsp"/>
        <input type="submit" value="Search" style="display:none" id="cantonSearch"/>
        <input id="searchImg" type="submit" value=""/>
   	</div>
  <form>


