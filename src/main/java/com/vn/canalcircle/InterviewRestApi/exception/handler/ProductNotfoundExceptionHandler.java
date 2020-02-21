package com.vn.canalcircle.InterviewRestApi.exception.handler;

import com.vn.canalcircle.InterviewRestApi.dto.ErrorCode;
import com.vn.canalcircle.InterviewRestApi.dto.ResponseEnvelope;
import com.vn.canalcircle.InterviewRestApi.dto.ResponseEnvelopeFactory;
import com.vn.canalcircle.InterviewRestApi.exception.ProductNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotfoundExceptionHandler {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        result.setMessage(exception.getMessage());
        result.setCode(ErrorCode.EXCEPTION);
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
}