package com.rubix.timesheet.Exception;

import java.util.Date;

/**
 * @author kausar
 * @class ErrorDetails
 * Returns the Error details to the  ExceptionHandler whenever there is failure in connection
 */

public class ErrorDetails {
	//Initialize the timestamp variable
	private Date timestamp;
	//Initialize the message variable
	private String message;
	//Initialize the details variable
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * This method is used for time stamp
	 * @method getTimestamp
	 * @return Date
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * This method is used for message
	 * @method getMessage
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method is used for details
	 * @method getDetails
	 * @return String
	 */
	public String getDetails() {
		return details;
	}
}
