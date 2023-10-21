package com.guiamorim91.ProfileSightCore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Profile {
    @Id
    private int Id;

    @Column(length = 200)
    private String description;

    @Column(length = 2000)
    private String text;
}
