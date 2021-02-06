package com.ceiba.reserva.service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.util.DateUtil;
import com.ceiba.reserva.util.DescuentoUtil;

public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    private static final int MINIMA_CANTIDAD_PERSONAS_APLICA_DESCUENTO = 5;

    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        aplicarDescuentoPorCantidadPersonas(reserva);
        aplicarDescuentoPorDiaReserva(reserva);
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
            reserva.setPrecio(DescuentoUtil.aplicarDescuento(reserva.getPrecio(), DescuentoUtil.DESCUENTO_CINCO_PORCIENTO));
        }
    }

    private void aplicarDescuentoPorDiaReserva(Reserva reserva) {
        if(DateUtil.compararDia(reserva.getFechaReserva(), DateUtil.LUNES)) {
            reserva.setPrecio(DescuentoUtil.aplicarDescuento(reserva.getPrecio(), DescuentoUtil.DESCUENTO_DIES_PORCIENTO));
        }
    }
}
