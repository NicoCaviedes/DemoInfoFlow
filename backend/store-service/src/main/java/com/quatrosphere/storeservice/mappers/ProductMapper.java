package com.quatrosphere.storeservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.quatrosphere.storeservice.models.dtos.ProductDto;
import com.quatrosphere.storeservice.models.entities.product.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    ProductDto toProductDto(ProductEntity productEntity);
    List<ProductDto> toListProductDtos(List<ProductEntity> listpProductEntities);
    ProductEntity toProductEntity(ProductDto productDto);
}
