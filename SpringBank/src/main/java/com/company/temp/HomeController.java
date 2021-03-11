package com.company.temp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//페이지 이동
	@GetMapping("/getBiz")
	public String getBizForm() {
		return "bank/getBiz";
	}
	
	//크롤링 결과 조회
	@PostMapping("/getBiz")
	public String getBiz(@RequestParam String bizno, Model model) throws IOException {  //VO, Map, String
		//크롤링
		String uri = "https://bizno.net/?query=" + bizno;
		Document doc = Jsoup.connect(uri).get();
		Elements element = doc.select(".titles > a > h4");
		bizno = element.text();
		//회사이름 찾아서 
		model.addAttribute("bizname", element);
		
		return "bank/getBiz";
	}
}
