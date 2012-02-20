package com.bleum.canton.myaccount.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.myaccount.entity.HomeAddr;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository
public interface IHomeAddrDao extends BaseDao<HomeAddr>{


	public HomeAddr getRecentUseHomeAddr(Long customerId);
	public HomeAddr getDefaultHomeAddr   (Long customerId,Integer DefaultValue);
	public List<HomeAddr> getAllHomeAddr();
	
}
