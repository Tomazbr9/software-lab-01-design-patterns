package com.tomazbr9.dto;

import com.tomazbr9.model.Order;

import java.math.BigDecimal;

public record OrderResponse(
        Order order,
        BigDecimal total
) {
}
