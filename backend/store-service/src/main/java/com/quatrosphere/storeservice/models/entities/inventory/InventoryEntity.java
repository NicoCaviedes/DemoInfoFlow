package com.quatrosphere.storeservice.models.entities.inventory;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.BaseEntity;
import com.quatrosphere.storeservice.models.entities.sales.DetailSaleEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "inventory_store")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class InventoryEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inv")
    private long idInv;

    @Column(name = "quantity_prods")
    private long quantityProds;

    @Column(name = "unit_price_prod")
    private long unitPriceProd;

    @Column(name = "id_prod")
    private long idProd;

    @Column(name = "product_name")
    private String nombreProd;

    @Column(name = "barcode")
    private long codigoBarra;

    @Column(name = "product_type")
    private String tipoProducto;

    @Column(name = "net_weight")
    private int pesoNeto;

    @Column(name = "net_weight_unit")
    private String unidadPesoNeto;

    @Column(name = "id_Company")
    private long idCompany;

    @OneToMany(mappedBy = "inventoryProduct")
    private List<DetailSaleEntity> listDetailsSales;

}
