package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fechaReserva = extraerLocalDate(resultSet, "fecha_reserva");
        String cedulaCliente = resultSet.getString("cedula_cliente");
        String nombreCliente = resultSet.getString( "nombre_cliente");
        String telefonoCliente = resultSet.getString("telefono_cliente");
        String emailCliente = resultSet.getString( "email_cliente");
        int numeroPersonas = resultSet.getInt("numero_personas");
        Long idPaqueteTuristico = resultSet.getLong("id_paquete_turistico");
        String observaciones = resultSet.getString("observaciones");
        String identificadorReserva = resultSet.getString("identificador_reserva");
        BigDecimal precio = resultSet.getBigDecimal("precio");

        return new DtoReserva(
                id,
                fechaReserva,
                cedulaCliente,
                nombreCliente,
                telefonoCliente,
                emailCliente,
                numeroPersonas,
                idPaqueteTuristico,
                observaciones,
                identificadorReserva,
                precio);
    }
}
