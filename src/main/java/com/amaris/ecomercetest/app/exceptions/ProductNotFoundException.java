package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;
import java.util.Map;

public class ProductNotFoundException extends ApplicationException {
    public ProductNotFoundException(BigInteger notFoundProductId) {
        super("product.not-found",
                String.format("Not found Product ID -> %s", notFoundProductId),
                Map.of("product.id", notFoundProductId)
        );
    }
}
