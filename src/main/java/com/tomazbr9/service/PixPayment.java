package com.tomazbr9.service;

import java.math.BigDecimal;

public class PixPayment implements PaymentMethod{

    @Override
    public boolean processPayment(BigDecimal value) {

        if(value.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        System.out.println("Pagamento efetuado com sucesso");
        return true;
    }
}
