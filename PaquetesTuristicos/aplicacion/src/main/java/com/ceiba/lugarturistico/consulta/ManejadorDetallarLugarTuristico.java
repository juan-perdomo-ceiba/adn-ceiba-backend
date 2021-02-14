package com.ceiba.lugarturistico.consulta;

import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import com.ceiba.lugarturistico.puerto.dao.DaoLugarTuristico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorDetallarLugarTuristico {

    private final DaoLugarTuristico daoLugarTuristico;

    public ManejadorDetallarLugarTuristico(DaoLugarTuristico daoLugarTuristico){
        this.daoLugarTuristico = daoLugarTuristico;
    }

    public DtoLugarTuristico ejecutar(Long id){ return this.daoLugarTuristico.detallar(id); }
}
