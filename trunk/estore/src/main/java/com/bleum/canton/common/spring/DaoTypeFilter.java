package com.bleum.canton.common.spring;

import java.lang.annotation.Annotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;

/**
 * filter for DAO annotation.
 * 
 * @author stephen.huang
 *
 */
public class DaoTypeFilter extends AbstractTypeHierarchyTraversingFilter {

	private final Class<? extends Annotation> annotationType;

	protected DaoTypeFilter(Class<? extends Annotation> annotationType) {
		super(false, false);
		this.annotationType = annotationType;
	}

	@Override
	protected boolean matchSelf(MetadataReader metadataReader) {
		AnnotationMetadata metadata = metadataReader.getAnnotationMetadata();
		
		return metadata.getAnnotationTypes().contains(this.annotationType.getName());
	}
}
