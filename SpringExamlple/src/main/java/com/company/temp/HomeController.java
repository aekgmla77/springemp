package com.company.temp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.temp.product.service.ProductService;
import com.company.temp.product.service.ProductVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired ProductService dao;
	
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
	
	@RequestMapping("/getSearchProduct") 
	public String getSearchProduct(ProductVO vo, Model model) {
		model.addAttribute("list", dao.getSearchProduct(vo));
		return "product/productList"; 
	}
	
	
	@RequestMapping("/insertForm") 
	public String insertProduct(ProductVO vo, Model model) {
		return "product/insertPro"; 
	}
	
	@PostMapping("/insertProduct")
	public String insertProductproc(ProductVO vo, Model model) {
		dao.insertProduct(vo);
		return "redirect:/getSearchProduct"; 
	}
	
}
