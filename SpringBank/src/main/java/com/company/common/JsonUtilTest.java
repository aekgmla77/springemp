package com.company.common;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.company.board.service.BoardsVO;

public class JsonUtilTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JsonUtil json = new JsonUtil();
		Map<String, Object> map = new HashMap<>();
		map.put("username", "홍길동");
		map.put("age", "30");
		map.put("dept", "개발");
		String result = json.toJson(map);
		System.out.println(result);  //  map 은 vo랑 같음 List > 대괄호    map, vo   >   중괄호
									 // {"username" : "홍길동", "age" : 30, "dept" : "개발"}
		
		BoardsVO vo = new BoardsVO();
		vo.setContent("test");
		vo.setTitle("wow");
		vo.setWriter("me");
		result = json.toObjectJson(vo);
	}
}
