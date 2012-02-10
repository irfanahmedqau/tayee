/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import java.util.List;
import java.util.Map;

import com.bleum.canton.myaccount.command.RegionForm;
import com.bleum.canton.myaccount.dao.impl.RegionDaoImpl;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.service.IRegionService;

/**
 * @author rudy.ding
 *
 */
public class RegionServiceImpl implements IRegionService {


	public List<Region> getCountries(RegionForm regionForm) {
		// TODO Auto-generated method stub
		return RegionDaoImpl.getInstance().getCountries(transferRegionForm(regionForm));
	}

	public Map<Region, List<Region>> getProvinces(RegionForm regionForm) {
		// TODO Auto-generated method stub
		return RegionDaoImpl.getInstance().getProvinces(transferRegionForm(regionForm));
	}

	public Map<Region, List<Region>> getCities(RegionForm regionForm) {
		// TODO Auto-generated method stub
		return RegionDaoImpl.getInstance().getCities(transferRegionForm(regionForm));
	}

	public Map<Region, List<Region>> getDistricts(RegionForm regionForm) {
		// TODO Auto-generated method stub
		return RegionDaoImpl.getInstance().getDistricts(transferRegionForm(regionForm));
	}
	
	/**
	 * RegionForm 转换成region
	 */
	public Region transferRegionForm(RegionForm regionForm){
		Long id = regionForm.getId();
		String regionName = regionForm.getRegionName();
		Long regionType = regionForm.getRegionType();
		Region parentRegion = new Region();
		parentRegion.setId( regionForm.getParentRegion().getId());
		Region region = new Region();
		region.setId(id);
		region.setRegionName(regionName);
		region.setRegionType(regionType);
		region.setParentRegion(parentRegion);
		return region;
	}
	
}
