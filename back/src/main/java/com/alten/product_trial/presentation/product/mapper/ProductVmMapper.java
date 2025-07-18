package com.alten.product_trial.presentation.product.mapper;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.presentation.product.vm.ProductVM;

public class ProductVmMapper {

    public static ProductVM toViewModel(ProductDto dto) {
        ProductVM vm = new ProductVM();
        vm.setUuid(dto.getUuid());
        vm.setCode(dto.getCode());
        vm.setName(dto.getName());
        vm.setDescription(dto.getDescription());
        vm.setImage(dto.getImage());
        vm.setCategory(dto.getCategory());
        vm.setPrice(dto.getPrice());
        vm.setQuantity(dto.getQuantity());
        vm.setInternalReference(dto.getInternalReference());
        vm.setRating(dto.getRating() != null ? dto.getRating() : 0.0);
        return vm;
    }
}