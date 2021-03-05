package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.emp.UsersVO;
import com.yedam.emp.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired UsersService userservice;
	
	//등록
	@PostMapping("/user")
	public UsersVO insertUsers(@RequestBody UsersVO vo) {
		userservice.insertUsers(vo);
		if(vo.getId().equals("0")) {
			return vo;
		} else {
		return userservice.getUsers(vo);
		}
	}
	
	//수정
	@PutMapping("/user")
	public UsersVO updateUsrs(@RequestBody UsersVO vo) {
		userservice.updateUsers(vo);
		return vo;
	}
	
	//삭제
	@DeleteMapping(value="/user/{id}")
	public Map deleteUsers(UsersVO vo, @PathVariable String id) {
		vo.setId(id);
		int r = userservice.deleteUsers(vo);
		return Collections.singletonMap("cnt", r);
	}
	
	//삭제
//	@DeleteMapping(value="/user")
//	public Map deleteUsers(@RequestBody UsersVO vo) {
//		int r = userservice.deleteUsers(vo);
//		return Collections.singletonMap("cnt", r);
//	}
	
	//단건
	@GetMapping("/user/{id}")
	public UsersVO getUsers(UsersVO vo, @PathVariable String id) {
		vo.setId(id);
		return userservice.getUsers(vo);
	}
	
	//전체
	@GetMapping("/user")
	public List<UsersVO> getSearchUsres(UsersVO vo){
		return userservice.getSearchUsers(vo);
	}
}
