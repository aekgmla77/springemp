package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {
	
	@Autowired DeptService deptservice;
	
	@GetMapping("/insertDept")  //등록 페이지
	public String insertDept(DeptVO vo) {
		return "/dept/insertDept"; 
	}
	
	@PostMapping("/insertDept") //등록 처리
	public String insertDeptProc(DeptVO vo) {
		deptservice.insertDept(vo);
		return "redirect:/getSearchDept"; 
	}
	
	@RequestMapping("/deleteDept") //삭제 처리
	public String deleteDept(DeptVO vo) {
		deptservice.deleteDept(vo);
		return "redirect:/getSearchDept"; 
	}
	
	@GetMapping("/updateDept")  //수정 페이지
	public String updateDept(DeptVO vo, Model model) {  //모든 파라미터는 vo에 자동으로 들어옴
		model.addAttribute("deptVO", deptservice.getDept(vo) );
		return "/dept/updateDept"; 
	}
	
	@PostMapping("/updateDept") //수정 처리
	public String updateDeptProc(DeptVO vo) {
		deptservice.updateDept(vo);
		return "redirect:/getSearchDept"; 
	}
	
	@GetMapping("/getDept") //단 건 조회
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptservice.getDept(vo) );
		return "/dept/getDept"; 
	}
	
	@GetMapping("/getSearchDept") //검색 조회
	public String getSearchDept(DeptVO vo, Paging paging, Model model) {
		paging.setPageUnit(5);  //한 페이지 표시되는 레코드 건수
		paging.setPageSize(3);  //페이지 번호
		//paging
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(deptservice.getDcount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", deptservice.getSearchDept(vo));
		return "/dept/getSearchDept"; 
	}
}
