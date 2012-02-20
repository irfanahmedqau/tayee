package com.bleum.canton.myaccount.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.IRegionDao;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.enumeration.RegionType;



/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */


@Repository("regionDao")
public class RegionDaoImpl extends BaseDaoHibernateImpl<Region>  implements IRegionDao {
	

	
	

	

	
	public  RegionDaoImpl(){
		super.init();
	}
	

	

	public List<Region> findByParentId(Region region) {
		
		Query query = getSession().getNamedQuery("Region.findByParentId").setParameter("parentRegion", region);
		return query.list();
	}

	public List<Region> findByRegionType(RegionType regionType) {
		Session session = getSession();
		System.out.println("session = " + session);
		Query query = getSession().getNamedQuery("Region.findByRegionType").setParameter("regionType", regionType);
		return query.list();
	}
	

	
}
