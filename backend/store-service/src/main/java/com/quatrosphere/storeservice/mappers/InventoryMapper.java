package com.quatrosphere.storeservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.quatrosphere.storeservice.models.dtos.InventoryDto;
import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    
    InventoryDto toInventoryDto(InventoryEntity inventoryEntity);
    List<InventoryDto> toListInventoryDto(List<InventoryEntity> listInventoryEntities);
    InventoryEntity toInventoryEntity(InventoryDto inventoryDto);
}
