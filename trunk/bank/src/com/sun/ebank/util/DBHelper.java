/* 
 * Copyright (c) 2003 Sun Microsystems, Inc.  All rights reserved.  U.S.  
 * Government Rights - Commercial software.  Government users are subject  
 * to the Sun Microsystems, Inc. standard license agreement and  
 * applicable provisions of the FAR and its supplements.  Use is subject  
 * to license terms.   
 *  
 * This distribution may include materials developed by third parties.  
 * Sun, Sun Microsystems, the Sun logo, Java and J2EE are trademarks  
 * or registered trademarks of Sun Microsystems, Inc. in the U.S. and  
 * other countries.   
 *  
 * Copyright (c) 2003 Sun Microsystems, Inc. Tous droits reserves. 
 *  
 * Droits du gouvernement americain, utilisateurs gouvernementaux - logiciel 
 * commercial. Les utilisateurs gouvernementaux sont soumis au contrat de  
 * licence standard de Sun Microsystems, Inc., ainsi qu'aux dispositions  
 * en vigueur de la FAR (Federal Acquisition Regulations) et des  
 * supplements a celles-ci.  Distribue par des licences qui en  
 * restreignent l'utilisation. 
 *  
 * Cette distribution peut comprendre des composants developpes par des  
 * tierces parties. Sun, Sun Microsystems, le logo Sun, Java et J2EE  
 * sont des marques de fabrique ou des marques deposees de Sun  
 * Microsystems, Inc. aux Etats-Unis et dans d'autres pays. 
 */
  
package com.sun.ebank.util; 
  
import java.sql.*; 
import javax.sql.*; 
import com.sun.ebank.util.*; 
import com.sun.ebank.ejb.exception.*; 
  
/** 
 * This class contains helper methods for components 
 * that access Cloudscape databases. 
 */
  
public final class DBHelper { 
  
    // The getNext<name>Id methods retrieve the next unique 
    // primary key. 
  
    public static final String getNextAccountId(Connection con)  
        throws SQLException, MissingPrimaryKeyException { 
  
        Debug.print("DBHelper getNextAccountId"); 
        return getNextId(con, "next_account_id"); 
    } // getNextAccountId 
  
    public static final String getNextCustomerId(Connection con)  
        throws SQLException, MissingPrimaryKeyException { 
  
        Debug.print("DBHelper getNextCustomerId"); 
        return getNextId(con, "next_customer_id"); 
    } // getNextCustomerId 
  
    public static final String getNextTxId(Connection con) 
        throws SQLException, MissingPrimaryKeyException { 
  
        Debug.print("DBHelper getNextTxId"); 
        return getNextId(con, "next_tx_id"); 
    } // getNextTxId 
  
    private static final String getNextId(Connection con, String table) 
        throws SQLException, MissingPrimaryKeyException { 
  
        Debug.print("DBHelper getNextId"); 
  
        String selectStatement = 
                "select max(id) from " + table; 
        String updateStatement = 
                "update " + table + " " + 
                "set id = id + 1 "; 
  
        PreparedStatement prepSelect = 
                con.prepareStatement(selectStatement); 
        PreparedStatement prepUpdate = 
                con.prepareStatement(updateStatement); 
   
        prepUpdate.executeUpdate(); 
        ResultSet rs = prepSelect.executeQuery(); 
        rs.next(); 
        int i = rs.getInt(1); 
        rs.close(); 
        prepSelect.close(); 
        prepUpdate.close(); 
  
        if (i <= 0) { 
            throw new MissingPrimaryKeyException 
            ("Table " + table + " is empty."); 
        } 
  
        return Integer.toString(i); 
  
    } // getNextId 
  
  
    public static final java.sql.Date toSQLDate(java.util.Date inDate) { 
  
        // This method returns a sql.Date version of the util.Date arg. 
  
        return new java.sql.Date(inDate.getTime()); 
    } 
  
  
} // class