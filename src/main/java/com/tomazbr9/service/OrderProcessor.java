package com.tomazbr9.service;

import com.tomazbr9.dto.OrderRequest;
import com.tomazbr9.dto.OrderResponse;
import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderProcessor {

    private final PaymentSimulator paymentSimulator;
    private final Descount descount;

    public OrderProcessor(
            PaymentSimulator paymentSimulator,
            Descount descount
    ){
        this.paymentSimulator = paymentSimulator;
        this.descount = descount;
    }


    public OrderResponse processOrder(OrderRequest request){

        Order order = new Order(UUID.randomUUID(), request.items());

        BigDecimal total = request.items().stream()
                .map(
                        item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalWithDescount = descount.applyDiscount(total);

        if(!paymentSimulator.process(total)){
            throw new IllegalArgumentException("Pagamento invalido");
        }

        order.confirmPayment();

        return new OrderResponse(
                order.getId(),
                order.getItems(),
                order.getStatus(),
                totalWithDescount
        );

    }

}
