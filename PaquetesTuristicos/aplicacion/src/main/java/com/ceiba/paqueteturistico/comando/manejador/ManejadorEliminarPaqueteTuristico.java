package com.ceiba.paqueteturistico.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paqueteturistico.servicio.ServicioEliminarPaqueteTuristico;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPaqueteTuristico implements ManejadorComando<Long> {

    private final ServicioEliminarPaqueteTuristico servicioEliminarPaqueteTuristico;

    public ManejadorEliminarPaqueteTuristico(ServicioEliminarPaqueteTuristico servicioEliminarPaqueteTuristico) {
        this.servicioEliminarPaqueteTuristico = servicioEliminarPaqueteTuristico;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarPaqueteTuristico.ejecutar(idUsuario);
    }
}
