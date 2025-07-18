package com.alten.product_trial.application.product.service;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto createProduct(CreationProduct product);

    ProductDto getProductById(UUID id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(UUID id, ProductDto updatedProduct);

    void deleteProduct(UUID id);
}
