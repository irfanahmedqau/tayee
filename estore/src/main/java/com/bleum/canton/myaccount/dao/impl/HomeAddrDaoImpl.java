package com.bleum.canton.myaccount.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.IHomeAddrDao;
import com.bleum.canton.myaccount.entity.HomeAddr;



/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository("homeAddrDao")
public class HomeAddrDaoImpl extends BaseDaoHibernateImpl<HomeAddr> implements IHomeAddrDao {

	public HomeAddrDaoImpl(){
		super.init();
	}
	public HomeAddr getRecentUseHomeAddr(Long customerId) {
		Session session = super.getSession();
		Query query = session.createQuery("SELECT MAX(RECENTUSE) FROM HomeAddr WHERE CUSTOMER=?");
		query.setLong(0, customerId);
		return (HomeAddr) query.list().get(0);

	}

	public HomeAddr getDefaultHomeAddr(Long customerId,Integer defaultValue) {
		Session session = super.getSession();
		Query query = session.createQuery("FROM HomeAddr WHERE CUSTOMER=? AND ISDEFAULT=?");
		query.setLong(0, customerId);
		query.setInteger(1,defaultValue );
		return (HomeAddr) query.list().get(0);

	}

	public List<HomeAddr> getAllHomeAddr() {
		Session session = super.getSession();
		Query query   = session.createQuery("FROM HomeAddr");	
		return query.list();
	}
	
}
