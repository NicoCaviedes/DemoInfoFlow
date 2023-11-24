package com.quatrosphere.storeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.quatrosphere.storeservice.mappers.SaleMapper;
import com.quatrosphere.storeservice.models.dtos.SaleDto;
import com.quatrosphere.storeservice.services.SaleService;

@Controller
@RequestMapping("/sales")
public class SaleConsumerController {
    
    @Autowired
    private SaleService saleService;
    
    @Autowired
    private SaleMapper saleMapper;

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSells(){
        try {
            List<SaleDto> listSales = saleService.getAllSales();

            if (listSales.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listSales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> getSale(@PathVariable("id") long idSale){
        SaleDto vtaEncontrada = saleMapper.toSaleDto(saleService.findById(idSale));
        if(vtaEncontrada != null)
            return new ResponseEntity<SaleDto>(vtaEncontrada, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
