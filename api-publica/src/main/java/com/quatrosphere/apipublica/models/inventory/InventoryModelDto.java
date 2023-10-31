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
    private long quantityProds;
    private long unitPriceProd;
    private long idProd;
    private String nombreProd;
    private long codigoBarra;
    private String tipoProducto;
    private int pesoNeto;
    private String unidadPesoNeto;
    private long idEmpresa;

    @Override
    public InventoryModel transferToModel() {
        InventoryModel invTrf = new InventoryModel();
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
