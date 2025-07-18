package com.alten.product_trial.presentation.product.vm;

import com.alten.product_trial.domain.model.InventoryStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductVM {

    private UUID uuid;
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private BigDecimal price;
    private int quantity;
    private String internalReference;
    private Long shellId;
    private InventoryStatus inventoryStatus;
    private Double rating;

}
