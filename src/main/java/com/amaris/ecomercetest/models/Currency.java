package com.amaris.ecomercetest.models;

import java.math.BigDecimal;
import java.text.NumberFormat;

public enum Currency {
    EUR;

    private final NumberFormat numberFormat;

    Currency() {
        numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setCurrency(java.util.Currency.getInstance(this.name()));
    }

    public String format(BigDecimal number) {
        return numberFormat.format(number);
    }
}
