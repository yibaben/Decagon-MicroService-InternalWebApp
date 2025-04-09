package com.decagon.DepartmentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CodeNumAlreadyExistException extends RuntimeException{
    private String message;

    public CodeNumAlreadyExistException(String message){
        super(message);
    }
}
