package com.quatrosphere.storeservice.models.dtos;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.sales.DetailSaleEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaleDto {
    
    private long idSale;
    private long totProds;
    private long totalPriceSale;
    private List<DetailSaleEntity> detailSale;
}
