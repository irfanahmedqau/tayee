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
 * 
 * the javascript code will handle the float advertisement in the homepage
 */

 $(document).ready(function(){
  var tabContents = $('.tabContentContainer .tabcontent');
  var lasttabcontent = $(tabContents[0]);
  var tabs = $('.tabgroupTabs a');
  var lasttab = $(tabs[0]);
  
  tabs.each(function(i,o){
    $(o).mouseover(function(){
    	lasttabcontent.hide();
    	lasttabcontent = $(tabContents[i]).show();
    	lasttab.removeClass('cur'); 
    	lasttab = $(o).addClass('cur'); 
    })
  });
  
  
 });
  