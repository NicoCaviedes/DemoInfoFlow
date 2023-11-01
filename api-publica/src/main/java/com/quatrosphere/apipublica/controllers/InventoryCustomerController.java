package com.quatrosphere.apipublica.controllers;

import com.quatrosphere.apipublica.models.inventory.InventoryModelDto;
import com.quatrosphere.apipublica.services.InventoryService;
import com.quatrosphere.apipublica.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/private/inventory")
public class InventoryCustomerController {

    @Autowired
    private InventoryService invService;

    @Autowired
    private ProductService productService;

    @GetMapping("/{idComercio}")
    public ResponseEntity<List<InventoryModelDto>> getInventoryd(@PathVariable("idComercio") long idComercio){
        List<InventoryModelDto> inventarioComercio = invService.findByComercio(idComercio);
        if(inventarioComercio != null)
            return new ResponseEntity<>(inventarioComercio, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Boolean> saveProductInventory(@RequestBody InventoryModelDto inventory){
        try {
            System.out.println(inventory.transferToModel());
            System.out.println(invService.save(inventory.transferToModel()));
            /* invService.save(inventory.transferToModel());  */
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
