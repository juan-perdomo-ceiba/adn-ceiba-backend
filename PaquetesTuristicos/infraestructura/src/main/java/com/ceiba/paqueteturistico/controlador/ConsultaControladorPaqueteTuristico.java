package com.ceiba.paqueteturistico.controlador;

import com.ceiba.paqueteturistico.consulta.ManejadorDetallarPaqueteTuristico;
import com.ceiba.paqueteturistico.consulta.ManejadorListarPaquetesTuristicos;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorPaqueteTuristico implements ConsultaControlador{

    private final ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos;
    private final ManejadorDetallarPaqueteTuristico manejadorDetallarPaqueteTuristico;

    public ConsultaControladorPaqueteTuristico(ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos, ManejadorDetallarPaqueteTuristico manejadorDetallarPaqueteTuristico) {
        this.manejadorListarPaquetesTuristicos = manejadorListarPaquetesTuristicos;
        this.manejadorDetallarPaqueteTuristico = manejadorDetallarPaqueteTuristico;
    }

    @Override
    public List<DtoPaqueteTuristico> listar() {
        return this.manejadorListarPaquetesTuristicos.ejecutar();
    }

    @Override
    public DtoPaqueteTuristico detallar(Long id) {
        return manejadorDetallarPaqueteTuristico.ejecutar(id);
    }
}
