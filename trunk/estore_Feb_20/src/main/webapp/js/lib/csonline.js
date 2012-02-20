jQuery.fn.csonline = function(obj){
  var words = ['系统：连线中……请稍候……<br />', 
                  '系统：伺服器连接成功！<br />',
                  '系统：客服2334号为您服务！<br />',
                  '客服2334号：中午好，请问有什么可以帮到您吗？<br />'];
  var cswin = {};
  var talkArea = $("<div id='talkArea'></div>");
  var chatArea = $("<textarea id='chatArea' name='' class='' ></textarea>");
  var sendBt = $("<button id='sendBt'>Send</button>");
  var container = $('<div id="csContainer"><div class="title">沃尔玛网店在线客服</div><a href="javascript:void(0)" onclick="$(\'#csContainer\').hide()" style="float:right; margin-top:-18px; margin-right:3px;">退出客服</a></div>').append(talkArea).append(chatArea);
  var moveFlag = false;
  var x, y;
  
  this.click(function(){
    if(document.getElementById('csContainer')){$('#csContainer').show(); return}
    container.css("right",'151px').appendTo($("#wrap"));
    var ta = $('#talkArea');
    $('#chatArea').focus().keydown(function(evt){if(evt.keyCode==13){ta.append('我：'+this.value+'<br />'); }}).keyup(function(evt){if(evt.keyCode==13){this.value=''}});
    setTimeout(function(){ta.append(words[0])},1000);
    setTimeout(function(){ta.append(words[1])},5000);
    setTimeout(function(){ta.append(words[2])},7000);
    setTimeout(function(){ta.append(words[3])},9000);
    return false;
  });

}



