package com.ceiba.paqueteturistico.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;

public class ServicioCrearPaqueteTuristico {

    public static final String EL_PAQUETE_TURISTICO_YA_EXISTE_EN_EL_SISTEMA = "El paquete turistico ya existe en el sistema";

    private final RepositorioPaqueteTuristico repositorioPaqueteTuristico;

    public ServicioCrearPaqueteTuristico(RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        this.repositorioPaqueteTuristico = repositorioPaqueteTuristico;
    }

    public Long ejecutar(PaqueteTuristico paqueteTuristico) {
        validarExistenciaPrevia(paqueteTuristico);
        return this.repositorioPaqueteTuristico.crear(paqueteTuristico);
    }

    private void validarExistenciaPrevia(PaqueteTuristico paqueteTuristico) {
        boolean existe = this.repositorioPaqueteTuristico.existe(paqueteTuristico.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PAQUETE_TURISTICO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
