package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ReservaTestDataBuilder {
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


    public ReservaTestDataBuilder() {
        fechaReserva = LocalDate.now();
        cedulaCliente = "1094955026";
        nombreCliente = "Juan Jose";
        telefonoCliente = "3159687452";
        emailCliente = "juan.perdomo@ceiba,com.co";
        numeroPersonas = 5;
        idPaqueteTuristico = 1L;
        observaciones = "llgaremos muy temprano al sitio";
        identificadorReserva = UUID.randomUUID().toString();
        precio = new BigDecimal(500000);
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Reserva build() {
        return new Reserva(id,fechaReserva, cedulaCliente, nombreCliente, telefonoCliente, emailCliente, numeroPersonas, idPaqueteTuristico, observaciones, identificadorReserva, precio);
    }
}
