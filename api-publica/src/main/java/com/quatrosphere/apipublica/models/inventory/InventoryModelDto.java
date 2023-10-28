package com.quatrosphere.apipublica.models.inventory;

import com.quatrosphere.apipublica.models.base.BaseDto;
import com.quatrosphere.apipublica.models.sales.DetailSaleModel;
import com.quatrosphere.apipublica.models.user.UserModel;
import com.quatrosphere.apipublica.models.user.UserModelDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data @ToString
public class InventoryModelDto extends BaseDto {

    private long idInv;
    private long idProd;
    private long quantityProds;
    private long unitPriceProd;
    private UserModelDto user;

    @Override
    public Object transferToModel() {
        return null;
    }
}
