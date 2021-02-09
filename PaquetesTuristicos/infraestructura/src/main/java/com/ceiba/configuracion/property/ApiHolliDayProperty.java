package com.ceiba.configuracion.property;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api-holly-day.properties")
public class ApiHolliDayProperty {
}
