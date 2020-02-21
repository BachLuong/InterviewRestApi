package com.vn.canalcircle.InterviewRestApi.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {

    OK(1),FAIL(2),EXCEPTION(3);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
