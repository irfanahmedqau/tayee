/**
 * 
 */
package com.bleum.canton.checkout.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.entity.Invoice;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;

/**
 * @author walter.chen
 *
 */
@Transactional
@DAO(name="invoiceDaoImpl")
public interface IInvoiceDao extends BaseDao<Invoice>{
	Invoice saveInvoiceInfo(Invoice invoice);
}
