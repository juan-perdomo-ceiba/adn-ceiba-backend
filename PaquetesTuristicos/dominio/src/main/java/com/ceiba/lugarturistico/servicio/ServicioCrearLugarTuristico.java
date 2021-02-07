package com.ceiba.lugarturistico.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;


public class ServicioCrearLugarTuristico {

    private static final String EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA = "El lugar turistico ya existe en el sistema";

    private final RepositorioLugarTuristico repositorioLugarTuristico;

    public ServicioCrearLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        this.repositorioLugarTuristico = repositorioLugarTuristico;
    }

    public Long ejecutar(LugarTuristico lugarTuristico) {
        validarExistenciaPrevia(lugarTuristico);
        return this.repositorioLugarTuristico.crear(lugarTuristico);
    }

    private void validarExistenciaPrevia(LugarTuristico lugarTuristico) {
        boolean existe = this.repositorioLugarTuristico.existeExcluyendoId(lugarTuristico.getId(),lugarTuristico.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_LUGAR_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
