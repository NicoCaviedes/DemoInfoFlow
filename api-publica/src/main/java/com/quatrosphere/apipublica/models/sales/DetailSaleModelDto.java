package com.quatrosphere.apipublica.models.sales;

import com.quatrosphere.apipublica.models.base.BaseDto;
import com.quatrosphere.apipublica.models.inventory.InventoryModel;
import com.quatrosphere.apipublica.models.inventory.InventoryModelDto;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data@ToString
public class DetailSaleModelDto extends BaseDto {
    private int quantityProds;
    private long totalPrice;
    private InventoryModelDto inventoryProduct;
    private SaleModelDto saleHeader;

    @Override
    public Object transferToModel() {
        return null;
    }
}
