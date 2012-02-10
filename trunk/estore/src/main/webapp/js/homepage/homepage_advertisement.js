 /* <Bleum Inc. Copyright>
 * Copyright (C) 2011 Walmart Inc.
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement from Bleum Inc..  This notice must be
 * included on all copies, modifications and derivatives of this
 * work.
 *
 * Bleum Inc. MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. Bleum Inc. 
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF 
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * </Bleum Inc. Copyright>
 * 
 * 
 * @author: charles.wang
 * mailto: charles.wang@bleum.com
 * 
 */
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
