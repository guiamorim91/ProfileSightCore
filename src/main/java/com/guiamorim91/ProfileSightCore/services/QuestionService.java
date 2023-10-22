package com.guiamorim91.ProfileSightCore.services;

import com.guiamorim91.ProfileSightCore.dtos.QuestionDTO;
import com.guiamorim91.ProfileSightCore.entities.Question;
import com.guiamorim91.ProfileSightCore.mappers.QuestionMapper;
import com.guiamorim91.ProfileSightCore.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<QuestionDTO> findAll() {
        List<Question> questions = questionRepository.findAll();
        return QuestionMapper.INSTANCE.toDTOList(questions);
    }
}
