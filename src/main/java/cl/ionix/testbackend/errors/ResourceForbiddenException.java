package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class ResourceForbiddenException extends RuntimeException {
    
    public ResourceForbiddenException (String message){
        super(message);
    }
}