package com.quatrosphere.publicservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatrosphere.publicservice.mappers.ProductMapper;
import com.quatrosphere.publicservice.models.dtos.ProductDto;
import com.quatrosphere.publicservice.models.entities.products.ProductEntity;
import com.quatrosphere.publicservice.repositories.ProductRespository;

@Service
public class ProductService extends BaseService<ProductEntity>{
    
    @Autowired
    private ProductMapper productMapper;

    public ProductService(ProductRespository respository) {
        super(respository);
    }

    public List<ProductDto> getAllProdDtos() {
        List<ProductDto> listProducts = productMapper.toListProductDtos(findAll());
        return listProducts;
    }
}
