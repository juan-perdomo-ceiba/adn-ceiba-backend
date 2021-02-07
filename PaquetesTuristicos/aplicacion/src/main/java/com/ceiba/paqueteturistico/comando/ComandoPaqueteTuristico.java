package com.ceiba.paqueteturistico.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPaqueteTuristico {

    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidadMaximaPersonas;
    private int cantidadMaximaReservas;
    private BigDecimal precioPorPersona;
    private Long idLugarTuristico;
}
