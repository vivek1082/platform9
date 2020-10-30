package com.platform9.diwalibulbs.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.platform9.diwalibulbs.dto.OutputBulbList;
import com.platform9.diwalibulbs.dto.TotalInputBulbs;
import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbArraySizeInputException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;
import com.platform9.diwalibulbs.services.CountPositionService;
import com.platform9.diwalibulbs.utility.FileUtility;

@Component
public class TerminalController {

	@Autowired
	FileUtility fileUtility;
	@Autowired
	CountPositionService countPositionService;

	public ResponseEntity<OutputBulbList> showLightBulbs() throws BadBulbsFileException, BadSwitchInputException,
			BadOnOffInputException, BadBulbArraySizeInputException, ArgumentMismatchException {
		OutputBulbList outputBulbList = null;
		System.out.println("Enter Light Bulbs Input as per Input Format");
		TotalInputBulbs bulbList = fileUtility.readTerminalInput();

		outputBulbList = countPositionService.countSwitch(bulbList);
		return new ResponseEntity<OutputBulbList>(outputBulbList, HttpStatus.OK);
	}

	public OutputBulbList showLightBulbs(File file) throws BadBulbsFileException,
			BadSwitchInputException, BadOnOffInputException, BadBulbArraySizeInputException, ArgumentMismatchException {
		OutputBulbList outputBulbList = null;
		TotalInputBulbs bulbList = fileUtility.readFile(file);

		outputBulbList = countPositionService.countSwitch(bulbList);
		return  outputBulbList;
	}
}
