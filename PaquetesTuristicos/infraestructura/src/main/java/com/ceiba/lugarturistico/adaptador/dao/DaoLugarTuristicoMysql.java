package com.ceiba.lugarturistico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import com.ceiba.lugarturistico.puerto.dao.DaoLugarTuristico;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoLugarTuristicoMysql implements DaoLugarTuristico {

    private static final String NAMESPACE = "lugarturistico";


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value="listar")
    private static String sqlListar;

    public DaoLugarTuristicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLugarTuristico> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoLugarTuristico());
    }
}
