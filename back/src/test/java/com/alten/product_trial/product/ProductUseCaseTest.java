package com.alten.product_trial.product;

import static com.alten.product_trial.product.factory.ProductFactory.CreationProductFactory;
import static com.alten.product_trial.product.factory.ProductFactory.createProduct;
import static com.alten.product_trial.product.factory.ProductFactory.createProductDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.alten.product_trial.application.product.model.CreationProduct;
import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import com.alten.product_trial.application.product.usecase.ProductUseCase;
import com.alten.product_trial.domain.entity.Product;
import com.alten.product_trial.domain.repository.ProductRepository;
import com.alten.product_trial.infra.product.service.ProductServiceImpl;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductUseCaseTest {


    private ProductUseCase productUseCase;

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        // Use real service but with mocked repository
        productService = new ProductServiceImpl(productRepository);
        productUseCase = new ProductUseCase(productService);
    }

    @Test
    void should_create_product() {
        // given
        CreationProduct product = CreationProductFactory(); // remplace ceci avec un objet concret si besoin
        Product productBDD = createProduct();
        when(productRepository.save(any())).thenReturn(productBDD);

        // when
        ProductDto result = productUseCase.createProduct(product);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCode()).isEqualTo(product.getCode());
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void should_update_product() {
        ProductDto productDto = createProductDto();
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");
        Product productBDD = createProduct();

        when(productRepository.getProductByUuid(uuid)).thenReturn(productBDD);
        when(productRepository.save(any())).thenReturn(productBDD);

        ProductDto result = productUseCase.updateProduct(uuid, productDto);

        assertThat(productDto.getCode()).isEqualTo(result.getCode());
        verify(productRepository).save(productBDD);
    }

    @Test
    void should_delete_product() {
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");
        Product productBDD = createProduct();

        when(productRepository.getProductByUuid(uuid)).thenReturn(productBDD);

        assertDoesNotThrow(() -> productUseCase.deleteProduct(uuid));
        verify(productRepository).delete(productBDD);
    }

    @Test
    void should_get_product_by_uuid() {
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");
        Product productBDD = createProduct();

        when(productRepository.getProductByUuid(uuid)).thenReturn(productBDD);

        ProductDto result = productUseCase.getProductByUuid(uuid);

        assertThat(result).isNotNull();
        verify(productRepository).getProductByUuid(uuid);
    }

    @Test
    void should_get_all_products() {
        Product productBDD = createProduct();

        when(productRepository.findAll()).thenReturn(List.of(productBDD));

        List<ProductDto> result = productUseCase.getAllProducts();

        assertThat(result.size()).isEqualTo(1);
    }
}
