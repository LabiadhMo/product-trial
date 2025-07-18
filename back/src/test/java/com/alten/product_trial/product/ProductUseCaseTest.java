package com.alten.product_trial.product;

import static com.alten.product_trial.product.factory.ProductFactory.createProductDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.alten.product_trial.application.product.model.ProductDto;
import com.alten.product_trial.application.product.service.ProductService;
import com.alten.product_trial.application.product.usecase.ProductUseCase;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class ProductUseCaseTest {

    @InjectMocks
    private final ProductUseCase productUseCase;

    @Mock
    private final ProductService productService;

    @Test
    void should_create_product() {
        ProductDto productDto = createProductDto();

        when(productService.createProduct(productDto)).thenReturn(productDto);

        ProductDto result = productUseCase.createProduct(productDto);

        assertThat(result).isNotNull();
        assertThat(productDto.getCode()).isEqualTo(result.getCode());
        verify(productService).createProduct(productDto);
    }

    @Test
    void should_update_product() {
        ProductDto productDto = createProductDto();
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");

        when(productService.updateProduct(any(), eq(productDto))).thenReturn(productDto);

        ProductDto result = productUseCase.updateProduct(uuid, productDto);

        assertThat(productDto.getCode()).isEqualTo(result.getCode());
        verify(productService).updateProduct(any(), eq(productDto));
    }

    @Test
    void should_delete_product() {
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");

        doNothing().when(productService).deleteProduct(any());

        assertDoesNotThrow(() -> productUseCase.deleteProduct(uuid));
        verify(productService).deleteProduct(any());
    }

    @Test
    void should_get_product_by_uuid() {
        ProductDto productDto = createProductDto();
        UUID uuid = UUID.fromString("6877fdd0-2790-8013-9237-1a8812354678");

        when(productService.getProductById(any())).thenReturn(productDto);

        ProductDto result = productUseCase.getProductByUuid(uuid);

        assertThat(result).isNotNull();
        verify(productService).getProductById(any());
    }

    @Test
    void should_get_all_products() {
        ProductDto productDto = createProductDto();

        when(productService.getAllProducts()).thenReturn(List.of(productDto));

        List<ProductDto> result = productUseCase.getAllProducts();

        assertThat(result.size()).isEqualTo(1);
        verify(productService).getAllProducts();
    }
}
