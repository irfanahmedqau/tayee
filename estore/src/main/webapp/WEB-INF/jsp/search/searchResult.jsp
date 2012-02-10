<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>沃尔玛网店</title>
<script type="text/javascript" src="${jsRootPath}/common/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${jsRootPath}/common/districts.js"></script>
<script type="text/javascript" src="${jsRootPath}/common/stores.js"></script>
<script type="text/javascript" src="${jsRootPath}/lib/countdown.js"></script>
<script type="text/javascript" src="${jsRootPath}/lib/csonline.js"></script>
<script type="text/javascript" src="${jsRootPath}/lib/favourites.js"></script>
<script type="text/javascript" src="${jsRootPath}/lib/cart.js"></script>
<script type="text/javascript" src="${jsRootPath}/runonce.js"></script>
<link href="${cssRootPath}/default.css" rel="stylesheet" type="text/css">
<!--[if lt IE 7]>
    <link href="/stylesheets/default_ie.css" rel="stylesheet" type="text/css">
    <![endif]-->
<!--[if IE 7]>
    <link href="/stylesheets/default_ie.css" rel="stylesheet" type="text/css">
    <![endif]-->
<script>
  var ITEM = [{
    id: '10001',
    name: '诺基亚手机',
    price: '1999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10002',
    name: '三星手机',
    price: '2999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10003',
    name: '夏普手机',
    price: '3999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10004',
    name: 'Iphone4手机',
    price: '4999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10005',
    name: '索爱手机',
    price: '4999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10006',
    name: '西门子手机',
    price: '5999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10007',
    name: '摩托罗拉手机',
    price: '6999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10008',
    name: '黑莓手机',
    price: '7999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10009',
    name: '很贵的手机',
    price: '8999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  },{
    id: '10010',
    name: '山寨机',
    price: '999.01',
    url: '${imagesRootPath}/products/item_apple.jpg'
  }];
  ITEMPAGE = 1;
  $(function(){
    SITE_CAT_OBJ = document.getElementById('siteCategories');
    SITE_CAT_TIMER = 0;
    SITE_CAT_OBJ.onmouseover = function(){
      clearTimeout(SITE_CAT_TIMER); 
      $(this).removeClass('itempageMainCat'); 
    }
    SITE_CAT_OBJ.onmouseout = function(){
      var s=this; SITE_CAT_TIMER = setTimeout(function(){$(s).addClass('itempageMainCat'); },100);
    }
  });
      
    </script>
</head>
<body>
<div id="topbar">
  <div class="welcomeWord">
    <p>您好,欢迎来到沃尔玛中国！ </p>
    <div class="loginArea"> <a href="javascript:void(0)">登录</a>&nbsp;│&nbsp;<a href="javascript:void(0)">免费注册</a>&nbsp;│&nbsp;<a href="javascript:void(0)">我的沃尔玛</a>&nbsp;│&nbsp;<a href="javascript:void(0)" id="storeLocatorLink">卖场查找</a>&nbsp;│&nbsp;<a href="javascript:void(0)">帮助中心</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText favFolder">收藏夹</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText cs"><span class="onLineService"></span>在线客服</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText myMiniCart"><span class="myCart"></span>我的购物车(<span class="prodsNum">0</span>)</a><a href="javascript:void(0)" class="closeBtn" style="visibility:hidden"></a> </div>
    <div id="slcon" style="position:absolute; top:-10000px; left:-10000px; ">
      <div class="brands">
        <div class="stlogo current" onclick="stLoadProvince('walmart')"><img src="${imagesRootPath}/logo_supercenter.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('samsclub')"><img src="${imagesRootPath}/logo_sams.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('neighborhood')"><img src="${imagesRootPath}/logo_comm.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('discount')"><img src="${imagesRootPath}/logo_huixuan.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('supermarket')"><img src="${imagesRootPath}/logo_huixuanmart.gif" /></div>
      </div>
      <div class="con">
        <div class="province"></div>
        <div class="city"></div>
        <div class="store"></div>
        <div class="gmap">
          <iframe width="453" height="491" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://ditu.google.cn/maps?hl=zh-cn&amp;ie=UTF8&amp;hq=&amp;hnear=%E4%B8%8A%E6%B5%B7%E5%B8%82&amp;brcurrent=3,0x31508e64e5c642c1:0x951daa7c349f366f,1%3B5,0,1&amp;ll=32.175612,108.984375&amp;spn=35.931272,39.726563&amp;z=4&amp;output=embed"></iframe>
          <br />
          <small><a href="http://ditu.google.cn/maps?hl=zh-cn&amp;ie=UTF8&amp;hq=&amp;hnear=%E4%B8%8A%E6%B5%B7%E5%B8%82&amp;brcurrent=3,0x31508e64e5c642c1:0x951daa7c349f366f,1%3B5,0,1&amp;ll=32.175612,108.984375&amp;spn=35.931272,39.726563&amp;z=4&amp;source=embed" style="color:#0000FF;text-align:left">查看大图</a></small></div>
      </div>
    </div>
  </div>
  <div class="flowBar"> <a href="javascript:void(0)"  class="whiteText favFolder">收藏夹</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText cs"><span class="onLineService"></span>在线客服</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText myMiniCart"><span class="myCart"></span>我的购物车(<span class="prodsNum">0</span>)</a><a href="javascript:void(0)" class="closeBtn"></a> </div>
</div>
<div id="wrap" class="twoColPage">
<div id="pageHeader">
  <div style="padding:10px 0 0 0"><a href="/homepage.html"><img src="${imagesRootPath}/logo.gif" /></a></div>
  <div style="position:absolute; margin:-60px 0 0 360px;">
    <div class="navSearchWrap">
      <div class="navSeachPart">
        <div class="searchPanel">
          <div class="panelLBg"><img src="${imagesRootPath}/seachArea_Bg_L.gif" /></div>
          <div class="panelM">
            <div class="keyInfoInput">
              <label for="topSearch">
                <input type="text" value="搜索" class="defaultKey" name="topSearch" maxlength="50" autocomplete="off" id="topSearch"/>
              </label>
            </div>
            <div class="areaSelect">
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
            <div class="searchButton"><a href="javascript:void(0)"><img src="${imagesRootPath}/seachArea_btn.gif" border="0" /></a></div>
          </div>
          <div class="panelRBg"><img src="${imagesRootPath}/seachArea_Bg_R.gif" /></div>
        </div>
        <div class="remindInfo"><a href="javascript:void(0)">高级搜索</a><br />
          <a href="javascript:void(0)">使用帮助</a></div>
      </div>
    </div>
  </div>
  <div id="topNavigation">
    <ul>
      <li><a href="javascript:void(0)" class="current"><span>首页</span></a></li>
      <li><a href="javascript:void(0)"><span>食品饮料</span></a></li>
      <li><a href="javascript:void(0)"><span>家用电器</span></a></li>
      <li><a href="javascript:void(0)"><span>个护美妆</span></a></li>
      <li><a href="javascript:void(0)"><span>家居用品</span></a></li>
      <li><a href="javascript:void(0)"><span>手机数码</span></a></li>
      <li><a href="javascript:void(0)"><span>婴幼系列</span></a></li>
      <li><a href="javascript:void(0)"><span>办公用品</span></a></li>
      <li><a href="javascript:void(0)"><span>文体用品</span></a></li>
      <li><a href="javascript:void(0)"><span>自有品牌</span></a></li>
      <li><a href="javascript:void(0)"><span>全部分类</span></a></li>
      <!--
        <li class="directLink">
          <ul>
            <li><a href="javascript:void(0)" ><span>推荐品牌</span></a></li>
            <li><a href="javascript:void(0)" ><span>限时抢购</span></a></li>
            <li><a href="javascript:void(0)" ><span>专题活动</span></a></li>
          </ul>
        </li>
        -->
    </ul>
  </div>
  <div id="siteCategories" class="section itempageMainCat">
    <h2>全部商品分类<a href="javascript:void(0)"></a></h2>
    <ul>
      <li>
        <h3><a href="javascript:void(0)">食品饮料</a></h3>
        <div class="bar"></div>
        <div class="menu">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">休闲零食</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">薯片</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">肉干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">坚果</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">小食</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">蜜饯</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">海味零食</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">果冻/布丁</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">冲饮茗茶</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">成人奶粉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">麦片</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">茶叶茶包</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">咖啡</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">蜂蜜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">奶茶</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">果珍</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">酒品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">烈酒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">葡萄酒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">啤酒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">香槟</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">乳制品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">进口乳制品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">国产乳制品</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">饮料/水</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">茶饮料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">水</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">碳酸饮料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">凉茶</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">果汁</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">咖啡饮料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">运动/健康饮料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">醋饮料</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">粮油米面</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">米</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">油</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">方便面</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">五谷杂粮</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">面粉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">橄榄油</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">面条/粉丝</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">饼干</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">曲奇饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">苏打饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">甜味/咸味饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">威化饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">夹心饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">糕点</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">调味品/干货</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">炼乳</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">酱料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">调味汁</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">调味粉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">糖</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">干海产</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">菌菇类</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">腌制品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">汤料</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">罐装食品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">其它干货</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">糖果/巧克力</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">巧克力</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">糖果</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">口香糖</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">营养保健</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">保健品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">滋补品</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">进口食品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">进口乳制品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口粮油/米面</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口酒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口糖果/巧克力</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口饼干</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口饮料/水</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口休闲零食</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口调味品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">进口冲饮茗茶</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">健康食品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">有机食品</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">家用电器</a></h3>
        <div class="bar"></div>
        <div class="menu">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">家庭影音</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">平板电视</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">DVD播放机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">家庭影院</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">音响</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">影音附件</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">大家电</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">冰箱</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">洗衣机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">热水器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">酒柜</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">厨房电器</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">电饭煲</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电炖锅</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">豆浆机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">榨汁机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">咖啡机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">燃气灶</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">微波炉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">料理机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电烤箱</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电磁炉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电水壶</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电压力锅</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">吸油烟机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">消毒柜</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">生活电器</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">吸尘器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">熨斗/挂烫机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">饮水机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">加湿器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">灯具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">净水设备</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电动缝纫机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电池/充电器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">其它生活电器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">净化器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">插座</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">个人护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">剃须刀/剃毛器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">按摩器</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电吹风</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电子秤</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">血压计</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">个护美妆</a></h3>
        <div class="bar"></div>
        <div class="menu">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">洗发护发</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">洗发水</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">护发</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">染发</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">定型</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">洗浴用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">沐浴露</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">洗手液</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">香皂</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">沐浴用品</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">脸部护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">精华/乳液</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">面霜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">眼霜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">洁面乳</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">面膜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">柔肤水/爽肤水</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">脸部防晒</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">男士护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">男士洁面乳</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">男士护肤品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">剃须用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">成人保健</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">身体护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">身体乳液</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">精油</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">手部护理</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">脚部护理</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">防晒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">丰胸产品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">其它身体护理</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">女性护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">卫生巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">护垫</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">护理洗液</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">口腔护理</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">牙膏</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">牙刷</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">口腔护理附件</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">儿童牙刷</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">儿童牙膏</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">美容彩妆</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">唇彩</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">甲油</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">眼影</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">粉饼</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">眉笔</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">眼线笔</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">睫毛膏</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">粉底液</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">腮红</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">香水</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">美容工具</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">家居用品</a></h3>
        <div class="bar"></div>
        <div class="menu">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">清洁用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">衣物清洁/护理</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">家居清洁</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">厨房清洁</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">浴厕清洁</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">清洁用具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">驱蚊/驱虫</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">吸湿/防蛀</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">消毒液</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">清洁用纸</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">卫生卷纸</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">抽纸</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">手帕纸</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">湿纸巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">厨房纸巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">商务用纸</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">家具箱包</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">箱包</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">层架</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">客厅家具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">户外家具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">桌椅</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">衣柜</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">收纳洗晒</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">整理箱柜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">洗晒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">压缩收纳袋</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">购物袋</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">烫衣板</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">其它收纳</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">厨房餐饮</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">锅具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">保鲜盒</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">保鲜膜/袋</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">厨房小件</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">餐具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">一次性用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">水具茶具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">烧烤用具</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">床上用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">床品套件</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">枕头</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">床品单件</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">被褥毯子</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">床垫</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">皮革毛草</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">卫浴用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">毛巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">浴巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">儿童毛巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">地垫</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">汽车用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">机油</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">美容/养护</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">香水/去味</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">汽车配件</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">GPS导航</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">宠物用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">狗粮</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">猫粮</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">宠物用具</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">手机数码</a></h3>
        <div class="bar"></div>
        <div class="menu" style="margin-top:100px">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">电脑产品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">笔记本电脑</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">台式电脑</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电脑配件</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">数码影像</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">数码相机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">单反相机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">摄像机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">单反镜头</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">望远镜</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">手机通讯</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">手机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电话机</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">时尚数码</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">电纸书</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">电子辞典</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">收音机/收录机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">录音笔</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">数码配件</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">移动存储</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">刻录碟片</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">耳机/耳麦</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">读卡器</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">婴幼系列</a></h3>
        <div class="bar"></div>
        <div class="menu" style="margin-top:100px">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">婴儿食物</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">婴儿奶粉</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">婴儿加热食品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">即食婴儿食品</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">防尿用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">纸尿裤</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">成长裤</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">洗护用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">婴儿洗护</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">婴儿清洁用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">婴儿湿纸巾</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">婴儿护肤</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">孕妇专区</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">卫生洗护</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">母乳喂养用品</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">喂养用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">奶瓶/奶嘴</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">哺育配件</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">婴儿车座</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">安全座椅/配件</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">办公用品</a></h3>
        <div class="bar"></div>
        <div class="menu" style="margin-top:152px">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">办公用纸</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">复印纸</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">打印纸</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">传真纸</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">办公电器</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">打印机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">一体机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">传真机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">保险柜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">考勤机/点钞机</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">碎纸机</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">办公文具</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">书写用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">文件夹/袋/包/柜</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">桌面用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">学生文具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">财务用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">薄本信封</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">日常用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">办公耗材</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">办公家具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">礼品笔</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">公文包</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">娱乐用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">相册</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
      <li>
        <h3><a href="javascript:void(0)">文体用品</a></h3>
        <div class="bar"></div>
        <div class="menu" style="margin-top:222px; *margin-top:230px; _margin-top:228px; ">
          <div class="SubItem">
            <div>
              <div class="Fore"><a href="javascript:void(0)">体育用品</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">球类用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">户外用品</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">健身器材</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">运动背包</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">自行车及配件</a></nobr></dt>
                </dl>
              </div>
            </div>
            <div>
              <div class="Fore"><a href="javascript:void(0)">玩具系列</a></div>
              <div class="list">
                <dl>
                  <dt><nobr><a href="javascript:void(0)">汽车玩具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">儿童自行车</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">益智玩具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">毛绒玩具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">娃娃玩具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">学步玩具</a></nobr></dt>
                  <dt><nobr><a href="javascript:void(0)">游戏机</a></nobr></dt>
                </dl>
              </div>
            </div>
          </div>
        </div>
      </li>
    </ul>
  </div>
</div>

<div id="mainContent">
  <div id="twoColContent">
    <div id="twoColLeft">
      <div class="subCatalog SRCatalog">
        <h2>搜索结果分类</h2>
        <div class="container">
          <ul>
            <li><a href="javascript:void(0)"><span>3G手机(2)</span></a></li>
            <li><a href="javascript:void(0)"><span>笔记本电脑(23)</span></a></li>
            <li><a href="javascript:void(0)"><span>台式电脑(43)</span></a></li>
            <li><a href="javascript:void(0)"><span>数码配件(2)</span></a></li>
            <li><a href="javascript:void(0)"><span>数码相机(2)</span></a></li>
          </ul>
        </div>
      </div>
      <div class="brandCatalog">
        <h2>品牌推荐</h2>
        <div class="container">
          <ul>
            <li><a href="javascript:void(0)"><b>联想</b></a></li>
            <li><a href="javascript:void(0)"><b>惠普</b></a></li>
            <li><a href="javascript:void(0)"><b>Gateway</b></a></li>
            <li><a href="javascript:void(0)"><b>海信</b></a></li>
            <li><a href="javascript:void(0)"><b>创维</b></b></a></li>
            <li><a href="javascript:void(0)"><b>海尔</b></a></li>
            <li><a href="javascript:void(0)"><b>长虹</b></a></li>
            <li><a href="javascript:void(0)"><b>康宁</b></a></li>
          </ul>
        </div>
      </div>
      <div class="itemCatalog" >
        <h2>推荐产品</h2>
        <div class="container">
          <ul>
            <li><img src="${imagesRootPath}/products/p01_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">磊科 ( Netcore ) 150ML保温杯</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p02_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">索尼（SONY）KLV-37BX20537英寸液晶电视</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p03_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">卡西欧（casio） EX-Z800 数码相机（银色）</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p04_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">曼富图（manfrotto）7322YB隔音耳塞</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p_05_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">美的（Midea） DS12G11 多功能全钢系列 底盘加热 智能醇化 营养不流失网干</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p06_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">志高（chigo）KFR-51GW/D96+N家用冰箱</a></div>
            </li>
          </ul>
        </div>
      </div>
      <div class="ADContainer"><img src="/adimages/ad07_200px.jpg" /></div>
      <div class="ADContainer"><img src="/adimages/ad03_200px.jpg" /></div>
      <div class="browserHistoryGray" >
        <h2>我浏览过的物品</h2>
        <div class="container">
          <ul>
            <li><img src="${imagesRootPath}/products/p01_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">磊科 ( Netcore ) 150ML保温杯</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p02_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">索尼（SONY）KLV-37BX20537英寸液晶电视</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p03_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">卡西欧（casio） EX-Z800 数码相机（银色）</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p04_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">曼富图（manfrotto）7322YB隔音耳塞</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p_05_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">美的（Midea） DS12G11 多功能全钢系列 底盘加热 智能醇化 营养不流失网干</a></div>
            </li>
            <li><img src="${imagesRootPath}/products/p06_45X45.jpg" />
              <div class="itext"><a href="javascript:void(0)">志高（chigo）KFR-51GW/D96+N家用冰箱</a></div>
            </li>
          </ul>
        </div>
      </div>
      <div class="ADContainer"><img src="/adimages/ad01_200px.jpg" width="200px"  /></div>
    </div>
    <div id="twoColRight">
      <div class="crumb"> <a href="javascript:void(0)">首页</a><span>&gt;</span> <em>"数码"</em> </div>
      <div class="mainProduct">
        <div class="searchRInfo">
          <h1>"数码"搜索结果（124条）<span>您是不是在找“<a href=""><b>数码手机</b></a>”、“<a href=""><b>数码电视</b></a>”</span></h1>
          <div class="keyWord">
            <ul>
              <li class="title">相关搜索：</li>
              <li><a href="">数码照相机</a></li>
              <li>|</li>
              <li><a href="">数码MP3</a></li>
              <li>|</li>
              <li><a href="">数码MP3</a></li>
              <li>|</li>
              <li><a href="">数码MP3</a></li>
              <li>|</li>
              <li><a href="">数码MP3</a></li>
              <li>|</li>
              <li><a href="">数码MP3</a></li>
            </ul>
          </div>
        </div>
        <div class="rightFilterArea" style="display:none;">
          <div class="filterHeader"></div>
          <div class="filterContent">
            <div class="allProperty">
              <div class="propList">
                <p style="display:none">总共搜索到 3434 款商品供您选择</p>
                <p>按“</p>
                <div class="closedProperty"><span>苹果</span><a href="javascript:void(0)"></a></div>
                <p>+</p>
                <div class="closedProperty"><span>1000-1999</span><a href="javascript:void(0)"></a></div>
                <p>+</p>
                <div class="closedProperty"><span>32G</span><a href="javascript:void(0)"></a></div>
                <p>+</p>
                <div class="closedProperty"><span>3.0英寸</span><a href="javascript:void(0)"></a></div>
                <p>”</p>
                <p>的条件筛选出 <font color="#ff3300">2188</font> 款商品供您选择</p>
              </div>
              <a href="javascript:void(0)" class="expandBtn">收起筛选器</a> <a href="javascript:void(0)" style="float:right;margin-right:5px;">[取消所有选择]</a> </div>
            <div class="propertyItem">
              <dl>
                <dt>品牌：</dt>
                <dd>
                    <div class="curProperty"><p>苹果</p><a href="javascript:void(0)"></a></div>
                    <a href="javascript:void(0)">飞利浦</a> 
                    <a href="javascript:void(0)">索尼</a> 
                    <a href="javascript:void(0)">爱国者</a> 
                    <a href="javascript:void(0)">台电</a> 
                    <a href="javascript:void(0)">昂达</a> 
                    <a href="javascript:void(0)">驰为</a> 
                    <a href="javascript:void(0)">艾诺</a> 
                    <a href="javascript:void(0)">智器</a> 
                    <a href="javascript:void(0)">纽曼</a> 
                    <a href="javascript:void(0)">OPPO</a> 
                    <a href="javascript:void(0)">酷比魔方</a> 
                    <a href="javascript:void(0)" >歌美</a> 
                    <a href="javascript:void(0)" >佳的美</a> 
                    <a href="javascript:void(0)" >神行者</a> 
                    <a href="javascript:void(0)" >艾利和</a> 
                    <a href="javascript:void(0)" >三星</a> 
                    <a href="javascript:void(0)" >爱欧迪</a> 
                    <a href="javascript:void(0)" >蓝晨</a> 
                    <a href="javascript:void(0)" >长城</a> 
                    <a href="javascript:void(0)" >蓝魔</a> 
                    <a href="javascript:void(0)" >其它</a> 
                 </dd>
              </dl>
              <dl>
                <dt>价格：</dt>
                <dd> 
                  <a href="javascript:void(0)">1-99</a> 
                  <a href="javascript:void(0)">100-299</a> 
                  <a href="javascript:void(0)">300-599</a> 
                  <a href="javascript:void(0)">600-999</a>
                  <div class="curProperty"><p>1000-1999</p><a href="javascript:void(0)"></a></div>
                  <a href="javascript:void(0)">2000以上</a>
                </dd>
              </dl>
              <dl>
                <dt>容量：</dt>
                <dd>
                  <a href="javascript:void(0)">2G</a> 
                  <a href="javascript:void(0)">4G</a> 
                  <a href="javascript:void(0)">8G</a> 
                  <a href="javascript:void(0)">16G</a>
                  <div class="curProperty"><p>32G</p><a href="javascript:void(0)"></a></div>
                  <a href="javascript:void(0)">64G以上</a>
                </dd>
              </dl>
              <dl>
                <dt>屏幕尺寸：</dt>
                <dd>
                  <a href="javascript:void(0)">1.2英寸</a>
                  <a href="javascript:void(0)">1.8英寸</a> 
                  <a href="javascript:void(0)">2.0英寸</a> 
                  <a href="javascript:void(0)">2.4英寸</a> 
                  <a href="javascript:void(0)">2.8英寸</a>
                  <div class="curProperty"><p>3.0英寸</p><a href="javascript:void(0)"></a></div>
                  <a href="javascript:void(0)">3.5英寸</a> 
                  <a href="javascript:void(0)">4.0英寸</a> 
                  <a href="javascript:void(0)">4.3英寸</a> 
                  <a href="javascript:void(0)">5.0英寸</a> 
                  <a href="javascript:void(0)">6.0英寸</a> 
                  <a href="javascript:void(0)">7.0英寸</a> 
                  <a href="javascript:void(0)">8.0英寸</a> 
                  <a href="javascript:void(0)">8.9英寸</a> 
                  <a href="javascript:void(0)">其它</a> 
               </dd>
              </dl>
              <dl>
                <dt>相关配件：</dt>
                <dd>
                  <a href="javascript:void(0)">保护套</a> 
                  <a href="javascript:void(0)">贴膜</a> 
                  <a href="javascript:void(0)">充电器</a> 
                  <a href="javascript:void(0)">移动电源</a> 
                  <a href="javascript:void(0)">支架</a> 
                  <a href="javascript:void(0)">连接线</a> 
                  <a href="javascript:void(0)">耳机</a>
               </dd>
              </dl>
            </div>
          </div>
          <div class="filterFooter"></div>
        </div></div>
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
            <div class="orderAmount">
              <div style="float:left;">显示数量：</div>
              <div style="float:left;">
                <ul>
                  <li class="icon_12"><a href="javascript:void(0);" class="cur" title="12"></a></li>
                  <li class="icon_24"><a href="javascript:void(0);" class="" title="24"></a></li>
                  <li class="icon_36"><a href="javascript:void(0);" class="" title="36"></a></li>
                </ul>
              </div>
            </div>
            <div class="orderListP">
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
            <div class="pagePanel">
              <ul>
                <li><span class="disable">上一页</span></li>
                <li><span class="current">1</span></li>
                <li><a href="">2</a></li>
                <li ><span>...</span></li>
                <li><a href="">30</a></li>
                <li><a href="" class="control">下一页</a></li>
              </ul>
            </div>
            <div class="gotPage">
            <a href="#" title="searchNumber"></a>
              <input type="text" value="" name="" maxlength="30"/>
            </div>
          </div>
        </div>
        <div id="productInfoList" class="RowGrid">
          <div class="Row">
            <div class="RImg"><a href="###" title="苹果（Apple） MacBook Pro MC374CH/A 13.3英寸宽屏笔记本"><img src="${imagesRootPath}/products/macbook.jpg" width="120" height="120" alt="苹果（Apple） MacBook Pro MC374CH/A 13.3英寸宽屏笔记本" /></a></div>
            <div class="RText"><a href="###" title="苹果（Apple） MacBook Pro MC374CH/A 13.3英寸宽屏笔记本">苹果（Apple） MacBook Pro MC374CH/A 13.3英寸宽屏笔记本</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥9899.00</span></div>
              <div class="RPrice">特惠价：<span>￥8889.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达五星"><span class="rank5"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" ><img src="${imagesRootPath}/products/sonycam.jpg" width="100" height="100"  />
              <div class="RProIcon"></div>
              </a></div>
            <div class="RText"><a href="###" title="索尼SONY DSC-HX1数码相机,送4G记忆棒，相机包，遮光罩，3年质保，圣诞特促抓紧时间！！！">索尼(<span>SONY</span>)DSC-HX1数码相机,<span>送4G记忆棒，相机包，遮光罩，3年质保，圣诞特促抓紧时间！！！</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥123599.00</span></div>
              <div class="RPrice">特惠价：<span>￥2589.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达五星"><span class="rank5"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="佳能（Canon） XL H1A 专业数码摄像机"><img src="${imagesRootPath}/products/canon.jpg" width="100" height="100" alt="佳能（Canon） XL H1A 专业数码摄像机时间！！！" /></a></div>
            <div class="RText"><a href="###" title="佳能（Canon） XL H1A 专业数码摄像机">佳能（Canon） XL H1A 专业数码摄像机</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥35329.00</span></div>
              <div class="RPrice">特惠价：<span>￥33399.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达四星"><span class="rank4"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="飞利浦（PHILIPS）SPF4208数码相框"><img src="${imagesRootPath}/products/digitalframe.jpg" width="100" height="100" alt="飞利浦（PHILIPS）SPF4208数码相框" />
              <div class="RProIcon"></div>
              </a></div>
            <div class="RText"><a href="###" title="飞利浦（PHILIPS）SPF4208数码相框">飞利浦（PHILIPS）SPF4208数码相框</a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥1399.00</span></div>
              <div class="RPrice">特惠价：<span>￥749.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达三星"><span class="rank3"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="苹果（APPLE）iPod classic 3代 160G MC293CH/A MP3播放器（银色）超大内"><img src="${imagesRootPath}/products/ipod1.jpg" width="100" height="100" alt="苹果（APPLE）iPod classic 3代 160G MC293CH/A MP3播放器（银色）超大内" /></a></div>
            <div class="RText"><a href="###" title="苹果（APPLE）iPod classic 3代 160G MC293CH/A MP3播放器（银色）">苹果（APPLE）<span>iPod classic 3代 160G MC293CH/A MP3播放器（银色）超大内</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥1999.00</span></div>
              <div class="RPrice">特惠价：<span>￥1848.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达二星"><span class="rank2"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="苹果（Apple）iPod nano 6代 8G MC691CH/A MP3播放器（橘黄色）"><img src="${imagesRootPath}/products/ipod2.jpg" width="100" height="100" alt="苹果（Apple）iPod nano 6代 8G MC691CH/A MP3播放器（橘黄色）" /></a></div>
            <div class="RText"><a href="###" title="苹果（Apple）iPod nano 6代 8G MC691CH/A MP3播放器（橘黄色）">苹果（Apple）<span>iPod</span> nano 6代 8G MC691CH/A MP3播放器（橘黄色）</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥1249.00</span></div>
              <div class="RPrice">特惠价：<span>￥1248.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达一星"><span class="rank1"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="宏碁（Acer）AM1850台式电脑 （E5500 2G 320G DVD 键鼠 Linux）！"><img src="${imagesRootPath}/products/acer1.jpg" width="100" height="100" alt="宏碁（Acer）AM1850台式电脑 （E5500 2G 320G DVD 键鼠 Linux）" /></a></div>
            <div class="RText"><a href="###" title="宏碁（Acer）AM1850台式电脑 （E5500 2G 320G DVD 键鼠 Linux）">宏碁（Acer）AM1850台式电脑<span> （E5500 2G 320G DVD 键鼠 Linux）</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥123599.00</span></div>
              <div class="RPrice">特惠价：<span>￥2589.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="该产品目前还没有用户评价"><span class="rank0"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
          <div class="Row">
            <div class="RImg"><a href="###" title="宏碁（Acer）EL1320台式电脑 （AMD LE1660 1G 320G DVD 键鼠 Linux）"><img src="${imagesRootPath}/products/acer2.jpg" width="100" height="100" alt="宏碁（Acer）EL1320台式电脑 （AMD LE1660 1G 320G DVD 键鼠 Linux）" /></a></div>
            <div class="RText"><a href="###" title="宏碁（Acer）EL1320台式电脑 （AMD LE1660 1G 320G DVD 键鼠 Linux）">宏碁（Acer）EL1320台式电脑 （AMD LE1660 1G 320G DVD 键鼠 Linux）</span></a></div>
            <div class="RPRow">
              <div class="OPrice">市场价：<span>￥2890.00</span></div>
              <div class="RPrice">特惠价：<span>￥2499.00</span></div>
              <div class="RComment"><span>评　论：</span><a href="###" title="用户满意达五星"><span class="rank5"></span>(20)</a></div>
            </div>
            <div class="RBtn"><a href="###"><span class="RBtnMark" title="添加至收藏">收藏</span></a><a href="###"><span class="RBtnBuy" title="添加到购物车">添加到购物车</span></a></div>
          </div>
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
            <div class="orderAmount">
              <div style="float:left;">显示数量：</div>
              <div style="float:left;">
                <ul>
                  <li class="icon_12"><a href="javascript:void(0);" class="cur" title="图片版"></a></li>
                  <li class="icon_24"><a href="javascript:void(0);" class="" title="图文版"></a></li>
                  <li class="icon_36"><a href="javascript:void(0);" class="" title="图文版"></a></li>
                </ul>
              </div>
            </div>
            <div class="orderListP">
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
            <div class="pagePanel">
              <ul>
                <li><span class="disable">上一页</span></li>
                <li><span class="current">1</span></li>
                <li><a href="">2</a></li>
                <li ><span>...</span></li>
                <li><a href="">30</a></li>
                <li><a href="" class="control">下一页</a></li>
              </ul>
            </div>
            <div class="gotPage">
            <a href="#" title="searchNumber"></a>
              <input type="text" value="" name="" maxlength="30"/>
            </div>
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
<div id="pageFooter">
  <ul>
    <li class="city-service">
      <h4>沃尔玛保障</h4>
      <span>正品行货</span> <span>先行赔付</span> <span>七天无理由退换货</span> <span>享受国家三包政策</span> <a href="javascript:void(0)">“电保包”延展服务 </a> </li>
    <li class="new">
      <h4>新手上路</h4>
      <a href="javascript:void(0)" title="">购物车</a> <a href="javascript:void(0)" title="">我的订单</a> <a href="javascript:void(0)" title="">导购热线帮助</a> </li>
    <li class="pay-way">
      <h4>门店及合作</h4>
      <a href="javascript:void(0)">全国门店地址</a> <a href="javascript:void(0)">信用卡支付</a> <a href="javascript:void(0)">货到付款</a> <a href="javascript:void(0)">网上银行支付</a> </li>
    <li class="join clearfix">
      <h4>配送方式</h4>
      <a href="javascript:void(0)" title="">使用帮助</a> <a href="javascript:void(0)" title="">支付帮助</a> <a href="javascript:void(0)" title="">配送帮助</a> </li>
  </ul>
  <div id="copyRight"> 关于我们|联系我们|人才招聘|<br>
    上海市公安局备案编号：2202081681  沪ICP证070359号 <br>
    Copyright&reg;2010  沃尔玛中国 版权所有 </div>
</div>
</body>
</html>
