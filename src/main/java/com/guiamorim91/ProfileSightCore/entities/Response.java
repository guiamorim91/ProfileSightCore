package com.guiamorim91.ProfileSightCore.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Option option;
}
