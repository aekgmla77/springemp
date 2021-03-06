package com.company.temp.user.service.impl;

import java.util.List;

import com.company.temp.user.service.UsersVO;

public interface UsersMapper {
	//등록
	public int insertUsers(UsersVO vo);
	//수정
	public int updateUsers(UsersVO vo);
	//삭제
	public int deleteUsers(UsersVO vo);
	//단건
	public UsersVO getUsers(UsersVO vo);
	//전체
	public List<UsersVO> getSearchUsers(UsersVO vo);
	
}
