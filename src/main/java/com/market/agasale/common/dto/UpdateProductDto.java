package com.market.agasale.common.dto;

import com.market.agasale.common.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class UpdateProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

    private List<Category> categories;
}
