package com.ceiba.lugarturistico.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;
import com.ceiba.lugarturistico.servicio.testdatabuilder.LugarTuristicoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearLugarTuristicoTest {

    @Test
    public void validarLugarTuristicoExistenciaPreviaTest() {
        // arrange
        LugarTuristico lugarTuristico = new LugarTuristicoTestDataBuilder().build();
        RepositorioLugarTuristico repositorioLugarTuristico = Mockito.mock(RepositorioLugarTuristico.class);
        Mockito.when(repositorioLugarTuristico.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearLugarTuristico servicioCrearLugarTuristico = new ServicioCrearLugarTuristico(repositorioLugarTuristico);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearLugarTuristico.ejecutar(lugarTuristico), ExcepcionDuplicidad.class, ServicioCrearLugarTuristico.EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
