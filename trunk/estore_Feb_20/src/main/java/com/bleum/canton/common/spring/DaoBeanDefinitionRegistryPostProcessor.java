package com.bleum.canton.common.spring;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.bleum.canton.common.dao.DAO;

/**
 * Post processor to auto register dao bean for DAO annotation.
 * 
 * @author stephen.huang
 *
 */
public class DaoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		if(logger.isDebugEnabled()){
			debug("Registered beans start");
			for(String s: bf.getBeanDefinitionNames()){
				debug(s);
			}
			debug("Registered beans end");
		}
	}
	
	/*
	<!--  Dao Layer instances -->
    <bean id="customerDao" parent="abstractDao" >
        <property name="proxyInterfaces" value="com.bleum.canton.myaccount.dao.ICustomerDao"/>
        <property name="target">
        	<bean parent="abstractDaoTarget">
        		<property name="type" value="com.bleum.canton.myaccount.entity.Customer"/>
            </bean>
        </property>
    </bean>
	 */
	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		debug("starting register dao bean...");
		
		DaoComponentProvider provider = new DaoComponentProvider(false);
		provider.resetFilters(false);
		provider.addIncludeFilter(new DaoTypeFilter(DAO.class));
		provider.setResourceLoader(new PathMatchingResourcePatternResolver());

		final Set<BeanDefinition> candidates = provider.findCandidateComponents("com.bleum.canton.*");
		debug("candidates size:"+candidates.size());
		for (BeanDefinition candidate : candidates) {
			debug("Registr bean for dao interface:"+candidate.getBeanClassName());
			
			AnnotatedBeanDefinition abd = (AnnotatedBeanDefinition) candidate;
			AnnotationMetadata meta = abd.getMetadata();
			
			Class<?> daoClass = null;
			
			String entityType = getEntityTypeName(meta);
			String clazz_name = candidate.getBeanClassName();
			if(entityType == null || entityType.equals("")){
				try {
					daoClass = Class.forName(clazz_name);
				} catch (ClassNotFoundException e) {
					logger.error("can not find class with name:" + clazz_name, e);
					continue;
				}
				Class<?> entityClass = getGenericClass(daoClass,0);
				entityType = entityClass.getName();
			}
			
			debug("entity type:"+entityType);

			BeanDefinition daoBean = buildBeanDefinition(clazz_name, entityType);
			
			//String beanName = this.beanNameGenerator.generateBeanName(candidate, this.registry);
			String beanName = getBeanName(meta);
			if(beanName == null || beanName.equals("")){
				beanName = daoClass.getSimpleName();
			}

			debug("beanName:"+beanName);
			
			registry.registerBeanDefinition(beanName, daoBean);
		}
		debug("done register dao bean...");
	}
	
	private String getBeanName(AnnotationMetadata meta){
		String name =  meta.getAnnotationAttributes(DAO.class.getName()).get("name").toString();
		return name;
	}
	
	private String getEntityTypeName(AnnotationMetadata meta){
		String type =  meta.getAnnotationAttributes(DAO.class.getName()).get("type").toString();
		return type;
	}
	
	private BeanDefinition buildBeanDefinition(String daoInterfaceName, String entityName){
		GenericBeanDefinition targetBean = new GenericBeanDefinition();
		targetBean.setParentName("abstractDaoTarget");
		targetBean.getPropertyValues().add("type", entityName);

		GenericBeanDefinition daoBean = new GenericBeanDefinition();
		daoBean.setParentName("abstractDao");
		daoBean.getPropertyValues().add("proxyInterfaces", daoInterfaceName);
		daoBean.getPropertyValues().add("target", targetBean);
		
		return daoBean;
	}
	
	private Class<?> getGenericClass(Class<?> clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if(clazz.isInterface()){
			genType = clazz.getGenericInterfaces()[0];
		}

		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();

			if ((params != null) && (params.length >= 0)) {
				return (Class<?>) params[index];
			}
		}
		return null;
	}
	
	private void debug(String s){
		if(logger.isDebugEnabled()){
			logger.debug(s);
		}
	}

}
