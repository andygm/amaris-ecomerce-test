package com.amaris.ecomercetest.app.service;

import com.amaris.ecomercetest.models.Price;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface PriceService {
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
    Mono<Price> getFinalPrice(BigInteger brandId, BigInteger productId, LocalDateTime date);
}
