package com.ceiba.paqueteturistico.servicio.testdatabuilder;

import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;

import java.math.BigDecimal;

public class PaqueteTuristicoTestDataBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidadMaximaPersonas;
    private int cantidadMaximaReservas;
    private BigDecimal precioPorPersona;
    private Long idLugarTuristico;

    public PaqueteTuristicoTestDataBuilder() {
        nombre = "Parque Gold";
        descripcion = "descripcion";
        cantidadMaximaPersonas = 50;
        cantidadMaximaReservas = 20;
        precioPorPersona = BigDecimal.valueOf(50000);
        idLugarTuristico = 1L;
    }

    public PaqueteTuristicoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PaqueteTuristico build() {
        return new PaqueteTuristico(id, nombre, descripcion, cantidadMaximaPersonas, cantidadMaximaReservas, precioPorPersona, idLugarTuristico);
    }
}
