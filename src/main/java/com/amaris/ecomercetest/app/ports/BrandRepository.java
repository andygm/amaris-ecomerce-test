package com.amaris.ecomercetest.app.ports;

import java.math.BigInteger;

public interface BrandRepository {
    /**
     * Call for existence of {@link com.amaris.ecomercetest.models.Brand Brand} in repository.
     * @param id Brand ID.
     * @return True if the Brand exist, else False.
     */
    Boolean exist(BigInteger id);
}
