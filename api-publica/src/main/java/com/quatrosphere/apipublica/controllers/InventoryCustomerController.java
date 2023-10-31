package com.quatrosphere.apipublica.controllers;

import com.quatrosphere.apipublica.models.inventory.InventoryModelDto;
import com.quatrosphere.apipublica.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/private/inventory")
public class InventoryCustomerController {

    @Autowired
    private InventoryService invService;

    @GetMapping
    public ResponseEntity<List<InventoryModelDto>> getAllProds(){
        try {
            List<InventoryModelDto> listProds = invService.getAllProds();

            if (listProds.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listProds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryModelDto> getProductInv(@PathVariable("id") long idProdInv){
        InventoryModelDto productoEncontrado = invService.findById(idProdInv).transferToDto();
        if(productoEncontrado != null)
            return new ResponseEntity<>(productoEncontrado, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
