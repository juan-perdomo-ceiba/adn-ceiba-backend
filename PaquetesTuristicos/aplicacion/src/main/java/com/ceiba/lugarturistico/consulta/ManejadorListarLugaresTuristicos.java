package com.ceiba.lugarturistico.consulta;

import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import com.ceiba.lugarturistico.puerto.dao.DaoLugarTuristico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarLugaresTuristicos {

    private final DaoLugarTuristico daoLugarTuristico;

    public ManejadorListarLugaresTuristicos(DaoLugarTuristico daoLugarTuristico){
        this.daoLugarTuristico = daoLugarTuristico;
    }

    public List<DtoLugarTuristico> ejecutar(){ return this.daoLugarTuristico.listar(); }
}
