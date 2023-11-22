package com.quatrosphere.storeservice.models.entities.sales;

import com.quatrosphere.storeservice.models.entities.BaseEntity;
import com.quatrosphere.storeservice.models.entities.inventory.InventoryEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "deta_vta_comercio")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class DetailSaleEntity extends BaseEntity{
    
    @Id
    @Column(name = "id_detalle")
    private long idDetalle;

    @Column(name = "quantity_prods")
    private int quantityProds;

    @Column(name = "total_price")
    private long totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inv")
    private InventoryEntity inventoryProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sale")
    private SaleEntity saleHeader;
}
