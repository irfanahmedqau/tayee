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
  
import javax.rmi.PortableRemoteObject; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import com.sun.ebank.ejb.account.AccountHome; 
import com.sun.ebank.ejb.account.AccountControllerHome; 
import com.sun.ebank.ejb.customer.CustomerHome; 
import com.sun.ebank.ejb.customer.CustomerControllerHome; 
import com.sun.ebank.ejb.tx.TxHome; 
import com.sun.ebank.ejb.tx.TxControllerHome; 
import com.sun.ebank.ejb.exception.*; 
  
/** 
 * This helper class fetches EJB home references. 
 */
  
public final class EJBGetter { 
  
    public static AccountHome getAccountHome() throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.ACCOUNT_EJBHOME); 
        return (AccountHome) 
            PortableRemoteObject.narrow(objref, AccountHome.class); 
    }  
  
    public static AccountControllerHome getAccountControllerHome()  
        throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.ACCOUNT_CONTROLLER_EJBHOME); 
        return (AccountControllerHome) 
            PortableRemoteObject.narrow(objref, AccountControllerHome.class); 
    }  
  
    public static CustomerHome getCustomerHome() throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.CUSTOMER_EJBHOME); 
        return (CustomerHome) 
            PortableRemoteObject.narrow(objref, CustomerHome.class); 
    } 
  
    public static CustomerControllerHome getCustomerControllerHome()  
        throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.CUSTOMER_CONTROLLER_EJBHOME); 
        return (CustomerControllerHome) 
            PortableRemoteObject.narrow(objref, CustomerControllerHome.class); 
    } 
  
    public static TxHome getTxHome() throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.TX_EJBHOME); 
        return (TxHome) 
            PortableRemoteObject.narrow(objref, TxHome.class); 
    } 
  
    public static TxControllerHome getTxControllerHome()  
        throws NamingException { 
  
        InitialContext initial = new InitialContext(); 
        Object objref = initial.lookup(CodedNames.TX_CONTROLLER_EJBHOME); 
        return (TxControllerHome) 
            PortableRemoteObject.narrow(objref, TxControllerHome.class); 
    } 
  
} // EJBGetter