package com.bleum.canton.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleum.canton.sample.command.ProductForm;
import com.bleum.canton.sample.dao.IProductDao;
import com.bleum.canton.sample.dao.IProductStorageDao;
import com.bleum.canton.sample.entity.Product;
import com.bleum.canton.sample.entity.ProductStorage;
import com.bleum.canton.sample.service.IProductManagementService;

@Service("productManagementService")
public class ProductManagementService implements IProductManagementService {
	
	@Resource(name = "productDao")
	private IProductDao productDao;
	
	@Resource(name = "productStorageDao")
	private IProductStorageDao productStorageDao;

	@Transactional
	public void saveProductAndStorages(ProductForm form) {
		Product product = new Product();
		product.setProductName(form.getProductName());
		product.setSkuId(form.getSkuId());
		productDao.saveProduct(product);
		for(String storageId:form.getStorages()) {
			ProductStorage productStorage = new ProductStorage();
			productStorage.getId().setProductId(product.getId());
			productStorage.getId().setStorageId(storageId);
			productStorageDao.saveProductStorage(productStorage);
		}
	}

}
