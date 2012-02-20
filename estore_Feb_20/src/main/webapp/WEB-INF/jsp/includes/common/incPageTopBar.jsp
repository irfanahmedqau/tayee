<%--
  The top bar ,which contains the following contents:
  1) welcome words
  2) login
  3) register
  4) store locator
  5) help center
  6) online customer center
  7) shopping cart
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>

<%--the welcome word--%>
<div class="topbar-welcome-word">
	<p>
		<fmt:message key="canton.pageTopbar.welcomeVisit" />
	</p>


	<%--
        the login area:
        if the user is transient ,it will display "登录"
        else,it will display "欢迎，用户名"
      --%>    
      <div class="topbar-login-area">
      <c:choose>
  		<c:when test="${ loginName eq null}">
  		<a href="${contextPath}/login" class="whiteText"><fmt:message key="canton.pageTopbar.login" /></a>
  		&nbsp;│&nbsp;
  		<a href="${contextPath}/register"><fmt:message key="canton.pageTopbar.register" /></a>
  		</c:when>
  		<c:otherwise>
  		<fmt:message key="canton.pageTopbar.welcome" />&nbsp;<dsp:valueof bean="Profile.firstName"/>│&nbsp;
              <a href="${contextPath}/logout" title="${logoutTitle}"
                   bean="B2CProfileFormHandler.logout" value="logout"><fmt:message key="canton.pageTopbar.logout" /></a>
  		 </c:otherwise>
	 </c:choose>
	 </div>
	 
	 <%-- my account --%>
	<div class="topbar-my-account">
		&nbsp;│&nbsp; <a href="${contextPath}/myaccount/home"
			class="whiteText myAcount"><fmt:message
				key="canton.pageTopbar.myCanton" /></a>
	</div>
	
	<%-- store locator --%>
	<div class="topbar-store-locator">
		&nbsp;│&nbsp;<a href="javascript:void(0)" id="storeLocatorLink"
			class="whiteText"><fmt:message key="canton.pageTopbar.search" /></a>
	</div>
	
	<%-- help center --%>
	<div class="topbar-help-center">
		&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText helpcenter"><fmt:message
				key="canton.pageTopbar.help" /></a>
	</div>

	<%-- shopping cart --%>
	<div class="topbar-shopping-cart">
		&nbsp;│&nbsp;
		<!-- &nbsp;&nbsp;<a href="javascript:void(0)" class="whiteText myMiniCart"><span class="myCart"></span><fmt:message key="canton.pageTopbar.cart" />(<span class="itemsCountInCart">0</span>)</a><a href="javascript:void(0)" class="closeBtn" style="visibility:hidden"></a> -->
		<a class="whiteText myMiniCart" href="${contextPath}/shoppingcart/display"> <span
			class="myCart"></span> <fmt:message key="canton.pageTopbar.cart" />(
			<span class="prodsNum">0</span> )
		</a> <a class="closeBtn" style="visibility: hidden"
			href="javascript:void(0)"></a>
	</div>
</div>


</div>





