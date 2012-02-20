/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.myaccount.dao.IRegionDao;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.enumeration.RegionType;
import com.bleum.canton.myaccount.service.IRegionService;

/**
 * @author rudy.ding
 *
 */



@Component("regionService")
@Transactional
public class RegionServiceImpl implements IRegionService {

	private static   List<Region>             countriesRegion     = new ArrayList<Region>();
	private static  Map<Long,List<Region>> provincesRegion		= new HashMap<Long, List<Region>>();
	private static  Map<Long,List<Region>> citiesRegion		= new HashMap<Long, List<Region>>();
	private static  Map<Long,List<Region>> districtsRegion		= new HashMap<Long, List<Region>>();
	private static  Map<Long,Region> allRegion = new HashMap<Long,Region>();

	
	@Resource(name="regionDao")
	private   IRegionDao regionDao ;
	

	public List<Region> getCountries() {
		// TODO Auto-generated method stub
		return countriesRegion;
	}

	public List<Region> getProvinces(Long parenetId) {
		// TODO Auto-generated method stub
		return provincesRegion.get(parenetId);
	}

	public List<Region> getCities(Long parenetId) {
		// TODO Auto-generated method stub
		return citiesRegion.get(parenetId);
	}

	public List<Region> getDistricts(Long parenetId) {
		// TODO Auto-generated method stub
		return districtsRegion.get(parenetId);
	}
	
	public Map<Long,Region>  getAllRegions(){
		return allRegion;
	}
	
	
	public  void initRegion(){
		System.out.println("enter");
		if(countriesRegion == null || countriesRegion.size()==0 ){
			countriesRegion = regionDao.findByRegionType(RegionType.COUNTRY);
			for(Region country : countriesRegion){
				List<Region> provinces = regionDao.findByParentId(country);
				allRegion.put(country.getId(), country);
				provincesRegion.put(country.getId(), provinces);
				for(Region province:provinces){
					List<Region> cities = regionDao.findByParentId(province);
					allRegion.put(province.getId(), province);
					citiesRegion.put(province.getId(), cities);
					for(Region city:cities){
						
						List<Region> districts = regionDao.findByParentId(city);
						allRegion.put(city.getId(), city);
						districtsRegion.put(city.getId(), districts);
						for(Region district:districts){
							allRegion.put(district.getId(), district);
						}
					}
				}
			}
		}
		
	}
	
}
