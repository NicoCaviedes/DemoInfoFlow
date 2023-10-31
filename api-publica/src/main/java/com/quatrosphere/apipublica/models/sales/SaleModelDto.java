package com.quatrosphere.apipublica.models.sales;

import com.quatrosphere.apipublica.models.base.BaseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data @ToString
@EqualsAndHashCode(callSuper=false)
public class SaleModelDto extends BaseDto {

    private long idSale;
    private long totProds;
    private long totalPriceSale;
    private List<DetailSaleModelDto> detailSale;

    @Override
    public Object transferToModel() {
        return null;
    }
}
