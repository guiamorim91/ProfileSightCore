package com.guiamorim91.ProfileSightCore.mappers;

import com.guiamorim91.ProfileSightCore.dtos.QuestionDTO;
import com.guiamorim91.ProfileSightCore.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OptionMapper.class)
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO toDTO(Question question);

    List<QuestionDTO> toDTOList(List<Question> questions);
}
