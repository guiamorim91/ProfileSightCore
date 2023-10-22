package com.guiamorim91.ProfileSightCore.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Objeto de transferência para model de resposta, com validações de campo obrigatório.")
@Data
public class ResponseDTO {
    @NotNull(message = "O Campo 'pergunta' não pode ser nulo.")
    private Long question;

    @NotNull(message = "O Campo 'resposta' não pode ser nulo.")
    private Long option;
}
