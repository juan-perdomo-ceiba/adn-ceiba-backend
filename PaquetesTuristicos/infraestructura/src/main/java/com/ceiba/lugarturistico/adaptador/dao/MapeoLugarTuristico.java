package com.ceiba.lugarturistico.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.lugarturistico.modelo.dto.DtoLugarTuristico;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoLugarTuristico implements RowMapper<DtoLugarTuristico>, MapperResult {

    @Override
    public DtoLugarTuristico mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String descripcion = resultSet.getString("descripcion");
        Long idMunicipio = resultSet.getLong("id_municipio");
        String direccion = resultSet.getString("direccion");
        return new DtoLugarTuristico(id,nombre,descripcion, idMunicipio, direccion);
    }

}
