package com.example.desafio_quality.unit.district;

import com.example.desafio_quality.dto.form.DistrictForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class DistrictTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldSaveDistrict() throws Exception {
        DistrictForm districtForm = new DistrictForm("Test Meli", new BigDecimal(100.0));

        String payload = objectMapper.writeValueAsString(districtForm);

        mockMvc.perform(post("/api/district/create")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated());
    }
}
