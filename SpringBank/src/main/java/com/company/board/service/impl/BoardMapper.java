package com.company.board.service.impl;

import com.company.board.service.BoardsVO;

public interface BoardMapper {
	
	public int insertBoard(BoardsVO vo);
	
	public BoardsVO getBoard(BoardsVO vo);
}
