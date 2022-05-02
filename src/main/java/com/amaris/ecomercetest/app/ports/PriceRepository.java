package com.amaris.ecomercetest.app.ports;

import com.amaris.ecomercetest.models.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    /**
     * Get the final {@link com.amaris.ecomercetest.models.Price Price} for a
     * {@link com.amaris.ecomercetest.models.Product Product} that belongs to a
     * {@link com.amaris.ecomercetest.models.Brand Brand} in a certain date.
     *
     * @param brandId Brand ID.
     * @param productId Product ID.
     * @param date Final price search date.
     * @return Optional of Price
     */
    Optional<Price> getFinalPrice(BigInteger brandId, BigInteger productId, LocalDateTime date);
}
