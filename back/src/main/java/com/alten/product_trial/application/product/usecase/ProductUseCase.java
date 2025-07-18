package com.alten.product_trial.application.product.usecase;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductService productService;

    public ProductDto createProduct(CreationProduct product) {
        return productService.createProduct(product);
    }

    public ProductDto updateProduct(UUID uuid, ProductDto productDto) {
        return productService.updateProduct(uuid, productDto);
    }

    public void deleteProduct(UUID uuid) {
        productService.deleteProduct(uuid);
    }

    public ProductDto getProductByUuid(UUID uuid) {
        return productService.getProductById(uuid);
    }

    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

}
