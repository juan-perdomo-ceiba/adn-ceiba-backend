package com.ceiba.reserva.service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoDisponible;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.util.DescuentoCobroUtil;

import java.util.UUID;

public class ServicioCrearReserva {

    public static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    public static final String NO_HAY_RERVAS_DISPONIBLES = "No hay reservas disponibles";

    private final RepositorioReserva repositorioReserva;
    private final RepositorioFestivo repositorioFestivo;
    private final RepositorioPaqueteTuristico repositorioPaqueteTuristico;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioFestivo repositorioFestivo, RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        this.repositorioReserva = repositorioReserva;
        this.repositorioFestivo = repositorioFestivo;
        this.repositorioPaqueteTuristico = repositorioPaqueteTuristico;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        validarDisponibilidadReserva(reserva);
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

        PaqueteTuristico paqueteTuristico = repositorioPaqueteTuristico.obtener(reserva.getIdPaqueteTuristico());

        if(cantidadReservasExistentes >= paqueteTuristico.getCantidadMaximaReservas() || cantidadPersonasEnReservasExistentes + reserva.getNumeroPersonas() > paqueteTuristico.getCantidadMaximaPersonas()) {
            throw new ExcepcionReservaNoDisponible(NO_HAY_RERVAS_DISPONIBLES);
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
