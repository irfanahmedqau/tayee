/* <Bleum Inc. Copyright>
 * Copyright (C) 2011 Bleum Inc.
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement from Bleum Inc..  This notice must be
 * included on all copies, modifications and derivatives of this
 * work.
 *
 * Bleum Inc. MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. Belum Inc. 
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF 
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * </Bleum Inc. Copyright>
 * */

package com.bleum.canton.ca.category.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.ca.category.entity.Category;
import com.bleum.canton.ca.category.service.ICategoryManagementService;
import com.bleum.canton.util.json.ExtJsonResponse;

/**
 * @author Wayne.Zhong
 * @created Feb 13, 2012 12:15:25 PM
 */
@Controller
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    
    @Resource(name= "categoryManagementService")
    private ICategoryManagementService categoryManagementService;
    
    private static final String CATEGORY_HOME_PAGE = "main";
    
         
    @RequestMapping(value= "/main", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest request){
        logger.debug("load homepage...");
        ModelAndView mav = new ModelAndView(CATEGORY_HOME_PAGE);
        return mav;
    }
    
    @RequestMapping(value= "/loadingCategory", method = RequestMethod.GET)
    @ResponseBody
    public ExtJsonResponse <Category> loadingCategory2(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "node") String node){
        logger.debug("LoadingCategory");
        logger.debug("[selectNode]: " + node);
        
        List <Category> categoryList = categoryManagementService.findCategoriesByParentId(node);
        ExtJsonResponse <Category> jsonResponse = new ExtJsonResponse<Category>();
        if (categoryList !=null){
            jsonResponse.setSuccess(true);
            jsonResponse.setData(categoryList);
        } else {
            jsonResponse.setSuccess(false);
        }
        return jsonResponse;
    }
    
    @RequestMapping(value= "/Category", method = RequestMethod.GET)
    @ResponseBody
    public ExtJsonResponse <Category> loadingCategory(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "node") String node){
        logger.debug("LoadingCategory");
        logger.debug("[selectNode]: " + node);
        
        List <Category> categoryList = categoryManagementService.findCategoriesByParentId(node);
        ExtJsonResponse <Category> jsonResponse = new ExtJsonResponse<Category>();
        if (categoryList !=null){
            jsonResponse.setSuccess(true);
            jsonResponse.setData(categoryList);
        } else {
            jsonResponse.setSuccess(false);
        }
        return jsonResponse;
    }
    
}

