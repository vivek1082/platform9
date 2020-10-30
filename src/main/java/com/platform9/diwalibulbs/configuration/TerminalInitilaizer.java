package com.platform9.diwalibulbs.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.platform9.diwalibulbs.controller.TerminalController;
import com.platform9.diwalibulbs.dto.MaxSparkedBulb;
import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbArraySizeInputException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;

//@Component
public class TerminalInitilaizer {

	@Autowired
	TerminalController terminalController;

	@PostConstruct
	public void init() throws BadBulbsFileException, BadSwitchInputException, BadOnOffInputException,
			BadBulbArraySizeInputException, ArgumentMismatchException {
		ResponseEntity<OutputBulbList> responseEntity = null;
		try {
			responseEntity = terminalController.showLightBulbs();
		} catch (Exception e) {
			//Doing dirty work here 
			//TO-DO : fix it
			System.out.println("Error caused while processing : "+ e.getClass() +" "+ e.getMessage() );
			System.out.println("Abrupty exiting system for a while, till Rest COntrollers code are not up");
			System.exit(-1);
		}
		
		OutputBulbList bulbList = responseEntity.getBody();
		for (MaxSparkedBulb maxSparkedBulb : bulbList.getOutput()) {
			System.out.println("Maximum number of ON Bulbs " + maxSparkedBulb.getMaxOnBulbs());
			System.out.println("Bulb position to switch ON");
			for (Integer integer : maxSparkedBulb.getBulbPosition()) {
				System.out.println(integer);
			}
		}
		
		//Doing dirty work here 
		//TO-DO : fix it
		System.out.println("Abrupty exiting system for a while, till Rest COntrollers code are not up");
		System.exit(-1);

	}
}
