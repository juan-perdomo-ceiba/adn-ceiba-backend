package com.ceiba.paqueteturistico.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.fabrica.FabricaPaqueteTuristico;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.ServicioCrearPaqueteTuristico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaqueteTuristico implements ManejadorComandoRespuesta<ComandoPaqueteTuristico, ComandoRespuesta<Long>> {

    private final FabricaPaqueteTuristico fabricaPaqueteTuristico;
    private final ServicioCrearPaqueteTuristico servicioCrearPaqueteTuristico;

    public ManejadorCrearPaqueteTuristico(FabricaPaqueteTuristico fabricaPaqueteTuristico, ServicioCrearPaqueteTuristico servicioCrearPaqueteTuristico) {
        this.fabricaPaqueteTuristico = fabricaPaqueteTuristico;
        this.servicioCrearPaqueteTuristico = servicioCrearPaqueteTuristico;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPaqueteTuristico comandoPaqueteTuristico) {
        PaqueteTuristico paqueteTuristico = this.fabricaPaqueteTuristico.crear(comandoPaqueteTuristico);
        return new ComandoRespuesta<>(this.servicioCrearPaqueteTuristico.ejecutar(paqueteTuristico));
    }
}
