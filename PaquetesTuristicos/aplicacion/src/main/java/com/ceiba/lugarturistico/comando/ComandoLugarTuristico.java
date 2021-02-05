package com.ceiba.lugarturistico.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoLugarTuristico {

    private Long id;
    private String nombre;
    private String descripcion;
}
