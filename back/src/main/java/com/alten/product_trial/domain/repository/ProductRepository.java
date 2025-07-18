package com.alten.product_trial.domain.repository;

import com.alten.product_trial.domain.entity.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductByUuid(UUID uuid);
}
