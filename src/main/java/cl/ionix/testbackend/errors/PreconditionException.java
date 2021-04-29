package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.PRECONDITION_REQUIRED)
public class PreconditionException extends RuntimeException{
    
    public PreconditionException(String message){
        super(message);
    }
}