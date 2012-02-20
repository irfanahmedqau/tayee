package com.bleum.canton.common.dao.impl;

import java.util.Collection;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.IntroductionInterceptor;

import com.bleum.canton.common.dao.QueryExecutor;

/**
 * intercept query from dao interface.
 * 
 * @author stephen.huang
 *
 */
public class DaoInterceptor implements IntroductionInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		QueryExecutor<?> executor = (QueryExecutor<?>) methodInvocation.getThis();
		
		String methodName = methodInvocation.getMethod().getName();
		if(logger.isDebugEnabled()){
			logger.debug("in DaoInterceptor, execute-->" + methodName);
		}
				
		if (methodName.startsWith("find")) {
			Object[] arguments = methodInvocation.getArguments();
			List<?> results = executor.executeQuery(methodInvocation.getMethod(), arguments);
			boolean is_collection = methodInvocation.getMethod().getReturnType().isAssignableFrom(Collection.class);
			boolean is_array = methodInvocation.getMethod().getReturnType().isArray();
			if(logger.isDebugEnabled()){
				logger.debug("return type:" + methodInvocation.getMethod().getReturnType());
				logger.debug("is_collection:" + is_collection);
				logger.debug("is_array:" + is_array);
			}
			if(is_collection || is_array){
				return results;
			}
			return results.size() > 0 ? results.get(0): null;
		} else {
			return methodInvocation.proceed();
		}
	}

	public boolean implementsInterface(Class<?> intf) {
		return intf.isInterface() && QueryExecutor.class.isAssignableFrom(intf);
	}
}
