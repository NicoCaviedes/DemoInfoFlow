package com.quatrosphere.apipublica.controllers;

import com.quatrosphere.apipublica.models.sales.SaleModelDto;
import com.quatrosphere.apipublica.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/private/sales")
public class SaleConsumerController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleModelDto>> getAllSells(){
        try {
            List<SaleModelDto> listSales = saleService.getAllSales();

            if (listSales.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listSales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleModelDto> getSale(@PathVariable("id") long idSale){
        SaleModelDto vtaEncontrada = saleService.findById(idSale).transferToDto();
        if(vtaEncontrada != null)
            return new ResponseEntity<SaleModelDto>(vtaEncontrada, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
