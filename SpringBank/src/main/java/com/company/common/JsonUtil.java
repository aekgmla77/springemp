package com.company.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtil {
	public String toJson(Map<String,Object> map) {
		StringBuilder result= new StringBuilder();
		boolean start = true;
		result.append("{");
		// Set > 순서를 유지하지 않는 데이터 집합(ierator 시켜야 순차적으로 됨),   List는 순서를 유지하는 데이터의 집합
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			String value = (String) map.get(key);
			if(! start) {
				result.append(",");
			} else {
				start = false;
			}
			result.append("\"" + key + "\"" + ":" + "\"" + value + "\"");
		}
		result.append("}");
		
		return result.toString();
	}
	
	public String toJson(List<Map<String, Object>> map) {
		StringBuilder result = new StringBuilder();
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		result.append("{");
//		while(keys.hasNext()) {
//			Map<String, Object> key = keys.next();
//			String value = (String)map.get(key);
//		}
		return result.toString();
	}
	
	public String toObjectJson(Object vo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String result = "";
		Field[] fields = vo.getClass().getDeclaredFields();
		for(Field field : fields) {
			String fieldName = field.getName();
			String method = "get" + field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1);
			Method m = vo.getClass().getDeclaredMethod(method, null);
			String value = (String) m.invoke(vo, null);
			System.out.print("{");
			System.out.print("\"" + fieldName + "\"" + ":" + "\"" + value + "\"");
			System.out.print("}" + ",");
		}
		return result.toString();		
	}
	
	public String toObjectJson(List<Object> vo) {
		String result = "";
		return result;
	}
	
}
