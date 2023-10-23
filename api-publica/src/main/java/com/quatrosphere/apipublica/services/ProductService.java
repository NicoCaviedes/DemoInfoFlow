package com.quatrosphere.apipublica.services;

import org.springframework.stereotype.Service;

import com.quatrosphere.apipublica.models.ProductModel;
import com.quatrosphere.apipublica.repositories.ProductRepository;

@Service
public class ProductService extends BaseService<ProductModel>{


    public ProductService(ProductRepository repository) {
        super(repository);
    }
    
}
