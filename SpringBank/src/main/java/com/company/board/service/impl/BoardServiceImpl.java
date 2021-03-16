package com.company.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.board.service.BoardsVO;

@Service
public class BoardServiceImpl implements BoardMapper{

	@Autowired BoardMapper boardmapper;
	
	@Override
	public int insertBoard(BoardsVO vo) {
		return boardmapper.insertBoard(vo);
	}

	@Override
	public BoardsVO getBoard(BoardsVO vo) {
		return boardmapper.getBoard(vo);
	}
}
