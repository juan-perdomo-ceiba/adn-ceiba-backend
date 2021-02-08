package com.ceiba.configuracion;

import com.ceiba.lugarturistico.puerto.repositorio.RepositorioLugarTuristico;
import com.ceiba.lugarturistico.servicio.ServicioActualizarLugarTuristico;
import com.ceiba.lugarturistico.servicio.ServicioCrearLugarTuristico;
import com.ceiba.lugarturistico.servicio.ServicioEliminarLugarTuristico;
import com.ceiba.paqueteturistico.puerto.repositorio.RepositorioPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.ServicioActualizarPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.ServicioCrearPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.ServicioEliminarPaqueteTuristico;
import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.service.ServicioActualizarReserva;
import com.ceiba.reserva.service.ServicioCrearReserva;
import com.ceiba.reserva.service.ServicioEliminarReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearLugarTuristico servicioCrearLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        return new ServicioCrearLugarTuristico(repositorioLugarTuristico);
    }

    @Bean
    public ServicioActualizarLugarTuristico servicioActualizarLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        return new ServicioActualizarLugarTuristico(repositorioLugarTuristico);
    }

    @Bean
    public ServicioEliminarLugarTuristico servicioEliminarLugarTuristico(RepositorioLugarTuristico repositorioLugarTuristico) {
        return new ServicioEliminarLugarTuristico(repositorioLugarTuristico);
    }

    @Bean
    public ServicioCrearPaqueteTuristico servicioCrearPaqueteTuristico(RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        return new ServicioCrearPaqueteTuristico(repositorioPaqueteTuristico);
    }

    @Bean
    public ServicioActualizarPaqueteTuristico servicioActualizarPaqueteTuristico(RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        return new ServicioActualizarPaqueteTuristico(repositorioPaqueteTuristico);
    }

    @Bean
    public ServicioEliminarPaqueteTuristico servicioEliminarPaqueteTuristico(RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        return new ServicioEliminarPaqueteTuristico(repositorioPaqueteTuristico);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, RepositorioFestivo repositorioFestivo, RepositorioPaqueteTuristico repositorioPaqueteTuristico) {
        return new ServicioCrearReserva(repositorioReserva, repositorioFestivo, repositorioPaqueteTuristico);
    }

    @Bean
    public ServicioActualizarReserva servicioActualizarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioActualizarReserva(repositorioReserva);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }
}
