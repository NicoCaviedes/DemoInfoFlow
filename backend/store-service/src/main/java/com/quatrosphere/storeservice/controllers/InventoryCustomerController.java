package com.quatrosphere.storeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.quatrosphere.storeservice.mappers.InventoryMapper;
import com.quatrosphere.storeservice.models.dtos.InventoryDto;
import com.quatrosphere.storeservice.services.InventoryService;


@Controller
@RequestMapping("/inventory")
public class InventoryCustomerController {
    
    @Autowired
    private InventoryService invService;

    @Autowired
    private InventoryMapper inventoryMapper;

    @GetMapping("/{idComercio}")
    public ResponseEntity<List<InventoryDto>> getInvetory(@PathVariable("idComercio") long idComercio){
        List<InventoryDto> inventarioComercio = invService.findByComercio(idComercio);
        if(inventarioComercio != null)
            return new ResponseEntity<>(inventarioComercio, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveProductInventory(@RequestBody InventoryDto inventoryDto){
        try {
            invService.save(inventoryMapper.toInventoryEntity(inventoryDto));
            return new ResponseEntity<>("El producto se guardo correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No se logró guardar el producto.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}