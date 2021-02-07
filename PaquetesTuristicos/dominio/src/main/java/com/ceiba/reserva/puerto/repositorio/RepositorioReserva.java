package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

public interface RepositorioReserva {

    Long crear(Reserva usuario);

    void actualizar(Reserva usuario);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id,String nombre);

}
