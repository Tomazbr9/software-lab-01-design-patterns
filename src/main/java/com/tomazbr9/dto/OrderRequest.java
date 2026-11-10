package com.tomazbr9.dto;

import com.tomazbr9.model.Item;

import java.util.List;

public record OrderRequest(
        List<Item> items
) {
}
