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

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
