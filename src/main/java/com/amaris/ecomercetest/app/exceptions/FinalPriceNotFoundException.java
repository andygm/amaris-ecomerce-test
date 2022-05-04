package com.amaris.ecomercetest.app.exceptions;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Map;

public class FinalPriceNotFoundException extends ApplicationException {
    public FinalPriceNotFoundException(BigInteger brandId, BigInteger productId, LocalDateTime date) {
        super("price.not-found",
                String.format("Not found final price for Brand ID -> %s, Product ID -> %s, Date -> %s", brandId, productId, date),
                Map.of("brand.id", brandId, "product.id", productId, "date", date)
        );
    }
}
