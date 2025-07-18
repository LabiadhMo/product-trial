package com.alten.product_trial.application.product.mapper;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.domain.entity.Product;
import com.alten.product_trial.presentation.product.vm.ProductVM;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setUuid(product.getUuid());
        productDto.setCode(product.getCode());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setInternalReference(product.getInternalReference());
        productDto.setRating(product.getRating() != null ? product.getRating() : 0.0);
        return productDto;
    }

    public static List<ProductDto> toDto(List<Product> product) {
        return product.stream().map(ProductDtoMapper::toDto).collect(Collectors.toList());
    }


}