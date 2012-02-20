package com.bleum.canton.sample.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 6375118592370832278L;

	private String id;
	
	private String userName;

	private Integer age;
	
	public User() {}

	public User(String id, String userName, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}