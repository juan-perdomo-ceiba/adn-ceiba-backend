package com.ceiba.lugarturistico.comando.fabrica;

import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import org.springframework.stereotype.Component;

@Component
public class FabricaLugarTuristico {

    public LugarTuristico crear(ComandoLugarTuristico comandoLugarTuristico) {
        return new LugarTuristico(
                comandoLugarTuristico.getId(),
                comandoLugarTuristico.getNombre(),
                comandoLugarTuristico.getDescripcion(),
                comandoLugarTuristico.getIdMunicipio(),
                comandoLugarTuristico.getDireccion()
        );
    }

}
