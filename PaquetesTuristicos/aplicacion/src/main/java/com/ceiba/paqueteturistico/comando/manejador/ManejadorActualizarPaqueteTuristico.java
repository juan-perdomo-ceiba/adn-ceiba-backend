package com.ceiba.paqueteturistico.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.comando.fabrica.FabricaPaqueteTuristico;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.ServicioActualizarPaqueteTuristico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPaqueteTuristico implements ManejadorComando<ComandoPaqueteTuristico> {

    private final FabricaPaqueteTuristico fabricaPaqueteTuristico;
    private final ServicioActualizarPaqueteTuristico servicioActualizarPaqueteTuristico;

    public ManejadorActualizarPaqueteTuristico(FabricaPaqueteTuristico fabricaPaqueteTuristico, ServicioActualizarPaqueteTuristico servicioActualizarPaqueteTuristico) {
        this.fabricaPaqueteTuristico = fabricaPaqueteTuristico;
        this.servicioActualizarPaqueteTuristico = servicioActualizarPaqueteTuristico;
    }

    public void ejecutar(ComandoPaqueteTuristico comandoPaqueteTuristico) {
        PaqueteTuristico paqueteTuristico = this.fabricaPaqueteTuristico.crear(comandoPaqueteTuristico);
        this.servicioActualizarPaqueteTuristico.ejecutar(paqueteTuristico);
    }
}
