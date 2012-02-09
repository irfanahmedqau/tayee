package com.bleum.canton.ca.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ExtHelper {
	public static String getJsonFromList(long recordTotal, List beanList){
		TotalJson total = new TotalJson();
		total.setResults(recordTotal);
		total.setItems(beanList);
		JSONObject jsonArray = JSONObject.fromObject(total);
		return jsonArray.toString();
	}
	
	public static String listToJsonArray(List obj){
		JSONArray json = JSONArray.fromObject(obj);
		return json.toString();
	}
}
