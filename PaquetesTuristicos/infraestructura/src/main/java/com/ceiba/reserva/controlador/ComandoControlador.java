package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reservas")
@Api(tags = { "Controlador comando reserva"})
public interface ComandoControlador {

    @PostMapping
    @ApiOperation(
            value = "Crear Rserva",
            notes = "Realiza la creacion de una reserva en el sistema"
    )
    ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva);

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Eliminar Reserva",
            notes = "Eliminan una reserva en el sistema")
    void eliminar(@PathVariable Long id);

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar Reserva",
            notes = "Realiza la actualizacion de una reserva en el sistema")
    void actualizar(@RequestBody ComandoReserva comandoReserva,@PathVariable Long id);
}
