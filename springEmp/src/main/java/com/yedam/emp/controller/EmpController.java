package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {
	
	@Autowired EmpService empservice;
	@Autowired DeptService deptservice;
	@Autowired JobService jobservice;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/insertEmp")  //등록 페이지  //get, post 둘 다 가능
	public String insertEmp(EmpVO vo, Model model, DeptVO deptvo, JobVO jobvo) {
		deptvo.setStart(1);
		deptvo.setEnd(1000);
		model.addAttribute("deptList", deptservice.getSearchDept(deptvo));
		model.addAttribute("jobList", jobservice.getSearchJob(jobvo));
		return "/emp/insertEmp"; 
	}
	
	@PostMapping("/insertEmp") //등록 처리
	public String insertEmpProc(EmpVO vo) {
		empservice.insertEmp(vo);
		return "redirect:/getSearchEmp"; 
	}
	
	@RequestMapping("/deleteEmp") //삭제 처리
	public String deleteEmp(EmpVO vo) {
		empservice.deleteEmp(vo);
		return "redirect:/getSearchEmp"; 
	}
	
	@GetMapping("/updateEmp")  //수정 페이지
	public String updateEmp(EmpVO vo, Model model, DeptVO deptvo, JobVO jobvo) {  //모든 파라미터는 vo에 자동으로 들어옴
		model.addAttribute("deptList", deptservice.getSearchDept(deptvo));
		model.addAttribute("jobList", jobservice.getSearchJob(jobvo));
		model.addAttribute("empVO", empservice.getEmp(vo) );
		return "/emp/updateEmp"; 
	}
	
	@PostMapping("/updateEmp") //수정 처리
	public String updateEmpProc(EmpVO vo) {
		empservice.updateEmp(vo);
		return "redirect:/getSearchEmp"; 
	}
	
	@GetMapping("/getEmp") //단 건 조회
	public String getEmp(Model model
//						, HttpServletRequest request
//						, @RequestParam(value="id", 
//										required = false, 
//										defaultValue = "100"  ) String employee_id   // 아래 string __이랑 똑같음 required > null 값 여부 
//						, @PathVariable String employee_id
						, @ModelAttribute("employee") EmpVO vo
						) {
		//1. getParameter
//		String employee_id = request.getParameter("employee_id");
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(employee_id);
		
		model.addAttribute("emp", empservice.getEmp(vo) );
		return "/emp/getEmp"; 
	}
	
	@GetMapping("/getSearchEmp") //검색 조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5);  //한 페이지 표시되는 레코드 건수
		paging.setPageSize(3);  //페이지 번호
		//paging
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empservice.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", empservice.getSearchEmp(vo));
		return "/emp/getSearchEmp"; 
	}
}
