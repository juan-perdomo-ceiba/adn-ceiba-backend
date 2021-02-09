package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.configuracion.property.ApiHolliDayProperty;
import com.ceiba.reserva.puerto.repositorio.RepositorioFestivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class RepositorioFestivoHolidaysApi implements RepositorioFestivo {

    @Autowired
    private ApiHolliDayProperty apiHolliDayProperty;

    @Autowired
    private RestTemplate restTemplate;

    private String DIRECCION_BASE;
    private String PAIS;
    private String API_KEY;
    private String PARAM_PAIS;
    private String PARAM_API_KEY;
    private String PARAM_ANIO;
    private String PARAM_MES;
    private String PARAM_DIA;
    private String CONCATENADOR_PARAM;

    @PostConstruct
    public void loadProperties() {
        this.DIRECCION_BASE = apiHolliDayProperty.getProperty("direccionbase");
        this.PAIS = apiHolliDayProperty.getProperty("pais");
        this.API_KEY = apiHolliDayProperty.getProperty("apikey");
        this.PARAM_PAIS = apiHolliDayProperty.getProperty("parampais");
        this.PARAM_API_KEY = apiHolliDayProperty.getProperty("paramapikey");
        this.PARAM_ANIO = apiHolliDayProperty.getProperty("paramanio");
        this.PARAM_MES = apiHolliDayProperty.getProperty("parammes");
        this.PARAM_DIA = apiHolliDayProperty.getProperty("paramdia");
        this.CONCATENADOR_PARAM = apiHolliDayProperty.getProperty("concatenadorparam");
    }

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
