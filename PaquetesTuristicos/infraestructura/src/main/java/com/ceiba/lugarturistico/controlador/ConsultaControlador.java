package com.ceiba.lugarturistico.controlador;

import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/lugares-turisticos")
@Api(tags = { "Controlador consulta lugar turistico"})
public interface ConsultaControlador {

    @GetMapping
    @ApiOperation(
            value = "Listar Lugares Turisticos",
            notes = "Lista los lugares turisticos existentes en el sistema")
    List<DtoLugarTuristico> listar();
}
