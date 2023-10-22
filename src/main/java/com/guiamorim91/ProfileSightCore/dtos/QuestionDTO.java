package com.guiamorim91.ProfileSightCore.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "Objeto de transferência para model de resposta.")
@Data
public class QuestionDTO {
    private Long id;

    private String text;

    private List<OptionDTO> options = new ArrayList<>();
}
