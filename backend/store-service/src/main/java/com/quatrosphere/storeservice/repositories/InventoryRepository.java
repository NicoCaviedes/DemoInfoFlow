package com.quatrosphere.storeservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;


public interface InventoryRepository extends BaseRepository<InventoryEntity>{
    
    @Query(value = "select * from inventory_store where id_company = ?1", nativeQuery = true)
    List<InventoryEntity> findByIdEmpresa(long idEmpresa);
}
