package com.tomazbr9.model;

import com.tomazbr9.enums.OrderStatus;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;

    private List<Item> items;

    private OrderStatus status = OrderStatus.PENDING;

    public Order(UUID id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void confirmPayment(){
        status = OrderStatus.PAID;
    }
}
