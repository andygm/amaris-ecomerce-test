package com.amaris.ecomercetest.adapters.repository;

import com.amaris.ecomercetest.app.ports.ProductRepository;
import com.amaris.ecomercetest.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ProductJPARepository extends CrudRepository<Product, BigInteger>, ProductRepository {
    @Override
    default Boolean exist(BigInteger id){
        return existsById(id);
    }
}
