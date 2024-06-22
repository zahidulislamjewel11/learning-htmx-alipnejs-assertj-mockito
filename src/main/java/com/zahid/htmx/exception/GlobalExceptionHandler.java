package com.zahid.htmx.exception;

import java.util.NoSuchElementException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String CUSTOM_EXCEPTION_VIEW = "exception/custom-exception";

    @ExceptionHandler(value = Exception.class)
    public String handleAnyException(Exception ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return CUSTOM_EXCEPTION_VIEW;
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointerException(NullPointerException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return CUSTOM_EXCEPTION_VIEW;
    }
    
    @ExceptionHandler(value = EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return CUSTOM_EXCEPTION_VIEW;
    }
    
    @ExceptionHandler(value = NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return CUSTOM_EXCEPTION_VIEW;
    }

}
