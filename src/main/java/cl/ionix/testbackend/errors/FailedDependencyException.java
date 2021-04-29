package cl.ionix.testbackend.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@SuppressWarnings("serial")
@ResponseStatus(value= HttpStatus.FAILED_DEPENDENCY)
public class FailedDependencyException extends RuntimeException {
 
    public FailedDependencyException(String message){
        super(message);
    }
}