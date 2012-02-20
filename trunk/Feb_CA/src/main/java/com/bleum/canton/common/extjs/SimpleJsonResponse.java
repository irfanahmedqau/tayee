package com.bleum.canton.common.extjs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * It's a abstract class, defines the structure of the response for 
 * ExtJS application accessing. The response instance usually will be 
 * transformed to JSON String by framework.
 * @author 	sandro.xu
 * @version	1.0
 * @since	2/16/2012, V 1.0
 *
 */
public class SimpleJsonResponse<T> {

	/*
	 * 	Flag of the operation executed successfully or unsuccessfully
	 */
	private Boolean success;
	
	/*
	 *	The result set of the operation 
	 */
	private Collection<T> data;
	
	private ErrorInfo errors;


    /**
     * @return Returns the errors.
     */
    public ErrorInfo getErrors() {
        return errors;
    }

    /**
     * @param errors The errors to set.
     */
    public void setErrors(String errors) {
        ErrorInfo info = new ErrorInfo(errors);
        this.errors = info;
    }

    public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

}
