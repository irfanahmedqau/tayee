/**
 * 
 */
package com.bleum.canton.myaccount.service;

import java.util.List;
import java.util.Map;

import com.bleum.canton.myaccount.command.RegionForm;
import com.bleum.canton.myaccount.entity.Region;

/**
 * @author rudy.ding
 *
 */
public interface IRegionService {
	
	public List<Region> getCountries(RegionForm regionForm);
	
	public Map<Region,List<Region>> getProvinces(RegionForm regionForm);
	
	public Map<Region,List<Region>> getCities(RegionForm regionForm);
	
	public Map<Region,List<Region>> getDistricts(RegionForm regionForm);
	
	
	
}
