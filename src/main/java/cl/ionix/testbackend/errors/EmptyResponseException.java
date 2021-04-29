package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class EmptyResponseException extends RuntimeException{
    
    public EmptyResponseException(String message){
        super(message);
    }
}