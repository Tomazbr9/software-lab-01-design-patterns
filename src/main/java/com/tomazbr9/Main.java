package com.tomazbr9;

import com.tomazbr9.dto.OrderRequest;
import com.tomazbr9.dto.OrderResponse;
import com.tomazbr9.model.Item;
import com.tomazbr9.model.Order;
import com.tomazbr9.service.Descount;
import com.tomazbr9.service.OrderProcessor;
import com.tomazbr9.service.PaymentSimulator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PaymentSimulator paymentSimulator = new PaymentSimulator();
        Descount descount = new Descount();
        OrderProcessor orderProcessor = new OrderProcessor(paymentSimulator, descount);

        Item item1 = new Item("Pizza de calabbresa", new BigDecimal("400.00"), 1);
        Item item2 = new Item("Cola Cola 2L", new BigDecimal("100"), 1);

        List<Item> items = List.of(item1, item2);

        OrderRequest request = new OrderRequest(items);

        OrderResponse response = orderProcessor.processOrder(request);

        System.out.println("Id do Pedido: " + response.id());
        System.out.println("Total do Pedido: R$" + response.total().setScale(2, RoundingMode.HALF_UP));
        System.out.println("Status do Pagamento : " + response.status());

    }
}