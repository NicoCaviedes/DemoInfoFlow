package com.quatrosphere.storeservice.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    
    private long idProducto;
    private String nombreProducto;
    private String nombreProveedor;
    private long codigoBarra;
    private String tipoProducto;
    private int pesoNeto;
    private String unidadPesoNeto;
    private String descProducto;
}
