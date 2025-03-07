package com.market.agasale.common.dto;

import com.market.agasale.common.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchDto {
    private String name;
    private List<Category> categories;
}
