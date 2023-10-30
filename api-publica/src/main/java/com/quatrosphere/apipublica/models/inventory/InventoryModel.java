package com.quatrosphere.apipublica.models.inventory;

import com.quatrosphere.apipublica.models.base.BaseModel;
import com.quatrosphere.apipublica.models.product.ProductModel;
import com.quatrosphere.apipublica.models.sales.DetailSaleModel;
import com.quatrosphere.apipublica.models.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "inventario_comercios")
@Data @ToString
public class InventoryModel extends BaseModel {

    @Id
    @Column(name = "id_inv")
    private long idInv;

    @Column(name = "id_prod")
    private long idProd;

    @Column(name = "quantity_prods")
    private long quantityProds;

    @Column(name = "unit_price_prod")
    private long unitPriceProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserModel user;

    @OneToMany(mappedBy = "inventoryProduct")
    private List<DetailSaleModel> listDetailsSales;

    @Override
    public InventoryModelDto transferToDto(){
        InventoryModelDto invTrf = new InventoryModelDto();

        invTrf.setIdInv(this.idInv);
        invTrf.setIdProd(this.idProd);
        invTrf.setQuantityProds(this.quantityProds);
        invTrf.setUnitPriceProd(this.unitPriceProd);
        invTrf.setUser(this.user.transferToDto());

        return invTrf;
    }
}
