package com.quatrosphere.apipublica.services;

import com.quatrosphere.apipublica.models.sales.SaleModel;
import com.quatrosphere.apipublica.models.sales.SaleModelDto;
import com.quatrosphere.apipublica.repositories.BaseRepository;
import com.quatrosphere.apipublica.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService extends BaseService<SaleModel> {

    public SaleService(SaleRepository repository) {
        super(repository);
    }

    public List<SaleModelDto> getAllSales(){
        List<SaleModelDto> saleDto = new ArrayList();

        this.findAll().forEach(saleModel -> {
            saleDto.add(saleModel.transferToDto());
        });

        return saleDto;
    }
}
