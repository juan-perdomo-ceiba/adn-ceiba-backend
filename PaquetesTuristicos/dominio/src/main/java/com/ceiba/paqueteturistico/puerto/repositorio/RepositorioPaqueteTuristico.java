package com.ceiba.paqueteturistico.puerto.repositorio;

import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;

public interface RepositorioPaqueteTuristico {

    Long crear(PaqueteTuristico usuario);

    void actualizar(PaqueteTuristico usuario);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id,String nombre);
}
