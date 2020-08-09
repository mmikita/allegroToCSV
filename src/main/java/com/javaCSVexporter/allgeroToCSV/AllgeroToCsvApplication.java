package com.javaCSVexporter.allgeroToCSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan(basePackages= "com.javaCSVexporter")
@SpringBootApplication
public class AllgeroToCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllgeroToCsvApplication.class, args);
	}
	

}
