package com.guiamorim91.ProfileSightCore.mappers;

import com.guiamorim91.ProfileSightCore.dtos.OptionDTO;
import com.guiamorim91.ProfileSightCore.dtos.QuestionDTO;
import com.guiamorim91.ProfileSightCore.entities.Option;
import com.guiamorim91.ProfileSightCore.entities.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    OptionDTO toDTO(Option option);

    List<OptionDTO> toDTOList(List<Option> options);
}
