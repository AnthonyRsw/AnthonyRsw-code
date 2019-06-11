package com.pinjingjing.demo;

import org.mybatis.spring.annotation.MapperScan; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.pinjingjing.demo.mapper")  
public class SummaryApplication {  

	public static void main(String[] args) { 
		SpringApplication.run(SummaryApplication.class, args);
	}

}
