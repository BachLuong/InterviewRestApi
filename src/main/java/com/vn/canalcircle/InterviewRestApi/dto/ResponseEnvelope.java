package com.vn.canalcircle.InterviewRestApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class ResponseEnvelope implements Serializable {

    private static final long serialVersionUID = -7046917563407303115L;

    private ErrorCode code;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    private long timestamp = System.currentTimeMillis();

    public ResponseEnvelope() {
        code = ErrorCode.OK;
    }

    public ResponseEnvelope(ErrorCode code) {
        this.code = code;
    }

    public ResponseEnvelope(Object result) {
        code = ErrorCode.OK;
        this.result = result;
    }

    public ResponseEnvelope(ErrorCode code, Object result) {
        this.code = code;
        this.result = result;
    }

    public ResponseEnvelope setResult(Object result) {
        this.result = result;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public ErrorCode getCode() {
        return code;
    }

    public ResponseEnvelope setCode(ErrorCode code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEnvelope setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
