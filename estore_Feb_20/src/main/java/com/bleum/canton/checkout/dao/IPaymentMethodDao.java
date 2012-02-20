/**
 * 
 */
package com.bleum.canton.checkout.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;

/**
 * @author walter.chen
 *
 */
@Transactional
@DAO(name="paymentMethodDaoImpl")
public interface IPaymentMethodDao extends BaseDao<PaymentMethod>{
	PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);
}
