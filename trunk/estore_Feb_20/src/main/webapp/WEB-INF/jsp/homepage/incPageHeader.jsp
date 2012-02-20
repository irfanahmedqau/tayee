<%--
  The page header,which includes the canton logo and the search bar
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>
<%@ page contentType="text/html; charset=UTF-8"%>


<div id="pageHeader">
	<%--the canton logo ,will replace the walmart logo to canton logo later --%>
	<div class=logo style="padding: 10px 0 0 0">
		<a href="${contextPath}/index"> <img src="${imagesRootPath}/canton.gif" />
		</a>
	</div>

	<%--the search bar--%>
	<div class=searchBar
		style="position: absolute; margin: -60px 0 0 360px;">
		<div class="navSearchWrap">

			<div class="navSeachPart">

				<div class="searchPanel">
					<div class="panelLBg">
						<img src="${imagesRootPath}/seachArea_Bg_L.gif" />
					</div>

					<div class="panelM">
						<jsp:include page="${jspRootPath}/gadget/searchGadget.jsp" />
					</div>

					<div class="panelRBg">
						<img src="${imagesRootPath}/seachArea_Bg_R.gif" />
					</div>


					<div class="remindInfo">
						<a href="javascript:void(0)"><fmt:message
								key="canton.pageHeader.advancedSearch" /></a><br /> <a
							href="javascript:void(0)"><fmt:message
								key="canton.pageHeader.help" /></a>
					</div>
				</div>
			</div>



		</div>

	</div>

</div>
