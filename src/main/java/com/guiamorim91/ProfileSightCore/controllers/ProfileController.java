package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.entities.Profile;
import com.guiamorim91.ProfileSightCore.services.ProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Profile", description = "Tipos de perfil.")
@RestController
@RequestMapping("api/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok(profileService.findAll());
    }
}
