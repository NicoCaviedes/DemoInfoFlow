package com.quatrosphere.publicservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quatrosphere.publicservice.mappers.ProductMapper;
import com.quatrosphere.publicservice.models.dtos.ProductDto;
import com.quatrosphere.publicservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired 
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        
        try {
            List<ProductDto> products = productService.getAllProdDtos();
            if(products.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("idProduct") long idProduct) {
        
        try {
            ProductDto products = productMapper.toProductDto(productService.findById(idProduct));
            return new ResponseEntity<>(products, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
