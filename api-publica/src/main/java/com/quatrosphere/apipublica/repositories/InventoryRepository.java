package com.quatrosphere.apipublica.repositories;

import com.quatrosphere.apipublica.models.customer.CustomerModel;
import com.quatrosphere.apipublica.models.inventory.InventoryModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends BaseRepository<InventoryModel>{
    @Query(value = "SELECT * FROM inventario_comercios WHERE id_empresa=?1 ORDER BY id_inv DESC", nativeQuery = true)
    public List<InventoryModel> findByIdEmpresa(long idComercio);
}
