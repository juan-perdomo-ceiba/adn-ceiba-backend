package com.ceiba.lugarturistico.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class LugarTuristico {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la clave";

    private Long id;
    private String nombre;
    private String descripcion;
    private Long idMunicipio;
    private String direccion;

    public LugarTuristico(Long id, String nombre, String descripcion, Long idMunicipio, String direccion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idMunicipio = idMunicipio;
        this.direccion = direccion;
    }
}
