package com.amaris.ecomercetest.adapters.http.dto.mapper;

import com.amaris.ecomercetest.adapters.http.dto.PriceDto;
import com.amaris.ecomercetest.models.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.ResponseEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    default ResponseEntity<PriceDto> toResponse(Price source) {
        return ResponseEntity.ok(to(source));
    }

    default String priceToString(Price source) {
        return source.getCurrency().format(source.getPrice());
    }

    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "from", source = "startDate")
    @Mapping(target = "to", source = "endDate")
    @Mapping(target = "finalPrice", expression = "java(priceToString(source))")
    PriceDto to(Price source);
}
