package com.guiamorim91.ProfileSightCore.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Schema(description = "Ticket de preenchimento do formulário para registrar as respostas.")
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date createdAt;
}
