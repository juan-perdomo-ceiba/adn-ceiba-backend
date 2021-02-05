package com.ceiba.paqueteturistico.servicio;

import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;

public class ServicioEliminarPaqueteTuristico {

    private final RepositorioPaqueteTuristico repositorioPaqueteTuristico;

    public ServicioEliminarPaqueteTuristico(RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        this.repositorioPaqueteTuristico = repositorioPaqueteTuristico;
    }

    public void ejecutar(Long id) {
        this.repositorioPaqueteTuristico.eliminar(id);
    }
}
