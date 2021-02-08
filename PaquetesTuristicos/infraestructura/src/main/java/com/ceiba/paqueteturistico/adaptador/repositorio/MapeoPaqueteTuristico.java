package com.ceiba.paqueteturistico.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPaqueteTuristico implements RowMapper<PaqueteTuristico>, MapperResult {

    @Override
    public PaqueteTuristico mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        int cantidadMaximaPersonas = resultSet.getInt("cantidad_maxima_personas");
        int cantidadMaximaReservas = resultSet.getInt("cantidad_maxima_reservas");
        BigDecimal precioPorPersona = resultSet.getBigDecimal("precio_por_persona");
        Long idLugarTuristico = resultSet.getLong("id_lugar_turistico");

        return new PaqueteTuristico(id,nombre,descripcion, cantidadMaximaPersonas, cantidadMaximaReservas, precioPorPersona, idLugarTuristico);
    }

}
