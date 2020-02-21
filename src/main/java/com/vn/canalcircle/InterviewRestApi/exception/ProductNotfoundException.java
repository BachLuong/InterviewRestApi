package com.vn.canalcircle.InterviewRestApi.exception;

public class ProductNotfoundException extends RuntimeException{
    private static final long serialVersionUID = -3867092575395982599L;

    public ProductNotfoundException() {
        super();
    }
    public ProductNotfoundException(String message) {
        super(message);
    }
}
