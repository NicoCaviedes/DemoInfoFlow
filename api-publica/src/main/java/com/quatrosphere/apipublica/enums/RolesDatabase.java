package com.quatrosphere.apipublica.enums;

public enum RolesDatabase {
    USER(1),
    CLIENTE(2),
    PROVEEDOR(3),
    ADMIN(4);

    private int IDRol;

    RolesDatabase(int idRol) {
        this.IDRol = idRol;
    }
    
    public int getIDRol(){
        return IDRol;
    }
}
