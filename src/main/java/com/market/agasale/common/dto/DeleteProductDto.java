package com.market.agasale.common.dto;

import com.market.agasale.common.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class DeleteProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

    private List<Category> categories;

    public DeleteProductDto(long id, String name, BigDecimal price, int stockQuantity, String description, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.categories = categories;
    }
}
