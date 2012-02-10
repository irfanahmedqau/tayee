jQuery.fn.countdown = function(h,m,s){
  var h = h;//.toString().replace(/^(\d{1})$/,'0$1');
  var m = m;//.toString().replace(/^(\d{1})$/,'0$1');
  var s = s;//.toString().replace(/^(\d{1})$/,'0$1');
  var self = this;
  var ch,cm,cs;
  
  var render = function(){
    self.html('<div class="wmCountdown">剩余<span class="ch__">'+h+'</span>小时<span class="cm__">'+m+'</span>分钟<span class="cs__">'+s+'</span>秒</div>');
    ch = $('.ch__', self);
    cm = $('.cm__', self);
    cs = $('.cs__', self);
    
    var ch_v = parseInt(ch.html());
    var cm_v = parseInt(cm.html());
    var cs_v = parseInt(cs.html());
    
    var cdt = setInterval(function(){
      
      cs_v = cs_v-1;
      cs.html(cs_v);//.toString().replace(/^(\d{1})$/,'0$1'));
      if(cs_v==-1){
        cm_v = cm_v-1;
        cm.html(cm_v);//.toString().replace(/^(\d{1})$/,'0$1'));
        cs_v = 59;
        cs.html(cs_v);
      }
      if(cm_v==-1){
        ch_v = ch_v-1;
        ch.html(ch_v);//.toString().replace(/^(\d{1})$/,'0$1'));
        cm_v = 59;
        cm.html(cm_v);
      }
      
      
      
      if(ch_v == 0 && cm_v == 0 && cs_v ==0){
        clearTimeout(cdt);
        self.fadeOut(function(){self.remove();});
      }
      
      
    }, 1000);
    
  }
  
  render();
}



