package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.model.Tourist;
//@Component
public class FindByIdTestRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate temp;
	@Override
	public void run(String... args) throws Exception {
		try {
			String Url="http://localhost:8081/BootRestPrj09-RestAPI-TouristMiniProject/tourist-api/find/{id}";
			//json
			ResponseEntity<String> resp=temp.getForEntity(Url, String.class,2100);
			System.out.println("String json Data ::"+resp.getBody());
			
			//object
			ResponseEntity<Tourist> t=temp.getForEntity(Url, Tourist.class,2100);
			System.out.println("Direct Object Data::"+t);
			
			//object
			String jsonContent=resp.getBody();
			ObjectMapper mapper=new ObjectMapper();
			mapper.registerModule((new JavaTimeModule()));
			Tourist tourist=mapper.readValue(jsonContent, Tourist.class);
			System.out.println("Converted Object Data::"+tourist);
			
		}catch(Exception e) {
			System.out.println("App Error ::"+e.getMessage());
		}
System.exit(0);
	}

}
