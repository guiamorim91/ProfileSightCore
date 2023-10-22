package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.entities.Profile;
import com.guiamorim91.ProfileSightCore.services.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService profileService;

    @BeforeEach
    void setUp() {
        List<Profile> profiles = new java.util.ArrayList<>(List.of());
        for (int i = 0; i <= 4; i++) {
            Profile profile = new Profile();
            profile.setId(i++);
            profile.setDescription("profile" + i);
            profiles.add(profile);
        }

        Mockito.when(profileService.findAll()).thenReturn(profiles);
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/api/profile"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}