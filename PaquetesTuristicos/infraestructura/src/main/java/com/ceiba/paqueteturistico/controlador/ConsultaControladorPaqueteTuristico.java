package com.ceiba.paqueteturistico.controlador;

import com.ceiba.paqueteturistico.consulta.ManejadorListarPaquetesTuristicos;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorPaqueteTuristico implements ConsultaControlador{

    private final ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos;

    public ConsultaControladorPaqueteTuristico(ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos) {
        this.manejadorListarPaquetesTuristicos = manejadorListarPaquetesTuristicos;
    }

    @Override
    public List<DtoPaqueteTuristico> listar() {
        return this.manejadorListarPaquetesTuristicos.ejecutar();
    }
}
