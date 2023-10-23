package com.quatrosphere.apipublica.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "productos")
@Data @ToString
public class ProductModel{
    
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
    
}
