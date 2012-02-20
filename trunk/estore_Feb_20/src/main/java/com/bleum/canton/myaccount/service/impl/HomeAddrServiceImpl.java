/**
 * 
 */
package com.bleum.canton.myaccount.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.myaccount.command.HomeAddrForm;
import com.bleum.canton.myaccount.dao.IHomeAddrDao;
import com.bleum.canton.myaccount.entity.HomeAddr;
import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.service.IHomeAddrService;
import com.bleum.canton.myaccount.service.IRegionService;

/**
 * @author rudy.ding
 *
 */
@Component("homeAddrService")
public class HomeAddrServiceImpl implements IHomeAddrService {

	
	@Resource(name="homeAddrDao")
	private IHomeAddrDao homeAddrDao;
	
	@Resource(name="regionService")
	private IRegionService regionService;

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#addHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	@Transactional
	public HomeAddr addHomeAddr(HomeAddrForm homeAddrForm) {
		// TODO Auto-generated method stub
		HomeAddr homeAddr = new HomeAddr();
		Region country = transferRegionForm(homeAddrForm.getCountryId());
		Region province = transferRegionForm(homeAddrForm.getProvinceId());
		Region city = transferRegionForm(homeAddrForm.getCityId());
		Region district = transferRegionForm(homeAddrForm.getDistrictId());
		String linePhone = homeAddrForm.getLinePhone();
		String mobilePhone = homeAddrForm.getMobilePhone();
		String contact = homeAddrForm.getContact();
		String detailAddress = homeAddrForm.getDetailAddress();
		
		homeAddr.setCountry(country);
		homeAddr.setProvince(province);
		homeAddr.setCity(city);
		homeAddr.setDistrict(district);
		homeAddr.setLinePhone(linePhone);
		homeAddr.setMobilePhone(mobilePhone);
		homeAddr.setContact(contact);
		homeAddr.setDetailAddress(detailAddress);
		
		homeAddrDao.create(homeAddr);
		return homeAddr;
	}

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#deleteHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	@Transactional
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
	@Transactional
	public List<HomeAddr> getHomeAddresses() {
		List<HomeAddr> allHomeAddr = homeAddrDao.getAllHomeAddr();
		return allHomeAddr;
	}

	/* (non-Javadoc)
	 * @see com.bleum.canton.myaccount.service.IHomeAddrService#modifyHomeAddr(com.bleum.canton.myaccount.command.HomeAddrForm)
	 */
	@Transactional
	public HomeAddr modifyHomeAddr(HomeAddrForm homeAddrForm) {
		HomeAddr homeAddr = new HomeAddr();
		Region country = transferRegionForm(homeAddrForm.getCountryId());
		Region province = transferRegionForm(homeAddrForm.getProvinceId());
		Region city = transferRegionForm(homeAddrForm.getCityId());
		Region district = transferRegionForm(homeAddrForm.getDistrictId());
		String linePhone = homeAddrForm.getLinePhone();
		String mobilePhone = homeAddrForm.getMobilePhone();
		String contact = homeAddrForm.getContact();
		String detailAddress = homeAddrForm.getDetailAddress();
		String zipCode     = homeAddrForm.getZipCode();
		Long id = homeAddrForm.getId();
		System.out.println("id = " + id);
		System.out.println("detailAddress = " + detailAddress);
		homeAddr.setCountry(country);
		homeAddr.setProvince(province);
		homeAddr.setCity(city);
		homeAddr.setDistrict(district);
		homeAddr.setLinePhone(linePhone);
		homeAddr.setMobilePhone(mobilePhone);
		homeAddr.setContact(contact);
		homeAddr.setDetailAddress(detailAddress);
		homeAddr.setZipCode(zipCode);
		homeAddr.setId(id);
		
		homeAddrDao.update(homeAddr);
		return homeAddr;
	}

	@Transactional
	public HomeAddr getRecentUseHomeAddr(Long customerId) {
		// TODO Auto-generated method stub
		return
		homeAddrDao.getRecentUseHomeAddr(customerId);
//		return null;

	}
	@Transactional
	public HomeAddr getDefaultHomeAddr(Long customerId) {

		return homeAddrDao.getDefaultHomeAddr(customerId, 1);
	}
	/**
	 * RegionForm 转换成region
	 */
	@Transactional
	public Region transferRegionForm(Long id){		
		return regionService.getAllRegions().get(id);
		
	}
}
