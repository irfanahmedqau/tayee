package com.bleum.canton.sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bleum.canton.common.extjs.QueryFilter;
import com.bleum.canton.common.extjs.RestQueryForm;
import com.bleum.canton.common.extjs.SimpleJsonResponse;
import com.bleum.canton.common.extjs.QuerySort;
import com.bleum.canton.sample.entity.User;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private static final String REST_USER_PAGE = "sample/restful1";
	
	//Create mock data source for User Entity
	private static final Map<String, User> userStore = new HashMap<String, User>();
	
	private static int idGenerator = 100;
	
	static {
		User ed = new User(String.valueOf(idGenerator++), "Ed", 50);
		User tommy = new User(String.valueOf(idGenerator++), "Tommy", 28);
		userStore.put(ed.getId(), ed);
		userStore.put(tommy.getId(), tommy);
	}
	
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String userView() {
		return REST_USER_PAGE;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public SimpleJsonResponse<User> saveUser(@RequestBody User user) {
		logger.debug("User name is [{}].", user.getUserName());
		logger.debug("User age is [{}].", user.getAge());
		user.setId(String.valueOf(idGenerator++));
		userStore.put(user.getId(), user);
		SimpleJsonResponse<User> json = new SimpleJsonResponse<User>();
		List<User> users = new LinkedList<User>();
		users.add(user);
		json.setData(users);
		json.setSuccess(true);
		return json;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public SimpleJsonResponse<User> loadUsers(RestQueryForm queryForm) {
		logger.debug("[limit]: {}", queryForm.getLimit().toString());
		logger.debug("[start]: {}", queryForm.getStart().toString());
		logger.debug("[page]: {}", queryForm.getPage().toString());
		List<QueryFilter> queryFilters = queryForm.getQueryFilters();
		for(QueryFilter queryFilter:queryFilters) {
			logger.debug("Query Filter [{}]: {}", new String[]{queryFilter.getProperty(),queryFilter.getValue()});
		}
		List<QuerySort> querySorts = queryForm.getQuerySorts();
		for(QuerySort querySort:querySorts) {
			logger.debug("Sort Filter [{}]: {}", new String[]{querySort.getProperty(),querySort.getDirection()});
		}
		
		List<User> users = new LinkedList<User>();
		users.addAll(userStore.values());
		SimpleJsonResponse<User> json = new SimpleJsonResponse<User>();
		json.setSuccess(true);
		json.setData(users);
		return json;
	}
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public SimpleJsonResponse<User> updateUser(@PathVariable String userId, @RequestBody User user) {
		logger.debug("User ID is [{}].", userId);
		logger.debug("User name is [{}].", user.getUserName());
		logger.debug("User age is [{}].", user.getAge());
		//Update information
		userStore.put(userId, user);
		
		List<User> users = new LinkedList<User>();
		users.add(user);
		SimpleJsonResponse<User> json = new SimpleJsonResponse<User>();
		json.setSuccess(true);
		json.setData(users);
		return json;
	}
	
}
