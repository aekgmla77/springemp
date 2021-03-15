package com.company.temp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.temp.product.service.ProductService;
import com.company.temp.product.service.ProductVO;
import com.company.temp.sales.service.SalesService;
import com.company.temp.sales.service.SalesVO;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	@Autowired ProductService dao;
	@Autowired SalesService saledao;
	@Autowired MovieAPI movieapi;
	
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
	
	@RequestMapping("/getProduct") 
	@ResponseBody
	public ProductVO getProduct(ProductVO vo) {
		return dao.getProduct(vo);
	}
	
	@PostMapping("/insertSale")
	@ResponseBody
	public int insertSale(SalesVO vo) {
		System.out.println(vo);
		return saledao.insertSale(vo);
	}
	
	@RequestMapping("/directors")
	@ResponseBody
	public List<String> movieActor() {
		List<String> list = new ArrayList<>();
		Map map =  movieapi.getmovieInfo();
		Map movieInfoResult = (Map) map.get("movieInfoResult");
		Map movieInfo = (Map) movieInfoResult.get("movieInfo");
		List<Map> directors = (List<Map>) movieInfo.get("directors");
		for(Map ac : directors) {
			list.add((String) ac.get("peopleNm"));
		}
		return list;
	}
}
