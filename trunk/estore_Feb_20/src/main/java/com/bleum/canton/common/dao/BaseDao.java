package com.bleum.canton.common.dao;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;

import com.bleum.canton.common.entity.BaseEntity;

/**
 * base dao for common CRUD operation.
 * 
 * @author stephen.huang
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseEntity> {
	
	public T create(T entity) throws DataAccessException;

	public T retrieve (Serializable entityId) throws DataAccessException;
	
	public void update(T entity) throws DataAccessException;
	
	public void delete(T entity) throws DataAccessException;

}