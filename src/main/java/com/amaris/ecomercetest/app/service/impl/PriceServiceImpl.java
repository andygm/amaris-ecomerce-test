package com.amaris.ecomercetest.app.service.impl;

import com.amaris.ecomercetest.adapters.repository.BrandJPARepository;
import com.amaris.ecomercetest.app.exceptions.BrandNotFoundException;
import com.amaris.ecomercetest.app.exceptions.FinalPriceNotFoundException;
import com.amaris.ecomercetest.app.exceptions.ProductNotFoundException;
import com.amaris.ecomercetest.app.ports.BrandRepository;
import com.amaris.ecomercetest.app.ports.PriceRepository;
import com.amaris.ecomercetest.app.ports.ProductRepository;
import com.amaris.ecomercetest.app.service.PriceService;
import com.amaris.ecomercetest.models.Price;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.time.LocalDateTime;

import static reactor.core.publisher.Mono.*;

@Service
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;
    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    public PriceServiceImpl(PriceRepository priceRepository, BrandJPARepository brandRepository, ProductRepository productRepository) {
        this.priceRepository = priceRepository;
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Mono<Price> getFinalPrice(BigInteger brandId, BigInteger productId, LocalDateTime date) {
        return fromSupplier(() -> brandRepository.exist(brandId))
                .filter(b -> b)
                .switchIfEmpty(error(new BrandNotFoundException(brandId)))
                .thenReturn(productRepository.exist(productId))
                .filter(b -> b)
                .switchIfEmpty(error(new ProductNotFoundException(productId)))
                .then(justOrEmpty(priceRepository.getFinalPrice(brandId, productId, date)))
                .switchIfEmpty(error(new FinalPriceNotFoundException(brandId, productId, date)));
    }
}
