/**
 * 
 */
package com.bleum.canton.checkout.dao.impl;

import org.springframework.stereotype.Repository;

import com.bleum.canton.checkout.dao.IInvoiceDao;
import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;

/**
 * @author walter.chen
 *
 */
//@Repository("invoiceDaoImpl")
public class InvoiceDaoImpl extends BaseDaoHibernateImpl<Invoice> implements IInvoiceDao {

	public Invoice saveInvoiceInfo(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}

}
