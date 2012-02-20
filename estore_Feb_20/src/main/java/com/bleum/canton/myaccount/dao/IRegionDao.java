package com.bleum.canton.myaccount.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.enumeration.RegionType;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
@Repository
public interface IRegionDao extends BaseDao<Region>{

	
	public List<Region> findByParentId(Region region);
	public List<Region> findByRegionType(RegionType regionType);
	
}
