package com.ceiba.reserva.util;

import java.math.BigDecimal;

public class DescuentoUtil {

    public static BigDecimal DESCUENTO_CINCO_PORCIENTO = new BigDecimal("0.05");
    public static BigDecimal DESCUENTO_DIES_PORCIENTO = new BigDecimal("0.1");

    private DescuentoUtil() {}

    public static BigDecimal aplicarDescuento(BigDecimal valor, BigDecimal descuento) {
        return valor.subtract(valor.divide(descuento, BigDecimal.ROUND_HALF_UP));
    }
}
