package com.alten.product_trial.application.product.usecase;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService productService;

    public ProductDto createProduct(ProductDto productDto) {
        return new ProductDto();
    }

    public ProductDto updateProduct(UUID uuid, ProductDto productDto) {
        return new ProductDto();
    }

    public void deleteProduct(UUID uuid) {
    }

    public ProductDto getProductByUuid(UUID uuid) {
        return new ProductDto();
    }

    public List<ProductDto> getAllProducts() {
        return List.of();
    }

}
