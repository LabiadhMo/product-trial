package com.alten.product_trial.infra.product.service;

import static com.alten.product_trial.application.product.mapper.ProductDtoMapper.toDto;
import static com.alten.product_trial.infra.product.mapper.ProductMapper.mapCreationProduct;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import com.alten.product_trial.domain.entity.Product;
import com.alten.product_trial.domain.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(CreationProduct cp) {
        Product product = mapCreationProduct(cp);
        Product productBDD = productRepository.save(product);
        return toDto(productBDD);
    }

    @Override
    public ProductDto getProductById(UUID id) {
        Product productBDD = productRepository.getProductByUuid(id);
        return toDto(productBDD);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return toDto(products);
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductDto updatedProduct) {
        Product productBDD = productRepository.getProductByUuid(id);
        productBDD.setCode(updatedProduct.getCode());
        productBDD.setName(updatedProduct.getName());
        productBDD.setDescription(updatedProduct.getDescription());
        productBDD.setImage(updatedProduct.getImage());
        productBDD.setCategory(updatedProduct.getCategory());
        productBDD.setPrice(updatedProduct.getPrice());
        productBDD.setQuantity(updatedProduct.getQuantity());
        productBDD.setInternalReference(updatedProduct.getInternalReference());
        productBDD.setRating(updatedProduct.getRating());

        return toDto(productRepository.save(productBDD));
    }

    @Override
    public void deleteProduct(UUID id) {
        Product productBDD = productRepository.getProductByUuid(id);
        productRepository.delete(productBDD);
    }
}
