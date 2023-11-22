package com.quatrosphere.storeservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatrosphere.storeservice.mappers.ProductMapper;
import com.quatrosphere.storeservice.models.dtos.ProductDto;
import com.quatrosphere.storeservice.models.entities.product.ProductEntity;
import com.quatrosphere.storeservice.repositories.ProductRepository;

@Service
public class ProductService extends BaseService<ProductEntity>{

    @Autowired
    private ProductMapper productMapper;

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public List<ProductDto> getAllProdDtos(){
        List<ProductDto> listProducts = productMapper.toListProductDtos(findAll());
        return listProducts;
    }
    
}
