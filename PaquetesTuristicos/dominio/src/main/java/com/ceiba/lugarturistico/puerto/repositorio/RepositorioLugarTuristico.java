package com.ceiba.lugarturistico.puerto.repositorio;

import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;

public interface RepositorioLugarTuristico  {

    Long crear(LugarTuristico lugarTuristico);

    void actualizar(LugarTuristico lugarTuristico);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id,String nombre);
}
