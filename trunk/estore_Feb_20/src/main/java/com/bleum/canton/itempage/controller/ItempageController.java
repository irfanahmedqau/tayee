package com.bleum.canton.itempage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bleum.canton.itempage.entity.Category;
import com.bleum.canton.itempage.entity.Item;
import com.bleum.canton.itempage.entity.ItemImage;
import com.bleum.canton.itempage.entity.Product;
import com.bleum.canton.itempage.entity.ProductRichContent;
import com.bleum.canton.itempage.entity.ProductVarient;
import com.bleum.canton.itempage.service.IItempageService;

@Controller
@Transactional
public class ItempageController {

	private final Logger logger = LoggerFactory
			.getLogger(ItempageController.class);

	@Autowired
	private IItempageService itempageServiceImpl;
	
	private static final String RETURNPAGE = "itempage/itempage";

	@RequestMapping(value = "/viewProduct/{productid}/{itemlabel}")
	public ModelAndView changeItem(@PathVariable("productid") int productid, @PathVariable("itemlabel") String itemlabel,HttpServletRequest request) {
		
		Product product = itempageServiceImpl.getProductByID(productid);
		Item item;
		if(itemlabel.equals("default"))
			item = itempageServiceImpl.getDefaultItemByProductID(productid);
		else
			item = itempageServiceImpl.getItemByLabel(itemlabel);
		List<Category> categoryTree = itempageServiceImpl.getCategoryTreeFromProduct(product);
		List<ProductRichContent> prcList = itempageServiceImpl.getRichContentByProductID(productid);
		List<ProductVarient> pvList = itempageServiceImpl.getProductVarientByProductID(productid);
		
		Map model = new HashMap();
		model.put("product", product);
		model.put("item", item);
		model.put("categoryTree", categoryTree);
		model.put("productRichContentList", prcList);
		model.put("productVarientList", pvList);
		
		return new ModelAndView(RETURNPAGE, model);
	}
}
