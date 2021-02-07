package com.ceiba.reserva.util;

import java.math.BigDecimal;

public class DescuentoCobroUtil {

    public static BigDecimal CINCO_PORCIENTO = new BigDecimal("0.05");
    public static BigDecimal DIES_PORCIENTO = new BigDecimal("0.1");
    public static BigDecimal VEINTE_PORCIENTO = new BigDecimal("0.2");

    private DescuentoCobroUtil() {}

    public static BigDecimal aplicarDescuento(BigDecimal valor, BigDecimal descuento) {
        return valor.subtract(valor.divide(descuento, BigDecimal.ROUND_HALF_UP));
    }

    public static BigDecimal aplicarCobro(BigDecimal valor, BigDecimal cobro) {
        return valor.add(valor.divide(cobro, BigDecimal.ROUND_HALF_UP));
    }
}