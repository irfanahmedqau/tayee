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

	public List<Region> getCountries();

	public List<Region> getProvinces(Long parenetId);

	public List<Region> getCities(Long parenetId);

	public List<Region> getDistricts(Long parenetId);

	public void initRegion();

	public Map<Long, Region> getAllRegions();

}
