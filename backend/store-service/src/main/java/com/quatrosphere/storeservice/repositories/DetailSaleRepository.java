package com.quatrosphere.storeservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;
import com.quatrosphere.storeservice.models.entities.sales.DetailSaleEntity;

public interface DetailSaleRepository extends BaseRepository<DetailSaleEntity>{
    @Query(value = "SELECT * FROM inventario_comercios WHERE id_empresa=?1 ORDER BY id_inv DESC", nativeQuery = true)
    public List<InventoryEntity> findByIdEmpresa(long idComercio);
}
