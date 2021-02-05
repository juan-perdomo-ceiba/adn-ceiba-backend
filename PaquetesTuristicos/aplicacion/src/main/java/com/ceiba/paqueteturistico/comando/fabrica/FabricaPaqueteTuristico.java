package com.ceiba.paqueteturistico.comando.fabrica;

import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.modelo.entidad.PaqueteTuristico;
import org.springframework.stereotype.Component;

@Component
public class FabricaPaqueteTuristico {

    public PaqueteTuristico crear(ComandoPaqueteTuristico comandoPaqueteTuristico) {
        return new PaqueteTuristico(
                comandoPaqueteTuristico.getId(),
                comandoPaqueteTuristico.getNombre(),
                comandoPaqueteTuristico.getDescripcion(),
                comandoPaqueteTuristico.getFechaReserva(),
                comandoPaqueteTuristico.getCantidadMaximaPersonas(),
                comandoPaqueteTuristico.getCantidadMaximaReservas(),
                comandoPaqueteTuristico.getPrecioPorPersona()
        );
    }

}
