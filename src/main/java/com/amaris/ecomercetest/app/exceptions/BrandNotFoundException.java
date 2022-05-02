package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(BigInteger notFoundBrandId) {
        super(String.format("Not found Brand ID -> %s", notFoundBrandId));
    }
}
