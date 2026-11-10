package com.tomazbr9.dto;

import com.tomazbr9.enums.OrderStatus;
import com.tomazbr9.model.Item;
import com.tomazbr9.model.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        List<Item> items,
        OrderStatus status,
        BigDecimal total
) {
}
