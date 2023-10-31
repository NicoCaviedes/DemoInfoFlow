package com.quatrosphere.apipublica.models.product;

import com.quatrosphere.apipublica.models.base.BaseDto;
import lombok.Data;
import lombok.ToString;

@Data @ToString
public class ProductModelDto extends BaseDto {

    private long idProducto;
    private String nombreProducto;
    private String nombreProveedor;
    private long codigoBarra;
    private String tipoProducto;
    private int pesoNeto;
    private String unidadPesoNeto;
    private String descProducto;

    @Override
    public Object transferToModel() {
        return null;
    }
}
