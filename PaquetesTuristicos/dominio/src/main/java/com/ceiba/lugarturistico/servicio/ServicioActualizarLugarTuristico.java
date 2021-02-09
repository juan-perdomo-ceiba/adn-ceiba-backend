package com.ceiba.lugarturistico.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;

public class ServicioActualizarLugarTuristico {

    public static final String EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA = "El lugar turistico ya existe en el sistema";

    private final RepositorioLugarTuristico repositorioLugarTuristico;

    public ServicioActualizarLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        this.repositorioLugarTuristico = repositorioLugarTuristico;
    }

    public void ejecutar(LugarTuristico lugarTuristico) {
        validarExistenciaPrevia(lugarTuristico);
        this.repositorioLugarTuristico.actualizar(lugarTuristico);
    }

    private void validarExistenciaPrevia(LugarTuristico lugarTuristico) {
        boolean existe = this.repositorioLugarTuristico.existeExcluyendoId(lugarTuristico.getId(),lugarTuristico.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
