package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

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
