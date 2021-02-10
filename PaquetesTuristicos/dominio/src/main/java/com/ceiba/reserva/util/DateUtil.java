package com.ceiba.reserva.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public final class DateUtil {

    public static final int LUNES = DayOfWeek.MONDAY.getValue();

    private DateUtil() {}

    public static boolean compararDia(LocalDate fecha, int day) {
        return fecha.getDayOfWeek().getValue() == day;
    }
}
