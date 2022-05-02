package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(BigInteger notFoundProductId) {
        super(String.format("Not found Product ID -> %s", notFoundProductId));
    }
}
