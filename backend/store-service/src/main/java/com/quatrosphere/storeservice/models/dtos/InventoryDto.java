package com.quatrosphere.storeservice.models.dtos;

import java.util.List;

import com.quatrosphere.storeservice.models.entities.sales.DetailSaleEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDto {
    
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
    private List<DetailSaleEntity> listDetailsSales;

}
