package com.ceiba.paqueteturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorActualizarPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorCrearPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.manejador.ManejadorEliminarPaqueteTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paquetes-turisticos")
@Api(tags = { "Controlador comando paquete turistico"})
public class ComandoControladorPaqueteTuristico {

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

    @PostMapping
    @ApiOperation("Crear Paquete Turistico")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaqueteTuristico comandoPaqueteTuristico) {
        return manejadorCrearPaqueteTuristico.ejecutar(comandoPaqueteTuristico);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Paquete turistico")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarPaqueteTuristico.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Paquete Turistico")
	public void actualizar(@RequestBody ComandoPaqueteTuristico comandoPaqueteTuristico,@PathVariable Long id) {
		comandoPaqueteTuristico.setId(id);
		manejadorActualizarPaqueteTuristico.ejecutar(comandoPaqueteTuristico);
	}
}
