<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>沃尔玛网店</title>
	<jsp:include page="${jspRootPath}/includes/global/incScript.jsp" />
	<script type="text/javascript" src="${jsRootPath}/lib/datepicker/jquery-ui-1.8.7.custom.min.js"></script>
	<link href="${jsRootPath}/lib/datepicker/jquery-ui-1.8.7.custom.css" rel="stylesheet" type="text/css">
	<link href="${cssRootPath}/default.css" rel="stylesheet" type="text/css">
	<!--[if lt IE 7]>
	<link href="${cssRootPath}/default_ie.css" rel="stylesheet" type="text/css">
	<![endif]-->
	<!--[if IE 7]>
	<link href="${cssRootPath}/default_ie.css" rel="stylesheet" type="text/css">
	<![endif]-->
	<link rel="stylesheet" href="${cssRootPath}/checkout/checkout.css">

	<script>
		$(function () {
			$('#startDate').datepicker({ minDate:0});
		});
		function addNewAddress(t){
			$(".addressArea").find("table").each(function(){
				$(this).toggle(0);
			});
			$("#newAddress").hide();
			$("#phone").val("");
			$("#street").val("");
			$("#zipcode").val("");
			
		}
		function saveAddress(){
			var  regx=/^\d{6}$/;
			var zipcode = $("#zipcode").val();
			var r =new RegExp(/\d{3}-\d{8}|\d{4}-\d{7}/); 
			var r2 = new RegExp(/^\d{11}$/); 
			var phone =$("#phone").val();
			if(!regx.test(zipcode)){
				$("#msg_zipcode").html("邮编格式不正确");
			if(phone = ""||(!r.exec(phone)&&!r2.exec(phone))) {
				$("#msg_phone").html("固定电话或手机格式不正确");
				return;
			}
			return;
			}else if(phone = ""||(!r.exec(phone)&&!r2.exec(phone))) {
				$("#msg_phone").html("固定电话或手机格式不正确");
				return;
			}
			$(".addressArea").find("table").each(function(){
				$(this).toggle(0);
			});
			var url="${contextPath}/saveAccountInfo";
			//prpare the data for the addresss
			//ajax post to the server
			$.post(
			url, 
			{province : $("#province").val(),city:$("#area").val(),street:$("#street").val(),
				zipcode:$("#zipcode").val(),phone: $("#phone").val() ,checkOutID:"${checkOutID}" },
			function (data, textStatus){
				if(data.status=="success"){
					$("#addressCard").val(data.addressCard);
				}
				//init the show message on the addressCard
			}, "json");
			$("#td_city").html($("#city").find("option:selected").text());
			$("#td_area").html($("#area").find("option:selected").text());
			$("#td_detail").html($("#street").val());
			$("#td_zipcode").html($("#zipcode").val());
			$("#td_phone").html($("#phone").val());
			$("#newAddress").show();
			
		}
		function updateAddress(){
			$(".addressArea").find("table").each(function(){
				$(this).toggle(0);
			});
			$("#city option").attr("selected","selected");
			$("#street").val($("#td_detail").html());
			$("#zipcode").val($("#td_zipcode").html());
			$("#phone").val($("#td_phone").html());
			$("#newAddress").hide();
		}
		function undoAddress(){
			$(".addressArea").find("table").each(function(){
				$(this).toggle(0);
			});
			$("#newAddress").show();
		}
		
		function modifyPaymentMethod(){
			$("#paymentTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			$(".NCO-payList ul li input").each(function(){
				$(this).attr("disabled","");
			});
		}
		function savePaymentMethod(){
			$("#paymentTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			
			var url="${contextPath}/savePaymentMethod";
			var payType = $("input[name='payType']:checked").val();
			//prpare the data for the addresss
			//ajax post to the server
			$.post(
			url, 
			{payType : payType , checkOutID:"${checkOutID}"},
			function (data, textStatus){
				if(data.status=="success"){
					$("#paymentMethodId").val(data.paymentMethodId);
				}
				//init the show message on the addressCard
			}, "json");
			
			$(".NCO-paymentInfo .NCO-payList ul li input").each(function(){
				$(this).attr("disabled","disabled");
			});
		}
		function saveInvoiceInfo(){
			$("#invoiceTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			var url="${contextPath}/saveInvoiceInfo";
			var invoiceName = $("input[name='invoiceNameOption']:checked").val();
			var invoiceType = $("input[name='invoiceTypeOption']:checked").val();
			var invoiceContent = $("input[name='invoiceContentOption']:checked").val();
			
			//prpare the data for the addresss
			//ajax post to the server
			$.post(
			url, 
			{invoiceName : invoiceName,invoiceType: invoiceType,invoiceContent: invoiceContent ,checkOutID:"${checkOutID}"},
			function (data, textStatus){
				if(data.status=="success"){
					$("#invoiceId").val(data.invoiceId);
				}
				//init the show message on the addressCard
			}, "json");
			$(".subform table tr td input").each(function(){
				$(this).attr("disabled","disabled");
			});
		}
		function modifyInvoiceInfo(){
			$("#invoiceTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			$(".subform table tr td input").each(function(){
				$(this).attr("disabled","");
			});
		}
		function saveShippingMethod(){
			if($("#startDate").val()==""){
				$("#msg_startDate").html("不能为空");
				return;
			}
			$("#shippingTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			var url="${contextPath}/saveShippingMethod";
			var shippingExpectDate = $("input[name='shippingOption']:checked").val();
			//prpare the data for the addresss
			//ajax post to the server
			$.post(
			url, 
			{shippingExpectDate : shippingExpectDate,shippingExactDate:$("#startDate").val(),
				shippingDetailTime:$("#detailTime").val(),checkOutID:"${checkOutID}"},
			function (data, textStatus){
				if(data.status=="success"){
					$("#shippingMethodId").val(data.shippingMethodId);
				}
				//init the show message on the addressCard
			}, "json");
			
			$("#shipForm ul li input").each(function(){
				$(this).attr("disabled","disabled");
			});
			$("#shipForm input").each(function(){
				$(this).attr("disabled","disabled");
			});
			$("#shipForm select").each(function(){
				$(this).attr("disabled","disabled");
			});
		}
		function modifyShippingMethod(){
			$("#shippingTitle").find("span").each(function(){
				$(this).toggle(0);
			});
			$("#shipForm ul li input").each(function(){
				$(this).attr("disabled","");
			});
			$("#shipForm input").each(function(){
				$(this).attr("disabled","");
			});
			$("#shipForm select").each(function(){
				$(this).attr("disabled","");
			});
		}
		function completeCheckOut(){
			var url = "${contextPath}/isInfoCompleted";
			$.post(
					url, 
					{checkOutID:"${checkOutID}"},
					function (data, textStatus){
						if(data.status=="success"){
							$("#submitForm").submit();
						}else{
							alert(data.message);
						}
						//init the show message on the addressCard
					}, "json");
		}
	</script>
</head>
<body>
<div id="wrap" class="twoColPage">
	<div id="mainContent">
		<div class="orderStep">
			<div class="stepLogo"></div>
			<div class="stepNow step2"></div>
			<div class="divideLine"></div>
		</div>
		<div class="NCO-container">
			<div class="NCO-content">
				<div class="NCO-section">
					<h2>
						<spring:message code="checkout.shippingaddress.tile"/>&nbsp;&nbsp;&nbsp;&nbsp; 
						<span><a href="javascript:addNewAddress()" id="newAddress"><spring:message code="checkout.shippingaddress.add"/></a></span>
					</h2>
					<h3><spring:message code="checkout.shippingaddress.storage"/></h3>
					<label for="savedAddr"><spring:message code="checkout.shippingaddress.choose"/></label>
					<select id="savedAddr">
						<option>凯旋北路1555弄（大华清水湾花园）117号101室（默认地址）</option>
						<option>浦东南路1038弄112号2002室</option>
					</select>
					<div id="addressAreaShow" class="addressArea">
						<h3>凯旋北路1555弄（大华清水湾花园）117号101室</h3>
						<table width="100%">
							<tr>
								<td style="width: 100px"><spring:message code="checkout.shippingaddress.province"/></td>
								<td id="td_city">上海市</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.area"/></td>
								<td id="td_area">普陀区</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.street"/></td>
								<td id="td_detail">凯旋北路1555弄（大华清水湾花园）117号101室</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.zipcode"/></td>
								<td id="td_zipcode">200052</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.phone"/></td>
								<td id="td_phone">139199888888</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.operate"/></td>
								<td><a href="javascript:updateAddress()"><spring:message code="checkout.shippingaddress.edit"/></a></td>
							</tr>
						</table>
						<table width="100%" style="display: none">
							<tr>
								<td style="width: 100px"><spring:message code="checkout.shippingaddress.province"/></td>
								<td>
									<select id="province" >
										<option value="SHANGHAI" selected="selected">上海</option>
										<option value="BEIJING">北京</option>
									</select>
									<select id="city" >
										<option value="SHANGHAI" selected="selected">上海</option>
										<option value="BEIJING">北京</option>
									</select>
									<select id="area" >
										<option value="changning"selected="selected">长宁区</option>
										<option value="jinan">静安区</option>
										<option value="putuo">普陀区</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.street"/></td>
								<td><input type="text" id="street" value="" style="width: 300px;"/></td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.zipcode"/></td>
								<td><input type="text" id="zipcode" value="" style="width: 150px;" onclick="$('#msg_zipcode').html('');"/>
								<span id="msg_zipcode" style="color: red"></span>
								</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.phone"/></td>
								<td><input type="text" id="phone" value="" style="width: 150px;" onclick="$('#msg_phone').html('');"/>
								<span id="msg_phone" style="color: red"></span>
								</td>
							</tr>
							<tr>
								<td><spring:message code="checkout.shippingaddress.operate"/></td>
								<td><a href="javascript:saveAddress()"><spring:message code="checkout.shippingaddress.save"/>
								</a>&nbsp;<a href="javascript:undoAddress()"><spring:message code="checkout.shippingaddress.cancel"/></a></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="NCO-section">
					<h2 id="shippingTitle"><spring:message code="checkout.shippingmethod.demand"/>&nbsp;&nbsp;&nbsp;&nbsp; 
						<span style="display:none"><a href="javascript:modifyShippingMethod()"><spring:message code="checkout.shippingmethod.modify"/></a></span>
						<span><a href="javascript:saveShippingMethod()"><spring:message code="checkout.shippingmethod.save"/></a></span></h2>
					<div id="shipForm" class="subform">
						<ul class="optgroup" id="expectDate">
							<li>
								<input id="sevenDay" name="shippingOption" type="radio" checked="checked" value="seven">
								<span class="sevenDayIcon"></span>
								<label for="sevenDay"><spring:message code="checkout.shippingmethod.in.sevenday"/></label>
							</li>
							<li>
								<input id="twoDay" type="radio" name="shippingOption" value="two">
								<span class="twoDayIcon"></span>
								<label for="twoDay"><spring:message code="checkout.shippingmethod.in.twoday"/></label>
							</li>
							<li>
								<input id="oneDay" type="radio" name="shippingOption" value="one">
								<span class="oneDayIcon"></span>
								<label for="oneDay"><spring:message code="checkout.shippingmethod.in.oneday"/></label>
							</li>
						</ul>
					</div>
					<div id="shipForm" class="subform">
							<p style="float:left;margin-right:5px;"><spring:message code="checkout.shippingmethod.shippingdate"/></p>
							<input type="text" class="calendar dashboard" name="startDate" id="startDate" readonly="" onclick="$('#msg_startDate').html('');">
							<span id="msg_startDate" style="color: red"></span>
							<br/>
							<spring:message code="checkout.shippingmethod.shipping.detailtime"/>
							<select style="width:140px;" id="detailTime">
								<option><spring:message code="checkout.shippingmethod.detailtime.8am-10am"/></option>
								<option><spring:message code="checkout.shippingmethod.detailtime.11am-13pm"/></option>
								<option><spring:message code="checkout.shippingmethod.detailtime.14pm-16pm"/></option>
								<option><spring:message code="checkout.shippingmethod.detailtime.17pm-19pm"/></option>
								<option><spring:message code="checkout.shippingmethod.detailtime.20pm-21pm"/></option>
							</select>
					</div>
				</div>
				<div class="NCO-section">
					<h2 id="paymentTitle">
						<spring:message code="checkout.paymentmethod.paymentconfirm"/> &nbsp;&nbsp;&nbsp;&nbsp; 
						<span style="display:none"><a href="javascript:modifyPaymentMethod()"><spring:message code="checkout.paymentmethod.modify"/></a></span>
						<span><a href="javascript:savePaymentMethod()"><spring:message code="checkout.paymentmethod.save"/></a></span>
					</h2>
					<div class="NCO-paymentInfo">
						<div class="NCO-info-title"><spring:message code="checkout.paymentmethod.choose"/></div>
						<div class="NCO-payList">
							<ul>
								<li>
									<input type="radio" value="ALIPAY" id="p3" name="payType" checked="checked"/>
									<label class="iconbox" for="p3"> <span title="<spring:message code="checkout.paymentmethod.alipay"/>" class="icon zfb"></span>
									</label>
								</li>
								<li>
									<input type="radio" value="COD" id="p4" name="payType"/>
									<label class="iconbox" for="p4"> <span title="<spring:message code="checkout.paymentmethod.cod"/>" class="icon mobile"></span>
									</label>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="NCO-section">
					<h2 id="invoiceTitle"><spring:message code="checkout.invoice.info"/>&nbsp;&nbsp;&nbsp;&nbsp; 
						<span style="display:none"><a href="javascript:modifyInvoiceInfo()"><spring:message code="checkout.invoice.modify"/></a></span>
						<span><a href="javascript:saveInvoiceInfo()"><spring:message code="checkout.invoice.save"/></a></span>
					</h2>
					<div class="subform">
						<table style='width:100%;display:'>
				                <tr>
				                    <td style='text-align:right;width:82px;'><spring:message code="checkout.invoice.name"/></td>
				                    <td>
				                    	<form>
				                    	<input type="radio" id="normal" name="invoiceNameOption" value="normal" checked="checked">
				                    	<label for="normal"><spring:message code="checkout.invoice.name.normal"/></label>
				                    	<input type="radio" id="vat" name="invoiceNameOption" value="vat">
				                    	<label for="vat"><spring:message code="checkout.invoice.name.vot"/></label>
				                    	</form>
				                    </td>
				                    <td></td>
				                </tr>
				                <tr>
				                    <td style='text-align:right;'><spring:message code="checkout.invoice.type"/></td>
				                    <td>
				                    	<form>
										<input type="radio" id="person" name="invoiceTypeOption" value="person" checked="checked">
				                    	<label for="person"><spring:message code="checkout.invoice.type.person"/></label>
				                    	<input type="radio" id="company" name="invoiceTypeOption" value="company">
				                    	<label for="company"><spring:message code="checkout.invoice.type.company"/></label>
				                    	</form>
									</td>
				                </tr>
				                 <tr>
				                   <td style='text-align:right;'><spring:message code="checkout.invoice.content"/></td>
				                   <td>
				                   <form>
				                        <input type="radio" id="detail" name="invoiceContentOption" value="detail" checked="checked">
				                    	<label for="detail"><spring:message code="checkout.invoice.content.detail"/></label>
				                    	<input type="radio" id="office" name="invoiceContentOption" value="office">
				                    	<label for="office"><spring:message code="checkout.invoice.content.office"/></label>
				                    </form>
				                   </td>
				                </tr>
				            </table> 
					</div>
				</div>
			</div>
			<div class="NCO-aside">
				<h2><span>订单汇总</span></h2>
				<table cellpadding="0" cellspacing="0" class="content">
					<tr>
						<td class="amount">1</td>
						<td class="detail">
							<ul>
								<li>挂扣领牛津布衬衣</li>
								<li>型号：Small</li>
								<li>颜色：Pink</li>
								<li>商品编号：xsku1262</li>
							</ul>
						</td>
						<td class="price">￥36.80</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" class="summary">
					<tr>
						<td class="label">小计</td>
						<td class="price">￥0</td>
					</tr>
					<tr>
						<td class="label">发货</td>
						<td class="price">￥0</td>
					</tr>
					<tr>
						<td class="label">税额</td>
						<td class="price">￥0</td>
					</tr>
				</table><table class="overall">
					<tr>
						<td class="label">总计</td>
						<td class="price">￥36.80</td>
					</tr>
				</table>
			</div>
			<div class="NCO-overall">
				<h2>订单详细信息</h2>
				<div class="NCO-section">
					<table class="NCO-cartList" cellpadding="0" cellspacing="0">
							<thead>
								<tr>
									<th class="thumb">商品编号</th>
									<th class="detail">&nbsp;</th>
									<th class="price">价格</th>
									<th class="amount">数量</th>
									<th class="sum">总计</th>
								</tr>
							</thead>
							<tbody class="orderItems">
								<tr>
									<td class="thumb">
										<a href="javascript:void(0)"><img src="${imagesRootPath}/carProduct_img1.jpg" alt="拌扣领牛津布衬衣"/></a>
									</td>
									<td class="detail">
										<div class="CartItemInfor">
											<a href="#">拌扣领牛津布衬衣</a>
											<ul>
												<li>型号：Small</li>
												<li>颜色：Pink</li>
												<li>商品编号：xsku1262</li>
											</ul>
										</div>
									</td>
									<td class="price">￥36.80
										<ul>
											<li>（金牌会员8%的折扣）</li>
										</ul>
									</td>
									<td class="amount">1</td>
									<td class="sum">￥36.80
									</td>
								</tr>
							</tbody>
							<tbody class="orderTotal">
								<tr>
									<td class="link" colspan="3"></td>
									<th class="label">小计</th>
									<td class="price">￥36.80</td>
								</tr>
								<tr>
									<td class="link" colspan="3"></td>
									<th class="label">发货</th>
									<td class="price">￥5.95</td>
								</tr>
								<tr>
									<td class="link" colspan="3"></td>
									<th class="label">税额</th>
									<td class="price">￥0</td>
								</tr>
								<tr>
									<td class="link" colspan="3">
										<a href="javascript:void(0)">发货细节</a> │
										<a href="javascript:void(0)">退换货准则</a>
									</td>
									<th class="label">总计</th>
									<td class="price totalPrice">￥<span>42.75</span></td>
								</tr>
							</tbody>
						</table>
				</div>
				<div class="NCO-buttons">
					<div class="left-buttons">
						<a href="javascript:void(0)"><img src="${imagesRootPath}/btn_cancelCart.gif"/></a>
						<a href="javascript:void(0)"><img src="${imagesRootPath}/btn_reEditcart.gif"/></a>
					</div>
					<div class="right-buttons">
					<input type="image" onclick="javascript:completeCheckOut();" 
					src="${imagesRootPath}/chkoutSubmit.gif"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="clear:both"></div>
</div>

<div style="display:none">
	<!-- Here are the hiden form used to submit the resource -->
	<form id="submitForm" name="submitForm" action="${contextPath}/toOms" method="POST">
		<input type="text" value="" id="addressCard" name="addressCard" />
		<input type="text" value="" id="paymentMethodId" name="paymentMethodId" />
		<input type="text" value="" id="invoiceId" name="invoiceId" />
		<input type="text" value="" id="shippingMethodId" name="shippingMethodId" />
	</form>
</div>

<div style="clear:both"></div>
</div>
<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp"/>
</body>
</html>