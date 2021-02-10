package com.ceiba.reserva.util;

import java.math.BigDecimal;

public final class DescuentoCobroUtil {

    public static final BigDecimal CINCO_PORCIENTO = new BigDecimal("0.05");
    public static final BigDecimal DIES_PORCIENTO = new BigDecimal("0.1");
    public static final BigDecimal VEINTE_PORCIENTO = new BigDecimal("0.2");
    private static final BigDecimal PORCENTAJE = new BigDecimal(100);

    private DescuentoCobroUtil() {}

    public static BigDecimal aplicarDescuento(BigDecimal valor, BigDecimal descuento) {
        return valor.subtract((valor.multiply(descuento).divide(PORCENTAJE, BigDecimal.ROUND_HALF_UP)));
    }

    public static BigDecimal aplicarCobro(BigDecimal valor, BigDecimal cobro) {
        return valor.add((valor.multiply(cobro).divide(PORCENTAJE, BigDecimal.ROUND_HALF_UP)));
    }
}
