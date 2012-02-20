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
    <div id="slcon" style="display:none; ">
      <div class="brands">
        <div class="stlogo current" onclick="stLoadProvince('walmart')"><img src="/images/logo_supercenter.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('samsclub')"><img src="/images/logo_sams.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('neighborhood')"><img src="/images/logo_comm.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('discount')"><img src="/images/logo_huixuan.gif" /></div>
        <div class="stlogo" onclick="stLoadProvince('supermarket')"><img src="/images/logo_huixuanmart.gif" /></div>
      </div>
      <div class="con">
        <div class="province"></div>
        <div class="city"></div>
        <div class="store"></div>
      </div>
    </div>
  </div>
  <div class="flowBar"> <a href="javascript:void(0)"  class="whiteText favFolder">收藏夹</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText cs"><span class="onLineService"></span>在线客服</a>&nbsp;│&nbsp;<a href="javascript:void(0)" class="whiteText myMiniCart"><span class="myCart"></span>我的购物车(<span class="prodsNum">0</span>)</a><a href="javascript:void(0)" class="closeBtn"></a> </div>
</div>
<div id="wrap" class="twoColPage">
  <div id="pageHeader">
        <div style="padding:10px 0 0 0"><a href="/homepage.html"><img src="/images/logo.gif" /></a></div>
    <div style="position:absolute; margin:-60px 0 0 360px;">
      <div class="navSearchWrap">
        <div class="navSeachPart">
          <div class="searchPanel">
            <div class="panelLBg"><img src="/images/seachArea_Bg_L.gif" /></div>
            <div class="panelM">
              <div class="keyInfoInput"><label for="topSearch"><input type="text" value="搜索" class="defaultKey" name="topSearch" maxlength="50" autocomplete="off" id="topSearch"/></label></div>
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
              <div class="searchButton"><a href="javascript:void(0)"><img src="/images/seachArea_btn.gif" border="0" /></a></div>
            </div>
            <div class="panelRBg"><img src="/images/seachArea_Bg_R.gif" /></div>
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
    <div class="shlefcrumb">
      <a href="javascript:void(0)">首页</a><span>&gt;</span>
      <em>订单提交成功</em>
      
      
    </div>
    <div class="checkoutModule">
      <div class="co_success">
        <div class="co_successInfo">
          <h1>成功！</h1>
          <p>您的订单号是：<a href="#">12345678</a>，您可以点击订单号查看详情,或在<a href="#">我的沃尔玛</a>搜索相关订单信息。</p>
          <p style="text-align:center"><a href=""><img src="images/zhifubao_btn.png" /></a></p>
        </div>
      </div>
      <div class="CartRecommend adPart">
          <div class="CartRecommendHeader">
            <div class="CartRecomLeft"></div>
            <div class="CartRecomCenter">根据您购物车的商品，我们为您做以下推荐：</div>
            <div class="CartRecomright"></div>
          </div>
          <div class="CartRecomContent">
            <div class="CartRecomRow">
<div class="CartRecomItem">
                <div class="CartRecomInfor"><a href="javascript:void(0)" title="NAGA 纳伽 CD10 撒哈拉银(GS)摄影包 D3000/D5000/450D/550D/500D等"><img src="/images/products/cart_01.jpg" alt="NAGA 纳伽 CD10 撒哈拉银(GS)摄影包D3000/D5000/450D/550D/500D等"></a></div>
                <div class="CartRecomText"> <a href="javascript:void(0)" title="NAGA 纳伽 CD10 撒哈拉银(GS)摄影包D3000/D5000/450D/550D/500D等">NAGA 纳伽 CD10 撒哈拉银(GS)摄影包&nbsp;<font class="CartItemNotice">D3000/D5000/450D/550D/500D等</font></a> </div>
                <div class="CartItemPrice"><span>优惠价:</span>
                  ￥298.00
                </div>
                <a href="javascript:void(0);" title="加入购物车">
                  <div class="Add2Cart">加入购物车</div>
                </a>
              </div>
              <div class="CartRecomItem" >
                <div class="CartRecomInfor"><a href="javascript:void(0)" title="FUJIFILM 富士 FinePix AV105 黑色 1220万像素 3倍光变 数码相机可以摄像1280*720视频!性价比强机!"><img src="images/products/cart_02.jpg" alt="FUJIFILM 富士 FinePix AV105 黑色 1220万像素 3倍光变 数码相机可以摄像1280*720视频!性价比强机!"></a></div>
                <div class="CartRecomText"> <a href="javascript:void(0)" title="FUJIFILM 富士 FinePix AV105 黑色 1220万像素 3倍光变 数码相机可以摄像1280*720视频!性价比强机!">FUJIFILM 富士 FinePix AV105 黑色 1220万像素 3倍光变 数码相机&nbsp;<font class="CartItemNotice">可以摄像1280*720视频!性价比强机!</font></a> </div>
                <div class="CartItemPrice"><span>优惠价:</span>
                  ￥485.00
                </div>
                <a href="javascript:void(0);" title="加入购物车"><span>
                  <div class="Add2Cart">加入购物车</div>
                  </span></a>
              </div>
              <div class="CartRecomItem">
                <div class="CartRecomInfor"><a href="javascript:void(0)" title="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"><img src="images/products/cart_03.jpg" alt="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"></a></div>
                <div class="CartRecomText"> <a href="javascript:void(0)" title="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包">NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包&nbsp;</a> </div>
                <div class="CartItemPrice"><span>优惠价:</span>
                  ￥168.00
                </div>
                <a href="javascript:void(0);" title="加入购物车">
                  <div class="Add2Cart">加入购物车
                  </div></a>
              </div>
                            <div class="CartRecomItem">
                <div class="CartRecomInfor"><a href="javascript:void(0)" title="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"><img src="images/products/cart_04.jpg" alt="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"></a></div>
                <div class="CartRecomText"> <a href="javascript:void(0)" title="SLIK 竖力 三脚架云台套装 SPRINT 150+SBH-150DQ仕必得系列(铝合金)">SLIK 竖力 三脚架云台套装 SPRINT 150+SBH-150DQ&nbsp;<div class="CartItemNotice">仕必得系列(铝合金)</div></a></div>
                <div class="CartItemPrice"><span>优惠价:</span>
                  ￥168.00
                </div>
                <a href="javascript:void(0);" title="加入购物车">
                  <div class="Add2Cart">加入购物车
                  </div></a>
              </div>
                            <div class="CartRecomItem">
                <div class="CartRecomInfor"><a href="javascript:void(0)" title="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"><img src="images/products/cart_05.jpg" alt="NATIONAL GEOGRAPHIC 国家地理 NG 1150 数码相机包"></a></div>
                <div class="CartRecomText"> <a href="javascript:void(0)" title="炭之语 竹炭电视枕 蓝色赠竹炭眼罩">炭之语 竹炭电视枕 蓝色&nbsp;<div class="CartItemNotice">赠竹炭眼罩</div></a> </div>
                <div class="CartItemPrice"><span>优惠价:</span>
                  ￥168.00
                </div>
                <a href="javascript:void(0);" title="加入购物车">
                  <div class="Add2Cart">加入购物车
                  </div></a>
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