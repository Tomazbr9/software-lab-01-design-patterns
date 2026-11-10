package com.tomazbr9.service;

import com.tomazbr9.dto.OrderResponse;
import com.tomazbr9.model.Item;
import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderProcessor {

    private final PaymentSimulator paymentSimulator;

    public OrderProcessor(PaymentSimulator paymentSimulator){
        this.paymentSimulator = paymentSimulator;
    }

    private final BigDecimal DISCOUNT = new BigDecimal("0.90");
    private final BigDecimal DISCOUNT_AMOUNT = new BigDecimal("500.00");

    public OrderResponse processOrder(Order newOrder){

        BigDecimal total = newOrder.getItems().stream()
                .map(
                        item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if(total.compareTo(DISCOUNT_AMOUNT) >= 0){
            total = total.multiply(DISCOUNT);
        }

        if(!paymentSimulator.process(total)){
            System.out.println("Pagamento invalido");
            throw new IllegalArgumentException();
        }

        UUID id = newOrder.getId();
        List<Item> items = newOrder.getItems();
        Order order = new Order(id, items);

        order.confirmPayment();

        return new OrderResponse(order, total);

    }

}
