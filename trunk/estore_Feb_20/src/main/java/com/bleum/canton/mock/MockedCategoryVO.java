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
package com.bleum.canton.mock;

import java.util.ArrayList;
import com.bleum.canton.mock.MockedProductVO;

/**
 * @author charles.wang
 * @created Feb 9, 2012 9:27:48 AM
 * Description:the value object which stand for category
 */
public class MockedCategoryVO {

    private String categoryId;
    private String categoryName;
    private boolean isParentCategory;
    private boolean isLeafCategory;
    private boolean isRootCategory;
    
    private MockedCategoryVO parentCategory;
    
  //private ArrayList<String> subCategories = new ArrayList<String> ();
    private ArrayList<MockedCategoryVO> subCategories = new ArrayList<MockedCategoryVO>();
    
    private ArrayList<MockedProductVO> products = new ArrayList<MockedProductVO> ();
    
    
    
    public boolean isLeafCategory() {
        return this.isLeafCategory;
    }
    
    public void setLeafCategory(boolean pIsLeafCategory) {
        this.isLeafCategory = pIsLeafCategory;
    }

    
    
    public boolean isRootCategory() {
        return this.isRootCategory;
    }

    public void setRootCategory(boolean pIsRootCategory) {
        this.isRootCategory = pIsRootCategory;
    }



    
    
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
    
    
    
    
    public MockedCategoryVO getParentCategory() {
        return this.parentCategory;
    }

    public void setParentCategory(MockedCategoryVO pParentCategory) {
        this.parentCategory = pParentCategory;
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
   
   
    
       
    public void addSubCategory(MockedCategoryVO category){
        if(isParentCategory()==true){
            subCategories.add(category);
        }
    }
    
    
    public void addParentCategory(MockedCategoryVO category){
        if(isRootCategory()!=true){
            this.setParentCategory(category);
            category.addSubCategory(this);
        }
    }
    
    public void addProduct(MockedProductVO product){
        if(isLeafCategory()==true)
        this.products.add(product);
    }
    
    
    public ArrayList<MockedCategoryVO> getSubCategories() {
        if(isParentCategory()==true)
            return this.subCategories;
        
        else
            return null;
    }
    
    public ArrayList<String> getSubCategoryIds(){
       
        
        ArrayList<String> subCategoryIds = new ArrayList<String> ();
        for (int i=0;i<subCategories.size();i++){
            subCategoryIds.add(subCategories.get(i).getCategoryId());
        }
        
        return subCategoryIds;
    }
    
    public ArrayList<MockedProductVO> getProducts(){
        
        if(isLeafCategory()==true)
            return this.products;
        
        else
            return null;
        
    }
    
    
    
    
    
}
