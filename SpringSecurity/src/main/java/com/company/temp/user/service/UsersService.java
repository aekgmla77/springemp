package com.company.temp.user.service;

import java.util.List;

public interface UsersService {
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
	//로그인
	public boolean loginCheck(UsersVO vo);
	//password 변경
	public int updatePw(UsersVO vo);
}
