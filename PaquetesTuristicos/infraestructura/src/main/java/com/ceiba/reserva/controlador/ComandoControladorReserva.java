package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarRserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComandoControladorReserva implements ComandoControlador{

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

	@Override
    public ComandoRespuesta<Long> crear(ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

	@Override
	public void eliminar(Long id) {
		manejadorEliminarReserva.ejecutar(id);
	}

	@Override
	public void actualizar(ComandoReserva comandoReserva, Long id) {
		comandoReserva.setId(id);
		manejadorActualizarRserva.ejecutar(comandoReserva);
	}
}
