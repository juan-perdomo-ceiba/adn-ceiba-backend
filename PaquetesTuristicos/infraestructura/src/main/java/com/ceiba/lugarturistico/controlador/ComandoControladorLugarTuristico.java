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
    @ApiOperation("Crear lugar turistico")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoLugarTuristico comandoLugarTuristico) {
        return manejadorCrearLugarTuristico.ejecutar(comandoLugarTuristico);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar lugar turistico")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarLugarTuristico.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar lugar turistico")
	public void actualizar(@RequestBody ComandoLugarTuristico comandoLugarTuristico,@PathVariable Long id) {
		comandoLugarTuristico.setId(id);
		manejadorActualizarLugarTuristico.ejecutar(comandoLugarTuristico);
	}
}
