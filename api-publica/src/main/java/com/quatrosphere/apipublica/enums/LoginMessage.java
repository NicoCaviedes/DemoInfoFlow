package com.quatrosphere.apipublica.enums;

public enum LoginMessage {
    NOT_FOUND("No se encontro el usuario en la base de datos"),
    FOUND_NOT_EQUAL_PASS("La contraseña no es correcta."),
    USER_EXISTS("Usuario verificado correctamente"),
    INTERNAL_ERROR("Problema en el sistema, intentelo mas tarde");
    private String message;

    LoginMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
