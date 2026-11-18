package com.tomazbr9.service;

import java.math.BigDecimal;

public class PixPayment implements PaymentMethod{

    @Override
    public boolean processPayment(BigDecimal value) {

        if(!(value.compareTo(BigDecimal.ZERO) > 0)){
            throw new IllegalArgumentException("Valor para processar pix deve ser maior que zero");
        }

        System.out.println("Pagamento efetuado com sucesso");
        return true;
    }
}
