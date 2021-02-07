package com.ceiba.lugarturistico.servicio.testdatabuilder;

import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;

public class ComandoLugarTuristicoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long idMunicipio;
    private String direccion;

    public ComandoLugarTuristicoTestDataBuilder() {
        nombre = "Parque del Cafe";
        descripcion = "descripcion";
        idMunicipio = 1L;
        direccion = "Calle 1 # 7";
    }

    public ComandoLugarTuristicoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoLugarTuristicoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoLugarTuristicoTestDataBuilder conIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
        return this;
    }

    public ComandoLugarTuristicoTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoLugarTuristico build() {
        return new ComandoLugarTuristico(id,nombre, descripcion, idMunicipio, direccion);
    }
}
