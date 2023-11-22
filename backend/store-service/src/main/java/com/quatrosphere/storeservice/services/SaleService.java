package com.quatrosphere.storeservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quatrosphere.storeservice.mappers.SaleMapper;
import com.quatrosphere.storeservice.models.dtos.SaleDto;
import com.quatrosphere.storeservice.models.entities.sales.SaleEntity;
import com.quatrosphere.storeservice.repositories.SaleRepository;

@Service
public class SaleService extends BaseService<SaleEntity>{
    
    @Autowired
    private SaleMapper saleMapper;

    public SaleService(SaleRepository repository) {
        super(repository);
    }

    public List<SaleDto> getAllSales(){
        List<SaleDto> saleDto = saleMapper.toListSaleDtos(findAll());
        return saleDto;
    }
}
