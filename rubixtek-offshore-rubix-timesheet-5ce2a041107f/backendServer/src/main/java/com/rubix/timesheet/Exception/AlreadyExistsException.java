package com.rubix.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 
 * @class AlreadyExistsException
 * Returns the message of Error details when there is a response 
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String message) {
		super(message);
	}
}
