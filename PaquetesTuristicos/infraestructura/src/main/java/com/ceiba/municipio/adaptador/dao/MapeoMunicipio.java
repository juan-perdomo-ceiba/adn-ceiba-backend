package com.ceiba.municipio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.municipio.modelo.dto.DtoMunicipio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMunicipio implements RowMapper<DtoMunicipio>, MapperResult {

    @Override
    public DtoMunicipio mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String codigo = resultSet.getString("codigo");
        return new DtoMunicipio(id,nombre,codigo);
    }
}
