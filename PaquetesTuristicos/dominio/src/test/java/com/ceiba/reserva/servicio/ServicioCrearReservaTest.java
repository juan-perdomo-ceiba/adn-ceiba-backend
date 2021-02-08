package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
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
        DaoPaqueteTurisico daoPaqueteTurisico = Mockito.mock(DaoPaqueteTurisico.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, repositorioFestivo, daoPaqueteTurisico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class, ServicioCrearReserva.LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
    }
}
