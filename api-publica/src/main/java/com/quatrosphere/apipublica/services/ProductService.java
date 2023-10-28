package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.product.ProductModelDto;
import org.springframework.stereotype.Service;

import com.quatrosphere.apipublica.models.product.ProductModel;
import com.quatrosphere.apipublica.repositories.ProductRepository;

import java.util.*;

@Service
public class ProductService extends BaseService<ProductModel>{


    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public List<ProductModelDto> getAllProdDtos(){
        List<ProductModelDto> listProducts = new ArrayList();
        this.findAll().forEach(productModel -> {
            listProducts.add(productModel.transferToDto());
        });

        return listProducts;
    }

}
