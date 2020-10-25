package com.platform9.diwalibulbs.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
}
