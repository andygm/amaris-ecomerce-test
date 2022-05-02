package com.amaris.ecomercetest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Price {
    @Id
    private BigInteger priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
