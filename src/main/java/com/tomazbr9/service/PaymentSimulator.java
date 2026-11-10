package com.tomazbr9.service;

import java.math.BigDecimal;

public class PaymentSimulator {

    public boolean process(BigDecimal amount){
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
