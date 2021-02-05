package com.ceiba.municipio.consulta;
import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import com.ceiba.municipio.puerto.dao.DaoMunicipio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMunicipios {

    private final DaoMunicipio daoMunicipio;

    public ManejadorListarMunicipios(DaoMunicipio daoMunicipio){
        this.daoMunicipio = daoMunicipio;
    }

    public List<DtoMunicipio> ejecutar(){ return this.daoMunicipio.listar(); }
}
