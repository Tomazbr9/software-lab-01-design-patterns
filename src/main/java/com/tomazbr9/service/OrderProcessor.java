package com.tomazbr9.service;

import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderProcessor {

    private final PaymentSimulator paymentSimulator;

    public OrderProcessor(PaymentSimulator paymentSimulator){
        this.paymentSimulator = paymentSimulator;
    }

    private final BigDecimal DISCOUNT = new BigDecimal("0.90");
    private final BigDecimal DISCOUNT_AMOUNT = new BigDecimal("500.00");

    public void processOrder(Order order){

        BigDecimal total = order.getItems().stream()
                .map(
                        item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if(total.compareTo(DISCOUNT_AMOUNT) >= 0){
            total = total.multiply(DISCOUNT);
        }

        if(!paymentSimulator.process(total)){
            System.out.println("Pagamento invalido");
            return;
        }

        order.confirmPayment();

        System.out.println("Numero do pedido: " + order.getId());
        System.out.println("Total: R$" + total.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Status: " + order.getStatus().name());

    }

}
