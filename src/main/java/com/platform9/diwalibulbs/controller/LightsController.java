package com.platform9.diwalibulbs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
@RequestMapping(value = "/**")
public class LightsController {

	@Autowired
	FileUtility fileUtility;

	@Autowired
	CountPositionService countPositionService;

	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String handler(Model model) {
		model.addAttribute("msg", "a jar msg");
		return "index";
	}
	public ResponseEntity<OutputBulbList> showLightBulbs(@RequestPart("file") MultipartFile input)
			throws BadBulbsFileException, BadSwitchInputException, BadOnOffInputException,
			BadBulbArraySizeInputException, ArgumentMismatchException {
		if (null == input.getOriginalFilename())
			throw new BadBulbsFileException("File not provided");
		OutputBulbList outputBulbList = null;
		try {
			byte[] fileBites = input.getBytes();
			TotalInputBulbs bulbList = fileUtility.readFileBytes(fileBites);

			outputBulbList = countPositionService.countSwitch(bulbList);
		} catch (IOException e) {
			throw new BadBulbsFileException("IO exception occured try again");
		}
		return new ResponseEntity<OutputBulbList>(outputBulbList, HttpStatus.OK);
	}
	
	

}
