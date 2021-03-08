package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UsersVO;
import com.yedam.emp.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired UsersService userservice;
	
	//등록
	@PostMapping("/insertuser")
	public ResponseEntity<Object> insertUsers(UsersVO vo) throws JsonProcessingException {
		userservice.insertUsers(vo);
		UsersVO userVO = userservice.getUsers(vo);
		if(userVO != null) {
			ObjectMapper mapper = new ObjectMapper(); //jackson 라이브러리 json
			return ResponseEntity.status(200).body( mapper.writeValueAsString(userVO) );
		} else {
			return ResponseEntity.status(500).body( "insert error" );
		}
		//return userservice.getUsers(vo);
	}
	
	//수정
	@PostMapping("/updateuser")
	public UsersVO updateUsrs(UsersVO vo) {
		userservice.updateUsers(vo);
		return vo;
	}
	
	//삭제
	@GetMapping(value="/deleteuser")
	public Map deleteUsers(UsersVO vo) {
		int r = userservice.deleteUsers(vo);
		return Collections.singletonMap("cnt", r);
	}
	
	
	//단건
	@GetMapping("/getuser")
	public UsersVO getUsers(UsersVO vo) {
		return userservice.getUsers(vo);
	}
	
	//전체
	@GetMapping("/getsearchuser")
	public List<UsersVO> getSearchUsres(UsersVO vo){
		return userservice.getSearchUsers(vo);
	}
}

