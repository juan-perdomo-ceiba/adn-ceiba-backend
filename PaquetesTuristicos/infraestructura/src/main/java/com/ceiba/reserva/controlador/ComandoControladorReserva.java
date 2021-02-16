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
	@ApiOperation(
			value = "Crear Rserva",
			notes = "Realiza la creacion de una reserva en el sistema"
	)
    public ComandoRespuesta<Long> crear(ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "Eliminar Reserva",
			notes = "Eliminan una reserva en el sistema")
	public void eliminar(Long id) {
		manejadorEliminarReserva.ejecutar(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(
			value = "Actualizar Reserva",
			notes = "Realiza la actualizacion de una reserva en el sistema")
	public void actualizar(ComandoReserva comandoReserva, Long id) {
		comandoReserva.setId(id);
		manejadorActualizarRserva.ejecutar(comandoReserva);
	}
}
