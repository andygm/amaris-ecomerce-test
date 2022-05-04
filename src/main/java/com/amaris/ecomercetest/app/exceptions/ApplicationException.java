package com.amaris.ecomercetest.app.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public abstract class ApplicationException extends RuntimeException {
    private final String code;
    private final String message;
    private final Map<String, Object> params;

    protected ApplicationException(String code, String message, Map<String, Object> params) {
        this.code = code;
        this.message = message;
        this.params = params;
    }
}
