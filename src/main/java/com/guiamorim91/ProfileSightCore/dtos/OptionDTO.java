package com.guiamorim91.ProfileSightCore.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Objeto de transferência para model de opção de resposta.")
@Data
public class OptionDTO {
    private Long Id;

    private String text;
}
