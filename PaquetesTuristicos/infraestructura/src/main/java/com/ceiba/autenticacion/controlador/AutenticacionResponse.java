package com.ceiba.autenticacion.controlador;

import org.springframework.security.core.userdetails.UserDetails;

public class AutenticacionResponse {

    private UserDetails usuario;
    private String token;

    public UserDetails getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDetails usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
