/**
 * 
 */
package com.bleum.canton.common.dao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class is a "dao" and will register a bean accordingly.
 *
 * @author stephen.huang
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DAO {

	/**
	 * The dao bean name
	 */
	String name() default "";
	
	String type() default "";

}