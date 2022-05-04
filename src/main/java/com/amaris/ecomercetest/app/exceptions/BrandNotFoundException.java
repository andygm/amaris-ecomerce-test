package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;
import java.util.Map;

public class BrandNotFoundException extends ApplicationException {
    public BrandNotFoundException(BigInteger notFoundBrandId) {
        super("brand.not-found",
                String.format("Not found Brand ID -> %s", notFoundBrandId),
                Map.of("brand.id", notFoundBrandId.toString()));
    }
}
