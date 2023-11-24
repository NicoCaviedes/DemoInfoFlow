package com.quatrosphere.storeservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatrosphere.storeservice.mappers.InventoryMapper;
import com.quatrosphere.storeservice.models.dtos.InventoryDto;
import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;
import com.quatrosphere.storeservice.repositories.InventoryRepository;

@Service
public class InventoryService extends BaseService<InventoryEntity>{
    
    @Autowired
    private InventoryRepository invRepository;

    @Autowired
    private InventoryMapper inventoryMapper;

    public InventoryService(InventoryRepository repository) {
        super(repository);
    }

    public List<InventoryDto> findByComercio(long idComercio){
        List<InventoryDto> listProdsDto = inventoryMapper.toListInventoryDto(this.invRepository.findByIdEmpresa(idComercio));
        return listProdsDto;
    }
}
