package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorDetallarPorIdentificadorReserva;
import com.ceiba.reserva.consulta.ManejadorDetallarReserva;
import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reservas"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservas manejadorListarReservas;
    private final ManejadorDetallarPorIdentificadorReserva manejadorDetallarPorIdentificadorReserva;
    private final ManejadorDetallarReserva manejadorDetallarReserva;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas, ManejadorDetallarPorIdentificadorReserva manejadorDetallarPorIdentificadorReserva, ManejadorDetallarReserva manejadorDetallarReserva) {
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorDetallarPorIdentificadorReserva = manejadorDetallarPorIdentificadorReserva;
        this.manejadorDetallarReserva = manejadorDetallarReserva;
    }

    @GetMapping
    @ApiOperation(
            value = "Listar reservas",
            notes = "Lista todas la reservas creadas en el sistema")
    public List<DtoReserva> listar() {
        return this.manejadorListarReservas.ejecutar();
    }

    @GetMapping("/detalle/{identificadorReserva}")
    @ApiOperation(
            value = "Detallar reserva por identificador",
            notes = "Detalla una reserva por identificador unico de reserva creada en el sistema")
    public DtoReserva detallarPorIdentificadorReserva(@PathVariable String identificadorReserva) {
        return this.manejadorDetallarPorIdentificadorReserva.ejecutar(identificadorReserva);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Detallar reserva",
            notes = "Detalla una reserva por id")
    public DtoReserva detallarReserva(@PathVariable Long id) {
        return this.manejadorDetallarReserva.ejecutar(id);
    }
}
