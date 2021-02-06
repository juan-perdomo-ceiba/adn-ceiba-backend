package com.ceiba.paqueteturistico.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPaqueteTuristico {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaReserva;
    private int cantidadMaximaPersonas;
    private int cantidadMaximaReservas;
    private BigDecimal precioPorPersona;
    private Long idLugarTuristico;
}
