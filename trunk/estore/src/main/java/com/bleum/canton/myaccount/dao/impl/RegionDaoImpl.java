package com.bleum.canton.myaccount.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bleum.canton.common.dao.impl.BaseDaoHibernateImpl;
import com.bleum.canton.myaccount.dao.IRegionDao;
import com.bleum.canton.myaccount.entity.Region;



/**
 * @author    lynn.chen
 * @since     v 0.1.0 ,Feb 6, 2012
 * @version   v 0.1.0
 */


public class RegionDaoImpl extends BaseDaoHibernateImpl<Region>  implements IRegionDao {
	

	
	
	private static  List<Region>             countriesRegion     = new ArrayList<Region>();
	private static  Map<Region,List<Region>> provincesRegion		= new HashMap<Region, List<Region>>();
	private static  Map<Region,List<Region>> citiesRegion		= new HashMap<Region, List<Region>>();
	private static  Map<Region,List<Region>> districtsRegion		= new HashMap<Region, List<Region>>();
	
	private static Long COUNTRY_CODE = (long) 0;
	private static  RegionDaoImpl regionDaoImpl = new RegionDaoImpl();
	

	
	private RegionDaoImpl(){
		super.init();
		initialRegion();
	}
	
	public synchronized static RegionDaoImpl getInstance(){
		if(regionDaoImpl == null){
			regionDaoImpl = new RegionDaoImpl();
		}
		return regionDaoImpl;
	}
	
	
	public List<Region> findByParentId(Long parentId) {
		Session session = super.getSession();
		Query query 	= session.createQuery("FROM Region r WHERE r.PARENTID=?");
		query.setLong(0, parentId);
		return query.list();
	}

	public List<Region> findByRegionType(Long regionType) {
		Session session = super.getSession();
		Query query 	= session.createQuery("FROM Region r WHERE r.REGIONTYPE=?");
		query.setLong(0, regionType);
		return query.list();
	}
	
	public List<Region> getCountries(Region region) {
		return countriesRegion;
	}

	public Map<Region, List<Region>> getProvinces(Region region) {

		return provincesRegion;
	}

	public Map<Region, List<Region>> getCities(Region region) {
		return citiesRegion;
	}

	public Map<Region, List<Region>> getDistricts(Region region) {
		
		return districtsRegion;
	}
	
	private void initialRegion(){

		countriesRegion = findByRegionType(COUNTRY_CODE);
		for(Region country : countriesRegion){
			List<Region> provinces = findByParentId(country.getId());
			provincesRegion.put(country, provinces);
			for(Region province:provinces){
				List<Region> cities = findByParentId(province.getId());
				citiesRegion.put(province, cities);
				for(Region city:cities){
					List<Region> districts = findByParentId(city.getId());
					districtsRegion.put(city, districts);
				}
			}
		}
	}
	
}
