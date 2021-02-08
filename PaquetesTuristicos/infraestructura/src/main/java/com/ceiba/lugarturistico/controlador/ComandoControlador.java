package com.ceiba.lugarturistico.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/lugares-turisticos")
@Api(tags = { "Controlador comando lugar turistico"})
public interface ComandoControlador {

    @PostMapping
    @ApiOperation(
            value = "Crear lugar turistico",
            notes = "Realiza la creacion de un lugar turistico en el sistema")
    ComandoRespuesta<Long> crear(@RequestBody ComandoLugarTuristico comandoLugarTuristico);

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Eliminar lugar turistico",
            notes = "Elimina un lugar turistico existente en el sistema")
    void eliminar(@PathVariable Long id);

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar lugar turistico",
            notes = "Realiza la actualizacion de un lugar turistico en el sistema")
    void actualizar(@RequestBody ComandoLugarTuristico comandoLugarTuristico,@PathVariable Long id);
}
