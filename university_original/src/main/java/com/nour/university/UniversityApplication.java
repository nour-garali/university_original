package com.nour.university;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nour.university.entities.University;
import com.nour.university.service.UniversityService;

@SpringBootApplication
public class UniversityApplication {

	@Autowired 
	UniversityService universityService;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	
	public void run(String... args) throws Exception {
		
		
		  universityService.saveUniversity(new University( "iset rades", "tunis", 65,new Date())); 
		  universityService.saveUniversity(new University("iset nabeul","nabeul", 65, new Date())); 
		  universityService.saveUniversity(new University("iset kelibia", "nabeul", 65, new Date()));
		 
	}

}
