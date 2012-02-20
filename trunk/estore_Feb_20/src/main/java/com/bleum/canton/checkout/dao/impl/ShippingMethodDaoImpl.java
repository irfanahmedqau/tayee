/**
 * 
 */
package com.bleum.canton.checkout.dao.impl;

import org.springframework.stereotype.Repository;

import com.bleum.canton.checkout.dao.IShippingMethodDao;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;

/**
 * @author walter.chen
 *
 */
//@Repository("shippingMethodDaoImpl")
public class ShippingMethodDaoImpl extends BaseDaoHibernateImpl<ShippingMethod> implements IShippingMethodDao {

	public ShippingMethod saveShippingMethod(ShippingMethod shippingMethod) {
		// TODO Auto-generated method stub
		return null;
	}

}
