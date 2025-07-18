package com.alten.product_trial.infra.product.mapper;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.domain.entity.Product;

public class ProductMapper {
    public static Product mapCreationProduct(CreationProduct creationProduct) {
        return Product.builder()
            .code(creationProduct.getCode())
            .name(creationProduct.getName())
            .description(creationProduct.getDescription())
            .image(creationProduct.getImage())
            .category(creationProduct.getCategory())
            .price(creationProduct.getPrice())
            .quantity(creationProduct.getQuantity())
            .internalReference(creationProduct.getInternalReference())
            .shellId(creationProduct.getShellId())
            .inventoryStatus(creationProduct.getInventoryStatus())
            .rating(creationProduct.getRating())
            .build();
    }
}
