package com.platform9.diwalibulbs.utility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.platform9.diwalibulbs.dto.InputBulbString;
import com.platform9.diwalibulbs.dto.TotalInputBulbs;
import com.platform9.diwalibulbs.enums.BulbState;
import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;

@Controller
public class FileUtility {

	public TotalInputBulbs readFile(File file)
			throws ArgumentMismatchException, BadSwitchInputException, BadOnOffInputException, BadBulbsFileException {
		TotalInputBulbs totalInputBulbs = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			totalInputBulbs = inputParser(reader);
		} catch (IOException e) {
			throw new BadBulbsFileException("Input Error happened on resources");
		}

		return totalInputBulbs;
	}

	public TotalInputBulbs readFileBytes(byte[] file)
			throws ArgumentMismatchException, BadSwitchInputException, BadOnOffInputException, BadBulbsFileException {
		TotalInputBulbs totalInputBulbs = null;
		try (InputStream inputStream = new ByteArrayInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			totalInputBulbs = inputParser(reader);
		} catch (IOException e) {
			throw new BadBulbsFileException("Input Error happened on resources");
		}

		return totalInputBulbs;
	}

	public TotalInputBulbs readTerminalInput()
			throws ArgumentMismatchException, BadSwitchInputException, BadOnOffInputException, BadBulbsFileException {
		TotalInputBulbs totalInputBulbs = null;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			totalInputBulbs = inputParser(reader);
		} catch (IOException e) {
			throw new BadBulbsFileException("Input Error happened on resources");
		}

		return totalInputBulbs;
	}

	public TotalInputBulbs inputParser(BufferedReader reader)
			throws ArgumentMismatchException, BadSwitchInputException, BadOnOffInputException {
		List<Integer> bulbs = null;
		TotalInputBulbs totalInputBulbs = new TotalInputBulbs();
		List<InputBulbString> bulbStrings = null;
		try {
			int noOfTestCase = Integer.parseInt(reader.readLine().trim());
			int actualTestCase = 0;
			bulbStrings = new ArrayList<InputBulbString>(noOfTestCase);
			totalInputBulbs.setBulbString(bulbStrings);

			for (int i = 0; i < noOfTestCase; i++) {
				InputBulbString lines = new InputBulbString();
				int bulbStringLength = Integer.parseInt(reader.readLine().trim());
				int noOfSwitch = Integer.parseInt(reader.readLine().trim());
				if(noOfSwitch < 0)
					noOfSwitch =0;

				lines.setNoOfSwitch(noOfSwitch);
				String bulbString = reader.readLine();
				if (bulbStringLength != bulbString.length())
					throw new BadOnOffInputException("Given Bulb String does not match given length in test case " + i);
				bulbs = convertBulbString(bulbString.trim(), i);
				lines.setBulbs(bulbs);
				bulbStrings.add(lines);
				actualTestCase++;
			}
			if (actualTestCase != noOfTestCase) {
				throw new ArgumentMismatchException("Not valid no of test cases as given");
			}
			//input still there, less coutn of test case provided
			if(reader.readLine()!=null && reader.readLine().trim()!="") {
				throw new ArgumentMismatchException("input still there, less coutn of test case provided");
			}
				
		} catch (NumberFormatException | IOException e) {
			throw new ArgumentMismatchException("Not a valid number");
		} catch (NullPointerException e) {
			throw new ArgumentMismatchException("Check file Input for proper Test case");
		}
		
		return totalInputBulbs;
	}

	private List<Integer> convertBulbString(String bulbString, int testNo) throws BadOnOffInputException {
		List<Integer> setBits = new ArrayList<Integer>();
		if (bulbString != null) {
			for (int i = 0; i < bulbString.length(); i++) {
				if (!(bulbString.charAt(i) != BulbState.ON.getState()
						^ bulbString.charAt(i) != BulbState.OFF.getState())) {
					throw new BadOnOffInputException("String contans other than 0 or 1 at test case " + testNo);
				}
				if (bulbString.charAt(i) == BulbState.ON.getState()) {
					setBits.add(1);
				} else {
					setBits.add(0);
				}
			}
		}

		return setBits;
	}
	
	

}