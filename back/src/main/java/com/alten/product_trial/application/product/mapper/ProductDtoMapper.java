package com.alten.product_trial.application.product.mapper;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.presentation.product.vm.ProductVM;

public class ProductDtoMapper {

    public static ProductDto toDto(ProductVM productVM) {
        ProductDto productDto = new ProductDto();
        productDto.setUuid(productVM.getUuid());
        productDto.setCode(productVM.getCode());
        productDto.setName(productVM.getName());
        productDto.setDescription(productVM.getDescription());
        productDto.setImage(productVM.getImage());
        productDto.setCategory(productVM.getCategory());
        productDto.setPrice(productVM.getPrice());
        productDto.setQuantity(productVM.getQuantity());
        productDto.setInternalReference(productVM.getInternalReference());
        productDto.setRating(productVM.getRating() != null ? productVM.getRating() : 0.0);
        return productDto;
    }
}