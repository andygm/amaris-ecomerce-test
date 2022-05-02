package com.amaris.ecomercetest;

import com.amaris.ecomercetest.app.exceptions.BrandNotFoundException;
import com.amaris.ecomercetest.app.exceptions.FinalPriceNotFoundException;
import com.amaris.ecomercetest.app.exceptions.ProductNotFoundException;
import com.amaris.ecomercetest.app.service.PriceService;
import com.amaris.ecomercetest.models.Brand;
import com.amaris.ecomercetest.models.Currency;
import com.amaris.ecomercetest.models.Price;
import com.amaris.ecomercetest.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
@ActiveProfiles("test")
class EcomerceTestApplicationTests {
    static BigInteger PRODUCT_ID = BigInteger.valueOf(35455);
    static BigInteger BRAND_ID = BigInteger.ONE;

    @Autowired
    private PriceService service;


    @Test
    void getFinalPrice_Successful() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 17, 0);
        StepVerifier.create(service.getFinalPrice(BRAND_ID, PRODUCT_ID, date))
                .expectNext(getSuccessfulPrice())
                .verifyComplete();
    }

    @Test
    void getFinalPrice_BrandNotFound() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 17, 0);
        StepVerifier.create(service.getFinalPrice(BigInteger.ZERO, PRODUCT_ID, date))
                .expectErrorMatches(throwable -> throwable instanceof BrandNotFoundException &&
                        throwable.getMessage().equals("Not found Brand ID -> 0")
                ).verify();
    }

    @Test
    void getFinalPrice_ProductNotFound() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 17, 0);
        StepVerifier.create(service.getFinalPrice(BRAND_ID, BigInteger.ZERO, date))
                .expectErrorMatches(throwable -> throwable instanceof ProductNotFoundException &&
                                throwable.getMessage().equals("Not found Product ID -> 0")
                ).verify();
    }

    @Test
    void getFinalPrice_FinalPriceNotFound() {
        LocalDateTime date = LocalDateTime.of(2021, 6, 14, 17, 0);
        StepVerifier.create(service.getFinalPrice(BRAND_ID, PRODUCT_ID, date))
                .expectErrorMatches(throwable -> throwable instanceof FinalPriceNotFoundException &&
                        throwable.getMessage().equals("Not found final price for Brand ID -> 1, Product ID -> 35455, Date -> 2021-06-14T17:00")
                ).verify();
    }
    
    private Price getSuccessfulPrice() {
        Brand brand = new Brand(BRAND_ID, "ZARA");
        Product product = new Product(PRODUCT_ID, "PRODUCT-1");
        return Price.builder()
                .priceList(BigInteger.valueOf(2))
                .brand(brand)
                .product(product)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30))
                .price(BigDecimal.valueOf(25.45))
                .priority(1)
                .currency(Currency.EUR)
                .build();
    }

    @ParameterizedTest
    @MethodSource
    void argumentTestByRequirements(LocalDateTime date, BigInteger productId, BigInteger brandId) {
        StepVerifier.create(service.getFinalPrice(brandId, productId, date))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    private static Stream<Arguments> argumentTestByRequirements() {
        return Stream.of(
                Arguments.of(LocalDateTime.of(2020, 6, 14, 10, 0), PRODUCT_ID, BRAND_ID),
                Arguments.of(LocalDateTime.of(2020, 6, 14, 16, 0), PRODUCT_ID, BRAND_ID),
                Arguments.of(LocalDateTime.of(2020, 6, 14, 21, 0), PRODUCT_ID, BRAND_ID),
                Arguments.of(LocalDateTime.of(2020, 6, 15, 10, 0), PRODUCT_ID, BRAND_ID),
                Arguments.of(LocalDateTime.of(2020, 6, 16, 21, 0), PRODUCT_ID, BRAND_ID)
        );
    }

}
