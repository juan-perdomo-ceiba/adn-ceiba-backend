package com.ceiba.reserva.controlador;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/reservas")
@Api(tags={"Controlador consulta reservas"})
public interface ConsultaControlador {

    @GetMapping
    @ApiOperation(
            value = "Listar reservas",
            notes = "Lista todas la reservas creadas en el sistema")
    List<DtoReserva> listar();

    @GetMapping("detalle/{identificadorReserva}")
    @ApiOperation(
            value = "Detallar reserva por identificador",
            notes = "Detalla una reserva por identificador unico de reserva creada en el sistema")
    DtoReserva detallarPorIdentificadorReserva(@PathVariable String identificadorReserva);


    @GetMapping("/{id}")
    @ApiOperation(
            value = "Detallar reserva",
            notes = "Detalla una reserva por id")
    DtoReserva detallarReserva(@PathVariable Long id);
}
