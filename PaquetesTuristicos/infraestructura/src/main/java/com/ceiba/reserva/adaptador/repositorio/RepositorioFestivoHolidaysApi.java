package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class RepositorioFestivoHolidaysApi implements RepositorioFestivo {

    private final String DIRECCION_BASE = "https://holidays.abstractapi.com/v1/?";
    private final String PAIS = "CO";
    private final String API_KEY = "5e0e2b64c9964607bac699cc84e42f74";
    private final String PARAM_PAIS = "country=";
    private final String PARAM_API_KEY = "api_key=";
    private final String PARAM_ANIO = "year=";
    private final String PARAM_MES = "month=";
    private final String PARAM_DIA = "day=";
    private final String CONCATENADOR_PARAM = "&";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean validarEsFestivo(LocalDate fecha) {
        Object[] response = restTemplate.getForObject(buildUrl(fecha), Object[].class);
        return response != null && response.length > 0;
    }

    private String buildUrl(LocalDate fecha) {
        return DIRECCION_BASE +
                PARAM_API_KEY +
                API_KEY +
                CONCATENADOR_PARAM +
                PARAM_PAIS +
                PAIS +
                CONCATENADOR_PARAM +
                PARAM_ANIO +
                fecha.getYear() +
                CONCATENADOR_PARAM +
                PARAM_MES +
                fecha.getMonthValue() +
                CONCATENADOR_PARAM +
                PARAM_DIA +
                fecha.getDayOfMonth();
    }
}
