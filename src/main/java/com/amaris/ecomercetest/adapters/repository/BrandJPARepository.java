package com.amaris.ecomercetest.adapters.repository;

import com.amaris.ecomercetest.app.ports.BrandRepository;
import com.amaris.ecomercetest.models.Brand;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface BrandJPARepository extends CrudRepository<Brand, BigInteger>, BrandRepository {
    @Override
    default Boolean exist(BigInteger id){
        return existsById(id);
    }
}
