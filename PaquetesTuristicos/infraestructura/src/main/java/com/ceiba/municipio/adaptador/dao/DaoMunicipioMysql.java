package com.ceiba.municipio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import com.ceiba.municipio.puerto.dao.DaoMunicipio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMunicipioMysql implements DaoMunicipio {

    private static final String NAMESPACE = "municipio";


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value="listar")
    private static String sqlListar;

    public DaoMunicipioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoMunicipio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoMunicipio());
    }
}
