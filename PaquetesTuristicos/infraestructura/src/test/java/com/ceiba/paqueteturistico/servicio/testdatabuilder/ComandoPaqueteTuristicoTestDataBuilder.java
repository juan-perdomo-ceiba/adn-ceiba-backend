package com.ceiba.paqueteturistico.servicio.testdatabuilder;

import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;

import java.math.BigDecimal;

public class ComandoPaqueteTuristicoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidadMaximaPersonas;
    private int cantidadMaximaReservas;
    private BigDecimal precioPorPersona;
    private Long idLugarTuristico;

    public ComandoPaqueteTuristicoTestDataBuilder() {
        nombre = "Parque Gold";
        descripcion = "descripcion";
        cantidadMaximaPersonas = 50;
        cantidadMaximaReservas = 20;
        precioPorPersona = BigDecimal.valueOf(50000);
        idLugarTuristico = 1L;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conCantidadMaximaPersonas(int cantidadMaximaPersonas) {
        this.cantidadMaximaPersonas = cantidadMaximaPersonas;
        return this;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conCantidadMaximaReservas(int cantidadMaximaReservas) {
        this.cantidadMaximaReservas = cantidadMaximaReservas;
        return this;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conPrecioPorPersona(BigDecimal precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
        return this;
    }

    public ComandoPaqueteTuristicoTestDataBuilder conIdLugarTuristico(Long idLugarTuristico) {
        this.idLugarTuristico = idLugarTuristico;
        return this;
    }

    public ComandoPaqueteTuristico build() {
        return new ComandoPaqueteTuristico(id, nombre, descripcion, cantidadMaximaPersonas, cantidadMaximaReservas, precioPorPersona, idLugarTuristico);
    }
}
