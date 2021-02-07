package com.ceiba.lugarturistico.servicio.testdatabuilder;

import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;

public class LugarTuristicoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long idMunicipio;
    private String direccion;

    public LugarTuristicoTestDataBuilder() {
        nombre = "Parque del Cafe";
        descripcion = "descripcion";
        idMunicipio = 1L;
        direccion = "Calle 1 # 7";
    }

    public LugarTuristicoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public LugarTuristico build() {
        return new LugarTuristico(id, nombre, descripcion, idMunicipio, direccion);
    }
}
