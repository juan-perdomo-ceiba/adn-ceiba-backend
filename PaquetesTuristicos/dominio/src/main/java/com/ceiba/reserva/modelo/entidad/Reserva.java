package com.ceiba.reserva.modelo.entidad;


import com.ceiba.reserva.util.DateUtil;
import com.ceiba.reserva.util.DescuentoCobroUtil;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {
    private static final int MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO = 4;
    private static final String SE_DEBE_INGRESAR_LA_FECHA_RESERVA = "Se debe ingresar la fecha de reserva";
    private static final String SE_DEBE_INGRESAR_CEDULA_CLIENTE = "Se debe ingresar la cedula del cliente";
    private static final String SE_DEBE_INGRESAR_NOMBRE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_TELEFONO_CLIENTE = "Se debe ingresar el telefono del cliente";
    private static final String SE_DEBE_INGRESAR_EMAIL_CLIENTE = "Se debe ingresar el email del cliente";
    private static final String SE_DEBE_INGRESAR_NUMERO_PERSONAS = "Se debe ingresar el numero de personas";
    private static final String SE_DEBE_INGRESAR_PAQUETE_TURISTICO= "Se debe ingresar el paquete turistico";
    private static final String SE_DEBE_INGRESAR_IDENTIFICADOR = "Se debe ingresar el identificador de reserva";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio";

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

    public Reserva(Long id, LocalDate fechaReserva, String cedulaCliente, String nombreCliente, String telefonoCliente, String emailCliente, int numeroPersonas, Long idPaqueteTuristico, String observaciones, String identificadorReserva, BigDecimal precio) {
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_RESERVA);
        validarObligatorio(cedulaCliente, SE_DEBE_INGRESAR_CEDULA_CLIENTE);
        validarObligatorio(nombreCliente, SE_DEBE_INGRESAR_NOMBRE_CLIENTE);
        validarObligatorio(telefonoCliente, SE_DEBE_INGRESAR_TELEFONO_CLIENTE);
        validarObligatorio(emailCliente, SE_DEBE_INGRESAR_EMAIL_CLIENTE);
        validarObligatorio(numeroPersonas, SE_DEBE_INGRESAR_NUMERO_PERSONAS);
        validarObligatorio(idPaqueteTuristico, SE_DEBE_INGRESAR_PAQUETE_TURISTICO);
        validarObligatorio(identificadorReserva, SE_DEBE_INGRESAR_IDENTIFICADOR);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);

        this.id = id;
        this.fechaReserva = fechaReserva;
        this.cedulaCliente = cedulaCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.numeroPersonas = numeroPersonas;
        this.idPaqueteTuristico = idPaqueteTuristico;
        this.observaciones= observaciones;
        this.identificadorReserva = identificadorReserva;
        this.precio = precio;

        aplicarDescuentoPorCantidadPersonas();
        aplicarDescuentoPorDiaReserva();
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setIdentificadorReserva(String identificadorReserva) {
        this.identificadorReserva = identificadorReserva;
    }

    private void aplicarDescuentoPorCantidadPersonas() {
        if(this.numeroPersonas > MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO) {
            this.precio = DescuentoCobroUtil.aplicarDescuento(this.precio, DescuentoCobroUtil.CINCO_PORCIENTO);
        }
    }

    private void aplicarDescuentoPorDiaReserva() {
        if(DateUtil.compararDia(this.fechaReserva, DateUtil.LUNES)) {
            this.precio = DescuentoCobroUtil.aplicarDescuento(this.precio, DescuentoCobroUtil.DIES_PORCIENTO);
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fechaReserva=" + fechaReserva +
                ", cedulaCliente='" + cedulaCliente + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", emailCliente='" + emailCliente + '\'' +
                ", numeroPersonas=" + numeroPersonas +
                ", idPaqueteTuristico=" + idPaqueteTuristico +
                ", observaciones='" + observaciones + '\'' +
                ", identificadorReserva='" + identificadorReserva + '\'' +
                ", precio=" + precio +
                '}';
    }
}
