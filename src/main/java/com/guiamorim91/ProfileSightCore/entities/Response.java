package com.guiamorim91.ProfileSightCore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Schema(description = "Resposta da pergunta.")
@Entity
@Data
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    @JsonIgnore
    private Question question;

    @ManyToOne
    private Option option;
}
