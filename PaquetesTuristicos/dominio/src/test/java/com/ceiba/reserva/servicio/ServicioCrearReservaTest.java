package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoDisponible;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.testdatabuilder.PaqueteTuristicoTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.service.ServicioCrearReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {

    @Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioFestivo repositorioFestivo = Mockito.mock(RepositorioFestivo.class);
        RepositorioPaqueteTuristico repositorioPaqueteTuristico = Mockito.mock(RepositorioPaqueteTuristico.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioFestivo, repositorioPaqueteTuristico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, ServicioCrearReserva.LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarReservaNoDisponibleCantidadDeReservasTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        PaqueteTuristico paqueteTuristico = new PaqueteTuristicoTestDataBuilder().conId(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioFestivo repositorioFestivo = Mockito.mock(RepositorioFestivo.class);
        RepositorioPaqueteTuristico repositorioPaqueteTuristico = Mockito.mock(RepositorioPaqueteTuristico.class);

        Mockito.when(repositorioReserva.cantidadReservasPorPaqueteTuristico(Mockito.anyLong())).thenReturn(20);
        Mockito.when(repositorioPaqueteTuristico.obtener(Mockito.anyLong())).thenReturn(paqueteTuristico);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioFestivo, repositorioPaqueteTuristico);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionReservaNoDisponible.class, ServicioCrearReserva.NO_HAY_RERVAS_DISPONIBLES);
    }

    @Test
    public void validarReservaNoDisponibleCantidadDePersonasTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        PaqueteTuristico paqueteTuristico = new PaqueteTuristicoTestDataBuilder().conId(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        RepositorioFestivo repositorioFestivo = Mockito.mock(RepositorioFestivo.class);
        RepositorioPaqueteTuristico repositorioPaqueteTuristico = Mockito.mock(RepositorioPaqueteTuristico.class);

        Mockito.when(repositorioReserva.cantidadReservasPorPaqueteTuristico(Mockito.anyLong())).thenReturn(10);
        Mockito.when(repositorioReserva.cantidadPersonasEnReservasPorPaqueteTuristico(Mockito.anyLong())).thenReturn(46);
        Mockito.when(repositorioPaqueteTuristico.obtener(Mockito.anyLong())).thenReturn(paqueteTuristico);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioFestivo, repositorioPaqueteTuristico);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionReservaNoDisponible.class, ServicioCrearReserva.NO_HAY_RERVAS_DISPONIBLES);
    }



}
