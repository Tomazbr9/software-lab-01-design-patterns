package com.tomazbr9.service;

import com.tomazbr9.enums.OrderStatus;
import com.tomazbr9.model.Item;
import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderProcessor {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.90");
    private static final BigDecimal DISCOUNT_AMOUNT = new BigDecimal("500.00");

    public static void processOrder(Order order){

        BigDecimal total = order.getItems().stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if(total.compareTo(DISCOUNT_AMOUNT) >= 0){
            total = total.multiply(DISCOUNT);
        }

        order.setStatus(OrderStatus.PAID);

        System.out.println("Numero do pedido: " + order.getId());
        System.out.println("Total: " + total.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Status: " + order.getStatus().name());

    }

}
