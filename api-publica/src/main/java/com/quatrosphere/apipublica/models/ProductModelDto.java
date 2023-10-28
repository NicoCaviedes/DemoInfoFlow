package com.quatrosphere.apipublica.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class ProductModelDto {

    private long idProducto;
    private String nombreProducto;
    private String nombreProveedor;
    private long codigoBarra;
    private String tipoProducto;
    private int pesoNeto;
    private String unidadPesoNeto;
    private String descProducto;

    public ProductModel transferToDto(){
        ProductModel productTrf = new ProductModel();
        productTrf.setIdProducto(this.idProducto);
        productTrf.setNombreProveedor(this.nombreProveedor);
        productTrf.setCodigoBarra(this.codigoBarra);
        productTrf.setTipoProducto(this.tipoProducto);
        productTrf.setPesoNeto(this.pesoNeto);
        productTrf.setUnidadPesoNeto(this.unidadPesoNeto);
        productTrf.setDescProducto(this.descProducto);
        return productTrf;
    }
}
