package com.market.agasale.controller;

import com.market.agasale.common.dto.DeleteProductDto;
import com.market.agasale.model.Product;
import com.market.agasale.service.ProductService;
import com.market.agasale.common.dto.CreateProductDto;
import com.market.agasale.common.dto.UpdateProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody CreateProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody UpdateProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/product/{id}")
    public DeleteProductDto deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
