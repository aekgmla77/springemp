package com.yedam.board.controller;

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

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@RestController   // responsebody를 하나하나 해주기 싫으면 controller 앞에 rest 붙이기
public class CommentsController {
	
	@Autowired CommentsService commentservice;
	
	//등록처리
	@PostMapping("/comments")
	public CommentsVO insertComments(@RequestBody CommentsVO vo) {
		commentservice.insertComments(vo);
		if(vo.getId().equals("0")) {
			return vo;
		} else {
		return commentservice.getComments(vo);
		}
	}
	//삭제
	@DeleteMapping(value = "/comments")  // method = RequestMethod.DELETE, @PathVariable String id > 이거 빼면 다건삭제
	public Map deleteComments(@RequestBody CommentsVO vo
//							, @PathVariable String id
			) {
//		vo.setId(id);
		int r = commentservice.deleteComments(vo);
		return Collections.singletonMap("cnt", r);
	}
	
	//수정 처리
	@PutMapping("/comments")
	public CommentsVO updateComments(@RequestBody CommentsVO vo) { //@RequestBody >> json으로 변환시켜주는 거
		System.out.println("********"+vo);
		return vo;
	} 
	
	//게시글의 댓글 조회
	@GetMapping("/comments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentservice.getSearchComments(vo);
	}
	
	//단 건 조회
	@GetMapping("/comments/{id}")
	public CommentsVO getComments(CommentsVO vo, @PathVariable String id) {
		vo.setId(id);
		return commentservice.getComments(vo);
	}
}
