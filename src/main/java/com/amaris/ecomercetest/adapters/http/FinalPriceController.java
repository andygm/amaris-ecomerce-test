package com.amaris.ecomercetest.adapters.http;

import com.amaris.ecomercetest.adapters.http.dto.PriceDto;
import com.amaris.ecomercetest.adapters.http.dto.mapper.PriceMapper;
import com.amaris.ecomercetest.app.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class FinalPriceController {
    private final PriceService service;
    private final PriceMapper priceMapper;

    public FinalPriceController(PriceService service, PriceMapper priceMapper) {
        this.service = service;
        this.priceMapper = priceMapper;
    }

    @GetMapping("/brand/{brand}/product/{product}/price")
    public Mono<ResponseEntity<PriceDto>> getFinalPrice(@PathVariable BigInteger brand,
                                                        @PathVariable BigInteger product,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return service.getFinalPrice(brand, product, date)
                .map(priceMapper::toResponse);
    }
}
