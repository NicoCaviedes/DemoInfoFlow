package com.quatrosphere.publicservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.quatrosphere.publicservice.models.dtos.ProductDto;
import com.quatrosphere.publicservice.models.entities.products.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    ProductDto toProductDto(ProductEntity productEntity);
    List<ProductDto> toListProductDtos(List<ProductEntity> listpProductEntities);
    ProductEntity toProductEntity(ProductDto productDto);
}
