package com.tomazbr9.service;

import java.math.BigDecimal;

public class Descount {

    private final BigDecimal DISCOUNT = new BigDecimal("0.90");
    private final BigDecimal DISCOUNT_AMOUNT = new BigDecimal("500.00");

    public BigDecimal applyDiscount(BigDecimal value){

        if(value.compareTo(DISCOUNT_AMOUNT) >= 0){
            return value.multiply(DISCOUNT);
        }

        return value;
    }
}
