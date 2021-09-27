package com.db.trades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TradeExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(LowerVersionException.class)
	protected ResponseEntity<Object> handleLowerVersionException(LowerVersionException ex){
		 return new ResponseEntity<>("Lower version is not acceptable for updating trades.", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(InvalidMaturityDateException.class)
	protected ResponseEntity<Object> handleInvalidMaturityDateException(InvalidMaturityDateException ex){
		 return new ResponseEntity<>("Maturity date is before current date for updating trades.", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
