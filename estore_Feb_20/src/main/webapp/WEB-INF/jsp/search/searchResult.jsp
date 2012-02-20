<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <%--include the global page start page --%>
        <jsp:include page="${jspRootPath}/includes/common/incPageStart.jsp" />
        <title><fmt:message key="canton.homepage.title" /></title>
        <script type="text/javascript" src="${jsRootPath}/lib/countdown.js"></script>
        <script type="text/javascript" src="${jsRootPath}/lib/csonline.js"></script>
        <script type="text/javascript" src="${jsRootPath}/lib/favourites.js"></script>
        <script type="text/javascript" src="${jsRootPath}/lib/cart.js"></script>
        <script type="text/javascript" src="${jsRootPath}/runonce.js"></script>
        <link href="${cssRootPath}/default.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="topbar">
           <jsp:include page="${jspRootPath }/includes/common/incPageTopBar.jsp"/> 
        </div>
        <div id="wrap" class="twoColPage">
            <div id="pageHeader">
                <jsp:include page="${jspRootPath}/homepage/incPageHeader.jsp"/>
            </div>
            <div id="mainContent">
              <div id="twoColContent">
                <div id="twoColLeft">
                    <jsp:include page="${jspRootPath}/search/incSubCatalog.jsp"/>
                    <jsp:include page="${jspRootPath}/search/incBrandCatalog.jsp"/>
                    <jsp:include page="${jspRootPath}/search/incItemCatalog.jsp"/>
                    <div class="ADContainer"><img src="/adimages/ad07_200px.jpg" /></div>
                    <div class="ADContainer"><img src="/adimages/ad03_200px.jpg" /></div>
                    <jsp:include page="${jspRootPath}/search/incBrowseHistoryItems.jsp"/>
                    <div class="ADContainer"><img src="/adimages/ad01_200px.jpg" width="200px"  /></div>
                </div>
                <div id="twoColRight">
                    <div class="crumb"> <a href="javascript:void(0)">首页</a><span>&gt;</span> <em>"数码"</em> </div>
                    <div class="mainProduct">
                        <jsp:include page="${jspRootPath}/search/incSearchInfo.jsp"/>
                        <jsp:include page="${jspRootPath}/search/incRightFilterArea.jsp"/>
                    </div>
                    <div class="controlPanel">
                      <div class="controlList">
                        <div class="showList">
                          <div style="float:left;">显示方式：</div>
                          <div style="float:left;">
                            <ul>
                              <li class="showGrid"><a href="javascript:void(0);" id="topViewGrid" class="cur" title="图片版" onclick="changeView('Grid', 'List')"></a></li>
                              <li class="showRow"><a href="javascript:void(0);" id="topViewList" class="" title="图文版" onclick="changeView('List', 'Grid')"></a></li>
                            </ul>
                          </div>
                        </div>
                        <jsp:include page="${jspRootPath}/search/incPageSize.jsp"/>
                        <div class="orderListP" style="display:none">
                          <div class="orderWay">排列方式：</div>
                          <div class="ListSelect">
                            <select>
                              <option value ="xx">所有分类</option>
                              <option>数码产品</option>
                              <option>饮料食物</option>
                              <option>运动健康</option>
                              <option>个护化妆</option>
                              <option>家用电器</option>
                              <option>全部分类</option>
                            </select>
                          </div>
                        </div>
                        <jsp:include page="${jspRootPath}/search/incPagination.jsp"></jsp:include>
                      </div>
                    </div>
                    <div id="productInfoList" class="RowGrid">
                        <c:forEach items="${searchResult.items}" var="item"> 
                            <div class="Row">
                                <div class="RImg"><a href="###" title="${item.name}"><img src="${imagesRootPath}/${item.imageUrl}" width="120" height="120" alt="${item.name}" /></a></div>
                                <div class="RText"><a href="###" title="${item.name}">${item.name}</a></div>
                                <div class="RPRow">
                                  <div class="OPrice">市场价：<span>￥9899.00</span></div>
                                  <div class="RPrice">特惠价：<span>￥${item.price}</span></div>
                                  <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达五星"><span class="rank5"></span>(20)</a></div>
                                </div>
                                <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="controlPanel">
                      <div class="controlList">
                        <div class="showList">
                          <div style="float:left;">显示方式：</div>
                          <div style="float:left;">
                            <ul>
                              <li class="showGrid"><a href="javascript:void(0);" id="btmViewGrid" class="cur" title="图片版" onclick="changeView('Grid', 'List')"></a></li>
                              <li class="showRow"><a href="javascript:void(0);" id="btmViewList" class="" title="图文版" onclick="changeView('List', 'Grid')"></a></li>
                            </ul>
                          </div>
                        </div>
                        <jsp:include page="${jspRootPath}/search/incPageSize.jsp"/>
                        <div class="orderListP" style="display:none">
                          <div class="orderWay">排列方式：</div>
                          <div class="ListSelect">
                            <select>
                              <option value ="xx">所有分类</option>
                              <option>数码产品</option>
                              <option>饮料食物</option>
                              <option>运动健康</option>
                              <option>个护化妆</option>
                              <option>家用电器</option>
                              <option>全部分类</option>
                            </select>
                          </div>
                        </div>
                        <jsp:include page="${jspRootPath}/search/incPagination.jsp"></jsp:include>
                      </div>
                    </div>
                  </div>
                  <div style="clear:both"></div>
                </div>
                <div style="clear:both"></div>
              </div>
              <div style="clear:both"></div>
            </div>
        </div>
      	<%--include the page footer --%>
    	<jsp:include page="${jspRootPath}/includes/common/incPageFooter.jsp" />
    </body>
</html>
