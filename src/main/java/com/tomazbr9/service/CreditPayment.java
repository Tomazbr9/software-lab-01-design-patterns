package com.tomazbr9.service;

import java.math.BigDecimal;

public class CreditPayment implements PaymentMethod{

    private final BigDecimal VALUE_LIMIT = BigDecimal.valueOf(1000.00);

    @Override
    public boolean processPayment(BigDecimal value) {

        if(value.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        if(value.compareTo(VALUE_LIMIT) > 0){
            return false;
        }

        System.out.println("Pagamento efetuado com sucesso");
        return true;
    }
}
