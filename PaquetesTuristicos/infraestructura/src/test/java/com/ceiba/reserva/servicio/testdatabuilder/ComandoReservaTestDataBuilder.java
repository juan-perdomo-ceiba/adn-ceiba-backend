package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ComandoReservaTestDataBuilder {

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

    public ComandoReservaTestDataBuilder() {
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

    public ComandoReservaTestDataBuilder conFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
        return this;
    }

    public ComandoReservaTestDataBuilder conCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
        return this;
    }

    public ComandoReservaTestDataBuilder conTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
        return this;
    }

    public ComandoReservaTestDataBuilder conEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
        return this;
    }

    public ComandoReservaTestDataBuilder conNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdPaqueteTuristico(Long idPaqueteTuristico) {
        this.idPaqueteTuristico = idPaqueteTuristico;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdPaqueteTuristico(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public ComandoReservaTestDataBuilder conIdentificadorReserva(String identificadorReserva) {
        this.identificadorReserva = identificadorReserva;
        return this;
    }

    public ComandoReservaTestDataBuilder conPrecio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(id, fechaReserva, cedulaCliente, nombreCliente, telefonoCliente, emailCliente, numeroPersonas, idPaqueteTuristico, observaciones, identificadorReserva, precio);
    }
}
