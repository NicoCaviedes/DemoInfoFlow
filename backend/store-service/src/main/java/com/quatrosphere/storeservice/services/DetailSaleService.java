package com.quatrosphere.storeservice.services;

import org.springframework.stereotype.Service;

import com.quatrosphere.storeservice.models.entities.sales.DetailSaleEntity;
import com.quatrosphere.storeservice.repositories.DetailSaleRepository;

@Service
public class DetailSaleService extends BaseService<DetailSaleEntity>{

    public DetailSaleService(DetailSaleRepository repository) {
        super(repository);
    }
}
