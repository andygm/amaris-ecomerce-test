package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class FinalPriceNotFoundException extends RuntimeException {
    public FinalPriceNotFoundException(BigInteger brandId, BigInteger productId, LocalDateTime date) {
        super(String.format("Not found final price for Brand ID -> %s, Product ID -> %s, Date -> %s", brandId, productId, date));
    }
}
