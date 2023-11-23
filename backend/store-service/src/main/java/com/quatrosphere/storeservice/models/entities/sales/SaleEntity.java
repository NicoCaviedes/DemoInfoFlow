package com.quatrosphere.storeservice.models.entities.sales;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Table(name = "ventas_comercio")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class SaleEntity extends BaseEntity{
    
    @Id
    @Column(name = "id_sale")
    private long idSale;

    @Column(name = "tot_prods")
    private long totProds;

    @Column(name = "total_price_sale")
    private long totalPriceSale;

    @OneToMany(mappedBy = "saleHeader")
    private List<DetailSaleEntity> detailSale;

    // @Override
    // public DetailSaleModelDto transferToDto(){
    //     DetailSaleModelDto detailTrf = new DetailSaleModelDto();

    //     detailTrf.setQuantityProds(this.quantityProds);
    //     detailTrf.setTotalPrice(this.totalPrice);
    //     detailTrf.setInventoryProduct(inventoryProduct.transferToDto());
    //     detailTrf.setSaleHeader(this.saleHeader.transferToDto());

    //     return detailTrf;
    // }
}
