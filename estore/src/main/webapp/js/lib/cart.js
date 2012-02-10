var cart = function(handlerID){
  var _self = this;
  var miniCart = $('<div id="miniCart"><div class="miniCartHeader"><a href="javascript:void(0)" class="miniClose"><div style="width:60px; height:20px; overflow:hidden; background:url(/images/walmartSprite.gif) -14px -502px no-repeat"></div></a></div><div class="miniCartBody"></div><div class="subTotal">当前购物车为空</div><div class="miniCartFooter"><a href="javascript:void(0)">查看完整购物车</a>&nbsp;<img src="/images/chkoutnow.gif" align="absmiddle" style="margin:0 3px 3px 0; cursor:pointer" /></div></div>');
  var itemTem = $('<div class="miniItem"><div class="miniImg"></div><div class="miniDetail"></div></div>');
  var subTotal = $('<div class="subTotal">当前购物车为空</div>');
  var totalDes = '您当前购买的商品总和为：￥';
  var timer = null;
  var clickCloseFlag = false;
  this.show = function(){
    clearTimeout(timer);
    miniCart.slideDown();
//    timer = setTimeout(function(){
//      _self.hide();
//    },6000);
  };
  this.hide = function(){
    miniCart.slideUp();
  };
  function render(){
    miniCart.css('right', '151px').appendTo('body');
    $('#miniCart .subTotal').css('text-align','center');
    $('#miniCart .miniCartFooter').hide();
  };
  this.addItem = function(ITEM){
    if($('#prod_'+ITEM.id).length != 0){
      $('#prod_'+ITEM.id+'_num').html(parseInt($('#prod_'+ITEM.id+'_num').html())+1);
    }else{
      var itemClone = itemTem.clone().attr('id', 'prod_'+ITEM.id);
      $('.miniImg', itemClone).append('<img src="'+ITEM.url+'" />');
      $('.miniDetail', itemClone).append('<a href="###">'+ITEM.name+'</a><br>单价：<span class="perItemPrice">'+ITEM.price+'</span>').append('<div>数量：<span id="'+itemClone.attr('id')+'_num">1</span></div>');
      $('.miniCartBody').append(itemClone);
    }
    $('.subTotal').html(totalDes + calcTotal());
    $('.prodsNum').html(parseInt($('.prodsNum').html()) + 1);
    _self.show();
    if($('.miniItem').length>0){
      $('#miniCart .subTotal').css('text-align','right');
      $('#miniCart .miniCartFooter').show();
    }else{
      $('#miniCart .subTotal').css('text-align','center');
      $('#miniCart .miniCartFooter').hide();
    }
  };
  function calcTotal(){
    var price = parseFloat(0);
    $('.perItemPrice').each(function(){
      price += parseFloat($(this).html()) * parseInt($(this).next().children('span').html());
    });
    return price.toFixed(2);
  };
  this.setHandler = function(id){
    $('#'+id).click(function(){
      _self.addItem(ITEM[Math.round(Math.random()*10)]);
    }).mouseover(function(){
      clickCloseFlag = false;
    }).mouseout(function(){
      clickCloseFlag = true;
    });
  };
  miniCart.mouseover(function(){
    clickCloseFlag = false;
    clearTimeout(timer);
  }).mouseout(function(){
    clickCloseFlag = true;
  });

  _self.setHandler(handlerID);
  render();
  $('.miniClose').click(function(){
    _self.hide();
  });
  $('body').mousedown(function(){
    if(clickCloseFlag){
      _self.hide();
      clickCloseFlag = false;
    }
  });
  $('.myMiniCart').click(function(){
    _self.show();
  });
}