package com.ceiba.lugarturistico.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLugarTuristicoMysql implements RepositorioLugarTuristico {

    private static final String NAMESPACE = "lugarturistico";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = NAMESPACE, value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = NAMESPACE, value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = NAMESPACE, value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace = NAMESPACE, value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioLugarTuristicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(LugarTuristico lugarTuristico) {
        return this.customNamedParameterJdbcTemplate.crear(lugarTuristico, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(LugarTuristico lugarTuristico) {
        this.customNamedParameterJdbcTemplate.actualizar(lugarTuristico, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
