package com.quatrosphere.storeservice.models.entities.product;

import com.quatrosphere.storeservice.models.entities.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "productos")
@Data @ToString
@EqualsAndHashCode(callSuper = false)
public class ProductEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private long idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;
    
    @Column(name = "codigo_barra")
    private long codigoBarra;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    @Column(name = "peso_neto")
    private int pesoNeto;

    @Column(name = "unidad_peso_neto")
    private String unidadPesoNeto;

    @Column(name = "desripcion_producto")
    private String descProducto;

    // @Override
    // public ProductModelDto transferToDto(){
    //     ProductModelDto productTrf = new ProductModelDto();
    //     productTrf.setIdProducto(this.idProducto);
    //     productTrf.setNombreProducto(this.nombreProducto);
    //     productTrf.setNombreProveedor(this.nombreProveedor);
    //     productTrf.setCodigoBarra(this.codigoBarra);
    //     productTrf.setTipoProducto(this.tipoProducto);
    //     productTrf.setPesoNeto(this.pesoNeto);
    //     productTrf.setUnidadPesoNeto(this.unidadPesoNeto);
    //     productTrf.setDescProducto(this.descProducto);
    //     return productTrf;
    // }
}
