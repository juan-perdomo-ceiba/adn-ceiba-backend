package com.ceiba.lugarturistico.controlador;

import com.ceiba.lugarturistico.consulta.ManejadorListarLugaresTuristicos;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaControladorLugarTuristico implements ConsultaControlador{

    private final ManejadorListarLugaresTuristicos manejadorListarUsuarios;

    public ConsultaControladorLugarTuristico(ManejadorListarLugaresTuristicos manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @Override
    public List<DtoLugarTuristico> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }
}
