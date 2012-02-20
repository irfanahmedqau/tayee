package com.bleum.canton.common.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import com.bleum.canton.common.dao.DAO;

/**
 * override isCandidateComponent to allow DAO annotated interface can be an candidate.
 * 
 * @author stephen.huang
 *
 */
public class DaoComponentProvider extends
		ClassPathScanningCandidateComponentProvider {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public DaoComponentProvider(boolean useDefaultFilters) {
		super(useDefaultFilters);
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		if(logger.isDebugEnabled()){
			logger.debug("check candidate:"+beanDefinition.getBeanClassName());
		}

		if(beanDefinition.getMetadata().getAnnotationTypes().contains(DAO.class.getName())){
			return true;
		}
		return (beanDefinition.getMetadata().isConcrete() && beanDefinition.getMetadata().isIndependent());
	}

}
