package com.quatrosphere.storeservice.repositories;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;


public interface InventoryRepository extends BaseRepository<InventoryEntity>{
    
    List<InventoryEntity> findByIdEmpresa(long idEmpresa);
}
