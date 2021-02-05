package com.ceiba.municipio.controlador;

import com.ceiba.municipio.consulta.ManejadorListarMunicipios;
import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipios")
@Api(tags = { "Controlador consulta municipio"})
public class ConsultaControladorMunicipio {

    private final ManejadorListarMunicipios manejadorListarMunicipios;

    public ConsultaControladorMunicipio(ManejadorListarMunicipios manejadorListarMunicipios) {
        this.manejadorListarMunicipios = manejadorListarMunicipios;
    }

    @GetMapping
    @ApiOperation("Listar Lugares Turisticos")
    public List<DtoMunicipio> listar() {
        return this.manejadorListarMunicipios.ejecutar();
    }
}
