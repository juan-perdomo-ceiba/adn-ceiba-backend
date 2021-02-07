package com.ceiba.lugarturistico.comando.manejador;

import com.ceiba.lugarturistico.servicio.ServicioEliminarLugarTuristico;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarLugarTuristico implements ManejadorComando<Long> {

    private final ServicioEliminarLugarTuristico servicioEliminarLugarTuristico;

    public ManejadorEliminarLugarTuristico(ServicioEliminarLugarTuristico servicioEliminarLugarTuristico) {
        this.servicioEliminarLugarTuristico = servicioEliminarLugarTuristico;
    }

    public void ejecutar(Long idLugarTuristico) {
        this.servicioEliminarLugarTuristico.ejecutar(idLugarTuristico);
    }
}
