/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bleum.canton.myaccount.command.HomeAddrForm;
import com.bleum.canton.myaccount.command.RegionForm;
import com.bleum.canton.myaccount.dao.IHomeAddrDao;
import com.bleum.canton.myaccount.entity.HomeAddr;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.service.IHomeAddrService;

/**
 * @author rudy.ding
 *
 */
public class HomeAddrServiceImpl implements IHomeAddrService {

	
	@Resource(name="homeAddrDao")
	private IHomeAddrDao homeAddrDao;
	

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#addHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	public void addHomeAddr(HomeAddrForm homeAddrForm) {
		// TODO Auto-generated method stub
		HomeAddr homeAddr = new HomeAddr();
		Region country = transferRegionForm(homeAddrForm.getCountry());
		Region province = transferRegionForm(homeAddrForm.getProvince());
		Region city = transferRegionForm(homeAddrForm.getCity());
		Region district = transferRegionForm(homeAddrForm.getDistrict());
		String linePhone = homeAddrForm.getLinePhone();
		String mobilePhone = homeAddrForm.getMobilePhone();
		String contacter = homeAddrForm.getContacter();
		
		homeAddr.setCountry(country);
		homeAddr.setProvince(province);
		homeAddr.setCity(city);
		homeAddr.setDistrict(district);
		homeAddr.setLinePhone(linePhone);
		homeAddr.setMobilePhone(mobilePhone);
		homeAddr.setContacter(contacter);
		
		homeAddrDao.create(homeAddr);
	}

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#deleteHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	public void deleteHomeAddr(HomeAddrForm homeAddrForm) {
		// TODO Auto-generated method stub
		Long id = homeAddrForm.getId();
		HomeAddr homeAddr = new HomeAddr();
		homeAddr.setId(id);
		homeAddrDao.delete(homeAddr);
	}

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#getHomeAddresses()
	 */
	public List<HomeAddr> getHomeAddresses() {
		List<HomeAddr> allHomeAddr = homeAddrDao.getAllHomeAddr();
		return allHomeAddr;
	}

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#modifyHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	public HomeAddr modifyHomeAddr(HomeAddrForm homeAddrForm) {
		HomeAddr homeAddr = new HomeAddr();
		Region country = transferRegionForm(homeAddrForm.getCountry());
		Region province = transferRegionForm(homeAddrForm.getProvince());
		Region city = transferRegionForm(homeAddrForm.getCity());
		Region district = transferRegionForm(homeAddrForm.getDistrict());
		String linePhone = homeAddrForm.getLinePhone();
		String mobilePhone = homeAddrForm.getMobilePhone();
		String contacter = homeAddrForm.getContacter();
		
		homeAddr.setCountry(country);
		homeAddr.setProvince(province);
		homeAddr.setCity(city);
		homeAddr.setDistrict(district);
		homeAddr.setLinePhone(linePhone);
		homeAddr.setMobilePhone(mobilePhone);
		homeAddr.setContacter(contacter);
		
		homeAddrDao.update(homeAddr);
		return homeAddr;
	}

	
	public HomeAddr getRecentUseHomeAddr(Long customerId) {
		// TODO Auto-generated method stub
		return
		homeAddrDao.getRecentUseHomeAddr(customerId);
//		return null;

	}

	public HomeAddr getDefaultHomeAddr(Long customerId) {

		return homeAddrDao.getDefaultHomeAddr(customerId, 1);
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
