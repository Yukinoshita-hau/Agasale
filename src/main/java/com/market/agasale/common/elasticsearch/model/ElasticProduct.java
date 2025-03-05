package com.market.agasale.common.elasticsearch.model;

import com.market.agasale.common.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ElasticProduct {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<Category> category;
}
