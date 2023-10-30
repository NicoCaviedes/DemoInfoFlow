package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.inventory.InventoryModel;
import com.quatrosphere.apipublica.models.inventory.InventoryModelDto;
import com.quatrosphere.apipublica.repositories.BaseRepository;
import com.quatrosphere.apipublica.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService extends BaseService<InventoryModel>{
    public InventoryService(InventoryRepository repository) {
        super(repository);
    }

    public List<InventoryModelDto> getAllProds(){
        List<InventoryModelDto> listProdsDto = new ArrayList();

        this.findAll().forEach(inventoryModel -> {
            listProdsDto.add(inventoryModel.transferToDto());
        });
        return listProdsDto;
    }
}
