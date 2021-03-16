package com.company.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.temp.service.TestVO;

@Controller
public class TestController {
//	RequestMapping(post&get)
	//get, command 객체(VO)
	@PostMapping("/getTest1")
	public String getTest1(TestVO vo) {
		System.out.println(vo);
		return "home";
	}
	
	//파라미터
	@RequestMapping("/getTest2")
	public String getTest2(@RequestParam String firstName, @RequestParam int salary) {
		System.out.println(firstName + ":" + salary);
		return "home";
	}
	
	@RequestMapping("/getTest3")
	public String getTest3(@RequestParam("hobby") String[] hobbies) {
//		for(int i = 0; i < hobby.length; i++) {
//			System.out.println(hobby[i]);
//		};
		// 배열을 리스트로 변환 Arrays.asList
		System.out.println(Arrays.asList(hobbies));
		return "home";
	}
//	json은 get으로 안 됨.(나머지는 다 가능)
//	TestVO vo를 배열로 하려면 List<TestVO> 리스트로 감싸주기
//	TestVO 대신 List<Map>도 가능
	@RequestMapping("/getTest4")
	public String getTest4(@RequestBody List<Map> vo) {
		System.out.println(vo);
		return "home";
	}
	
//	get, post 상관없음
	@RequestMapping("/getTest5/{firstName}/{salary}")
	public String getTest5( Model model, 
							@PathVariable String firstName, 
							@PathVariable int salary, 
							@ModelAttribute("tvo") TestVO vo) {
		vo.setFirstName(firstName);
		vo.setSalary(salary);
		System.out.println(firstName + salary);
		model.addAttribute("firstName", firstName);
		return "test";
	}
	
	@RequestMapping("/getTest6/{firstName}/{salary}")
	public ModelAndView getTest6( @PathVariable String firstName, 
							@PathVariable int salary, 
							@ModelAttribute("tvo") TestVO vo) {
		vo.setFirstName(firstName);
		vo.setSalary(salary);
		ModelAndView mv = new ModelAndView();
		mv.addObject("firstName", firstName);
		mv.setViewName("test");
		return mv;
	}
	
	// 응답결과가 json인 경우
	@RequestMapping("/getTest7/{firstName}/{salary}")
	@ResponseBody
	public TestVO getTest7( @PathVariable String firstName, 
							@PathVariable int salary, 
							TestVO vo) {
		vo.setFirstName(firstName);
		vo.setSalary(salary);
		return vo;
	}
	
	@RequestMapping("/getTest8")
	@ResponseBody
	public List<Map> getTest8() {
		List list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("name", "kang");
		map.put("sal", "1000");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "lee");
		map.put("sal", "151515");
		list.add(map);
		
		return list;
	}
}
