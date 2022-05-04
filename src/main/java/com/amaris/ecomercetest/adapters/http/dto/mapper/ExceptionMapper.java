package com.amaris.ecomercetest.adapters.http.dto.mapper;

import com.amaris.ecomercetest.adapters.http.dto.ExceptionDto;
import com.amaris.ecomercetest.app.exceptions.ApplicationException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.server.ServerWebInputException;

@Mapper(componentModel = "spring")
public interface ExceptionMapper {
    ExceptionDto to(ApplicationException source);

    @Mapping(target = "code", constant = "input-error")
    ExceptionDto to(ServerWebInputException source);

    @Mapping(target = "code", constant = "internal-error.not-handled-error")
    ExceptionDto to(Exception source);
}
