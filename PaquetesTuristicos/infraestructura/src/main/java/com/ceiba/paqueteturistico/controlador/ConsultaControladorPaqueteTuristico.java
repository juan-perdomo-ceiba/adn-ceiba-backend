package com.ceiba.paqueteturistico.controlador;

import com.ceiba.paqueteturistico.consulta.ManejadorListarPaquetesTuristicos;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paquetes-turisticos")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorPaqueteTuristico {

    private final ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos;

    public ConsultaControladorPaqueteTuristico(ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos) {
        this.manejadorListarPaquetesTuristicos = manejadorListarPaquetesTuristicos;
    }

    @GetMapping
    @ApiOperation("Listar paquetes turisticos")
    public List<DtoPaqueteTuristico> listar() {
        return this.manejadorListarPaquetesTuristicos.ejecutar();
    }

}
