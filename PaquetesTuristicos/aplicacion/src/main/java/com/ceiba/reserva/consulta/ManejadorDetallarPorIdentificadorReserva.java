package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorDetallarPorIdentificadorReserva {

    private final DaoReserva daoReserva;

    public ManejadorDetallarPorIdentificadorReserva(DaoReserva daoReserva){
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(String identificadorReserva){ return this.daoReserva.detallarPorIdentificadorReserva(identificadorReserva); }
}
