package com.paypal.bfs.test.employeeserv.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorResponse> exceptionToDoHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    ObjectError  objectError =ex.getBindingResult().getAllErrors().get(0);
	    String fieldName = ((FieldError) objectError).getField();
        String errorMessage = objectError.getDefaultMessage();
	    ErrorResponse error = new ErrorResponse();
	    error.setMessage(fieldName +" "+errorMessage );
	    error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);

	}

}