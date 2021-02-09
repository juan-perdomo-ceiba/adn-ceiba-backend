package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class RepositorioFestivoHolidaysApi implements RepositorioFestivo {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${direccionbase}")
    private String DIRECCION_BASE;
    @Value("${pais}")
    private String PAIS;
    @Value("${apikey}")
    private String API_KEY;
    @Value("${parampais}")
    private String PARAM_PAIS;
    @Value("${paramapikey}")
    private String PARAM_API_KEY;
    @Value("${paramanio}")
    private String PARAM_ANIO;
    @Value("${parammes}")
    private String PARAM_MES;
    @Value("${paramdia}")
    private String PARAM_DIA;
    @Value("${concatenadorparam}")
    private String CONCATENADOR_PARAM;

    @Override
    public boolean validarEsFestivo(LocalDate fecha) {
        String path = buildUrl(fecha);
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
