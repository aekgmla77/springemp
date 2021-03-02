package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empservice;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/insertEmp")  //등록 페이지
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp"; 
	}
	
	@PostMapping("/insertEmp") //등록 처리
	public String insertEmpProc(EmpVO vo) {
		return "redirect:/getSearchEmp"; 
	}
	
	@GetMapping("/updateEmp")  //수정 페이지
	public String updateEmp(EmpVO vo) {
		return "/emp/updateEmp"; 
	}
	
	@PostMapping("/updateEmp") //수정 처리
	public String updateEmpProc(EmpVO vo) {
		return "redirect:/getSearchEmp"; 
	}
	
	@GetMapping("/getEmp") //단 건 조회
	public String getEmp(EmpVO vo) {
		return "/emp/getEmp"; 
	}
	
	@GetMapping("/getSearchEmp") //검색 조회
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empservice.getSearchEmp(vo));
		return "/emp/getSearchEmp"; 
	}
}
