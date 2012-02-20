<%@page import="com.bleum.canton.itempage.entity.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>沃尔玛网店</title>
<jsp:include page="${jspRootPath}/includes/global/incScript.jsp" />
<script type="text/javascript"
	src="${jsRootPath}/lib/datepicker/jquery-ui-1.8.7.custom.min.js"></script>
<link href="${jsRootPath}/lib/datepicker/jquery-ui-1.8.7.custom.css"
	rel="stylesheet" type="text/css">
<link href="${cssRootPath}/default.css" rel="stylesheet" type="text/css">

</head>

<script type="text/javascript">
	function changeItem(obj) {

		$(obj).parent().siblings().each(function() {
			$(this).find("a").removeClass("selected");
		});

		$(obj).addClass("selected");

		item_label = p_id;
		$(".detailList dl .itemSelectPart").each(
				function() {
					var varient_id = $(this).find(".itemSelectArea").find(
							"label").attr("id");
					var option_id = "";
					$(this).find(".itemSelect").find("ul").find("li").find("a")
							.each(function() {
								if ($(this).attr("class") == "selected")
									option_id = $(this).attr("id");
							})

					item_label += "_" + varient_id + "," + option_id;
				});

		window.location.href = "${contextPath }/viewProduct/${product.id}/"
				+ item_label;
	}

	function showTab(obj) {
		$("#product_appendent .TabHeader ul li a").each(function() {
			$(this).removeClass("cur");
		});
		$(obj).addClass("cur");
		var tab = $(obj).attr("title");
		$("#" + tab).show().siblings().hide();
	}
</script>

<body>

	<div id="topbar">
		<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
		<jsp:include page="${jspRootPath}/includes/common/incPageTopBar.jsp" />
	</div>
	<div id="wrap" class="twoColPage">
		<div id="pageHeader">
			<jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp" />
		</div>

		<div id="mainContent">
			<div id="twoColContent">
				<div id="twoColLeft">
					<div class="subCatalog">
						<h2>相关分类</h2>
						<div class="container">
							<ul>
								<li><a href="javascript:void(0)">3G手机</a></li>
								<li><a href="javascript:void(0)">笔记本电脑</a></li>
								<li><a href="javascript:void(0)">台式电脑</a></li>
								<li><a href="javascript:void(0)">数码配件</a></li>
								<li><a href="javascript:void(0)">数码相机</a></li>
								<li><a href="javascript:void(0)">影音视听</a></li>
								<li><a href="javascript:void(0)">投影设备</a></li>
								<li><a href="javascript:void(0)">导航设备</a></li>
							</ul>
						</div>
					</div>
					<div class="sameCatalog">
						<h2>品牌分类</h2>
						<div class="container">
							<ul>
								<li><a href="javascript:void(0)">联想</a></li>
								<li><a href="javascript:void(0)">惠普</a></li>
								<li><a href="javascript:void(0)">Gateway</a></li>
								<li><a href="javascript:void(0)">海信</a></li>
								<li><a href="javascript:void(0)">创维</a></li>
								<li><a href="javascript:void(0)">海尔</a></li>
								<li><a href="javascript:void(0)">长虹</a></li>
								<li><a href="javascript:void(0)">康宁</a></li>
							</ul>
						</div>
					</div>
					<div class="ADContainer">
						<img src="/ad${imagesRootPath}/button_05.jpg" />
					</div>
					<div class="ADContainer">
						<img src="/ad${imagesRootPath}/button_04.jpg" />
					</div>
					<div class="browserHistoryGray">
						<h2>我浏览过的物品</h2>
						<div class="container">
							<ul>
								<li><img
									src="${imagesRootPath}/products/0286215723090_A.jpg" />
									<div class="itext">
										<a href="javascript:void(0)">MOTOROLA摩托罗拉ME600手机</a>
									</div></li>
								<li><img
									src="${imagesRootPath}/products/0286227915390_A_45x45.jpg" />
									<div class="itext">
										<a href="javascript:void(0)">BLACKBERRY黑莓8910手机</a>
									</div></li>
								<li><img
									src="${imagesRootPath}/products/0286219524090_A_45x45.jpg" />
									<div class="itext">
										<a href="javascript:void(0)">Canon佳能EOS-50D单反相机</a>
									</div></li>
								<li><img
									src="${imagesRootPath}/products/0286228568590_A_45x45.jpg" />
									<div class="itext">
										<a href="javascript:void(0)">HP惠普Compaq Presario
											CQ32-107TX笔记本电脑</a>
									</div></li>
								<li><img
									src="${imagesRootPath}/products/0286266564590_A_45x45.jpg" />
									<div class="itext">
										<a href="javascript:void(0)">NIKON尼康D90单反相机（套机18-105镜头）</a>
									</div></li>
							</ul>
						</div>
					</div>
					<div class="ADContainer">
						<img src="/ad${imagesRootPath}/pop_bis.gif" width="200px"
							height="247px;" />
					</div>
				</div>
				<div id="twoColRight">
					<div class="crumb">
						<c:forEach var="tree" items="${categoryTree}">
							<a href="javascript:void(0)">${tree.categoryName}</a>
							<span>&gt;</span>
						</c:forEach>
						<c:out value="${product.productName})" />
					</div>
					<div class="itemInfoWrap">
						<div class="itemHeader">
							<h1>
								<c:out value="${item.itemName}" />
							</h1>
						</div>
						<div class="itemlImgArea">
							<div class="itemlImg">
								<c:forEach var="image" items="${item.images}">
									<img src="${imagesRootPath}/${image.url}" alt="ipod touch 4"
										id="prodimgLarge" width="310" height="310" />
								</c:forEach>
							</div>
							<div class="itemMoveList">
								<div class="leftArrow">
									<a href="javascript:void(0)"></a>
								</div>
								<!-- 
								<ul>
									<li class="current"><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/item_apple.jpg"
											largeSrc="${imagesRootPath}/item_apple.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_B.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_B.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_C.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_C.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_A.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_A.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_B.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_B.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_C.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_C.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_A.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_A.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_B.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_B.jpg" /></a></li>
									<li><a href="javascript:void(0)"><img
											src="${imagesRootPath}/products/small_prod120912_C.jpg"
											largeSrc="${imagesRootPath}/products/large_prod120912_C.jpg" /></a></li>
								</ul>
				 -->
								<div class="rightArrow">
									<a href="javascript:void(0)"></a>
								</div>
							</div>
							<div class="shareIconList">
								<ul>
									<li><img src="${imagesRootPath}/share_icon.gif" /></li>
									<li><span>分享到:</span></li>
									<li><a title="分享到腾讯微博" id="site-qzone"
										href="javascript:void(0)">qzone</a></li>
									<li><a title="分享到豆瓣" id="site-douban"
										href="javascript:void(0)" target="_blank">douban</a></li>
									<li><a title="分享到人人" id="site-renren"
										href="javascript:void(0)" target="_blank">renren</a></li>
									<li><a title="分享到开心网" id="site-kaixing"
										href="javascript:void(0)" target="_blank">kaixing</a></li>
									<li><a title="分享到新浪微博" id="site-sina"
										href="javascript:void(0)">sina</a></li>
									<li><a title="邮件" id="site-email"
										href="javascript:void(0)" target="_blank">email</a></li>
									<li><a title="通过QQ/MSN发送链接给好友" id="site-qqmsn"
										href="javascript:void(0)">qq/msn</a></li>
								</ul>
							</div>
						</div>
						<div class="itemMainInfoArea">
							<div class="detailList">
								<dl>
									<dd>
										产品编号:<span><c:out value="${item.id}" /></span>
									</dd>
									<dd>
										网<span class="extraSpace"></span>店<span class="extraSpace"></span>价:<span
											class="itemPrice">&yen;<strong><c:out
													value="${item.price}" /></strong></span><a href="javascript:void(0)">（降价通知）</a>
									</dd>
									<dd>
										库<span class="extraSpace"></span><span class="extraSpace"></span><span
											class="extraSpace"></span><span class="extraSpace"></span>存:
										<c:out value="${item.stockLeft}" />
									</dd>
								
									<c:set var="itemLabel" value="${item.itemLabel}" />
								
									<%!
										String[] labelFragements;
										String[] varientFragements;
									%>
									<%
										labelFragements = ((String)pageContext.getAttribute("itemLabel")).split("_");
									%>
								
									<c:forEach var="varient" items="${productVarientList}"
										varStatus="varient_status">
										
										<c:set var="varient_index" value="${varient_status.index}" />
										
										<dd class="itemSelectPart" id="item_varient_area">

											<div id="item_varient" class="itemSelectArea">
												<c:out value="${varient.varientName}" />
												<label style="display: none" id="${varient.id}">${varient.id}</label>
											</div>
											<div id="item_options" class="itemSelect">
												<ul>
													<c:forEach var="option" items="${varient.values}"
														varStatus="option_status">
														
														<c:set var="option_id" value="${option.id}" />
														
														<%
															int index = (Integer)pageContext.getAttribute("varient_index")+1;
															varientFragements = labelFragements[index].split(",");
															if(varientFragements[1].equals(String.valueOf(pageContext.getAttribute("option_id")))){
														%>
														<li><a href="javascript:void(0)"
															onclick="changeItem(this)" class="selected"
															id="${option.id}"><c:out value="${option.value}" /></a></li>
														<%
															}else{
														%>
														<li><a href="javascript:void(0)" onclick="changeItem(this)"
															id="${option.id}"><c:out value="${option.value}" />
														</a>
														</li>
														<%
															}
														%>
													</c:forEach>
												</ul>
											</div>

										</dd>
									</c:forEach>
								</dl>
							</div>
							<div class="checkOutPart">
								<div class="checkOutInfo">
									<div class="checkNumber">
										<span>我要买:</span><input type="text" value="1" id="" /><span>件</span>
									</div>
									<a href="javascript:void(0)" id="addToCart"><img
										class="btnAddTC" src="${imagesRootPath}/btn_addtocart.png"
										alt="加入购物车" /></a><a href="javascript:void(0)"><img
										src="${imagesRootPath}/btn_collection .png" alt="加入收藏夹" /></a>
								</div>
								<div class="payInfo">
									<img src="${imagesRootPath}/icon_Cridcard.gif" /><span><a
										href="javascript:void(0)">支持信用卡付款</a>&nbsp;|&nbsp;<a
										href="javascript:void(0)">支持信用卡付款</a>&nbsp;|&nbsp;<a
										href="javascript:void(0)">支持信用卡付款</a></span>
								</div>
							</div>
						</div>
					</div>
					<div class="production_TabBar">
						<div class="TabHeader">
							<ul>
								<li><a href="#tab_SpecialPackages" class="cur"><span>优惠套装</span></a></li>
								<li><a href="#tab_RecommendProducts"><span>推荐配件</span></a></li>
							</ul>
						</div>
						<div class="TabMainContent">
							<div id="tab_SpecialPackages">
								<div>
									<div class="bundlesList">
										<a href="javascript:void(0)"><img alt="SONY索尼A390L数码单反相机"
											src="${imagesRootPath}/products/large_prod31107_A_100x100.jpg" /></a>
										<div class="Add"></div>
										<a href="javascript:void(0)"><img
											alt="SanDisk 闪迪 8GB MS PRO Duo记忆棒 ￥179.00"
											src="${imagesRootPath}/products/23-c32-000.jpg" /></a> <a
											href="javascript:void(0)"><img
											alt="GGS 金钢 LCD保护膜 日本进口玻材 2.7寸 ￥35.00"
											src="${imagesRootPath}/products/99-c04-008.jpg" /></a> <a
											href="javascript:void(0)"><img
											alt="KATA 卡塔 DC-439 Digital Case 数码单肩包 ￥364.00"
											src="${imagesRootPath}/products/96-c08-062.jpg" /></a>
									</div>
									<div class="bundlesPrice">
										<table>
											<tr>
												<td colspan="2"><h4>套餐一</h4></td>
												<td></td>
											</tr>
											<tr>
												<td>市场价：</td>
												<td class="oldPrice">￥4177.00元</td>
											</tr>
											<tr>
												<td>套装价：</td>
												<td class="newPrice">￥3759.30元</td>
											</tr>
											<tr>
												<td>立即节省：</td>
												<td class="savePrice">￥417.7元</td>
											</tr>
											<tr>
												<td colspan="2"><a href="javascript:void(0)"
													class="Btn_buyBundles"></a></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
							<div id="tab_RecommendProducts" class="itemProductsList"
								style="display: none">
								<ul>
									<li>
										<div class="proImg">
											<img src="${imagesRootPath}/products/17-C04-144.jpg">
										</div> <a href="javascript:void(0)" title="Lenspen 专业镜头笔">Lenspen<br />专业镜头笔
									</a>
										<div>
											特价：<strong>￥39.00</strong>
										</div>
										<div class="addBtns">
											<a href="javascript:void(0)" class="addToCart"></a>
										</div>
									</li>
									<li>
										<div class="proImg">
											<img alt="SanDisk 闪迪 8GB MS PRO Duo记忆棒 ￥179.00"
												src="${imagesRootPath}/products/23-c32-000.jpg" />
										</div> <a href="javascript:void(0)"
										title="SanDisk 闪迪 8GB MS PRO Duo记忆棒">SanDisk 闪迪 8GB MS PRO
											Duo记忆棒 </a>
										<div>
											特价：<strong>￥179.00</strong>
										</div>
										<div class="addBtns">
											<a href="javascript:void(0)" class="addToCart"></a>
										</div>
									</li>
									<li>
										<div class="proImg">
											<img alt="GGS 金钢 LCD保护膜 日本进口玻材 2.7寸 ￥35.00"
												src="${imagesRootPath}/products/99-c04-008.jpg" />
										</div> <a href="javascript:void(0)"
										title="GGS 金钢 LCD保护膜 日本进口玻材 2.7寸 ">GGS 金钢 LCD保护膜 日本进口玻材
											2.7寸 </a>
										<div>
											特价：<strong>￥35.00</strong>
										</div>
										<div class="addBtns">
											<a href="javascript:void(0)" class="addToCart"></a>
										</div>
									</li>
									<li>
										<div class="proImg">
											<img alt="KATA 卡塔 DC-439 Digital Case 数码单肩包 ￥364.00"
												src="${imagesRootPath}/products/96-c08-062.jpg" />
										</div> <a href="javascript:void(0)"
										title=" KATA 卡塔 DC-439 Digital Case 数码单肩包 "> KATA 卡塔
											DC-439 Digital Case 数码单肩包 </a>
										<div>
											特价：<strong>￥364.00</strong>
										</div>
										<div class="addBtns">
											<a href="javascript:void(0)" class="addToCart"></a>
										</div>
									</li>
								</ul>
							</div>
							<div style="clear: both"></div>
						</div>
					</div>
					<div id="product_appendent" class="production_TabBar">
						<div class="TabHeader">
							<ul>
								<li><a title="tab_CommodityDescription" href="##"
									class="cur" onclick="showTab(this)"><span>商品介绍 </span></a></li>
								<li><a title="tab_Details" href="##"
									onclick="showTab(this);"><span>规格参数</span></a></li>
								<li><a title="tab_PackagingInfo" href="##"
									onclick="showTab(this)"><span>包装清单</span></a></li>
								<li><a title="tab_SaleService" href="##"
									onclick="showTab(this)"><span>售后服务</span></a></li>
							</ul>
						</div>
						<div class="TabMainContent">
							<div id="tab_CommodityDescription">
								<!-- jsp:include page="${product.descriptionURL}" flush="true" -->
								<jsp:include page="${jspRootPath}/${product.descriptionURL}" />
							</div>
							<div id="tab_Details" style="display: none">
								<table width="100%" cellspacing="0" cellpadding="0" border="0"
									class="Dtable">
									<tbody>
										<!-- 
										<tr>
											<th class="title" colspan="2">类型</th>
										</tr>
										 -->
										<c:forEach var="richcontent" items="${productRichContentList}">
											<tr>
												<th width="120"><c:out value="${richcontent.RCName}" /></th>
												<td><c:out value="${richcontent.RCValue}" /></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
							<div id="tab_PackagingInfo" style="display: none">
								<table width="100%" cellspacing="0" cellpadding="0" border="0"
									class="Dtable">
									<tbody>
										<tr>
											<th width="120">主机</th>
											<td>x1</td>
										</tr>
										<tr>
											<th>电池</th>
											<td>x1</td>
										</tr>
										<tr>
											<th>充电器</th>
											<td>x1</td>
										</tr>
										<tr>
											<th>腕带</th>
											<td>x1(相机带AN-DC3)</td>
										</tr>
										<tr>
											<th>其它配件</th>
											<td>x1 (铁氧体磁芯（两类）)</td>
										</tr>
										<tr>
											<th>电池</th>
											<td>x1</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div id="tab_SaleService" style="display: none">
								<div class="content">
									<p>厂商保修信息：</p>
									<ul>
										<li>该商品保修期为12个月，零部件保修期为12个月。</li>
										<li>全国联保一年</li>
									</ul>
									<br />
								</div>
							</div>
							<div style="clear: both"></div>
						</div>
					</div>
				</div>
			</div>
			<div style="clear: both"></div>
		</div>
		<div style="clear: both"></div>
	</div>
	<div id="pageFooter">
		<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
	</div>
</body>

<script type="text/javascript">
	var p_id;
	var item_label;

	$(function() {
		p_id = "${product.id}";
		item_label = "${item.itemLabel}";
	});
</script>
</html>
