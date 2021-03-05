package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired CommentsMapper dao;
	
	@Override
	public void insertComments(CommentsVO vo) {
		dao.insertComments(vo);
	}
	
	@Override
	public int deleteComments(CommentsVO vo) {
		return dao.deleteComments(vo);
	}


	@Override
	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}

	@Override
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return dao.getSearchComments(vo);
	}


}
