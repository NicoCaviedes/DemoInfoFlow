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

    @Column(name = "quantity_prods")
    private long quantityProds;

    @Column(name = "unit_price_prod")
    private long unitPriceProd;

    @Column(name = "id_prod")
    private long idProd;

    @Column(name = "nombre_producto")
    private String nombreProd;

    @Column(name = "codigo_barra")
    private long codigoBarra;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "peso_neto")
    private int pesoNeto;

    @Column(name = "unidad_peso_neto")
    private String unidadPesoNeto;

    @Column(name = "id_empresa")
    private long idEmpresa;

    @OneToMany(mappedBy = "inventoryProduct")
    private List<DetailSaleModel> listDetailsSales;

    @Override
    public InventoryModelDto transferToDto(){
        InventoryModelDto invTrf = new InventoryModelDto();

        invTrf.setIdInv(this.idInv);
        invTrf.setQuantityProds(this.quantityProds);
        invTrf.setUnitPriceProd(this.unitPriceProd);
        invTrf.setIdProd(this.idProd);
        invTrf.setNombreProd(this.nombreProd);
        invTrf.setCodigoBarra(this.codigoBarra);
        invTrf.setTipoProducto(this.tipoProducto);
        invTrf.setPesoNeto(this.pesoNeto);
        invTrf.setUnidadPesoNeto(this.unidadPesoNeto);
        invTrf.setIdEmpresa(this.idEmpresa);
        return invTrf;
    }
}
