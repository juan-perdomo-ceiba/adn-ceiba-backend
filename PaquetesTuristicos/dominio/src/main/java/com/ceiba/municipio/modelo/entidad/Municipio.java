package com.ceiba.municipio.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Municipio {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO = "Se debe ingresar el codigo";

    private Long id;
    private String nombre;
    private String codigo;

    public Municipio(Long id, String nombre, String codigo) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO);
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }
}
