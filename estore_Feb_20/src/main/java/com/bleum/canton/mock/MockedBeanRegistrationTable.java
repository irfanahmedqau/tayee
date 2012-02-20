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

import java.util.HashMap;
import java.util.Map;

/**
 * @author charles.wang
 * @created Feb 15, 2012 11:22:52 AM
 * Description: the bean registration table
 */
public class MockedBeanRegistrationTable {
    
    private Map<String,Object> registration;
    
    public MockedBeanRegistrationTable(){
        registration = new HashMap<String,Object>();
    }
    
    public void addEntry(String key ,Object value){
        registration.put(key, value);
    }
    
    public Object get(String key){
        return registration.get(key);
    }
    

}
