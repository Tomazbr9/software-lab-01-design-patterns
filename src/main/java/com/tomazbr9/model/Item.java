package com.tomazbr9.model;

import javax.management.InvalidAttributeValueException;
import java.math.BigDecimal;

public class Item {

    private String name;

    private BigDecimal price;

    private Integer quantity;

    public Item(String name, BigDecimal price, Integer quantity){
        this.name = validateName(name);
        this.price = validatePrice(price);
        this.quantity = validateQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private String validateName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        return name;
    }

    private BigDecimal validatePrice(BigDecimal price){
        if(price == null || price.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("preço do produto é obrigatorio");
            throw new IllegalArgumentException();
        }
        return price;
    }

    private Integer validateQuantity(Integer quantity){
        if(quantity < 0){
            System.out.println("quantidade do produto é obrigatorio");
            throw new IllegalArgumentException();
        }

        return quantity;
    }

}
