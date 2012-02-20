package com.bleum.canton.search.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchUtil {
	public static Class<?>[] EMPTY_CLASS = new Class<?>[0];
	public static Object[] EMPTY_OBJ = new Object[0];

	public static Object executeMethod(Object target, String method) throws IllegalArgumentException,
			SecurityException,
			IllegalAccessException,
			InvocationTargetException,
			NoSuchMethodException {
		return target.getClass().getMethod(method, null).invoke(target, null).toString();
	}

	@SuppressWarnings("static-access")
	public static void jsonDump(Object o) {
		//		System.out.println(new JSONObject().fromObject(o).toString(4));
	}

	public static boolean notEmpty(Collection<?> c) {
		return c != null && !c.isEmpty();
	}

	public static boolean notEmpty(String str) {
		return str != null && str.replace("^\\s*", "").length() > 0 && str.replace("\\s*$", "").length() > 0;
	}

	public static String toSetMethodName(String name) {
		return "set" + String.valueOf(name.charAt(0)).toUpperCase()
				+ name.substring(1);
	}

	public static int getPathDeepth(String path) {
		return path.replaceAll("[^\\/]", "").length();
	}

	public static String getPathParent(String path) {
		String res = "";
		String[] l = path.split("\\/");
		if (l.length > 2) {
			for (int i = 1; i < l.length - 1; i++) {
				res += "/" + l[i];
			}
		}
		return res;
	}

	public static String getPathRoot(String path) {
		String res = "";
		String[] l = path.split("\\/");
		if (l.length > 2) {
			res = "/" + l[1];
		}
		return res;
	}

	public static String getCurrentPathDisplayName(String path) {
		String res = "";
		String[] l = path.split("\\/");
		if (l.length > 0) {
			res = l[l.length - 1];
		}
		return res;
	}

	public static File getFile(String filePath) throws FileNotFoundException {
		File res = null;
		List<String> paths = new ArrayList<String>();
		paths.add(filePath);
		if (SearchUtil.class.getResource(filePath) != null) {
			paths.add(SearchUtil.class.getResource(filePath).getPath());
		}
		for (String path : paths) {
			try {
				res = new File(path);
				if (res.exists()) {
					return res;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		throw new FileNotFoundException("Can't find file dir [" + filePath + "]");
	}
}
