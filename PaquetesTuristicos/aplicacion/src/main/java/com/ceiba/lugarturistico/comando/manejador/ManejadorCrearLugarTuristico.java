package com.ceiba.lugarturistico.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import com.ceiba.lugarturistico.comando.fabrica.FabricaLugarTuristico;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.servicio.ServicioCrearLugarTuristico;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearLugarTuristico implements ManejadorComandoRespuesta<ComandoLugarTuristico, ComandoRespuesta<Long>> {

    private final FabricaLugarTuristico fabricaLugarTuristico;
    private final ServicioCrearLugarTuristico servicioCrearLugarTuristico;

    public ManejadorCrearLugarTuristico(FabricaLugarTuristico fabricaLugarTuristico, ServicioCrearLugarTuristico servicioCrearLugarTuristico) {
        this.fabricaLugarTuristico = fabricaLugarTuristico;
        this.servicioCrearLugarTuristico = servicioCrearLugarTuristico;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoLugarTuristico comandoLugarTuristico) {
        LugarTuristico lugarTuristico = this.fabricaLugarTuristico.crear(comandoLugarTuristico);
        return new ComandoRespuesta<>(this.servicioCrearLugarTuristico.ejecutar(lugarTuristico));
    }
}
