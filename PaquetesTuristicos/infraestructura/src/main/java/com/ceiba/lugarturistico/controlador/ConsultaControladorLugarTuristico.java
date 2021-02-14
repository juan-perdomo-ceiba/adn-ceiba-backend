package com.ceiba.lugarturistico.controlador;

import com.ceiba.lugarturistico.consulta.ManejadorDetallarLugarTuristico;
import com.ceiba.lugarturistico.consulta.ManejadorListarLugaresTuristicos;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorLugarTuristico implements ConsultaControlador {

    private final ManejadorListarLugaresTuristicos manejadorListarLugaresTUristicos;
    private final ManejadorDetallarLugarTuristico manejadorDetallarLugarTuristico;

    public ConsultaControladorLugarTuristico(ManejadorListarLugaresTuristicos manejadorListarLugaresTUristicos, ManejadorDetallarLugarTuristico manejadorDetallarLugarTuristico) {
        this.manejadorListarLugaresTUristicos = manejadorListarLugaresTUristicos;
        this.manejadorDetallarLugarTuristico = manejadorDetallarLugarTuristico;
    }

    @Override
    public List<DtoLugarTuristico> listar() {
        return this.manejadorListarLugaresTUristicos.ejecutar();
    }

    @Override
    public DtoLugarTuristico detallar(Long id) {
        return this.manejadorDetallarLugarTuristico.ejecutar(id);
    }
}
