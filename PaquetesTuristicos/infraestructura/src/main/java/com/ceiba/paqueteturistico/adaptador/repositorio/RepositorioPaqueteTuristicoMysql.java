package com.ceiba.paqueteturistico.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPaqueteTuristicoMysql implements RepositorioPaqueteTuristico {

    private static final String NAMESPACE = "paqueteturistico";

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

    @SqlStatement(namespace = NAMESPACE, value="detallar")
    private static String sqlDetallar;

    public RepositorioPaqueteTuristicoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PaqueteTuristico paqueteTuristico) {
        return this.customNamedParameterJdbcTemplate.crear(paqueteTuristico, sqlCrear);
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
    public void actualizar(PaqueteTuristico paqueteTuristico) {
        this.customNamedParameterJdbcTemplate.actualizar(paqueteTuristico, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public PaqueteTuristico obtener(Long idPaqueteTuristico) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaqueteTuristico", idPaqueteTuristico);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDetallar, paramSource, new MapeoPaqueteTuristico());
    }
}
