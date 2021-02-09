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
    private String direccionBase;
    @Value("${pais}")
    private String pais;
    @Value("${apikey}")
    private String apiKey;
    @Value("${parampais}")
    private String paramPais;
    @Value("${paramapikey}")
    private String paramApiKey;
    @Value("${paramanio}")
    private String paramAnio;
    @Value("${parammes}")
    private String paramMes;
    @Value("${paramdia}")
    private String paramDia;
    @Value("${concatenadorparam}")
    private String concatenadorParam;

    @Override
    public boolean validarEsFestivo(LocalDate fecha) {
        String path = buildUrl(fecha);
        Object[] response = restTemplate.getForObject(buildUrl(fecha), Object[].class);
        return response != null && response.length > 0;
    }

    private String buildUrl(LocalDate fecha) {
        return direccionBase +
                paramApiKey +
                apiKey +
                concatenadorParam +
                paramPais +
                pais +
                concatenadorParam +
                paramAnio +
                fecha.getYear() +
                concatenadorParam +
                paramMes +
                fecha.getMonthValue() +
                concatenadorParam +
                paramDia +
                fecha.getDayOfMonth();
    }
}
