package com.ceiba.paqueteturistico.consulta;

import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorDetallarPaqueteTuristico {

    private final DaoPaqueteTurisico daoPaqueteTurisico;

    public ManejadorDetallarPaqueteTuristico(DaoPaqueteTurisico daoPaqueteTurisico){
        this.daoPaqueteTurisico = daoPaqueteTurisico;
    }

    public DtoPaqueteTuristico ejecutar(Long id){ return this.daoPaqueteTurisico.detallar(id); }
}
