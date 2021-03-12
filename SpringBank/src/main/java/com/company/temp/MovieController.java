package com.company.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.common.MovieAPI;

@Controller
public class MovieController {
	
	@Autowired MovieAPI movieapi;

	@RequestMapping("/boxOffice")
	@ResponseBody
	public List<String> boxOffice() {
		List<String> list = new ArrayList<>();
		Map map =  movieapi.getBoxOffice();
		Map boxOfficeResult = (Map) map.get("boxOfficeResult");
//		배열은 List<Map>으로 돌려줌     
//		[] > list , {} > vo, map
		List<Map> dailyBoxOfficeList = (List<Map>) boxOfficeResult.get("dailyBoxOfficeList");
		for(Map movie : dailyBoxOfficeList) {
			list.add((String) movie.get("movieNm") + ":" + (String) movie.get("movieCd"));
		}
		return list;
	}
	
	@RequestMapping("/movieActor")
	@ResponseBody
	public List<String> movieActor() {
		List<String> list = new ArrayList<>();
		Map map =  movieapi.getmovieInfo();
		Map movieInfoResult = (Map) map.get("movieInfoResult");
		Map movieInfo = (Map) movieInfoResult.get("movieInfo");
		List<Map> actors = (List<Map>) movieInfo.get("actors");
		for(Map ac : actors) {
			list.add((String) ac.get("peopleNm") + ":" + (String) ac.get("peopleNmEn"));
		}
		return list;
	}
}
