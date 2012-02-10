<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>沃尔玛网店</title>
	<script type="text/javascript" src="/javascripts/common/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="/javascripts/lib/datepicker/jquery-ui-1.8.7.custom.min.js"></script>
	<script type="text/javascript" src="/javascripts/common/districts.js"></script>
	<script type="text/javascript" src="/javascripts/common/stores.js"></script>
	<script type="text/javascript" src="/javascripts/lib/countdown.js"></script>
	<script type="text/javascript" src="/javascripts/lib/csonline.js"></script>
	<script type="text/javascript" src="/javascripts/lib/favourites.js"></script>
	<script type="text/javascript" src="/javascripts/lib/cart.js"></script>
	<script type="text/javascript" src="/javascripts/runonce.js"></script>
	<link href="${cssRootPath}/default.css" rel="stylesheet" type="text/css">
	<link href="/javascripts/lib/datepicker/jquery-ui-1.8.7.custom.css" rel="stylesheet" type="text/css">
	<!--[if lt IE 7]>
	<link href="/css/default_ie.css" rel="stylesheet" type="text/css">
	<![endif]-->
	<!--[if IE 7]>
	<link href="/css/default_ie.css" rel="stylesheet" type="text/css">
	<![endif]-->
	<link rel="stylesheet" href="${cssRootPath}/checkout/checkout.css">

	<script>
		$(function () {
			$('#startDate').datepicker({ minDate:0});
		});
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
					<h2>送货地址</h2>
					<h3>已保存的有效地址:</h3>
					<label for="savedAddr">选择地址：</label>
					<select id="savedAddr">
						<option>凯旋北路1555弄（大华清水湾花园）117号101室（默认地址）</option>
						<option>浦东南路1038弄112号2002室</option>
					</select>
					<div class="addressArea">
						<h3>凯旋北路1555弄（大华清水湾花园）117号101室</h3>
						<table width="100%">
							<tr>
								<td style="width: 100px">所在省市：</td>
								<td>上海市</td>
							</tr>
							<tr>
								<td>所在地区：</td>
								<td>普陀区</td>
							</tr>
							<tr>
								<td>街道地址：</td>
								<td>凯旋北路1555弄（大华清水湾花园）117号101室</td>
							</tr>
							<tr>
								<td>邮编：</td>
								<td>200052</td>
							</tr>
							<tr>
								<td>电话/手机：</td>
								<td>139199888888</td>
							</tr>
							<tr>
								<td>操作：</td>
								<td><a href="javascript:void(0)">编辑地址</a></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="NCO-section">
					<h2>配送要求</h2>
					<div class="subform">
						<ul class="optgroup">
							<li>
								<input id="sevenDay" name="option" type="radio" checked>
								<span class="sevenDayIcon"></span>
								<label for="sevenDay">预计7个工作日内送</label>
							</li>
							<li>
								<input id="twoDay" type="radio" name="option">
								<span class="twoDayIcon"></span>
								<label for="twoDay">2个工作日内送达（如果在下午三点前确认订单）</label>
							</li>
							<li>
								<input id="oneDay" type="radio" name="option">
								<span class="oneDayIcon"></span>
								<label for="oneDay">次日到达（如果在下午三点前确认订单）</label>
							</li>
						</ul>
					</div>
					<div class="subform">
							<p style="float:left;margin-right:5px;">送货日期</p>
							<input type="text" class="calendar dashboard" name="startDate" id="startDate" readonly=""><br/>
							送货时间
							<select style="width:140px;">
								<option>8:00-10:00</option>
								<option>11:00-13:00</option>
								<option>14:00-16:00</option>
								<option>17:00-19:00</option>
								<option>20:00-21:00</option>
							</select>
					</div>
				</div>
				<div class="NCO-section">
					<h2>支付确认</h2>
					<div class="NCO-paymentInfo">
						<div class="NCO-info-title">选择您的支付方式</div>
						<div class="NCO-payList">
							<ul>
								<li>
									<input type="radio" value="" id="p1" name="payType"/>
									<label class="iconbox" for="p1"> <span title="财付通" class="icon cft"></span>
									</label>
								</li>
								<li>
									<input type="radio" value="" id="p2" name="payType"/>
									<label class="iconbox" for="p2"> <span title="快钱" class="icon qmoney"></span>
									</label>
								</li>
								<li>
									<input type="radio" value="" id="p3" name="payType"/>
									<label class="iconbox" for="p3"> <span title="支付宝" class="icon zfb"></span>
									</label>
								</li>
								<li>
									<input type="radio" value="" id="p4" name="payType"/>
									<label class="iconbox" for="p4"> <span title="手机支付" class="icon mobile"></span>
									</label>
								</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="NCO-section">
					<h2>发票信息 &nbsp;&nbsp; <span><a href="#" onclick="alert('你手贱啊')">[修改]</a></span></h2>
					<div class="subform">
						<table style='width:100%;display:'>
				                <tr>
				                    <td style='text-align:right;width:82px;'>发票类型：</td>
				                    <td>普通发票</td>
				                </tr>
				                <tr>
				                    <td style='text-align:right;'>发票抬头：</td>
				                    <td>个人 </td>
				                </tr>
				                 <tr>
				                   <td style='text-align:right;'>发票内容：</td>
				                   <td>
				                         <div><span style="display:none">非图书商品：</span><span style="display:;">明细</span></div>
				                          <div><span style="display:none">图书商品：</span><span style="display:none;">不开发票</span></div>
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
						<a href="checkout_step5.html"><img src="${imagesRootPath}/chkoutSubmit.gif"/></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="clear:both"></div>
</div>
<div style="clear:both"></div>
</div>
<div id="pageFooter">
	<ul>
		<li class="city-service">
			<h4>沃尔玛保障</h4>
			<span>正品行货</span> <span>先行赔付</span> <span>七天无理由退换货</span> <span>享受国家三包政策</span>
			<a href="javascript:void(0)">“电保包”延展服务 </a></li>
		<li class="new">
			<h4>新手上路</h4>
			<a href="javascript:void(0)" title="">购物车</a> <a href="javascript:void(0)" title="">我的订单</a>
			<a href="javascript:void(0)" title="">导购热线帮助</a></li>
		<li class="pay-way">
			<h4>门店及合作</h4>
			<a href="javascript:void(0)">全国门店地址</a> <a href="javascript:void(0)">信用卡支付</a>
			<a href="javascript:void(0)">货到付款</a> <a href="javascript:void(0)">网上银行支付</a></li>
		<li class="join clearfix">
			<h4>配送方式</h4>
			<a href="javascript:void(0)" title="">使用帮助</a> <a href="javascript:void(0)" title="">支付帮助</a>
			<a href="javascript:void(0)" title="">配送帮助</a></li>
	</ul>
	<div id="copyRight"> 关于我们|联系我们|人才招聘|<br>
		上海市公安局备案编号：2202081681 沪ICP证070359号 <br>
		Copyright&reg;2010 沃尔玛中国 版权所有
	</div>
</div>
</body>
</html>