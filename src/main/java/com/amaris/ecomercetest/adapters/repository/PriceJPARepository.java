package com.amaris.ecomercetest.adapters.repository;

import com.amaris.ecomercetest.app.ports.PriceRepository;
import com.amaris.ecomercetest.models.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

public interface PriceJPARepository extends Repository<Price, BigInteger>, PriceRepository {
    @Query(value = "SELECT p FROM Price p " +
            "WHERE p.brand.id = :brandId " +
            "AND p.product.id = :productId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC "
    )
    Stream<Price> getFinalPriceFor(BigInteger brandId, BigInteger productId, LocalDateTime date);

    @Override
    default Optional<Price> getFinalPrice(BigInteger brandId, BigInteger productId, LocalDateTime date){
        return getFinalPriceFor(brandId, productId, date)
                .findFirst();
    }
}
