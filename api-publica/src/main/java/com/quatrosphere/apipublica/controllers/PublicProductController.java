package com.quatrosphere.apipublica.controllers;

import java.util.List;

import com.quatrosphere.apipublica.models.product.ProductModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quatrosphere.apipublica.services.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/products")
@RestController
public class PublicProductController {

    @Autowired
    private ProductService prodService;

    @GetMapping
    public ResponseEntity<List<ProductModelDto>> getAllProducts() {
        try {
            List<ProductModelDto> listProducts = prodService.getAllProdDtos();

            if (listProducts.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModelDto> getProduct(@PathVariable("id") long idProducto) {
        ProductModelDto productoEncontrado = prodService.findById(idProducto).transferToDto();
        if(productoEncontrado != null)
            return new ResponseEntity<ProductModelDto>(productoEncontrado, HttpStatus.OK);
        else    
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
