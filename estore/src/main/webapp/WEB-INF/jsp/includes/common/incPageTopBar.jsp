<%--
  The top bar ,which contains the following contents:
  1) welcome words
  2) login
  3) register
  4) store locator
  5) help center
  6) favorite
  7) phone call customer center
  8) online customer center
  9) shopping cart
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>

	<%--the welcome word--%>
	<div class="topbar-welcome-word">
      <p><fmt:message key="canton.pageTopbar.welcomeVisit" /> </p>
   
    
      <%--
        the login area:
        if the user is transient ,it will display "登录"
        else,it will display "欢迎，用户名"
      --%>    
      <div class="topbar-login-area">
      <c:choose>
  		<c:when test="${ profile eq null}">
  		<a href="${jspRootPath}/cantonstore/myaccount/login.jsp" class="whiteText"><fmt:message key="canton.pageTopbar.login" /></a>
  		&nbsp;│&nbsp;
  		<a href="javascript:void(0)"><fmt:message key="canton.pageTopbar.register" /></a>
  		</c:when>
  		<c:otherwise>
  		<fmt:message key="canton.pageTopbar.welcome" />&nbsp;<dsp:valueof bean="Profile.firstName"/>│&nbsp;
              <a href="${jspRootPath}/myaccount/login.jsp" title="${logoutTitle}"
                   bean="B2CProfileFormHandler.logout" value="logout"><fmt:message key="canton.pageTopbar.logout" /></a>
  		 </c:otherwise>
	 </c:choose>
	 </div>
	 
	 <%-- my account --%>
	<div class="topbar-my-account">
	&nbsp;│&nbsp;
	<a href="javascript:void(0)" class="whiteText myAcount"><fmt:message key="canton.pageTopbar.myCanton" /></a>
	</div>
	
	<%-- store locator --%>
	<div class="topbar-store-locator">
	&nbsp;│&nbsp;<a href="javascript:void(0)" id="storeLocatorLink" class="whiteText"><fmt:message key="canton.pageTopbar.search" /></a>
	</div>
	
	<%-- help center --%>
	<div class="topbar-help-center">
	&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText helpcenter"><fmt:message key="canton.pageTopbar.help" /></a>
	</div>
	
	<%-- my favourite --%>
	<div class="topbar-my-favourite">	
	&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText favFolder"><fmt:message key="canton.pageTopbar.favorites" /></a>
	</div>
	
	<%-- online service --%>
	<div class="topbar-online-service">
	&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText cs"><span class="onLineService"></span><fmt:message key="canton.pageTopbar.online" /></a>
	</div>
	
	<%-- shopping cart --%>
	<div class="topbar-shopping-cart">
	&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText myMiniCart"><span class="myCart"></span><fmt:message key="canton.pageTopbar.cart" />(<span class="itemsCountInCart">0</span>)</a><a href="javascript:void(0)" class="closeBtn" style="visibility:hidden"></a>
	</div>
	
	 </div>
	 
	 
	 
	
      
      