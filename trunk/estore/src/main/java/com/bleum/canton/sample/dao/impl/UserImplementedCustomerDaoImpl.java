package com.bleum.canton.sample.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.sample.dao.CustomerDao;
import com.bleum.canton.sample.entity.SampleCustomer;

@Transactional
@Component("userImplementedCustomerDao")
public class UserImplementedCustomerDaoImpl extends BaseDaoHibernateImpl<SampleCustomer> implements CustomerDao{
	public UserImplementedCustomerDaoImpl(){
		super.init();
	}
	
	public SampleCustomer findById(Long id){
		return super.find(id);
	}
	
	public SampleCustomer findByEmail(String email){
		return null;
	}
}
