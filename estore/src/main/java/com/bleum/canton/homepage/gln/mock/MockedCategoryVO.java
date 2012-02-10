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
package com.bleum.canton.homepage.gln.mock;

import java.util.ArrayList;

/**
 * @author charles.wang
 * @created Feb 9, 2012 9:27:48 AM
 * Description:the value object which stand for category
 */
public class MockedCategoryVO {

    private String categoryId;
    private String categoryName;
    private boolean isParentCategory;
    private ArrayList<String> subCategories = new ArrayList<String> ();
    
    
    //generated getter and setter
    public String getCategoryId() {
        return this.categoryId;
    }
    public boolean isParentCategory() {
        return this.isParentCategory;
    }
    public void setParentCategory(boolean pIsParentCategory) {
        this.isParentCategory = pIsParentCategory;
    }
    public void setCategoryId(String pCategoryId) {
        this.categoryId = pCategoryId;
    }
    public String getCategoryName() {
        return this.categoryName;
    }
    public void setCategoryName(String pCategoryName) {
        this.categoryName = pCategoryName;
    }
   
   
    public ArrayList<String> getSubCategories() {
        return this.subCategories;
    }
       
    public void addSubCategory(String subCategoryId){
        if(isParentCategory()==true){
            subCategories.add(subCategoryId);
        }
    }
    
    @Override
    public String toString() {
        return "MockedCategoryVO [categoryId=" + this.categoryId + ", categoryName=" + this.categoryName
                + ", isRootCategory="  + ", ParentCategory=" + this.isParentCategory
                + ", subCategories=" + this.subCategories + "]";
    }
    
    
    
}
