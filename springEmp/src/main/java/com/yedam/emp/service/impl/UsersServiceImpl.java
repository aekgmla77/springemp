package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UsersVO;
import com.yedam.emp.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired UsersMapper dao;
	
	@Override
	public int insertUsers(UsersVO vo) {
		return dao.insertUsers(vo);
	}

	@Override
	public int updateUsers(UsersVO vo) {
		return dao.updateUsers(vo);
	}

	@Override
	public int deleteUsers(UsersVO vo) {
		return dao.deleteUsers(vo);
	}

	@Override
	public UsersVO getUsers(UsersVO vo) {
		return dao.getUsers(vo);
	}

	@Override
	public List<UsersVO> getSearchUsers(UsersVO vo) {
		return dao.getSearchUsers(vo);
	}

}
