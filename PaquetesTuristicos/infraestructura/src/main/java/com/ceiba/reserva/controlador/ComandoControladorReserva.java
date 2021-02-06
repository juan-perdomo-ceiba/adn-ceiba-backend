package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarRserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
	private final ManejadorEliminarReserva manejadorEliminarReserva;
	private final ManejadorActualizarRserva manejadorActualizarRserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva,
									 ManejadorEliminarReserva manejadorEliminarReserva,
									 ManejadorActualizarRserva manejadorActualizarRserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
		this.manejadorEliminarReserva = manejadorEliminarReserva;
		this.manejadorActualizarRserva = manejadorActualizarRserva;
    }

    @PostMapping
    @ApiOperation("Crear Rserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Reserva")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarReserva.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Reserva")
	public void actualizar(@RequestBody ComandoReserva comandoReserva,@PathVariable Long id) {
		comandoReserva.setId(id);
		manejadorActualizarRserva.ejecutar(comandoReserva);
	}
}
