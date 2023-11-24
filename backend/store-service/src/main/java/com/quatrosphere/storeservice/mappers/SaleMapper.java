package com.quatrosphere.storeservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.quatrosphere.storeservice.models.dtos.SaleDto;
import com.quatrosphere.storeservice.models.entities.sales.SaleEntity;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    
    SaleDto toSaleDto(SaleEntity saleEntity);
    List<SaleDto> toListSaleDtos(List<SaleEntity> listSaleEntities);
    SaleEntity toSaleEntity(SaleDto saleDto);
}
