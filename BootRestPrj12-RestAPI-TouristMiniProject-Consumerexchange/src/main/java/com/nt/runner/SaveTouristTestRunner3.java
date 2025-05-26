package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class SaveTouristTestRunner3 implements CommandLineRunner {

	@Autowired
	private RestTemplate temp;
	@Override
	public void run(String... args) throws Exception {
		try {
			String Url="http://localhost:8081/BootRestPrj09-RestAPI-TouristMiniProject/tourist-api/add";
			String json_body="{\"tname\":\"Ravi\",\"taddrs\":\"Bdp\",\"tmobile\":9949703543,\"tdob\":\"1969-01-01\"}";
			org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request=new HttpEntity<String>(json_body, headers);
			
			//json
			ResponseEntity<String> resp=temp.postForEntity(Url,request, String.class);
			System.out.println("Result is::"+resp.getBody());
			
				
		}catch(Exception e) {
			System.out.println("App Error ::"+e.getMessage());
		}
System.exit(0);
	}

}
