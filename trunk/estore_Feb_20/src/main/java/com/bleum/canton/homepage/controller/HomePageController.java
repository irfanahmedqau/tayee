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
 */
package com.bleum.canton.homepage.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.service.IItempageService;


/**
 * @author charles.wang
 * @created Feb 7, 2012 10:00:46 AM
 * Description: the controller which can render the homepage view
 */

@Controller
public class HomePageController {
    
    private static final Logger logger=LoggerFactory.getLogger(HomePageController.class);
    
    private static final String HOME_VIEW_PAGE="index";
    
    @Autowired
    private IItempageService itempageServiceImpl;
    
    @RequestMapping(method=RequestMethod.GET, value="/index")
    public ModelAndView homePage (HttpServletRequest request){
        
       
        
        ModelAndView result = new ModelAndView();
        
        //add the object itempageService which can be used in any place of page
        //so any page can use request.getParameter() to get the reference of this object
        result.addObject("itempageService", itempageServiceImpl);
     
        result.setViewName(HOME_VIEW_PAGE);
        return result;
       
        
    }
    
    

}
