<%--
  The left part of the main content in homepage,and it includes the following parts:
  1) the left navigation
  2) the hot sale
  3) the famous brands
  
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>


    <%-- the left part of the main content --%>
    <div id="mainContentLeft">
    <%-- left navigation --%>
		<div id="leftNavigation" class="section">
		  <h2><fmt:message key="canton.leftNavigation.title" /><a href="#"></a></h2>
		  <ul>
		  	<jsp:include page="${jspRootPath}/gadget/leftNavigation.jsp" />
		  </ul>
		</div>
  
  
		<jsp:include page="${jspRootPath}/gadget/hotTabGroup.jsp" />

		<div class="section" style="height:70px; margin-top:5px; padding: 2px;">
		  <img src="${imagesRootPath }/HPADV020101214142103.gif" />
		</div>

		<jsp:include page="${jspRootPath }/gadget/brand.jsp"/>

		<div class="section">
		  <img src="${imagesRootPath }/T2PoxwXaJaX.jpg" />
		</div>
		<br>
		
		<jsp:include page="${jspRootPath }/gadget/browseHistory.jsp" />
		<br>

		

    </div>
