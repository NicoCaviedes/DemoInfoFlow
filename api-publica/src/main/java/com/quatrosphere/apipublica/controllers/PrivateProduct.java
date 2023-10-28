package com.quatrosphere.apipublica.controllers;

import com.quatrosphere.apipublica.models.ProductModel;
import com.quatrosphere.apipublica.models.ProductModelDto;
import com.quatrosphere.apipublica.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/private/products")
public class PrivateProduct {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModelDto>> getAllProducts(){
        try {
            List<ProductModelDto> listProducts = productService.findAll();

            if (listProducts.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
