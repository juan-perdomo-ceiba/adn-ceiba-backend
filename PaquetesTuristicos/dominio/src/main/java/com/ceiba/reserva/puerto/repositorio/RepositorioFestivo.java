package com.ceiba.reserva.puerto.repositorio;

import java.time.LocalDate;

public interface RepositorioFestivo {

    boolean validarEsFestivo(LocalDate fecha);
}
