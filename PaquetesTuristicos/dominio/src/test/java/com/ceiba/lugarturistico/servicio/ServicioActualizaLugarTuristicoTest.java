package com.ceiba.lugarturistico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;
import com.ceiba.lugarturistico.servicio.testdatabuilder.LugarTuristicoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizaLugarTuristicoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        LugarTuristico lugarTuristico = new LugarTuristicoTestDataBuilder().conId(1L).build();
        RepositorioLugarTuristico repositorioLugarTuristico = Mockito.mock(RepositorioLugarTuristico.class);
        Mockito.when(repositorioLugarTuristico.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarLugarTuristico servicioActualizarLugarTuristico = new ServicioActualizarLugarTuristico(repositorioLugarTuristico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLugarTuristico.ejecutar(lugarTuristico), ExcepcionDuplicidad.class, ServicioActualizarLugarTuristico.EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
