package com.company.common;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
@Service
public class BankAPI {
	
	String host = "https://testapi.openbanking.or.kr";
	String client_id = "0edcd4e7-bf0e-4e45-b783-f238b4a8aa56";
	String client_secret = "d6d418f7-61a6-44b0-b892-ef38494199c6";
	String redirect_uri = "http://localhost/temp/callback";

	// bank token 
		public Map<String, Object> getAccessToken (String authorize_code) {
	        String reqURL = host + "/oauth/2.0/authorize_account";
	        Map<String, Object> map = new HashMap<String, Object>();
	        String access_Token;
	        String refresh_Token;
	        
	        try {
	            URL url = new URL(reqURL);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            
	            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	            StringBuilder sb = new StringBuilder();
	            sb.append("code=").append(authorize_code);
	            sb.append("&client_id=").append(client_id);
	            sb.append("&client_secret=").append(client_secret);
	            sb.append("&redirect_uri=").append(redirect_uri);
	            sb.append("&grant_type=authorization_code");
	            bw.write(sb.toString());
	            bw.flush();
	            
	            //    결과 코드가 200이라면 성공
	            int responseCode = conn.getResponseCode();
	            System.out.println("responseCode : " + responseCode);
	 
	            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line = "";
	            String result = "";
	            
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("response body : " + result);
	            
	            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
	            Gson gson = new Gson();
	            map = gson.fromJson(sb.toString(), Map.class);
//	            JsonParser parser = new JsonParser();
//	            JsonElement element = parser.parse(result);
	            
//	            access_Token = element.getAsJsonObject().get("access_token").getAsString();
//	            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
//	            
//	            
//	            System.out.println("access_token : " + access_Token);
//	            System.out.println("refresh_token : " + refresh_Token);
//	            
//	            br.close();
//	            bw.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	        
	        return map;
	    }
		
		
		//userinfo
		public HashMap<String, Object> getAccountList(String access_token, String use_num) throws Exception{
			HashMap<String, Object> map = new HashMap<>();
		    String reqURL = host + "/v2.0/account/list";
		    StringBuilder qstr = new StringBuilder();
			qstr.append("user_seq_no=" + use_num)
				.append("&include_cancel_yn=" + "Y")
				.append("&sort_order=" + "D" );
		    try {
		        URL url = new URL(reqURL + "?" + qstr);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        
		        // 요청에 필요한 Header에 포함될 내용
		        conn.setRequestProperty("Authorization", "Bearer " + access_token);
		        // 출력되는 값이 200이면 정상작동
		        int responseCode = conn.getResponseCode();
		        System.out.println("responseCode : " + responseCode);
		        
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println("response body : " + result);
		        
		        //String -> map에 담아서 return
		        JsonMapper mapper = new JsonMapper();
		        map = mapper.readValue(result, HashMap.class);
		        //userInfo.put("email", email);
		        
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    
		    return map;
		}
		
		public String getDate() {
			String str = "";
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
			str = format.format(date);
			return str;
		}
		
		public String getRend2() {
			long time = System.currentTimeMillis();
			String str = Long.toString(time);
			String str2 = Long.toString(time);
			String str3 = Long.toString(time);
			return str + str2 +str3.substring(str3.length()-6);
		}
		
		public String getRand() {
			long time = System.currentTimeMillis();
			String str = Long.toString(time);
			return str.substring(str.length()-9);
		}
		
		
		public HashMap<String, Object> getBalance(BankVO vo) throws Exception{
			HashMap<String, Object> map = new HashMap<>();
		    String reqURL = host + "/v2.0/account/balance/fin_num";
		    StringBuilder qstr = new StringBuilder();
		    String use_org_code = "M202111672";
			qstr.append("bank_tran_id=").append(use_org_code + "U" + getRand())
				.append("&fintech_use_num=" + vo.getFintech_use_num())
				.append("&tran_dtime=").append(getDate());
		    try {
		        URL url = new URL(reqURL + "?" + qstr);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        
		        // 요청에 필요한 Header에 포함될 내용
		        conn.setRequestProperty("Authorization", "Bearer " + vo.getAccess_token());
		        // 출력되는 값이 200이면 정상작동
		        int responseCode = conn.getResponseCode();
		        System.out.println("responseCode : " + responseCode);
		        System.out.println(getRend2());
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println("response body : " + result);
		        
		        //String -> map에 담아서 return
		        JsonMapper mapper = new JsonMapper();
		        map = mapper.readValue(result, HashMap.class);
		        //userInfo.put("email", email);
		        
		    } catch (Exception e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		    
		    return map;
		}
		
		public Map<String, Object> getOrgAccessToken () {
	        String reqURL = host + "/oauth/2.0/token";
	        Map<String, Object> map = new HashMap<String, Object>();
	        String access_Token;
	        String refresh_Token;
	        
	        try {
	            URL url = new URL(reqURL);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	            
	            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
	            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	            StringBuilder sb = new StringBuilder();
	            sb.append("client_id=").append(client_id);
	            sb.append("&client_secret=").append(client_secret);
	            sb.append("&scope=oob");
	            sb.append("&grant_type=client_credentials");
	            bw.write(sb.toString());
	            bw.flush();
	            
	            //    결과 코드가 200이라면 성공
	            int responseCode = conn.getResponseCode();
	            System.out.println("responseCode : " + responseCode);
	 
	            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line = "";
	            String result = "";
	            
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("response body : " + result);
	            
	            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
	            Gson gson = new Gson();
	            map = gson.fromJson(result, Map.class);
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	        
	        return map;
	    }
		
		public Map<String, Object> getOrgAccessTokenRestTemplate () {
			String reqURL = host + "/oauth/2.0/token";
	        Map<String, Object> map = null;
	        
	        StringBuilder sb = new StringBuilder();
            sb.append("client_id=").append(client_id);
            sb.append("&client_secret=").append(client_secret);
            sb.append("&scope=oob");
            sb.append("&grant_type=client_credentials");
            
            RestTemplate restTemplate = new RestTemplate();
            
	        return map;
			
			
		}
}
