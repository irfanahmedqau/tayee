/* <Bleum Inc. Copyright>
 * Copyright (C) 2011 Bleum Inc.
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement from Walmart Inc..  This notice must be
 * included on all copies, modifications and derivatives of this
 * work.
 *
 * Bleum Inc. MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. Belum Inc. 
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF 
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * </Walmart Inc. Copyright>
 */
package com.bleum.canton.ca.util.json;

import java.util.List;

/**
 * @author Wayne.Zhong
 * @created Feb 16, 2012 10:27:40 AM
 * This class defines the extjs tree response jason format.
 */
public class TreeResponseJsonModel {
    private String id;
    private String text;
    private String cls;
    private boolean leaf;
/*  Comment below as they are setting for checked tree  */
/*  private boolean expanded;
    private List <TreeResponseJsonModel>  children;
    private boolean checked;
*/
    
    
    /**
     * @return Returns the leaf.
     */
    public boolean isLeaf() {
        return leaf;
    }
    /**
     * @param leaf The leaf to set.
     */
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    /**
     * @return Returns the id.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }
    /**
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }
    /**
     * @return Returns the cls.
     */
    public String getCls() {
        return cls;
    }
    /**
     * @param cls The cls to set.
     */
    public void setCls(String cls) {
        this.cls = cls;
    }
}
