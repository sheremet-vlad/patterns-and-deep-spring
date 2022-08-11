package com.example.patterns.flyweight.entity;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//Flyweight factory. Returns shared flyweight based on key
@Service
public class ErrorMessageFactory {

	private static final Map<ErrorType, ErrorMessage> errors = new HashMap<>();

	private static final String NOT_US_CONTACT = "not us";

	//This serves as key for getting flyweight instance
	public enum ErrorType {GenericSystemError, PageNotFoundError, ServerError}
	
	private ErrorMessageFactory() {
		errors.put(ErrorType.GenericSystemError,
					new SystemErrorMessage("Generic error, please contact %s", NOT_US_CONTACT));
		errors.put(ErrorType.PageNotFoundError,
					new SystemErrorMessage("404 error, please contact %s", NOT_US_CONTACT));
		errors.put(ErrorType.ServerError,
					new SystemErrorMessage("Server error, please contact %s", NOT_US_CONTACT));
	}

	public ErrorMessage getErrorMessage(final ErrorType errorType)
	{
		return errors.get(errorType);
	}
	
	public UserBannedErrorMessage getUserBannedMessage(String caseId) {
		return new UserBannedErrorMessage(caseId);
	}
}
