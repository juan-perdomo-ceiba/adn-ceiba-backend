package com.ceiba.reserva.controlador;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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
}
