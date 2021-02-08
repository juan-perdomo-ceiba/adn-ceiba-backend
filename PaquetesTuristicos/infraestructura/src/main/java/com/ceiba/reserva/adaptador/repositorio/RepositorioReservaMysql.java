package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private static final String NAMESPACE = "reserva";

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

    @SqlStatement(namespace = NAMESPACE, value = "cantidadReservasPorPaqueteTuristico.sql")
    private static String sqlCantidadReservasPorPaqueteTuristico;

    @SqlStatement(namespace = NAMESPACE, value = "cantidadReservasPorPaqueteTuristico.sql")
    private static String sqlCantidadPersonasEnReservasPorPaqueteTuristico;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
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
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public int cantidadReservasPorPaqueteTuristico(Long idPaqueteTuristico) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaqueteTuristico", idPaqueteTuristico);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadReservasPorPaqueteTuristico,paramSource, int.class);
    }

    @Override
    public int cantidadPersonasEnReservasPorPaqueteTuristico(Long idPaqueteTuristico) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaqueteTuristico", idPaqueteTuristico);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadPersonasEnReservasPorPaqueteTuristico,paramSource, int.class);
    }
}
