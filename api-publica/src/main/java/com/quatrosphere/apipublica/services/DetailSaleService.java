package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.sales.DetailSaleModel;
import com.quatrosphere.apipublica.repositories.BaseRepository;
import com.quatrosphere.apipublica.repositories.DetailSaleRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailSaleService extends BaseService<DetailSaleModel>{
    public DetailSaleService(DetailSaleRepository repository) {
        super(repository);
    }
}
