package com.alten.product_trial.application.product.service;

import com.alten.product_trial.application.product.model.ProductDto;
import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto product);

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long id, ProductDto updatedProduct);

    void deleteProduct(Long id);
}
