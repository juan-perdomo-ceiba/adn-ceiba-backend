package com.ceiba.lugarturistico.servicio;

import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;

public class ServicioEliminarLugarTuristico {

    private final RepositorioLugarTuristico repositorioLugarTuristico;

    public ServicioEliminarLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        this.repositorioLugarTuristico = repositorioLugarTuristico;
    }

    public void ejecutar(Long id) {
        this.repositorioLugarTuristico.eliminar(id);
    }
}
