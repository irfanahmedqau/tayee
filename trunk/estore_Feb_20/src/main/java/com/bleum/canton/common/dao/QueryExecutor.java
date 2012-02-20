package com.bleum.canton.common.dao;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * common query executor, interceptor will call it to do the real query.
 * 
 * @author stephen.huang
 *
 * @param <T>
 */
public interface QueryExecutor<T extends BaseEntity> {
	
	public List<T> executeQuery(Method method, Object[] queryArgs) throws DataAccessException;

}