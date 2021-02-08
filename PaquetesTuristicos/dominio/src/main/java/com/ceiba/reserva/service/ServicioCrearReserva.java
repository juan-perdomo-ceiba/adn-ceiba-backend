package com.ceiba.reserva.service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoDisponible;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.util.DateUtil;
import com.ceiba.reserva.util.DescuentoCobroUtil;

import java.util.UUID;

public class ServicioCrearReserva {

    public static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    public static final String NO_HAY_RERVAS_DISPONIBLES = "No hay reservas disponibles";
    private static final int MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO = 5;

    private final RepositorioReserva repositorioReserva;
    private final RepositorioFestivo repositorioFestivo;
    private final DaoPaqueteTurisico daoPaqueteTurisico;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioFestivo repositorioFestivo, DaoPaqueteTurisico daoPaqueteTurisico) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioFestivo = repositorioFestivo;
        this.daoPaqueteTurisico = daoPaqueteTurisico;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        validarDisponibilidadReserva(reserva);
        aplicarDescuentoPorCantidadPersonas(reserva);
        aplicarDescuentoPorDiaReserva(reserva);
        aplicarCobroPorDiaFestivo(reserva);
        asignarIdentificadorReserva(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getIdentificadorReserva());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarDisponibilidadReserva(Reserva reserva) {
        int cantidadReservasExistentes = repositorioReserva.cantidadReservasPorPaqueteTuristico(reserva.getIdPaqueteTuristico());
        int cantidadPersonasEnReservasExistentes = repositorioReserva.cantidadPersonasEnReservasPorPaqueteTuristico(reserva.getIdPaqueteTuristico());

        DtoPaqueteTuristico paqueteTuristico = daoPaqueteTurisico.detallar(reserva.getIdPaqueteTuristico());

        if(cantidadReservasExistentes >= paqueteTuristico.getCantidadMaximaReservas() || cantidadPersonasEnReservasExistentes + reserva.getNumeroPersonas() > paqueteTuristico.getCantidadMaximaPersonas()) {
            throw new ExcepcionReservaNoDisponible(NO_HAY_RERVAS_DISPONIBLES);
        }
    }

    private void aplicarDescuentoPorCantidadPersonas(Reserva reserva) {
        if(reserva.getNumeroPersonas() > MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO) {
            reserva.setPrecio(DescuentoCobroUtil.aplicarDescuento(reserva.getPrecio(), DescuentoCobroUtil.CINCO_PORCIENTO));
        }
    }

    private void aplicarDescuentoPorDiaReserva(Reserva reserva) {
        if(DateUtil.compararDia(reserva.getFechaReserva(), DateUtil.LUNES)) {
            reserva.setPrecio(DescuentoCobroUtil.aplicarDescuento(reserva.getPrecio(), DescuentoCobroUtil.DIES_PORCIENTO));
        }
    }

    private void aplicarCobroPorDiaFestivo(Reserva reserva) {
        boolean esFestivo = repositorioFestivo.validarEsFestivo(reserva.getFechaReserva());
        if(esFestivo) {
            reserva.setPrecio(DescuentoCobroUtil.aplicarCobro(reserva.getPrecio(), DescuentoCobroUtil.VEINTE_PORCIENTO));
        }
    }

    private void asignarIdentificadorReserva(Reserva reserva) {
        reserva.setIdentificadorReserva(UUID.randomUUID().toString());
    }
}
