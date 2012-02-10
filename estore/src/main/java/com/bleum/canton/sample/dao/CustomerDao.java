package com.bleum.canton.sample.dao;

import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.DAO;
import com.bleum.canton.sample.entity.SampleCustomer;

@Transactional
@DAO
//@DAO(name="xxcustomerDao")
//@DAO(name="xxcustomerDao", type="com.bleum.canton.sample.entity.SampleCustomer")
public interface CustomerDao extends BaseDao<SampleCustomer>{
	SampleCustomer findById(Long id);
	SampleCustomer findByEmail(String email);
}
