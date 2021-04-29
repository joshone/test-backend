package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
 
    public ConflictException(String message){
        super(message);
    }
}