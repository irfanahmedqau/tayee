jQuery.fn.favourite = function(des){
  var moutTimer = [];
  var _self = this;
  this.append('<div class="atfBt"><img src="/images/addfav.gif" /></div>').hover(function(){
    $('div.atfBt', this).show();
  },function(){
    $('div.atfBt', this).hide();
  });
  $("div.atfBt", this).click(function(){
    var offset = $(this).offset();
    var left = offset.left -100;
    var top = offset.top -100;
    _self.prepend('<div class="flyDiv" style="left:'+left+'px; top: '+top+'px"></div>');
    var flyDivs = $(".flyDiv");
    var desLeft = $('.'+des).offset().left;
    var lpiece = (desLeft + 0 - left )/50;
    var tpiece = (top - $(document).scrollTop())/50;
    var i = 1;
    var interval = setInterval(function(){
      flyDivs.css('left', flyDivs.offset().left + lpiece).css('top', flyDivs.offset().top - tpiece).width(flyDivs.width()*0.95*i).height(flyDivs.height()*0.95*i).css('opacity', parseFloat(flyDivs.css('opacity'))*0.9);
      //i = i - 0.001;
      if(flyDivs.width() <= 20){
        $('.favFolder').css('background','#fff').css('color','#000');
        setTimeout(function(){$('.favFolder').css('background','none').css('color','#fff')},500);
        flyDivs.remove();
        clearInterval(interval);
      }
    }, 10);
    return false;
  });
  

}



