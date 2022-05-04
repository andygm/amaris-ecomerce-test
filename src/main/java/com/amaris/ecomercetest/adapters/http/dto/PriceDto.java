package com.amaris.ecomercetest.adapters.http.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Setter
@Getter
public class PriceDto {
    private BigInteger productId;
    private BigInteger brandId;
    private BigInteger priceList;
    private LocalDateTime from;
    private LocalDateTime to;
    private String finalPrice;
}
