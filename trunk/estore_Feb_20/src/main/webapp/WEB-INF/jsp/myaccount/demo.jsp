<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="易迅网" />
<meta name="keywords" content="笔记本电脑" />
<link href="${cssRootPath}/myaccount/header_full.css" rel="stylesheet"
	type="text/css" />
<link href="${cssRootPath}/myaccount/package_v1.css" rel="stylesheet"
	type="text/css" />
<link href="${cssRootPath}/myaccount/mycenter.css" rel="stylesheet"
	type="text/css" />
<jsp:include page="${jspRootPath}/includes/global/incScript.jsp" />
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
<script type="text/javascript"
	src="${jsRootPath}/myaccount/myaccount_homeaddr.js"></script>
<title>收货地址管理 - 我的Canton - Canton网</title>
</head>
<body>
	<div id="topbar">
		<jsp:include page="${jspRootPath }/includes/common/incPageTopBar.jsp" />
	</div>

	<%--include the home page header --%>
	<div id="wrap">
		<jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp" />
	</div>
	<div class="main layout_row3" id="container">
		<div class="crumbs">
			<a href="">首页</a> &gt; <a href="">我的Canton</a> &gt; 收货地址管理
		</div>
		<div class="i_content wrap_mycenter">
			<!-- 二级页内容 s -->
			<div class="mod_kong id_mod_receive">
				<div class="mod_hd">
					<h3>收货信息管理</h3>
				</div>
				<div class="mod_bd" id="mod_receive">
					<table class="table_biao id_table_nobor">
						<colgroup>
							<col class="col1">
							<col class="col2">
							<col class="col4">
							<col class="col5">
						</colgroup>
						<thead>
							<tr>
								<th class="left">地址类型</th>
								<th class="left">地址</th>
								<th colspan="3" class="center">操作</th>
							</tr>
						</thead>
						<tbody id="address_list">
							<c:forEach var="address" items="${allHomeAddresses}"
								varStatus="status">

								<tr>
									<td class="left">地址类型</td>
									<td class="left break">
										<div class="other_info">
											<p>收货人：${address.contact} 联系电话：${address.mobilePhone} &nbsp;${address.linePhone}</p>
											<p>详细地址:${address.detailAddress}</p>
										</div>
									</td>
									<td>
										<div class="other_info center">
											<p class="wrap_btn">
												<a href="javascript:modify('${address.id}')">修改</a>
											</p>
										</div>
									</td>
									<td>
										<div class="other_info center">
											<p class="wrap_btn">
												<a href="${contextPath}/deleteHomeAddress?id=${address.id}">删除</a>
											</p>
										</div>
									</td>
							</c:forEach>
						</tbody>
						<tbody class="add_adress">
							<tr>
								<td colspan="5"><a class="btn_common" id="bt_add"
									onclick="new_homeaddress()">增加新收货地址</a></td>
							</tr>

							<form:form id="homeaddr_form"
								action="${contextPath}/addHomeAddress" method="post"
								modelAttribute="HomeAddrForm">
								<tr id="form_hidden" style="display: none">
									<td colspan="5">
										<ul class="list_info">
											<li><span class="tit">地址标注</span> <input type="text"
												name="workplace" class="input_mini" value="" /> <span
												class="nor">例如家里、公司，最多4个汉字或者8个字母。</span></li>
											<li><span class="tit"><span class="strong">*</span>选择地区</span>
												<form:select id="country" path="countryId"
													onchange="selectedCountry()" onclick="getAllCountries()">
													<option>please select</option>
												</form:select> <form:select style="diaplay:none" id="province"
													path="provinceId" onchange="selectedProvice()">
													<option>please select</option>
												</form:select> <form:select style="diaplay:none" id="city" path="cityId"
													onchange="selectedCity()">
													<option>please select</option>
												</form:select> <form:select style="diaplay:none" id="district"
													path="districtId" onchange="selectedDistrict()">
													<option>please select</option>
												</form:select> 
												<form:errors path="countryId" cssClass="error" />
												<span class="interval" id="region_error"></span></li>

											<li><span class="tit"><span class="strong">*</span>详细地址</span>

												<form:input class="input_long" id="detailAddress"
													path="detailAddress" onblur="checkHomeAddress()"/>
													<form:errors path="detailAddress" cssClass="error" />
													<span id="detailAddress_error"></span>
													
													
											<li><span class="tit"><span class="strong">
												</span>邮政编码</span> <form:input class="input_short" path="zipCode" />
												<form:errors  path="zipCode" cssClass="error" />
												<span id="zipCode_error"></span>
												</li>
											<li><span class="tit"><span class="strong">*</span>收&nbsp;&nbsp;货&nbsp;&nbsp;人</span>
												<form:input class="input_short" path="contact" />
												<form:errors id="contact" path="contact" cssClass="error" />
												<span id="contact_error"></span>
												
												</li>
											<li><span class="tit"><span class="strong">*</span>手&nbsp;&nbsp;机</span>
												<form:input id="mobilePhone" class="input_short" path="mobilePhone" />或 固定电话<form:input
												id="linePhone"	class="input_short" path="linePhone" /><span  class="nor">两者至少填写一项</span>
												<form:errors id="linePhone" path="linePhone" cssClass="error" />
												<form:errors id="mobilePhone" path="mobilePhone" cssClass="error" />
									
												</li>
											<li>
												<div class="wrap_btn">
													<form:hidden id="homeaddr_id" path="id" />
													<form:errors  path="id" cssClass="error" />
													<input type="button" class="btn_common" value="save" onclick="checkform()">
													<a type="button" onclick="cancle()">cancle</a>
												</div>
											</li>
										</ul>
									</td>
								</tr>
							</form:form>

						</tbody>
					</table>
				</div>
			</div>
			<!-- 二级页内容 e -->
		</div>

		<div id="address_list_tpl" style="display: none">
			<!--
	<@list@><tr aid="{aid}">
		<td class="left">{workplace}</td>
		<td class="left break">
			<div class="other_info">
				<p>收货人：{name} 联系电话：{mobile} {phone}</p>
				<p>{district_chn} {address}</p>
			</div>
		</td>
		<td>
			<div class="other_info center"><p class="wrap_btn"><a href="#" onclick="G.app.mycenter.address.editArea.edit('{aid}');return false">修改</a></p></div>
		</td>
		<td>
			<div class="other_info center"><p class="wrap_btn"><a href="#" onclick="G.app.mycenter.address.remove('{aid}');return false">删除</a></p></div>
		</td>
	</tr><@_list@>
-->
		</div>
		<div class="i_sidebar">
			<div class="wrap_menu">
				<dl class="mod_menu">
					<dt class="mod_hd">
						<h3>交易管理</h3>
					</dt>
					<dd class="mod_bd">
						<ul class="list_menu">
							<li><a href="">我的订单</a></li>
							<li><a href="">我的收藏</a></li>
							<li><a href="">我的优惠券</a></li>
							<li><a href="">我的到货通知</a></li>
							<li><a href="">我的积分</a></li>
							<li><a href="">我的站内信</a></li>
							<li><a href="">我的反馈</a></li>
							<li><a href="">我的咨询</a></li>
							<li><a href="">我的价格举报</a></li>
							<li><a href="">我的装机配置</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="mod_menu">
					<dt class="mod_hd">
						<h3>售后管理</h3>
					</dt>
					<dd class="mod_bd">
						<ul class="list_menu">
							<li><a href=""
								target="_blank">在线报修申请</a></li>
							<li><a href="">我的在线报修</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="mod_menu">
					<dt class="mod_hd">
						<h3>资料管理</h3>
					</dt>
					<dd class="mod_bd">
						<ul class="list_menu">
							<li><a href="">个人资料</a></li>
							<li class="status_hover"><a
								href="">收货信息</a></li>
							<li><a href="">登录密码</a></li>
							<li><a href="">邮件订阅</a></li>
						</ul>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
	</div>
</body>
</html>
