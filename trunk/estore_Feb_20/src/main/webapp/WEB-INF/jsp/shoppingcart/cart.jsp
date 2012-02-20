<%-- shopping cart main page--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--include the global page start page --%>
<jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" /> 
<title><fmt:message key="canton.homepage.title" /></title>
<%--JS --%>
<script language="javascript" type="text/javascript">
function checkout(){
	document.getElementById("triggerForm").submit();
}

function emptycart(){
	document.getElementById("removeAllForm").submit();
}
</script>
</head>
<body>
<%--include the top bar --%>
<div id="topbar">
	<jsp:include page="${jspRootPath }/includes/common/incPageTopBar.jsp"/> 
</div>

<%--include the page header --%>
<div id="wrap">
	<jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp"/>
</div>
<%--main content of cart page --%>
<div id="mainContent">
<div class="shlefcrumb"> <a href="${contextPath}/ ">首页</a><span>&gt;</span> <em>我的购物车</em></div>
    <div class="checkoutModule">
      <div class="CartPageWidth">
      <div class="block">
        <div class="CartRow">
         <table class="CartList"  cellpadding="0" cellspacing="0">
           <thead>
             <tr>
             <th class="leftLine" width="100">商品编号 </th>
             <th >&nbsp;</th>
             <th class="price">价格</th>
             <th class="price">数量</th>
             <th class="price" width="150">操作</th>
             <th class="rightLine" width="10">&nbsp;</th>
             </tr>
           </thead>
           <tbody>
            <%-- iterate the items in cart--%>
            <c:if test="${empty itemList}">
                 	购物车为空
            </c:if>
            <c:forEach items="${itemList}" var="cartItem" varStatus="s">
             <tr>
             	<td class="leftLine"><a href="javascript:void(0)"><img src="/images/carProduct_img1.jpg" alt="图片" /></a></td>
             	<td class="">
                   <div class="CartItemInfor">
                     <a href="javascript:void(0)">${cartItem.itemId} -- ${cartItem.itemName}</a>
                   </div>  
                </td>
				<td class="price">${cartItem.item.price}</td>
                <td class="price">
                  <label>
                   <input name="textfield" type="text" id="textfield" value="${cartItem.quantity}">
                  </label>
                  <label>
                  	${cartItem.quantity}
                  </label>
                 </td>
                <td class="price"><a href="javascript:void(0)">更新</a></td>
			<!--  	<td class="price"><a href="javascript:void(0)">删除</a></td> -->
                <td class="rightLine">&nbsp;</td>
             </tr>
            </c:forEach>

            <%-- summary --%>
             <tr class="grayBody">
                <td class="leftLine bottomLine" colspan="5">
                    <table class="noline">
                      <tr>
                        <td width="60">总计</td>
                        <td width="100" class="tolPrice">￥<span>${totalPrice}</span></td>
                      </tr>
                    </table>
                    <div class="links">
                      <a href="javascript:void(0)">发货细节</a> │ <a href="javascript:void(0)">退换货准则</a>
                    </div>
                </td>
                <td class="rightLine bottomLine" width="10">&nbsp;</td>
             </tr>            
           </tbody>
         </table>
          
        </div>
        <div class="CartButton">
          <div class="CartBTNRight">
          <a href="javascript:checkout()"><img src="${imagesRootPath}/btn_checkout.gif" /></a>
          </div>
          <div class="CartBTNLeft">
          <a href="${contextPath}/"><img src="${imagesRootPath}/btn_continueshopping.gif" /></a>
          <a href="javascript:emptycart()"><img src="${imagesRootPath}/btn_emptycart.gif" /></a>
          </div>
        </div>
        <div>
        <form id="triggerForm" name="triggerForm"  action="${contextPath}/checkOutTrigger" method="POST">
           <input type="hidden" name="customerID" id="customerID" value="111111"/>
           <input type="hidden" name="itemList" id="itemList" value="1#2#3"/>
        </form>
         <form id="removeAllForm" name="removeAllForm"  action="${contextPath}/shoppingcart/removeAll" method="POST" >
         </form>
   
        </div>
      </div>
      </div>
    </div>
        
</div>

<%--include the page footer --%>
<div id="footer">
	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
</div>

</body>
</html>