package com.nt.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.model.Tourist;
@Component
public class FindAllTestRunner2 implements CommandLineRunner {

	@Autowired
	private RestTemplate temp;
	@Override
	public void run(String... args) throws Exception {
		try {
			String Url="http://localhost:8081/BootRestPrj09-RestAPI-TouristMiniProject/tourist-api/show";
			//json
			ResponseEntity<String> resp=temp.getForEntity(Url, String.class);
			System.out.println("All json Data::"+resp.getBody());
			String content=resp.getBody();
			
			  //convert to objects 
			  ObjectMapper mapper=new ObjectMapper();
			  mapper.registerModule(new JavaTimeModule()); 
			  List<Tourist> tour=mapper.readValue(content,new com.fasterxml.jackson.core.type.TypeReference<List<Tourist>>(){});
			  System.out.println("All Converted Objects ::");
			  tour.forEach(x->System.out.println(x));
			 
			  //direct from json to objects
			  Class<? extends List> clazz=new ArrayList<Tourist>().getClass();
			  ResponseEntity<? extends List> list=temp.getForEntity(Url, clazz);
				System.out.println("All Direct Object Data::");
				list.getBody().forEach(x->System.out.println(x));
				
				//direct from json to objects
				  Class<? extends List> clazz1=new ArrayList<Tourist>().getClass();
				  ResponseEntity<? extends List> list1=temp.exchange(Url,HttpMethod.GET,null, clazz1);
					System.out.println("All Direct Object Data::");
					list1.getBody().forEach(x->System.out.println(x));
				
		}catch(Exception e) {
			System.out.println("App Error ::"+e.getMessage());
		}
System.exit(0);
	}

}
