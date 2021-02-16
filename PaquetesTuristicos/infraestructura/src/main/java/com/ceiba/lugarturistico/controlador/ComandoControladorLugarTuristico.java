package com.ceiba.lugarturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorActualizarLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorCrearLugarTuristico;
import com.ceiba.lugarturistico.comando.manejador.ManejadorEliminarLugarTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lugares-turisticos")
@Api(tags = { "Controlador comando lugar turistico"})
public class ComandoControladorLugarTuristico {

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

	@PostMapping
	@ApiOperation(
			value = "Crear lugar turistico",
			notes = "Realiza la creacion de un lugar turistico en el sistema")
    public ComandoRespuesta<Long> crear(ComandoLugarTuristico comandoLugarTuristico) {
        return manejadorCrearLugarTuristico.ejecutar(comandoLugarTuristico);
    }

	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "Eliminar lugar turistico",
			notes = "Elimina un lugar turistico existente en el sistema")
	public void eliminar(Long id) {
		manejadorEliminarLugarTuristico.ejecutar(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(
			value = "Actualizar lugar turistico",
			notes = "Realiza la actualizacion de un lugar turistico en el sistema")
	public void actualizar(ComandoLugarTuristico comandoLugarTuristico, Long id) {
		comandoLugarTuristico.setId(id);
		manejadorActualizarLugarTuristico.ejecutar(comandoLugarTuristico);
	}
}
