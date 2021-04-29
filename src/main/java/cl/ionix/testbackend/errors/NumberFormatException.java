package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.OK)
public class NumberFormatException extends RuntimeException{
    
    public NumberFormatException(String message){
        super(message);
    }
}