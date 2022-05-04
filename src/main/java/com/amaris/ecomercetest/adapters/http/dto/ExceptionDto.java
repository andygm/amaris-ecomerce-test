package com.amaris.ecomercetest.adapters.http.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ExceptionDto {
        private String code;
        private String message;
        private Map<String, Object> params;
}
