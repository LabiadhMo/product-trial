package com.alten.product_trial.product.factory;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.domain.entity.Product;
import com.alten.product_trial.domain.model.InventoryStatus;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductFactory {

    public static Product createProduct() {

        return Product.builder()
            .id(1L)
            .uuid(UUID.randomUUID())
            .code("PRD-001")
            .name("Test Product")
            .description("A sample test product")
            .image("http://example.com/image.jpg")
            .category("Books")
            .price(BigDecimal.valueOf(49.99))
            .quantity(10)
            .internalReference("REF-123")
            .shellId(1001L)
            .inventoryStatus(InventoryStatus.INSTOCK)
            .rating(4.5)
            .build();
    }

    public static ProductDto createProductDto() {
        return ProductDto.builder()
            .uuid(UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678"))
            .code("PRD-001")
            .name("Test Product")
            .description("A sample test product")
            .image("http://example.com/image.jpg")
            .category("Books")
            .price(BigDecimal.valueOf(49.99))
            .quantity(10)
            .internalReference("REF-123")
            .shellId(1001L)
            .inventoryStatus(InventoryStatus.INSTOCK)
            .rating(4.5)
            .build();
    }

    public static CreationProduct CreationProductFactory() {
        return CreationProduct.builder()
            .code("PRD-001")
            .name("Test Product")
            .description("A sample test product")
            .image("http://example.com/image.jpg")
            .category("Books")
            .price(BigDecimal.valueOf(49.99))
            .quantity(10)
            .internalReference("REF-123")
            .shellId(1001L)
            .inventoryStatus(InventoryStatus.INSTOCK)
            .rating(4.5)
            .build();
    }


}
