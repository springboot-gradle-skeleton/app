package com.skeleton.application.api.impl;

import com.skeleton.framework.exception.BusinessException;
import com.skeleton.framework.exception.response.ExceptionResponse;
import com.skeleton.framework.exception.response.ExceptionResponseExtend;
import com.skeleton.framework.exception.validation.ValidationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseExtend<ValidationResult>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {

        ValidationResult validationResult = new ValidationResult();

        BindingResult bindingResult = exception.getBindingResult();
        for (ObjectError error: bindingResult.getAllErrors()) {
            if (error instanceof FieldError) {
                validationResult.addResult(((FieldError) error).getField(), error.getDefaultMessage());
            } else {
                validationResult.addResult("entity", error.getDefaultMessage());
            }
        }

        ExceptionResponseExtend<ValidationResult> exceptionResponse = new ExceptionResponseExtend<>(
                "method_argument_not_valid", HttpStatus.BAD_REQUEST.value(), null, null, validationResult);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> businessExceptionHandler(BusinessException businessException) {
        ExceptionResponse exceptionResponse = businessException.toResponse();
        HttpStatus httpStatus = HttpStatus.resolve(exceptionResponse.getCode());
        return ResponseEntity.status(Objects.nonNull(httpStatus) ? httpStatus : HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }
}
