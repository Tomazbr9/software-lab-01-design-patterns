package com.tomazbr9.service;

import java.math.BigDecimal;

public interface PaymentMethod {

    boolean processPayment(BigDecimal value);
}
