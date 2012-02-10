package com.bleum.canton.myaccount.dao;

import java.util.List;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.myaccount.entity.Region;

/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */
public interface IRegionDao extends BaseDao<Region>{

	
	public List<Region> findByParentId(Long parentId);
	public List<Region> findByRegionType(Long regionType);
	
}
