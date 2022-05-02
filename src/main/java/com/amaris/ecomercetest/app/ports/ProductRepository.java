package com.amaris.ecomercetest.app.ports;

import java.math.BigInteger;

public interface ProductRepository {
    /**
     * Call for existence of {@link com.amaris.ecomercetest.models.Product Product} in repository.
     * @param id Product ID.
     * @return True if the Product exist, else False.
     */
    Boolean exist(BigInteger id);
}
