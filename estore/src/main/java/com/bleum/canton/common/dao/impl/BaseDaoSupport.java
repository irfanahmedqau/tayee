package com.bleum.canton.common.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * support class for base dao, may put some other concern in here.
 * 
 * @author stephen.huang
 *
 * @param <T>
 */
public class BaseDaoSupport<T> {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Class type;

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}

	public void init() {
		if (type == null) {
			type = getGenericClass(this.getClass(), 0);
		}
	}

	private Class<?> getGenericClass(Class<?> clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();

			if ((params != null) && (params.length >= 0)) {
				return (Class<?>) params[index];
			}
		}
		return null;
	}

}
