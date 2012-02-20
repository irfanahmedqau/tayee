package com.bleum.canton.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import com.bleum.canton.common.dao.BaseDao;
import com.bleum.canton.common.dao.QueryExecutor;
import com.bleum.canton.common.entity.BaseEntity;

/**
 * hibernate impl for base dao interface.
 * 
 * @author stephen.huang
 *
 * @param <T>
 */
public class BaseDaoHibernateImpl<T extends BaseEntity> extends BaseDaoSupport<T> implements
		BaseDao<T>, QueryExecutor<T> {

	@Resource(name = "estoreSessionFactory")
	protected SessionFactory sessionFactory;

	/**
	 * create a new entity.
	 * 
	 * @param entity transient instance of a entity class
	 * @return the identity of this new created entity instance
	 */
	public T create(T entity) throws DataAccessException {
		entity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		getSession().save(entity);
		return entity;
	}

	/**
	 * find entity instance with identity.
	 * 
	 * @return entity instance
	 */
	@SuppressWarnings("unchecked")
	public T retrieve (Serializable entityId) throws DataAccessException {
		return (T) getSession().get(getType(), entityId);
	}

	/**
	 * update detached entity instance
	 */
	public void update(T entity) throws DataAccessException {
		entity.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
		getSession().update(entity);
	}

	/**
	 * delete entity instance
	 */
	public void delete(T entity) throws DataAccessException {
		getSession().delete(entity);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<T> executeQuery(Method method, Object[] queryArgs)
			throws DataAccessException {
		final Query namedQuery = prepareQuery(method, queryArgs);
		return (List<T>) namedQuery.list();
	}

	private Query prepareQuery(Method method, Object[] queryArgs) {
		final String queryName = queryNameFromMethod(getType(), method);
		
		if(logger.isDebugEnabled()){
			logger.debug("query name:" + queryName);
		}
		
		final Query namedQuery = getSession().getNamedQuery(queryName);
		String[] namedParameters = namedQuery.getNamedParameters();
		if (namedParameters.length == 0) {
			setPositionalParams(queryArgs, namedQuery);
		} else {
			setNamedParams(namedParameters, queryArgs, namedQuery);
		}
		return namedQuery;
	}

	private String queryNameFromMethod(Class findTargetType, Method finderMethod) {
		return findTargetType.getSimpleName() + "." + finderMethod.getName();
	}

	private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];
				namedQuery.setParameter(i, arg);
			}
		}
	}

	private void setNamedParams(String[] namedParameters, Object[] queryArgs,
			Query namedQuery) {
		if (queryArgs != null) {
			for (int i = 0; i < queryArgs.length; i++) {
				Object arg = queryArgs[i];

				if (arg instanceof Collection) {
					namedQuery.setParameterList(namedParameters[i],
							(Collection) arg);
				} else {
					namedQuery.setParameter(namedParameters[i], arg);
				}

			}
		}
	}
}
