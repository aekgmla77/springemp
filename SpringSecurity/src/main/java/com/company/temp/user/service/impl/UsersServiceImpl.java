package com.company.temp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.temp.user.service.UsersService;
import com.company.temp.user.service.UsersVO;


@Service("userService")
public class UsersServiceImpl implements UsersService, UserDetailsService {

	@Autowired
	UsersMapper dao;

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

	@Override
	public boolean loginCheck(UsersVO vo) {
		// 단건조회
		UsersVO uservo = dao.getUsers(vo);
		// id 일치하는지 확인
		if (uservo == null) {
			return false;
		}
		// pw 일치 확인
		if (uservo.getPassword().equals(vo.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updatePw(UsersVO vo) {
		//단건 조회
		UsersVO uservo = dao.getUsers(vo);
		//기존 패스워드 일치 확인
		if(uservo.getPassword().equals(vo.getOldpassword())) {
	    //패스워드 업데이트
//			vo.getPassword().equals(vo.getNewpass());
			return dao.updateUsers(vo);
		} else {
			return 0;
		}
	}

	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("============================= userservice 실행");
		UsersVO uservo = new UsersVO();
		uservo.setId(username);
		uservo = dao.getUsers(uservo);
		
		if(uservo == null) {
			System.out.println();
			throw new UsernameNotFoundException("no user");
	
		}
		
		return uservo;
	}
}
