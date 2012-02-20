/**
 * 
 */
package com.bleum.canton.checkout.dao.impl;

import org.springframework.stereotype.Repository;

import com.bleum.canton.checkout.dao.IPaymentMethodDao;
import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;

/**
 * @author walter.chen
 *
 */
//@Repository("paymentMethodDaoImpl")
public class PaymentMethodDaoImpl extends BaseDaoHibernateImpl<PaymentMethod> implements IPaymentMethodDao {

	public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		return null;
	}

}
