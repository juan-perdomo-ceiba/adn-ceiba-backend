package com.ceiba.configuracion.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:api-holly-day.properties")
public class ApiHolliDayProperty {

    @Autowired
    Environment environment;

    public String getProperty(String property) {
        return  environment.getProperty(property);
    }
}
