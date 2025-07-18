package com.alten.product_trial.infra.product.service;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDto createProduct(ProductDto product) {
        return null;
    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto updatedProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
