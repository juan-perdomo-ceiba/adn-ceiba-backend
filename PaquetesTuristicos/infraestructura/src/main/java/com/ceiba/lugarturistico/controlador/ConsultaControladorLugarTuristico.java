package com.ceiba.lugarturistico.controlador;

import com.ceiba.lugarturistico.consulta.ManejadorListarLugaresTuristicos;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lugares-turisticos")
@Api(tags = { "Controlador comando lugar turistico"})
public class ConsultaControladorLugarTuristico {

    private final ManejadorListarLugaresTuristicos manejadorListarUsuarios;

    public ConsultaControladorLugarTuristico(ManejadorListarLugaresTuristicos manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Lugares Turisticos")
    public List<DtoLugarTuristico> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }
}
