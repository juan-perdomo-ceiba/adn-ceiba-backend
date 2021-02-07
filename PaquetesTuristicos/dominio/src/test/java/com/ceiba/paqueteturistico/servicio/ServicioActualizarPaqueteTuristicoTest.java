package com.ceiba.paqueteturistico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.testdatabuilder.PaqueteTuristicoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarPaqueteTuristicoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        PaqueteTuristico paqueteTuristico = new PaqueteTuristicoTestDataBuilder().conId(1L).build();
        RepositorioPaqueteTuristico repositorioPaqueteTuristico = Mockito.mock(RepositorioPaqueteTuristico.class);
        Mockito.when(repositorioPaqueteTuristico.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarPaqueteTuristico servicioActualizarPaqueteTuristico = new ServicioActualizarPaqueteTuristico(repositorioPaqueteTuristico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPaqueteTuristico.ejecutar(paqueteTuristico), ExcepcionDuplicidad.class, ServicioCrearPaqueteTuristico.EL_PAQUETE_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
