$(function(){
  
  try{
  SL_OBJ = document.getElementById('slcon');
  SL_OBJ_TIMER = 0;
  SL_OBJ_HOVER = 0;
  
  var stll = document.getElementById('storeLocatorLink');
  stll.onmousedown = function(){
    SL_OBJ.style.position = '';
    SL_OBJ.style.top = '';
    SL_OBJ.style.left = '';
    clearTimeout(SL_OBJ_TIMER); 
    SL_OBJ_TIMER = 0;
    SL_OBJ.style.display = '';
  }
  document.getElementsByTagName('body')[0].onmousedown = function(){
    if(SL_OBJ_HOVER == 0)
    SL_OBJ_TIMER = setTimeout(function(){SL_OBJ.style.display='none'; },100);
  }
  stll.onmouseover = SL_OBJ.onmouseover = function(){
    SL_OBJ_HOVER = 1;
  }
  stll.onmouseout = SL_OBJ.onmouseout = function(){
    SL_OBJ_HOVER = 0;
  }
  document.getElementById('sfclose').onmousedown = function(){
    SL_OBJ_TIMER = setTimeout(function(){SL_OBJ.style.display='none'; },100);
  }
  
  var stlogo = $('.stlogo');
  var laststlogo = stlogo[0];
  var stprovcon = $('#slcon .con .province').html('<a href="javascript:void(0)" class="sel"></a>');
  var stcitycon = $('#slcon .con .city').html('<a href="javascript:void(0)" class="sel"></a>');
  var ststorecon = $('#slcon .con .store').html('');
  
  stLoadProvince = function(s){
    ststorecon.html('')
    stprovcon.html('<a href="javascript:void(0)" class="sel"></a>');
    stcitycon.html('<a href="javascript:void(0)" class="sel"></a>');
    $(STORE_DAT[s]).each(function(i,o){
      for(p in o){
        stprovcon.append('<a href="javascript:void(0)" class="prov" onclick="loadStCity(\''+s+'\', \''+p+'\')">'+p+'</a>');
      }
    })
  }
  
  stLoadProvince('walmart');
  
  loadStCity = function(s,q){
    ststorecon.html('')
    stcitycon.html('<a href="javascript:void(0)" class="sel"></a>');
    $('.sel', stprovcon).html(q);
    var con = stcitycon;
    $(STORE_DAT[s]).each(function(i,o){
      for(p in o){
        if(p==q){
          $(o[p]).each(function(j,k){
            for(m in k){
              con.append('<a href="javascript:void(0)" class="ac" onclick="loadStores(\''+s+'\', \''+p+'\', \''+m+'\')">'+m+'</a>')
            }
          })
        }
      }
    })
  }
  
  var lastSelectedStore = 0;
  
  loadStores = function(s,q,r){
    var con = ststorecon;
    ststorecon.html('')
    $('.sel', stcitycon).html(r);
    $(STORE_DAT[s]).each(function(i,o){
      for(p in o){
        if(p==q){
          $(o[p]).each(function(j,k){
            for(m in k){
              if(r==m){
                for(var u=0; u<k[m].length; u++){
                  var itm = k[m][u].split('|');
                  con.append('<div class="sfstore"><div class="sfstname">'+itm[0]+'</div><div class="sfstaddr">'+itm[1]+'</div><div>'+itm[2].replace(/\//,'<br/>')+'</div></div>');
                }
              }
            }
          })
        }
      }
    })
    //
    $('.sfstore', con).mouseover(function(){$(this).addClass('sfsthover')}).mouseout(function(){$(this).removeClass('sfsthover')}).mousedown(function(){
      alert('{\nstoreName: "'+ $('.sfstname', this).html() +'",\nstoreAddress:"'+ $('.sfstaddr', this).html() + '"\n}');
      if(lastSelectedStore){lastSelectedStore.removeClass('sfstselected')}
      lastSelectedStore = $(this).addClass('sfstselected');
    })
  }
  
  stlogo.each(function(i,o){
    $(o).click(function(){$(laststlogo).removeClass('current'); laststlogo = $(this).addClass('current')})
  })
  }catch(e){}
  var store_province_html = '<option>请选择省份</option>';
  
  for(p in DISTRICTS_DAT){
    if(/\d\d0000/.test(p))
    store_province_html += '<option value="'+p+'">'+DISTRICTS_DAT[p][0]+'</option>';
  }
  
  $('#store_province').html(store_province_html);
  
  var sff = 0;
  if(/MSIE/.test(navigator.userAgent)){
    sff = 8;
  }

  loadCity = function(o){
    $('#storeLocator').show().animate({
      height: 198+sff
    }, 500, function() {
      // Animation complete.
    });
    
    var p = o.options[o.selectedIndex].value.replace(/(\d\d)0000/,'$1');
    var h = '<option>请选择城市</option>';
    
    for(c in DISTRICTS_DAT){
      if(c.replace(/(\d{2})(\d{4})/, '$1')==p && (/(\d{4})00/.test(c)) && c.replace(/(\d\d)0000/,'$1')!=p)
      h += '<option value="'+c+'">'+DISTRICTS_DAT[c][0]+'</option>';
    }
    $('#store_city').html(h);
    
  }
  
  loadDistrict = function(o){
    $('#storeLocator').show().animate({
      height: 228+sff
    }, 500, function() {
      // Animation complete.
    });
    
    var p = o.options[o.selectedIndex].value.replace(/(\d{4})00/,'$1');
    var h = '<option>请选择城区</option>';
    
    for(c in DISTRICTS_DAT){
      if(c.replace(/(\d{4})(\d{2})/, '$1')==p && c.replace(/(\d{4})00/,'$1')!=p)
      h += '<option value="'+c+'">'+DISTRICTS_DAT[c][0]+'</option>';
    }
    $('#store_district').html(h);
  }
  
  loadStore = function(){
    $('#store_info').fadeIn()
    $('#storeLocator').animate({
      height: 383+sff
    }, 500, function() {
      // Animation complete.
    });
  }
  
  
  $('#mainContentRightCountdown_0 .newcountdown_0').countdown(0,0,5);
  $('#mainContentRightCountdown_1 .newcountdown_0').countdown(2,23,27);
  $('#mainContentRightCountdown_2 .newcountdown_0').countdown(3,41,10);
  
  if(/MSIE/.test(navigator.userAgent)){
    $('#siteCategories ul li').each(function(i,o){
      $(o).mouseover(function(){$(o).addClass('hover')})
        .mouseout(function(){$(o).removeClass('hover')})
    })
  }
  
  
  var tabContents = $('.tabContentContainer .tabcontent');
  var lasttabcontent = $(tabContents[0]);
  var tabs = $('.tabgroupTabs a');
  var lasttab = $(tabs[0]);
  
  tabs.each(function(i,o){
    $(o).mouseover(function(){lasttabcontent.hide(); lasttabcontent = $(tabContents[i]).show(); lasttab.removeClass('cur'); lasttab = $(o).addClass('cur'); })
  })
  
  
  var flipTimer = "";
  var hoverTimer = "";
  $("#mainContentPOV li").mouseover(function(e){
    clearTimeout(flipTimer);
    var cindex = $("#mainContentPOV li").index($(this));
    $("#mainContentPOV li").each(function(index){
      index != cindex ? $(this).removeClass("cur") : $(this).addClass("cur");
    });
    clearTimeout(hoverTimer);
    hoverTimer = setTimeout(function(){
      $("#mainContentPOV .povpic a").each(function(index){
        index != cindex ? $(this).fadeOut() : $(this).fadeIn(function(){
          clearTimeout(flipTimer);
          flipTimer = setTimeout(function(){rotate($("#mainContentPOV li.cur").next());},2000);
        });
      });
    },200);
  });
  
  
	flipTimer = setTimeout(function(){rotate($("#mainContentPOV li.cur").next());},2000);
  var rotate = function(obj){
    obj.length != 0 ? obj.mouseover() : $("#mainContentPOV li:first").mouseover();
  }

  var naTimer = null;
  function scrollArrivals(){
    if(document.getElementById('arrivals')){
       naTimer= setInterval(function(){
        var height = parseInt($("#arrivals ul li").css("height").replace(/px/,''));
        $("#arrivals ul:eq(1)").animate({marginTop: '0px'}, 1000);
        $("#arrivals ul:eq(0)").animate({marginTop: '-'+height+'px'}, 1000, function(){
          $(this).before($(this).next()).css("margin-top","0px");
        });
      }, 6000);
    }
  }
  scrollArrivals();
  $('#arrivals').mouseover(function(){
    if (naTimer != null){
      clearInterval(naTimer);
    }
  }).mouseout(function(){
    scrollArrivals();
  });
  
  
  
  var fixFlag = true;
  window.onscroll = function(){
    if (fixFlag){
      $(document).scrollTop() >= 50 ? $("div.flowBar").show() : $("div.flowBar").hide();
    }
  }
  $(".closeBtn").click(function(){
    $("div.flowBar").hide();
    fixFlag = false;
    return false;
  });
  //12/20/2010,edit by Sandro to change the implement of the chat.
  //$(".cs").csonline();	//the original codes
  $('.cs').click(function(){
	  window.open('https://admin.instantservice.com/links/7520/46096','custclient','width=600;height=324;scrollbars=0');
	  return false;
  });
  
  $("#arrivals li").favourite('favFolder');
  $(".cateProd li").favourite('favFolder');
//  $('div.TabHeader').each(function(){
//    var divTab = $(this);
//    $('li a', divTab).click(function(obj){
//      $('li a', divTab).removeClass('cur');
//      $(this).addClass('cur');
//      $($(this).attr('href')).show().siblings().hide();
//      return false;
//    })
//  });
  $('div.TabHeader a').click(function(){var ts = new Date();
      $(this).addClass('cur').parent().siblings().children().removeClass('cur');
      $($(this).attr('href')).show().siblings().hide();
      return false;
  });
  $('div.itemSelect a').click(function(){var ts = new Date();
      var li = $(this).addClass('selected').parent();
      li.siblings().children().removeClass('selected');
      return false;
  });
  $('.storeInfo').each(function(){
    var _self = $('div', this);
    var ddTimer = '';
    $('div, dl', this).hover(function(){
      clearTimeout(ddTimer);
      _self.next().show();
    },function(){
      ddTimer = setTimeout(function(){
        _self.next().hide();
      }, 500);
    });
    $('dd a', this).click(function(){
      _self.html($(this).html()).next().hide();
      return false;
    });
  });

  if(typeof ITEMPAGE != 'undefined'){
    var arindex = 0;
    var ob = $('.itemMoveList li');
    if (ob.length != 0){
      var uw = ob[0].offsetWidth;
      var minL = 6;
      var maxL = ob.length;
      var rcont = true;
      var lcont = false;
      $('.rightArrow').click(function(){
        lcont = true;
        if(arindex < maxL && rcont){
          if(maxL-arindex == minL +1){
              rcont = false;
          }
          $('.itemMoveList li:eq('+arindex+++')').animate({'margin-left' : '-='+uw+'px'}, 'slow');
        }
      });
      $('.leftArrow').click(function(){
        rcont = true;
        if(arindex >= 0 && lcont){
          if(arindex == 0){
              lcont = false;
          }else{
            $('.itemMoveList li:eq('+--arindex+')').animate({'margin-left' : '+='+uw+'px'}, 'slow');  
          }
        }
      });
      $('.itemMoveList li').click(function(){
        $(this).addClass('current').siblings().removeClass('current');
        var m = this;
        setTimeout(function(){$('#prodimgLarge').attr('src', $('img', m).attr('largeSrc'));},0)
      });
    }
  }

  var Cart = new cart('addToCart');
  
  var lastBank = null;
  $('li', 'div.co_cardWrap').click(function(){
    if(lastBank != null){
      lastBank.removeClass('current');
    }
    lastBank = $('label', this).addClass('current');
  });
  var defaultKeyword = $('#topSearch').val();
  $('#topSearch').focusin(function(){
    if($(this).val() == defaultKeyword){
      $(this).removeClass('defaultKey').val('');
    }
  }).focusout(function(){
    if($(this).val() == ''){
      $(this).addClass('defaultKey').val(defaultKeyword);
    }
  });

  $('.expandBtn').click(function(){
    $(this).toggleClass('shrink').parent().next().slideToggle(100);
  });
  changeView = function(to,from){
    $('#topView'+to)[0].className = 'cur';
    $('#btmView'+to)[0].className = 'cur';
    $('#topView'+from)[0].className = '';
    $('#btmView'+from)[0].className = '';
    $('#productInfoList')[0].className = 'Row'+to;
  }

try{
  var reqUrl = "http://jshu-linux.corp.walmart.com:8889/typeahead/searcher";
  try{
    $("#topSearch").autocomplete({
      source: function( request, response ) {
          $.ajax({
            type: "GET",
            url: reqUrl,
            data: {
              'q': $("#topSearch").val()
            },
            success: function( data ) {
              response( $.map( data.results, function( item ) {
                return {
                  label: item.KEYWORD,
                  value: item.KEYWORD
                }
              }));
            }
          });
        }
    });
  }catch(e){
  }
  }catch(e){}

  //top flyout nav
  var tfoTimer = null;
  var lastTopDiv = null;
  $('#topNavigation li ').mouseover(function(){
    var li = $(this);
    if($('div', li).length > 0){
      clearTimeout(tfoTimer);
      if (lastTopDiv){ lastTopDiv.hide(); }            
      lastTopDiv = $('>div', li).show();
    }
  }).mouseout(function(){
    var li = $(this);
    if($('div', li).length > 0){
      tfoTimer = setTimeout(function(){
        $('>div', li).hide();
      }, 10);
    }
  });
  var flag = true;
  var oldPrice = '';
  var selectTd = null;
  $('.DState td').click(function(){
    var _self = $(this);
    if(flag && !_self.hasClass('checked') && !_self.hasClass('gray')&& !_self.hasClass('dateTime')){
      flag = false;
      tempPrice = _self.html();
      _self.text('检查中').addClass('loading');
      setTimeout(function(){
        if (selectTd){
          selectTd.removeClass('checked');
          if (oldPrice != ''){
            selectTd.html(oldPrice);
          }
        }
        selectTd = _self.removeClass('loading').addClass('checked').text('可用').css('cursor','default');
        oldPrice = tempPrice;
        flag = true;
      }, 1500);
      /*$.ajax({
        type: "GET",
        url: '/checkAvailable',
        data: {
          'date': $(this)[0].id
        },
        success: function( data ) {
          if (selectTd){
            selectTd.removeClass('checked');
            if (oldPrice != ''){
              selectTd.html(oldPrice);
            }
          }
          selectTd = _self.removeClass('loading').addClass('checked').text('可用').css('cursor','default');
          oldPrice = tempPrice;
          flag = true;
        }
      });*/
    }
  });
})

