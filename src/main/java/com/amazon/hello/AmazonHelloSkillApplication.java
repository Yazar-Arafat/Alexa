package com.amazon.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonHelloSkillApplication //extends SpringBootServletInitializer {
{

	public static void main(String[] args) {
		SpringApplication.run(AmazonHelloSkillApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(AmazonHelloSkillApplication.class);
//	}
	

}
