package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorReserva implements ConsultaControlador{

    private final ManejadorListarReservas manejadorListarReservas;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas) {
        this.manejadorListarReservas = manejadorListarReservas;
    }

    @Override
    public List<DtoReserva> listar() {
        return this.manejadorListarReservas.ejecutar();
    }
}
