package com.db.trades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE,reason = "Maturity date is before current date.")
public class InvalidMaturityDateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidMaturityDateException() {
        super();
    }
    public InvalidMaturityDateException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidMaturityDateException(String message) {
        super(message);
    }
    public InvalidMaturityDateException(Throwable cause) {
        super(cause);
    }

}
