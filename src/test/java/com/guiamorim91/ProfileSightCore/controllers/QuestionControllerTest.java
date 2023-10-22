package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.dtos.OptionDTO;
import com.guiamorim91.ProfileSightCore.dtos.QuestionDTO;
import com.guiamorim91.ProfileSightCore.services.QuestionService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        List<QuestionDTO> questions = new java.util.ArrayList<>(List.of());
        for (int i = 0; i <= 10; i++) {
            QuestionDTO question = new QuestionDTO();
            question.setId((long) i++);
            question.setText("question" + i);
            question.getOptions().add(new OptionDTO());

            for (int j = 0; j <= 4; j++) {
                OptionDTO optionDTO = new OptionDTO();

                optionDTO.setId((long) j++);
                optionDTO.setText("option" + j);

                question.getOptions().add(optionDTO);
            }
        }

        Mockito.when(questionService.findAll()).thenReturn(questions);
    }


    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/api/question"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}