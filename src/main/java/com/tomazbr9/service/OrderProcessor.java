package com.tomazbr9.service;

import com.tomazbr9.dto.OrderRequest;
import com.tomazbr9.dto.OrderResponse;
import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderProcessor {

    private final DiscountCalculator discountCalculator;
    private final PaymentMethod paymentMethod;

    public OrderProcessor(
            DiscountCalculator discountCalculator,
            PaymentMethod paymentMethod
    ){
        this.discountCalculator = discountCalculator;
        this.paymentMethod = paymentMethod;
    }


    public OrderResponse processOrder(OrderRequest request){

        Order order = new Order(UUID.randomUUID(), request.items());

        BigDecimal total = request.items().stream()
                .map(
                        item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalWithDescount = discountCalculator.applyDiscount(total);

        boolean approved = paymentMethod.processPayment(totalWithDescount);

        if(approved){
            order.confirmPayment();
        }

        return new OrderResponse(
                order.getId(),
                order.getItems(),
                order.getStatus(),
                totalWithDescount
        );

    }

}
