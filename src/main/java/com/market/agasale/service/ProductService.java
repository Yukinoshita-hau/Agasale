package com.market.agasale.service;

import com.market.agasale.common.dto.CreateProductDto;
import com.market.agasale.common.dto.DeleteProductDto;
import com.market.agasale.common.dto.UpdateProductDto;
import com.market.agasale.common.enums.HttpDefaultMessage;
import com.market.agasale.exception.ProductNotFoundException;
import com.market.agasale.exception.SellerNotFoundException;
import com.market.agasale.model.Product;
import com.market.agasale.model.Seller;
import com.market.agasale.repo.ProductRepo;
import com.market.agasale.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SellerRepo sellerRepo;

    public Product getProduct(long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(id));
        }
    }

    public Product createProduct(CreateProductDto productDto) {
        Optional<Seller> optionalSeller = sellerRepo.findById(productDto.getSellerId());

        if (optionalSeller.isPresent()) {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setStockQuantity(productDto.getStockQuantity());
            product.setSeller(optionalSeller.get());

            return productRepo.save(product);
        } else {
            throw new SellerNotFoundException(HttpDefaultMessage.HTTP_SELLER_NOT_FOUND_MESSAGE.getHttpSellerNotFoundMessageWithId(productDto.getSellerId()));
        }
    }

    public Product updateProduct(UpdateProductDto productDto) {
        Optional<Product> optionalProduct = productRepo.findById(productDto.getId());

        if (optionalProduct.isPresent()) {
            Product existedProduct = optionalProduct.get();
            existedProduct.setName(productDto.getName());
            existedProduct.setDescription(productDto.getDescription());
            existedProduct.setPrice(productDto.getPrice());
            existedProduct.setStockQuantity(productDto.getStockQuantity());

            return productRepo.save(existedProduct);
        } else {
            throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(productDto.getId()));
        }
    }

    public DeleteProductDto deleteProduct(long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.deleteById(id);
            return new DeleteProductDto(optionalProduct.get().getId(),
                                        optionalProduct.get().getName(),
                                        optionalProduct.get().getPrice(),
                                        optionalProduct.get().getStockQuantity(),
                                        optionalProduct.get().getDescription());
        } else {
            throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(id));
        }
    }
}
