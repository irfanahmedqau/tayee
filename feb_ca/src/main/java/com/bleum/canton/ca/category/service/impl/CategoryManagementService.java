package com.bleum.canton.ca.category.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bleum.canton.ca.category.dao.ICategoryDao;
import com.bleum.canton.ca.category.entity.Category;
import com.bleum.canton.ca.category.service.ICategoryManagementService;
import com.bleum.canton.ca.util.json.TreeResponseJsonModel;
import com.bleum.canton.util.json.ExtJsonResponse;

/**
 * @author Wayne.Zhong
 * @created Feb 13, 2012 12:11:39 PM
 */
@Service("categoryManagementService")
public class CategoryManagementService implements ICategoryManagementService {
    private final Logger logger = LoggerFactory.getLogger(CategoryManagementService.class);
	@Resource(name="categoryDao")
	private ICategoryDao categoryDao;

	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}

	public void delCategory() {
		// TODO Auto-generated method stub

	}

	public ExtJsonResponse <TreeResponseJsonModel> findCategoriesByParentId(String id) {
	    List <Category> categoryList = categoryDao.findCategoriesByParentId(id);
		logger.debug("Category Retrieved Number: " + categoryList.size() );
		List<TreeResponseJsonModel> treeResponseJsonModelList = null;
		if (categoryList != null){
		    treeResponseJsonModelList = getCategoryTreeJason(categoryList);
		}
		ExtJsonResponse <TreeResponseJsonModel> jsonResponse = new ExtJsonResponse<TreeResponseJsonModel>();
        if (treeResponseJsonModelList !=null){
            jsonResponse.setSuccess(true);
            jsonResponse.setData(treeResponseJsonModelList);
        } else {
            jsonResponse.setSuccess(false);
        } 
		return jsonResponse;
	}
	 

	/* (non-Javadoc)
     * @see com.bleum.canton.ca.category.service.ICategoryManagementService#getCategoryTreeJason(java.util.List)
     */
    public List<TreeResponseJsonModel> getCategoryTreeJason(List<Category> categoryList) {
        List<TreeResponseJsonModel> treeResponseJsonModelList = new 
                ArrayList <TreeResponseJsonModel> ();
        for (Category cat : categoryList){
            TreeResponseJsonModel treeResponseJsonModel = new TreeResponseJsonModel();
            treeResponseJsonModel.setId(cat.getCategoryID());
            treeResponseJsonModel.setText(cat.getCategoryName());
            treeResponseJsonModel.setCls("folder");
            treeResponseJsonModel.setLeaf(false); 
            treeResponseJsonModelList.add(treeResponseJsonModel);
        }
        // TODO Auto-generated method stub
        return treeResponseJsonModelList;
    }

    public Category findCategoryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void UpdateCategory(Category category) {
		// TODO Auto-generated method stub

	}
	
}
