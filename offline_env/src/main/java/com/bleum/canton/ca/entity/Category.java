package com.bleum.canton.ca.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wayne.zhong
 * @created Feb 10, 2012 1:34:27 PM
 */

@Entity
@Table(name="T_Category")
public class Category implements Serializable {

    private static final long serialVersionUID = -4480721263636980277L;

    @Id
    @Column(name = "ID")
    private String categoryID;

    @Column(name = "CATEGORYNAME", nullable = false)
    private String categoryName;
    
    @Column(name = "PARENTID", nullable = false)
    private String parentID;
    
    @Column(name = "CATEGORYLEVEL", nullable = false)
    private String level;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
