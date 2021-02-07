package com.ceiba.paqueteturistico.consulta;

import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPaquetesTuristicos {

    private final DaoPaqueteTurisico daoPaqueteTurisico;

    public ManejadorListarPaquetesTuristicos(DaoPaqueteTurisico daoPaqueteTurisico){
        this.daoPaqueteTurisico = daoPaqueteTurisico;
    }

    public List<DtoPaqueteTuristico> ejecutar(){ return this.daoPaqueteTurisico.listar(); }
}
