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
package com.bleum.canton.ca.category.service;

import java.util.List;

import com.bleum.canton.ca.category.entity.Category;

/**
 * @author Wayne.Zhong
 * @created Feb 13, 2012 11:30:30 AM
 */
public interface ICategoryManagementService {
    public void addCategory(Category category);
    
    public void delCategory();
    
    public List <Category> findCategoriesByParentId(String id);
    
    public Category findCategoryById(String id);
    
    public void UpdateCategory(Category category);
    
}
