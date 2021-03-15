package com.company.temp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.common.BoardVO;

@Controller
// view > string, 나머지 > @ResponseBody
public class BoardController {
	@RequestMapping("/insertBoard")
	public String insertBoard(BoardVO vo) {
		System.out.println(vo);
		return "insertBoardResult";
	}
	
	@RequestMapping("ajaxInsertBoard")
	@ResponseBody
	public BoardVO ajaxInsertBoard(BoardVO vo) {
		System.out.println(vo);
		return vo;
	}
}
