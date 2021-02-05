package com.ceiba.lugarturistico.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;

public class ServicioActualizarLugarTuristico {

    private static final String EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA = "El lugar turistico ya existe en el sistema";

    private final RepositorioLugarTuristico repositorioLugarTuristico;

    public ServicioActualizarLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        this.repositorioLugarTuristico = repositorioLugarTuristico;
    }

    public void ejecutar(LugarTuristico lugarTuristico) {
        validarExistenciaPrevia(lugarTuristico);
        this.repositorioLugarTuristico.actualizar(lugarTuristico);
    }

    private void validarExistenciaPrevia(LugarTuristico LugarTuristico) {
        boolean existe = this.repositorioLugarTuristico.existeExcluyendoId(LugarTuristico.getId(),LugarTuristico.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
