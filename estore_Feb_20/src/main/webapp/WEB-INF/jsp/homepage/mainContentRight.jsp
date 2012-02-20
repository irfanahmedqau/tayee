<%--
  The right part of the main content in homepage,and it includes the following parts:
  1) advertisement bar
  2) placeholders of these items
  
  
  
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
  
--%>

	<div id="mainContentRight">
       <%--the advertisement image --%>
       <div class="section" style="height:255px;"><a href="javascript:void(0)"><img src="${imagesRootPath }/HF20101214120002.jpg" border="0" /></a></div>
       
       <%--the main content right count down list --%>
       <div id="mainContentRightCountdown_0" class="Rightcountdown">
         <h4><fmt:message key="canton.mainContentRight.title1" /></h2>


         <div class="CountdownContainer">
	    

					<script type="text/javascript">
					$(function(){
					  $('#mainContentRightCountdown_0 #${skuId} .newcountdown_0').countdown('${hours}','${miniutes}','${seconds}');
					});
					</script>

					<div id="${skuId}">
				         <div class="newcountdown_0"></div>
				         <div class="cd_fight"></div>
				         <div class="cdprod_img">
				         	<a href="${pageContext.request.contextPath}/browse/productDetail.jsp?todo=true&productId=${productId}" title="${skuName}">
				         		<img height="100" width="100"  src="${imagesRootPath }/products/cdprod_img1.jpg">
				         	</a>
				         </div>
				         <div class="cdprod_name"><a href="${pageContext.request.contextPath }/browse/productDetail.jsp?todo=true&productId=${productId}" title="${skuName}">${skuName}</a></div>
				         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />:
				         	<span>
								10000
				         	</span>
				         	<c:if test="${not(hours eq 0 and miniutes eq 0 and seconds eq 0) }">(${(100-adjuster)/10}<fmt:message key="canton.mainContentRight.discount" />)</div></c:if>
					</div>
			     	
         </div>
       </div>

<script type="text/javascript">
$(function(){
  $('#mainContentRightCountdown_1 .newcountdown_0').countdown(88,23,27);
  $('#mainContentRightCountdown_2 .newcountdown_0').countdown(98,41,10);
});
</script>

       <div id="mainContentRightCountdown_1" class="Rightcountdown">
          <h4><fmt:message key="canton.mainContentRight.title2" /></h2>
          <div class="CountdownContainer">
         <div class="newcountdown_0"></div>

<div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img1.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="磊科 ( Netcore ) NW338 150M无线USB网卡">磊科 ( Netcore ) NW338 150M无线USB网卡</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;110.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>

         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img2.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="飞利浦绚彩浴霸PS10-01-RC ( 闪亮银 ) 底价促销，免费安装！">飞利浦绚彩浴霸PS10-01-RC ( 闪亮银 ) 底价促销，免费安装！</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;599.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>
 </div>
       </div>
       <div id="mainContentRightCountdown_2" class="Rightcountdown">
         <h4><fmt:message key="canton.mainContentRight.title3" /></h2>
         <div class="CountdownContainer">
         <div class="newcountdown_0"></div>
         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img5.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="[Vera Wang] 王薇薇套装">[Vera Wang] 王薇薇套装</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;900.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>

         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img6.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="SK-II多元抗皱修护精华露">SK-II多元抗皱修护精华露 50g</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;920.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>
         </div>
         
         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img6.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="SK-II多元抗皱修护精华露">SK-II多元抗皱修护精华露 50g</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;920.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>
         </div>
         
         <div class="CountdownContainer">
         <div class="newcountdown_0"></div>
         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img5.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="[Vera Wang] 王薇薇套装">[Vera Wang] 王薇薇套装</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;900.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>

         <div class="cd_fight"></div>
         <div class="cdprod_img"><img src="${imagesRootPath }/products/cdprod_img6.jpg"></div>
         <div class="cdprod_name"><a href="javascript:void(0)" title="SK-II多元抗皱修护精华露">SK-II多元抗皱修护精华露 50g</a></div>
         <div class="cdprod_price"><fmt:message key="canton.mainContentRight.price" />: <span>&yen;920.00</span> (3<fmt:message key="canton.mainContentRight.discount" />)</div>
         </div>
         
       </div>
       

     </div><%-- mainContentRight div end --%>
