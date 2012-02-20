/**
 * 
 */
package com.bleum.canton.myaccount.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.myaccount.command.HomeAddrForm;
import com.bleum.canton.myaccount.entity.HomeAddr;
import com.bleum.canton.myaccount.service.IHomeAddrService;

/**
 * @author rudy.ding
 * 
 */
@Controller
public class HomeAddrController {

	private final Logger logger = LoggerFactory
			.getLogger(HomeAddrController.class);
	private static final String HOME_ADDRESS = "/myaccount/homeaddr";
	private static final String HOME_ADDRESS_DEMO = "/myaccount/demo";
	private static final String ALL_ADDRESSES = "allHomeAddresses";
	private List<HomeAddr> homeAddresses = new ArrayList<HomeAddr>();
	private Map<Long,HomeAddr> allHomeAddress = new HashMap<Long,HomeAddr>();

	@Resource(name = "homeAddrService")
	private IHomeAddrService homeAddrService;

	@RequestMapping(value = "/addHomeAddress", method = RequestMethod.POST)
	public ModelAndView addHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm,
			HttpServletRequest request) {
		HomeAddr homeAddr = homeAddrService.addHomeAddr(homeAddrForm);
		ModelAndView mav = new ModelAndView(HOME_ADDRESS_DEMO);
		allHomeAddress.put(homeAddr.getId(), homeAddr);
		homeAddresses.add(homeAddr);
		mav.addObject(ALL_ADDRESSES, homeAddresses);
		return mav;
	}

	@RequestMapping(value = "/modifyHomeAddress", method = RequestMethod.POST)
	public ModelAndView modifyHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm,
			HttpServletRequest request) {
		HomeAddr homeAddr = homeAddrService.modifyHomeAddr(homeAddrForm);
		ModelAndView mav = new ModelAndView(HOME_ADDRESS_DEMO);
		allHomeAddress.put(homeAddr.getId(), homeAddr);
		Iterator<Entry<Long,HomeAddr>> iterator =  allHomeAddress.entrySet().iterator();
		homeAddresses.clear();
		while(iterator.hasNext()){
			homeAddresses.add(iterator.next().getValue());
		}
		mav.addObject(ALL_ADDRESSES, homeAddresses);
		return mav;
	}

	@RequestMapping(value = "/deleteHomeAddress", method = RequestMethod.GET)
	public ModelAndView deleteHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm,
			HttpServletRequest request) {
		Long id = new Long(request.getParameter("id"));
		homeAddrForm.setId(id);
		ModelAndView mav = new ModelAndView(HOME_ADDRESS_DEMO);

		homeAddrService.deleteHomeAddr(homeAddrForm);
		allHomeAddress.remove(homeAddrForm.getId());
		Iterator<Entry<Long,HomeAddr>> iterator =  allHomeAddress.entrySet().iterator();
		homeAddresses.clear();
		while(iterator.hasNext()){
			homeAddresses.add(iterator.next().getValue());
		}
		mav.addObject(ALL_ADDRESSES, homeAddresses);
		return mav;
	}

	@RequestMapping(value = "/getHomeAddresses", method = RequestMethod.GET)
	public ModelAndView getAllHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm) {
		homeAddresses = (ArrayList<HomeAddr>) homeAddrService
				.getHomeAddresses();
		for(HomeAddr homeAddr :homeAddresses){
			allHomeAddress.put(homeAddr.getId(), homeAddr);
		}
		ModelAndView mav = new ModelAndView(HOME_ADDRESS_DEMO);
		mav.addObject(ALL_ADDRESSES, homeAddresses);
		return mav;
	}

	@RequestMapping(value = "/getDefaultHomeAddr", method = RequestMethod.POST)
	public ModelAndView getDefaultHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	@RequestMapping(value = "/getRecentUseHomeAddr", method = RequestMethod.POST)
	public ModelAndView getRecentUseHomeAddr(
			@ModelAttribute("HomeAddrForm") HomeAddrForm homeAddrForm) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value="/getModifyHomeAddr",method=RequestMethod.POST)
	@ResponseBody
	public HomeAddr getModifyHomeAddr(@RequestBody String id){
		String key= id.replaceAll("\\D","").trim();
		HomeAddr response = allHomeAddress.get(Long.parseLong(key));
		return response;
	}
	

}
