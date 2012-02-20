/**
 * 
 */
package com.bleum.canton.myaccount.service;

import java.util.List;

import com.bleum.canton.myaccount.command.HomeAddrForm;
import com.bleum.canton.myaccount.entity.HomeAddr;

/**
 * @author rudy.ding
 *
 */
public interface IHomeAddrService {
	
	/**
	 * add home address
	 * @param homeAddrForm
	 */
	public HomeAddr addHomeAddr(HomeAddrForm homeAddrForm);
	
	/**
	 * delete home address
	 * @param homeAddrForm
	 */
	public void deleteHomeAddr(HomeAddrForm homeAddrForm);
	
	/**
	 * get all registered home addresses
	 * @return List<HomeAddrForm>
	 */
	public List<HomeAddr> getHomeAddresses();
	
	/**
	 * modify home address
	 * @param homeAddrForm
	 * @return CusHomeAddrForm
	 */
	public HomeAddr modifyHomeAddr(HomeAddrForm homeAddrForm);
	
	/**
	 * RecentUseHomeAddr
	 * 
	 * @return recentUseHomeAddrForm
	 */
	public HomeAddr getRecentUseHomeAddr(Long customerId);
	
	
	
	/**
	 * DefaultHomeAddr
	 * @return
	 */
	public HomeAddr getDefaultHomeAddr(Long customerId);
	
	
	
}
