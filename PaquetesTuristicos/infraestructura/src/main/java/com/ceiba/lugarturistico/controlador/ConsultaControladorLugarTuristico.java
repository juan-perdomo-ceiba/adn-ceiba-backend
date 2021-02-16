package com.ceiba.lugarturistico.controlador;

import com.ceiba.lugarturistico.consulta.ManejadorDetallarLugarTuristico;
import com.ceiba.lugarturistico.consulta.ManejadorListarLugaresTuristicos;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lugares-turisticos")
@Api(tags = { "Controlador consulta lugar turistico"})
public class ConsultaControladorLugarTuristico {

    private final ManejadorListarLugaresTuristicos manejadorListarLugaresTUristicos;
    private final ManejadorDetallarLugarTuristico manejadorDetallarLugarTuristico;

    public ConsultaControladorLugarTuristico(ManejadorListarLugaresTuristicos manejadorListarLugaresTUristicos, ManejadorDetallarLugarTuristico manejadorDetallarLugarTuristico) {
        this.manejadorListarLugaresTUristicos = manejadorListarLugaresTUristicos;
        this.manejadorDetallarLugarTuristico = manejadorDetallarLugarTuristico;
    }

    @GetMapping
    @ApiOperation(
            value = "Listar Lugares Turisticos",
            notes = "Lista los lugares turisticos existentes en el sistema")
    public List<DtoLugarTuristico> listar() {
        return this.manejadorListarLugaresTUristicos.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Detallar lugar turistico",
            notes = "Lista un lugar turistico existente en el sistema por id")
    public DtoLugarTuristico detallar(@PathVariable Long id) {
        return this.manejadorDetallarLugarTuristico.ejecutar(id);
    }
}
