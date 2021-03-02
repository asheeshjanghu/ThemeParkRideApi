package com.asheesh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ThemeParkApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllRides() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getOneRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void addRide() throws Exception {
        String ride = "{ \"id\": 4, \"name\": \"AmarJhoola\", \"fare\": 50, \"description\": \"Sabse mast jhoola\" }";
        mockMvc.perform(MockMvcRequestBuilders.post("/ride")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ride)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}