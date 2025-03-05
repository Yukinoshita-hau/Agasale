package com.market.agasale.model;

import com.market.agasale.common.enums.Categories;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private List<String> images;

    @ManyToOne
    private Seller seller;

    @ElementCollection(targetClass = Categories.class)
    @CollectionTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Enumerated(EnumType.STRING)
    private List<Categories> category;


}
