package com.ceiba.lugarturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorActualizarLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorCrearLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorEliminarLugarTuristico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ComandoControladorLugarTuristico implements ComandoControlador {

    private final ManejadorCrearLugarTuristico manejadorCrearLugarTuristico;
	private final ManejadorEliminarLugarTuristico manejadorEliminarLugarTuristico;
	private final ManejadorActualizarLugarTuristico manejadorActualizarLugarTuristico;

    @Autowired
    public ComandoControladorLugarTuristico(ManejadorCrearLugarTuristico manejadorCrearLugarTuristico,
                                            ManejadorEliminarLugarTuristico manejadorEliminarLugarTuristico,
                                            ManejadorActualizarLugarTuristico manejadorActualizarLugarTuristico) {
        this.manejadorCrearLugarTuristico = manejadorCrearLugarTuristico;
		this.manejadorEliminarLugarTuristico = manejadorEliminarLugarTuristico;
		this.manejadorActualizarLugarTuristico = manejadorActualizarLugarTuristico;
    }

	@Override
    public ComandoRespuesta<Long> crear(ComandoLugarTuristico comandoLugarTuristico) {
        return manejadorCrearLugarTuristico.ejecutar(comandoLugarTuristico);
    }

	@Override
	public void eliminar(Long id) {
		manejadorEliminarLugarTuristico.ejecutar(id);
	}

	@Override
	public void actualizar(ComandoLugarTuristico comandoLugarTuristico, Long id) {
		comandoLugarTuristico.setId(id);
		manejadorActualizarLugarTuristico.ejecutar(comandoLugarTuristico);
	}
}
