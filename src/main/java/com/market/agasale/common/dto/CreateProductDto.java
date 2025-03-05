package com.market.agasale.common.dto;

import com.market.agasale.common.enums.Categories;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class CreateProductDto {
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

    private long sellerId;
    private List<Categories> categories;

}
