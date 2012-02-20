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

/**
 * @author charles.wang
 * @created Feb 15, 2012 11:15:52 AM
 * Description: this is the mocked product 
 */
public class MockedProductVO {
    
    private String productId;
    private String productName;
    private String thumbnailImgPath;
    private double price;
    
    private MockedCategoryVO categoryVO ;
    
    public String getProductId() {
        return this.productId;
    }
    public void setProductId(String pProductId) {
        this.productId = pProductId;
    }
    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String pProductName) {
        this.productName = pProductName;
    }
      
    public String getThumbnailImgPath() {
        return this.thumbnailImgPath;
    }
    public void setThumbnailImgPath(String pThumbnailImgPath) {
        this.thumbnailImgPath = pThumbnailImgPath;
    }
    
    
    
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double pPrice) {
        this.price = pPrice;
    }
    public MockedCategoryVO getCategoryVO() {
        return this.categoryVO;
    }
    public void setCategoryVO(MockedCategoryVO pCategoryVO) {
        this.categoryVO = pCategoryVO;
        categoryVO.addProduct(this);
    }
    
    

}
