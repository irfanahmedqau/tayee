package com.bleum.canton.myaccount.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccDateUtil {
	
	private final static Logger logger = LoggerFactory.getLogger(MyAccDateUtil.class);
	
	private final static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	
	public static Date stringToDate(String string) {
		if (string == null || string.trim().length()== 0) {
			return null;
		}
		try {
			DateFormat fmt = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
			return fmt.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}

	public static String dateToString(Date date) {
		DateFormat fmt = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		if (date == null) {
			return "";
		} else {
			return fmt.format(date);
		}
	}
	
	public static java.sql.Date toSqlDate(Date date){
		if (date == null) {
			return null;
		}
		long miliseconds = date.getTime();
		return new java.sql.Date(miliseconds);
	}
	
	public static Date toUtilDate(java.sql.Date date) {
		if (date == null) {
			return null;
		}
		long miliseconds = date.getTime();
		return new Date(miliseconds);
	}
	
	public static java.sql.Timestamp toSqlTimestamp(Date date){
		if (date == null) {
			return null;
		}
		long miliseconds = date.getTime();
		return new java.sql.Timestamp(miliseconds);
	}
	
	public static java.sql.Timestamp toSqlTimestamp(String string){
		if (string == null|| string.trim().length()== 0) {
			return null;
		}
		try {
			DateFormat fmt = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
			Date date = fmt.parse(string);
			long miliseconds = date.getTime();
			return new java.sql.Timestamp(miliseconds);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
	
	/*
	public static String sqlTimestampToString(java.sql.Timestamp timestamp) {
		DateFormat fmt = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		if (timestamp == null) {
			return "";
		} else {
			return fmt.format(timestamp);
		}
	}
	*/

}
