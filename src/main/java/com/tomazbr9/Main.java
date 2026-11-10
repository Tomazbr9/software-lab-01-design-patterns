package com.tomazbr9;

import com.tomazbr9.model.Item;
import com.tomazbr9.model.Order;
import com.tomazbr9.service.OrderProcessor;
import com.tomazbr9.service.PaymentSimulator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentSimulator paymentSimulator = new PaymentSimulator();
        OrderProcessor orderProcessor = new OrderProcessor(paymentSimulator);

        Item item1 = new Item("Pizza de calabbresa", new BigDecimal("400.00"), 1);
        Item item2 = new Item("Cola Cola 2L", new BigDecimal("100.00"), 2);

        List<Item> items = List.of(item1, item2);

        Order order = new Order(UUID.randomUUID(), items);

        orderProcessor.processOrder(order);

    }
}