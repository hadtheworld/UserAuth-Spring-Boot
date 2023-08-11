package com.example.UserAuth.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.UserAuth.Exceptions.EmptyOutputException;
import com.example.UserAuth.Exceptions.UniqueValueException;

@ControllerAdvice
public class UserAdvice extends ResponseEntityExceptionHandler{
	@ExceptionHandler(UniqueValueException.class)
	public ResponseEntity<Object> handleUniqueValueException(UniqueValueException uniqueValueException){
		return new ResponseEntity<>(uniqueValueException.getErrorMessage(),HttpStatus.CONFLICT);
	}
	@ExceptionHandler(EmptyOutputException.class)
	public ResponseEntity<Object> handleEmptyOutputException(EmptyOutputException emptyOutputException){
		return new ResponseEntity<>(emptyOutputException.getErrorMessage(),HttpStatus.NOT_FOUND);
	}
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		return new ResponseEntity<>("Made Request is Not Supported for this endpoint",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
		return new ResponseEntity<>(illegalArgumentException.getMessage(),HttpStatus.FORBIDDEN);
	}
}
