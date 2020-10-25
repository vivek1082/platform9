package com.platform9.diwalibulbs.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.platform9.diwalibulbs.controller.TerminalController;
import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbArraySizeInputException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;

@ComponentScan("com.platform9")
@SpringBootApplication
public class SpringBootInitializerWeb extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpringBootInitializerWeb.class);
	}

	public static void main(String[] args) throws BadBulbsFileException, BadSwitchInputException,
			BadOnOffInputException, BadBulbArraySizeInputException, ArgumentMismatchException {
		SpringApplication.run(SpringBootInitializerWeb.class, args);

	}

}
