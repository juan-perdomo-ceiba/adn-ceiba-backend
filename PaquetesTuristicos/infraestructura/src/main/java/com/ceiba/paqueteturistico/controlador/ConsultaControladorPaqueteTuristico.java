package com.ceiba.paqueteturistico.controlador;

import com.ceiba.paqueteturistico.consulta.ManejadorDetallarPaqueteTuristico;
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
@Api(tags={"Controlador consulta paquete turistico"})
public class ConsultaControladorPaqueteTuristico {

    private final ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos;
    private final ManejadorDetallarPaqueteTuristico manejadorDetallarPaqueteTuristico;

    public ConsultaControladorPaqueteTuristico(ManejadorListarPaquetesTuristicos manejadorListarPaquetesTuristicos, ManejadorDetallarPaqueteTuristico manejadorDetallarPaqueteTuristico) {
        this.manejadorListarPaquetesTuristicos = manejadorListarPaquetesTuristicos;
        this.manejadorDetallarPaqueteTuristico = manejadorDetallarPaqueteTuristico;
    }

    @GetMapping
    @ApiOperation(
            value = "Listar paquetes turisticos",
            notes = "Lista todos los paquetes turisticos existentes en el sistema")
    public List<DtoPaqueteTuristico> listar() {
        return this.manejadorListarPaquetesTuristicos.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "obtener por id",
            notes = "Detalla un paquete turistico por id")
    public DtoPaqueteTuristico detallar(Long id) {
        return manejadorDetallarPaqueteTuristico.ejecutar(id);
    }
}
