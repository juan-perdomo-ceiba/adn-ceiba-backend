package com.ceiba.paqueteturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/paquetes-turisticos")
@Api(tags = { "Controlador comando paquete turistico"})
public interface ComandoControlador {

    @PostMapping
    @ApiOperation(
            value = "Crear Paquete Turistico",
            notes = "Realiza la creacion de un paquete turistico en el sistema")
    ComandoRespuesta<Long> crear(@RequestBody ComandoPaqueteTuristico comandoPaqueteTuristico);

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Eliminar Paquete turistico",
            notes = "Elimina un paquete turistico en el sistema")
    void eliminar(@PathVariable Long id);


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar Paquete Turistico",
            notes = "Reliza la actualizacion de un paquete turistico en el sistema")
    void actualizar(@RequestBody ComandoPaqueteTuristico comandoPaqueteTuristico,@PathVariable Long id);
}
