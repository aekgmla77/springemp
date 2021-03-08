package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.ChangePwdCommandValidator;
import com.yedam.emp.UsersVO;
import com.yedam.emp.service.UsersService;

@Controller
public class LoginController {
	
	@Resource UsersService userservice;
	
	@GetMapping("/changePw")
	public String changePw() {
		return "user/changePw";
	}
	
	//패스워드 변경처리
	@PostMapping("/changePw")
	public String changePwProc(UsersVO vo, BindingResult errors, HttpSession session) {
		//validation 일치여부 확인
		new ChangePwdCommandValidator().validate(vo, errors);
		if(vo.getPassword().equals(vo.getNewpass())) {
			return "user/changePw";
		}
		else if(errors.hasErrors()) {
			return "user/changePw";
		}
		//패스워드 변경 서비스
		String id = (String) session.getAttribute("loginid");
		vo.setId(id);
		userservice.updatePw(vo);
		return "user/changePw";
	}
	
	//login page
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//login 처리
	@PostMapping("/login")
	public String loginproc(UsersVO vo, HttpSession session) {
		if (userservice.loginCheck(vo)){  //login success
			//세션에 저장
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		} else {  //login fail
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //session 무효화
		return "redirect:/";
	}
}
