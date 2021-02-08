package com.ceiba.municipio.controlador;

import com.ceiba.municipio.consulta.ManejadorListarMunicipios;
import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorMunicipio implements ConsultaControlador {

    private final ManejadorListarMunicipios manejadorListarMunicipios;

    public ConsultaControladorMunicipio(ManejadorListarMunicipios manejadorListarMunicipios) {
        this.manejadorListarMunicipios = manejadorListarMunicipios;
    }

    @Override
    public List<DtoMunicipio> listar() {
        return this.manejadorListarMunicipios.ejecutar();
    }
}
