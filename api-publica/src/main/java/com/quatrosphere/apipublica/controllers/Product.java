package com.quatrosphere.apipublica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quatrosphere.apipublica.models.ProductModel;
import com.quatrosphere.apipublica.services.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/productos")
@RestController
public class Product {

    @Autowired
    private ProductService prodService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getProducts() {
        try {
            List<ProductModel> listProducts = prodService.findAll();

            if (listProducts.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("id") long idProducto) {
        ProductModel productoEncontrado = prodService.findById(idProducto);
        if(productoEncontrado != null)
            return new ResponseEntity<ProductModel>(productoEncontrado, HttpStatus.OK);
        else    
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
