package com.alten.product_trial.presentation.product.rest;

import com.alten.product_trial.application.product.mapper.ProductDtoMapper;
import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.usecase.ProductUseCase;
import com.alten.product_trial.presentation.product.mapper.ProductVmMapper;
import com.alten.product_trial.presentation.product.vm.ProductVM;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity<List<ProductVM>> getAllProducts() {
        List<ProductVM> vms = productUseCase.getAllProducts()
            .stream()
            .map(ProductVmMapper::toViewModel)
            .collect(Collectors.toList());
        return ResponseEntity.ok(vms);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ProductVM> getProduct(@PathVariable UUID uuid) {
        ProductDto dto = productUseCase.getProductByUuid(uuid);
        return ResponseEntity.ok(ProductVmMapper.toViewModel(dto));
    }

    @PostMapping
    public ResponseEntity<ProductVM> createProduct(@Valid @RequestBody CreationProduct product) {
        ProductDto created = productUseCase.createProduct(product);
        return ResponseEntity.status(201).body(ProductVmMapper.toViewModel(created));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<ProductVM> updateProduct(@PathVariable UUID uuid, @Valid @RequestBody ProductVM productVM) {
        ProductDto updated = productUseCase.updateProduct(uuid,ProductDtoMapper.toDto(productVM));
        return ResponseEntity.ok(ProductVmMapper.toViewModel(updated));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid) {
        productUseCase.deleteProduct(uuid);
        return ResponseEntity.noContent().build();
    }

}
