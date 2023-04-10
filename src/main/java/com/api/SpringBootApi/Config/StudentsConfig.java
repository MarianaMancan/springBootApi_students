package com.api.SpringBootApi.Config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.SpringBootApi.Model.Students;
import com.api.SpringBootApi.Repository.StudentsRepository;

@Configuration
public class StudentsConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentsRepository repository) {
		return args ->{
			Students Mariam = new Students(
                    1L,
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
                
				);
			Students Alex= new Students(
                    "alex",
                    "alex.jamal@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
                    
				);
			repository.saveAll(
					List.of(Mariam,Alex)
					);
		};
	}
}
