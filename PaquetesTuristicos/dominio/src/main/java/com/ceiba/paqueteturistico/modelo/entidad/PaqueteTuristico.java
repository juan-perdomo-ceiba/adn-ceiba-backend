package com.ceiba.paqueteturistico.modelo.entidad;


import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class PaqueteTuristico {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_RESERVA = "Se debe ingresar la fecha de reserva";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_MAXIMA_PERSONAS = "Se debe ingresar la cantidad maxima de personas";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_MAXIMA_RESERVAS = "Se debe ingresar la cantidad maxima de reservas";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_POR_PERSONA = "Se debe ingresar el precio por persona";
    private static final String SE_DEBE_INGRESAR_EL_LUGAR_TURUSTICO = "Se debe ingresar el lugarTuristico";

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaReserva;
    private int cantidadMaximaPersonas;
    private int cantidadMaximaReservas;
    private BigDecimal precioPorPersona;
    private Long idLugarTuristico;

    public PaqueteTuristico(Long id, String nombre, String descripcion, LocalDate fechaReserva, int cantidadMaximaPersonas, int cantidadMaximaReservas, BigDecimal precioPorPersona, Long idLugarTuristico) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_RESERVA);
        validarObligatorio(cantidadMaximaPersonas, SE_DEBE_INGRESAR_LA_CANTIDAD_MAXIMA_PERSONAS);
        validarObligatorio(cantidadMaximaReservas, SE_DEBE_INGRESAR_LA_CANTIDAD_MAXIMA_RESERVAS);
        validarObligatorio(precioPorPersona, SE_DEBE_INGRESAR_EL_PRECIO_POR_PERSONA);
        validarObligatorio(idLugarTuristico, SE_DEBE_INGRESAR_EL_LUGAR_TURUSTICO);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaReserva = fechaReserva;
        this.cantidadMaximaPersonas = cantidadMaximaPersonas;
        this.cantidadMaximaReservas = cantidadMaximaReservas;
        this.precioPorPersona = precioPorPersona;
        this.idLugarTuristico = idLugarTuristico;
    }
}
