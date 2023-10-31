package com.quatrosphere.apipublica.models.sales;

import com.quatrosphere.apipublica.models.base.BaseModel;
import com.quatrosphere.apipublica.models.inventory.InventoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
@Entity
@Table(name = "deta_vta_comerio")
@Data @ToString
public class DetailSaleModel extends BaseModel {

    @Id
    @Column(name = "id_detalle")
    private long idDetalle;

    @Column(name = "quantity_prods")
    private int quantityProds;

    @Column(name = "total_price")
    private long totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inv")
    private InventoryModel inventoryProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sale")
    private SaleModel saleHeader;

    @Override
    public DetailSaleModelDto transferToDto(){
        DetailSaleModelDto detailTrf = new DetailSaleModelDto();

        detailTrf.setQuantityProds(this.quantityProds);
        detailTrf.setTotalPrice(this.totalPrice);
        detailTrf.setInventoryProduct(inventoryProduct.transferToDto());
        detailTrf.setSaleHeader(this.saleHeader.transferToDto());

        return detailTrf;
    }
}
