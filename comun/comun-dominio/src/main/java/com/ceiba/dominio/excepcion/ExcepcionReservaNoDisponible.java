package com.ceiba.dominio.excepcion;

public class ExcepcionReservaNoDisponible extends RuntimeException {

    public ExcepcionReservaNoDisponible(String mensaje) {
        super(mensaje);
    }
}
