package com.ceiba.paqueteturistico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.dao.DaoPaqueteTurisico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPaqueteTuristicoMysql implements DaoPaqueteTurisico {

    private static final String NAMESPACE = "paqueteturistico";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = NAMESPACE, value="detallar")
    private static String sqlDetallar;

    public DaoPaqueteTuristicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPaqueteTuristico> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPaqueteTuristico());
    }

    @Override
    public DtoPaqueteTuristico detallar(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListar, mapSqlParameterSource,new MapeoPaqueteTuristico());
    }

}
