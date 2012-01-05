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
  
package com.sun.ebank.ejb.tx; 
  
import java.sql.*; 
import javax.sql.*; 
import java.util.*; 
import java.math.*; 
import javax.ejb.*; 
import javax.naming.*; 
import java.rmi.RemoteException; 
import com.sun.ebank.ejb.account.AccountHome; 
import com.sun.ebank.ejb.account.Account; 
import com.sun.ebank.ejb.exception.TxNotFoundException; 
import com.sun.ebank.ejb.exception.AccountNotFoundException; 
import com.sun.ebank.ejb.exception.InsufficientFundsException; 
import com.sun.ebank.ejb.exception.InsufficientCreditException; 
import com.sun.ebank.ejb.exception.IllegalAccountTypeException; 
import com.sun.ebank.ejb.exception.InvalidParameterException; 
import com.sun.ebank.util.Debug; 
import com.sun.ebank.util.TxDetails; 
import com.sun.ebank.util.DBHelper; 
import com.sun.ebank.util.EJBGetter; 
import com.sun.ebank.util.CodedNames; 
import com.sun.ebank.util.DomainUtil; 
  
public class TxControllerBean implements SessionBean { 
  
    private TxHome txHome; 
    private AccountHome accountHome; 
    private Connection con; 
    private SessionContext context; 
    private BigDecimal bigZero = new BigDecimal("0.00"); 
  
    public ArrayList getTxsOfAccount(java.util.Date startDate,  
        java.util.Date endDate, String accountId)  
        throws InvalidParameterException { 
  
        Debug.print("TxControllerBean  getTxsOfAccount"); 
  
        Collection txIds; 
        ArrayList txList = new ArrayList(); 
  
        if (startDate == null)  
            throw new InvalidParameterException("null startDate"); 
  
        if (endDate == null)  
            throw new InvalidParameterException("null endDate"); 
  
        if (accountId == null)  
            throw new InvalidParameterException("null accountId"); 
  
        try { 
            txIds = txHome.findByAccountId(startDate, endDate, accountId); 
        } catch (Exception ex) { 
             return txList; 
        } 
  
        Iterator i = txIds.iterator(); 
        while (i.hasNext()) { 
            Tx tx = (Tx)i.next(); 
            TxDetails txDetail = tx.getDetails(); 
            txList.add(txDetail); 
        } 
  
  
        return txList; 
  
    } // getTxsOfAccount 
  
    public TxDetails getDetails(String txId)  
        throws TxNotFoundException, InvalidParameterException { 
  
        Debug.print("TxControllerBean getDetails"); 
  
        if (txId == null) 
           throw new InvalidParameterException("null txId"); 
  
        try { 
            Tx tx = txHome.findByPrimaryKey(txId); 
            return tx.getDetails(); 
        } catch (Exception ex) { 
            throw new TxNotFoundException(txId); 
        } 
  
    } // getDetails 
  
    public void withdraw(BigDecimal amount, String description, 
        String accountId) throws  InvalidParameterException,  
        AccountNotFoundException, IllegalAccountTypeException, 
        InsufficientFundsException { 
  
        Debug.print("TxControllerBean withdraw"); 
  
        Account account = checkAccountArgs(amount, description, accountId); 
  
        String type = account.getType(); 
        if (DomainUtil.isCreditAccount(type))  
            throw new IllegalAccountTypeException(type); 
  
        BigDecimal newBalance = account.getBalance().subtract(amount); 
  
        if (newBalance.compareTo(bigZero) == -1) 
            throw new InsufficientFundsException(); 
  
        executeTx(amount.negate(), description, accountId, newBalance,  
            account); 
  
    } // withdraw 
  
     
    public void deposit(BigDecimal amount, String description, 
        String accountId) throws InvalidParameterException, 
        AccountNotFoundException, IllegalAccountTypeException { 
   
        Debug.print("TxControllerBean deposit"); 
  
        Account account = checkAccountArgs(amount, description, accountId); 
  
        String type = account.getType(); 
        if (DomainUtil.isCreditAccount(type))  
            throw new IllegalAccountTypeException(type); 
  
        BigDecimal newBalance = account.getBalance().add(amount); 
        executeTx(amount, description, accountId, newBalance, account);       
  
    } // deposit 
  
  
    public void makeCharge(BigDecimal amount, String description, 
        String accountId) throws  InvalidParameterException,  
        AccountNotFoundException, IllegalAccountTypeException, 
        InsufficientCreditException { 
  
        Debug.print("TxControllerBean charge"); 
  
        Account account = checkAccountArgs(amount, description, accountId); 
  
        String type = account.getType(); 
        if (DomainUtil.isCreditAccount(type) == false)  
            throw new IllegalAccountTypeException(type); 
  
        BigDecimal newBalance = account.getBalance().add(amount); 
  
        if (newBalance.compareTo(account.getCreditLine())  == 1) 
            throw new InsufficientCreditException(); 
  
        executeTx(amount, description, accountId, newBalance, account); 
  
  
    } // charge 
  
    public void makePayment(BigDecimal amount, String description, 
        String accountId) throws InvalidParameterException, 
        AccountNotFoundException, IllegalAccountTypeException { 
   
        Debug.print("TxControllerBean makePayment"); 
  
        Account account = checkAccountArgs(amount, description, accountId); 
  
        String type = account.getType(); 
        if (DomainUtil.isCreditAccount(type) == false)  
            throw new IllegalAccountTypeException(type); 
  
        BigDecimal newBalance = account.getBalance().subtract(amount); 
        executeTx(amount.negate(), description, accountId, newBalance,  
            account);       
  
    } // makePayment 
  
    public void transferFunds(BigDecimal amount, String description, 
        String fromAccountId, String toAccountId) throws   
        InvalidParameterException, 
        AccountNotFoundException, InsufficientFundsException, 
        InsufficientCreditException { 
  
        Account fromAccount = checkAccountArgs(amount, description,  
            fromAccountId); 
        Account toAccount = checkAccountArgs(amount, description,  
            toAccountId); 
  
        String fromType = fromAccount.getType(); 
        BigDecimal fromBalance = fromAccount.getBalance(); 
  
        if (DomainUtil.isCreditAccount(fromType)) { 
            BigDecimal fromNewBalance =  fromBalance.add(amount); 
            if (fromNewBalance.compareTo(fromAccount.getCreditLine()) == 1) 
                throw new InsufficientCreditException(); 
            executeTx(amount, description, fromAccountId,  
                fromNewBalance, fromAccount); 
        } else { 
            BigDecimal fromNewBalance =  fromBalance.subtract(amount); 
            if (fromNewBalance.compareTo(bigZero) == -1) 
                throw new InsufficientFundsException(); 
            executeTx(amount.negate(), description, fromAccountId,  
                fromNewBalance, fromAccount); 
        } 
              
        String toType = toAccount.getType(); 
        BigDecimal toBalance = toAccount.getBalance(); 
      
        if (DomainUtil.isCreditAccount(toType)) { 
            BigDecimal toNewBalance = toBalance.subtract(amount); 
            executeTx(amount.negate(), description, toAccountId,  
                toNewBalance, toAccount); 
        } else { 
            BigDecimal toNewBalance = toBalance.add(amount); 
            executeTx(amount, description, toAccountId,  
                toNewBalance, toAccount); 
        } 
  
    } // transferFunds 
  
    // private methods 
  
    private void executeTx(BigDecimal amount, String description, 
        String accountId, BigDecimal newBalance, Account account) { 
  
        Debug.print("TxControllerBean executeTx"); 
  
        try { 
            makeConnection(); 
            String txId = DBHelper.getNextTxId(con); 
            account.setBalance(newBalance); 
            Tx tx = txHome.create(txId, accountId, new java.util.Date(), 
                amount, newBalance, description); 
        } catch (Exception ex) { 
             throw new EJBException("executeTx: " + ex.getMessage()); 
        } finally { 
             releaseConnection(); 
        } 
  
    } // executeTx 
  
    private Account checkAccountArgs(BigDecimal amount, String description, 
        String accountId) throws InvalidParameterException, 
        AccountNotFoundException { 
  
        Account account = null; 
  
        if (description == null) 
            throw new InvalidParameterException("null description"); 
  
        if (accountId == null) 
            throw new InvalidParameterException("null accountId" ); 
  
        if (amount.compareTo(bigZero) != 1) 
           throw new InvalidParameterException("amount <= 0"); 
  
        try { 
            account = accountHome.findByPrimaryKey(accountId); 
        } catch (Exception ex) { 
            throw new AccountNotFoundException(accountId); 
        } 
     
        return account; 
  
    } // checkAccountArgs 
  
    // ejb methods 
  
    public void ejbCreate() { 
  
        Debug.print("TxControllerBean ejbCreate"); 
  
        try { 
            txHome = EJBGetter.getTxHome(); 
            accountHome = EJBGetter.getAccountHome(); 
        } catch (Exception ex) { 
             throw new EJBException("ejbCreate: " + 
                 ex.getMessage()); 
        } 
    } // ejbCreate 
  
  
    public void setSessionContext(SessionContext context) { 
       this.context = context; 
    } 
  
    public TxControllerBean() {} 
    public void ejbRemove() {} 
    public void ejbActivate() {} 
    public void ejbPassivate() {} 
  
  
/*********************** Database Routines *************************/
  
    private void makeConnection() { 
     
        Debug.print("TxControllerBean makeConnection"); 
  
        try { 
            InitialContext ic = new InitialContext(); 
            DataSource ds = (DataSource) ic.lookup(CodedNames.BANK_DATABASE); 
            con =  ds.getConnection(); 
        } catch (Exception ex) { 
             throw new EJBException("Unable to connect to database. " + 
                 ex.getMessage()); 
        } 
    } // makeConnection 
   
    
    private void releaseConnection() { 
     
        Debug.print("TxControllerBean releaseConnection"); 
  
        try { 
            con.close(); 
        } catch (SQLException ex) { 
             throw new EJBException("releaseConnection: " + ex.getMessage()); 
        } 
  
    } // releaseConnection 
  
  
  
} // TxControllerBean 

