package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoReservaMysql implements DaoReserva {

    private static final String NAMESPACE = "reserva";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = NAMESPACE, value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = NAMESPACE, value = "detallarPorIdentificador")
    private static String sqlDetallaPorIdentificadorr;

    public DaoReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoReserva());
    }

    @Override
    public DtoReserva detallarPorIdentificadorReserva(String identificadorReserva) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificadorReserva", identificadorReserva);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDetallaPorIdentificadorr, paramSource,new MapeoReserva());
    }
}
