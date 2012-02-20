package com.bleum.canton.checkout.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.checkout.entity.PaymentMethod;
import com.bleum.canton.checkout.entity.ShippingMethod;
import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
@Transactional
@DAO(name="shippingMethodDaoImpl")
public interface IShippingMethodDao extends BaseDao<ShippingMethod>{

	ShippingMethod saveShippingMethod(ShippingMethod shippingMethod);
}
