package com.ceiba.paqueteturistico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paqueteturistico.modelo.dto.DtoPaqueteTuristico;
import org.springframework.jdbc.core.RowMapper;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoPaqueteTuristico implements RowMapper<DtoPaqueteTuristico>, MapperResult {

    @Override
    public DtoPaqueteTuristico mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        LocalDate fechaReserva = extraerLocalDate(resultSet, "fecha_reserva");
        int cantidadMaximaPersonas = resultSet.getInt("cantidad_maxima_personas");
        int cantidadMaximaReservas = resultSet.getInt("cantidad_maxima_reservas");
        BigDecimal precioPorPersona = resultSet.getBigDecimal("precio_por_persona");

        return new DtoPaqueteTuristico(id,nombre,descripcion,fechaReserva, cantidadMaximaPersonas, cantidadMaximaReservas, precioPorPersona);
    }

}
