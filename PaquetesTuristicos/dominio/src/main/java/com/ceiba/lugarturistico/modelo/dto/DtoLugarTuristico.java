package com.ceiba.lugarturistico.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoLugarTuristico {
    private Long id;
    private String nombre;
    private String descripcion;
}
