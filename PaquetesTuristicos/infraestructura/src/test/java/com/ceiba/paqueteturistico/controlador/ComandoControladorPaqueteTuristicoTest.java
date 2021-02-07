package com.ceiba.paqueteturistico.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.paqueteturistico.comando.ComandoPaqueteTuristico;
import com.ceiba.paqueteturistico.servicio.testdatabuilder.ComandoPaqueteTuristicoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPaqueteTuristico.class)
public class ComandoControladorPaqueteTuristicoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPaqueteTuristico paqueteTuristico = new ComandoPaqueteTuristicoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/paquetes-turisticos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paqueteTuristico)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoPaqueteTuristico paqueteTuristico = new ComandoPaqueteTuristicoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/paquetes-turisticos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paqueteTuristico)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/paquetes-turisticos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
