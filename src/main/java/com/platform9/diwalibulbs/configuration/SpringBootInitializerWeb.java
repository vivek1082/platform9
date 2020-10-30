package com.platform9.diwalibulbs.configuration;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import com.platform9.diwalibulbs.controller.TerminalController;
import com.platform9.diwalibulbs.dto.MaxSparkedBulb;
import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbArraySizeInputException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;
import com.platform9.diwalibulbs.exception.NoInputFIleException;
import com.platform9.diwalibulbs.utility.FileUtility;

@ComponentScan("com.platform9")
@SpringBootApplication
public class SpringBootInitializerWeb implements CommandLineRunner {

	@Autowired
	TerminalController terminalController;

	public static void main(String[] args) throws BadBulbsFileException, BadSwitchInputException,
			BadOnOffInputException, BadBulbArraySizeInputException, ArgumentMismatchException {
		SpringApplication.run(SpringBootInitializerWeb.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		try {
			if (args.length == 0 || args.length > 1)
				throw new NoInputFIleException("Input FIle not provided. Please PAss input file");

			File file = new File(args[0]);
			if (!file.exists())
				throw new NoInputFIleException("FIle does not exist at location");
			OutputBulbList responseEntity = null;

			responseEntity = terminalController.showLightBulbs(file);
			for (MaxSparkedBulb maxSparkedBulb : responseEntity.getOutput()) {
				System.out.println("Maximum number of ON Bulbs for input " +maxSparkedBulb.getGivenInput()+" will be " + maxSparkedBulb.getMaxOnBulbs());
				System.out.println("Bulb positions");
				for (Integer integer : maxSparkedBulb.getBulbPosition()) {
					System.out.println(integer);
				}
			}
			
		} catch(Exception e) {
			System.out.println("Exception while processing " + e.getMessage() + " " + e.getClass());
			
		} finally {
			System.out.println("Exiting System");
			System.exit(-1);
		}
		

	}

}
