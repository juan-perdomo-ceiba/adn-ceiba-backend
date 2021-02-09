package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private LocalDate fechaReserva;
    private String cedulaCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String emailCliente;
    private int numeroPersonas;
    private Long idPaqueteTuristico;
    private String observaciones;
    private String identificadorReserva;
    private BigDecimal precio;
}
