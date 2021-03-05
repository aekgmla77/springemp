package com.yedam.board.service;

import java.util.List;

public interface CommentsService {
	//입력
	public void insertComments(CommentsVO vo);
		
	//삭제
	public int deleteComments(CommentsVO vo);
		
	//단건 조회
	public CommentsVO getComments(CommentsVO vo);
		
	//전체 조회
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
