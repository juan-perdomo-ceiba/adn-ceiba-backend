package com.ceiba.paqueteturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorActualizarPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorCrearPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorEliminarPaqueteTuristico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComandoControladorPaqueteTuristico implements ComandoControlador{

    private final ManejadorCrearPaqueteTuristico manejadorCrearPaqueteTuristico;
	private final ManejadorEliminarPaqueteTuristico manejadorEliminarPaqueteTuristico;
	private final ManejadorActualizarPaqueteTuristico manejadorActualizarPaqueteTuristico;

    @Autowired
    public ComandoControladorPaqueteTuristico(ManejadorCrearPaqueteTuristico manejadorCrearPaqueteTuristico,
                                              ManejadorEliminarPaqueteTuristico manejadorEliminarPaqueteTuristico,
                                              ManejadorActualizarPaqueteTuristico manejadorActualizarPaqueteTuristico) {
        this.manejadorCrearPaqueteTuristico = manejadorCrearPaqueteTuristico;
		this.manejadorEliminarPaqueteTuristico = manejadorEliminarPaqueteTuristico;
		this.manejadorActualizarPaqueteTuristico = manejadorActualizarPaqueteTuristico;
    }

	@Override
    public ComandoRespuesta<Long> crear(ComandoPaqueteTuristico comandoPaqueteTuristico) {
        return manejadorCrearPaqueteTuristico.ejecutar(comandoPaqueteTuristico);
    }

	@Override
	public void eliminar(Long id) {
		manejadorEliminarPaqueteTuristico.ejecutar(id);
	}

	@Override
	public void actualizar(ComandoPaqueteTuristico comandoPaqueteTuristico, Long id) {
		comandoPaqueteTuristico.setId(id);
		manejadorActualizarPaqueteTuristico.ejecutar(comandoPaqueteTuristico);
	}
}
