package com.ceiba.reserva.puerto.dao;

import java.time.LocalDate;

public interface DaoFestivo {

    boolean validarEsFestivo(LocalDate fecha);
}
