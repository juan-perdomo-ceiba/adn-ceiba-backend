package com.ceiba.reserva.service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.dao.DaoFestivo;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.util.DateUtil;
import com.ceiba.reserva.util.DescuentoCobroUtil;

import java.util.UUID;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    private static final int MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO = 5;

    private final RepositorioReserva repositorioReserva;
    private final DaoFestivo daoFestivo;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, DaoFestivo daoFestivo) {
        this.repositorioReserva = repositorioReserva;
        this.daoFestivo = daoFestivo;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
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
        boolean esFestivo = daoFestivo.validarEsFestivo(reserva.getFechaReserva());
        if(esFestivo) {
            reserva.setPrecio(DescuentoCobroUtil.aplicarCobro(reserva.getPrecio(), DescuentoCobroUtil.VEINTE_PORCIENTO));
        }
    }

    private void asignarIdentificadorReserva(Reserva reserva) {
        reserva.setIdentificadorReserva(UUID.randomUUID().toString());
    }
}
