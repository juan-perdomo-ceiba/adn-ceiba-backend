package com.ceiba.paqueteturistico.controlador;

import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/paquetes-turisticos")
@Api(tags={"Controlador consulta paquete turistico"})
public interface ConsultaControlador {

    @GetMapping
    @ApiOperation(
            value = "Listar paquetes turisticos",
            notes = "Lista todos los paquetes turisticos existentes en el sistema")
    List<DtoPaqueteTuristico> listar();
}
