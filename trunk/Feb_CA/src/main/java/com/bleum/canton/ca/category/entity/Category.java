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

package com.bleum.canton.ca.category.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bleum.canton.ca.common.entity.BaseEntity;

/**
 * 
 * @author Wayne.Zhong
 * @created Feb 13, 2012 11:29:19 AM
 */
@Entity
@Table(name="Versioned_Category")
public class Category extends BaseEntity {

    private static final long serialVersionUID = -4480721263636980277L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String ID;
    
    @Column(name= "CATEGORY_CODE", nullable = false, unique = true)
    private String categoryCode;

    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;
    
    @Column(name = "PARENT_ID", nullable = false)
    private String parentID;
    
    @Column(name = "CATEGORY_LEVEL", nullable = false)
    private String level; 
    
    @Column(name = "STATUS", nullable= false)
    private String status;
    
    @Column(name = "VERSION", nullable = false)
    private String version;

    /**
     * @return Returns the iD.
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD The iD to set.
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return Returns the categoryCode.
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @param categoryCode The categoryCode to set.
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return Returns the categoryName.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName The categoryName to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return Returns the parentID.
     */
    public String getParentID() {
        return parentID;
    }

    /**
     * @param parentID The parentID to set.
     */
    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    /**
     * @return Returns the level.
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level The level to set.
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Returns the version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version The version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }
    

  

}
