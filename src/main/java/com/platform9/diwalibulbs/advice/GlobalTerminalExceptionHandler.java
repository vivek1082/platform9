package com.platform9.diwalibulbs.advice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.platform9.diwalibulbs.exception.ArgumentMismatchException;
import com.platform9.diwalibulbs.exception.BadBulbArraySizeInputException;
import com.platform9.diwalibulbs.exception.BadBulbsFileException;
import com.platform9.diwalibulbs.exception.BadOnOffInputException;
import com.platform9.diwalibulbs.exception.BadSwitchInputException;

@Component
@ControllerAdvice
public class GlobalTerminalExceptionHandler {

	@ExceptionHandler({ ArgumentMismatchException.class, BadBulbArraySizeInputException.class,
			BadBulbsFileException.class, BadOnOffInputException.class, BadSwitchInputException.class })
	public void printMsgForTerminalMode(Exception ex) {
		System.out.println("Exception occured while processing, msg " + ex.getMessage() + " " + ex.getClass());
		
		//doing dirty work for a while 
		System.out.println("Closing the system abruptly - bye");
		System.exit(-1);
	}
}
