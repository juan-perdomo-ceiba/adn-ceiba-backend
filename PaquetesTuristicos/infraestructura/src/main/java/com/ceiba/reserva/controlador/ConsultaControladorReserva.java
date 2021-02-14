package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorDetallarPorIdentificadorReserva;
import com.ceiba.reserva.consulta.ManejadorDetallarReserva;
import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorReserva implements ConsultaControlador {

    private final ManejadorListarReservas manejadorListarReservas;
    private final ManejadorDetallarPorIdentificadorReserva manejadorDetallarPorIdentificadorReserva;
    private final ManejadorDetallarReserva manejadorDetallarReserva;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas, ManejadorDetallarPorIdentificadorReserva manejadorDetallarPorIdentificadorReserva, ManejadorDetallarReserva manejadorDetallarReserva) {
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorDetallarPorIdentificadorReserva = manejadorDetallarPorIdentificadorReserva;
        this.manejadorDetallarReserva = manejadorDetallarReserva;
    }

    @Override
    public List<DtoReserva> listar() {
        return this.manejadorListarReservas.ejecutar();
    }

    @Override
    public DtoReserva detallarPorIdentificadorReserva(String identificadorReserva) {
        return this.manejadorDetallarPorIdentificadorReserva.ejecutar(identificadorReserva);
    }

    @Override
    public DtoReserva detallarReserva(Long id) {
        return this.manejadorDetallarReserva.ejecutar(id);
    }
}
