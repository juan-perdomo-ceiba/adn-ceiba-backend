package com.ceiba.municipio.controlador;

import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/municipios")
@Api(tags = { "Controlador consulta municipio"})
public interface ConsultaControlador {

    @GetMapping
    @ApiOperation(
            value = "Listar Lugares Turisticos",
            notes = "Lista todos los municipios existentes en el sistema")
    List<DtoMunicipio> listar();
}
