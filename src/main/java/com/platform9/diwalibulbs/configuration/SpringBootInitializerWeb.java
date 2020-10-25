package com.platform9.diwalibulbs.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.platform9")
@SpringBootApplication
public class SpringBootInitializerWeb extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpringBootInitializerWeb.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitializerWeb.class, args);
	}

}
