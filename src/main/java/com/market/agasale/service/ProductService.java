package com.market.agasale.service;

import com.market.agasale.common.Minio;
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
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SellerRepo sellerRepo;

    @Autowired
    private Minio minio;

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

    public Product uploadImage(MultipartFile file, long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent()) {
            String bucketName = "products-images";
            String objectName = file.getOriginalFilename();

            try {
                minio.uploadObjectFromStream(bucketName, objectName, file.getInputStream(), file.getSize(), file.getContentType());

                Product product = optionalProduct.get();
                List<String> listArrProducts = product.getImages() != null ? product.getImages(): new ArrayList<>();
                listArrProducts.add(objectName);
                product.setImages(listArrProducts);

                return productRepo.save(product);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка при загрузке изображения: " + e.getMessage());
            }
        } else {
            throw new ProductNotFoundException(HttpDefaultMessage.HTTP_PRODUCT_NOT_FOUND_MESSAGE.getHttpProductNotFoundMessageWithId(id));
        }
    }

    public ResponseEntity<byte[]> getImage(String fileName) {
        String bucketName = "products-images";

        try {
            GetObjectResponse objectResponse = minio.getObject(bucketName, fileName);
            InputStream inputStream = objectResponse;

            byte[] imageBytes = inputStream.readAllBytes();

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, objectResponse.headers().get("Content-Type"));
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"");

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
