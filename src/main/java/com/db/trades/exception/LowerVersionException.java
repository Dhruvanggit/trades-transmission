package com.db.trades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE,reason = "Lower Version not accepted.")
public class LowerVersionException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public LowerVersionException() {
        super();
    }
    public LowerVersionException(String message, Throwable cause) {
        super(message, cause);
    }
    public LowerVersionException(String message) {
        super(message);
    }
    public LowerVersionException(Throwable cause) {
        super(cause);
    }
	
}
