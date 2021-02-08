package com.ceiba.paqueteturistico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.testdatabuilder.PaqueteTuristicoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPaqueteTuristicoTest {

    @Test
    public void validarPaqueteTuristicoExistenciaPreviaTest() {
        // arrange
        PaqueteTuristico paqueteTuristico = new PaqueteTuristicoTestDataBuilder().build();
        RepositorioPaqueteTuristico repositorioPaqueteTuristico = Mockito.mock(RepositorioPaqueteTuristico.class);
        Mockito.when(repositorioPaqueteTuristico.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaqueteTuristico servicioCrearPaqueteTuristico = new ServicioCrearPaqueteTuristico(repositorioPaqueteTuristico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPaqueteTuristico.ejecutar(paqueteTuristico), ExcepcionDuplicidad.class, ServicioCrearPaqueteTuristico.EL_PAQUETE_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
