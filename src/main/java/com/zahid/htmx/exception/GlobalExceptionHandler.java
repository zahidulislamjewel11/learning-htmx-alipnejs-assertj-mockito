package com.zahid.htmx.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String CUSTOM_EXCEPTION_TEMPLATE = "exception/custom-exception";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAnyException(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return CUSTOM_EXCEPTION_TEMPLATE;
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNullPointerException(NullPointerException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("statusCode", HttpStatus.BAD_REQUEST.value());
        return CUSTOM_EXCEPTION_TEMPLATE;
    }
    
    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(EntityNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("statusCode", HttpStatus.NOT_FOUND.value());
        return CUSTOM_EXCEPTION_TEMPLATE;
    }
    
    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("statusCode", HttpStatus.NOT_FOUND.value());
        return CUSTOM_EXCEPTION_TEMPLATE;
    }

}
