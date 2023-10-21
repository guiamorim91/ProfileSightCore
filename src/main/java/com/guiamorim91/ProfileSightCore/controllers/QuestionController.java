package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.entities.Question;
import com.guiamorim91.ProfileSightCore.services.QuestionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Question", description = "Questionário para identificação do perfil.")
@RestController
@RequestMapping("api/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public ResponseEntity<List<Question>> findAll() {
        return ResponseEntity.ok(questionService.findAll());
    }
}
