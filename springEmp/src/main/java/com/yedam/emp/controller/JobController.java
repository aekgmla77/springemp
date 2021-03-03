package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Controller
public class JobController {
	
	@Autowired JobService jobservice;
	
	@GetMapping("/insertJob")  //등록 페이지
	public String insertJob(JobVO vo) {
		return "/job/insertJob"; 
	}
	
	@PostMapping("/insertJob") //등록 처리
	public String insertJobProc(JobVO vo) {
		jobservice.insertJob(vo);
		return "redirect:/getSearchJob"; 
	}
	
	@RequestMapping("/deleteJob") //삭제 처리
	public String deleteJob(JobVO vo) {
		jobservice.deleteJob(vo);
		return "redirect:/getSearchJob"; 
	}
	
	@GetMapping("/updateJob")  //수정 페이지
	public String updateJob(JobVO vo, Model model) {  //모든 파라미터는 vo에 자동으로 들어옴
		model.addAttribute("jobVO", jobservice.getJob(vo) );
		return "/job/updateJob"; 
	}
	
	@PostMapping("/updateJob") //수정 처리
	public String updateJobProc(JobVO vo) {
		jobservice.updateJob(vo);
		return "redirect:/getSearchJob"; 
	}
	
	@GetMapping("/getJob") //단 건 조회
	public String getJob(JobVO vo, Model model) {
		model.addAttribute("job", jobservice.getJob(vo) );
		return "/job/getJob"; 
	}
	
	@GetMapping("/getSearchJob") //검색 조회
	public String getSearchJob(JobVO vo, Model model) {
		model.addAttribute("list", jobservice.getSearchJob(vo));
		return "/job/getSearchJob"; 
	}
}
