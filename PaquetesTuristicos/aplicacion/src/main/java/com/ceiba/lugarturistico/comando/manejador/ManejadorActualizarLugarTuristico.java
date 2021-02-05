package com.ceiba.lugarturistico.comando.manejador;

import com.ceiba.lugarturistico.comando.ComandoLugarTuristico;
import com.ceiba.lugarturistico.comando.fabrica.FabricaLugarTuristico;
import com.ceiba.lugarturistico.modelo.entidad.LugarTuristico;
import com.ceiba.lugarturistico.servicio.ServicioActualizarLugarTuristico;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarLugarTuristico implements ManejadorComando<ComandoLugarTuristico> {

    private final FabricaLugarTuristico fabricaLugarTuristico;
    private final ServicioActualizarLugarTuristico servicioActualizarLugarTuristico;

    public ManejadorActualizarLugarTuristico(FabricaLugarTuristico fabricaLugarTuristico, ServicioActualizarLugarTuristico servicioActualizarLugarTuristico) {
        this.fabricaLugarTuristico = fabricaLugarTuristico;
        this.servicioActualizarLugarTuristico = servicioActualizarLugarTuristico;
    }

    public void ejecutar(ComandoLugarTuristico comandoLugarTuristico) {
        LugarTuristico usuario = this.fabricaLugarTuristico.crear(comandoLugarTuristico);
        this.servicioActualizarLugarTuristico.ejecutar(usuario);
    }
}
