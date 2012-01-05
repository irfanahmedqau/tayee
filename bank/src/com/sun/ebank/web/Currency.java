/* 
 * 
 * Copyright 2001 Sun Microsystems, Inc. All Rights Reserved. 
 *  
 * This software is the proprietary information of Sun Microsystems, Inc.   
 * Use is subject to license terms. 
 *  
 */
   
package com.sun.ebank.web; 
import java.text.NumberFormat; 
import java.text.DecimalFormat; 
public final class Currency extends Object { 
   public static String format(double amount){ 
      NumberFormat nf = NumberFormat.getCurrencyInstance(); 
      DecimalFormat df = (DecimalFormat)nf; 
      df.setMinimumFractionDigits(2); 
      df.setMaximumFractionDigits(2); 
      df.setDecimalSeparatorAlwaysShown(true); 
      String pattern = "$###,###.00";  
      df.applyPattern(pattern); 
      return df.format(amount); 
   } 
}