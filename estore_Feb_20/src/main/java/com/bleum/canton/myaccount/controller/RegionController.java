/**
 * 
 */
package com.bleum.canton.myaccount.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bleum.canton.myaccount.entity.Region;
import com.bleum.canton.myaccount.service.IRegionService;


/**
 * @author rudy.ding
 *
 */
@Controller
public class RegionController {
	
	private final Logger logger = LoggerFactory.getLogger(RegionController.class);
	
	@Resource(name="regionService")
	IRegionService regionService ;

	@RequestMapping(value="/getCountries",method=RequestMethod.POST)
	@ResponseBody
	public  List<Region> getCountries( ){

		regionService.initRegion();
		List<Region> response =  regionService.getCountries();
		for(Region region:response){
			System.out.println("region = " + region.getRegionName());
		}
		return response;
	}
	
	@RequestMapping(value="/getProvinces",method=RequestMethod.POST)
	@ResponseBody
	public   List<Region> getProvinces(@RequestBody String id ){

//		Long parentId = regionForm.getId();
		String idtemp = id.replaceAll("\\D","").trim();
		if("".equals(idtemp)){
			return new ArrayList<Region>();
		}
		Long parentId = Long.parseLong(idtemp);

		List<Region> response =regionService.getProvinces(parentId);
		for(Region region:response){
			System.out.println("region.id = " + region.getId());
		}
		return response;
	}
	
	@RequestMapping(value="/getCities",method=RequestMethod.POST)
	public @ResponseBody List<Region> getCities(@RequestBody String id ){
		String idtemp = id.replaceAll("\\D","").trim();
		if("".equals(idtemp)){
			return new ArrayList<Region>();
		}
		Long parentId = Long.parseLong(idtemp);
		List<Region> response = regionService.getCities(parentId);
		return response;
	}
	
	@RequestMapping(value="/getDistricts",method=RequestMethod.POST)
	public @ResponseBody List<Region> getDistricts(@RequestBody String id ){
		String idtemp = id.replaceAll("\\D","").trim();
		if("".equals(idtemp)){
			return new ArrayList<Region>();
		}
		Long parentId = Long.parseLong(idtemp);

		List<Region> response = regionService.getDistricts(parentId);
		
		return response;
	}

}
